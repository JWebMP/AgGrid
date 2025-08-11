package com.jwebmp.plugins.aggrid.options;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.plugins.aggrid.options.enums.AutoSizeStrategy;
import com.jwebmp.plugins.aggrid.options.enums.RowSelectionMode;

import java.util.ArrayList;
import java.util.List;

/**
 * The options for AG Grid
 *
 * @author YourName
 * @since 2023
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgGridOptions<J extends AgGridOptions<J>> extends JavaScriptPart<J>
{
    /**
     * The column definitions
     */
    @JsonProperty("columnDefs")
    private List<AgGridColumnDef<?>> columnDefs;

    /**
     * The row data
     */
    @JsonProperty("rowData")
    private List<Object> rowData;

    /**
     * Optional raw rowData binding expression (TypeScript/Angular expression).
     * When provided, the grid will bind [rowData] to this expression directly,
     * instead of using the serialized Java list above.
     */
    @JsonProperty("rowDataRaw")
    private String rowDataRaw;

    /**
     * Whether to enable pagination
     */
    @JsonProperty("pagination")
    private Boolean pagination;

    /**
     * The page size for pagination
     */
    @JsonProperty("paginationPageSize")
    private Integer paginationPageSize;

    /**
     * Row selection options
     */
    @JsonProperty("rowSelection")
    private RowSelectionOptions<?> rowSelection;

    /**
     * Default column definition applied to all columns
     */
    @JsonProperty("defaultColDef")
    private AgGridColumnDef<?> defaultColDef;

    /**
     * Whether to enable column resizing
     */
    @JsonProperty("resizable")
    private Boolean resizable;

    /**
     * Whether to enable sorting
     */
    @JsonProperty("sortable")
    private Boolean sortable;

    /**
     * Whether to enable filtering
     */
    @JsonProperty("filter")
    private Boolean filter;

    /**
     * Whether to enable column moving
     */
    @JsonProperty("movable")
    private Boolean movable;
    
    /**
     * The height in pixels for the row containing the column label header
     */
    @JsonProperty("headerHeight")
    private Integer headerHeight;
    
    /**
     * The height in pixels for the rows containing header column groups
     */
    @JsonProperty("groupHeaderHeight")
    private Integer groupHeaderHeight;
    
    /**
     * The height in pixels for the row containing the floating filters
     */
    @JsonProperty("floatingFiltersHeight")
    private Integer floatingFiltersHeight;
    
    /**
     * The height in pixels for the row containing the columns when in pivot mode
     */
    @JsonProperty("pivotHeaderHeight")
    private Integer pivotHeaderHeight;
    
    /**
     * The height in pixels for the row containing header column groups when in pivot mode
     */
    @JsonProperty("pivotGroupHeaderHeight")
    private Integer pivotGroupHeaderHeight;
    
    /**
     * Whether to automatically adjust header height based on content
     */
    @JsonProperty("autoHeaderHeight")
    private Boolean autoHeaderHeight;
    
    /**
     * Whether to hide any column header rows that would only contain padded groups
     */
    @JsonProperty("hidePaddedHeaderRows")
    private Boolean hidePaddedHeaderRows;
    
    /**
     * Default column group definition (properties applied to all column groups)
     */
    @JsonProperty("defaultColGroupDef")
    private AgGridColumnDef<?> defaultColGroupDef;
    
    /**
     * Whether to suppress column move animation
     */
    @JsonProperty("suppressColumnMoveAnimation")
    private Boolean suppressColumnMoveAnimation;
    
    /**
     * Whether to suppress columns being hidden when dragged outside the grid
     */
    @JsonProperty("suppressDragLeaveHidesColumns")
    private Boolean suppressDragLeaveHidesColumns;
    
    /**
     * Whether to suppress column movement while dragging
     */
    @JsonProperty("suppressMoveWhenColumnDragging")
    private Boolean suppressMoveWhenColumnDragging;
    
    /**
     * Whether to allow dragging columns from the columns tool panel
     */
    @JsonProperty("allowDragFromColumnsToolPanel")
    private Boolean allowDragFromColumnsToolPanel;
    
    /**
     * Function to process columns being removed from pinned sections when viewport is too small
     */
    @JsonProperty("processUnpinnedColumns")
    private String processUnpinnedColumns;
    
    /**
     * Auto-size strategy for columns
     */
    @JsonProperty("autoSizeStrategy")
    private AutoSizeStrategy autoSizeStrategy;
    
    /**
     * Default column resize behavior
     * Can be 'normal' or 'shift'
     */
    @JsonProperty("colResizeDefault")
    private String colResizeDefault;
    
    /**
     * Whether to skip the header when auto-sizing columns
     */
    @JsonProperty("skipHeaderOnAutoSize")
    private Boolean skipHeaderOnAutoSize;
    
    /**
     * Whether to suppress column virtualization
     */
    @JsonProperty("suppressColumnVirtualisation")
    private Boolean suppressColumnVirtualisation;
    
    /**
     * Configuration for the selection column
     */
    @JsonProperty("selectionColumnDef")
    private AgGridColumnDef<?> selectionColumnDef;
    
    /**
     * Callback to determine if a row should be rendered as a full width row
     */
    @JsonProperty("isFullWidthRow")
    private String isFullWidthRow;
    
    /**
     * Cell renderer to use for full width rows
     */
    @JsonProperty("fullWidthCellRenderer")
    private String fullWidthCellRenderer;
    
    /**
     * Whether to embed full width rows in the same container as regular rows
     * When true, full width rows will scroll horizontally with the grid
     */
    @JsonProperty("embedFullWidthRows")
    private Boolean embedFullWidthRows;

    /**
     * Default constructor
     */
    public AgGridOptions()
    {
        // Default constructor
    }

    /**
     * Gets the column definitions
     *
     * @return The column definitions
     */
    public List<AgGridColumnDef<?>> getColumnDefs()
    {
        if (columnDefs == null)
        {
            columnDefs = new ArrayList<>();
        }
        return columnDefs;
    }

    /**
     * Sets the column definitions
     *
     * @param columnDefs The column definitions
     * @return This object
     */
    public J setColumnDefs(List<AgGridColumnDef<?>> columnDefs)
    {
        this.columnDefs = columnDefs;
        return (J) this;
    }

    /**
     * Gets the row data
     *
     * @return The row data
     */
    public List<Object> getRowData()
    {
        if (rowData == null)
        {
            rowData = new ArrayList<Object>();
        }
        return rowData;
    }

    /**
     * Sets the row data
     *
     * @param rowData The row data
     * @return This object
     */
    public J setRowData(List<Object> rowData)
    {
        this.rowData = rowData;
        return (J) this;
    }

    /**
     * Gets the raw rowData binding expression.
     * When non-null/non-empty, this expression will be used for [rowData] binding.
     */
    public String getRowDataRaw()
    {
        return rowDataRaw;
    }

    /**
     * Sets the raw rowData binding expression.
     * Provide a valid TypeScript expression (e.g., myRows, this.dataRows, someMethod()).
     * If set, the grid will bind [rowData] to this expression and will not emit a local rowData array.
     *
     * @param rowDataRaw The raw expression to bind.
     * @return This object
     */
    public J setRowDataRaw(String rowDataRaw)
    {
        this.rowDataRaw = rowDataRaw;
        return (J) this;
    }

    /**
     * Gets whether pagination is enabled
     *
     * @return Whether pagination is enabled
     */
    public Boolean getPagination()
    {
        return pagination;
    }

    /**
     * Sets whether pagination is enabled
     *
     * @param pagination Whether pagination is enabled
     * @return This object
     */
    public J setPagination(Boolean pagination)
    {
        this.pagination = pagination;
        return (J) this;
    }

    /**
     * Gets the page size for pagination
     *
     * @return The page size for pagination
     */
    public Integer getPaginationPageSize()
    {
        return paginationPageSize;
    }

    /**
     * Sets the page size for pagination
     *
     * @param paginationPageSize The page size for pagination
     * @return This object
     */
    public J setPaginationPageSize(Integer paginationPageSize)
    {
        this.paginationPageSize = paginationPageSize;
        return (J) this;
    }

    /**
     * Gets the row selection options
     *
     * @return The row selection options
     */
    public RowSelectionOptions<?> getRowSelection()
    {
        return rowSelection;
    }

    public AgGridColumnDef<?> getDefaultColDef()
    {
        return defaultColDef;
    }

    public J setDefaultColDef(AgGridColumnDef<?> defaultColDef)
    {
        this.defaultColDef = defaultColDef;
        return (J) this;
    }

    /**
     * Sets the row selection options
     *
     * @param rowSelection The row selection options
     * @return This object
     */
    public J setRowSelection(RowSelectionOptions<?> rowSelection)
    {
        this.rowSelection = rowSelection;
        return (J) this;
    }
    
    /**
     * Sets the row selection mode
     *
     * @param mode The row selection mode
     * @return This object
     */
    public J setRowSelectionMode(RowSelectionMode mode)
    {
        if (this.rowSelection == null)
        {
            this.rowSelection = new RowSelectionOptions<>();
        }
        this.rowSelection.setMode(mode);
        return (J) this;
    }

    /**
     * Gets whether columns are resizable
     *
     * @return Whether columns are resizable
     */
    public Boolean getResizable()
    {
        return resizable;
    }

    /**
     * Sets whether columns are resizable
     *
     * @param resizable Whether columns are resizable
     * @return This object
     */
    public J setResizable(Boolean resizable)
    {
        this.resizable = resizable;
        return (J) this;
    }

    /**
     * Gets whether columns are sortable
     *
     * @return Whether columns are sortable
     */
    public Boolean getSortable()
    {
        return sortable;
    }

    /**
     * Sets whether columns are sortable
     *
     * @param sortable Whether columns are sortable
     * @return This object
     */
    public J setSortable(Boolean sortable)
    {
        this.sortable = sortable;
        return (J) this;
    }

    /**
     * Gets whether filtering is enabled
     *
     * @return Whether filtering is enabled
     */
    public Boolean getFilter()
    {
        return filter;
    }

    /**
     * Sets whether filtering is enabled
     *
     * @param filter Whether filtering is enabled
     * @return This object
     */
    public J setFilter(Boolean filter)
    {
        this.filter = filter;
        return (J) this;
    }

    /**
     * Gets whether columns are movable
     *
     * @return Whether columns are movable
     */
    public Boolean getMovable()
    {
        return movable;
    }

    /**
     * Sets whether columns are movable
     *
     * @param movable Whether columns are movable
     * @return This object
     */
    public J setMovable(Boolean movable)
    {
        this.movable = movable;
        return (J) this;
    }
    
    /**
     * Gets the header height in pixels
     *
     * @return The header height
     */
    public Integer getHeaderHeight()
    {
        return headerHeight;
    }

    /**
     * Sets the header height in pixels
     *
     * @param headerHeight The header height
     * @return This object
     */
    public J setHeaderHeight(Integer headerHeight)
    {
        this.headerHeight = headerHeight;
        return (J) this;
    }

    /**
     * Gets the group header height in pixels
     *
     * @return The group header height
     */
    public Integer getGroupHeaderHeight()
    {
        return groupHeaderHeight;
    }

    /**
     * Sets the group header height in pixels
     *
     * @param groupHeaderHeight The group header height
     * @return This object
     */
    public J setGroupHeaderHeight(Integer groupHeaderHeight)
    {
        this.groupHeaderHeight = groupHeaderHeight;
        return (J) this;
    }

    /**
     * Gets the floating filters height in pixels
     *
     * @return The floating filters height
     */
    public Integer getFloatingFiltersHeight()
    {
        return floatingFiltersHeight;
    }

    /**
     * Sets the floating filters height in pixels
     *
     * @param floatingFiltersHeight The floating filters height
     * @return This object
     */
    public J setFloatingFiltersHeight(Integer floatingFiltersHeight)
    {
        this.floatingFiltersHeight = floatingFiltersHeight;
        return (J) this;
    }

    /**
     * Gets the pivot header height in pixels
     *
     * @return The pivot header height
     */
    public Integer getPivotHeaderHeight()
    {
        return pivotHeaderHeight;
    }

    /**
     * Sets the pivot header height in pixels
     *
     * @param pivotHeaderHeight The pivot header height
     * @return This object
     */
    public J setPivotHeaderHeight(Integer pivotHeaderHeight)
    {
        this.pivotHeaderHeight = pivotHeaderHeight;
        return (J) this;
    }

    /**
     * Gets the pivot group header height in pixels
     *
     * @return The pivot group header height
     */
    public Integer getPivotGroupHeaderHeight()
    {
        return pivotGroupHeaderHeight;
    }

    /**
     * Sets the pivot group header height in pixels
     *
     * @param pivotGroupHeaderHeight The pivot group header height
     * @return This object
     */
    public J setPivotGroupHeaderHeight(Integer pivotGroupHeaderHeight)
    {
        this.pivotGroupHeaderHeight = pivotGroupHeaderHeight;
        return (J) this;
    }

    /**
     * Gets whether to automatically adjust header height based on content
     *
     * @return Whether to automatically adjust header height
     */
    public Boolean getAutoHeaderHeight()
    {
        return autoHeaderHeight;
    }

    /**
     * Sets whether to automatically adjust header height based on content
     *
     * @param autoHeaderHeight Whether to automatically adjust header height
     * @return This object
     */
    public J setAutoHeaderHeight(Boolean autoHeaderHeight)
    {
        this.autoHeaderHeight = autoHeaderHeight;
        return (J) this;
    }

    /**
     * Gets whether to hide padded header rows
     *
     * @return Whether to hide padded header rows
     */
    public Boolean getHidePaddedHeaderRows()
    {
        return hidePaddedHeaderRows;
    }

    /**
     * Sets whether to hide padded header rows
     *
     * @param hidePaddedHeaderRows Whether to hide padded header rows
     * @return This object
     */
    public J setHidePaddedHeaderRows(Boolean hidePaddedHeaderRows)
    {
        this.hidePaddedHeaderRows = hidePaddedHeaderRows;
        return (J) this;
    }
    
    /**
     * Gets the default column group definition
     *
     * @return The default column group definition
     */
    public AgGridColumnDef<?> getDefaultColGroupDef()
    {
        return defaultColGroupDef;
    }

    /**
     * Sets the default column group definition
     *
     * @param defaultColGroupDef The default column group definition
     * @return This object
     */
    public J setDefaultColGroupDef(AgGridColumnDef<?> defaultColGroupDef)
    {
        this.defaultColGroupDef = defaultColGroupDef;
        return (J) this;
    }
    
    /**
     * Gets whether to suppress column move animation
     *
     * @return Whether to suppress column move animation
     */
    public Boolean getSuppressColumnMoveAnimation()
    {
        return suppressColumnMoveAnimation;
    }

    /**
     * Sets whether to suppress column move animation
     *
     * @param suppressColumnMoveAnimation Whether to suppress column move animation
     * @return This object
     */
    public J setSuppressColumnMoveAnimation(Boolean suppressColumnMoveAnimation)
    {
        this.suppressColumnMoveAnimation = suppressColumnMoveAnimation;
        return (J) this;
    }

    /**
     * Gets whether to suppress columns being hidden when dragged outside the grid
     *
     * @return Whether to suppress columns being hidden when dragged outside the grid
     */
    public Boolean getSuppressDragLeaveHidesColumns()
    {
        return suppressDragLeaveHidesColumns;
    }

    /**
     * Sets whether to suppress columns being hidden when dragged outside the grid
     *
     * @param suppressDragLeaveHidesColumns Whether to suppress columns being hidden when dragged outside the grid
     * @return This object
     */
    public J setSuppressDragLeaveHidesColumns(Boolean suppressDragLeaveHidesColumns)
    {
        this.suppressDragLeaveHidesColumns = suppressDragLeaveHidesColumns;
        return (J) this;
    }

    /**
     * Gets whether to suppress column movement while dragging
     *
     * @return Whether to suppress column movement while dragging
     */
    public Boolean getSuppressMoveWhenColumnDragging()
    {
        return suppressMoveWhenColumnDragging;
    }

    /**
     * Sets whether to suppress column movement while dragging
     *
     * @param suppressMoveWhenColumnDragging Whether to suppress column movement while dragging
     * @return This object
     */
    public J setSuppressMoveWhenColumnDragging(Boolean suppressMoveWhenColumnDragging)
    {
        this.suppressMoveWhenColumnDragging = suppressMoveWhenColumnDragging;
        return (J) this;
    }

    /**
     * Gets whether to allow dragging columns from the columns tool panel
     *
     * @return Whether to allow dragging columns from the columns tool panel
     */
    public Boolean getAllowDragFromColumnsToolPanel()
    {
        return allowDragFromColumnsToolPanel;
    }

    /**
     * Sets whether to allow dragging columns from the columns tool panel
     *
     * @param allowDragFromColumnsToolPanel Whether to allow dragging columns from the columns tool panel
     * @return This object
     */
    public J setAllowDragFromColumnsToolPanel(Boolean allowDragFromColumnsToolPanel)
    {
        this.allowDragFromColumnsToolPanel = allowDragFromColumnsToolPanel;
        return (J) this;
    }
    
    /**
     * Gets the function to process columns being removed from pinned sections when viewport is too small
     *
     * @return The function to process columns being removed from pinned sections
     */
    public String getProcessUnpinnedColumns()
    {
        return processUnpinnedColumns;
    }

    /**
     * Sets the function to process columns being removed from pinned sections when viewport is too small
     *
     * @param processUnpinnedColumns The function to process columns being removed from pinned sections
     * @return This object
     */
    public J setProcessUnpinnedColumns(String processUnpinnedColumns)
    {
        this.processUnpinnedColumns = processUnpinnedColumns;
        return (J) this;
    }
    
    /**
     * Gets the auto-size strategy for columns
     *
     * @return The auto-size strategy for columns
     */
    public AutoSizeStrategy getAutoSizeStrategy()
    {
        return autoSizeStrategy;
    }

    /**
     * Sets the auto-size strategy for columns
     *
     * @param autoSizeStrategy The auto-size strategy for columns
     * @return This object
     */
    public J setAutoSizeStrategy(AutoSizeStrategy autoSizeStrategy)
    {
        this.autoSizeStrategy = autoSizeStrategy;
        return (J) this;
    }

    /**
     * Gets the default column resize behavior
     *
     * @return The default column resize behavior
     */
    public String getColResizeDefault()
    {
        return colResizeDefault;
    }

    /**
     * Sets the default column resize behavior
     *
     * @param colResizeDefault The default column resize behavior ('normal' or 'shift')
     * @return This object
     */
    public J setColResizeDefault(String colResizeDefault)
    {
        this.colResizeDefault = colResizeDefault;
        return (J) this;
    }

    /**
     * Gets whether to skip the header when auto-sizing columns
     *
     * @return Whether to skip the header when auto-sizing columns
     */
    public Boolean getSkipHeaderOnAutoSize()
    {
        return skipHeaderOnAutoSize;
    }

    /**
     * Sets whether to skip the header when auto-sizing columns
     *
     * @param skipHeaderOnAutoSize Whether to skip the header when auto-sizing columns
     * @return This object
     */
    public J setSkipHeaderOnAutoSize(Boolean skipHeaderOnAutoSize)
    {
        this.skipHeaderOnAutoSize = skipHeaderOnAutoSize;
        return (J) this;
    }

    /**
     * Gets whether to suppress column virtualization
     *
     * @return Whether to suppress column virtualization
     */
    public Boolean getSuppressColumnVirtualisation()
    {
        return suppressColumnVirtualisation;
    }

    /**
     * Sets whether to suppress column virtualization
     *
     * @param suppressColumnVirtualisation Whether to suppress column virtualization
     * @return This object
     */
    public J setSuppressColumnVirtualisation(Boolean suppressColumnVirtualisation)
    {
        this.suppressColumnVirtualisation = suppressColumnVirtualisation;
        return (J) this;
    }
    
    /**
     * Gets the configuration for the selection column
     *
     * @return The selection column configuration
     */
    public AgGridColumnDef<?> getSelectionColumnDef()
    {
        return selectionColumnDef;
    }

    /**
     * Sets the configuration for the selection column
     *
     * @param selectionColumnDef The selection column configuration
     * @return This object
     */
    public J setSelectionColumnDef(AgGridColumnDef<?> selectionColumnDef)
    {
        this.selectionColumnDef = selectionColumnDef;
        return (J) this;
    }
    
    /**
     * Gets the callback to determine if a row should be rendered as a full width row
     *
     * @return The callback function as a string
     */
    public String getIsFullWidthRow()
    {
        return isFullWidthRow;
    }

    /**
     * Sets the callback to determine if a row should be rendered as a full width row
     *
     * @param isFullWidthRow The callback function as a string
     * @return This object
     */
    public J setIsFullWidthRow(String isFullWidthRow)
    {
        this.isFullWidthRow = isFullWidthRow;
        return (J) this;
    }

    /**
     * Gets the cell renderer to use for full width rows
     *
     * @return The cell renderer name
     */
    public String getFullWidthCellRenderer()
    {
        return fullWidthCellRenderer;
    }

    /**
     * Sets the cell renderer to use for full width rows
     *
     * @param fullWidthCellRenderer The cell renderer name
     * @return This object
     */
    public J setFullWidthCellRenderer(String fullWidthCellRenderer)
    {
        this.fullWidthCellRenderer = fullWidthCellRenderer;
        return (J) this;
    }
    
    /**
     * Sets the cell renderer to use for full width rows using a class name
     *
     * @param fullWidthCellRendererClassName The cell renderer class name
     * @return This object
     */
    public J setFullWidthCellRendererClassName(String fullWidthCellRendererClassName)
    {
        this.fullWidthCellRenderer = fullWidthCellRendererClassName;
        return (J) this;
    }
    
    /**
     * Sets the cell renderer to use for full width rows using a class that implements INgComponent
     *
     * @param fullWidthCellRendererClass The cell renderer component class
     * @return This object
     */
    public J setFullWidthCellRenderer(Class<? extends INgComponent<?>> fullWidthCellRendererClass)
    {
        this.fullWidthCellRenderer = fullWidthCellRendererClass.getSimpleName();
        return (J) this;
    }
    
    /**
     * Gets whether to embed full width rows in the same container as regular rows
     *
     * @return Whether to embed full width rows
     */
    public Boolean getEmbedFullWidthRows()
    {
        return embedFullWidthRows;
    }

    /**
     * Sets whether to embed full width rows in the same container as regular rows
     * When true, full width rows will scroll horizontally with the grid
     *
     * @param embedFullWidthRows Whether to embed full width rows
     * @return This object
     */
    public J setEmbedFullWidthRows(Boolean embedFullWidthRows)
    {
        this.embedFullWidthRows = embedFullWidthRows;
        return (J) this;
    }
}
