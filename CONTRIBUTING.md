# Contributing to JWebMP AgGrid Plugin

Thank you for your interest in contributing! This document provides guidelines for participating in the project.

## Code of Conduct

By participating in this project, you agree to maintain a respectful, inclusive community. Please treat all participants with respect, regardless of experience level or background.

---

## Getting Started

### Prerequisites

- **Java 25 LTS** (required)
- **Maven 3.8+**
- **Git**
- **IDE**: IntelliJ IDEA, Eclipse, or VS Code with Java extensions

### Fork & Clone

```bash
# Fork the repository on GitHub
# https://github.com/JWebMP/JWebMP-AgGrid/fork

# Clone your fork
git clone https://github.com/<your-username>/JWebMP-AgGrid.git
cd JWebMP-AgGrid

# Add upstream remote
git remote add upstream https://github.com/JWebMP/JWebMP-AgGrid.git
```

### Build Locally

```bash
# Install dependencies and build
mvn clean install -DskipTests

# Run tests
mvn test

# Run full verification (tests + code quality)
mvn clean verify
```

---

## Development Workflow

### 1. Create a Feature Branch

Always create a new branch for your work. Branch naming conventions:

- **Feature**: `feature/description-of-feature`
- **Bug Fix**: `fix/description-of-bug`
- **Documentation**: `docs/description-of-docs`
- **Refactor**: `refactor/description-of-refactor`

```bash
git checkout -b feature/my-new-feature
```

### 2. Make Changes

