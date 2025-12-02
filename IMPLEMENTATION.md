# IMPLEMENTATION.md

**Code Layout & Module Overview** — JWebMP AgGrid Plugin v2.0.0-SNAPSHOT

This document describes the current module structure, key file locations, and code organization. For how-to guides, see [GUIDES.md](./GUIDES.md); for architecture details, see [docs/architecture/README.md](./docs/architecture/README.md).

---

## Table of Contents

1. [Project Structure](#project-structure)
2. [Core Modules](#core-modules)
3. [Key Classes & Files](#key-classes--files)
4. [Package Overview](#package-overview)
5. [Build & Artifacts](#build--artifacts)
6. [Test Structure](#test-structure)
7. [Resource & Configuration Files](#resource--configuration-files)

---

## Project Structure

```
c:\Java\DevSuite\JWebMP\plugins\aggrid\
│
├── pom.xml                              # Maven POM (defines dependencies, plugins)
├── flatter.pom                          # Flattened POM (for CI/CD)
├── LICENSE                              # Apache 2.0 license
├── README.md                            # Project README (to be expanded)
│
├── .git/                                # Git repository
├── .gitmodules                          # Git submodule config (rules/)
├── .gitignore                           # Git ignore patterns
│
├── rules/                               # Submodule: https://github.com/GuicedEE/ai-rules.git
│                                        # (External; not modified in this repo)
│
├── src/main/
│   ├── java/com/jwebmp/plugins/aggrid/
│   │   ├── AgGrid.java                 # Core grid component (abstract CRTP)
│   │   ├── AgGridPageConfigurator.java # Plugin lifecycle manager
│   │   │
│   │   ├── cellrenderers/
│   │   │   ├── ICellRenderer.java      # Cell renderer contract
│   │   │   ├── DefaultCellRenderer.java # Base renderer impl
│   │   │   └── [Custom renderers]      # User-defined renderers (examples)
│   │   │
│   │   ├── headers/
│   │   │   ├── [Header components]     # Custom header components (examples)
│   │   │
│   │   ├── options/
│   │   │   ├── AgGridColumnDef.java    # Column definition POJO
│   │   │   ├── AgGridOptions.java      # Grid options container
│   │   │   ├── enums/
│   │   │   │   ├── RowSelectionMode.java
│   │   │   │   └── [Other enums]
│   │   │   └── params/
│   │   │       ├── HeaderComponentParams.java
│   │   │       ├── RowSelectionOptions.java
│   │   │       └── [Other parameter objects]
│   │   │
│   │   └── implementations/
│   │       ├── [Service implementations]
│   │
│   └── resources/
│       └── META-INF/
│           └── services/
│               └── [SPI registration files]
│
├── src/test/
│   └── java/com/jwebmp/plugins/aggrid/
│       ├── *Test.java                  # Unit tests
│       └── *IntegrationTest.java       # Integration tests
│
├── target/                              # Maven build artifacts (generated)
│   ├── classes/                         # Compiled .class files
│   ├── test-classes/                    # Compiled test .class files
│   ├── generated-sources/               # Annotation processor output
│   └── maven-archiver/                  # Build metadata
│
└── docs/                                # Project documentation
    ├── PROMPT_REFERENCE.md             # AI assistant reference
    │
    ├── architecture/                   # Architecture diagrams
    │   ├── README.md                   # Architecture overview
    │   ├── c4-context.md              # C4 L1: System Context
    │   ├── c4-container.md            # C4 L2: Container Architecture
    │   ├── c4-component-aggrid.md     # C4 L3: Component Details
    │   ├── sequence-grid-initialization.md  # Sequence diagrams
    │   └── erd-domain.md              # Entity-Relationship Diagram
    │
    └── [legacy topic docs]             # AgGrid-Guide.md, cell-*.txt, etc.
                                        # (To be consolidated into new docs)

├── PACT.md                             # Product & Architecture Contract (root)
├── RULES.md                            # Technology rules & constraints (root)
├── GUIDES.md                           # How-to guide & patterns (root)
├── GUIDES_EXTENSIONS.md                # Extended patterns & migration (root)
├── IMPLEMENTATION.md                   # This file (root)
└── GLOSSARY.md                         # Unified terminology (root)
```

---

## Core Modules

### 1. Grid Component (com.jwebmp.plugins.aggrid)

**File**: `src/main/java/com/jwebmp/plugins/aggrid/AgGrid.java`

**Purpose**: Abstract base class for all AgGrid instances; implements CRTP fluent API and JWebMP component lifecycle.

**Key Methods**:
| Method | Return | Purpose |
|--------|--------|---------|
| `fetchData()` | `Collection<T> & IJsonRepresentation<T>` | Abstract; fetch row data from service |
| `getRowIdFieldName()` | `String` | Abstract; return unique row identifier field |
| `setHeight(String)` | `J` (CRTP) | Set grid height CSS |
| `setWidth(String)` | `J` (CRTP) | Set grid width CSS |
| `setTheme(String)` | `J` (CRTP) | Set AG Grid CSS theme |
| `setOptions(AgGridOptions)` | `J` (CRTP) | Set grid-level options |
| `addColumnDef(AgGridColumnDef)` | `J` (CRTP) | Add column definition |
| `bindRowData(String)` | `J` (CRTP) | Bind to TypeScript rowData variable |
| `bindColumnDefs(String)` | `J` (CRTP) | Bind to TypeScript columnDefs variable |
| `enablePagination()` | `J` (CRTP) | Enable AG Grid pagination |
| `enableRowSelection(String)` | `J` (CRTP) | Enable row selection mode |
| `init()` | `void` | Lifecycle hook; initializes WebSocket listeners, emits Angular attributes |
| `fields()` | `List<String>` | Generate TypeScript field declarations (called by Angular codegen) |
| `methods()` | `List<String>` | Generate TypeScript methods (event handlers, grid API calls) |
| `constructorBody()` | `List<String>` | Generate TypeScript constructor code (WebSocket subscriptions) |

**Annotations** (Process by JWebMP codegen):
- `@NgAfterViewInit` — Emits grid ready signal on component initialization
- `@NgOnDestroy` — Unregisters WebSocket listener on component destruction
- `@NgComponentReference` — Registers cell/header renderer components
- `@NgImportReference` — Imports AG Grid modules (ColDef, GridApi, etc.)
- `@NgImportModule` — Imports AG Grid Angular module
- `@NgField` — Declares TypeScript fields
- `@NgMethod` — Declares TypeScript methods
- `@NgConstructorBody` — Adds code to TypeScript constructor

**Internal Classes**:
- `AgGridFetchDataReceiver` (protected static) — WebSocket message handler; inherits from `WebSocketAbstractCallReceiver`

---

### 2. Grid Options (com.jwebmp.plugins.aggrid.options)

**File**: `src/main/java/com/jwebmp/plugins/aggrid/options/AgGridOptions.java`

**Purpose**: Container for grid-level configuration (columns, row data, pagination, selection mode, etc.).

**Key Properties**:
| Property | Type | Purpose |
|----------|------|---------|
| `columnDefs` | `List<AgGridColumnDef<T>>` | Column definitions |
| `rowData` | `List<Object>` | Initial or fetched row data |
| `rowDataRaw` | `String` | TypeScript expression for dynamic row binding |
| `pagination` | `Boolean` | Enable pagination |
| `paginationPageSize` | `Integer` | Rows per page |
| `rowHeight` | `Integer` | Uniform row height (pixels) |
| `rowSelection` | `RowSelectionOptions` | Selection mode & checkbox visibility |
| `defaultColDef` | `AgGridColumnDef<?>` | Default settings for all columns |
| `enableCellChangeFlash` | `Boolean` | Flash cells when values change |

**Serialization**: `toString()` produces JSON for Angular template binding.

---

### 3. Column Definition (com.jwebmp.plugins.aggrid.options)

**File**: `src/main/java/com/jwebmp/plugins/aggrid/options/AgGridColumnDef.java`

**Purpose**: Represents a single grid column; binds field, header, renderer, and AG Grid configuration.

**Key Properties**:
| Property | Type | Purpose |
|----------|------|---------|
| `field` | `String` | Data property name |
| `headerName` | `String` | Column title |
| `cellRenderer` | `ICellRenderer<?>` | Optional custom cell component |
| `headerComponent` | `IComponent<?>` | Optional custom header component |
| `headerComponentParams` | `HeaderComponentParams` | Header configuration |
| `sortable` | `Boolean` | Allow sorting |
| `filter` | `Boolean` | Show filter control |
| `resizable` | `Boolean` | Allow resizing |
| `width` | `Integer` | Column width (pixels) |
| `hide` | `Boolean` | Hidden column |

**Fluent Methods**: `setSortable()`, `setFilterable()`, `setWidth()`, etc. (return `this` for chaining).

---

### 4. Cell Renderers (com.jwebmp.plugins.aggrid.cellrenderers)

**File**: `src/main/java/com/jwebmp/plugins/aggrid/cellrenderers/ICellRenderer.java`

**Purpose**: Contract for custom cell rendering components.

**Interface**:
```java
public interface ICellRenderer<C extends ICellRenderer<C>> extends IComponent<C> {
    // No additional methods; contract defined by IComponent
}
```

**Base Class**: `DefaultCellRenderer<T>`
- Provides common cell rendering patterns
- Can be extended for custom renderers

**Usage Example**:
```java
public class StatusBadgeRenderer extends DefaultCellRenderer<StatusBadgeRenderer> 
    implements ICellRenderer<StatusBadgeRenderer> {
    // Custom implementation
}
```

---

### 5. Page Configurator (com.jwebmp.plugins.aggrid)

**File**: `src/main/java/com/jwebmp/plugins/aggrid/AgGridPageConfigurator.java`

**Purpose**: Plugin lifecycle manager; GuicedEE SPI-discovered PageConfigurator.

**Key Methods**:
- `setEnabled(boolean)` — Enable/disable plugin globally
- `onPageAdded()` — Hook called when plugin is activated

**Lifecycle**: Auto-discovered by GuicedEE at application startup; no manual registration needed.

---

### 6. Enums & Options (com.jwebmp.plugins.aggrid.options.enums)

**Files**:
- `RowSelectionMode.java` — SINGLE (singleRow) or MULTIPLE

**Purpose**: Type-safe configuration values.

---

### 7. Parameter Objects (com.jwebmp.plugins.aggrid.options.params)

**Files**:
- `RowSelectionOptions.java` — Row selection config (mode, checkboxes)
- `HeaderComponentParams.java` — Header component configuration
- `[Others]` — Additional parameter POJOs

**Purpose**: Encapsulate grid configuration parameters; serialize to JSON.

---

## Key Classes & Files

### Public API Classes (Developers Use These)

| Class | Location | Purpose |
|-------|----------|---------|
| `AgGrid<J>` | `src/main/java/...AgGrid.java` | Base class for grid components |
| `AgGridOptions<T>` | `src/main/java/.../options/AgGridOptions.java` | Grid options container |
| `AgGridColumnDef<T>` | `src/main/java/.../options/AgGridColumnDef.java` | Column definition |
| `ICellRenderer<C>` | `src/main/java/.../cellrenderers/ICellRenderer.java` | Cell renderer contract |
| `DefaultCellRenderer<T>` | `src/main/java/.../cellrenderers/DefaultCellRenderer.java` | Base renderer class |
| `RowSelectionMode` | `src/main/java/.../options/enums/RowSelectionMode.java` | Enum: SINGLE, MULTIPLE |
| `RowSelectionOptions` | `src/main/java/.../options/params/RowSelectionOptions.java` | Selection options |
| `AgGridPageConfigurator` | `src/main/java/.../AgGridPageConfigurator.java` | Plugin lifecycle |

### Internal Implementation Classes (Framework Use)

| Class | Location | Purpose |
|-------|----------|---------|
| `AgGridFetchDataReceiver` | Inner class of `AgGrid` | WebSocket message handler |

---

## Package Overview

### com.jwebmp.plugins.aggrid
- **Location**: `src/main/java/com/jwebmp/plugins/aggrid/`
- **Contents**:
  - `AgGrid.java` — Core grid component
  - `AgGridPageConfigurator.java` — Plugin lifecycle
  - Subpackages: `cellrenderers/`, `headers/`, `options/`, `implementations/`

### com.jwebmp.plugins.aggrid.cellrenderers
- **Location**: `src/main/java/com/jwebmp/plugins/aggrid/cellrenderers/`
- **Contents**:
  - `ICellRenderer.java` — Renderer contract
  - `DefaultCellRenderer.java` — Base implementation
  - Custom renderer examples (user-defined)

### com.jwebmp.plugins.aggrid.headers
- **Location**: `src/main/java/com/jwebmp/plugins/aggrid/headers/`
- **Contents**:
  - Custom header component examples

### com.jwebmp.plugins.aggrid.options
- **Location**: `src/main/java/com/jwebmp/plugins/aggrid/options/`
- **Contents**:
  - `AgGridOptions.java` — Options container
  - `AgGridColumnDef.java` — Column definition
  - Subpackages: `enums/`, `params/`

### com.jwebmp.plugins.aggrid.options.enums
- **Location**: `src/main/java/com/jwebmp/plugins/aggrid/options/enums/`
- **Contents**:
  - `RowSelectionMode.java`
  - Other option enums

### com.jwebmp.plugins.aggrid.options.params
- **Location**: `src/main/java/com/jwebmp/plugins/aggrid/options/params/`
- **Contents**:
  - `RowSelectionOptions.java`
  - `HeaderComponentParams.java`
  - Other parameter POJOs

### com.jwebmp.plugins.aggrid.implementations
- **Location**: `src/main/java/com/jwebmp/plugins/aggrid/implementations/`
- **Contents**:
  - Service implementations, utilities, helper classes

---

## Build & Artifacts

### Maven POM

**File**: `pom.xml`

**Key Sections**:

```xml
<modelVersion>4.0.0</modelVersion>
<parent>
    <groupId>com.jwebmp</groupId>
    <artifactId>parent</artifactId>
    <version>2.0.0-SNAPSHOT</version>
</parent>

<groupId>com.jwebmp.plugins</groupId>
<artifactId>aggrid</artifactId>
<version>2.0.0-SNAPSHOT</version>
<name>AG Grid</name>
<packaging>jar</packaging>

<dependencies>
    <dependency>
        <groupId>com.jwebmp.core</groupId>
        <artifactId>jwebmp-core</artifactId>
    </dependency>
    <dependency>
        <groupId>com.jwebmp.plugins</groupId>
        <artifactId>angular</artifactId>
    </dependency>
    <dependency>
        <groupId>com.jwebmp.core</groupId>
        <artifactId>jwebmp-testlib</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>

<dependencyManagement>
    <!-- Import GuicedEE, JWebMP, Fasterxml BOMs for version resolution -->
</dependencyManagement>

<build>
    <plugins>
        <plugin>
            <groupId>org.codehaus.mojo</groupId>
            <artifactId>flatten-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```

**Artifact Output**: `target/aggrid-2.0.0-SNAPSHOT.jar`

---

## Test Structure

### Test Classes

**Location**: `src/test/java/com/jwebmp/plugins/aggrid/`

**Naming Convention**:
- `*Test.java` — Unit tests (JUnit 5)
- `*IntegrationTest.java` — Integration tests

**Test Framework**:
- JUnit 5 (Jupiter)
- Mockito (mocking)
- JWebMP test harness (jwebmp-testlib)

**Coverage Tool**: Jacoco
- **Target**: ≥80% code coverage
- **Configuration**: `pom.xml` jacoco-maven-plugin

**Running Tests**:
```bash
mvn clean test                    # Unit tests only
mvn clean verify                  # Unit + integration tests
mvn clean test jacoco:report      # Generate coverage report
```

---

## Resource & Configuration Files

### META-INF/services/

**Location**: `src/main/resources/META-INF/services/`

**Files**:
- `com.jwebmp.core.plugins.ComponentInformation` — Component metadata registration
- `com.guicedee.guicedee.services.PackageLocator` — Service provider for GuicedEE discovery

**Purpose**: SPI (Service Provider Interface) registration for auto-discovery by framework.

---

## Extending the Plugin

### Creating a New Grid Subclass

```java
package com.example.demo.grids;

import com.jwebmp.plugins.aggrid.AgGrid;
import com.jwebmp.plugins.aggrid.options.AgGridColumnDef;

public class MyGrid extends AgGrid<MyGrid> {
    
    public MyGrid() {
        setID("myGrid");
        setHeight("600px");
        setTheme("ag-theme-alpine");
        
        // Add columns
        addColumnDef(new AgGridColumnDef<>("id", "ID"));
        addColumnDef(new AgGridColumnDef<>("name", "Name").setSortable(true));
    }
    
    @Override
    public List<MyData> fetchData() {
        // Implement data fetching
        return Collections.emptyList();
    }
    
    @Override
    public String getRowIdFieldName() {
        return "id";
    }
}
```

### Creating a Custom Cell Renderer

```java
package com.example.demo.renderers;

import com.jwebmp.plugins.aggrid.cellrenderers.DefaultCellRenderer;
import com.jwebmp.plugins.aggrid.cellrenderers.ICellRenderer;

public class MyRenderer extends DefaultCellRenderer<MyRenderer> 
    implements ICellRenderer<MyRenderer> {
    // Implement custom rendering logic
}
```

### Registering Renderer with Grid

```java
MyGrid grid = new MyGrid();
MyRenderer renderer = new MyRenderer();

AgGridColumnDef<MyData> col = new AgGridColumnDef<>("status", "Status")
    .setCellRenderer(renderer);

grid.addColumnDef(col);
```

---

## Debugging Tips

### Enable Debug Logging

```
# In log4j2.xml or logback.xml
<Logger name="com.jwebmp.plugins.aggrid" level="DEBUG" />
```

### WebSocket Connection Issues

**Checklist**:
1. Check browser DevTools Network tab for WebSocket connection (ws://...)
2. Verify grid ID is unique
3. Check server logs for `AgGridFetchDataReceiver` messages
4. Verify `fetchData()` returns valid data

### Grid Rendering Issues

**Checklist**:
1. Ensure AG Grid CSS is loaded (`ag-theme-alpine.css`)
2. Check browser console for AG Grid warnings/errors
3. Verify `getRowIdFieldName()` returns existing field in data
4. Verify `columnDefs` map to fields in row data

---

## References

- **PACT** (product intent, NRRs, ADRs): [PACT.md](./PACT.md)
- **RULES** (technology constraints): [RULES.md](./RULES.md)
- **GUIDES** (how-to examples): [GUIDES.md](./GUIDES.md)
- **Architecture**: [docs/architecture/README.md](./docs/architecture/README.md)
- **Glossary**: [GLOSSARY.md](./GLOSSARY.md)

---

## Document Metadata

- **Created**: December 2, 2025 (Stage 1)
- **Version**: 1.0
- **Status**: Active
- **Custodian**: JWebMP AgGrid Team
