# PACT: JWebMP AgGrid Plugin

**Product and Architecture Contract** for the JWebMP AG Grid Plugin — v2.0.0-SNAPSHOT

---

## Product Intent

The JWebMP AG Grid Plugin provides a **Java-first, server-driven approach to building reactive data grids** for modern web applications. It wraps the industry-standard **AG Grid Community/Enterprise** library, enabling Java developers to:

- Define grid configuration (columns, themes, row selection, pagination) **in Java** using a fluent CRTP API
- Bind real-time data updates via **WebSocket** (GuicedEE/Vert.x)
- Compose **custom cell renderers and headers as Angular components**
- Leverage **TDD and annotation-driven code generation** for type-safe Angular bindings
- Deploy grids in **micro-frontend architectures** (JWebMP client isolation)

### Success Criteria

- ✅ Grids render with AG Grid community features (sorting, filtering, pagination, column ops)
- ✅ Custom cell/header renderers as reusable Angular components
- ✅ Server-pushed data updates via WebSocket without client polling
- ✅ Row selection, event handling, and AJAX callbacks
- ✅ Multi-theme support (ag-theme-alpine, ag-theme-balham, etc.)
- ✅ Declarative configuration via CRTP fluent API (no XML, no magic strings)
- ✅ Full test coverage (Jacoco ≥80%)
- ✅ Production-ready: used in enterprise JWebMP applications

---

## Non-Functional Requirements (NRRs)

### Performance
| Requirement | Target | Measurement |
|-------------|--------|-------------|
| Initial grid load (< 1000 rows) | < 500ms | First interactive paint |
| WebSocket data update latency | < 200ms | Server push → grid render |
| Cell renderer initialization | Parallel | Per-column component injection |
| Memory footprint per grid | < 2MB | Browser heap (empty grid) |

### Reliability
- **99.9% uptime** for grid initialization (no unhandled exceptions during setup)
- **WebSocket resilience**: Auto-reconnect on disconnect, queue updates during outage
- **Graceful degradation**: Grid functional even if WebSocket unavailable (manual refresh)
- **Error logging**: All exceptions logged with context (grid ID, column, row) for debugging

### Scalability
- Support grids with **10,000+ rows** (via pagination or virtual scrolling)
- No memory leaks when grids destroyed (proper cleanup of listeners, subscriptions)
- Concurrent grids per page: **5+ independent grids** without performance degradation
- Real-time updates: **50+ grid updates/second** across cluster

### Security
- **CSRF Protection**: WebSocket receiver validates caller identity
- **Data Validation**: Server-side validation of grid requests (filter, sort, pagination params)
- **XSS Prevention**: Row data sanitized before rendering (Angular template escaping)
- **Access Control**: Grid data filtered by user permissions before fetchData() returns

### Maintainability
- **Code Coverage**: ≥80% unit + integration tests (Jacoco)
- **SonarQube Compliance**: No code smells, critical issues resolved
- **Documentation**: Every public API has JavaDoc; complex flows have diagrams
- **Forward-Only Policy**: Deprecated features removed cleanly; no legacy cruft

---

## Architectural Decisions (ADRs)

### ADR-001: CRTP Fluent API vs Builder Pattern
**Decision**: Use CRTP (Curiously Recurring Template Pattern) fluent setters

**Rationale**:
- **Type Safety**: Enables subclass-specific fluent returns (e.g., `MyGrid.setHeight()` returns `MyGrid`, not `AgGrid`)
- **No Lombok Overhead**: Manual CRTP chaining avoids @Builder annotation conflicts with Angular code generation
- **GuicedEE Precedent**: Consistent with JWebMP core components and GuicedEE fluent APIs
- **Performance**: Zero runtime overhead vs. builder allocations

**Tradeoff**: Requires explicit `(J) this` casting and `@SuppressWarnings("unchecked")` in implementation

---

### ADR-002: WebSocket vs HTTP for Real-Time Updates
**Decision**: Use WebSocket (GuicedEE/Vert.x) for server-pushed data

**Rationale**:
- **Low Latency**: Bidirectional communication without request/response overhead
- **Efficient**: Single TCP connection for multiple concurrent grids
- **Reactive**: Aligns with Vert.x 5 (GuicedEE foundation) non-blocking I/O model
- **Scalability**: Server can broadcast to many grids simultaneously

**Tradeoff**: Requires WebSocket fallback for restrictive network environments (optional HTTP polling)

---

### ADR-003: Cell Renderers as Angular Components (not AG Grid Editors)
**Decision**: Cell renderers implement `IComponent` (JWebMP/Angular component interface), not AG Grid's JS renderer config

**Rationale**:
- **Type Safety**: Java codegen for component references (no string-based "cellRenderer" names)
- **Lifecycle**: Full Angular component lifecycle (OnInit, OnDestroy) vs. AG Grid's stateless renderer
- **Composition**: Renderers can depend on services, pipes, other components
- **Reusability**: Cell renderers can be used outside grid context (buttons, forms, etc.)

**Tradeoff**: Cell renderers bound at grid init time (not dynamically swapped), requires component registry

---

### ADR-004: Pagination (Server-Side) vs Virtual Scrolling
**Decision**: Support **both** via options; default to pagination for simplicity

**Rationale**:
- **Pagination**: Familiar UX; reduces rows in memory; pairs well with server-side filtering
- **Virtual Scrolling**: Better for large result sets; requires lazy-load strategy
- **Plugin Flexibility**: App can choose based on data size and UX requirements

