# PROMPT_REFERENCE.md

**Codex & AI Assistant Reference** — JWebMP AgGrid Plugin v2.0.0-SNAPSHOT

This document captures the selected stacks, glossary composition, and architecture diagrams for all future prompts acting on this repository.

---

## 🏗️ Selected Stacks & Technology Choices

### Language & Build
- **Java LTS**: 25 (inherits from parent pom.xml)
- **Build Engine**: Maven 3.8+
- **Fluent API Strategy**: CRTP (Curiously Recurring Template Pattern)
- **Logging**: Log4j2 (via GuicedEE)
- **Dependency Management**: Maven BOM (jwebmp-bom, guicedee-bom, fasterxml-bom)

### Backend (JVM)
- **Reactive Stack**: Vert.x 5.x (via GuicedEE)
- **IoC/DI**: GuicedEE (Client modules for WebSocket, persistence bridges)
- **Validation**: JSpecify (nullness annotations)
- **Testing**: JUnit 5, Jacoco (≥80% coverage target)
- **Code Quality**: SonarQube

### Frontend
- **Framework**: Angular 20 (TypeScript)
- **Data Grid**: AG Grid Community/Enterprise (v33+)
- **WebSocket Client**: RxJS Subscriptions (built-in to Angular)
- **HTTP Client**: Angular HttpClient (Angular 20)

### CI/CD & DevOps
- **Source Control**: Git (GitHub)
- **CI/CD Provider**: GitHub Actions (selected)
- **Artifacts**: Maven Central via GitHub Actions workflows
- **Testing in CI**: Maven + Jacoco + SonarQube

### Architecture Patterns
- **Specification-Driven Design** (SDD) — Architecture decisions documented in PACT.md, ADRs
- **Test-Driven Development** (TDD) — Tests written first, code follows
- **Documentation-as-Code** — All diagrams (C4, ERD, Sequence) in Mermaid/PlantUML, version-controlled
- **Micro Frontends** — JWebMP Client enables isolated, deployable grid components
- **Component-Driven Development** — Cell renderers and headers as composable Angular components

---

## 📚 Glossary Composition (Topic-First Precedence)

### Topic Glossaries (Precedence Order)

1. **JWebMP Core & Client Glossary**
   - Path: `rules/generative/frontend/jwebmp/GLOSSARY.md`
   - **Precedence**: Defines "Component", "Page", "Configuration", "JWebMP" core terms
   - Example terms: Component, INgComponent, IComponent, Fluent API, CRTP

2. **AG Grid Glossary** (Custom — this repo)
   - Path: `docs/GLOSSARY.md` (in this repo)
   - **Precedence**: Overrides root for grid-specific terms
   - Example terms: GridOptions, ColumnDef, CellRenderer, RowData, WebSocket Listener

3. **Angular 20 Glossary**
   - Path: `rules/generative/language/angular/angular-20.rules.md`
   - **Precedence**: Defines Angular-specific concepts (ng* annotations, lifecycle, modules)
   - Example terms: NgComponent, NgAfterViewInit, NgOnDestroy, ViewChild, GridApi

4. **Vert.x 5 & Reactive Glossary**
   - Path: `rules/generative/backend/vertx/README.md`
   - **Precedence**: Reactive/async patterns, WebSocket lifecycle
   - Example terms: Uni, Multi, Subscription, WebSocket, Handler

5. **GuicedEE Glossary**
   - Path: `rules/generative/backend/guicedee/GLOSSARY.md`
   - **Precedence**: IoC, dependency injection, service discovery
   - Example terms: IGuiceContext, SPI, WebSocketReceiver, MessageBroker

6. **Java 25 LTS Glossary**
   - Path: `rules/generative/language/java/java-25.rules.md`
   - **Precedence**: Modern Java syntax, records, pattern matching
   - Example terms: Record, SealedClass, Pattern, GenericType

### Glossary Precedence Rules

- **Per-Topic Priority**: When a term appears in multiple topic glossaries, the **most specific topic takes precedence**.
  - Example: "Component" → JWebMP (core) > Angular > General
  - Example: "RowData" → AG Grid (this repo) > JWebMP > General

