# Security Policy

## Supported Versions

This project follows semantic versioning. Security updates are provided for:

| Version | Support Status | End of Life |
|---------|----------------|------------|
| 2.x | ✅ Active | TBD |
| 1.x | ⚠️ Limited | December 2024 |
| < 1.0 | ❌ Unsupported | N/A |

Security patches are released as soon as possible after discovery and verification. Users are encouraged to upgrade to the latest version.

---

## Reporting a Vulnerability

**Do NOT create a public GitHub issue for security vulnerabilities.**

Instead, please report security issues responsibly:

### 1. Email Security Team

Send details to: `security@jwebmp.com` (if available, or maintainer email)

Include:
- Description of the vulnerability
- Affected versions
- Steps to reproduce (if applicable)
- Potential impact
- Suggested fix (if you have one)

### 2. What to Expect

- **Acknowledgment**: Response within 48 hours
- **Assessment**: Evaluation of severity within 1 week
- **Patch**: Security patch released as soon as feasible
- **Disclosure**: Coordinated public disclosure after patch release

We aim for a 30-day disclosure timeline but may extend depending on complexity.

### 3. Confidentiality

- Your identity will be kept confidential if requested
- You may be credited in security advisory if desired

---

## Security Best Practices

### For Users of JWebMP AgGrid

1. **Keep Dependencies Updated**
   ```bash
   mvn versions:display-dependency-updates
   mvn versions:use-latest-releases
   ```

2. **Enable Dependency Check**
   ```bash
   mvn org.owasp:dependency-check-maven:check
   ```

3. **Review Security Advisories**
   - Monitor GitHub security advisories for this project
   - Subscribe to security notifications

4. **Data Validation**
   - Always validate user input on server-side
   - Sanitize data before rendering in grid
   - Use parameterized queries for database access

5. **CSRF Protection**
   - Enable Spring Security CSRF filters
   - Validate CSRF tokens for state-changing operations
   - Use SameSite cookies

6. **XSS Prevention**
   - Sanitize HTML before rendering in cell renderers
   - Use Angular's DomSanitizer for dynamic content
   - Avoid innerHTML; prefer textContent or Angular binding

### For Developers & Contributors

1. **Code Review**
   - All PRs require review before merge
   - Focus on security implications
   - Watch for injection vulnerabilities, unsafe deserialization, etc.

2. **Input Validation**
   ```java
   // BAD: Unsafe user input
   String sql = "SELECT * FROM orders WHERE id = " + userId;
   
   // GOOD: Parameterized query
   String sql = "SELECT * FROM orders WHERE id = ?";
   PreparedStatement ps = connection.prepareStatement(sql);
   ps.setString(1, userId);
   ```

3. **Null Safety**
   Use `@Nullable` and `@NonNull` annotations:
   ```java
   public void processOrder(@NonNull Order order) {
       // Guaranteed non-null
   }
   ```

4. **Dependency Management**
   - Use dependency management via BOM
   - Regularly audit for CVEs
   - Keep transitive dependencies updated
   - Document security implications of new dependencies

5. **Error Handling**
   - Don't expose stack traces to users
   - Log errors securely (sanitize sensitive data)
   - Return generic error messages in APIs

6. **Testing**
   - Include security-focused tests
   - Test with malicious input
   - Verify authentication/authorization
   - Test CSRF/XSS protection

---

## Vulnerability Disclosure

Once a vulnerability is fixed and released:

1. **Security Advisory** posted on GitHub
2. **Release Notes** include security information
3. **Public Disclosure** with CVE if applicable
4. **Notification** to users via:
   - GitHub security alerts
   - Maven Central advisories
   - Release notes

---

## Known Issues

None currently tracked. Check [Security Advisories](https://github.com/JWebMP/JWebMP-AgGrid/security/advisories) for any disclosed vulnerabilities.

---

## Dependencies Security

### Regular Scanning

- **GitHub Dependabot**: Automatic PR creation for vulnerable dependencies
- **OWASP Dependency Check**: Integrated into CI/CD
- **Maven Enforcer**: Blocks build with known vulnerable transitive deps

### Transitive Dependencies

This project includes:

- **jwebmp-core**: Core JWebMP framework
- **jwebmp-angular**: Angular integration
- **guicedee**: Dependency injection
- **junit-jupiter**: Testing framework
- **ag-grid-community**: AG Grid library

All transitive dependencies are managed via BOM for consistency.

---

## Security Considerations for AG Grid Integration

### License Key Security (Enterprise Only)

**Note**: License keys are **only required for AG Grid Enterprise**. The community version (ag-grid-community) does not require a license key.

If using AG Grid Enterprise, follow these practices:

```java
// ❌ BAD: License key in code
window.AG_GRID_LICENSE_KEY = 'xxxx-xxxx-xxxx-xxxx';

// ✅ GOOD: Injected at runtime from environment/secrets (Enterprise only)
@Inject
private SecretsProvider secrets;

@Override
public void configure(Page<?> page) {
    String license = secrets.get("AG_GRID_ENTERPRISE_LICENSE");
    if (license != null) {
        page.add(new Script<>()
            .add("window.AG_GRID_LICENSE_KEY = '" + 
                 JsUtils.escapeJs(license) + "';\n"));
    }
}
```

Best practices:
- Never commit license keys to source control
- Use environment variables or secure vaults
- Inject at runtime via configuration service
- Only apply to enterprise plugin module

### Data Security

- **Server-Side Filtering**: Apply access control on server
- **Pagination**: Don't expose total row count if sensitive
- **Export**: Verify user has permission before Excel export
- **WebSocket**: Validate and authenticate WebSocket connections
- **Real-Time Updates**: Only push data user is authorized to see

### Frontend Security

- **Angular Security**: Use Angular's built-in security features
- **CSP Headers**: Implement Content Security Policy
- **SameSite Cookies**: Prevent CSRF attacks
- **Input Sanitization**: Sanitize before rendering in cells

---

## Compliance

This project aims to comply with:

- **OWASP Top 10**: Common web application vulnerabilities
- **CWE Top 25**: Common Weakness Enumeration
- **Secure Coding Standards**: CERT and MISRA guidelines

---

## Contact

For security concerns, contact the JWebMP team (use responsible disclosure above).

For general questions about security practices, open a [Discussion](https://github.com/JWebMP/JWebMP-AgGrid/discussions).

---

**Last Updated**: December 2, 2025  
**Status**: Active
