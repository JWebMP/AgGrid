# AgGrid Plugin - Architecture Overview

This section documents the architecture, design patterns, and key flows of the JWebMP AgGrid plugin using the [C4 Model](https://c4model.com/) and supplementary diagrams.

## Quick Reference

- **[System Context (C4 L1)](./c4-context.md)** — AgGrid Plugin within the JWebMP ecosystem
- **[Container Architecture (C4 L2)](./c4-container.md)** — Plugin components and responsibilities
- **[Component Architecture (C4 L3)](./c4-component-aggrid.md)** — Detailed breakdown of AgGrid core components
- **[Data Flow Sequences](./sequence-grid-initialization.md)** — Key operational flows
- **[Domain Model (ERD)](./erd-domain.md)** — Grid configuration and data binding relationships

## Architecture Principles

1. **Component-Driven**: The plugin wraps AG Grid Angular as a JWebMP component, enabling server-driven grid configuration and client-side event handling.
2. **CRTP Fluent API**: Subclasses of `AgGrid<J>` use CRTP chaining for expressive configuration (Java 25 LTS idiom).
3. **WebSocket Real-Time Updates**: Grids subscribe to server-pushed data via WebSocket listeners (GuicedEE Client integration).
4. **Angular Module Integration**: Automatic `@NgImportReference` annotation processing bridges Java configuration to Angular module imports.
5. **TDD-First Design**: Grid behavior, renderers, and data bindings are specified in code annotations and validated via Jacoco/SonarQube.

## Key Artifacts

- **[PACT.md](../PACT.md)** — Product and Architecture Contract (product intent, non-functional requirements)
- **[RULES.md](../RULES.md)** — Stack-specific rules and constraints
- **[GUIDES.md](../GUIDES.md)** — How to apply rules (concrete examples)
- **[IMPLEMENTATION.md](../IMPLEMENTATION.md)** — Current module layout and code pointers
- **[GLOSSARY.md](../GLOSSARY.md)** — Unified terminology (topic-first precedence)

---

## Bounded Contexts

### 1. Grid Configuration (Options)
- **Scope**: Column definitions, row selection modes, pagination, default styles
- **Owner**: `com.jwebmp.plugins.aggrid.options` package
- **Key Types**: `AgGridOptions`, `AgGridColumnDef`, enums (RowSelectionMode, etc.)
- **Pattern**: Configuration objects serialize to JSON for AG Grid Angular

### 2. Cell Rendering (Components)
- **Scope**: Custom cell renderers that implement `INgComponent` interface
- **Owner**: `com.jwebmp.plugins.aggrid.cellrenderers` package
- **Key Types**: `ICellRenderer`, `DefaultCellRenderer`, header components
- **Pattern**: Renderers are injected as Angular components; JWebMP codegen emits @NgComponentReference annotations

### 3. Grid Event Handling (WebSocket/Ajax)
- **Scope**: Row selection, grid ready, data updates, cell value changes
- **Owner**: `AgGrid` class + `AgGridFetchDataReceiver` (abstract WebSocket receiver)
- **Key Types**: `AjaxCall`, `AjaxResponse`, `IGuicedWebSocket`
- **Pattern**: WebSocket listeners registered per grid ID; server pushes data rows on events

### 4. Layout & Theming
- **Scope**: Grid dimensions, AG Grid CSS themes (ag-theme-alpine, etc.)
- **Owner**: Attributes on the `AgGrid` root element
- **Key Types**: Style bindings, class bindings
- **Pattern**: Chainable methods (setTheme, setHeight, setWidth) modify HTML/CSS attributes

---

## Deployment Context

### Development

- JVM: Java 25 LTS (parent pom inheritance)
- Build: Maven (flattened POMs via flatten-maven-plugin)
- Testing: Jacoco code coverage, JWebMP test harness
- Frontend build: Angular 20 + typescript transpilation (via JWebMP codegen)

### Production

- JWebMP AgGrid runs as a library JAR in the host application
- Host application embeds AG Grid Angular and serves HTML/CSS/JS to browsers
- WebSocket connections are managed by the host's GuicedEE/Vert.x server

---

## Next Steps

1. Review [C4 L1 (Context)](./c4-context.md) and [C4 L2 (Containers)](./c4-container.md)
2. Deep-dive into [Component Architecture](./c4-component-aggrid.md) for domain details
3. Study [Sequence Diagrams](./sequence-grid-initialization.md) for operational flows
4. Cross-reference [IMPLEMENTATION.md](../IMPLEMENTATION.md) for current code layout