**Implementation**: `AgGridOptions.pagination` boolean; if true, limit rowData size per page

---

### ADR-005: Fluent API Serialization (JSON)
**Decision**: Serialize `AgGridOptions` and `AgGridColumnDef` to JSON for Angular template binding

**Rationale**:
- **Simplicity**: JSON is language-neutral; AG Grid Angular expects objects, not strings
- **Type Mapping**: JSON serializer handles Java → TypeScript type conversion (List → array, etc.)
- **Binding**: `[gridOptions]="gridOptions"` works directly without string concatenation

**Tradeoff**: Circular references or complex objects not serializable (handled by developer)

---

## Core Use Cases

### Use Case 1: CRUD Grid with Custom Status Column
```
1. Developer extends AgGrid, calls fetchData() to query database
2. Developer adds column with StatusBadgeRenderer (custom component)
3. Grid initializes, WebSocket listener registered
4. User selects row; onRowSelectJS() triggers server-side action
5. Server updates status, calls fetchData() again
6. Server broadcasts new rowData via WebSocket
7. Client receives, AG Grid updates grid rows
8. User sees status change in real-time
```

### Use Case 2: Multi-Tab Dashboard with Independent Grids
```
1. Page has 3 grids (Orders, Payments, Disputes)
2. Each grid has unique ID, independent WebSocket listener
3. User switches tabs; only active grid's listener broadcasts updates
4. Performance: Each grid renders independently; no cross-grid interference
```

### Use Case 3: Real-Time Monitoring Dashboard
```
1. Grid shows active transactions, updated every 500ms from server
2. fetchData() queries distributed cache (Redis)
3. Server batches updates, broadcasts via WebSocket to all connected grids
4. 50+ grids receive updates in parallel (Vert.x async)
```

---

## Technology Stack (Selected)

| Layer | Technology | Version | Role |
|-------|-----------|---------|------|
| **Backend** | Java LTS | 25 | Grid configuration, data fetching |
| **IoC** | GuicedEE | ≥2024.12 | Dependency injection, WebSocket receivers |
| **Reactive** | Vert.x | 5.x | HTTP/WebSocket server (GuicedEE base) |
| **Frontend** | Angular | 20 | Grid component host |
| **Data Grid** | AG Grid | Community/Enterprise (v33+) | Grid rendering, API |
| **Build** | Maven | 3.8+ | Artifact assembly, BOM imports |
| **Validation** | JSpecify | Latest | Nullness annotations |
| **Testing** | JUnit 5 + Jacoco | Latest | Unit/integration, coverage |
| **Code Analysis** | SonarQube | Latest | Quality gates |

---

## Constraints & Boundaries

### Constraints
1. **No Sync Wait in WebSocket**: All data fetches must return `Uni<AjaxResponse>` (non-blocking)
2. **Column Limit**: Recommend ≤50 columns per grid (browser rendering perf)
3. **Row Limit**: Pagination or virtual scroll recommended for >10K rows
4. **Renderer Injection**: Cell renderers must be registered before grid init; no dynamic swapping
5. **Single Root**: One grid per DOM container; no nested grids

### Boundaries
- **Grid Container**: `<ag-grid-angular>` element in HTML (parent app responsible)
- **Data Access**: Grid does not own database connection; fetchData() delegates to app's data layer
- **Theming**: Grid follows AG Grid CSS theming; app can override via custom CSS
- **Routing**: Grid lifecycle tied to Angular component lifecycle (destruction on route change)

---

## Success Metrics & KPIs

| Metric | Target | Tool |
|--------|--------|------|
| Code Coverage | ≥80% | Jacoco |
| SonarQube A-Grade | Yes | SonarQube |
| Initial Load Time | <500ms | Browser DevTools |
| WebSocket Latency (p95) | <200ms | Server metrics |
| Page Responsiveness (Cumulative Layout Shift) | <0.1 | Lighthouse |
| Memory Leak Detection | Pass | Chrome DevTools Memory Profile |
| Concurrent Grids (5+) | No regression | Load test |

---

## Roadmap (Future Iterations)

### v2.1 (Next Quarter)
- [ ] Virtual scrolling support (lazy-load rows)
- [ ] Server-side filtering/sorting integration guide
- [ ] Export to CSV/Excel
- [ ] Master-detail row expansion

### v2.2 (Following Quarter)
- [ ] Enterprise AG Grid plugins (charts, tree data, master-slave)
- [ ] Advanced cell editors (combo, date picker)
- [ ] Row grouping and aggregation

### v3.0 (Roadmap)
- [ ] GraphQL integration for data fetching
- [ ] Time-travel debugging for grid state (Redux DevTools)
- [ ] Mobile-responsive grid variants

---

## References

- **Architecture Diagrams**: [docs/architecture/README.md](./docs/architecture/README.md)
- **AG Grid Documentation**: https://www.ag-grid.com/
- **JWebMP Wiki**: https://github.com/JWebMP/JWebMP-AgGrid/wiki
- **Rules Repository**: [rules/](./rules/)

---

## Document Lineage

- **Created**: December 2025 (Stage 1)
- **Last Updated**: December 2025
- **Status**: Active (production plugin)
- **Custodian**: JWebMP AgGrid Team

---

## Approval

- [ ] Product Owner
- [ ] Architecture Lead
- [ ] QA Lead
