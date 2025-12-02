# RULES.md

**Technology Rules & Constraints** — JWebMP AgGrid Plugin v2.0.0-SNAPSHOT

This document defines the technology stack, coding standards, and constraints for the AgGrid plugin. For product intent and architecture decisions, see [PACT.md](./PACT.md).

---

## 1. Language & Build Tooling

### Java Language
- **Version**: **Java 25 LTS** (inherited from parent pom.xml)
- **Reference Rules**: [rules/generative/language/java/java-25.rules.md](./rules/generative/language/java/java-25.rules.md)
- **Requirements**:
  - Use modern Java syntax (records, sealed classes, pattern matching where applicable)
  - Nullness annotations via JSpecify: `@NonNull`, `@Nullable` on public APIs
  - No raw types; use generics throughout
  - Target JDK 25 bytecode (Maven compiler plugin)

### Build System
- **Tool**: Maven 3.8+
- **Reference Rules**: [rules/generative/language/java/build-tooling.md](./rules/generative/language/java/build-tooling.md)
- **Requirements**:
  - POM hierarchy: parent (JWebMP parent) → this plugin
  - Dependency declarations: Use groupId:artifactId:version format only in this file; rely on `jwebmp-bom`, `guicedee-bom`, `fasterxml-bom` for version resolution
  - Artifact coordinates for this plugin: `com.jwebmp.plugins:aggrid:2.0.0-SNAPSHOT`
  - Build plugins:
    - `flatten-maven-plugin` (generates flatter.pom for CI/CD)
    - `maven-compiler-plugin` (target Java 25)
    - `maven-surefire-plugin` (run tests)
    - `jacoco-maven-plugin` (coverage: ≥80% target)

### Dependency Management
```xml
<!-- Import BOMs for consistent transitive deps -->
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>com.guicedee</groupId>
      <artifactId>standalone-bom</artifactId>
      <scope>import</scope>
      <version>${guicedee.version}</version>
    </dependency>
    <dependency>
      <groupId>com.jwebmp</groupId>
      <artifactId>jwebmp-bom</artifactId>
      <scope>import</scope>
      <version>${guicedee.version}</version>
    </dependency>
  </dependencies>
</dependencyManagement>
```

---

## 2. Fluent API Strategy: CRTP

### Rule: Use CRTP (Curiously Recurring Template Pattern)
- **Pattern**: `public abstract class AgGrid<J extends AgGrid<J>> { ... }`
- **Setter Returns**: `public J setHeight(String h) { ... return (J) this; }`
- **Benefits**: Type-safe chaining; subclass fluent methods return subclass type
- **Constraints**:
  - Require explicit `(J) this` casting (annotation: `@SuppressWarnings("unchecked")`)
  - No use of Lombok `@Builder` on grid classes (conflicts with Angular codegen)
  - Manual fluent setters only (not auto-generated)

### Example: Grid Configuration Chain
```java
public class MyGrid extends AgGrid<MyGrid> {
    public MyGrid setHeight(String h) {
        addAttribute("style", "height: " + h + ";");
        return (J) this;  // Type-safe return of MyGrid
    }
}

// Usage:
new MyGrid()
    .setHeight("500px")
    .setTheme("ag-theme-alpine")
    .enableRowSelection("multiple")
    .bindColumnDefs("columnDefs");
```

### Related Document
[rules/generative/backend/fluent-api/crtp.rules.md](./rules/generative/backend/fluent-api/crtp.rules.md)

---

## 3. Backend: GuicedEE & Vert.x Reactive

### Vert.x 5
- **Version**: 5.x (latest stable)
- **Reference Rules**: [rules/generative/backend/vertx/README.md](./rules/generative/backend/vertx/README.md)
- **Requirements**:
  - No blocking calls in handlers; return `Uni<T>` or `Multi<T>`
  - WebSocket handlers inherit from `WebSocketAbstractCallReceiver`
  - Use `IGuicedWebSocket` API for listener registration

