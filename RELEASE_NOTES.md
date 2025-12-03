# Release Notes

## Template for Creating Release Notes

Use this format for each release published to Maven Central. Release notes are automatically created by the GitHub Actions CI/CD workflow when you push a version tag.

---

## Version X.Y.Z - Date (e.g., 2025-12-15)

### 🎯 Overview

**A brief 1-2 sentence summary of the release focus.**

Example: "This release adds support for AG Grid v34.2.0 enterprise features including Server-Side Row Model improvements and Integrated Charts enhancements, plus performance optimizations for large datasets."

---

## ✨ New Features

List major new features in this release.

### Server-Side Row Model Enhancements
- Description of enhancement
- Links to documentation or PR

### Integration with AG Grid v34.2.0
- Details of new feature support

---

## 🐛 Bug Fixes

List bug fixes in priority order.

### Critical Fixes
- **#123**: Fixed NPE in grid initialization
- **#124**: Corrected license key validation logic

### Minor Fixes
- **#125**: Improved error message for missing enterprise module

---

## 🔄 Breaking Changes

**IMPORTANT**: Document all breaking changes with migration guidance.

### Removed Features

#### serverSideInfiniteScroll Parameter (AG Grid v34 Breaking Change)
- **What Changed**: The `serverSideInfiniteScroll` parameter has been removed; infinite scrolling is now enabled by default
- **Migration**: No action required for most users. If you were explicitly setting `serverSideInfiniteScroll: false`, use `serverSideInfiniteScroll: { enabled: false }` in `serverSideParams`
- **Reference**: See [enterprise-features.rules.md](enterprise-features.rules.md#breaking-changes-v342)

### Modified APIs

#### GridOptions Parameter Signatures
- Description of change
- Before vs After code examples
- Migration path

---

## 🚀 Performance Improvements

List performance enhancements and benchmarks if available.

- Reduced bundle size by X% (ag-grid-community only)
- Server-Side Row Model now processes Y% faster with Z thousand rows
- Improved change detection in Angular integration

---

## 📚 Documentation Updates

- Updated [enterprise-features.rules.md](enterprise-features.rules.md) with new feature examples
- Added troubleshooting guide for common SSRM issues
- Enhanced CONTRIBUTING.md with development setup

---

## 🔐 Security Updates

### Dependencies Upgraded
- ag-grid v34.2.0 (security patches)
- guicedee v1.X.X (dependency vulnerability fixes)
- jackson v2.17.X (CVE-2025-XXXXX patch)

### OWASP Dependency-Check
- No known vulnerabilities with CVSS > 5.0
- See CI/CD artifacts for full dependency check report

### Recommendations
- Users should upgrade to this release for security patches
- Review [SECURITY.md](SECURITY.md) for best practices

---

## 🔌 Dependency Updates

### Updated Dependencies
```xml
<!-- AG Grid Community v34.2.0 -->
<version>34.2.0</version>

<!-- JWebMP Core v2.0.0 -->
<version>2.0.0</version>

<!-- GuicedEE (latest) -->
<version>1.X.X</version>
```

### Compatibility Matrix
| Component | Version | Status |
|-----------|---------|--------|
| Java | 25 LTS (required) | ✅ Tested |
| AG Grid | 34.2.0+ | ✅ Supported |
| Angular | 20+ | ✅ Compatible |
| Maven | 3.8+ | ✅ Required |
| Node.js | 18+ | ✅ Required |

---

## ⚠️ Known Issues & Limitations

### Known Issues
- **#456**: Excel export fails with very large datasets (>1M rows)
  - Workaround: Use chunked exports via pagination
  - Status: Investigating root cause for next release

### Limitations
- Server-Side Row Model requires Java 21+ for virtual threads
- Integrated Charts (Enterprise) requires license key for production use

---

## 🙏 Contributors

Thank you to everyone who contributed to this release:

- @username1 - Feature name
- @username2 - Bug fix
- @username3 - Documentation

See [commits](https://github.com/JWebMP/JWebMP-AgGrid/commits/v1.0.0) for full changelog.

---

## 📦 Installation

### Maven
```xml
<dependency>
    <groupId>com.jwebmp.plugins</groupId>
    <artifactId>aggrid</artifactId>
    <version>X.Y.Z</version>
</dependency>
```

### Gradle
```gradle
implementation 'com.jwebmp.plugins:aggrid:X.Y.Z'
```

---

## 📋 Changelog

For a complete list of changes, see the [GitHub release page](https://github.com/JWebMP/JWebMP-AgGrid/releases/tag/vX.Y.Z).

<details>
<summary><strong>Full Commit History</strong></summary>

```
commit abc123def456 - feat: add SSRM v2 support
commit def456ghi789 - fix: resolve license key validation NPE
commit ghi789jkl012 - docs: update enterprise features guide
commit jkl012mno345 - refactor: improve module registration
commit mno345pqr678 - test: add comprehensive SSRM tests
```

</details>

---

## 🔗 Links

- **GitHub Release**: https://github.com/JWebMP/JWebMP-AgGrid/releases/tag/vX.Y.Z
- **Maven Central**: https://mvnrepository.com/artifact/com.jwebmp.plugins/aggrid/X.Y.Z
- **Javadoc**: https://www.javadoc.io/doc/com.jwebmp.plugins/aggrid/X.Y.Z
- **Commit Diff**: https://github.com/JWebMP/JWebMP-AgGrid/compare/vA.B.C...vX.Y.Z

---

## 🚀 Next Steps

1. **Review**: Check release notes carefully for breaking changes
2. **Test**: Test the release in your environment before deploying
3. **Upgrade**: Follow migration guides if breaking changes apply
4. **Report**: File issues for any problems encountered

---

**Release Date**: YYYY-MM-DD  
**Released By**: Release automation  
**Status**: ✅ Production Ready

