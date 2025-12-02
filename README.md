# JWebMP AgGrid Plugin

[![Build Status](https://github.com/JWebMP/JWebMP-AgGrid/actions/workflows/build.yml/badge.svg)](https://github.com/JWebMP/JWebMP-AgGrid/actions)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.jwebmp.plugins/aggrid/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.jwebmp.plugins/aggrid)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](LICENSE)
[![Java Version](https://img.shields.io/badge/Java-25%20LTS-brightgreen.svg)](https://www.oracle.com/java/)

> **A comprehensive Java/JWebMP plugin for [AG Grid](https://www.ag-grid.com/) — a feature-rich data grid library supporting Enterprise features, real-time updates, and reactive patterns.**

---

## 🎯 What is JWebMP AgGrid?

This plugin provides a **server-driven, type-safe, fluent API** for building reactive AG Grid data grids in Java-based applications using the [JWebMP](https://jwebmp.com/) framework.

### Key Features

✅ **Server-Driven Grid Configuration** — Define grids entirely in Java with CRTP fluent API  
✅ **Enterprise Features** — Server-Side Row Model, Pivoting, Row Grouping, Excel Export, Charts  
✅ **Real-Time Updates** — WebSocket integration for live data streaming  
✅ **Type-Safe** — Leverage Java's type system for column definitions and renderers  
✅ **Reactive** — Built on Vert.x 5 and GuicedEE for non-blocking async operations  
✅ **Angular Integration** — Auto-generated Angular components with proper change detection  
✅ **Module-Based** — Opt-in enterprise features reduce bundle size  
✅ **Testing** — JUnit 5 with >80% Jacoco coverage, SonarQube quality gates  

---

## 📋 Quick Start

### Prerequisites

- **Java 25 LTS** (or 21 LTS)
- **Maven 3.8+**
- **Node.js 18+** (for frontend builds)
- **Angular 20+** (auto-integrated via JWebMP)

### Installation

#### 1. Add Maven Dependency

```xml
<dependency>
    <groupId>com.jwebmp.plugins</groupId>
    <artifactId>aggrid</artifactId>
    <version>2.0.0</version>
</dependency>
```

Or use the JWebMP BOM for version alignment:

```xml
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>com.jwebmp</groupId>
            <artifactId>jwebmp-bom</artifactId>
            <version>2.0.0</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
</dependencyManagement>

<dependency>
    <groupId>com.jwebmp.plugins</groupId>
    <artifactId>aggrid</artifactId>
</dependency>
```

#### 2. Create a Simple Grid

```java
import com.jwebmp.plugins.aggrid.AgGrid;
import com.jwebmp.plugins.aggrid.options.AgGridColumnDef;

public class OrderGrid extends AgGrid<OrderGrid> {
    
    public OrderGrid() {
        super();
        setHeight("600px")
            .enablePagination(25)
            .enableRowSelection("multiple");
        
        // Add columns
        addColumn(new AgGridColumnDef()
            .setField("orderId")
            .setHeaderName("Order ID")
            .setWidth(100));
        
        addColumn(new AgGridColumnDef()
            .setField("status")
            .setHeaderName("Status")
            .setCellRenderer(StatusBadgeRenderer.class));
        
        addColumn(new AgGridColumnDef()
            .setField("amount")
            .setHeaderName("Amount")
            .setCellDataType("number"));
    }
    
    // Optional: server-side data fetching
    @DataSource
    public Uni<List<Order>> fetchData(DataSourceRequest request) {
        return orderService.findPage(
            request.getStartRow(),
            request.getEndRow(),
            request.getFilterModel(),
            request.getSortModel()
        );
    }
}
```

#### 3. Add to a Page/Component

```java
@Page
public class OrdersPage extends Div<OrdersPage> {
    
    @Inject
    private OrderGrid orderGrid;
    
    public OrdersPage() {
        super();
        add(orderGrid);
    }
}
```

---

## 🚀 Enterprise Features

AG Grid Enterprise features are fully supported. Enable them via module registration:

### Common Enterprise Use Cases

**Server-Side Row Model** (millions of rows, lazy-loading):
```java
gridOptions.setRowModelType(RowModelType.SERVER_SIDE)
    .setServerSideInitialRowCount(1000);
```

**Row Grouping & Aggregation**:
```java
gridOptions.setRowGroupPanelShow(RowGroupPanelShow.ALWAYS)
    .addRowGroupColumn("region")
    .addValueColumn("revenue");
```

**Excel Export with Styles**:
```java
gridApi.exportDataAsExcel(new ExcelExportParams()
    .setFileName("report.xlsx")
    .setSheetName("Orders"));
```

**Integrated Charts**:
```java
gridApi.createRangeChart(
    new CreateRangeChartParams()
        .setCellRange(new CellRange().setColumns(["date", "revenue"]))
        .setChartType(ChartType.LINE)
);
```

See the [Enterprise Features Guide](./rules/generative/frontend/jwebmp/aggrid/enterprise-features.rules.md) for complete documentation.

---

## 📚 Documentation

### Core Resources

| Resource | Purpose |
|----------|---------|
| **[PACT.md](./PACT.md)** | Product architecture & contract |
| **[RULES.md](./RULES.md)** | Technology rules & standards |
| **[GUIDES.md](./GUIDES.md)** | How-to guides for common tasks |
| **[IMPLEMENTATION.md](./IMPLEMENTATION.md)** | Code structure & module layout |
| **[GLOSSARY.md](./GLOSSARY.md)** | Terminology & LLM alignment |

### Plugin Rules (In `rules/generative/frontend/jwebmp/aggrid/`)

- **[README.md](./rules/generative/frontend/jwebmp/aggrid/README.md)** — Plugin rules index
- **[grid-configuration.rules.md](./rules/generative/frontend/jwebmp/aggrid/grid-configuration.rules.md)** — CRTP fluent API, themes, selection
- **[column-definitions.rules.md](./rules/generative/frontend/jwebmp/aggrid/column-definitions.rules.md)** — Column types, filtering, sorting
- **[data-binding.rules.md](./rules/generative/frontend/jwebmp/aggrid/data-binding.rules.md)** — Server-side data, WebSocket integration
- **[event-handling.rules.md](./rules/generative/frontend/jwebmp/aggrid/event-handling.rules.md)** — Row selection, cell clicks, custom events
- **[enterprise-features.rules.md](./rules/generative/frontend/jwebmp/aggrid/enterprise-features.rules.md)** ⭐ — Complete v34.2.0 enterprise feature reference
- **[testing-strategy.rules.md](./rules/generative/frontend/jwebmp/aggrid/testing-strategy.rules.md)** — JUnit 5, BDD patterns, coverage targets
- **[QUICK_REFERENCE.md](./rules/generative/frontend/jwebmp/aggrid/QUICK_REFERENCE.md)** — Templates & checklists

---

## 🏗️ Architecture

### Technology Stack

- **Backend**: Java 25 LTS, Maven, GuicedEE (IoC), Vert.x 5 (reactive), Hibernate (ORM)
- **Frontend**: Angular 20, TypeScript, AG Grid v34.2.0+
- **Integration**: JWebMP Page Configurators, ServiceLoader SPI
- **Data**: Server-side row model, WebSocket real-time updates, transactions
- **Testing**: JUnit 5, Jacoco (≥80% coverage), SonarQube

### Module Structure

```
src/main/java/com/jwebmp/plugins/aggrid/
├── AgGrid.java                    # Main CRTP component
├── options/                       # Configuration POJOs
├── renderers/                     # ICellRenderer implementations
├── configurators/                 # Page Configurator (auto-discovery)
└── services/                      # Data sources, WebSocket handlers
```

---

## 🧪 Testing

### Run Unit Tests

```bash
mvn clean test
```

### Code Coverage Report

```bash
mvn clean test jacoco:report
# Open: target/site/jacoco/index.html
```

### SonarQube Analysis

```bash
mvn clean verify sonar:sonar \
  -Dsonar.projectKey=JWebMP-AgGrid \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=<token>
```

---

## 🔄 GitHub Actions CI/CD

This repository uses GitHub Actions for continuous integration. Workflows include:

### Build & Test

**Trigger**: `git push` to any branch  
**Actions**:
- Maven clean compile
- Unit tests (JUnit 5)
- Jacoco coverage (≥80% enforcement)
- SonarQube analysis (if enabled)
- Artifact generation

### Publish to Maven Central

**Trigger**: Release tag (e.g., `v2.0.0`)  
**Actions**:
- Maven clean package
- GPG sign artifacts
- Deploy to Sonatype nexus
- Maven Central sync

### Snapshots

**Trigger**: `git push` to `develop` branch  
**Actions**:
- Maven clean deploy
- Publish to Sonatype snapshots
- Available immediately for downstream testing

### Manual Workflow Dispatch

You can trigger builds manually:

```bash
gh workflow run build.yml --ref main
```

---

## 🚢 Deployment

### Maven Central

```xml
<repository>
    <id>central</id>
    <url>https://repo1.maven.org/maven2</url>
</repository>
```

### Sonatype Snapshots (Development)

```xml
<repository>
    <id>sonatype-snapshots</id>
    <url>https://oss.sonatype.org/content/repositories/snapshots</url>
    <snapshots><enabled>true</enabled></snapshots>
</repository>
```

### Build & Install Locally

```bash
mvn clean install -DskipTests
```

---

## 🔐 Security

### Dependency Management

- JWebMP BOM ensures consistent versions across plugins
- Regular dependency updates via Dependabot
- CVE scanning via Maven Enforcer Plugin

### License Compliance

- Apache 2.0 licensed
- All dependencies verified for compatibility
- SBOM (Software Bill of Materials) provided in releases

### Secure Practices

- No secrets in source code
- Environment variables for sensitive config
- GPG-signed releases
- Branch protection on `main`

---

## 🔐 Security

This project takes security seriously. 

**Reporting Security Vulnerabilities**: Do NOT create public GitHub issues for security vulnerabilities. Please see [SECURITY.md](SECURITY.md) for responsible disclosure guidelines.

**Key Security Features**:
- ✅ No hardcoded secrets (community version has no license keys)
- ✅ Environment-based configuration
- ✅ GPG-signed releases  
- ✅ OWASP Dependency-Check in CI/CD
- ✅ GitHub Dependabot enabled
- ✅ SonarQube code quality scanning
- ✅ JSpecify null-safety annotations

For detailed security information, see [SECURITY.md](SECURITY.md).

---

## 🤝 Contributing

Contributions are welcome! Please follow these guidelines:

1. **Fork** the repository
2. **Create a feature branch** (`git checkout -b feature/my-feature`)
3. **Commit with clear messages** (`git commit -m "feat: add new feature"`)
4. **Push to your fork** (`git push origin feature/my-feature`)
5. **Open a Pull Request** with:
   - Description of changes
   - Tests included
   - Documentation updates

### Code Standards

- **Java**: Follow JWebMP conventions (CRTP fluent APIs, proper null safety with JSpecify)
- **Tests**: JUnit 5, ≥80% coverage (Jacoco enforced)
- **Formatting**: Maven Spotless plugin enforced
- **Documentation**: Markdown, forward-only policy (see RULES.md)

### Reporting Issues

Please use [GitHub Issues](https://github.com/JWebMP/JWebMP-AgGrid/issues) with:
- Clear title and description
- Steps to reproduce (if bug)
- Expected vs. actual behavior
- Java/Maven/AG Grid versions

---

## 📊 Project Status

| Aspect | Status |
|--------|--------|
| **Version** | 2.0.0-SNAPSHOT |
| **AG Grid** | v34.2.0+ supported |
| **Java** | 25 LTS (minimum 21 LTS) |
| **Build** | ✅ Passing |
| **Coverage** | ≥80% (Jacoco enforced) |
| **License** | Apache 2.0 |
| **Maintenance** | Active |

---

## 🔗 Links

- **GitHub Repository**: https://github.com/JWebMP/JWebMP-AgGrid
- **Issue Tracker**: https://github.com/JWebMP/JWebMP-AgGrid/issues
- **Release Notes**: [RELEASE_NOTES.md](RELEASE_NOTES.md)
- **Maven Central**: https://mvnrepository.com/artifact/com.jwebmp.plugins/aggrid
- **AG Grid Docs**: https://www.ag-grid.com/
- **JWebMP Home**: https://jwebmp.com/

---

## 📄 License

Licensed under the [Apache License 2.0](LICENSE).

```
Copyright 2025 JWebMP Contributors

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

---

## 🙏 Acknowledgments

- **[AG Grid](https://www.ag-grid.com/)** — Enterprise data grid library
- **[JWebMP](https://jwebmp.com/)** — Server-driven web framework
- **[GuicedEE](https://github.com/GedMarc/GuicedEE)** — Dependency injection framework
- **[Vert.x](https://vertx.io/)** — Reactive runtime

---

## 📞 Support

### For JWebMP-Specific Issues

- **GitHub Issues**: https://github.com/JWebMP/JWebMP-AgGrid/issues
- **Discussions**: https://github.com/JWebMP/JWebMP-AgGrid/discussions
- **Documentation**: See [rules/](./rules/) and [docs/](./docs/)

### For AG Grid Questions

- **Official Docs**: https://www.ag-grid.com/
- **Stack Overflow**: Tag with `ag-grid`
- **AG Grid Forum**: https://www.ag-grid.com/support/

### For JWebMP Framework Questions

- **JWebMP Docs**: https://jwebmp.com/
- **JWebMP Issues**: https://github.com/JWebMP/JWebMP/issues

---

**Made with ❤️ by the JWebMP Team**