- **Minimal Duplication**: Root `docs/GLOSSARY.md` links to topic glossaries instead of copying definitions.
  - Exception: Enforced Prompt Language Alignment mappings (see below) are copied into root.

- **Prompt Language Alignment** (copied to root glossary):
  - **CRTP vs Builder routing**: Clarify when CRTP is used (JWebMP/GuicedEE) vs Builder (@Builder Lombok)
  - **Angular version specifics**: Versions 17, 19, 20 have different lifecycle annotations; root glossary clarifies selected version (20)

---

## 🎯 Architecture & Diagrams Reference

### C4 Model Diagrams

All diagrams are Mermaid source code, version-controlled in `docs/architecture/`:

1. **[C4 L1: System Context](./docs/architecture/c4-context.md)**
   - Shows: AgGrid Plugin in JWebMP ecosystem, external services, trust boundaries
   - Key entities: Browser, JWebMP Host, GuicedEE, Vert.x, External APIs
   - Use when: Understanding high-level integration points

2. **[C4 L2: Container Architecture](./docs/architecture/c4-container.md)**
   - Shows: Major containers (Angular Component, AG Grid Lib, WebSocket Client, GridComponent, EventReceiver, DataService)
   - Key interactions: Component lifecycle, WebSocket communication, data flow
   - Use when: Understanding system responsibilities and communication

3. **[C4 L3: Component Architecture](./docs/architecture/c4-component-aggrid.md)**
   - Shows: Detailed AgGrid classes (AgGrid, AgGridOptions, AgGridColumnDef, ICellRenderer, AgGridFetchDataReceiver)
   - Key relationships: Composition (Options contains ColumnDefs), Implementation (CellRenderer implements IComponent)
   - Use when: Deep-diving into grid internals or implementing new cell renderers

### Sequence Diagrams

4. **[Sequence: Grid Initialization](./docs/architecture/sequence-grid-initialization.md)**
   - Shows: Step-by-step flow from Java component creation → browser rendering → WebSocket data fetch
   - Key stages: Server-side component creation, annotation processing, client bootstrap, initial data load
   - Use when: Debugging grid setup or understanding WebSocket lifecycle