### GuicedEE Client
- **Reference Rules**: [rules/generative/backend/guicedee/client/README.md](./rules/generative/backend/guicedee/client/README.md)
- **Requirements**:
  - Dependency injection via `IGuiceContext.get(Class<T>)` (replaces new)
  - Service discovery via SPI (GuicedEE auto-discovers subclasses of `WebSocketAbstractCallReceiver`)
  - `PageConfigurator` pattern for plugin lifecycle hooks

### WebSocket Receivers (Event Handlers)
- **Interface**: Extend `WebSocketAbstractCallReceiver<T>`
- **Method**: `Uni<AjaxResponse<?>> action(AjaxCall<?> call, AjaxResponse<?> response)`
- **Contract**: Receive `AjaxCall` with message director, class, and parameters; return response
- **Example**:
  ```java
  protected static class AgGridFetchDataReceiver extends WebSocketAbstractCallReceiver<...> {
      @Override
      public Uni<AjaxResponse<?>> action(AjaxCall<?> call, AjaxResponse<?> response) {
          // Lookup grid instance from IoC
          var grid = IGuiceContext.get(actionClass);
          // Fetch data (non-blocking)
          var data = grid.fetchData();
          // Wrap and return
          response.addDataResponse(listenerName, data);
          return Uni.createFrom().item(response);
      }
  }
  ```

---

## 4. Frontend: Angular 20 & TypeScript

### Angular Version
- **Version**: 20 (TypeScript)
- **Reference Rules**: [rules/generative/language/angular/angular-20.rules.md](./rules/generative/language/angular/angular-20.rules.md)
- **Requirements**:
  - Modern lifecycle hooks: `ngAfterViewInit`, `ngOnDestroy` (no deprecated hooks)
  - RxJS subscriptions for WebSocket messages (use `Subscription`, cleanup in `ngOnDestroy`)
  - Typed grid API usage: `GridApi`, `GridOptions`, `ColDef` from `ag-grid-community`
  - Module imports via `@NgImportModule`, `@NgImportReference` (JWebMP codegen annotations)

### TypeScript
- **Version**: Latest (from Angular 20)
- **Reference Rules**: [rules/generative/language/typescript/README.md](./rules/generative/language/typescript/README.md)
- **Requirements**:
  - Strict mode enabled in `tsconfig.json`
  - Full type coverage (no implicit `any`)
  - Null checks enabled

### JWebMP Component Integration
- **Reference Rules**: [rules/generative/frontend/jwebmp/README.md](./rules/generative/frontend/jwebmp/README.md), [client/README.md](./rules/generative/frontend/jwebmp/client/README.md)
- **Requirements**:
  - Grid component extends `DivSimple<J>` (HTML div wrapper)
  - Grid implements `INgComponent<J>` (Angular component interface)
  - All cell/header renderers implement `IComponent` or `INgComponent`
  - JWebMP codegen processes annotations to generate Angular class metadata

