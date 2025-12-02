# AG Grid Community API Reference

**Version**: AG Grid 34.2.0+  
**Edition**: Community  
**Reference**: [Official AG Grid API Documentation](https://www.ag-grid.com/angular-data-grid/grid-api/)

## Overview

The AG Grid Community Edition provides a comprehensive JavaScript API for programmatic grid control. Since v34.2.0, all features listed below are available in the Community Edition at no additional cost.

This document maps the Grid API to JWebMP's Angular wrapper, showing how to access and use the grid API in your applications.

---

## Accessing the Grid API

In your Angular component, access the grid API through the `GridApi` object passed to the `onGridReady()` callback:

```typescript
// In your Angular component
export class MyGridComponent {
  gridApi: GridApi;
  
  onGridReady(params: GridReadyEvent) {
    this.gridApi = params.api;
    
    // Now you can use the API
    this.gridApi.selectAll();
    this.getSelectedRows();
  }
  
  getSelectedRows() {
    const selectedRows = this.gridApi.getSelectedRows();
    console.log('Selected rows:', selectedRows);
  }
}
```

---

## API Categories

### 1. Row Access & Management

#### Getting Row Nodes

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `getRowNode(id)` | Get a single row node by ID | RowNode | `const node = api.getRowNode('123');` |
| `getRenderedNodes()` | Get all visible (rendered) row nodes | RowNode[] | `const visible = api.getRenderedNodes();` |
| `getDisplayedRowAtIndex(index)` | Get row at specific visible index | RowNode | `const row = api.getDisplayedRowAtIndex(0);` |

#### Iterating Rows

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `forEachNode(callback)` | Iterate all rows (including hidden) | void | `api.forEachNode(node => console.log(node.data));` |
| `forEachNodeAfterFilter(callback)` | Iterate filtered rows | void | `api.forEachNodeAfterFilter(node => {...});` |
| `forEachNodeAfterFilterAndSort(callback)` | Iterate filtered & sorted rows in display order | void | `api.forEachNodeAfterFilterAndSort(node => {...});` |
| `forEachLeafNode(callback)` | Iterate leaf nodes only (for grouped/tree data) | void | `api.forEachLeafNode(node => {...});` |

#### Row Display Information

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `getDisplayedRowCount()` | Get count of visible rows | number | `const count = api.getDisplayedRowCount();` |
| `getFirstDisplayedRowIndex()` | Get index of first rendered row (with scroll buffer) | number | `const first = api.getFirstDisplayedRowIndex();` |
| `getLastDisplayedRowIndex()` | Get index of last rendered row | number | `const last = api.getLastDisplayedRowIndex();` |
| `isRowDataEmpty()` | Check if no rows in client-side model | boolean | `if (api.isRowDataEmpty()) { /* no data */ }` |

#### Row Expansion (Groups & Trees)

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `setRowNodeExpanded(rowNode, expanded, forceSync?)` | Expand/collapse a row (groups, trees, master-detail) | void | `api.setRowNodeExpanded(node, true);` |
| `expandAll()` | Expand all groups | void | `api.expandAll();` |
| `collapseAll()` | Collapse all groups | void | `api.collapseAll();` |
| `onGroupExpandedOrCollapsed()` | Notify grid of manual group state changes | void | `api.onGroupExpandedOrCollapsed();` |

---

### 2. Column Management

#### Column Definitions & Access

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `getColumnDefs()` | Get current column definitions | ColDef[] | `const cols = api.getColumnDefs();` |
| `getColumn(colKey)` | Get a single column by ID or ColDef | Column | `const col = api.getColumn('name');` |
| `getColumns()` | Get all columns (regardless of visibility) | Column[] | `const cols = api.getColumns();` |
| `getAllGridColumns()` | Get all grid columns in display order | Column[] | `const cols = api.getAllGridColumns();` |

#### Column Display State

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `getDisplayedCenterColumns()` | Get non-pinned columns | Column[] | `const center = api.getDisplayedCenterColumns();` |
| `getDisplayedLeftColumns()` | Get left-pinned columns | Column[] | `const left = api.getDisplayedLeftColumns();` |
| `getDisplayedRightColumns()` | Get right-pinned columns | Column[] | `const right = api.getDisplayedRightColumns();` |
| `getAllDisplayedColumns()` | Get all visible columns across all sections | Column[] | `const all = api.getAllDisplayedColumns();` |
| `getAllDisplayedVirtualColumns()` | Get visible columns (excluding virtualized) | Column[] | `const virtual = api.getAllDisplayedVirtualColumns();` |
| `getDisplayedColAfter(col)` | Get column to the right | Column | `const next = api.getDisplayedColAfter(col);` |
| `getDisplayedColBefore(col)` | Get column to the left | Column | `const prev = api.getDisplayedColBefore(col);` |
| `setColumnsVisible(keys, visible)` | Show/hide columns | void | `api.setColumnsVisible(['name', 'age'], false);` |
| `getDisplayNameForColumn(col)` | Get display name (with headerValueGetter) | string | `const name = api.getDisplayNameForColumn(col);` |

#### Column State Management

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `getColumnState()` | Get state (order, width, pinned, hidden, sort) | ColumnState[] | `const state = api.getColumnState();` |
| `applyColumnState(state)` | Restore column state | boolean (success) | `api.applyColumnState(savedState);` |
| `resetColumnState()` | Reset to original column definitions | void | `api.resetColumnState();` |
| `getColumnGroupState()` | Get group collapse/expand state | ColumnGroupState[] | `const groupState = api.getColumnGroupState();` |
| `setColumnGroupState(state)` | Set group collapse/expand state | void | `api.setColumnGroupState(groupState);` |
| `resetColumnGroupState()` | Reset groups to original state | void | `api.resetColumnGroupState();` |

#### Column Sizing

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `setColumnWidths(colsWithWidth)` | Set widths for columns | void | `api.setColumnWidths([{key: 'name', newWidth: 250}]);` |
| `sizeColumnsToFit(params?)` | Auto-fit columns to grid width | void | `api.sizeColumnsToFit();` |
| `autoSizeColumns(colKeys?, skipHeader?)` | Auto-size columns to content | void | `api.autoSizeColumns(['name', 'email']);` |
| `autoSizeAllColumns(skipHeader?)` | Auto-size all columns to content | void | `api.autoSizeAllColumns();` |

#### Column Pinning

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `isPinning()` | Check if any columns are pinned | boolean | `if (api.isPinning()) { /* handle pinned */ }` |
| `isPinningLeft()` | Check if left pinning active | boolean | `const leftPin = api.isPinningLeft();` |
| `isPinningRight()` | Check if right pinning active | boolean | `const rightPin = api.isPinningRight();` |
| `setColumnsPinned(keys, pinned)` | Pin/unpin columns | void | `api.setColumnsPinned(['name'], 'left');` |

#### Column Grouping

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `getColumnGroup(name)` | Get column group by name | ColumnGroup | `const group = api.getColumnGroup('details');` |
| `getProvidedColumnGroup(name)` | Get original column group (pre-processing) | ProvidedColumnGroup | `const orig = api.getProvidedColumnGroup('details');` |
| `setColumnGroupOpened(name, open)` | Expand/collapse column group | void | `api.setColumnGroupOpened('details', true);` |
| `getDisplayNameForColumnGroup(group)` | Get group display name | string | `const name = api.getDisplayNameForColumnGroup(group);` |
| `getAllDisplayedColumnGroups()` | Get all root column groups | ColumnGroup[] | `const groups = api.getAllDisplayedColumnGroups();` |

#### Column Moving

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `moveColumns(keys, toIndex)` | Move columns to index | void | `api.moveColumns(['name', 'age'], 0);` |
| `moveColumnByIndex(fromIndex, toIndex)` | Move column by position | void | `api.moveColumnByIndex(1, 3);` |

---

### 3. Row Selection

#### Basic Selection

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `selectAll(selectAllMode?, source?)` | Select all rows | void | `api.selectAll();` |
| `deselectAll(selectAllMode?, source?)` | Deselect all rows | void | `api.deselectAll();` |
| `getSelectedNodes()` | Get selected row nodes (unsorted) | RowNode[] | `const nodes = api.getSelectedNodes();` |
| `getSelectedRows()` | Get selected row data (unsorted) | any[] | `const data = api.getSelectedRows();` |
| `setNodesSelected(params)` | Set selection state for rows | void | `api.setNodesSelected({nodes: [node1, node2], newValue: true});` |

#### Advanced Selection

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `getBestCostNodeSelection()` | Get selected nodes at best cost (for grouped data) | RowNode[] | `const best = api.getBestCostNodeSelection();` |
| `getCellRanges()` | Get selected cell ranges | CellRange[] | `const ranges = api.getCellRanges();` |
| `addCellRange(params)` | Add to selected cell ranges | void | `api.addCellRange({rowStart: 0, rowEnd: 5, columns: ['name']});` |
| `clearCellSelection()` | Clear all cell ranges | void | `api.clearCellSelection();` |

---

### 4. Filtering

#### Quick Filter

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `getQuickFilter()` | Get current quick filter text | string | `const filter = api.getQuickFilter();` |
| `isQuickFilterPresent()` | Check if quick filter set | boolean | `const hasFilter = api.isQuickFilterPresent();` |
| `resetQuickFilter()` | Clear quick filter | void | `api.resetQuickFilter();` |

#### Column Filters

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `isColumnFilterPresent()` | Check if any column filter active | boolean | `if (api.isColumnFilterPresent()) { /* has filter */ }` |
| `isAnyFilterPresent()` | Check if any filter (quick, column, advanced, external) | boolean | `const hasAny = api.isAnyFilterPresent();` |
| `getColumnFilterInstance(key)` | Get filter component for column | IFilterComp | `const filter = api.getColumnFilterInstance('name');` |
| `getColumnFilterModel()` | Get filter state for all columns | any | `const model = api.getFilterModel();` |
| `setColumnFilterModel(model)` | Set filter state for all columns | void | `api.setFilterModel(savedFilterModel);` |
| `getColumnFilterModel(key, useUnapplied?)` | Get filter state for specific column | any | `const nameFilter = api.getColumnFilterModel('name');` |
| `setColumnFilterModel(key, model)` | Set filter state for specific column | void | `api.setColumnFilterModel('name', {type: 'equals', filter: 'John'});` |
| `onFilterChanged(params?)` | Notify grid of external filter changes | void | `api.onFilterChanged({source: 'api'});` |
| `destroyFilter(key)` | Force filter recreation | void | `api.destroyFilter('name');` |

#### Advanced Filter

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `getAdvancedFilterModel()` | Get advanced filter state | AdvancedFilterModel | `const advanced = api.getAdvancedFilterModel();` |
| `setAdvancedFilterModel(model)` | Set advanced filter state | void | `api.setAdvancedFilterModel(advancedModel);` |
| `showAdvancedFilterBuilder()` | Open advanced filter builder dialog | void | `api.showAdvancedFilterBuilder();` |
| `hideAdvancedFilterBuilder()` | Close advanced filter builder | void | `api.hideAdvancedFilterBuilder();` |

---

### 5. Sorting

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `onSortChanged()` | Notify grid of manual sort changes | void | `api.onSortChanged();` |

---

### 6. Pagination

#### Page Navigation

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `paginationGetPageSize()` | Get rows per page | number | `const pageSize = api.paginationGetPageSize();` |
| `paginationGetCurrentPage()` | Get current page (0-based) | number | `const page = api.paginationGetCurrentPage();` |
| `paginationGetTotalPages()` | Get total number of pages | number | `const total = api.paginationGetTotalPages();` |
| `paginationGetRowCount()` | Get total pageable rows | number | `const count = api.paginationGetRowCount();` |
| `paginationIsLastPageFound()` | Check if last page known | boolean | `const isLastKnown = api.paginationIsLastPageFound();` |

#### Page Movement

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `paginationGoToPage(page)` | Go to page (0-based) | void | `api.paginationGoToPage(2);` |
| `paginationGoToNextPage()` | Go to next page | void | `api.paginationGoToNextPage();` |
| `paginationGoToPreviousPage()` | Go to previous page | void | `api.paginationGoToPreviousPage();` |
| `paginationGoToFirstPage()` | Go to first page | void | `api.paginationGoToFirstPage();` |
| `paginationGoToLastPage()` | Go to last page | void | `api.paginationGoToLastPage();` |

---

### 7. Cell Editing

#### Edit Control

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `startEditingCell(params)` | Start editing a cell | void | `api.startEditingCell({rowIndex: 0, colKey: 'name'});` |
| `stopEditing(cancel?)` | Stop cell editing | void | `api.stopEditing(false); // save changes` |
| `getEditingCells()` | Get currently editing cells | CellPosition[] | `const editing = api.getEditingCells();` |
| `getCellEditorInstances(params?)` | Get active cell editor instances | ICellEditor[] | `const editors = api.getCellEditorInstances();` |
| `validateEdit()` | Run validation on all editors | void | `api.validateEdit();` |

#### Clipboard

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `cutToClipboard()` | Cut (Ctrl+X equivalent) | void | `api.cutToClipboard();` |
| `copyToClipboard()` | Copy (Ctrl+C equivalent) | void | `api.copyToClipboard();` |
| `copySelectedRowsToClipboard(params?)` | Copy selected rows | void | `api.copySelectedRowsToClipboard();` |
| `copySelectedRangeToClipboard()` | Copy selected cell range | void | `api.copySelectedRangeToClipboard();` |
| `copySelectedRangeDown()` | Fill down (Ctrl+D equivalent) | void | `api.copySelectedRangeDown();` |
| `pasteFromClipboard()` | Paste (Ctrl+V equivalent) | void | `api.pasteFromClipboard();` |

---

### 8. Row Grouping

#### Managing Row Groups

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `getRowGroupColumns()` | Get columns used for grouping | Column[] | `const grouped = api.getRowGroupColumns();` |
| `setRowGroupColumns(keys)` | Set grouping columns | void | `api.setRowGroupColumns(['country', 'sport']);` |
| `addRowGroupColumns(keys)` | Add to row grouping | void | `api.addRowGroupColumns(['country']);` |
| `removeRowGroupColumns(keys)` | Remove from row grouping | void | `api.removeRowGroupColumns(['country']);` |
| `moveRowGroupColumn(from, to)` | Reorder grouping columns | void | `api.moveRowGroupColumn(0, 1);` |

---

### 9. Aggregation (Row Aggregation / Pivot)

#### Value Columns (Pivot)

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `getValueColumns()` | Get aggregation value columns | Column[] | `const values = api.getValueColumns();` |
| `addValueColumns(keys)` | Add aggregation columns | void | `api.addValueColumns(['salary']);` |
| `removeValueColumns(keys)` | Remove aggregation columns | void | `api.removeValueColumns(['salary']);` |
| `setValueColumns(keys)` | Set aggregation columns | void | `api.setValueColumns(['salary', 'bonus']);` |

#### Pivot Columns

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `isPivotMode()` | Check if pivot mode active | boolean | `if (api.isPivotMode()) { /* pivot */ }` |
| `getPivotColumns()` | Get columns used for pivoting | Column[] | `const pivots = api.getPivotColumns();` |
| `setPivotColumns(keys)` | Set pivot columns | void | `api.setPivotColumns(['month']);` |
| `addPivotColumns(keys)` | Add to pivot columns | void | `api.addPivotColumns(['month']);` |
| `removePivotColumns(keys)` | Remove from pivot columns | void | `api.removePivotColumns(['month']);` |
| `getPivotResultColumn(pivotKeys, valueColKey)` | Get pivot result column | Column | `const result = api.getPivotResultColumn(['Jan'], 'salary');` |

#### Aggregation Functions

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `setColumnAggFunc(key, aggFunc)` | Set aggregation function for column | void | `api.setColumnAggFunc('salary', 'sum');` |
| `addAggFuncs(funcs)` | Register custom aggregation functions | void | `api.addAggFuncs({customAvg: customAvgFn});` |
| `clearAggFuncs()` | Clear all aggregation functions | void | `api.clearAggFuncs();` |

---

### 10. Scrolling & Keyboard Navigation

#### Scrolling

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `ensureIndexVisible(index, position?)` | Scroll to row by index | void | `api.ensureIndexVisible(50, 'top');` |
| `ensureNodeVisible(node, position?)` | Scroll to row node | void | `api.ensureNodeVisible(rowNode, 'middle');` |
| `ensureColumnVisible(key, position?)` | Scroll to column | void | `api.ensureColumnVisible('name');` |
| `getHorizontalPixelRange()` | Get horizontal scroll range | {left, right} | `const range = api.getHorizontalPixelRange();` |
| `getVerticalPixelRange()` | Get vertical scroll range | {top, bottom} | `const range = api.getVerticalPixelRange();` |

#### Keyboard Navigation

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `getFocusedCell()` | Get currently focused cell | CellPosition | `const cell = api.getFocusedCell();` |
| `setFocusedCell(row, col, rowPinned?)` | Set focused cell | void | `api.setFocusedCell(0, 'name');` |
| `clearFocusedCell()` | Clear cell focus | void | `api.clearFocusedCell();` |
| `setFocusedHeader(col)` | Set focused header | void | `api.setFocusedHeader('name');` |
| `tabToNextCell()` | Tab to next cell | void | `api.tabToNextCell();` |
| `tabToPreviousCell()` | Shift+tab to previous cell | void | `api.tabToPreviousCell();` |

---

### 11. Refresh & Rendering

#### Refresh Operations

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `refreshCells(params?)` | Refresh cell display | void | `api.refreshCells({rowNodes: [node1], force: true});` |
| `redrawRows(params?)` | Recreate row DOM | void | `api.redrawRows({rowNodes: [node1]});` |
| `refreshHeader()` | Redraw headers | void | `api.refreshHeader();` |
| `refreshClientSideRowModel(step?)` | Re-sort/filter/group | void | `api.refreshClientSideRowModel('filter');` |

#### Row Height

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `onRowHeightChanged()` | Notify of manual height changes | void | `api.onRowHeightChanged();` |
| `resetRowHeights()` | Reset row heights | void | `api.resetRowHeights();` |

#### Rendering Info

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `getRenderedNodes()` | Get visible row nodes | RowNode[] | `const visible = api.getRenderedNodes();` |
| `getCellRendererInstances(params?)` | Get active cell renderers | ICellRendererComp[] | `const renderers = api.getCellRendererInstances();` |
| `getSizesForCurrentTheme()` | Get current theme sizes | SizeObject | `const sizes = api.getSizesForCurrentTheme();` |
| `flashCells(params?)` | Flash cells (highlight changes) | void | `api.flashCells({rowNodes: [node1]});` |

#### Animation

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `isAnimationFrameQueueEmpty()` | Check if animations queued | boolean | `const empty = api.isAnimationFrameQueueEmpty();` |

---

### 12. Export

#### CSV Export

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `exportDataAsCsv(params?)` | Download CSV file | void | `api.exportDataAsCsv({fileName: 'data.csv'});` |
| `getDataAsCsv(params?)` | Get CSV as string | string | `const csv = api.getDataAsCsv();` |

#### Excel Export

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `exportDataAsExcel(params?)` | Download Excel file | void | `api.exportDataAsExcel({fileName: 'data.xlsx'});` |
| `getDataAsExcel(params?)` | Get Excel as Blob | Blob | `const blob = api.getDataAsExcel();` |
| `getSheetDataForExcel(params?)` | Get single sheet data | ExcelExportParams | `const sheet = api.getSheetDataForExcel();` |
| `exportMultipleSheetsAsExcel(params?)` | Export multiple sheets | void | `api.exportMultipleSheetsAsExcel({sheets: [sheet1, sheet2]});` |
| `getMultipleSheetsAsExcel(params?)` | Get multiple sheets as Blob | Blob | `const blob = api.getMultipleSheetsAsExcel({sheets});` |

---

### 13. Grid Options & State

#### Grid Options

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `getGridOption(key)` | Get single grid option | any | `const theme = api.getGridOption('theme');` |
| `setGridOption(key, value)` | Set single grid option | void | `api.setGridOption('theme', 'ag-theme-alpine');` |
| `updateGridOptions(options)` | Set multiple grid options at once | void | `api.updateGridOptions({pagination: true, pageSize: 50});` |

#### Grid State

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `getState()` | Get complete grid state (all properties) | GridState | `const state = api.getState();` |
| `setState(state, params?)` | Restore grid state | void | `api.setState(savedState);` |

#### Grid Information

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `getGridId()` | Get grid instance ID | string | `const id = api.getGridId();` |
| `isDestroyed()` | Check if grid destroyed | boolean | `if (api.isDestroyed()) { return; }` |
| `destroy()` | Destroy grid & release resources | void | `api.destroy();` |

---

### 14. Row Pinning

#### Pinned Rows

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `getPinnedTopRowCount()` | Get top pinned row count | number | `const count = api.getPinnedTopRowCount();` |
| `getPinnedBottomRowCount()` | Get bottom pinned row count | number | `const count = api.getPinnedBottomRowCount();` |
| `getPinnedTopRow(index)` | Get specific top pinned row | RowNode | `const row = api.getPinnedTopRow(0);` |
| `getPinnedBottomRow(index)` | Get specific bottom pinned row | RowNode | `const row = api.getPinnedBottomRow(0);` |
| `forEachPinnedRow(callback)` | Iterate pinned rows | void | `api.forEachPinnedRow(node => console.log(node.data));` |

---

### 15. Data Transactions

#### Client-Side Row Model

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `applyTransaction(transaction)` | Apply add/update/remove operations | RowNodeTransaction | `api.applyTransaction({add: [newRow], update: [updatedRow]});` |
| `applyTransactionAsync(transaction, callback)` | Apply transaction asynchronously | void | `api.applyTransactionAsync({add: [row]}, (res) => {});` |
| `flushAsyncTransactions()` | Wait for all async transactions | Promise | `await api.flushAsyncTransactions();` |

#### Infinite Row Model

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `refreshInfiniteCache()` | Mark blocks for reload | void | `api.refreshInfiniteCache();` |
| `purgeInfiniteCache()` | Clear cache completely | void | `api.purgeInfiniteCache();` |
| `setRowCount(rowCount, maxRowFound?)` | Set row count for infinite scroll | void | `api.setRowCount(1000);` |
| `isLastRowIndexKnown()` | Check if last row is known | boolean | `const known = api.isLastRowIndexKnown();` |
| `getCacheBlockState()` | Get cache state (debugging) | CacheBlockState[] | `const state = api.getCacheBlockState();` |

---

### 16. Server-Side Row Model

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `refreshServerSide(route?)` | Refresh server-side store | void | `api.refreshServerSide();` |
| `getServerSideGroupLevelState()` | Get group level state | ServerSideGroupLevelState[] | `const state = api.getServerSideGroupLevelState();` |
| `retryServerSideLoads()` | Retry failed server requests | void | `api.retryServerSideLoads();` |
| `applyServerSideTransaction(transaction)` | Apply transaction to server-side model | RowNodeTransaction | `api.applyServerSideTransaction({add: [row]});` |
| `applyServerSideTransactionAsync(transaction, callback)` | Async transaction | void | `api.applyServerSideTransactionAsync({add: [row]}, cb);` |
| `applyServerSideRowData(route, data)` | Apply row data to store | void | `api.applyServerSideRowData([], newData);` |

---

### 17. Events

#### Event Management

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `addEventListener(eventType, listener)` | Add event listener | void | `api.addEventListener('rowSelected', myListener);` |
| `removeEventListener(eventType, listener)` | Remove event listener | void | `api.removeEventListener('rowSelected', myListener);` |
| `addGlobalListener(listener)` | Listen to all events | void | `api.addGlobalListener((type, event) => {});` |
| `removeGlobalListener(listener)` | Remove global listener | void | `api.removeGlobalListener(myGlobalListener);` |
| `addRenderedRowListener(rowNode, eventType, listener)` | Listen to virtual row events | void | `api.addRenderedRowListener(node, 'virtualRowRemoved', listener);` |

---

### 18. Column Menu & Context Menu

#### Column Menu

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `showColumnMenu(params)` | Show column menu | void | `api.showColumnMenu({column: col});` |
| `showColumnChooser(params?)` | Show column chooser | void | `api.showColumnChooser();` |
| `hideColumnChooser()` | Hide column chooser | void | `api.hideColumnChooser();` |
| `showColumnFilter(key, parentElement?)` | Show filter for column | void | `api.showColumnFilter('name');` |
| `hideColumnFilter(key)` | Hide column filter | void | `api.hideColumnFilter('name');` |
| `hidePopupMenu()` | Hide any popup (context or column) | void | `api.hidePopupMenu();` |

#### Context Menu

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `showContextMenu(params)` | Show context menu | void | `api.showContextMenu({rowIndex: 0, colKey: 'name'});` |

---

### 19. Side Bar & Tool Panel

#### Side Bar Control

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `getSideBar()` | Get side bar configuration | SideBarState | `const config = api.getSideBar();` |
| `setSideBarVisible(visible)` | Show/hide side bar | void | `api.setSideBarVisible(true);` |
| `isSideBarVisible()` | Check if side bar visible | boolean | `const visible = api.isSideBarVisible();` |
| `setSideBarPosition(position)` | Move side bar (left/right) | void | `api.setSideBarPosition('right');` |

#### Tool Panel

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `openToolPanel(id, parentElement?)` | Open tool panel | void | `api.openToolPanel('filters');` |
| `closeToolPanel()` | Close current tool panel | void | `api.closeToolPanel();` |
| `getOpenedToolPanel()` | Get open tool panel ID | string | `const panel = api.getOpenedToolPanel();` |
| `isToolPanelShowing()` | Check if tool panel visible | boolean | `const showing = api.isToolPanelShowing();` |
| `refreshToolPanel()` | Refresh tool panel display | void | `api.refreshToolPanel();` |
| `getToolPanelInstance(id)` | Get tool panel component instance | IToolPanel | `const panel = api.getToolPanelInstance('filters');` |

#### Status Bar

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `getStatusPanel(id)` | Get status bar panel instance | StatusPanelComp | `const panel = api.getStatusPanel('statusPanelComponent');` |

---

### 20. Master-Detail

#### Detail Grids

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `getDetailGridInfo(id)` | Get detail grid info | DetailGridInfo | `const detail = api.getDetailGridInfo('detail-1');` |
| `forEachDetailGridInfo(callback)` | Iterate detail grids | void | `api.forEachDetailGridInfo((info) => {});` |
| `addDetailGridInfo(id, gridInfo)` | Register detail grid | void | `api.addDetailGridInfo('detail-1', info);` |
| `removeDetailGridInfo(id)` | Unregister detail grid | void | `api.removeDetailGridInfo('detail-1');` |

---

### 21. Integrated Charts

#### Chart Management

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `createRangeChart(params)` | Create chart from range | ChartRef | `const chart = api.createRangeChart({...});` |
| `createPivotChart(params)` | Create pivot chart | ChartRef | `const chart = api.createPivotChart({...});` |
| `createCrossFilterChart(params)` | Create cross-filter chart | ChartRef | `const chart = api.createCrossFilterChart({...});` |
| `updateChart(params)` | Update chart data/options | void | `api.updateChart({chartId: 'chart1', ...});` |
| `getChartRef(chartId)` | Get chart reference | ChartRef | `const ref = api.getChartRef('chart1');` |
| `getChartModels()` | Get all chart models | ChartModel[] | `const charts = api.getChartModels();` |
| `restoreChart(model)` | Restore chart from model | ChartRef | `api.restoreChart(savedModel);` |
| `getChartImageDataURL(chartId)` | Get chart as image (base64) | string | `const url = api.getChartImageDataURL('chart1');` |
| `downloadChart(chartId)` | Download chart as image | void | `api.downloadChart('chart1');` |
| `openChartToolPanel()` | Open chart tool panel | void | `api.openChartToolPanel();` |
| `closeChartToolPanel()` | Close chart tool panel | void | `api.closeChartToolPanel();` |

---

### 22. Find (Search)

#### Find Operations

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `findNext()` | Go to next search match | void | `api.findNext();` |
| `findPrevious()` | Go to previous match | void | `api.findPrevious();` |
| `findGetTotalMatches()` | Get total matches | number | `const total = api.findGetTotalMatches();` |
| `findGoTo(match, force?)` | Go to specific match | void | `api.findGoTo(1);` |
| `findClearActive()` | Clear current match | void | `api.findClearActive();` |
| `findGetActiveMatch()` | Get current match index | number | `const index = api.findGetActiveMatch();` |
| `findGetNumMatches(cell)` | Get matches in cell | number | `const count = api.findGetNumMatches(cell);` |
| `findGetParts(cell)` | Get match parts in cell | FindPart[] | `const parts = api.findGetParts(cell);` |
| `findRefresh()` | Re-run search | void | `api.findRefresh();` |

---

### 23. Overlays

#### Overlay Control

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `showNoRowsOverlay()` | Show "no rows" message | void | `api.showNoRowsOverlay();` |
| `hideOverlay()` | Hide overlay | void | `api.hideOverlay();` |

---

### 24. Batch Editing

#### Batch Edit Control

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `startBatchEdit()` | Start batch edit mode | void | `api.startBatchEdit();` |
| `commitBatchEdit()` | Save batch edits | void | `api.commitBatchEdit();` |
| `cancelBatchEdit()` | Discard batch edits | void | `api.cancelBatchEdit();` |
| `isBatchEditing()` | Check batch edit active | boolean | `if (api.isBatchEditing()) { /* editing */ }` |

---

### 25. Miscellaneous

#### Value Cache

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `getCellValue(params)` | Get cell value (formatted or raw) | any | `const val = api.getCellValue({rowIndex: 0, colKey: 'name'});` |
| `expireValueCache()` | Clear value cache | void | `api.expireValueCache();` |

#### Row Drag & Drop

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `addRowDropZone(zone)` | Add external drop zone | void | `api.addRowDropZone(dropZoneElement);` |
| `removeRowDropZone(zone)` | Remove drop zone | void | `api.removeRowDropZone(zone);` |
| `getRowDropZoneParams()` | Get params for another grid | RowDropZoneParams | `const params = api.getRowDropZoneParams();` |
| `setRowDropPositionIndicator(rowNode)` | Highlight drop target | void | `api.setRowDropPositionIndicator(targetNode);` |
| `getRowDropPositionIndicator()` | Get highlighted row | RowNode | `const target = api.getRowDropPositionIndicator();` |

#### Column Hover

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `isColumnHovered(col)` | Check if column hovered | boolean | `const hovered = api.isColumnHovered(column);` |

#### Module Check

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `isModuleRegistered(name)` | Check if module loaded | boolean | `if (api.isModuleRegistered('rowSelection')) { /* available */ }` |

#### ARIA Attributes

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `setGridAriaProperty(property, value)` | Set ARIA attribute | void | `api.setGridAriaProperty('label', 'Data Table');` |

#### Undo/Redo

| Method | Purpose | Returns | Example |
|--------|---------|---------|---------|
| `undoCellEditing()` | Undo last edit | void | `api.undoCellEditing();` |
| `redoCellEditing()` | Redo last undone edit | void | `api.redoCellEditing();` |
| `getCurrentUndoSize()` | Get undo operations available | number | `const size = api.getCurrentUndoSize();` |
| `getCurrentRedoSize()` | Get redo operations available | number | `const size = api.getCurrentRedoSize();` |

---

## Common Use Cases

### Get All Data

```typescript
// Get all data (including filtered)
const allData = [];
this.gridApi.forEachNodeAfterFilterAndSort(node => {
  allData.push(node.data);
});

// Get selected data
const selectedData = this.gridApi.getSelectedRows();
```

### Save & Restore Grid State

```typescript
// Save state
const state = this.gridApi.getState();
localStorage.setItem('gridState', JSON.stringify(state));

// Restore state
const savedState = JSON.parse(localStorage.getItem('gridState'));
if (savedState) {
  this.gridApi.setState(savedState);
}
```

### Export Data

```typescript
// Export as CSV
this.gridApi.exportDataAsCsv({fileName: 'data.csv'});

// Export as Excel
this.gridApi.exportDataAsExcel({fileName: 'data.xlsx'});

// Get as string for custom processing
const csv = this.gridApi.getDataAsCsv();
const excel = await this.gridApi.getDataAsExcel();
```

### Auto-fit Columns

```typescript
// Fit to grid width
this.gridApi.sizeColumnsToFit();

// Auto-size to content
this.gridApi.autoSizeAllColumns();

// Auto-size specific columns
this.gridApi.autoSizeColumns(['name', 'email']);
```

### Add/Update/Remove Rows Dynamically

```typescript
// Add new rows
this.gridApi.applyTransaction({
  add: [newRow1, newRow2]
});

// Update rows
this.gridApi.applyTransaction({
  update: [updatedRow1, updatedRow2]
});

// Remove rows
this.gridApi.applyTransaction({
  remove: [rowToDelete1, rowToDelete2]
});
```

---

## Notes

- All methods are available in **AG Grid Community Edition v34.2.0+**
- No enterprise license required for core Grid API
- For TypeScript, interfaces and type definitions are included
- All async operations return Promises where applicable
- Event listeners are automatically removed when grid is destroyed
- Module-specific methods require their module to be registered

---

## References

- [Official AG Grid API Reference](https://www.ag-grid.com/angular-data-grid/grid-api/)
- [AG Grid Getting Started Guide](https://www.ag-grid.com/documentation/)
- [AG Grid Angular Integration](https://www.ag-grid.com/angular-data-grid/)