5. **[Sequence: Reactive Data Updates](./docs/architecture/sequence-grid-initialization.md#reactive-data-updates-websocket-flow)** (section within above)
   - Shows: Row selection event → server action → fetchData() → WebSocket broadcast → grid re-render
   - Use when: Implementing custom event handlers or data update flows

### Domain Model (ERD)

6. **[Entity-Relationship Diagram](./docs/architecture/erd-domain.md)**
   - Shows: AGGRID, AGGRID_OPTIONS, COLUMN_DEF, CELL_RENDERER, HEADER_COMPONENT, ROW_DATA entities
   - Key relationships: 1:1 (Grid-Options, Options-DefaultColDef), 1:N (Grid-Columns, Grid-Rows)
   - Use when: Understanding data model or designing extensions

---

## 📋 Core Documentation Files

### In This Repository (Docs)
| File | Purpose | Audience |
|------|---------|----------|
| `docs/PACT.md` | Product & Architecture Contract | Architects, PMs, all stakeholders |
| `docs/RULES.md` | Technology rules & constraints | Developers, code reviewers |
| `docs/GUIDES.md` | How-to guides with examples | Developers (primary) |
| `docs/IMPLEMENTATION.md` | Code layout, module pointers | Developers, maintainers |
| `docs/GLOSSARY.md` | Unified terminology (root) | All (reference) |
| `docs/architecture/` | C4, sequence, ERD diagrams | Architects, technical leads |

### In Rules Repository (Linked)
| Path | Purpose | Selection |
|------|---------|-----------|
| `rules/creative/pact.md` | PACT template | (used for docs/PACT.md) |
| `rules/generative/frontend/jwebmp/README.md` | JWebMP core rules | ✅ Selected |
| `rules/generative/frontend/jwebmp/client/README.md` | JWebMP Client rules | ✅ Selected |
| `rules/generative/frontend/jwebmp/typescript/README.md` | JWebMP TypeScript client | ✅ Selected |
| `rules/generative/language/angular/angular-20.rules.md` | Angular 20 rules | ✅ Selected (Angular 20) |
| `rules/generative/language/java/java-25.rules.md` | Java 25 LTS rules | ✅ Selected |
| `rules/generative/language/java/build-tooling.md` | Maven/Gradle rules | ✅ Maven |
| `rules/generative/backend/vertx/README.md` | Vert.x 5 rules | ✅ Selected (via GuicedEE) |
| `rules/generative/backend/guicedee/README.md` | GuicedEE core rules | ✅ Selected |
| `rules/generative/backend/guicedee/client/README.md` | GuicedEE Client rules | ✅ Selected |
| `rules/generative/platform/ci-cd/README.md` | CI/CD framework | ✅ Selected |
| `rules/generative/platform/ci-cd/providers/github-actions.md` | GitHub Actions | ✅ Selected |
| `rules/generative/architecture/tdd/README.md` | Test-Driven Design | ✅ Selected |
| `rules/generative/platform/testing/README.md` | Testing strategy | ✅ Selected (Jacoco, BrowserStack) |

---

## 🔍 Project Structure (Observed)

```
c:\Java\DevSuite\JWebMP\plugins\aggrid\
├── pom.xml                          # Maven POM (parent: jwebmp parent)
├── flatter.pom                      # Flattened POM (for CI/CD)
├── README.md                        # Brief intro (to be expanded)
├── LICENSE                          # Apache 2
├── .git/                            # Git repo
├── .gitmodules                      # Submodule: rules/
├── rules/                           # Submodule: https://github.com/GuicedEE/ai-rules.git
├── src/
│   ├── main/
│   │   ├── java/com/jwebmp/plugins/aggrid/
│   │   │   ├── AgGrid.java         # Core component (CRTP, abstract)
│   │   │   ├── AgGridPageConfigurator.java  # Plugin lifecycle
│   │   │   ├── cellrenderers/      # Custom renderer base classes
│   │   │   ├── headers/            # Header components
│   │   │   ├── implementations/    # Service impls
│   │   │   └── options/            # AgGridOptions, AgGridColumnDef, enums
│   │   └── resources/
│   │       └── META-INF/services/  # SPI registrations
│   └── test/
│       └── java/com/jwebmp/plugins/aggrid/
│           └── [Test classes]
├── target/                         # Build artifacts
└── docs/
    ├── architecture/               # C4, sequence, ERD diagrams (NEW)
    │   ├── README.md
    │   ├── c4-context.md
    │   ├── c4-container.md
    │   ├── c4-component-aggrid.md
    │   ├── sequence-grid-initialization.md
    │   └── erd-domain.md
    ├── PACT.md                    # Product & Architecture Contract (NEW)
    ├── RULES.md                   # Technology rules (NEW)
    ├── GUIDES.md                  # How-to guide (NEW)
    ├── IMPLEMENTATION.md          # Code pointers (NEW)
    ├── GLOSSARY.md                # Terminology root (NEW)
    └── [legacy topic docs]        # AgGrid-Guide.md, cell-*.txt, headers.txt, etc.
```

---

## 🎓 How AI Assistants Should Use This Document

### At Session Start
1. Load this file (PROMPT_REFERENCE.md) to understand:
   - Selected stacks (Java 25, Angular 20, Vert.x 5, AG Grid 33+)
   - Technology rules (CRTP fluent API, WebSocket updates, component-driven)
   - Glossary precedence (JWebMP > AG Grid > Angular > Vert.x > GuicedEE > Java)

2. Acknowledge which MCP servers are active:
   - Mermaid MCP (for diagram generation): `https://mcp.mermaidchart.com/mcp` (HTTP)
   - Others (file search, git, etc.)

3. Pin the [Rules Repository](./rules/) path and reference it for:
   - Language-specific rules (Java 25, Angular 20)
   - Framework rules (Vert.x, GuicedEE)
   - Architecture patterns (TDD, documentation-as-code)

### When Generating Code
- **Fluent API**: Use CRTP pattern; return `(J) this` after setter calls
- **Annotations**: Use `@NgImportReference`, `@NgComponentReference`, `@NgField`, `@NgMethod` from JWebMP codegen
- **WebSocket**: Implement `WebSocketAbstractCallReceiver` and return `Uni<AjaxResponse>`; never block
- **Cell Renderers**: Implement `IComponent` + `ICellRenderer`, annotate with `@NgComponentReference`
- **Logging**: Use Log4j2 via `@Slf4j` or `LoggerFactory.getLogger()` (Lombok optional)
- **Nullness**: Annotate with `@NonNull` (JSpecify) and/or `@Nullable` where applicable

### When Writing Documentation
- **Glossary**: Link to topic glossaries (prefer `rules/` over copying)
- **Diagrams**: Use Mermaid (source code, version-controlled); no PNG/JPG
- **Examples**: Code examples in Markdown fenced blocks with language tag (```java, ```typescript)
- **Links**: Cross-reference to PACT, RULES, GUIDES, IMPLEMENTATION, Architecture diagrams
- **Forward-Only**: Remove deprecated docs; update all references when changing names/structure

### When Reviewing Code
- **CRTP**: Verify setters return `(J) this` with proper type casting
- **Annotations**: Check that component references are complete (`@NgComponentReference`, imports, module registration)
- **Reactive**: Ensure WebSocket actions return `Uni<AjaxResponse>`, no blocking calls
- **Testing**: Aim for ≥80% Jacoco coverage; enforce via SonarQube quality gates
- **Naming**: Verify consistency with GLOSSARY.md (e.g., "CellRenderer", not "Renderer")

---

## 📍 Key File Paths (Quick Reference)

```
# Architecture & Design
docs/architecture/README.md          → All diagram links
docs/PACT.md                         → Product intent, NRRs, ADRs
docs/RULES.md                        → Tech constraints
docs/GUIDES.md                       → How-to examples
docs/IMPLEMENTATION.md               → Code layout, module details
docs/GLOSSARY.md                     → Unified terminology (with topic links)

# Source Code
src/main/java/com/jwebmp/plugins/aggrid/AgGrid.java
src/main/java/com/jwebmp/plugins/aggrid/options/AgGridOptions.java
src/main/java/com/jwebmp/plugins/aggrid/options/AgGridColumnDef.java
src/main/java/com/jwebmp/plugins/aggrid/cellrenderers/ICellRenderer.java
src/main/java/com/jwebmp/plugins/aggrid/AgGridPageConfigurator.java

# Rules Repository (External)
rules/                               # Submodule (GuicedEE/ai-rules)
rules/generative/frontend/jwebmp/
rules/generative/language/angular/angular-20.rules.md
rules/generative/language/java/java-25.rules.md
rules/generative/backend/guicedee/
rules/generative/platform/ci-cd/
```

---

## ✅ Checklist for AI Assistants

- [ ] PROMPT_REFERENCE.md loaded and understood
- [ ] Rules Repository (rules/) linked and available for cross-reference
- [ ] Glossary precedence understood (topic-first, JWebMP > AG Grid > Angular > Vert.x > GuicedEE > Java)
- [ ] C4 architecture diagrams reviewed (L1 context, L2 containers, L3 components)
- [ ] Selected stacks pinned (Java 25, Maven, Angular 20, Vert.x 5, GuicedEE Client, AG Grid Community/Enterprise)
- [ ] CRTP fluent API pattern understood and will be applied
- [ ] WebSocket-based data updates (no polling) understood
- [ ] Component-driven cell renderers (Angular components, not AG Grid config strings) understood
- [ ] TDD & documentation-as-code practices acknowledged
- [ ] MCP servers active (Mermaid for diagrams, file tools for code)

---

## Document Metadata

- **Created**: December 2, 2025 (Stage 1)
- **Version**: 1.0
- **Status**: Active
- **Custodian**: JWebMP AgGrid Team
- **Next Review**: When stacks or architecture patterns change

---

## Contact & Escalation

- **Repository**: https://github.com/JWebMP/AgGrid
- **Issues**: GitHub Issues (PROMPT_ADOPT_EXISTING_PROJECT.md template)
- **Architecture Questions**: Reference PACT.md and ADRs
- **Code Questions**: Reference GUIDES.md and code comments
