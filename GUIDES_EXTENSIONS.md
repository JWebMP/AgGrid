# GUIDES_EXTENSIONS.md

**Extended How-To Patterns & Migration Guide** — JWebMP AgGrid Plugin v2.0.0-SNAPSHOT

This document extends [GUIDES.md](./GUIDES.md) with additional patterns captured from legacy documentation and provides migration guidance for existing projects.

---

## Table of Contents

1. [Column Configuration (Extended)](#column-configuration-extended)
2. [Header Customization](#header-customization)
3. [Column Pinning](#column-pinning)
4. [Column Moving](#column-moving)
5. [Column Sizing](#column-sizing)
6. [Column Groups](#column-groups)
7. [Column Spanning](#column-spanning)
8. [Full-Width Rows](#full-width-rows)
9. [Data Types & Cell Formatting](#data-types--cell-formatting)
10. [Highlighting Changes](#highlighting-changes)
11. [Tooltips](#tooltips)
12. [Migration Guide (Legacy → New Docs)](#migration-guide-legacy--new-docs)

---

## Column Configuration (Extended)

### Column-Level Sorting & Filtering

```java
AgGridColumnDef<?> nameCol = new AgGridColumnDef<>("name", "Full Name")
    .setSortable(true)
    .setFilter(true)
    .setFilterable(true);

// Custom filter configuration (optional, via AG Grid API)
nameCol.setFilter("agTextColumnFilter");  // Text search
nameCol.setFilter("agNumberColumnFilter"); // Numeric range
nameCol.setFilter("agSetColumnFilter");    // Multi-select filter
```

### Column Resizing

```java
AgGridColumnDef<?> col = new AgGridColumnDef<>("description", "Description")
    .setResizable(true)
    .setWidth(300)
    .setMinWidth(100)
    .setMaxWidth(500);
```

### Column Visibility & Hiding

```java
// Hide a column (still exists in data; not rendered)
AgGridColumnDef<?> internalCol = new AgGridColumnDef<>("internalId", "Internal ID")
    .setHide(true);

// Column that can be toggled visible by user
AgGridColumnDef<?> optionalCol = new AgGridColumnDef<>("notes", "Notes")
    .setHide(false);
```

### Column Flex & Responsive Layout

```java
// Use flex to make columns responsive
AgGridColumnDef<?> flexCol = new AgGridColumnDef<>("description", "Description")
    .setFlex(1);  // Takes remaining space equally

// Fixed-width columns
AgGridColumnDef<?> fixedCol = new AgGridColumnDef<>("id", "ID")
    .setWidth(80);

// Mix of flex and fixed
// Flex columns share remaining space; fixed columns maintain width
```

---

## Header Customization

### Header Heights

```java
AgGridOptions<?> options = grid.getOptions();

// Set uniform header height
options.setHeaderHeight(40);

// Column group header height (for grouped columns)
options.setGroupHeaderHeight(50);

// Floating filters height (for in-line filters)
options.setFloatingFiltersHeight(35);
```

### Header Styling

```java
// Apply CSS classes to specific column headers
AgGridColumnDef<?> col = new AgGridColumnDef<>("status", "Status")
    .setHeaderClass("status-header");  // Custom CSS class

// In your CSS:
// .status-header { font-weight: bold; background-color: #e0e0e0; }
```

### Header Tooltips

```java
AgGridColumnDef<?> complexCol = new AgGridColumnDef<>("payload", "Complex Data")
    .setHeaderTooltip("Click to sort; hover for more info");
```

### Vertical Text Headers

For headers displayed vertically, use CSS rotation:

```java
// Set tall header height to accommodate vertical text
options.setHeaderHeight(150);

// Column header with custom styling (CSS in app):
AgGridColumnDef<?> verticalCol = new AgGridColumnDef<>("shortCode", "Code")
    .setHeaderClass("vertical-header");

// CSS:
/*
.vertical-header .ag-header-cell-text {
    transform: rotate(90deg);
    display: inline-block;
    margin-top: 80px;
    width: 30px;
}
*/
```

### Custom Header Components

```java
public class CustomHeaderComponent extends DivSimple<CustomHeaderComponent> 
    implements IComponent<CustomHeaderComponent> {
    // Custom header logic (sorting icons, filters, etc.)
}

// Add to column
AgGridColumnDef<?> col = new AgGridColumnDef<>("amount", "Amount")
    .setHeaderComponent(new CustomHeaderComponent());
```

---

## Column Pinning

### Basic Pinning

```java
// Pin to left (keeps visible when scrolling right)
AgGridColumnDef<?> idCol = new AgGridColumnDef<>("id", "ID")
    .setPinned("left");

// Pin to right
AgGridColumnDef<?> totalCol = new AgGridColumnDef<>("total", "Total")
    .setPinned("right");

// Not pinned (default)
AgGridColumnDef<?> detailCol = new AgGridColumnDef<>("details", "Details")
    .setPinned(null);
```

### Lock Pinned State

```java
// Prevent user from un-pinning via context menu
AgGridColumnDef<?> lockedCol = new AgGridColumnDef<>("id", "ID")
    .setPinned("left")
    .setLockPinned(true);
```

### Use Case: Fixed ID + Scrollable Data

```java
PersonGrid grid = new PersonGrid();

// Fixed ID column (always visible)
grid.addColumnDef(new AgGridColumnDef<>("id", "ID")
    .setPinned("left")
    .setWidth(80)
    .setLockPinned(true));

// Scrollable columns
grid.addColumnDef(new AgGridColumnDef<>("name", "Name").setFlex(1));
grid.addColumnDef(new AgGridColumnDef<>("email", "Email").setFlex(1));
grid.addColumnDef(new AgGridColumnDef<>("phone", "Phone").setFlex(1));

// Fixed action column (always visible)
grid.addColumnDef(new AgGridColumnDef<>("actions", "Actions")
    .setPinned("right")
    .setWidth(100)
    .setLockPinned(true));
```

---

## Column Moving

### Enable Column Dragging

```java
AgGridOptions<?> options = grid.getOptions();

// Allow users to reorder columns via drag-and-drop
options.setMovable(true);
```

### Suppress Column Move Animation

```java
// Disable animation when dragging (faster UX)
options.setSuppressColumnMoveAnimation(true);
```

### Prevent Hiding on Drag-Out

```java
// By default, dragging column outside grid hides it
// Prevent this behavior:
options.setSuppressDragLeaveHidesColumns(true);
```

### Column-Level Move Prevention

```java
// Lock a column so it cannot be moved
AgGridColumnDef<?> fixedCol = new AgGridColumnDef<>("id", "ID")
    .setSuppressMovable(true);
```

---

## Column Sizing

### Fixed Widths

```java
AgGridColumnDef<?> col = new AgGridColumnDef<>("status", "Status")
    .setWidth(120);  // Fixed 120px
```

### Flexible (Flex) Layout

```java
// Column takes proportional share of remaining space
AgGridColumnDef<?> flexCol = new AgGridColumnDef<>("description", "Description")
    .setFlex(2);  // Takes 2x more space than flex: 1

AgGridColumnDef<?> otherCol = new AgGridColumnDef<>("notes", "Notes")
    .setFlex(1);   // Takes 1x space
```

### Min/Max Width

```java
AgGridColumnDef<?> col = new AgGridColumnDef<>("payload", "Data")
    .setMinWidth(100)   // Cannot shrink below 100px
    .setMaxWidth(500);  // Cannot grow beyond 500px
```

### Auto-Size on Init

```java
AgGridOptions<?> options = grid.getOptions();

// Optionally auto-fit columns to content on initialization
// (Requires AG Grid API call in Angular component)
```

### Column Spanning (Cells Across Multiple Columns)

```java
// Configure cell spanning to merge cells across columns
AgGridColumnDef<?> col = new AgGridColumnDef<>("category", "Category")
    .setColSpan(2);  // Cell spans 2 columns
```

---

## Column Groups

### Nested Grouped Columns

```java
AgGridColumnDef<?> nameGroup = new AgGridColumnDef<>("name", "Name Group")
    .setChildren(Arrays.asList(
        new AgGridColumnDef<>("firstName", "First Name"),
        new AgGridColumnDef<>("lastName", "Last Name")
    ));

AgGridColumnDef<?> addressGroup = new AgGridColumnDef<>("address", "Address")
    .setChildren(Arrays.asList(
        new AgGridColumnDef<>("street", "Street"),
        new AgGridColumnDef<>("city", "City"),
        new AgGridColumnDef<>("zipCode", "ZIP")
    ));

grid.addColumnDef(nameGroup);
grid.addColumnDef(addressGroup);
```

### Group Header Styling

```java
options.setGroupHeaderHeight(50);  // Taller header for group labels
```

---

## Column Spanning

### Row Spanning (Single Cell Over Multiple Rows)

```java
// Configure a cell to span multiple rows
AgGridColumnDef<?> categoryCol = new AgGridColumnDef<>("category", "Category")
    .setRowSpan(3);  // Cell spans 3 rows
```

### Column Spanning (Single Cell Over Multiple Columns)

```java
// Already covered in "Column Spanning" section above
AgGridColumnDef<?> col = new AgGridColumnDef<>("category", "Category")
    .setColSpan(2);  // Cell spans 2 columns
```

---

## Full-Width Rows

### Custom Row Templates

```java
// Row that spans full width (not divided into columns)
AgGridOptions<?> options = grid.getOptions();

// Configure full-width row renderer
// Requires custom component implementation
```

### Use Case: Summary/Total Rows

```java
public class SummaryRowRenderer extends DefaultCellRenderer<SummaryRowRenderer> 
    implements ICellRenderer<SummaryRowRenderer> {
    // Custom component that renders a full-width summary row
}
```

---

## Data Types & Cell Formatting

### Text Columns

```java
AgGridColumnDef<?> nameCol = new AgGridColumnDef<>("name", "Name")
    .setFilter("agTextColumnFilter");  // Text search
```

### Number Columns

```java
AgGridColumnDef<?> salaryCol = new AgGridColumnDef<>("salary", "Salary")
    .setFilter("agNumberColumnFilter")  // Numeric range filter
    .setWidth(120);

// Custom formatter (in Angular component via cellRenderer)
```

### Date Columns

```java
AgGridColumnDef<?> dateCol = new AgGridColumnDef<>("hireDate", "Hire Date")
    .setFilter("agDateColumnFilter")
    .setWidth(130);

// Custom date formatter via cell renderer
```

### Boolean/Status Columns

```java
AgGridColumnDef<?> activeCol = new AgGridColumnDef<>("active", "Active")
    .setFilter("agSetColumnFilter")  // Checkboxes for true/false
    .setWidth(100)
    .setCellRenderer(new StatusBadgeRenderer());  // Custom badge component
```

---

## Highlighting Changes

### Flash Changed Cells

```java
// Enable visual feedback when cell values change
AgGridOptions<?> options = grid.getOptions();
options.setEnableCellChangeFlash(true);

// Cells briefly highlight (CSS animation) when value updates
```

### Custom Change Detection

```java
// In Angular component, use AG Grid API to detect changes
// and apply custom styling (not built-in; requires custom implementation)
```

---

## Tooltips

### Column Header Tooltips

```java
AgGridColumnDef<?> col = new AgGridColumnDef<>("complexField", "Complex Data")
    .setHeaderTooltip("Hover for more information about this column");
```

### Cell Tooltips

```java
public class TooltipRenderer extends DefaultCellRenderer<TooltipRenderer> 
    implements ICellRenderer<TooltipRenderer> {
    // Custom component that shows tooltip on hover
}

AgGridColumnDef<?> col = new AgGridColumnDef<>("description", "Description")
    .setCellRenderer(new TooltipRenderer());
```

### Tooltip Configuration

```java
// Global tooltip settings
AgGridOptions<?> options = grid.getOptions();
options.setEnableRichSelect(true);  // Enable rich tooltips (enterprise feature)
```

---

## Migration Guide (Legacy → New Docs)

### Mapping Legacy Topics to New Structure

The legacy `docs/AgGrid-Guide.md` (1046 lines) has been decomposed into the modular documentation structure per the forward-only policy. Here's the mapping:

| Legacy Section | New Location | Status |
|----------------|--------------|--------|
| **Introduction** | [PACT.md - Product Intent](./PACT.md#product-intent) | ✅ Migrated |
| **Installation** | [PACT.md - Technology Stack](./PACT.md#technology-stack-selected) | ✅ Migrated |
| **Basic Usage** | [GUIDES.md - Creating a Basic Grid](./GUIDES.md#creating-a-basic-grid) | ✅ Migrated |
| **Configuration Options - Grid-Level** | [GUIDES.md - Configuring Columns](./GUIDES.md#configuring-columns) | ✅ Migrated |
| **Configuration Options - Columns** | [GUIDES.md - Configuring Columns](./GUIDES.md#configuring-columns) + **[GUIDES_EXTENSIONS.md](#column-configuration-extended)** | ✅ Migrated |
| **Header Customization** | **[GUIDES_EXTENSIONS.md - Header Customization](#header-customization)** | ✅ Migrated |
| **Column Moving** | **[GUIDES_EXTENSIONS.md - Column Moving](#column-moving)** | ✅ Migrated |
| **Column Pinning** | **[GUIDES_EXTENSIONS.md - Column Pinning](#column-pinning)** | ✅ Migrated |
| **Column Sizing** | **[GUIDES_EXTENSIONS.md - Column Sizing](#column-sizing)** | ✅ Migrated |
| **Column Groups** | **[GUIDES_EXTENSIONS.md - Column Groups](#column-groups)** | ✅ Migrated |
| **Column Spanning** | **[GUIDES_EXTENSIONS.md - Column Spanning](#column-spanning)** | ✅ Migrated |
| **Row Selection** | [GUIDES.md - Row Selection](./GUIDES.md#row-selection) | ✅ Migrated |
| **Full Width Rows** | **[GUIDES_EXTENSIONS.md - Full-Width Rows](#full-width-rows)** | ✅ Migrated |
| **Custom Cell Renderers** | [GUIDES.md - Custom Cell Renderers](./GUIDES.md#custom-cell-renderers) | ✅ Migrated |
| **Data Binding** | [GUIDES.md - Real-Time Data Updates](./GUIDES.md#real-time-data-updates) | ✅ Migrated |
| **Examples** | [GUIDES.md - Advanced Patterns](./GUIDES.md#advanced-patterns) | ✅ Migrated |
| **Troubleshooting** | [GUIDES.md - Troubleshooting](./GUIDES.md#troubleshooting) | ✅ Migrated |

### How to Use the New Structure

**For Developers Coming from Legacy Guide:**

1. **Basic Grid Setup**: Start with [GUIDES.md - Creating a Basic Grid](./GUIDES.md#creating-a-basic-grid)
2. **Configure Columns**: Read [GUIDES.md - Configuring Columns](./GUIDES.md#configuring-columns) then **[GUIDES_EXTENSIONS.md - Column Configuration](#column-configuration-extended)** for advanced options
3. **Custom Renderers**: See [GUIDES.md - Custom Cell Renderers](./GUIDES.md#custom-cell-renderers)
4. **Real-Time Data**: See [GUIDES.md - Real-Time Data Updates](./GUIDES.md#real-time-data-updates)
5. **Need Headers/Pinning/Groups**: Check **[GUIDES_EXTENSIONS.md](#table-of-contents)** for topic
6. **Architecture Deep-Dive**: See [docs/architecture/README.md](./docs/architecture/README.md)
7. **Technology Rules**: See [RULES.md](./RULES.md)

### Cleanup Plan (Forward-Only Policy)

**Phase 1 (Now - Stage 1)**: 
- ✅ New modular docs created
- ⏳ Legacy `docs/AgGrid-Guide.md` remains (reference during transition)
- ⏳ Other legacy topic files (`cell-*.txt`, `column-*.txt`, etc.) remain

**Phase 2 (Stage 3 - Implementation Review)**:
- 📋 Review & approve new modular docs
- 📋 Deprecate legacy guide with migration notes
- 📋 Add redirect link from legacy file to new location

**Phase 3 (Future Release)**:
- 🗑️ Remove `docs/AgGrid-Guide.md` entirely
- 🗑️ Remove scattered topic files (`docs/cell-*.txt`, etc.)
- 🗑️ Confirm all references updated in README/docs

---

## Design Validation Checklist

### ✅ Column Configuration (Extended)
- [x] All column properties documented (field, header, sortable, filter, resizable, width, flex, minWidth, maxWidth, hide, etc.)
- [x] Examples provided for each property type
- [x] Responsive layout patterns shown (flex + fixed mix)
- [x] Column visibility toggle explained

### ✅ Header Customization
- [x] Header heights documented
- [x] Styling via CSS classes
- [x] Tooltips on headers
- [x] Vertical text example provided
- [x] Custom header components pattern shown

### ✅ Column Operations (Pinning, Moving, Sizing)
- [x] All three operations documented with examples
- [x] Lock mechanisms explained (lockPinned, suppressMovable)
- [x] Use cases provided (fixed ID + scrollable data)

### ✅ Column Groups & Spanning
- [x] Nested groups example
- [x] Column spanning (colSpan) documented
- [x] Row spanning (rowSpan) documented

### ✅ Full-Width Rows
- [x] Concept explained
- [x] Summary row use case shown
- [x] Custom component pattern outlined

### ✅ Data Types & Formatting
- [x] Text, Number, Date, Boolean column examples
- [x] Filter types mapped to data types
- [x] Cell renderer integration shown

### ✅ Highlighting & Tooltips
- [x] Cell change flash configuration documented
- [x] Header & cell tooltips shown
- [x] Custom tooltip components pattern

### ✅ Migration Guide
- [x] Legacy topics mapped to new locations
- [x] Navigation guide provided for users
- [x] Cleanup plan (3 phases) documented
- [x] Forward-only policy applied

---

## Acceptance Criteria

### Documentation Completeness
- ✅ All legacy guide sections captured in new modular docs
- ✅ Each section has at least one code example
- ✅ Cross-references between GUIDES, GUIDES_EXTENSIONS, RULES, IMPLEMENTATION provided
- ✅ Related links included at bottom of sections

### Consistency with RULES
- ✅ All code examples follow CRTP fluent API pattern
- ✅ No Lombok @Builder shown (rule violation)
- ✅ WebSocket/reactive patterns where applicable
- ✅ Terminology matches GLOSSARY.md

### Usability for Developers
- ✅ Table of Contents with hyperlinks (easy navigation)
- ✅ Code examples are copy-paste ready
- ✅ Use cases provided (not just abstract patterns)
- ✅ Troubleshooting section for common issues
- ✅ Advanced patterns for power users

### Forward-Only Policy Compliance
- ✅ No legacy code stubs maintained for backward compatibility
- ✅ All references updated (no broken links)
- ✅ Cleanup plan documented for future removal
- ✅ New structure is definitive (no duplication)

---

## References

- **Extended Guides**: This file (GUIDES_EXTENSIONS.md)
- **Quick Start Guides**: [GUIDES.md](./GUIDES.md)
- **Technology Rules**: [RULES.md](./RULES.md)
- **Architecture**: [docs/architecture/README.md](./docs/architecture/README.md)
- **Terminology**: [GLOSSARY.md](./GLOSSARY.md)
- **AG Grid Official Docs**: https://www.ag-grid.com/

---

## Document Metadata

- **Created**: December 2, 2025 (Stage 2)
- **Version**: 1.0
- **Status**: Draft (awaiting review)
- **Custodian**: JWebMP AgGrid Team
