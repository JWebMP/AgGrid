# GLOSSARY.md

**Unified Terminology Reference** — JWebMP AgGrid Plugin v2.0.0-SNAPSHOT

This glossary provides consistent terminology across this project and links to topic-specific glossaries in the Rules Repository. **Topic glossaries take precedence** over this root glossary for their scope.

---

## Glossary Precedence Policy

1. **Topic Glossaries** (highest precedence for their scope):
   - [JWebMP Core GLOSSARY](./rules/generative/frontend/jwebmp/GLOSSARY.md)
   - [Angular 20 Rules](./rules/generative/language/angular/angular-20.rules.md)
   - [Vert.x Glossary](./rules/generative/backend/vertx/README.md)
   - [GuicedEE Glossary](./rules/generative/backend/guicedee/GLOSSARY.md)
   - [Java 25 LTS Rules](./rules/generative/language/java/java-25.rules.md)

2. **Root GLOSSARY.md** (this file): Links to topic glossaries; copies only enforced Prompt Language Alignment mappings

3. **Project-Specific Terms**: Defined and used only within this repository

**When in doubt**: Check the most specific topic glossary first; if not found, check root glossary.

---

## Core AgGrid Terms

### Grid Component
**Definition**: A Java class that extends `AgGrid<J>` and provides server-driven data grid functionality.

**Synonyms**: Grid, Data Grid, Table Component

**Usage**: "Create a custom grid by extending `AgGrid`."