- Keep commits **small and focused**
- Each commit should represent one logical change
- Write clear, descriptive commit messages (see [Commit Message Guidelines](#commit-message-guidelines))

### 3. Test Your Changes

```bash
# Run tests for affected modules
mvn clean test

# Run full verification
mvn clean verify

# Check code coverage (minimum 80% required)
mvn jacoco:report
# Open: target/site/jacoco/index.html
```

### 4. Commit & Push

```bash
# Stage changes
git add .

# Commit with clear message
git commit -m "feat: add server-side row model support"

# Push to your fork
git push origin feature/my-new-feature
```

### 5. Open a Pull Request

1. Go to https://github.com/JWebMP/JWebMP-AgGrid
2. Click "New Pull Request"
3. Select your branch
4. Fill in the PR template:
   - **Title**: Clear, concise description (use semantic commit prefix)
   - **Description**: What changed and why
   - **Related Issues**: Link to any issues (e.g., `Closes #123`)
   - **Testing**: How to verify the changes
5. Submit for review

### 6. Address Review Feedback

- Respond to comments promptly
- Make requested changes in new commits
- Push updates to your branch (PR automatically updates)
- Re-request review after making changes

### 7. Merge & Cleanup

Once approved and CI passes:
- PR will be merged by maintainers
- Your branch will be deleted
- Sync your local fork:

```bash
git checkout main
git pull upstream main
git push origin main
```

---

## Commit Message Guidelines

Follow [Conventional Commits](https://www.conventionalcommits.org/) format:

```
<type>(<scope>): <subject>

<body>

<footer>
```

### Type

- **feat**: New feature
- **fix**: Bug fix
- **docs**: Documentation changes
- **style**: Code style changes (formatting, missing semicolons, etc.)
- **refactor**: Code refactoring without feature/bug changes
- **perf**: Performance improvements
- **test**: Adding or updating tests
- **chore**: Build process, dependencies, tools

### Scope

Affected component (optional but recommended):
- `grid`: Core grid functionality
- `column`: Column definitions and behavior
- `rendering`: Cell/header renderers
- `data-binding`: Data source and fetching
- `enterprise`: Enterprise features
- `testing`: Test infrastructure
- `docs`: Documentation

### Subject

- Use imperative mood ("add" not "adds" or "added")
- Don't capitalize first letter
- No period at end
- Maximum 50 characters

### Body

- Explain *what* and *why*, not *how*
- Wrap at 72 characters
- Separate from subject with blank line
- Include context for complex changes

### Footer

- Reference issues: `Closes #123`
- Reference related PRs: `Related to #456`
- Breaking changes: `BREAKING CHANGE: description`

### Examples

```
feat(data-binding): add server-side row model support

Implement ServerSideRowModel integration with pagination
and lazy-loading of grouped rows. Supports server-side
filtering and sorting via fetchData pattern.

Closes #42
```

```
fix(rendering): correct cell height calculation with custom renderers

The cell height was incorrectly calculated when using custom
Angular component renderers. Now properly accounts for
component padding and margins.

Related to #156
```

---

## Code Standards

### Java Code Style

- **Indentation**: 4 spaces (not tabs)
- **Line length**: Maximum 120 characters
- **Naming**:
  - Classes: PascalCase (e.g., `AgGridColumnDef`)
  - Methods: camelCase (e.g., `fetchData()`)
  - Constants: UPPER_SNAKE_CASE
  - Private fields: camelCase with leading underscore (e.g., `_gridApi`)
- **Access Modifiers**: Always explicit (no package-private without reason)

### CRTP Fluent API Pattern

All configuration classes must follow CRTP pattern:

```java
public class MyConfig<J extends MyConfig<J>> {
    public J setSomething(String value) {
        this.something = value;
        return (J) this;
    }
}

public class MyGridConfig extends MyConfig<MyGridConfig> {
    // Subclass automatically inherits CRTP chaining
}
```

### Null Safety with JSpecify

Use `@Nullable` and `@NonNull` annotations:

```java
import org.jspecify.annotations.Nullable;
import org.jspecify.annotations.NonNull;

public class DataFetcher {
    @NonNull
    public List<Order> getOrders(@NonNull String filter) {
        // Never returns null
    }
    
    @Nullable
    public Order findById(@NonNull String id) {
        // May return null
    }
}
```

### Testing

- Use **JUnit 5** for tests
- Follow **AAA pattern**: Arrange, Act, Assert
- Use **BDD naming**: `should_<action>_when_<condition>`
- Minimum **80% code coverage** (Jacoco enforced)
- Test both happy path and error cases

Example:

```java
@Test
void should_fetch_rows_when_rowModelTypeIsServerSide() {
    // Arrange
    GridOptions opts = new GridOptions()
        .setRowModelType(RowModelType.SERVER_SIDE);
    
    // Act
    GridState state = opts.getGridState();
    
    // Assert
    assertEquals(RowModelType.SERVER_SIDE, state.getRowModelType());
}
```

---

## Documentation

### Code Comments

- Comment *why*, not *what* (code shows what it does)
- Use Javadoc for public APIs:

```java
/**
 * Configures the grid to use server-side row model.
 * 
 * @param rowCount initial row count estimate
 * @return this for method chaining
 * @throws IllegalArgumentException if rowCount < 0
 */
public AgGrid<J> setServerSideRowCount(int rowCount) {
    // implementation
}
```

### Documentation Files

- **README.md**: High-level overview, quick start
- **RULES.md**: Technical standards and patterns
- **GUIDES.md**: How-to guides for common tasks
- **docs/**: Architecture diagrams, detailed specs
- **rules/**: Modular topic-specific documentation

### Forward-Only Policy

Per [RULES.md](./RULES.md):

- Never keep deprecated code; remove it fully
- Always update all references when changing APIs
- Document breaking changes in RELEASE_NOTES.md
- No backward-compatibility stubs or shims

---

## Pull Request Checklist

Before submitting, ensure:

- [ ] Code follows [Java Code Style](#java-code-style)
- [ ] Tests pass: `mvn clean verify`
- [ ] Code coverage maintained at ≥80%: `mvn jacoco:report`
- [ ] Documentation updated (README, GUIDES, GLOSSARY)
- [ ] Commit messages follow [Conventional Commits](#commit-message-guidelines)
- [ ] No breaking changes without discussion (or documented in footer)
- [ ] PR description explains *what* and *why*
- [ ] Related issues/PRs linked in footer

---

## Reporting Issues

Use [GitHub Issues](https://github.com/JWebMP/JWebMP-AgGrid/issues) for bugs and feature requests.

### Bug Reports

Include:
- **Title**: Brief description of the problem
- **Environment**: 
  - Java version
  - Maven version
  - AG Grid version
  - JWebMP version
- **Steps to Reproduce**: Clear steps or code sample
- **Expected Behavior**: What should happen
- **Actual Behavior**: What actually happens
- **Logs/Stack Traces**: Relevant error output
- **Screenshots**: If applicable

### Feature Requests

Include:
- **Title**: Clear, concise feature name
- **Motivation**: Why this feature is needed
- **Proposed Solution**: How it should work
- **Alternatives Considered**: Other approaches explored
- **Example Usage**: Code snippet showing how it would be used

---

## Design & Architecture Questions

For significant changes:

1. **Open an Issue** with label `discussion` describing the proposal
2. **Discuss** with maintainers before starting work
3. **Document** the decision in [PACT.md](./PACT.md) or [RULES.md](./RULES.md)
4. **Implement** with clear commit history

This prevents wasted effort and ensures alignment with project vision.

---

## Release Process

*(Maintainers only)*

### Create a Release

```bash
# Update version in pom.xml
mvn versions:set -DnewVersion=2.1.0

# Update RELEASE_NOTES.md
# Commit and tag
git tag -a v2.1.0 -m "Release v2.1.0"
git push origin v2.1.0
```

CI/CD will:
1. Build and run tests
2. Sign artifacts with GPG
3. Deploy to Maven Central via Sonatype
4. Create GitHub Release

---

## Becoming a Maintainer

Regular contributors with a track record of quality work may be invited to become maintainers. Responsibilities include:

- Reviewing and merging PRs
- Triaging issues
- Creating releases
- Maintaining documentation
- Enforcing code standards

Interested? Open an issue to discuss!

---

## Contact & Support

- **GitHub Issues**: https://github.com/JWebMP/JWebMP-AgGrid/issues
- **Discussions**: https://github.com/JWebMP/JWebMP-AgGrid/discussions
- **Email**: (maintainer contact info if available)

---

## Resources

- [Conventional Commits](https://www.conventionalcommits.org/)
- [Keep a Changelog](https://keepachangelog.com/)
- [GitHub Flow Guide](https://guides.github.com/introduction/flow/)
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [Maven Documentation](https://maven.apache.org/guides/)

---

Thank you for contributing! Your work helps make JWebMP AgGrid better for everyone.
