# AG Grid Plugin Guide for JWebMP

This guide provides comprehensive information on how to use the AG Grid plugin in JWebMP applications, including setup, configuration, and custom cell renderers.

## Table of Contents

1. [Introduction](#introduction)
2. [Installation](#installation)
3. [Basic Usage](#basic-usage)
4. [Configuration Options](#configuration-options)
   - [Grid-Level Options](#grid-level-options)
   - [Column Definitions](#column-definitions)
   - [Header Customization](#header-customization)
   - [Column Moving](#column-moving)
   - [Column Pinning](#column-pinning)
   - [Column Sizing](#column-sizing)
   - [Column Groups](#column-groups)
   - [Column Spanning](#column-spanning)
   - [Row Selection](#row-selection)
   - [Full Width Rows](#full-width-rows)
5. [Custom Cell Renderers](#custom-cell-renderers)
6. [Data Binding](#data-binding)
7. [Examples](#examples)
8. [Troubleshooting](#troubleshooting)

## Introduction

AG Grid is a feature-rich data grid component for displaying and manipulating tabular data. The JWebMP AG Grid plugin provides a Java wrapper around the AG Grid library, making it easy to use in JWebMP applications.

Key features include:
- Data binding with server-side data sources
- Custom cell renderers
- Sorting, filtering, and pagination
- Column resizing and reordering
- Row selection

## Installation

### Maven Dependency

Add the following dependency to your project's `pom.xml`:

```xml
<dependency>
    <groupId>com.jwebmp.plugins</groupId>
    <artifactId>ag-grid</artifactId>
    <version>2.0.0-SNAPSHOT</version>
</dependency>
```

### Enable the Plugin

The plugin is automatically enabled when added to your project. If you need to manually enable or disable it, use:

```java
AgGridPageConfigurator.setEnabled(true); // or false to disable
```

## Basic Usage

To use AG Grid in your application, you need to create a subclass of `AgGrid` and implement the required methods:

```java
public class MyDataGrid extends AgGrid<MyDataGrid> {
    
    public MyDataGrid() {
        // Configure your grid here
        setID("myDataGrid");
    }
    
    @Override
    public List<MyDataObject> fetchData() {
        // Return your data collection
        return myDataService.getAllData();
    }
    
    @Override
    public String getRowIdFieldName() {
        // Return the field name to use as row ID
        return "id";
    }
}
```

Then add it to your page:

```java
MyDataGrid grid = new MyDataGrid();
add(grid);
```

## Configuration Options

AG Grid provides numerous configuration options through the `AgGridOptions` class:

### Grid-Level Options

```java
MyDataGrid grid = new MyDataGrid();

// Get the options object
AgGridOptions<?> options = grid.getOptions();

// Configure grid options
options.setPagination(true)
       .setPaginationPageSize(10)
       .setRowSelectionMode(RowSelectionMode.MULTIPLE)
       .setResizable(true)
       .setSortable(true)
       .setFilter(true)
       .setMovable(true);
```

### Column Definitions

Columns are defined using the `AgGridColumnDef` class:

```java
// Create column definitions
AgGridColumnDef<?> nameColumn = new AgGridColumnDef<>("name", "Name")
    .setSortable(true)
    .setFilter(true)
    .setResizable(true)
    .setWidth(200);

AgGridColumnDef<?> ageColumn = new AgGridColumnDef<>("age", "Age")
    .setSortable(true)
    .setFilter(true)
    .setWidth(100);

// Add columns to the grid options
options.getColumnDefs().add(nameColumn);
options.getColumnDefs().add(ageColumn);
```

### Header Customization

AG Grid provides several options for customizing headers, including height settings and styling.

#### Header Heights

You can customize the height of different header components:

```java
// Configure header heights
options.setHeaderHeight(50)                // Regular column headers
       .setGroupHeaderHeight(75)           // Column group headers
       .setFloatingFiltersHeight(40)       // Floating filters
       .setPivotHeaderHeight(60)           // Pivot mode headers
       .setPivotGroupHeaderHeight(80)      // Pivot mode group headers
       .setHidePaddedHeaderRows(true);     // Hide empty header rows
```

#### Auto Header Height

You can enable automatic header height adjustment based on content:

```java
// Enable auto header height for the grid
options.setAutoHeaderHeight(true);

// Or enable it for specific columns
AgGridColumnDef<?> descriptionColumn = new AgGridColumnDef<>("description", "Description")
    .setAutoHeaderHeight(true)
    .setWrapHeaderText(true);
```

#### Header Styling

You can apply custom styles and classes to column headers:

```java
// Apply CSS styles directly
AgGridColumnDef<?> statusColumn = new AgGridColumnDef<>("status", "Status")
    .setHeaderStyle("{\"color\": \"red\", \"background-color\": \"#f0f0f0\"}");

// Apply CSS classes
AgGridColumnDef<?> priorityColumn = new AgGridColumnDef<>("priority", "Priority")
    .setHeaderClass("priority-header");

// Add tooltips to headers
AgGridColumnDef<?> complexColumn = new AgGridColumnDef<>("complex", "Complex Data")
    .setHeaderTooltip("This column contains complex structured data");
```

#### Vertical Text Headers

To create vertical text headers like those shown in the headers.txt example, you can add custom CSS to your application:

```java
// First, set a taller header height
options.setHeaderHeight(150);

// Then add this CSS to your application
/*
.ag-header-cell-label {
    height: 100%;
    padding: 0 !important;
}

.ag-header-cell-label .ag-header-cell-text {
    width: 30px;
    transform: rotate(90deg);
    margin-top: 50px;
    display: inline-block;
}
*/
```

### Column Moving

AG Grid allows columns to be moved by dragging them with the mouse or through the API. You can configure various aspects of column moving behavior.

#### Basic Column Moving

To enable column moving, set the `movable` property on the grid options:

```java
// Enable column moving
options.setMovable(true);
```

#### Column Moving Animation

By default, column move animations are enabled. You can disable them if needed:

```java
// Disable column move animations
options.setSuppressColumnMoveAnimation(true);
```

#### Preventing Columns from Being Hidden

When a column is dragged outside the grid, it is hidden by default. You can prevent this behavior:

```java
// Prevent columns from being hidden when dragged outside the grid
options.setSuppressDragLeaveHidesColumns(true);
```

#### Suppressing Movement While Dragging

By default, columns move while being dragged. You can suppress this behavior:

```java
// Suppress column movement while dragging
options.setSuppressMoveWhenColumnDragging(true);
```

#### Column-Level Moving Properties

You can control moving behavior at the column level:

```java
// Create a column that cannot be moved
AgGridColumnDef<?> fixedColumn = new AgGridColumnDef<>("fixed", "Fixed Column")
    .setSuppressMovable(true);

// Create a column locked to the left position
AgGridColumnDef<?> leftLockedColumn = new AgGridColumnDef<>("left", "Left Locked")
    .setLockPosition("left");

// Create a column with locked visibility
AgGridColumnDef<?> visibilityLockedColumn = new AgGridColumnDef<>("locked", "Visibility Locked")
    .setLockVisible(true);
```

### Column Pinning

AG Grid allows columns to be pinned to the left or right side of the grid, keeping them visible while scrolling horizontally through the data.

#### Basic Column Pinning

To pin a column, set the `pinned` property on the column definition:

```java
// Pin a column to the left
AgGridColumnDef<?> athleteColumn = new AgGridColumnDef<>("athlete", "Athlete")
    .setPinned("left");

// Pin a column to the right
AgGridColumnDef<?> totalColumn = new AgGridColumnDef<>("total", "Total")
    .setPinned("right");
```

#### Locking Pinned Columns

You can prevent users from changing the pinned state of columns through the UI:

```java
// Create a column that is pinned and cannot be unpinned
AgGridColumnDef<?> lockedPinnedColumn = new AgGridColumnDef<>("athlete", "Athlete")
    .setPinned("left")
    .setLockPinned(true);

// Create a column that cannot be pinned
AgGridColumnDef<?> unpinnableColumn = new AgGridColumnDef<>("age", "Age")
    .setLockPinned(true);
```

#### Handling Pinned Section Resizing

When pinned sections become too large, AG Grid will automatically unpin columns to ensure the center viewport remains visible. You can customize this behavior using the `processUnpinnedColumns` property:

```java
// Set a custom function to handle unpinning columns when viewport is too small
options.setProcessUnpinnedColumns("function(params) { /* custom logic */ return []; }");
```

#### Pinning via Column Dragging

Users can pin columns by dragging them to the edge of the grid or to an existing pinned area. This behavior is enabled by default.

#### Example: Mixed Pinned Columns

```java
// Configure grid with mixed pinned columns
AgGridOptions<?> options = grid.getOptions();

// Create column definitions with different pinning configurations
AgGridColumnDef<?> pinnedLeftColumn = new AgGridColumnDef<>("athlete", "Athlete")
    .setPinned("left");

AgGridColumnDef<?> lockedPinnedColumn = new AgGridColumnDef<>("country", "Country")
    .setPinned("left")
    .setLockPinned(true);

AgGridColumnDef<?> unpinnableColumn = new AgGridColumnDef<>("age", "Age")
    .setLockPinned(true);

AgGridColumnDef<?> pinnedRightColumn = new AgGridColumnDef<>("total", "Total")
    .setPinned("right");

// Add columns to the grid options
options.getColumnDefs().add(pinnedLeftColumn);
options.getColumnDefs().add(lockedPinnedColumn);
options.getColumnDefs().add(unpinnableColumn);
options.getColumnDefs().add(pinnedRightColumn);
```

### Column Sizing

AG Grid provides several options for controlling column widths and resizing behavior.

#### Basic Column Resizing

By default, all columns can be resized by dragging the right edge of the column header. You can control this behavior for individual columns:

```java
// Disable resizing for a specific column
AgGridColumnDef<?> addressColumn = new AgGridColumnDef<>("address", "Address")
    .setResizable(false);

// Enable resizing for all columns via grid options
options.setResizable(true);
```

#### Fixed and Flexible Column Widths

Columns can have fixed widths or use flex sizing to fill available space:

```java
// Fixed width column
AgGridColumnDef<?> fixedColumn = new AgGridColumnDef<>("name", "Name")
    .setWidth(200);

// Flex column (will expand to fill available space)
AgGridColumnDef<?> flexColumn = new AgGridColumnDef<>("description", "Description")
    .setFlex(1);

// Flex column with constraints
AgGridColumnDef<?> constrainedFlexColumn = new AgGridColumnDef<>("details", "Details")
    .setFlex(2)
    .setMinWidth(100)
    .setMaxWidth(300);
```

When using flex, columns will divide the available space proportionally to their flex values. For example, a column with `flex: 2` will take twice as much space as a column with `flex: 1`.

#### Auto-Sizing Columns

Columns can be automatically sized to fit either the grid width or their content:

```java
// Auto-size strategy to fit grid width
options.setAutoSizeStrategy("{\"type\": \"fitGridWidth\", \"defaultMinWidth\": 100}");

// Auto-size strategy to fit content
options.setAutoSizeStrategy("{\"type\": \"fitCellContents\"}");

// Exclude a column from auto-sizing
AgGridColumnDef<?> excludedColumn = new AgGridColumnDef<>("id", "ID")
    .setSuppressSizeToFit(true);
```

#### Shift Resizing

You can change the default behavior for column resizing to maintain the total grid width:

```java
// Set shift resizing as the default behavior
options.setColResizeDefault("shift");
```

With shift resizing, when a column is resized, the adjacent column will adjust to maintain the total width of the grid.

#### Column Virtualization

For grids with many columns, you can disable column virtualization to ensure all columns are considered when auto-sizing:

```java
// Disable column virtualization
options.setSuppressColumnVirtualisation(true);
```

Note that disabling column virtualization may impact performance for grids with a large number of columns.

### Column Groups

AG Grid supports grouping columns in the header. Column groups can be expanded and collapsed to show or hide child columns.

#### Basic Column Groups

To create a column group, set the `children` property with a list of column definitions:

```java
// Create a column group
AgGridColumnDef<?> athleteDetailsGroup = new AgGridColumnDef<>();
athleteDetailsGroup.setHeaderName("Athlete Details");

// Create child columns
AgGridColumnDef<?> athleteColumn = new AgGridColumnDef<>("athlete", "Athlete");
AgGridColumnDef<?> countryColumn = new AgGridColumnDef<>("country", "Country");

// Add child columns to the group
List<AgGridColumnDef<?>> children = new ArrayList<>();
children.add(athleteColumn);
children.add(countryColumn);
athleteDetailsGroup.setChildren(children);

// Add the column group to the grid options
options.getColumnDefs().add(athleteDetailsGroup);
```

#### Column Group Show/Hide Behavior

You can control when columns are shown within a group using the `columnGroupShow` property:

```java
// Create a sports results group
AgGridColumnDef<?> sportsResultsGroup = new AgGridColumnDef<>();
sportsResultsGroup.setHeaderName("Sports Results");

// Total column - only shown when group is closed
AgGridColumnDef<?> totalColumn = new AgGridColumnDef<>("total", "Total");
totalColumn.setColumnGroupShow("closed");

// Medal columns - only shown when group is open
AgGridColumnDef<?> goldColumn = new AgGridColumnDef<>("gold", "Gold");
goldColumn.setColumnGroupShow("open");
AgGridColumnDef<?> silverColumn = new AgGridColumnDef<>("silver", "Silver");
silverColumn.setColumnGroupShow("open");

// Add columns to the group
List<AgGridColumnDef<?>> medalColumns = new ArrayList<>();
medalColumns.add(totalColumn);
medalColumns.add(goldColumn);
medalColumns.add(silverColumn);
sportsResultsGroup.setChildren(medalColumns);
```

#### Default Column Group Definition

You can set default properties for all column groups:

```java
// Set default properties for all column groups
AgGridColumnDef<?> defaultColGroupDef = new AgGridColumnDef<>();
defaultColGroupDef.setHeaderClass("group-header");
defaultColGroupDef.setOpenByDefault(true);

// Apply to grid options
options.setDefaultColGroupDef(defaultColGroupDef);
```

#### Column Group Properties

Column groups support several properties:

```java
// Create a column group with various properties
AgGridColumnDef<?> groupWithProperties = new AgGridColumnDef<>();
groupWithProperties.setHeaderName("Group Name");
groupWithProperties.setMarryChildren(true);           // Keep children together when moving
groupWithProperties.setOpenByDefault(true);           // Start with group open
groupWithProperties.setSuppressStickyLabel(true);     // Don't keep label visible when scrolling
groupWithProperties.setAutoHeaderHeight(true);        // Auto-adjust header height
groupWithProperties.setWrapHeaderText(true);          // Wrap header text
```

### Column Spanning

AG Grid allows cells to span multiple columns, similar to cell merging in Excel or column spanning in HTML tables.

#### Basic Column Spanning

To enable column spanning, use the `colSpan` property on the column definition. This can be a fixed value or a function that returns the number of columns to span:

```java
// Create a column with fixed column spanning
AgGridColumnDef<?> titleColumn = new AgGridColumnDef<>("title", "Title")
    .setColSpan(2); // This column will always span 2 columns

// Create a column with dynamic column spanning based on data
AgGridColumnDef<?> countryColumn = new AgGridColumnDef<>("country", "Country")
    .setColSpan("params => params.data.country === 'United States' ? 3 : 1");
```

#### Column Spanning Example

Here's a more complete example of using column spanning in a grid:

```java
// Configure grid options
AgGridOptions<?> options = grid.getOptions();

// Create column definitions with spanning
AgGridColumnDef<?> nameColumn = new AgGridColumnDef<>("name", "Name");

AgGridColumnDef<?> countryColumn = new AgGridColumnDef<>("country", "Country")
    // Country column spans 2 columns for Russia, 3 for USA, and 1 for others
    .setColSpan("params => {" +
                "  if (params.data.country === 'Russia') return 2;" +
                "  if (params.data.country === 'United States') return 3;" +
                "  return 1;" +
                "}");

AgGridColumnDef<?> yearColumn = new AgGridColumnDef<>("year", "Year");
AgGridColumnDef<?> sportColumn = new AgGridColumnDef<>("sport", "Sport");
AgGridColumnDef<?> goldColumn = new AgGridColumnDef<>("gold", "Gold");
AgGridColumnDef<?> silverColumn = new AgGridColumnDef<>("silver", "Silver");

// Add columns to the grid options
options.getColumnDefs().add(nameColumn);
options.getColumnDefs().add(countryColumn);
options.getColumnDefs().add(yearColumn);
options.getColumnDefs().add(sportColumn);
options.getColumnDefs().add(goldColumn);
options.getColumnDefs().add(silverColumn);

// Add CSS to highlight spanned cells
grid.addStyle(".ag-cell-span", "background-color: #d9f0d9;");
```

#### Column Spanning Constraints

When using column spanning, be aware of the following constraints:

1. Cell selection may not work correctly with spanning cells, as the selection range is no longer a perfect rectangle.
2. Column spanning only works within the same region of the grid. For example, a cell cannot span from the pinned area into the non-pinned area.
3. When columns are reordered or hidden, the spanning behavior may change as it depends on the current column order.

Column spanning is particularly useful for creating report-like layouts in AG Grid, where certain cells need to span multiple columns to create headers or group related data.

### Row Selection

AG Grid supports both single and multiple row selection modes with various configuration options.

#### Single Row Selection

To enable single row selection, set the row selection mode to `SINGLE`:

```java
// Enable single row selection
options.setRowSelectionMode(RowSelectionMode.SINGLE);
```

Or using the full options object:

```java
// Create row selection options for single selection
RowSelectionOptions<?> rowSelectionOptions = new RowSelectionOptions<>();
rowSelectionOptions.setMode(RowSelectionMode.SINGLE);
options.setRowSelection(rowSelectionOptions);
```

With single row selection, only one row can be selected at a time. Selecting a new row will automatically deselect the previously selected row.

#### Multiple Row Selection

For multiple row selection, set the mode to `MULTIPLE`:

```java
// Enable multiple row selection
options.setRowSelectionMode(RowSelectionMode.MULTIPLE);
```

#### Removing Selection Checkboxes

By default, AG Grid shows checkboxes for row selection. You can disable them and use click selection instead:

```java
RowSelectionOptions<?> rowSelectionOptions = new RowSelectionOptions<>();
rowSelectionOptions.setMode(RowSelectionMode.SINGLE);
rowSelectionOptions.setCheckboxes(false);
rowSelectionOptions.setEnableClickSelection(true);
options.setRowSelection(rowSelectionOptions);
```

#### Configuring Selectable Rows

You can specify which rows can be selected using a callback function:

```java
// Only allow selection for rows where the 'year' property is less than 2007
RowSelectionOptions<?> rowSelectionOptions = new RowSelectionOptions<>();
rowSelectionOptions.setMode(RowSelectionMode.SINGLE);
// In your Angular component, implement this as:
// isRowSelectable: (rowNode) => rowNode.data ? rowNode.data.year < 2007 : false
rowSelectionOptions.setHideDisabledCheckboxes(true); // Hide checkboxes for non-selectable rows
options.setRowSelection(rowSelectionOptions);
```

#### Click Selection Options

The `enableClickSelection` property controls whether rows can be selected by clicking:

```java
// Enable both selection and deselection by clicking
rowSelectionOptions.setEnableClickSelection(true);

// Enable only selection by clicking (not deselection)
rowSelectionOptions.setEnableClickSelection("enableSelection");

// Enable only deselection by Ctrl+clicking
rowSelectionOptions.setEnableClickSelection("enableDeselection");

// Disable click selection entirely
rowSelectionOptions.setEnableClickSelection(false);
```

#### Selection Column Customization

You can customize the selection column by setting the `selectionColumnDef` property on the grid options:

```java
// Create a custom selection column definition
AgGridColumnDef<?> selectionColumnDef = new AgGridColumnDef<>();
selectionColumnDef.setWidth(50);
selectionColumnDef.setHeaderTooltip("Select rows");
selectionColumnDef.setSortable(true);
selectionColumnDef.setResizable(true);

// Set the selection column definition
options.setSelectionColumnDef(selectionColumnDef);
```

#### Other Selection Options

The `RowSelectionOptions` class provides several additional options:

```java
RowSelectionOptions<?> rowSelectionOptions = new RowSelectionOptions<>();

// Configure checkboxes
rowSelectionOptions.setCheckboxLocation(CheckboxLocation.SELECTION_COLUMN); // In dedicated column
rowSelectionOptions.setHideDisabledCheckboxes(true); // Hide checkboxes for non-selectable rows

// Additional options
rowSelectionOptions.setCopySelectedRows(true); // Copy entire row when selected
rowSelectionOptions.setEnableSelectionWithoutKeys(false); // Require modifier keys for multiple selection
rowSelectionOptions.setMasterSelects("self"); // Master row selection behavior
```

#### Programmatic Row Selection

You can programmatically select rows using the grid API:

```java
// Select a row by ID
grid.getGridApi().selectRow("rowId");

// Select multiple rows
grid.getGridApi().selectRows(Arrays.asList("rowId1", "rowId2"));

// Clear selection
grid.getGridApi().deselectAll();
```

### Full Width Rows

AG Grid allows you to create full width rows that span the entire grid width, ignoring the column definitions. This is useful for displaying complex components or detailed information panels within the grid.

#### Basic Full Width Rows

To enable full width rows, you need to configure two properties:

```java
// Get the options object
AgGridOptions<?> options = grid.getOptions();

// Set the callback to determine which rows should be full width
options.setIsFullWidthRow("params => params.data.fullWidth === true");

// Set the cell renderer to use for full width rows
options.setFullWidthCellRenderer(FullWidthCellRenderer.class);
```

The `isFullWidthRow` callback receives a params object containing the rowNode and should return true for rows that should be rendered as full width.

#### Creating a Full Width Cell Renderer

You can create a custom full width cell renderer by extending the provided `FullWidthCellRenderer` class:

```java
public class MyFullWidthRenderer extends FullWidthCellRenderer<MyFullWidthRenderer> {
    
    public MyFullWidthRenderer() {
        // Constructor
    }
    
    @Override
    public void init() {
        if (!isInitialized()) {
            // Custom rendering logic
            add("""
                <div class="my-full-width-container">
                    <h3>{{ data.title }}</h3>
                    <p>{{ data.description }}</p>
                    <button (click)="onButtonClick()">View Details</button>
                </div>
            """);
            
            // Add custom styling
            addStyle("padding", "15px");
            addStyle("background-color", "#f9f9f9");
        }
        super.init();
    }
    
    // Add custom methods if needed
    @NgMethod("""
        onButtonClick(): void {
            console.log('Button clicked for row:', this.rowId);
        }
    """)
}
```

#### Embedded Full Width Rows

By default, full width rows remain fixed in place when scrolling horizontally. To make them scroll with the grid, set the `embedFullWidthRows` property:

```java
// Make full width rows scroll horizontally with the grid
options.setEmbedFullWidthRows(true);
```

When embedded, a different instance of the full width cell renderer is created for each section of the grid (pinned left, pinned right, and non-pinned).

#### Example: Mixed Regular and Full Width Rows

```java
// Configure grid options
AgGridOptions<?> options = grid.getOptions();

// Set full width row properties
options.setIsFullWidthRow("params => params.data.type === 'detail'");
options.setFullWidthCellRenderer(DetailPanelRenderer.class);

// Create column definitions for regular rows
AgGridColumnDef<?> nameColumn = new AgGridColumnDef<>("name", "Name");
AgGridColumnDef<?> ageColumn = new AgGridColumnDef<>("age", "Age");
AgGridColumnDef<?> countryColumn = new AgGridColumnDef<>("country", "Country");

// Add columns to the grid options
options.getColumnDefs().add(nameColumn);
options.getColumnDefs().add(ageColumn);
options.getColumnDefs().add(countryColumn);

// Add data with both regular and full width rows
List<Object> rowData = new ArrayList<>();
rowData.add(Map.of("name", "John", "age", 25, "country", "USA"));
rowData.add(Map.of("type", "detail", "title", "John's Details", "description", "Additional information about John"));
rowData.add(Map.of("name", "Mary", "age", 32, "country", "Canada"));
options.setRowData(rowData);
```

## Custom Cell Renderers

AG Grid allows you to customize how cells are rendered using custom cell renderers.

### Using the Default Cell Renderer

The plugin provides a `DefaultCellRenderer` class that you can extend:

```java
public class MyCustomRenderer extends DefaultCellRenderer<MyCustomRenderer> {
    
    public MyCustomRenderer() {
        // Configure the renderer
    }
    
    @Override
    public void init() {
        if (!isInitialized()) {
            // Custom rendering logic
            add("<div class='custom-cell'>{{ value }}</div>");
        }
        super.init();
    }
}
```

### Applying a Cell Renderer to a Column

```java
AgGridColumnDef<?> actionColumn = new AgGridColumnDef<>("action", "Actions")
    .setCellRenderer(MyCustomRenderer.class);
```

### Passing Parameters to Cell Renderers

You can pass parameters to your cell renderer:

```java
// Create parameters object
MyRendererParams params = new MyRendererParams();
params.setShowIcon(true);

// Set the parameters on the column definition
actionColumn.setCellRendererParams(params);
```

## Data Binding

AG Grid in JWebMP supports data binding through WebSockets for real-time updates.

### Implementing Data Fetching

The `fetchData()` method in your grid subclass is called to retrieve data:

```java
@Override
public List<MyDataObject> fetchData() {
    // Return your data collection
    return myDataService.getAllData();
}
```

### Row Identification

The `getRowIdFieldName()` method specifies which field in your data objects should be used as the unique identifier for rows:

```java
@Override
public String getRowIdFieldName() {
    return "id"; // Use the 'id' field as the row identifier
}
```

## Examples

### Basic Grid with Pagination

```java
public class UserGrid extends AgGrid<UserGrid> {
    
    public UserGrid() {
        setID("userGrid");
        
        // Configure grid options
        AgGridOptions<?> options = getOptions();
        options.setPagination(true)
               .setPaginationPageSize(20)
               .setRowSelection("single");
        
        // Define columns
        AgGridColumnDef<?> idColumn = new AgGridColumnDef<>("id", "ID")
            .setWidth(80);
        
        AgGridColumnDef<?> nameColumn = new AgGridColumnDef<>("name", "Name")
            .setSortable(true)
            .setFilter(true)
            .setResizable(true);
        
        AgGridColumnDef<?> emailColumn = new AgGridColumnDef<>("email", "Email")
            .setSortable(true)
            .setFilter(true)
            .setResizable(true);
        
        // Add columns to options
        options.getColumnDefs().add(idColumn);
        options.getColumnDefs().add(nameColumn);
        options.getColumnDefs().add(emailColumn);
    }
    
    @Override
    public List<User> fetchData() {
        return userService.getAllUsers();
    }
    
    @Override
    public String getRowIdFieldName() {
        return "id";
    }
}
```

### Grid with Custom Headers

```java
public class ReportGrid extends AgGrid<ReportGrid> {
    
    public ReportGrid() {
        setID("reportGrid");
        
        // Configure grid options with custom header heights
        AgGridOptions<?> options = getOptions();
        options.setHeaderHeight(60)
               .setGroupHeaderHeight(80)
               .setFloatingFiltersHeight(40);
        
        // Create a column group
        AgGridColumnDef<?> detailsGroup = new AgGridColumnDef<>();
        detailsGroup.setHeaderName("Report Details");
        detailsGroup.setHeaderClass("report-header-group");
        
        // Create columns with custom header styling
        AgGridColumnDef<?> dateColumn = new AgGridColumnDef<>("date", "Date")
            .setHeaderTooltip("Report generation date")
            .setWidth(120);
        
        AgGridColumnDef<?> titleColumn = new AgGridColumnDef<>("title", "Report Title")
            .setHeaderStyle("{\"color\": \"#2196F3\", \"font-weight\": \"bold\"}")
            .setWidth(200);
        
        AgGridColumnDef<?> statusColumn = new AgGridColumnDef<>("status", "Status")
            .setHeaderClass("status-header")
            .setWidth(100);
        
        AgGridColumnDef<?> descriptionColumn = new AgGridColumnDef<>("description", "Description")
            .setAutoHeaderHeight(true)
            .setWrapHeaderText(true)
            .setWidth(300);
        
        // Add columns to the group
        List<AgGridColumnDef<?>> groupChildren = new ArrayList<>();
        groupChildren.add(dateColumn);
        groupChildren.add(titleColumn);
        detailsGroup.setChildren(groupChildren);
        
        // Add columns to options
        options.getColumnDefs().add(detailsGroup);
        options.getColumnDefs().add(statusColumn);
        options.getColumnDefs().add(descriptionColumn);
        
        // Add custom CSS for the grid
        addStyle("--ag-header-background-color", "#f5f5f5");
    }
    
    @Override
    public List<Report> fetchData() {
        return reportService.getReports();
    }
    
    @Override
    public String getRowIdFieldName() {
        return "id";
    }
}
```

### Grid with Custom Cell Renderer

```java
// Custom cell renderer for status column
public class StatusCellRenderer extends DefaultCellRenderer<StatusCellRenderer> {
    
    public StatusCellRenderer() {
        // Constructor
    }
    
    @Override
    public void init() {
        if (!isInitialized()) {
            add("""
                <div [ngClass]="{'status-active': value === 'Active', 
                                'status-inactive': value === 'Inactive',
                                'status-pending': value === 'Pending'}">
                    {{ value }}
                </div>
            """);
        }
        super.init();
    }
}

// Using the custom renderer in a grid
public class UserStatusGrid extends AgGrid<UserStatusGrid> {
    
    public UserStatusGrid() {
        setID("userStatusGrid");
        
        // Configure columns
        AgGridColumnDef<?> nameColumn = new AgGridColumnDef<>("name", "Name");
        
        AgGridColumnDef<?> statusColumn = new AgGridColumnDef<>("status", "Status")
            .setCellRenderer(StatusCellRenderer.class);
        
        // Add columns to options
        getOptions().getColumnDefs().add(nameColumn);
        getOptions().getColumnDefs().add(statusColumn);
    }
    
    // Implementation of required methods...
}
```

## Troubleshooting

### Common Issues

1. **Grid not displaying data**
   - Ensure your `fetchData()` method returns a non-empty collection
   - Check that column field names match the property names in your data objects

2. **Custom cell renderers not working**
   - Verify that the cell renderer class is properly registered
   - Check for errors in the Angular template syntax

3. **Styling issues**
   - Make sure the AG Grid CSS files are properly loaded
   - You can customize the grid appearance by using one of the built-in themes or creating your own

### Debugging Tips

- Enable browser developer tools to check for JavaScript errors
- Use the `console.log()` statements in your Angular templates for debugging
- Inspect the generated HTML to ensure the grid structure is correct

## Additional Resources

- [AG Grid Official Documentation](https://www.ag-grid.com/documentation-main/documentation.php)
- [JWebMP AG Grid Wiki](https://github.com/JWebMP/JWebMP-AgGrid/wiki)
- [AG Grid API Reference](https://www.ag-grid.com/javascript-grid-api/)