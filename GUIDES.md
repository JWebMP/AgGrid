# GUIDES.md

**How-To Guide & Common Patterns** — JWebMP AgGrid Plugin v2.0.0-SNAPSHOT

This guide provides practical examples and patterns for using the AgGrid plugin. For rules and technology stack details, see [RULES.md](./RULES.md).

---

## Table of Contents

1. [Creating a Basic Grid](#creating-a-basic-grid)
2. [Configuring Columns](#configuring-columns)
3. [Custom Cell Renderers](#custom-cell-renderers)
4. [Row Selection](#row-selection)
5. [Pagination](#pagination)
6. [Styling & Theming](#styling--theming)
7. [Real-Time Data Updates](#real-time-data-updates)
8. [Event Handling](#event-handling)
9. [Advanced Patterns](#advanced-patterns)
10. **[Extended Patterns & Migration Guide](./GUIDES_EXTENSIONS.md)** ← See this for advanced column operations, headers, pinning, groups, data types, highlighting, tooltips, and legacy doc migration

---

## Creating a Basic Grid

### Step 1: Extend AgGrid

```java
package com.example.demo.grids;

import com.jwebmp.plugins.aggrid.AgGrid;
import com.jwebmp.plugins.aggrid.options.AgGridOptions;
import com.guicedee.client.IGuiceContext;

public class PersonGrid extends AgGrid<PersonGrid> {
    
    public PersonGrid() {
        setID("personGrid");
        setHeight("500px");
        setTheme("ag-theme-alpine");
    }
    
    @Override
    public List<Person> fetchData() {
        // Fetch data from service (dependency injection)
        PersonService service = IGuiceContext.get(PersonService.class);
        return service.getAllPersons();
    }
    
    @Override
    public String getRowIdFieldName() {
        // Field name that uniquely identifies rows
        return "id";
    }
}
```

### Step 2: Add to a JWebMP Page

```java
public class MyPage extends JWebMPPage {
    @Override
    public void init() {
        PersonGrid grid = new PersonGrid()
            .bindColumnDefs("columnDefs")
            .bindRowData("rowData")
            .enablePagination()
            .bindPaginationPageSize("pageSize");
        add(grid);
    }
}
```

### Step 3: Render Grid with Data

The grid will:
1. Register a WebSocket listener for real-time updates
2. Render `<ag-grid-angular [gridOptions]="options" ...>`
3. On client-side bootstrap, emit "grid ready" via WebSocket
4. Server responds with initial rowData
5. Client receives and AG Grid renders rows

---

## Configuring Columns

### Basic Column with Sorting & Filtering

```java
PersonGrid grid = new PersonGrid();

// Add a simple column
AgGridColumnDef<Person> nameCol = new AgGridColumnDef<>("name", "Full Name")
    .setSortable(true)
    .setFilterable(true)
    .setResizable(true);
grid.addColumnDef(nameCol);

// Add another column
AgGridColumnDef<Person> ageCol = new AgGridColumnDef<>("age", "Age")
    .setSortable(true)
    .setFilterable(true)
    .setWidth(100);
grid.addColumnDef(ageCol);
```

### Column Group Example

```java
AgGridColumnDef<Person> groupCol = new AgGridColumnDef<>("name", "Personal Info")
    .setChildren(Arrays.asList(
        new AgGridColumnDef<>("firstName", "First Name"),
        new AgGridColumnDef<>("lastName", "Last Name")
    ));
grid.addColumnDef(groupCol);
```

### Default Column Definition

```java
AgGridOptions<?> options = grid.getOptions();
AgGridColumnDef<?> defaultCol = new AgGridColumnDef<>()
    .setSortable(true)
    .setFilterable(true)
    .setResizable(true);
options.setDefaultColDef(defaultCol);

// Now all columns inherit these settings unless overridden
```

---

## Custom Cell Renderers

### Step 1: Create a Cell Renderer Component

```java
package com.example.demo.renderers;

import com.jwebmp.core.base.angular.client.annotations.structures.NgField;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.plugins.aggrid.cellrenderers.DefaultCellRenderer;

public class StatusBadgeRenderer extends DefaultCellRenderer<StatusBadgeRenderer> 
    implements INgComponent<StatusBadgeRenderer> {
    
    public StatusBadgeRenderer() {
        // Configure component selector, template, styles
    }
    
    @NgField("badgeClass: string;")
    public String getBadgeClass() {
        // Determine CSS class based on status value
        return "badge-success"; // or badge-warning, badge-danger, etc.
    }
    
    @Override
    public List<String> fields() {
        List<String> fields = new ArrayList<>();
        fields.add("badgeClass: string = 'badge-success';");
        return fields;
    }
}
```

### Step 2: Add Renderer to Column

```java
PersonGrid grid = new PersonGrid();

StatusBadgeRenderer statusRenderer = new StatusBadgeRenderer();

AgGridColumnDef<Person> statusCol = new AgGridColumnDef<>("status", "Status")
    .setCellRenderer(statusRenderer);

grid.addColumnDef(statusCol);
```

### Step 3: JWebMP Codegen

JWebMP automatically:
1. Detects `StatusBadgeRenderer` implements `IComponent`
2. Emits `@NgComponentReference(StatusBadgeRenderer.class)` on the grid
3. Generates Angular component metadata
4. Injects renderer into column definition in generated TypeScript

---

## Row Selection

### Single Row Selection

```java
PersonGrid grid = new PersonGrid()
    .enableRowSelection("single");  // or RowSelectionMode.SINGLE

// Or:
grid.getOptions().setRowSelectionMode(RowSelectionMode.SINGLE);
```

### Multiple Row Selection

```java
PersonGrid grid = new PersonGrid()
    .enableRowSelection("multiple");  // or RowSelectionMode.MULTIPLE

// Or via options:
RowSelectionOptions rowSel = new RowSelectionOptions();
rowSel.setMode(RowSelectionMode.MULTIPLE);
rowSel.setCheckboxes(true);  // Show checkboxes
grid.getOptions().setRowSelection(rowSel);
```

### Handling Row Selection Events

```java
public class PersonGrid extends AgGrid<PersonGrid> {
    
    @Override
    public List<String> onRowSelectJS() {
        // Return list of JavaScript event handler code snippets
        List<String> handlers = new ArrayList<>();
        handlers.add("""
            console.log('Row selected:', $event.data);
            // Send selection to server via AJAX (optional)
            this.http.post('/api/grid-selection', { 
                gridId: this.listenerName, 
                rowId: $event.data.id 
            }).subscribe(response => {
                console.log('Selection recorded:', response);
            });
        """);
        return handlers;
    }
}
```

---

## Pagination

### Enable Pagination

```java
PersonGrid grid = new PersonGrid()
    .enablePagination()
    .bindPaginationPageSize("pageSize");

// Set page size (default: all rows)
grid.getOptions().setPaginationPageSize(20);
```

### Server-Side Pagination

```java
public class PersonGrid extends AgGrid<PersonGrid> {
    
    @Override
    public List<Person> fetchData() {
        PersonService service = IGuiceContext.get(PersonService.class);
        
        // Pagination params from grid (if supported in future)
        int pageNumber = 0; // TODO: receive from grid state
        int pageSize = 20;
        
        return service.getPersons(pageNumber, pageSize);
    }
}
```

---

## Styling & Theming

### Set Theme

```java
PersonGrid grid = new PersonGrid()
    .setTheme("ag-theme-alpine");  // or ag-theme-balham, ag-theme-material, etc.
```

### Set Dimensions

```java
PersonGrid grid = new PersonGrid()
    .setHeight("600px")
    .setWidth("100%");

// Or adjust after creation:
grid.setHeight("800px");
```

### Custom CSS Classes

```java
PersonGrid grid = new PersonGrid()
    .addAttribute("class", "custom-grid-theme")
    .addAttribute("style", "border: 1px solid #ccc;");
```

---

## Real-Time Data Updates

### Reactive Data Push via WebSocket

```java
public class PersonGrid extends AgGrid<PersonGrid> {
    
    @Override
    public List<Person> fetchData() {
        // Called on initial load and when server pushes updates
        PersonService service = IGuiceContext.get(PersonService.class);
        return service.getAllPersons();
    }
}
```

**How it Works:**
1. Initial load: Grid emits "ready" signal → Server calls `fetchData()` → Sends rowData via WebSocket
2. Data update: External event (new person added) → Server calls `fetchData()` → Broadcasts updated rowData
3. Client receives: Grid updates via `AG Grid API.setGridOption('rowData', newRows)`

### Trigger Data Refresh

```java
public class PersonGridService {
    
    public void addPerson(Person p) {
        personRepository.save(p);
        
        // Notify all connected grids to refresh
        PersonGrid grid = IGuiceContext.get(PersonGrid.class);
        List<Person> updated = grid.fetchData();
        
        // Broadcast via WebSocket (handled by framework)
        broadcastGridUpdate("personGrid", updated);
    }
    
    private void broadcastGridUpdate(String gridId, List<?> data) {
        // Framework mechanism: AjaxResponse sent via WebSocket to all listeners
    }
}
```

---

## Event Handling

### Grid Ready Event

```java
public class PersonGrid extends AgGrid<PersonGrid> {
    
    @Override
    public List<String> constructorBody() {
        List<String> body = super.constructorBody();
        body.add("""
            // Emitted by @NgAfterViewInit annotation
            this.eventBusService.listen(this.listenerName, this.handlerId)
              .subscribe(message => {
                  console.log('Grid ready, initializing...');
                  // Grid is now initialized and ready for user interaction
              });
        """);
        return body;
    }
}
```

### Cell Value Changed

```java
public class PersonGrid extends AgGrid<PersonGrid> {
    
    // OnCellValueChanged event handled by AG Grid callbacks
    // Override in subclass if custom handling needed
}
```

### Custom AJAX Callbacks

```java
public class PersonGrid extends AgGrid<PersonGrid> {
    
    @Override
    public List<String> onRowSelectJS() {
        List<String> handlers = new ArrayList<>();
        handlers.add("""
            if ($event.node.isSelected()) {
                this.http.post('/api/persons/selected', { 
                    id: $event.data.id,
                    action: 'select'
                }).subscribe(
                    response => console.log('Selected:', response),
                    error => console.error('Error:', error)
                );
            }
        """);
        return handlers;
    }
}
```

---

## Advanced Patterns

### Pattern 1: Master-Detail Grid

```java
public class OrdersGrid extends AgGrid<OrdersGrid> {
    
    @Override
    public List<String> onRowSelectJS() {
        return Arrays.asList("""
            // When order selected, load associated order items
            const orderId = $event.data.id;
            this.eventBusService.send('orderItemsGrid-' + orderId, {
                orderId: orderId
            }, 'orderItemsGrid-' + orderId);
        """);
    }
}

public class OrderItemsGrid extends AgGrid<OrderItemsGrid> {
    
    private String orderId;
    
    public OrderItemsGrid(String orderId) {
        this.orderId = orderId;
        setID("orderItemsGrid-" + orderId);
    }
    
    @Override
    public List<OrderItem> fetchData() {
        OrderService service = IGuiceContext.get(OrderService.class);
        return service.getOrderItems(orderId);
    }
}
```

### Pattern 2: Grid with Server-Side Filtering

```java
public class FilterableGrid extends AgGrid<FilterableGrid> {
    
    private String searchText = "";
    
    public FilterableGrid setSearchText(String text) {
        this.searchText = text;
        return this;
    }
    
    @Override
    public List<Person> fetchData() {
        PersonService service = IGuiceContext.get(PersonService.class);
        
        if (searchText != null && !searchText.isEmpty()) {
            return service.searchPersons(searchText);
        }
        return service.getAllPersons();
    }
}
```

### Pattern 3: Dynamic Column Visibility

```java
public class DynamicColumnsGrid extends AgGrid<DynamicColumnsGrid> {
    
    private Set<String> visibleColumns = new HashSet<>(
        Arrays.asList("id", "name", "email")
    );
    
    public DynamicColumnsGrid toggleColumnVisibility(String fieldName) {
        if (visibleColumns.contains(fieldName)) {
            visibleColumns.remove(fieldName);
        } else {
            visibleColumns.add(fieldName);
        }
        return this;
    }
    
    @Override
    public List<AgGridColumnDef<?>> getVisibleColumnDefs() {
        return getOptions().getColumnDefs().stream()
            .filter(col -> visibleColumns.contains(col.getField()))
            .collect(Collectors.toList());
    }
}
```

### Pattern 4: Grid with Inline Editing

```java
public class EditableGrid extends AgGrid<EditableGrid> {
    
    @Override
    public List<String> onRowSelectJS() {
        return Arrays.asList("""
            // Enable AG Grid cell editing on double-click
            const rowNode = this.gridApi.getRowNode($event.rowIndex);
            if (rowNode) {
                rowNode.setExpanded(false);
                // Trigger edit mode for first cell
                this.gridApi.startEditingCell({ rowIndex: $event.rowIndex, colKey: 'name' });
            }
        """);
    }
}
```

---

## Troubleshooting

### Issue: Grid not rendering

**Checklist:**
1. ✅ Grid ID is unique (no duplicates on page)
2. ✅ `getRowIdFieldName()` returns existing field in row data
3. ✅ `fetchData()` returns non-null collection
4. ✅ WebSocket listener registered (check browser console: "Grid ready" message)
5. ✅ Theme CSS file included (ag-grid CSS)

### Issue: Data not updating in real-time

**Checklist:**
1. ✅ WebSocket connection active (check browser DevTools Network tab)
2. ✅ Server-side `fetchData()` returns new data
3. ✅ Browser subscription listening (check RxJS subscription)
4. ✅ `rowSelection` mode configured if row selection used

### Issue: Custom cell renderer not showing

**Checklist:**
1. ✅ Renderer extends `DefaultCellRenderer` or implements `IComponent`
2. ✅ Renderer registered via `@NgComponentReference` annotation
3. ✅ Renderer added to column before `grid.init()` called
4. ✅ Column `cellRenderer` property set to renderer instance

---

## Related Documents

- **Technology Rules**: [RULES.md](./RULES.md)
- **Product Intent**: [PACT.md](./PACT.md)
- **Code Layout**: [IMPLEMENTATION.md](./IMPLEMENTATION.md)
- **Architecture**: [docs/architecture/README.md](./docs/architecture/README.md)
- **Terminology**: [GLOSSARY.md](./GLOSSARY.md)

---

## Document Metadata

- **Created**: December 2, 2025 (Stage 1)
- **Version**: 1.0
- **Status**: Active
- **Custodian**: JWebMP AgGrid Team