**Related**:
- See [IMPLEMENTATION.md - Grid Component](./IMPLEMENTATION.md#1-grid-component)
- See [C4 L3 Component Architecture](./docs/architecture/c4-component-aggrid.md)

---

### AgGridOptions
**Definition**: Configuration container for grid-level settings (columns, rows, pagination, selection mode, theming).

**Synonyms**: Grid Configuration, Grid Settings

**Key Properties**:
- `columnDefs` — List of column definitions
- `rowData` — Row data collection
- `pagination` — Enable/disable pagination
- `rowSelection` — Row selection mode (single/multiple)

**Usage**: "Pass `AgGridOptions` to the grid to configure sorting and filtering."

**Related**:
- See [IMPLEMENTATION.md - Grid Options](./IMPLEMENTATION.md#2-grid-options)
- See [ERD - Domain Model](./docs/architecture/erd-domain.md)

---

### AgGridColumnDef
**Definition**: Represents a single grid column; binds field name, header text, cell renderer, and AG Grid configuration (sortable, filterable, resizable, etc.).

**Synonyms**: Column Definition, ColDef

**Key Properties**:
- `field` — Data property name
- `headerName` — Column title
- `cellRenderer` — Optional custom renderer component
- `sortable`, `filter`, `resizable` — Column features

**Usage**: "Create a column definition for the 'status' field with a custom cell renderer."

**Related**:
- See [IMPLEMENTATION.md - Column Definition](./IMPLEMENTATION.md#3-column-definition)
- See [GUIDES.md - Configuring Columns](./GUIDES.md#configuring-columns)

---

### Cell Renderer
**Definition**: An Angular component that renders the content of a grid cell. Implements `IComponent` interface.

**Synonyms**: Renderer, CellComponent, Custom Renderer

**Lifecycle**: Instantiated per cell; lifecycle managed by Angular (OnInit, OnDestroy, etc.).

**Usage**: "Use a custom cell renderer to display status badges or action buttons in each cell."

**Related**:
- See [IMPLEMENTATION.md - Cell Renderers](./IMPLEMENTATION.md#4-cell-renderers)
- See [GUIDES.md - Custom Cell Renderers](./GUIDES.md#custom-cell-renderers)

---

### Row Data
**Definition**: The collection of objects displayed as rows in the grid. Each row is a POJO (Plain Old Java Object).

**Synonyms**: Row Objects, Data Rows, Data Collection

**Properties**:
- Each row is identified by a unique field (specified by `getRowIdFieldName()`)
- Rows are fetched via `fetchData()` method
- Updates pushed via WebSocket in real-time

**Usage**: "Fetch row data from the database and pass it to the grid."

**Related**:
- See [PACT.md - Use Case 1](./PACT.md#use-case-1-crud-grid-with-custom-status-column)
- See [Sequence Diagram - Grid Initialization](./docs/architecture/sequence-grid-initialization.md)

---

### WebSocket Listener
**Definition**: A server-side message handler (`AgGridFetchDataReceiver`) that receives grid data requests from the client and pushes updates back.

**Synonyms**: Message Handler, Event Receiver, Data Receiver

**Registration**: One listener per grid ID; registered in `AgGrid.init()`

**Lifecycle**: Created when grid initializes; destroyed when grid destroyed (ngOnDestroy)

**Usage**: "WebSocket listeners enable real-time grid updates without polling."

**Related**:
- See [PACT.md - ADR-002](./PACT.md#adr-002-websocket-vs-http-for-real-time-updates)
- See [Sequence Diagram - Data Updates](./docs/architecture/sequence-grid-initialization.md#reactive-data-updates-websocket-flow)

---

### Fluent API
**Definition**: A method-chaining pattern that returns `this` (or a subclass) to enable expressive configuration.

**Synonyms**: Method Chaining, Builder Pattern (not Lombok @Builder)

**Pattern**: CRTP (Curiously Recurring Template Pattern)

**Example**:
```java
new MyGrid()
    .setHeight("500px")
    .setTheme("ag-theme-alpine")
    .enablePagination()
    .bindColumnDefs("columnDefs");
```

**Usage**: "Use the fluent API to configure grids with expressive, readable code."

**Related**:
- See [RULES.md - Section 2: Fluent API Strategy](./RULES.md#2-fluent-api-strategy-crtp)
- See [PACT.md - ADR-001](./PACT.md#adr-001-crtp-fluent-api-vs-builder-pattern)

---

### Grid Ready Event
**Definition**: Fired when the grid is initialized in the browser, ready to receive user interaction or data updates.

**Synonyms**: Grid Initialization, Component Ready

**Trigger**: Angular `@NgAfterViewInit` lifecycle hook

**Usage**: "Grid ready event signals to the server to send initial data via WebSocket."

**Related**:
- See [Sequence Diagram - Grid Initialization](./docs/architecture/sequence-grid-initialization.md)
- See [GUIDES.md - Grid Ready Event](./GUIDES.md#grid-ready-event)

---

### Pagination
**Definition**: Server-side or client-side splitting of large row datasets into fixed-size pages.

**Synonyms**: Paging, Page-Based Navigation

**Configuration**:
- `pagination` — Enable/disable
- `paginationPageSize` — Rows per page (e.g., 20)

**Usage**: "Enable pagination to display 20 rows per page in large datasets."

**Related**:
- See [GUIDES.md - Pagination](./GUIDES.md#pagination)
- See [PACT.md - ADR-004](./PACT.md#adr-004-pagination-server-side-vs-virtual-scrolling)

---

### Row Selection
**Definition**: User ability to select one or more rows in the grid via checkboxes or row click.

**Synonyms**: Row Picking, Selection Mode

**Modes**:
- `SINGLE` (singleRow) — Select only one row
- `MULTIPLE` — Select multiple rows (with checkbox support)

**Events**: `RowSelectedEvent` fired when selection changes

**Usage**: "Enable multiple row selection with checkboxes for bulk actions."

**Related**:
- See [GUIDES.md - Row Selection](./GUIDES.md#row-selection)
- See [ERD - Domain Model](./docs/architecture/erd-domain.md)

---

### Theme
**Definition**: CSS theme applied to the grid; controls colors, fonts, borders, etc.

**Synonyms**: Grid Theme, Styling, CSS Class

**Built-in Themes** (AG Grid Community):
- `ag-theme-alpine` — Light, clean design
- `ag-theme-balham` — Material Design-inspired
- `ag-theme-material` — Material 3 design

**Usage**: "Apply the ag-theme-alpine theme to the grid."

**Related**:
- See [GUIDES.md - Styling & Theming](./GUIDES.md#styling--theming)

---

## JWebMP Core Terms (Linked to Rules Repository)

The following terms are defined in the JWebMP Core glossary and should be used consistently:

| Term | Definition Location | Usage Context |
|------|---------------------|----------------|
| **Component** | [JWebMP GLOSSARY](./rules/generative/frontend/jwebmp/GLOSSARY.md) | UI building block; AgGrid is a component |
| **INgComponent** | [JWebMP GLOSSARY](./rules/generative/frontend/jwebmp/GLOSSARY.md) | Interface for Angular-capable components |
| **IComponent** | [JWebMP GLOSSARY](./rules/generative/frontend/jwebmp/GLOSSARY.md) | Base component interface |
| **Fluent API** | [Fluent API Rules](./rules/generative/backend/fluent-api/crtp.rules.md) | Method-chaining configuration pattern |
| **CRTP** | [CRTP Rules](./rules/generative/backend/fluent-api/crtp.rules.md) | Generic programming pattern for type-safe fluent APIs |
| **Page Configurator** | [JWebMP GLOSSARY](./rules/generative/frontend/jwebmp/GLOSSARY.md) | Plugin lifecycle hook |

---

## Angular Terms (Linked to Rules Repository)

The following terms are specific to Angular 20 and should use Angular's definitions:

| Term | Definition Location | Usage Context |
|------|---------------------|----------------|
| **NgComponent** | [Angular 20 Rules](./rules/generative/language/angular/angular-20.rules.md) | Angular component class |
| **@NgAfterViewInit** | [Angular 20 Rules](./rules/generative/language/angular/angular-20.rules.md) | Lifecycle hook after view initialization |
| **@NgOnDestroy** | [Angular 20 Rules](./rules/generative/language/angular/angular-20.rules.md) | Lifecycle hook on component destruction |
| **@ViewChild** | [Angular 20 Rules](./rules/generative/language/angular/angular-20.rules.md) | Decorator to access child component |
| **GridApi** | [AG Grid Documentation](https://www.ag-grid.com/) | AG Grid API for programmatic grid control |
| **GridOptions** | [AG Grid Documentation](https://www.ag-grid.com/) | Configuration object for AG Grid |

---

## Vert.x & Reactive Terms (Linked to Rules Repository)

The following terms relate to reactive programming and Vert.x:

| Term | Definition Location | Usage Context |
|------|---------------------|----------------|
| **Uni<T>** | [Vert.x Rules](./rules/generative/backend/vertx/README.md) | Reactive single value (async/non-blocking) |
| **Multi<T>** | [Vert.x Rules](./rules/generative/backend/vertx/README.md) | Reactive stream of values (async/non-blocking) |
| **WebSocket** | [Vert.x Rules](./rules/generative/backend/vertx/README.md) | Bidirectional persistent connection |
| **Subscription** | [RxJS Documentation](https://rxjs.dev/) | Subscription to reactive stream |
| **Non-Blocking** | [Vert.x Rules](./rules/generative/backend/vertx/README.md) | I/O operation does not block thread; returns Uni/Multi |

---

## GuicedEE Terms (Linked to Rules Repository)

The following terms relate to dependency injection and GuicedEE:

| Term | Definition Location | Usage Context |
|------|---------------------|----------------|
| **IGuiceContext** | [GuicedEE GLOSSARY](./rules/generative/backend/guicedee/GLOSSARY.md) | IoC container; look up instances |
| **SPI** | [GuicedEE GLOSSARY](./rules/generative/backend/guicedee/GLOSSARY.md) | Service Provider Interface; auto-discovery |
| **PageConfigurator** | [GuicedEE GLOSSARY](./rules/generative/backend/guicedee/GLOSSARY.md) | Plugin lifecycle hooks |
| **WebSocketReceiver** | [GuicedEE GLOSSARY](./rules/generative/backend/guicedee/GLOSSARY.md) | Abstract class for WebSocket handlers |

---

## Java Language Terms (Linked to Rules Repository)

The following terms are specific to Java 25 LTS:

| Term | Definition Location | Usage Context |
|------|---------------------|----------------|
| **Record** | [Java 25 Rules](./rules/generative/language/java/java-25.rules.md) | Immutable data carrier class |
| **Pattern Matching** | [Java 25 Rules](./rules/generative/language/java/java-25.rules.md) | Type-safe conditionals (switch expressions) |
| **Sealed Class** | [Java 25 Rules](./rules/generative/language/java/java-25.rules.md) | Class with restricted subclasses |
| **Generics** | [Java 25 Rules](./rules/generative/language/java/java-25.rules.md) | Type parameters (no raw types) |
| **@NonNull / @Nullable** | [Java 25 Rules](./rules/generative/language/java/java-25.rules.md) | JSpecify nullness annotations |

---

## Acronyms & Abbreviations

| Acronym | Expansion | Usage |
|---------|-----------|-------|
| **CRTP** | Curiously Recurring Template Pattern | Generic programming pattern for fluent APIs |
| **POJO** | Plain Old Java Object | Serializable data class |
| **SPI** | Service Provider Interface | Framework auto-discovery mechanism |
| **IoC** | Inversion of Control | Dependency injection container (GuicedEE) |
| **UI** | User Interface | What users see in the browser |
| **WebSocket** | Web Socket Protocol | Bidirectional network connection |
| **HTTP** | HyperText Transfer Protocol | Request-response protocol (contrasted with WebSocket) |
| **AJAX** | Asynchronous JavaScript and XML | Browser-to-server async request |
| **JSON** | JavaScript Object Notation | Data serialization format |
| **RxJS** | Reactive Extensions for JavaScript | Reactive library for Angular subscriptions |
| **CSS** | Cascading Style Sheets | Grid theming and styling |

---

## Prompt Language Alignment (Enforced Mappings)

When prompting AI assistants or describing features, use these terms consistently:

| Concept | Java Term | Angular Term | Usage |
|---------|-----------|--------------|-------|
| **Grid** | `AgGrid` | `ag-grid-angular` | Always use "grid" or "AgGrid" in Java; "ag-grid-angular" in templates |
| **Options** | `AgGridOptions` | `gridOptions` | Container for grid settings |
| **Columns** | `AgGridColumnDef` | `ColDef` | Column definition |
| **Cell Renderer** | `ICellRenderer` | Custom component | Component that renders cell content |
| **Row Selection** | `RowSelectionMode` | `RowSelectionOptions` | User ability to select rows |
| **Theme** | `setTheme(String)` | CSS class | Visual styling |

---

## Deprecated Terms

The following terms are **no longer used** in this project (forward-only policy):

| Term | Replacement | Notes |
|------|-------------|-------|
| (None yet) | - | As features are deprecated, old terms will be listed here |

---

## Related Documents

- **PACT** (Product intent, architecture decisions): [PACT.md](./PACT.md)
- **RULES** (Technology constraints): [RULES.md](./RULES.md)
- **GUIDES** (How-to examples): [GUIDES.md](./GUIDES.md)
- **IMPLEMENTATION** (Code layout): [IMPLEMENTATION.md](./IMPLEMENTATION.md)
- **Architecture**: [docs/architecture/README.md](./docs/architecture/README.md)
- **PROMPT_REFERENCE** (AI assistant reference): [docs/PROMPT_REFERENCE.md](./docs/PROMPT_REFERENCE.md)

---

## How to Update This Glossary

1. **Adding New Terms**: Define in the appropriate section (AgGrid Terms, Topic Terms, or Acronyms)
2. **Linking to Topic Glossaries**: When a term is defined in the Rules Repository, link rather than copy
3. **Enforcing Prompt Language Alignment**: If a term has multiple valid names, document the canonical form in the "Prompt Language Alignment" table
4. **Removing Terms**: Mark as deprecated and move to "Deprecated Terms" section (forward-only policy)

---

## Document Metadata

- **Created**: December 2, 2025 (Stage 1)
- **Version**: 1.0
- **Status**: Active
- **Custodian**: JWebMP AgGrid Team
- **Last Review**: December 2025

---

## Feedback & Suggestions

If you find ambiguities in terminology or need new definitions, please:
1. Open an issue with the term and context
2. Propose a definition or link to the appropriate topic glossary
3. Include where the term should appear (which section)