### AG Grid Integration
- **Grid Library**: AG Grid Community/Enterprise v34.2.0+ (minimum)
- **Reference**: [AG Grid Angular API Documentation](https://www.ag-grid.com/angular-data-grid/grid-api/)
- **Modules Required**:
  - `ClientSideRowModelModule` (for sorting, filtering, pagination)
  - `RowSelectionModule` (for row selection)
  - `ValidationModule` (for validation support)
  - `AgGridAngular` (Angular wrapper for AG Grid)
- **Module Registration**: Via `@NgImportModule` on grid class
- **Community Edition**: Supports full feature set including Grid API, Events, Filtering, Sorting, Row Selection, Export (CSV/Excel), Keyboard Navigation, and more

---

## 5. Code Quality & Testing

### Testing Framework
- **Unit Tests**: JUnit 5 (Jupiter) with Mockito for mocking
- **Integration Tests**: JWebMP test harness (jwebmp-testlib)
- **Coverage Target**: Minimum **80%** (enforced via Jacoco)
- **Code Analysis**: SonarQube (no critical issues, code smells resolved)

### Jacoco Coverage Requirements
```xml
<plugin>
  <groupId>org.jacoco</groupId>
  <artifactId>jacoco-maven-plugin</artifactId>
  <configuration>
    <rules>
      <rule>
        <element>PACKAGE</element>
        <includedRatios>
          <includedRatio>INSTRUCTION</includedRatio>
        </includedRatios>
        <limits>
          <limit>
            <counter>INSTRUCTION</counter>
            <value>COVEREDRATIO</value>
            <minimum>0.80</minimum>
          </limit>
        </limits>
      </rule>
    </rules>
  </configuration>
</plugin>
```

### Test Naming Convention
- `*Test.java` — Unit tests (JUnit 5)
- `*IntegrationTest.java` — Integration tests (Testcontainers, real DB)
- Method names: `given_<precondition>_when_<action>_then_<expectation>()` (BDD style)

### Code Style & Formatting
- **Formatter**: IDE default (IntelliJ IDEA preferred)
- **Line Length**: 120 characters (soft limit; 140 hard limit)
- **Naming**:
  - Classes: `PascalCase` (e.g., `AgGrid`, `AgGridOptions`, `DefaultCellRenderer`)
  - Methods: `camelCase` (e.g., `setHeight`, `bindRowData`, `enablePagination`)
  - Constants: `UPPER_SNAKE_CASE` (e.g., `DEFAULT_PAGE_SIZE = 20`)
- **Documentation**: JavaDoc for all public classes, methods, and fields

---

## 6. Logging

### Logging Implementation
- **Framework**: Log4j2 (via GuicedEE)
- **Annotation**: Lombok `@Log4j2` (if Lombok is selected) or `LoggerFactory.getLogger(Class)`
- **Log Levels**:
  - **DEBUG**: Grid initialization, option application, column setup
  - **INFO**: Component creation, page configurator activation
  - **WARN**: Missing renderers, configuration fallbacks
  - **ERROR**: Failed data fetches, WebSocket disconnects, grid render errors
  - **TRACE**: (Rarely used) detailed WebSocket message dumps

### Example
```java
@Log4j2
public class AgGrid<J extends AgGrid<J>> extends DivSimple<J> {
    @Override
    protected void init() {
        log.debug("Initializing AgGrid with ID: {}", getID());
        log.info("Registering WebSocket listener for grid: {}", getID());
        // ...
    }
}
```

---

## 7. Nullness & Type Safety

### JSpecify Annotations
- **Declarations**: All public APIs must declare nullness
- **Format**:
  ```java
  public @NonNull J setHeight(@Nullable String height) { ... }
  public J bindColumnDefs(@NonNull String variableName) { ... }
  ```
- **Tools**: IDE nullness checking, SonarQube nullness profile

### Optional vs Nullable
- **Optional<T>**: Use for return types (explicit "may be empty")
- **@Nullable**: Use for parameter/field annotations (pragmatic, indicates null is allowed)

---

## 8. Component & Cell Renderer Registration

### Cell Renderer Interface
```java
public interface ICellRenderer<C extends ICellRenderer<C>> extends IComponent<C> {
    // No additional methods; contract defined by IComponent
    // Implementations are Angular components, auto-injected into grid
}
```

### Renderer Registration
- **Mechanism**: JWebMP codegen scans `@NgComponentReference` annotations
- **Requirement**: All cell/header renderers must be referenced on the grid before `init()` is called
- **Pattern**:
  ```java
  public class MyGrid extends AgGrid<MyGrid> {
      @Override
      protected void init() {
          addConfiguration(AnnotationUtils.getNgComponentReference(StatusBadgeRenderer.class));
          // ...
      }
  }
  ```
- **Constraint**: Renderers cannot be swapped dynamically post-init

---

## 9. Documentation & Documentation-as-Code

### Markdown Standards
- **Format**: All docs in Markdown (.md)
- **Diagrams**: Mermaid source (```mermaid blocks) or PlantUML (.puml files)
- **No Images**: Commit diagram source, not rendered PNGs/JPGs
- **Links**: Use relative paths (e.g., `[PACT.md](./PACT.md)`, `[C4](./docs/architecture/c4-context.md)`)

### Documentation Artifacts
- **PACT.md**: Product intent, non-functional requirements, ADRs (root level)
- **RULES.md**: Technology stack rules (root level)
- **GUIDES.md**: How-to examples, common patterns (root level)
- **IMPLEMENTATION.md**: Code layout, module overview, key file pointers (root level)
- **GLOSSARY.md**: Unified terminology; links to topic glossaries in rules repo (root level)
- **Architecture Diagrams**: C4 (L1-L3), sequence, ERD in `docs/architecture/`
- **PROMPT_REFERENCE.md**: AI assistant reference (stacks, glossary, diagrams, checklist) (in docs/)

### Documentation Practices
- **Forward-Only Policy**: Remove deprecated docs when refactoring; update all references
- **Topic-First Glossary**: Link to topic glossaries in rules repo; minimal duplication in root glossary
- **Traceability**: Every architecture decision linked to PACT ADRs; every code pattern linked to RULES/GUIDES

---

## 10. CI/CD & Deployment

### CI/CD Provider
- **Platform**: GitHub Actions
- **Reference Rules**: [rules/generative/platform/ci-cd/providers/github-actions.md](./rules/generative/platform/ci-cd/providers/github-actions.md)
- **Workflows**:
  - Build & Test (Maven compile, test, Jacoco)
  - Coverage Report (upload to SonarQube)
  - Artifact Publish (Maven Central via GitHub Actions)

### Secrets Management
- **Location**: GitHub Secrets (not in repo)
- **Variables**: USERNAME, USER_TOKEN, SONA_USERNAME, SONA_PASSWORD
- **Reference**: [rules/generative/platform/secrets-config/env-variables.md](./rules/generative/platform/secrets-config/env-variables.md)

### Artifact Publishing
```xml
<distributionManagement>
  <repository>
    <id>central</id>
    <url>https://oss.sonatype.org/service/local/staging/deploy/maven2</url>
  </repository>
</distributionManagement>
```

---

## 11. Constraints & Anti-Patterns

### DO NOT
- ❌ Use Lombok `@Builder` on grid classes (incompatible with Angular codegen)
- ❌ Block in WebSocket handlers; always return `Uni<T>` or `Multi<T>`
- ❌ Create mutable static state; use IoC for singletons
- ❌ Hard-code AG Grid module registrations; use `@NgImportModule` annotations
- ❌ Nest grids or use multiple grids per DOM container without isolation
- ❌ Mix versions of AG Grid (e.g., v32 + v33); pick one and stick to it
- ❌ Place project-specific docs inside `rules/` submodule directory
- ❌ Duplicate glossary entries; link to topic glossaries instead

### DO
- ✅ Use CRTP fluent API for grid configuration
- ✅ Implement cell renderers as Angular components (IComponent)
- ✅ Use WebSocket for server-pushed updates (real-time)
- ✅ Validate all grid requests server-side (filter, sort, pagination params)
- ✅ Clean up WebSocket listeners on grid destruction (ngOnDestroy)
- ✅ Write tests first (TDD), aim for ≥80% coverage
- ✅ Document architecture decisions in PACT ADRs
- ✅ Link docs to rules repo topic glossaries (forward-only reference)

---

## 12. Related Documents & Links

- **Product & Intent**: [PACT.md](./PACT.md)
- **How-To Guide**: [GUIDES.md](./GUIDES.md)
- **Code Layout**: [IMPLEMENTATION.md](./IMPLEMENTATION.md)
- **Terminology**: [GLOSSARY.md](./GLOSSARY.md)
- **Architecture**: [docs/architecture/README.md](./docs/architecture/README.md)
- **AI Reference**: [docs/PROMPT_REFERENCE.md](./docs/PROMPT_REFERENCE.md)

---

## Document Metadata

- **Created**: December 2, 2025 (Stage 1)
- **Version**: 1.0
- **Status**: Active
- **Custodian**: JWebMP AgGrid Team
- **Last Review**: December 2025

---

## Enforcement

These rules are enforced via:
1. **Code Review**: PRs checked against this document
2. **Automated Tools**: SonarQube, Jacoco, Maven compiler
3. **IDE Inspection**: IntelliJ IDEA inspections for nullness, style, etc.
4. **CI Pipeline**: Build fails if Jacoco coverage drops below 80% or SonarQube gates fail
