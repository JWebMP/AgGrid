package com.jwebmp.plugins.aggrid.options;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.util.RawValue;
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
     * The column definitions - as presented in the html and ts component
     */
    //@JsonProperty("columnDefs")
    @JsonIgnore
    private List<AgGridColumnDef<?>> columnDefs;

    /**
     * The row data
     * <p>
     * This is placed on the HTML tag
     */
    @JsonIgnore
    private Object rowData;

    /**
     * Optional raw rowData binding expression (TypeScript/Angular expression).
     * When provided, the grid will bind [rowData] to this expression directly,
     * instead of using the serialized Java list above.
     */
    @JsonIgnore
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
     * Row height in pixels for all rows
     */
    @JsonProperty("rowHeight")
    private Integer rowHeight;

    /**
     * Row selection options
     */
    @JsonProperty("rowSelection")
    private RowSelectionOptions<?> rowSelection;

    /**
     * Default column definition applied to all columns
     */
    @JsonProperty("defaultColDef")
    private AgGridColumnDef<?> defaultColDef = new AgGridColumnDef<>();

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
     * Function to process columns being removed from pinned sections when viewport is too small
     * Serialized as raw JavaScript.
     */
    @JsonProperty("processUnpinnedColumns")
    @JsonRawValue
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
     * Serialized as raw JavaScript.
     */
    @JsonProperty("isFullWidthRow")
    @JsonRawValue
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
     * Raw JavaScript callback invoked after a cell's value changes.
     * Signature: params => void
     * Common usage: re-apply filtering after edits: params.api.onFilterChanged();
     */
    @JsonProperty("onCellValueChanged")
    @JsonRawValue
    private String onCellValueChanged;

    /**
     * Enable Tree Data mode so rows form hierarchies with parent/child relationships.
     */
    @JsonProperty("treeData")
    private Boolean treeData;

    /**
     * Raw JavaScript function used by Tree Data to extract the path for each row.
     * Signature: (data) => string[]
     */
    @JsonProperty("getDataPath")
    @JsonRawValue
    private String getDataPath;

    /**
     * Auto Group Column Definition used when grouping/tree data is enabled. Allows applying filters (incl. Set Filter) on the group column.
     */
    @JsonProperty("autoGroupColumnDef")
    private AgGridColumnDef<?> autoGroupColumnDef;

    /**
     * Locale text customisations for grid UI (e.g., searchOoo, noMatches).
     */
    @JsonProperty("localeText")
    private com.jwebmp.plugins.aggrid.options.locale.ILocaleText<?> localeText;

    /**
     * Enable Filter Handlers so Multi Filter buttons control child filters.
     */
    @JsonProperty("enableFilterHandlers")
    private Boolean enableFilterHandlers;

    /**
     * Fired before a Fill Handle operation starts.
     * Signature: (event) => void
     */
    @JsonProperty("onFillStart")
    @JsonRawValue
    private String onFillStart;

    /**
     * Fired after a Fill Handle operation ends.
     * Signature: (event) => void
     */
    @JsonProperty("onFillEnd")
    @JsonRawValue
    private String onFillEnd;

    /**
     * Default constructor
     */
    public AgGridOptions()
    {
        // Default constructor
    }

    /**
     * When true, recently changed cells will flash to highlight updates.
     */
    @JsonProperty("enableCellChangeFlash")
    private Boolean enableCellChangeFlash;

    // ===== Rendering options =====
    /**
     * Set to false to disable row animation which is enabled by default.
     */
    @JsonProperty("animateRows")
    private Boolean animateRows;

    /**
     * Duration in milliseconds that a cell remains in the flashed state after changes.
     * If 0, the cell will not flash.
     */
    @JsonProperty("cellFlashDuration")
    private Integer cellFlashDuration;

    /**
     * Duration in milliseconds for the fade-out of the flashed state.
     */
    @JsonProperty("cellFadeDuration")
    private Integer cellFadeDuration;

    /**
     * When true, allow cells to flash even when the change was caused by filtering.
     * Default is false.
     */
    @JsonProperty("allowShowChangeAfterFilter")
    private Boolean allowShowChangeAfterFilter;

    // ===== Clipboard options =====
    /**
     * Include headers when copying to clipboard.
     */
    @JsonProperty("copyHeadersToClipboard")
    private Boolean copyHeadersToClipboard;

    /**
     * Include group headers when copying to clipboard.
     */
    @JsonProperty("copyGroupHeadersToClipboard")
    private Boolean copyGroupHeadersToClipboard;

    /**
     * Delimiter used when copying to clipboard (default '\t').
     */
    @JsonProperty("clipboardDelimiter")
    private String clipboardDelimiter;

    /**
     * Block cut operations within the grid.
     */
    @JsonProperty("suppressCutToClipboard")
    private Boolean suppressCutToClipboard;

    /**
     * Workaround for Excel extra last empty line on paste.
     */
    @JsonProperty("suppressLastEmptyLineOnPaste")
    private Boolean suppressLastEmptyLineOnPaste;

    /**
     * Turn off paste operations within the grid.
     */
    @JsonProperty("suppressClipboardPaste")
    private Boolean suppressClipboardPaste;

    /**
     * Prevent the grid using the Clipboard API and fallback immediately.
     */
    @JsonProperty("suppressClipboardApi")
    private Boolean suppressClipboardApi;

    /**
     * Process cell value before copying to clipboard. Raw JS function string.
     */
    @JsonProperty("processCellForClipboard")
    @JsonRawValue
    private String processCellForClipboard;

    /**
     * Process header value before copying to clipboard. Raw JS function string.
     */
    @JsonProperty("processHeaderForClipboard")
    @JsonRawValue
    private String processHeaderForClipboard;

    /**
     * Process group header value before copying. Raw JS function string.
     */
    @JsonProperty("processGroupHeaderForClipboard")
    @JsonRawValue
    private String processGroupHeaderForClipboard;

    /**
     * Process cell values from clipboard. Raw JS function string.
     */
    @JsonProperty("processCellFromClipboard")
    @JsonRawValue
    private String processCellFromClipboard;

    /**
     * Intercept the data that would go to the clipboard. Raw JS function string.
     */
    @JsonProperty("sendToClipboard")
    @JsonRawValue
    private String sendToClipboard;

    /**
     * Full control of paste operation. Raw JS function string.
     */
    @JsonProperty("processDataFromClipboard")
    @JsonRawValue
    private String processDataFromClipboard;

    // ===== Column Moving toggles =====
    /**
     * Set to true to suppress column moving via drag.
     */
    @JsonProperty("suppressMovableColumns")
    private Boolean suppressMovableColumns;


    // ===== Tooltips =====
    /**
     * Use browser default tooltips instead of grid Tooltip Component. (Initial)
     */
    @JsonProperty("enableBrowserTooltips")
    private Boolean enableBrowserTooltips;

    // ===== Scrolling =====
    /**
     * Always show the horizontal scrollbar.
     */
    @JsonProperty("alwaysShowHorizontalScroll")
    private Boolean alwaysShowHorizontalScroll;

    /**
     * Always show the vertical scrollbar.
     */
    @JsonProperty("alwaysShowVerticalScroll")
    private Boolean alwaysShowVerticalScroll;

    /**
     * Debounce the vertical scrollbar for smoother scrolling on slow machines. (Initial)
     */
    @JsonProperty("debounceVerticalScrollbar")
    private Boolean debounceVerticalScrollbar;

    /**
     * Never show the horizontal scroll.
     */
    @JsonProperty("suppressHorizontalScroll")
    private Boolean suppressHorizontalScroll;

    /**
     * Do not scroll to top when new row data is provided.
     */
    @JsonProperty("suppressScrollOnNewData")
    private Boolean suppressScrollOnNewData;

    /**
     * Do not allow mousewheel/touchpad scroll when popup elements are present.
     */
    @JsonProperty("suppressScrollWhenPopupsAreOpen")
    private Boolean suppressScrollWhenPopupsAreOpen;

    /**
     * If true, middle clicks will result in click events for cells and rows.
     */
    @JsonProperty("suppressMiddleClickScrolls")
    private Boolean suppressMiddleClickScrolls;

    /**
     * Pass mouse wheel events to the browser instead of preventing default. (Initial)
     */
    @JsonProperty("suppressPreventDefaultOnMouseWheel")
    private Boolean suppressPreventDefaultOnMouseWheel;

    /**
     * Width in pixels of scrollbar for width calculations (non-standard scrollbars). (Initial)
     */
    @JsonProperty("scrollbarWidth")
    private Integer scrollbarWidth;

    /**
     * Delay in ms before showing tooltips.
     */
    @JsonProperty("tooltipShowDelay")
    private Integer tooltipShowDelay;

    /**
     * Delay in ms before hiding tooltips.
     */
    @JsonProperty("tooltipHideDelay")
    private Integer tooltipHideDelay;

    /**
     * Have tooltips follow the cursor once displayed. (Initial)
     */
    @JsonProperty("tooltipMouseTrack")
    private Boolean tooltipMouseTrack;

    /**
     * When to show tooltips: 'standard' | 'whenTruncated'.
     */
    @JsonProperty("tooltipShowMode")
    private String tooltipShowMode;

    /**
     * Tooltip trigger: 'hover' | 'focus'. (Initial)
     */
    @JsonProperty("tooltipTrigger")
    private String tooltipTrigger;

    /**
     * Enable tooltip interaction (keeps tooltip open on hover/focus). (Initial)
     */
    @JsonProperty("tooltipInteraction")
    private Boolean tooltipInteraction;

    // ===== Sorting options =====
    /**
     * Take accented characters into account when sorting.
     */
    @JsonProperty("accentedSort")
    private Boolean accentedSort;

    /**
     * Suppress multi-sort when user holds multiSortKey.
     */
    @JsonProperty("suppressMultiSort")
    private Boolean suppressMultiSort;

    /**
     * Always apply multi-sort regardless of key presses.
     */
    @JsonProperty("alwaysMultiSort")
    private Boolean alwaysMultiSort;

    /**
     * The key required for multi-sort (e.g. 'ctrl').
     */
    @JsonProperty("multiSortKey")
    private String multiSortKey;

    /**
     * Suppress maintaining original order for unsorted data.
     */
    @JsonProperty("suppressMaintainUnsortedOrder")
    private Boolean suppressMaintainUnsortedOrder;

    /**
     * Perform additional sorting after grid sort. Raw JS function.
     */
    @JsonProperty("postSortRows")
    @JsonRawValue
    private String postSortRows;

    /**
     * Enable delta sorting (sort only updated rows for transactions).
     */
    @JsonProperty("deltaSort")
    private Boolean deltaSort;

    // ===== Selection options (community) =====
    /**
     * If true, grid cells won't be focusable (disables keyboard nav for cells).
     */
    @JsonProperty("suppressCellFocus")
    private Boolean suppressCellFocus;

    /**
     * If true, header cells won't be focusable.
     */
    @JsonProperty("suppressHeaderFocus")
    private Boolean suppressHeaderFocus;

    /**
     * Allow selecting text within cells (disables clipboard copy behaviour).
     */
    @JsonProperty("enableCellTextSelection")
    private Boolean enableCellTextSelection;

    // ----- Sorting getters/setters -----
    public Boolean getAccentedSort() {return accentedSort;}

    public J setAccentedSort(Boolean accentedSort)
    {
        this.accentedSort = accentedSort;
        return (J) this;
    }

    public Boolean getSuppressMultiSort() {return suppressMultiSort;}

    public J setSuppressMultiSort(Boolean suppressMultiSort)
    {
        this.suppressMultiSort = suppressMultiSort;
        return (J) this;
    }

    public Boolean getAlwaysMultiSort() {return alwaysMultiSort;}

    public J setAlwaysMultiSort(Boolean alwaysMultiSort)
    {
        this.alwaysMultiSort = alwaysMultiSort;
        return (J) this;
    }

    public String getMultiSortKey() {return multiSortKey;}

    public J setMultiSortKey(String multiSortKey)
    {
        this.multiSortKey = multiSortKey;
        return (J) this;
    }

    public J setMultiSortKey(MultiSortKey key)
    {
        this.multiSortKey = key == null ? null : key.getJson();
        return (J) this;
    }

    public Boolean getSuppressMaintainUnsortedOrder() {return suppressMaintainUnsortedOrder;}

    public J setSuppressMaintainUnsortedOrder(Boolean suppressMaintainUnsortedOrder)
    {
        this.suppressMaintainUnsortedOrder = suppressMaintainUnsortedOrder;
        return (J) this;
    }

    public String getPostSortRows() {return postSortRows;}

    /**
     * Set the postSortRows callback using a raw JavaScript function or arrow function.
     * Example: "nodes => nodes.sort((a,b)=>a.data.order-b.data.order)".
     * The value is serialized without quotes.
     */
    public J setPostSortRowsRaw(String postSortRowsRawJs)
    {
        this.postSortRows = postSortRowsRawJs;
        return (J) this;
    }

    public Boolean getDeltaSort() {return deltaSort;}

    public J setDeltaSort(Boolean deltaSort)
    {
        this.deltaSort = deltaSort;
        return (J) this;
    }

    // ----- Selection getters/setters -----
    public Boolean getSuppressCellFocus() {return suppressCellFocus;}

    public J setSuppressCellFocus(Boolean suppressCellFocus)
    {
        this.suppressCellFocus = suppressCellFocus;
        return (J) this;
    }

    public Boolean getSuppressHeaderFocus() {return suppressHeaderFocus;}

    public J setSuppressHeaderFocus(Boolean suppressHeaderFocus)
    {
        this.suppressHeaderFocus = suppressHeaderFocus;
        return (J) this;
    }

    public Boolean getEnableCellTextSelection() {return enableCellTextSelection;}

    public J setEnableCellTextSelection(Boolean enableCellTextSelection)
    {
        this.enableCellTextSelection = enableCellTextSelection;
        return (J) this;
    }


    /**
     * Get locale text customisations object.
     */
    public com.jwebmp.plugins.aggrid.options.locale.ILocaleText<?> getLocaleText()
    {
        return localeText;
    }

    /**
     * Set locale text customisations object.
     */
    public J setLocaleText(com.jwebmp.plugins.aggrid.options.locale.ILocaleText<?> localeText)
    {
        this.localeText = localeText;
        return (J) this;
    }

    /**
     * Get whether Filter Handlers are enabled.
     */
    public Boolean getEnableFilterHandlers()
    {
        return enableFilterHandlers;
    }

    /**
     * Enable/disable Filter Handlers so Multi Filter buttons control child filters.
     */
    public J setEnableFilterHandlers(Boolean enableFilterHandlers)
    {
        this.enableFilterHandlers = enableFilterHandlers;
        return (J) this;
    }

    /**
     * Get raw JavaScript onFillStart callback.
     */
    public String getOnFillStart()
    {
        return onFillStart;
    }

    /**
     * Set the onFillStart callback as raw JavaScript.
     * Example: "e => console.log('fill start', e)".
     */
    public J setOnFillStartRaw(String onFillStartRawJs)
    {
        this.onFillStart = onFillStartRawJs;
        return (J) this;
    }

    /**
     * Get raw JavaScript onFillEnd callback.
     */
    public String getOnFillEnd()
    {
        return onFillEnd;
    }

    /**
     * Set the onFillEnd callback as raw JavaScript.
     * Example: "e => console.log('fill end', e)".
     */
    public J setOnFillEndRaw(String onFillEndRawJs)
    {
        this.onFillEnd = onFillEndRawJs;
        return (J) this;
    }

    /**
     * Convenience: set Mini Filter placeholder text (searchOoo). Creates LocaleText if needed.
     */
    public J setLocaleSearchOoo(String searchOoo)
    {
        if (this.localeText == null)
        {
            this.localeText = new com.jwebmp.plugins.aggrid.options.locale.LocaleText();
        }
        // Safe cast because we only need to call the interface method
        this.localeText.setSearchOoo(searchOoo);
        return (J) this;
    }

    /**
     * Convenience: set Mini Filter no matches message. Creates LocaleText if needed.
     */
    public J setLocaleNoMatches(String noMatches)
    {
        if (this.localeText == null)
        {
            this.localeText = new com.jwebmp.plugins.aggrid.options.locale.LocaleText();
        }
        this.localeText.setNoMatches(noMatches);
        return (J) this;
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
        if (rowData instanceof List)
        {
            return (List<Object>) rowData;
        }
        return null;
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
        if (rowDataRaw != null && !rowDataRaw.isBlank())
        {
            this.rowData = new RawValue(rowDataRaw);
        }
        else
        {
            this.rowData = null;
        }
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
     * Gets the row height in pixels for all rows
     *
     * @return The row height in pixels
     */
    public Integer getRowHeight()
    {
        return rowHeight;
    }

    /**
     * Sets the row height in pixels for all rows
     *
     * @param rowHeight The row height in pixels (e.g., 50)
     * @return This object
     */
    public J setRowHeight(Integer rowHeight)
    {
        this.rowHeight = rowHeight;
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
        if (defaultColDef == null)
        {
            defaultColDef = new AgGridColumnDef<>();
        }
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
     * Convenience overload to set row selection using a string mode: 'single' | 'multiple'.
     * This maps to RowSelectionMode enum values.
     */
    public J setRowSelection(String mode)
    {
        if (this.rowSelection == null)
        {
            this.rowSelection = new RowSelectionOptions<>();
        }
        if (mode == null)
        {
            this.rowSelection.setMode(null);
            return (J) this;
        }
        String m = mode.trim()
                       .toLowerCase();
        if ("single".equals(m))
        {
            this.rowSelection.setMode(RowSelectionMode.SINGLE);
        }
        else if ("multiple".equals(m))
        {
            this.rowSelection.setMode(RowSelectionMode.MULTIPLE);
        }
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

    /**
     * Get the raw JavaScript onCellValueChanged callback.
     */
    public String getOnCellValueChanged()
    {
        return onCellValueChanged;
    }

    /**
     * Set the onCellValueChanged callback using a raw JavaScript function or arrow function.
     * Example: "params => { params.api.onFilterChanged(); }"
     * The value is serialized without quotes.
     */
    public J setOnCellValueChangedRaw(String onCellValueChangedRawJs)
    {
        this.onCellValueChanged = onCellValueChangedRawJs;
        return (J) this;
    }

    /**
     * Convenience: enable re-applying filters automatically after cell edits.
     * This sets onCellValueChanged to call params.api.onFilterChanged().
     */
    public J enableReapplyFiltersOnCellValueChanged()
    {
        this.onCellValueChanged = "params => { params.api.onFilterChanged(); }";
        return (J) this;
    }

    /**
     * Get whether Tree Data mode is enabled.
     */
    public Boolean getTreeData()
    {
        return treeData;
    }

    /**
     * Enable/disable Tree Data mode.
     */
    public J setTreeData(Boolean treeData)
    {
        this.treeData = treeData;
        return (J) this;
    }

    /**
     * Get the raw JavaScript getDataPath callback used by Tree Data.
     */
    public String getGetDataPath()
    {
        return getDataPath;
    }

    /**
     * Set the getDataPath callback using a raw JavaScript function or arrow function.
     * Example: "(data) => data.path"
     */
    public J setGetDataPathRaw(String getDataPathRawJs)
    {
        this.getDataPath = getDataPathRawJs;
        return (J) this;
    }

    /**
     * Get the auto group column definition.
     */
    public AgGridColumnDef<?> getAutoGroupColumnDef()
    {
        if (autoGroupColumnDef == null)
        {
            autoGroupColumnDef = new AgGridColumnDef<>();
        }
        return autoGroupColumnDef;
    }

    /**
     * Set the auto group column definition used when grouping/tree data is enabled.
     */
    public J setAutoGroupColumnDef(AgGridColumnDef<?> autoGroupColumnDef)
    {
        this.autoGroupColumnDef = autoGroupColumnDef;
        return (J) this;
    }

    /**
     * @return whether cell change flash is enabled at grid level
     */
    public Boolean getEnableCellChangeFlash()
    {
        return enableCellChangeFlash;
    }

    /**
     * Enable/disable cell flash on value changes at grid level.
     */
    public J setEnableCellChangeFlash(Boolean enableCellChangeFlash)
    {
        this.enableCellChangeFlash = enableCellChangeFlash;
        return (J) this;
    }

    // ----- Rendering getters/setters -----

    /**
     * @return whether row animation is enabled
     */
    public Boolean getAnimateRows()
    {
        return animateRows;
    }

    /**
     * Enable/disable row animation (true by default in AG Grid).
     */
    public J setAnimateRows(Boolean animateRows)
    {
        this.animateRows = animateRows;
        return (J) this;
    }

    /**
     * @return the cell flash duration in milliseconds
     */
    public Integer getCellFlashDuration()
    {
        return cellFlashDuration;
    }

    /**
     * Sets the duration a cell remains in flashed state after changes.
     */
    public J setCellFlashDuration(Integer cellFlashDuration)
    {
        this.cellFlashDuration = cellFlashDuration;
        return (J) this;
    }

    /**
     * @return the cell fade duration in milliseconds
     */
    public Integer getCellFadeDuration()
    {
        return cellFadeDuration;
    }

    /**
     * Sets the fade-out duration for the flashed cell state.
     */
    public J setCellFadeDuration(Integer cellFadeDuration)
    {
        this.cellFadeDuration = cellFadeDuration;
        return (J) this;
    }

    /**
     * @return whether flashing is allowed for changes due to filtering
     */
    public Boolean getAllowShowChangeAfterFilter()
    {
        return allowShowChangeAfterFilter;
    }

    /**
     * Allow cells to flash even when change is caused by filtering (default false).
     */
    public J setAllowShowChangeAfterFilter(Boolean allowShowChangeAfterFilter)
    {
        this.allowShowChangeAfterFilter = allowShowChangeAfterFilter;
        return (J) this;
    }

    // ----- Clipboard getters/setters -----

    public Boolean getCopyHeadersToClipboard()
    {
        return copyHeadersToClipboard;
    }

    public J setCopyHeadersToClipboard(Boolean copyHeadersToClipboard)
    {
        this.copyHeadersToClipboard = copyHeadersToClipboard;
        return (J) this;
    }

    public Boolean getCopyGroupHeadersToClipboard()
    {
        return copyGroupHeadersToClipboard;
    }

    public J setCopyGroupHeadersToClipboard(Boolean copyGroupHeadersToClipboard)
    {
        this.copyGroupHeadersToClipboard = copyGroupHeadersToClipboard;
        return (J) this;
    }

    public String getClipboardDelimiter()
    {
        return clipboardDelimiter;
    }

    public J setClipboardDelimiter(String clipboardDelimiter)
    {
        this.clipboardDelimiter = clipboardDelimiter;
        return (J) this;
    }

    public Boolean getSuppressCutToClipboard()
    {
        return suppressCutToClipboard;
    }

    public J setSuppressCutToClipboard(Boolean suppressCutToClipboard)
    {
        this.suppressCutToClipboard = suppressCutToClipboard;
        return (J) this;
    }

    public Boolean getSuppressLastEmptyLineOnPaste()
    {
        return suppressLastEmptyLineOnPaste;
    }

    public J setSuppressLastEmptyLineOnPaste(Boolean suppressLastEmptyLineOnPaste)
    {
        this.suppressLastEmptyLineOnPaste = suppressLastEmptyLineOnPaste;
        return (J) this;
    }

    public Boolean getSuppressClipboardPaste()
    {
        return suppressClipboardPaste;
    }

    public J setSuppressClipboardPaste(Boolean suppressClipboardPaste)
    {
        this.suppressClipboardPaste = suppressClipboardPaste;
        return (J) this;
    }

    public Boolean getSuppressClipboardApi()
    {
        return suppressClipboardApi;
    }

    public J setSuppressClipboardApi(Boolean suppressClipboardApi)
    {
        this.suppressClipboardApi = suppressClipboardApi;
        return (J) this;
    }

    public String getProcessCellForClipboard()
    {
        return processCellForClipboard;
    }

    public J setProcessCellForClipboardRaw(String processCellForClipboard)
    {
        this.processCellForClipboard = processCellForClipboard;
        return (J) this;
    }

    public String getProcessHeaderForClipboard()
    {
        return processHeaderForClipboard;
    }

    public J setProcessHeaderForClipboardRaw(String processHeaderForClipboard)
    {
        this.processHeaderForClipboard = processHeaderForClipboard;
        return (J) this;
    }

    public String getProcessGroupHeaderForClipboard()
    {
        return processGroupHeaderForClipboard;
    }

    public J setProcessGroupHeaderForClipboardRaw(String processGroupHeaderForClipboard)
    {
        this.processGroupHeaderForClipboard = processGroupHeaderForClipboard;
        return (J) this;
    }

    public String getProcessCellFromClipboard()
    {
        return processCellFromClipboard;
    }

    public J setProcessCellFromClipboardRaw(String processCellFromClipboard)
    {
        this.processCellFromClipboard = processCellFromClipboard;
        return (J) this;
    }

    public String getSendToClipboard()
    {
        return sendToClipboard;
    }

    public J setSendToClipboardRaw(String sendToClipboard)
    {
        this.sendToClipboard = sendToClipboard;
        return (J) this;
    }

    public String getProcessDataFromClipboard()
    {
        return processDataFromClipboard;
    }

    public J setProcessDataFromClipboardRaw(String processDataFromClipboard)
    {
        this.processDataFromClipboard = processDataFromClipboard;
        return (J) this;
    }

    // ----- Column Moving toggles getters/setters -----

    public Boolean getSuppressMovableColumns()
    {
        return suppressMovableColumns;
    }

    public J setSuppressMovableColumns(Boolean suppressMovableColumns)
    {
        this.suppressMovableColumns = suppressMovableColumns;
        return (J) this;
    }

    // ----- Tooltip enums -----
    public enum TooltipShowMode
    {
        STANDARD("standard"),
        WHEN_TRUNCATED("whenTruncated");
        private final String json;

        TooltipShowMode(String json) {this.json = json;}

        public String getJson() {return json;}

        @Override
        public String toString() {return json;}
    }

    public enum TooltipTrigger
    {
        HOVER("hover"),
        FOCUS("focus");
        private final String json;

        TooltipTrigger(String json) {this.json = json;}

        public String getJson() {return json;}

        @Override
        public String toString() {return json;}
    }

    // ----- Sorting enums -----
    public enum MultiSortKey
    {
        CTRL("ctrl");
        private final String json;

        MultiSortKey(String json) {this.json = json;}

        public String getJson() {return json;}

        @Override
        public String toString() {return json;}
    }

    // ----- Tooltip getters/setters -----

    // Scrolling getters/setters
    public Boolean getAlwaysShowHorizontalScroll() {return alwaysShowHorizontalScroll;}

    public J setAlwaysShowHorizontalScroll(Boolean v)
    {
        this.alwaysShowHorizontalScroll = v;
        return (J) this;
    }

    public Boolean getAlwaysShowVerticalScroll() {return alwaysShowVerticalScroll;}

    public J setAlwaysShowVerticalScroll(Boolean v)
    {
        this.alwaysShowVerticalScroll = v;
        return (J) this;
    }

    public Boolean getDebounceVerticalScrollbar() {return debounceVerticalScrollbar;}

    public J setDebounceVerticalScrollbar(Boolean v)
    {
        this.debounceVerticalScrollbar = v;
        return (J) this;
    }

    public Boolean getSuppressHorizontalScroll() {return suppressHorizontalScroll;}

    public J setSuppressHorizontalScroll(Boolean v)
    {
        this.suppressHorizontalScroll = v;
        return (J) this;
    }

    public Boolean getSuppressScrollOnNewData() {return suppressScrollOnNewData;}

    public J setSuppressScrollOnNewData(Boolean v)
    {
        this.suppressScrollOnNewData = v;
        return (J) this;
    }

    public Boolean getSuppressScrollWhenPopupsAreOpen() {return suppressScrollWhenPopupsAreOpen;}

    public J setSuppressScrollWhenPopupsAreOpen(Boolean v)
    {
        this.suppressScrollWhenPopupsAreOpen = v;
        return (J) this;
    }

    public Boolean getSuppressMiddleClickScrolls() {return suppressMiddleClickScrolls;}

    public J setSuppressMiddleClickScrolls(Boolean v)
    {
        this.suppressMiddleClickScrolls = v;
        return (J) this;
    }

    public Boolean getSuppressPreventDefaultOnMouseWheel() {return suppressPreventDefaultOnMouseWheel;}

    public J setSuppressPreventDefaultOnMouseWheel(Boolean v)
    {
        this.suppressPreventDefaultOnMouseWheel = v;
        return (J) this;
    }

    public Integer getScrollbarWidth() {return scrollbarWidth;}

    public J setScrollbarWidth(Integer v)
    {
        this.scrollbarWidth = v;
        return (J) this;
    }

    public Boolean getEnableBrowserTooltips()
    {
        return enableBrowserTooltips;
    }

    public J setEnableBrowserTooltips(Boolean enableBrowserTooltips)
    {
        this.enableBrowserTooltips = enableBrowserTooltips;
        return (J) this;
    }

    public Integer getTooltipShowDelay()
    {
        return tooltipShowDelay;
    }

    public J setTooltipShowDelay(Integer tooltipShowDelay)
    {
        this.tooltipShowDelay = tooltipShowDelay;
        return (J) this;
    }

    public Integer getTooltipHideDelay()
    {
        return tooltipHideDelay;
    }

    public J setTooltipHideDelay(Integer tooltipHideDelay)
    {
        this.tooltipHideDelay = tooltipHideDelay;
        return (J) this;
    }

    public Boolean getTooltipMouseTrack()
    {
        return tooltipMouseTrack;
    }

    public J setTooltipMouseTrack(Boolean tooltipMouseTrack)
    {
        this.tooltipMouseTrack = tooltipMouseTrack;
        return (J) this;
    }

    public String getTooltipShowMode()
    {
        return tooltipShowMode;
    }

    public J setTooltipShowMode(String tooltipShowMode)
    {
        this.tooltipShowMode = tooltipShowMode;
        return (J) this;
    }

    public J setTooltipShowMode(TooltipShowMode mode)
    {
        this.tooltipShowMode = mode == null ? null : mode.getJson();
        return (J) this;
    }

    public String getTooltipTrigger()
    {
        return tooltipTrigger;
    }

    public J setTooltipTrigger(String tooltipTrigger)
    {
        this.tooltipTrigger = tooltipTrigger;
        return (J) this;
    }

    public J setTooltipTrigger(TooltipTrigger trigger)
    {
        this.tooltipTrigger = trigger == null ? null : trigger.getJson();
        return (J) this;
    }

    public Boolean getTooltipInteraction()
    {
        return tooltipInteraction;
    }

    public J setTooltipInteraction(Boolean tooltipInteraction)
    {
        this.tooltipInteraction = tooltipInteraction;
        return (J) this;
    }

    // Column Menu display type: 'legacy' | 'new'
    public enum ColumnMenuType
    {
        LEGACY("legacy"),
        NEW("new");
        private final String json;

        ColumnMenuType(String json) {this.json = json;}

        public String getJson() {return json;}

        @Override
        public String toString() {return json;}
    }

    @JsonProperty("columnMenu")
    private String columnMenu;

    public String getColumnMenu() {return columnMenu;}

    public J setColumnMenu(String columnMenu)
    {
        this.columnMenu = columnMenu;
        return (J) this;
    }

    public J setColumnMenu(ColumnMenuType type)
    {
        this.columnMenu = type == null ? null : type.getJson();
        return (J) this;
    }

    // Dom layout type: 'normal' | 'autoHeight' | 'print'
    public enum DomLayoutType
    {
        NORMAL("normal"),
        AUTO_HEIGHT("autoHeight"),
        PRINT("print");
        private final String json;

        DomLayoutType(String json) {this.json = json;}

        public String getJson() {return json;}

        @Override
        public String toString() {return json;}
    }

    @JsonProperty("domLayout")
    private String domLayout;

    public String getDomLayout() {return domLayout;}

    public J setDomLayout(String domLayout)
    {
        this.domLayout = domLayout;
        return (J) this;
    }

    public J setDomLayout(DomLayoutType type)
    {
        this.domLayout = type == null ? null : type.getJson();
        return (J) this;
    }

    // ===== Pagination (community) =====
    @JsonProperty("paginationAutoPageSize")
    private Boolean paginationAutoPageSize;

    @JsonProperty("paginateChildRows")
    private Boolean paginateChildRows;

    @JsonProperty("suppressPaginationPanel")
    private Boolean suppressPaginationPanel;

    // boolean | number[]
    @JsonProperty("paginationPageSizeSelector")
    private Object paginationPageSizeSelector;

    // Raw JS: (params) => string
    @JsonProperty("paginationNumberFormatter")
    @JsonRawValue
    private String paginationNumberFormatter;

    public Boolean getPaginationAutoPageSize() {return paginationAutoPageSize;}

    public J setPaginationAutoPageSize(Boolean v)
    {
        this.paginationAutoPageSize = v;
        return (J) this;
    }

    public Boolean getPaginateChildRows() {return paginateChildRows;}

    public J setPaginateChildRows(Boolean v)
    {
        this.paginateChildRows = v;
        return (J) this;
    }

    public Boolean getSuppressPaginationPanel() {return suppressPaginationPanel;}

    public J setSuppressPaginationPanel(Boolean v)
    {
        this.suppressPaginationPanel = v;
        return (J) this;
    }

    public Object getPaginationPageSizeSelector() {return paginationPageSizeSelector;}

    public J setPaginationPageSizeSelector(Boolean show)
    {
        this.paginationPageSizeSelector = show;
        return (J) this;
    }

    public J setPaginationPageSizeSelector(int[] values)
    {
        this.paginationPageSizeSelector = values;
        return (J) this;
    }

    /**
     * Convenience overload accepting a List<Integer> of page sizes.
     */
    public J setPaginationPageSizeSelector(java.util.List<Integer> values)
    {
        this.paginationPageSizeSelector = values;
        return (J) this;
    }

    public String getPaginationNumberFormatter() {return paginationNumberFormatter;}

    /**
     * Set the paginationNumberFormatter callback using raw JavaScript.
     * Example: "params => `${params.value.toLocaleString()}`"
     */
    public J setPaginationNumberFormatterRaw(String rawJs)
    {
        this.paginationNumberFormatter = rawJs;
        return (J) this;
    }

    // ===== Row Pinning (community) =====
    // boolean | 'top' | 'bottom'
    @JsonProperty("enableRowPinning")
    private Object enableRowPinning;

    // Is the row pinnable? Raw JS: (params) => boolean
    @JsonProperty("isRowPinnable")
    @JsonRawValue
    private String isRowPinnable;

    // Initial pin position for a row. Raw JS: (params) => 'top' | 'bottom' | null
    @JsonProperty("isRowPinned")
    @JsonRawValue
    private String isRowPinned;

    @JsonProperty("pinnedTopRowData")
    private java.util.List<Object> pinnedTopRowData;

    @JsonProperty("pinnedBottomRowData")
    private java.util.List<Object> pinnedBottomRowData;

    // Typed enum for pin position convenience
    public enum RowPinPosition
    {
        TOP("top"),
        BOTTOM("bottom");
        private final String json;

        RowPinPosition(String json) {this.json = json;}

        public String getJson() {return json;}

        @Override
        public String toString() {return json;}
    }

    public Object getEnableRowPinning() {return enableRowPinning;}

    public J setEnableRowPinning(Boolean v)
    {
        this.enableRowPinning = v;
        return (J) this;
    }

    public J setEnableRowPinning(String position)
    {
        this.enableRowPinning = position;
        return (J) this;
    }

    public J setEnableRowPinning(RowPinPosition pos)
    {
        this.enableRowPinning = pos == null ? null : pos.getJson();
        return (J) this;
    }

    public String getIsRowPinnable() {return isRowPinnable;}

    public J setIsRowPinnableRaw(String rawJs)
    {
        this.isRowPinnable = rawJs;
        return (J) this;
    }

    public String getIsRowPinned() {return isRowPinned;}

    public J setIsRowPinnedRaw(String rawJs)
    {
        this.isRowPinned = rawJs;
        return (J) this;
    }

    public java.util.List<Object> getPinnedTopRowData() {return pinnedTopRowData;}

    public J setPinnedTopRowData(java.util.List<Object> data)
    {
        this.pinnedTopRowData = data;
        return (J) this;
    }

    public java.util.List<Object> getPinnedBottomRowData() {return pinnedBottomRowData;}

    public J setPinnedBottomRowData(java.util.List<Object> data)
    {
        this.pinnedBottomRowData = data;
        return (J) this;
    }

    // ===== Overlays (community) =====
    /**
     * Show or hide the loading overlay.
     */
    @JsonProperty("loading")
    private Boolean loading;

    /**
     * Provide HTML string to override the default loading overlay.
     */
    @JsonProperty("overlayLoadingTemplate")
    private String overlayLoadingTemplate;

    /**
     * Custom loading overlay component (Initial).
     */
    @JsonProperty("loadingOverlayComponent")
    private Object loadingOverlayComponent;

    /**
     * Parameters provided to the custom loading overlay component.
     */
    @JsonProperty("loadingOverlayComponentParams")
    private Object loadingOverlayComponentParams;

    /**
     * Prevent the no-rows overlay when there is no data (Initial).
     */
    @JsonProperty("suppressNoRowsOverlay")
    private Boolean suppressNoRowsOverlay;

    /**
     * Provide HTML string to override the default no-rows overlay.
     */
    @JsonProperty("overlayNoRowsTemplate")
    private String overlayNoRowsTemplate;

    /**
     * Custom no-rows overlay component (Initial).
     */
    @JsonProperty("noRowsOverlayComponent")
    private Object noRowsOverlayComponent;

    /**
     * Parameters provided to the custom no-rows overlay component.
     */
    @JsonProperty("noRowsOverlayComponentParams")
    private Object noRowsOverlayComponentParams;

    // Overlays getters/setters
    public Boolean getLoading() {return loading;}

    public J setLoading(Boolean loading)
    {
        this.loading = loading;
        return (J) this;
    }

    public String getOverlayLoadingTemplate() {return overlayLoadingTemplate;}

    public J setOverlayLoadingTemplate(String overlayLoadingTemplate)
    {
        this.overlayLoadingTemplate = overlayLoadingTemplate;
        return (J) this;
    }

    public Object getLoadingOverlayComponent() {return loadingOverlayComponent;}

    public J setLoadingOverlayComponent(Object loadingOverlayComponent)
    {
        this.loadingOverlayComponent = loadingOverlayComponent;
        return (J) this;
    }

    public Object getLoadingOverlayComponentParams() {return loadingOverlayComponentParams;}

    public J setLoadingOverlayComponentParams(Object loadingOverlayComponentParams)
    {
        this.loadingOverlayComponentParams = loadingOverlayComponentParams;
        return (J) this;
    }

    public Boolean getSuppressNoRowsOverlay() {return suppressNoRowsOverlay;}

    public J setSuppressNoRowsOverlay(Boolean suppressNoRowsOverlay)
    {
        this.suppressNoRowsOverlay = suppressNoRowsOverlay;
        return (J) this;
    }

    public String getOverlayNoRowsTemplate() {return overlayNoRowsTemplate;}

    public J setOverlayNoRowsTemplate(String overlayNoRowsTemplate)
    {
        this.overlayNoRowsTemplate = overlayNoRowsTemplate;
        return (J) this;
    }

    public Object getNoRowsOverlayComponent() {return noRowsOverlayComponent;}

    public J setNoRowsOverlayComponent(Object noRowsOverlayComponent)
    {
        this.noRowsOverlayComponent = noRowsOverlayComponent;
        return (J) this;
    }

    public Object getNoRowsOverlayComponentParams() {return noRowsOverlayComponentParams;}

    public J setNoRowsOverlayComponentParams(Object noRowsOverlayComponentParams)
    {
        this.noRowsOverlayComponentParams = noRowsOverlayComponentParams;
        return (J) this;
    }

    // ===== Loading Cell Renderer (community) =====
    /**
     * Provide your own loading cell renderer to use when data is loading or renderer is deferred.
     */
    @JsonProperty("loadingCellRenderer")
    private Object loadingCellRenderer;

    /**
     * Parameters to be passed to the loadingCellRenderer component.
     */
    @JsonProperty("loadingCellRendererParams")
    private Object loadingCellRendererParams;

    /**
     * Callback to select which loading cell renderer to use. Raw JS.
     */
    @JsonProperty("loadingCellRendererSelector")
    @JsonRawValue
    private String loadingCellRendererSelector;

    public Object getLoadingCellRenderer() {return loadingCellRenderer;}

    public J setLoadingCellRenderer(Object loadingCellRenderer)
    {
        this.loadingCellRenderer = loadingCellRenderer;
        return (J) this;
    }

    public Object getLoadingCellRendererParams() {return loadingCellRendererParams;}

    public J setLoadingCellRendererParams(Object loadingCellRendererParams)
    {
        this.loadingCellRendererParams = loadingCellRendererParams;
        return (J) this;
    }

    public String getLoadingCellRendererSelector() {return loadingCellRendererSelector;}

    /**
     * Set loadingCellRendererSelector using raw JS. Example: "params => ({ component: 'MyRenderer' })".
     */
    public J setLoadingCellRendererSelectorRaw(String rawJs)
    {
        this.loadingCellRendererSelector = rawJs;
        return (J) this;
    }

    // ===== Styling (community) =====
    /**
     * Global row style object.
     */
    @JsonProperty("rowStyle")
    private Object rowStyle;

    /**
     * Callback version of rowStyle. Raw JS returning style object.
     */
    @JsonProperty("getRowStyle")
    @JsonRawValue
    private String getRowStyle;

    /**
     * CSS class(es) for all rows (string | string[]).
     */
    @JsonProperty("rowClass")
    private Object rowClass;

    /**
     * Callback to set class(es) for each row. Raw JS returning string | string[].
     */
    @JsonProperty("getRowClass")
    @JsonRawValue
    private String getRowClass;

    /**
     * Rules which can be applied to include certain CSS classes.
     */
    @JsonProperty("rowClassRules")
    private Object rowClassRules;

    /**
     * Do not highlight rows with ag-row-hover on hover.
     */
    @JsonProperty("suppressRowHoverHighlight")
    private Boolean suppressRowHoverHighlight;

    /**
     * Highlight columns by adding ag-column-hover on hover.
     */
    @JsonProperty("columnHoverHighlight")
    private Boolean columnHoverHighlight;

    public Object getRowStyle() {return rowStyle;}

    public J setRowStyle(Object rowStyle)
    {
        this.rowStyle = rowStyle;
        return (J) this;
    }

    public String getGetRowStyle() {return getRowStyle;}

    public J setGetRowStyleRaw(String rawJs)
    {
        this.getRowStyle = rawJs;
        return (J) this;
    }

    public Object getRowClass() {return rowClass;}

    public J setRowClass(Object rowClass)
    {
        this.rowClass = rowClass;
        return (J) this;
    }

    public String getGetRowClass() {return getRowClass;}

    public J setGetRowClassRaw(String rawJs)
    {
        this.getRowClass = rawJs;
        return (J) this;
    }

    public Object getRowClassRules() {return rowClassRules;}

    public J setRowClassRules(Object rowClassRules)
    {
        this.rowClassRules = rowClassRules;
        return (J) this;
    }

    public Boolean getSuppressRowHoverHighlight() {return suppressRowHoverHighlight;}

    public J setSuppressRowHoverHighlight(Boolean suppressRowHoverHighlight)
    {
        this.suppressRowHoverHighlight = suppressRowHoverHighlight;
        return (J) this;
    }

    public Boolean getColumnHoverHighlight() {return columnHoverHighlight;}

    public J setColumnHoverHighlight(Boolean columnHoverHighlight)
    {
        this.columnHoverHighlight = columnHoverHighlight;
        return (J) this;
    }

    // ===== Context Menu (community) =====
    /**
     * Set to true to not show the context menu.
     */
    @JsonProperty("suppressContextMenu")
    private Boolean suppressContextMenu;

    /**
     * When using suppressContextMenu, prevent the browser default context menu.
     */
    @JsonProperty("preventDefaultOnContextMenu")
    private Boolean preventDefaultOnContextMenu;

    /**
     * Allows context menu to show even when Ctrl key is held.
     */
    @JsonProperty("allowContextMenuWithControlKey")
    private Boolean allowContextMenuWithControlKey;

    public Boolean getSuppressContextMenu() {return suppressContextMenu;}

    public J setSuppressContextMenu(Boolean suppressContextMenu)
    {
        this.suppressContextMenu = suppressContextMenu;
        return (J) this;
    }

    public Boolean getPreventDefaultOnContextMenu() {return preventDefaultOnContextMenu;}

    public J setPreventDefaultOnContextMenu(Boolean preventDefaultOnContextMenu)
    {
        this.preventDefaultOnContextMenu = preventDefaultOnContextMenu;
        return (J) this;
    }

    public Boolean getAllowContextMenuWithControlKey() {return allowContextMenuWithControlKey;}

    public J setAllowContextMenuWithControlKey(Boolean allowContextMenuWithControlKey)
    {
        this.allowContextMenuWithControlKey = allowContextMenuWithControlKey;
        return (J) this;
    }

    // ===== Keyboard Navigation (community) =====
    /**
     * Override which element the grid should focus when it receives focus. Raw JS returns boolean.
     */
    @JsonProperty("focusGridInnerElement")
    @JsonRawValue
    private String focusGridInnerElement;

    /**
     * Override header navigation with arrow keys. Raw JS.
     */
    @JsonProperty("navigateToNextHeader")
    @JsonRawValue
    private String navigateToNextHeader;

    /**
     * Override Tab navigation for headers. Raw JS.
     */
    @JsonProperty("tabToNextHeader")
    @JsonRawValue
    private String tabToNextHeader;

    /**
     * Override cell navigation with arrow keys. Raw JS.
     */
    @JsonProperty("navigateToNextCell")
    @JsonRawValue
    private String navigateToNextCell;

    /**
     * Override Tab navigation for cells. Raw JS.
     */
    @JsonProperty("tabToNextCell")
    @JsonRawValue
    private String tabToNextCell;

    public String getFocusGridInnerElement() {return focusGridInnerElement;}

    /**
     * Example: "() => true" to handle focusing yourself.
     */
    public J setFocusGridInnerElementRaw(String rawJs)
    {
        this.focusGridInnerElement = rawJs;
        return (J) this;
    }

    public String getNavigateToNextHeader() {return navigateToNextHeader;}

    public J setNavigateToNextHeaderRaw(String rawJs)
    {
        this.navigateToNextHeader = rawJs;
        return (J) this;
    }

    public String getTabToNextHeader() {return tabToNextHeader;}

    public J setTabToNextHeaderRaw(String rawJs)
    {
        this.tabToNextHeader = rawJs;
        return (J) this;
    }

    public String getNavigateToNextCell() {return navigateToNextCell;}

    public J setNavigateToNextCellRaw(String rawJs)
    {
        this.navigateToNextCell = rawJs;
        return (J) this;
    }

    public String getTabToNextCell() {return tabToNextCell;}

    public J setTabToNextCellRaw(String rawJs)
    {
        this.tabToNextCell = rawJs;
        return (J) this;
    }

    // ===== Misc / Rendering / DOM (community) =====
    /**
     * Enable debug logging from the grid and related components. (Initial)
     */
    @JsonProperty("debug")
    private Boolean debug;

    /**
     * Do not set focus back on the grid after a refresh.
     */
    @JsonProperty("suppressFocusAfterRefresh")
    private Boolean suppressFocusAfterRefresh;

    /**
     * When true, ensure DOM order of rows/columns matches what is on screen (disables row animations). (Initial)
     */
    @JsonProperty("ensureDomOrder")
    private Boolean ensureDomOrder;

    /**
     * Custom gridId accessible via gridApi.getGridId() and set as grid-id attribute on root element. (Initial)
     */
    @JsonProperty("gridId")
    private String gridId;

    /**
     * Callback fired after the row is rendered into the DOM. Should not be used to initiate side effects.
     */
    @JsonProperty("processRowPostCreate")
    @JsonRawValue
    private String processRowPostCreate;

    /**
     * Enable RTL (Right to Left) mode. (Initial)
     */
    @JsonProperty("enableRtl")
    private Boolean enableRtl;

    /**
     * Do not virtualise the rows (render all). (Initial)
     */
    @JsonProperty("suppressRowVirtualisation")
    private Boolean suppressRowVirtualisation;

    /**
     * Remove the max rendered rows restriction. (Initial)
     */
    @JsonProperty("suppressMaxRenderedRowRestriction")
    private Boolean suppressMaxRenderedRowRestriction;

    /**
     * Enable the cell span feature allowing colDef.spanRows. (Initial)
     */
    @JsonProperty("enableCellSpan")
    private Boolean enableCellSpan;

    /**
     * Number of rows rendered outside the viewable area to render as buffer.
     */
    @JsonProperty("rowBuffer")
    private Integer rowBuffer;

    public Boolean getDebug() {return debug;}

    public J setDebug(Boolean debug)
    {
        this.debug = debug;
        return (J) this;
    }

    public Boolean getSuppressFocusAfterRefresh() {return suppressFocusAfterRefresh;}

    public J setSuppressFocusAfterRefresh(Boolean suppressFocusAfterRefresh)
    {
        this.suppressFocusAfterRefresh = suppressFocusAfterRefresh;
        return (J) this;
    }

    public Boolean getEnsureDomOrder() {return ensureDomOrder;}

    public J setEnsureDomOrder(Boolean ensureDomOrder)
    {
        this.ensureDomOrder = ensureDomOrder;
        return (J) this;
    }

    public String getGridId() {return gridId;}

    public J setGridId(String gridId)
    {
        this.gridId = gridId;
        return (J) this;
    }

    public String getProcessRowPostCreate() {return processRowPostCreate;}

    /**
     * Set raw JS: e.g., "params => { console.log('row created'); }"
     */
    public J setProcessRowPostCreateRaw(String rawJs)
    {
        this.processRowPostCreate = rawJs;
        return (J) this;
    }

    public Boolean getEnableRtl() {return enableRtl;}

    public J setEnableRtl(Boolean enableRtl)
    {
        this.enableRtl = enableRtl;
        return (J) this;
    }

    public Boolean getSuppressRowVirtualisation() {return suppressRowVirtualisation;}

    public J setSuppressRowVirtualisation(Boolean suppressRowVirtualisation)
    {
        this.suppressRowVirtualisation = suppressRowVirtualisation;
        return (J) this;
    }

    public Boolean getSuppressMaxRenderedRowRestriction() {return suppressMaxRenderedRowRestriction;}

    public J setSuppressMaxRenderedRowRestriction(Boolean suppressMaxRenderedRowRestriction)
    {
        this.suppressMaxRenderedRowRestriction = suppressMaxRenderedRowRestriction;
        return (J) this;
    }

    public Boolean getEnableCellSpan() {return enableCellSpan;}

    public J setEnableCellSpan(Boolean enableCellSpan)
    {
        this.enableCellSpan = enableCellSpan;
        return (J) this;
    }

    public Integer getRowBuffer() {return rowBuffer;}

    public J setRowBuffer(Integer rowBuffer)
    {
        this.rowBuffer = rowBuffer;
        return (J) this;
    }

    // ===== Master Detail (community) =====
    /**
     * Enable Master Detail feature.
     */
    @JsonProperty("masterDetail")
    private Boolean masterDetail;

    /**
     * Determine if a row is a master row. Raw JS callback.
     */
    @JsonProperty("isRowMaster")
    @JsonRawValue
    private String isRowMaster;

    /**
     * Custom Detail Cell Renderer component.
     */
    @JsonProperty("detailCellRenderer")
    private Object detailCellRenderer;

    /**
     * Params for the Detail Cell Renderer (object or function result).
     */
    @JsonProperty("detailCellRendererParams")
    private Object detailCellRendererParams;

    /**
     * Fixed height in pixels for each detail row. (Initial)
     */
    @JsonProperty("detailRowHeight")
    private Integer detailRowHeight;

    /**
     * Dynamically change detail row height to fit its rows. (Initial)
     */
    @JsonProperty("detailRowAutoHeight")
    private Boolean detailRowAutoHeight;

    /**
     * Keep detail rows for when they are shown again. (Initial)
     */
    @JsonProperty("keepDetailRows")
    private Boolean keepDetailRows;

    /**
     * Number of detail rows to keep. (Initial)
     */
    @JsonProperty("keepDetailRowsCount")
    private Integer keepDetailRowsCount;

    public Boolean getMasterDetail() {return masterDetail;}

    public J setMasterDetail(Boolean masterDetail)
    {
        this.masterDetail = masterDetail;
        return (J) this;
    }

    public String getIsRowMaster() {return isRowMaster;}

    /**
     * Set raw JS for isRowMaster, e.g., "params => params.data && params.data.master"
     */
    public J setIsRowMasterRaw(String rawJs)
    {
        this.isRowMaster = rawJs;
        return (J) this;
    }

    public Object getDetailCellRenderer() {return detailCellRenderer;}

    public J setDetailCellRenderer(Object detailCellRenderer)
    {
        this.detailCellRenderer = detailCellRenderer;
        return (J) this;
    }

    public Object getDetailCellRendererParams() {return detailCellRendererParams;}

    public J setDetailCellRendererParams(Object detailCellRendererParams)
    {
        this.detailCellRendererParams = detailCellRendererParams;
        return (J) this;
    }

    public Integer getDetailRowHeight() {return detailRowHeight;}

    public J setDetailRowHeight(Integer detailRowHeight)
    {
        this.detailRowHeight = detailRowHeight;
        return (J) this;
    }

    public Boolean getDetailRowAutoHeight() {return detailRowAutoHeight;}

    public J setDetailRowAutoHeight(Boolean detailRowAutoHeight)
    {
        this.detailRowAutoHeight = detailRowAutoHeight;
        return (J) this;
    }

    public Boolean getKeepDetailRows() {return keepDetailRows;}

    public J setKeepDetailRows(Boolean keepDetailRows)
    {
        this.keepDetailRows = keepDetailRows;
        return (J) this;
    }

    public Integer getKeepDetailRowsCount() {return keepDetailRowsCount;}

    public J setKeepDetailRowsCount(Integer keepDetailRowsCount)
    {
        this.keepDetailRowsCount = keepDetailRowsCount;
        return (J) this;
    }

    // ===== Row Drag & Drop (community) =====
    /**
     * Enable Managed Row Dragging.
     */
    @JsonProperty("rowDragManaged")
    private Boolean rowDragManaged;

    /**
     * Enable clicking and dragging anywhere on the row without a drag handle.
     */
    @JsonProperty("rowDragEntireRow")
    private Boolean rowDragEntireRow;

    /**
     * Enable dragging multiple rows at the same time.
     */
    @JsonProperty("rowDragMultiRow")
    private Boolean rowDragMultiRow;

    /**
     * Suppress row dragging.
     */
    @JsonProperty("suppressRowDrag")
    private Boolean suppressRowDrag;

    /**
     * Suppress moving rows while dragging the waffle.
     */
    @JsonProperty("suppressMoveWhenRowDragging")
    private Boolean suppressMoveWhenRowDragging;

    /**
     * Callback returning the text to display while dragging. Raw JS.
     */
    @JsonProperty("rowDragText")
    @JsonRawValue
    private String rowDragText;

    /**
     * Custom drag and drop image component.
     */
    @JsonProperty("dragAndDropImageComponent")
    private Object dragAndDropImageComponent;

    /**
     * Params for custom drag and drop image component.
     */
    @JsonProperty("dragAndDropImageComponentParams")
    private Object dragAndDropImageComponentParams;

    /**
     * Delay in ms before expanding groups or converting leafs to groups on drag over.
     */
    @JsonProperty("rowDragInsertDelay")
    private Integer rowDragInsertDelay;

    /**
     * Conditionally prevent dropping a dragged row on the hovered row (raw JS).
     */
    @JsonProperty("isRowValidDropPosition")
    @JsonRawValue
    private String isRowValidDropPosition;

    public Boolean getRowDragManaged() {return rowDragManaged;}

    public J setRowDragManaged(Boolean rowDragManaged)
    {
        this.rowDragManaged = rowDragManaged;
        return (J) this;
    }

    public Boolean getRowDragEntireRow() {return rowDragEntireRow;}

    public J setRowDragEntireRow(Boolean rowDragEntireRow)
    {
        this.rowDragEntireRow = rowDragEntireRow;
        return (J) this;
    }

    public Boolean getRowDragMultiRow() {return rowDragMultiRow;}

    public J setRowDragMultiRow(Boolean rowDragMultiRow)
    {
        this.rowDragMultiRow = rowDragMultiRow;
        return (J) this;
    }

    public Boolean getSuppressRowDrag() {return suppressRowDrag;}

    public J setSuppressRowDrag(Boolean suppressRowDrag)
    {
        this.suppressRowDrag = suppressRowDrag;
        return (J) this;
    }

    public Boolean getSuppressMoveWhenRowDragging() {return suppressMoveWhenRowDragging;}

    public J setSuppressMoveWhenRowDragging(Boolean suppressMoveWhenRowDragging)
    {
        this.suppressMoveWhenRowDragging = suppressMoveWhenRowDragging;
        return (J) this;
    }

    public String getRowDragText() {return rowDragText;}

    public J setRowDragTextRaw(String rawJs)
    {
        this.rowDragText = rawJs;
        return (J) this;
    }

    public Object getDragAndDropImageComponent() {return dragAndDropImageComponent;}

    public J setDragAndDropImageComponent(Object dragAndDropImageComponent)
    {
        this.dragAndDropImageComponent = dragAndDropImageComponent;
        return (J) this;
    }

    public Object getDragAndDropImageComponentParams() {return dragAndDropImageComponentParams;}

    public J setDragAndDropImageComponentParams(Object dragAndDropImageComponentParams)
    {
        this.dragAndDropImageComponentParams = dragAndDropImageComponentParams;
        return (J) this;
    }

    public Integer getRowDragInsertDelay() {return rowDragInsertDelay;}

    public J setRowDragInsertDelay(Integer rowDragInsertDelay)
    {
        this.rowDragInsertDelay = rowDragInsertDelay;
        return (J) this;
    }

    public String getIsRowValidDropPosition() {return isRowValidDropPosition;}

    public J setIsRowValidDropPositionRaw(String rawJs)
    {
        this.isRowValidDropPosition = rawJs;
        return (J) this;
    }

    // ===== Theme (community) =====
    /**
     * Theme to apply to the grid, or the string "legacy" to opt back to v32-style CSS themes.
     */
    @JsonProperty("theme")
    private Object theme;

    /**
     * If your theme uses a Google Font, pass true to load it from Google's CDN.
     */
    @JsonProperty("loadThemeGoogleFonts")
    private Boolean loadThemeGoogleFonts;

    /**
     * Element to insert style elements into when injecting styles (defaults to head or grid wrapper). (Initial)
     */
    @JsonProperty("themeStyleContainer")
    private Object themeStyleContainer;

    /**
     * The CSS layer to render the grid styles onto.
     */
    @JsonProperty("themeCssLayer")
    private String themeCssLayer;

    /**
     * CSP nonce to set on style elements added by themes.
     */
    @JsonProperty("styleNonce")
    private String styleNonce;

    public Object getTheme() {return theme;}

    public J setTheme(Object theme)
    {
        this.theme = theme;
        return (J) this;
    }

    public J setTheme(String theme)
    {
        this.theme = theme;
        return (J) this;
    }

    public Boolean getLoadThemeGoogleFonts() {return loadThemeGoogleFonts;}

    public J setLoadThemeGoogleFonts(Boolean loadThemeGoogleFonts)
    {
        this.loadThemeGoogleFonts = loadThemeGoogleFonts;
        return (J) this;
    }

    public Object getThemeStyleContainer() {return themeStyleContainer;}

    public J setThemeStyleContainer(Object themeStyleContainer)
    {
        this.themeStyleContainer = themeStyleContainer;
        return (J) this;
    }

    public String getThemeCssLayer() {return themeCssLayer;}

    public J setThemeCssLayer(String themeCssLayer)
    {
        this.themeCssLayer = themeCssLayer;
        return (J) this;
    }

    public String getStyleNonce() {return styleNonce;}

    public J setStyleNonce(String styleNonce)
    {
        this.styleNonce = styleNonce;
        return (J) this;
    }

    // ===== Row Model: Client-Side (community) =====
    @JsonProperty("asyncTransactionWaitMillis")
    private Integer asyncTransactionWaitMillis;

    @JsonProperty("suppressModelUpdateAfterUpdateTransaction")
    private Boolean suppressModelUpdateAfterUpdateTransaction;

    @JsonProperty("resetRowDataOnUpdate")
    private Boolean resetRowDataOnUpdate;

    public Integer getAsyncTransactionWaitMillis() {return asyncTransactionWaitMillis;}

    public J setAsyncTransactionWaitMillis(Integer millis)
    {
        this.asyncTransactionWaitMillis = millis;
        return (J) this;
    }

    public Boolean getSuppressModelUpdateAfterUpdateTransaction() {return suppressModelUpdateAfterUpdateTransaction;}

    public J setSuppressModelUpdateAfterUpdateTransaction(Boolean v)
    {
        this.suppressModelUpdateAfterUpdateTransaction = v;
        return (J) this;
    }

    public Boolean getResetRowDataOnUpdate() {return resetRowDataOnUpdate;}

    public J setResetRowDataOnUpdate(Boolean v)
    {
        this.resetRowDataOnUpdate = v;
        return (J) this;
    }

    // Immutable Data mode: when true, grid treats rowData as immutable and uses getRowId to track updates.
    @JsonProperty("immutableData")
    private Boolean immutableData;

    public Boolean getImmutableData() {return immutableData;}

    public J setImmutableData(Boolean immutableData)
    {
        this.immutableData = immutableData;
        return (J) this;
    }

    // ===== Row Model: Infinite (community) =====
    @JsonProperty("datasource")
    @JsonRawValue
    private String datasource;

    @JsonProperty("cacheOverflowSize")
    private Integer cacheOverflowSize;

    @JsonProperty("maxConcurrentDatasourceRequests")
    private Integer maxConcurrentDatasourceRequests;

    @JsonProperty("cacheBlockSize")
    private Integer cacheBlockSize;

    @JsonProperty("maxBlocksInCache")
    private Integer maxBlocksInCache;

    @JsonProperty("infiniteInitialRowCount")
    private Integer infiniteInitialRowCount;

    public String getDatasource() {return datasource;}

    public J setDatasourceRaw(String rawJsDatasource)
    {
        this.datasource = rawJsDatasource;
        return (J) this;
    }

    public Integer getCacheOverflowSize() {return cacheOverflowSize;}

    public J setCacheOverflowSize(Integer cacheOverflowSize)
    {
        this.cacheOverflowSize = cacheOverflowSize;
        return (J) this;
    }

    public Integer getMaxConcurrentDatasourceRequests() {return maxConcurrentDatasourceRequests;}

    public J setMaxConcurrentDatasourceRequests(Integer maxConcurrentDatasourceRequests)
    {
        this.maxConcurrentDatasourceRequests = maxConcurrentDatasourceRequests;
        return (J) this;
    }

    public Integer getCacheBlockSize() {return cacheBlockSize;}

    public J setCacheBlockSize(Integer cacheBlockSize)
    {
        this.cacheBlockSize = cacheBlockSize;
        return (J) this;
    }

    public Integer getMaxBlocksInCache() {return maxBlocksInCache;}

    public J setMaxBlocksInCache(Integer maxBlocksInCache)
    {
        this.maxBlocksInCache = maxBlocksInCache;
        return (J) this;
    }

    public Integer getInfiniteInitialRowCount() {return infiniteInitialRowCount;}

    public J setInfiniteInitialRowCount(Integer infiniteInitialRowCount)
    {
        this.infiniteInitialRowCount = infiniteInitialRowCount;
        return (J) this;
    }

    // ===== Row Model: Viewport (community) =====
    @JsonProperty("viewportDatasource")
    @JsonRawValue
    private String viewportDatasource;

    @JsonProperty("viewportRowModelPageSize")
    private Integer viewportRowModelPageSize;

    @JsonProperty("viewportRowModelBufferSize")
    private Integer viewportRowModelBufferSize;

    public String getViewportDatasource() {return viewportDatasource;}

    public J setViewportDatasourceRaw(String rawJsViewportDatasource)
    {
        this.viewportDatasource = rawJsViewportDatasource;
        return (J) this;
    }

    public Integer getViewportRowModelPageSize() {return viewportRowModelPageSize;}

    public J setViewportRowModelPageSize(Integer viewportRowModelPageSize)
    {
        this.viewportRowModelPageSize = viewportRowModelPageSize;
        return (J) this;
    }

    public Integer getViewportRowModelBufferSize() {return viewportRowModelBufferSize;}

    public J setViewportRowModelBufferSize(Integer viewportRowModelBufferSize)
    {
        this.viewportRowModelBufferSize = viewportRowModelBufferSize;
        return (J) this;
    }

    // ===== Column Menu & Popups (community) =====
    @JsonProperty("getMainMenuItems")
    @JsonRawValue
    private String getMainMenuItems;

    @JsonProperty("suppressMenuHide")
    private Boolean suppressMenuHide;

    @JsonProperty("popupParent")
    private Object popupParent;

    @JsonProperty("postProcessPopup")
    @JsonRawValue
    private String postProcessPopup;

    public String getGetMainMenuItems() {return getMainMenuItems;}

    public J setGetMainMenuItemsRaw(String rawJs)
    {
        this.getMainMenuItems = rawJs;
        return (J) this;
    }

    public Boolean getSuppressMenuHide() {return suppressMenuHide;}

    public J setSuppressMenuHide(Boolean suppressMenuHide)
    {
        this.suppressMenuHide = suppressMenuHide;
        return (J) this;
    }

    public Object getPopupParent() {return popupParent;}

    public J setPopupParent(Object popupParent)
    {
        this.popupParent = popupParent;
        return (J) this;
    }

    public String getPostProcessPopup() {return postProcessPopup;}

    public J setPostProcessPopupRaw(String rawJs)
    {
        this.postProcessPopup = rawJs;
        return (J) this;
    }


    // ===== Editing (community) =====
    /**
     * Set to 'fullRow' to enable Full Row Editing. Otherwise leave blank to edit one cell at a time.
     */
    @JsonProperty("editType")
    private String editType;

    /**
     * Validate Full Row Edit; only relevant when editType='fullRow'. Raw JS callback.
     */
    @JsonProperty("getFullRowEditValidationErrors")
    @JsonRawValue
    private String getFullRowEditValidationErrors;

    /**
     * When set, determines invalid edit commit behaviour. E.g., 'block' to block commit.
     */
    @JsonProperty("invalidEditValueMode")
    private String invalidEditValueMode;

    /**
     * Enable Single Click Editing for cells.
     */
    @JsonProperty("singleClickEdit")
    private Boolean singleClickEdit;

    /**
     * So that neither single nor double click starts editing.
     */
    @JsonProperty("suppressClickEdit")
    private Boolean suppressClickEdit;

    /**
     * Stop cell editing when grid loses focus. (Initial)
     */
    @JsonProperty("stopEditingWhenCellsLoseFocus")
    private Boolean stopEditingWhenCellsLoseFocus;

    /**
     * Determine behaviour when navigating with Tab to start edit.
     */
    @JsonProperty("suppressStartEditOnTab")
    private Boolean suppressStartEditOnTab;

    /**
     * Excel-style Enter key navigation.
     */
    @JsonProperty("enterNavigatesVertically")
    private Boolean enterNavigatesVertically;

    /**
     * Excel-style Enter key navigation after edit.
     */
    @JsonProperty("enterNavigatesVerticallyAfterEdit")
    private Boolean enterNavigatesVerticallyAfterEdit;

    /**
     * Forces Cell Editing to start when backspace is pressed (mostly for MacOS users).
     */
    @JsonProperty("enableCellEditingOnBackspace")
    private Boolean enableCellEditingOnBackspace;

    /**
     * Enable Undo / Redo while editing. (Initial)
     */
    @JsonProperty("undoRedoCellEditing")
    private Boolean undoRedoCellEditing;

    /**
     * Size of the undo / redo stack. (Initial, default 10)
     */
    @JsonProperty("undoRedoCellEditingLimit")
    private Integer undoRedoCellEditingLimit;

    /**
     * When true, the grid will not update data after Edit/Clipboard/Fill operations.
     */
    @JsonProperty("readOnlyEdit")
    private Boolean readOnlyEdit;

    // ----- Editing enums -----
    public enum EditType
    {
        FULL_ROW("fullRow");
        private final String json;

        EditType(String j) {this.json = j;}

        public String getJson() {return json;}

        @Override
        public String toString() {return json;}
    }

    public enum EditValidationCommitType
    {
        BLOCK("block");
        private final String json;

        EditValidationCommitType(String j) {this.json = j;}

        public String getJson() {return json;}

        @Override
        public String toString() {return json;}
    }

    // ----- Editing getters/setters -----
    public String getEditType() {return editType;}

    public J setEditType(String v)
    {
        this.editType = v;
        return (J) this;
    }

    public J setEditType(EditType v)
    {
        this.editType = v == null ? null : v.getJson();
        return (J) this;
    }

    public String getGetFullRowEditValidationErrors() {return getFullRowEditValidationErrors;}

    /**
     * Set raw JS: e.g., "(params) => []" returning array of validation errors.
     */
    public J setGetFullRowEditValidationErrorsRaw(String rawJs)
    {
        this.getFullRowEditValidationErrors = rawJs;
        return (J) this;
    }

    public String getInvalidEditValueMode() {return invalidEditValueMode;}

    public J setInvalidEditValueMode(String v)
    {
        this.invalidEditValueMode = v;
        return (J) this;
    }

    public J setInvalidEditValueMode(EditValidationCommitType v)
    {
        this.invalidEditValueMode = v == null ? null : v.getJson();
        return (J) this;
    }

    public Boolean getSingleClickEdit() {return singleClickEdit;}

    public J setSingleClickEdit(Boolean v)
    {
        this.singleClickEdit = v;
        return (J) this;
    }

    public Boolean getSuppressClickEdit() {return suppressClickEdit;}

    public J setSuppressClickEdit(Boolean v)
    {
        this.suppressClickEdit = v;
        return (J) this;
    }

    public Boolean getStopEditingWhenCellsLoseFocus() {return stopEditingWhenCellsLoseFocus;}

    public J setStopEditingWhenCellsLoseFocus(Boolean v)
    {
        this.stopEditingWhenCellsLoseFocus = v;
        return (J) this;
    }

    public Boolean getSuppressStartEditOnTab() {return suppressStartEditOnTab;}

    public J setSuppressStartEditOnTab(Boolean v)
    {
        this.suppressStartEditOnTab = v;
        return (J) this;
    }

    public Boolean getEnterNavigatesVertically() {return enterNavigatesVertically;}

    public J setEnterNavigatesVertically(Boolean v)
    {
        this.enterNavigatesVertically = v;
        return (J) this;
    }

    public Boolean getEnterNavigatesVerticallyAfterEdit() {return enterNavigatesVerticallyAfterEdit;}

    public J setEnterNavigatesVerticallyAfterEdit(Boolean v)
    {
        this.enterNavigatesVerticallyAfterEdit = v;
        return (J) this;
    }

    public Boolean getEnableCellEditingOnBackspace() {return enableCellEditingOnBackspace;}

    public J setEnableCellEditingOnBackspace(Boolean v)
    {
        this.enableCellEditingOnBackspace = v;
        return (J) this;
    }

    public Boolean getUndoRedoCellEditing() {return undoRedoCellEditing;}

    public J setUndoRedoCellEditing(Boolean v)
    {
        this.undoRedoCellEditing = v;
        return (J) this;
    }

    public Integer getUndoRedoCellEditingLimit() {return undoRedoCellEditingLimit;}

    public J setUndoRedoCellEditingLimit(Integer v)
    {
        this.undoRedoCellEditingLimit = v;
        return (J) this;
    }

    public Boolean getReadOnlyEdit() {return readOnlyEdit;}

    public J setReadOnlyEdit(Boolean v)
    {
        this.readOnlyEdit = v;
        return (J) this;
    }

    // ===== Export (community) =====
    /**
     * Default configuration object used to export to CSV.
     */
    @JsonProperty("defaultCsvExportParams")
    private Object defaultCsvExportParams;

    /**
     * Prevent the user from exporting the grid to CSV.
     */
    @JsonProperty("suppressCsvExport")
    private Boolean suppressCsvExport;

    /**
     * Default configuration object used to export to Excel.
     */
    @JsonProperty("defaultExcelExportParams")
    private Object defaultExcelExportParams;

    /**
     * Prevent the user from exporting the grid to Excel.
     */
    @JsonProperty("suppressExcelExport")
    private Boolean suppressExcelExport;

    /**
     * List of Excel styles used when exporting to Excel with styles. (Initial)
     */
    @JsonProperty("excelStyles")
    private java.util.List<Object> excelStyles;

    public Object getDefaultCsvExportParams() {return defaultCsvExportParams;}

    public J setDefaultCsvExportParams(Object defaultCsvExportParams)
    {
        this.defaultCsvExportParams = defaultCsvExportParams;
        return (J) this;
    }

    public Boolean getSuppressCsvExport() {return suppressCsvExport;}

    public J setSuppressCsvExport(Boolean suppressCsvExport)
    {
        this.suppressCsvExport = suppressCsvExport;
        return (J) this;
    }

    public Object getDefaultExcelExportParams() {return defaultExcelExportParams;}

    public J setDefaultExcelExportParams(Object defaultExcelExportParams)
    {
        this.defaultExcelExportParams = defaultExcelExportParams;
        return (J) this;
    }

    public Boolean getSuppressExcelExport() {return suppressExcelExport;}

    public J setSuppressExcelExport(Boolean suppressExcelExport)
    {
        this.suppressExcelExport = suppressExcelExport;
        return (J) this;
    }

    public java.util.List<Object> getExcelStyles() {return excelStyles;}

    public J setExcelStyles(java.util.List<Object> excelStyles)
    {
        this.excelStyles = excelStyles;
        return (J) this;
    }

    // ===== Filtering (community) =====
    /**
     * Quick filter text applied across all columns (Client-Side Row Model only).
     */
    @JsonProperty("quickFilterText")
    private String quickFilterText;

    /**
     * Turn on the Quick Filter cache (Initial).
     */
    @JsonProperty("cacheQuickFilter")
    private Boolean cacheQuickFilter;

    /**
     * Include hidden columns in the Quick Filter.
     */
    @JsonProperty("includeHiddenColumnsInQuickFilter")
    private Boolean includeHiddenColumnsInQuickFilter;

    /**
     * Custom quick filter parser. Raw JS: (text: string) => string[]
     */
    @JsonProperty("quickFilterParser")
    @JsonRawValue
    private String quickFilterParser;

    /**
     * Custom quick filter matcher. Raw JS: (params) => boolean
     */
    @JsonProperty("quickFilterMatcher")
    @JsonRawValue
    private String quickFilterMatcher;

    /**
     * Apply Quick Filter before pivoting/aggregating instead of after.
     */
    @JsonProperty("applyQuickFilterBeforePivotOrAgg")
    private Boolean applyQuickFilterBeforePivotOrAgg;

    /**
     * External filter present? Raw JS: () => boolean
     */
    @JsonProperty("isExternalFilterPresent")
    @JsonRawValue
    private String isExternalFilterPresent;

    /**
     * External filter pass check. Raw JS: (node) => boolean
     */
    @JsonProperty("doesExternalFilterPass")
    @JsonRawValue
    private String doesExternalFilterPass;

    /**
     * Tree Data: exclude child nodes when filtering parent.
     */
    @JsonProperty("excludeChildrenWhenTreeDataFiltering")
    private Boolean excludeChildrenWhenTreeDataFiltering;

    /**
     * Always pass filtering for rows matching predicate. Raw JS: (params) => boolean
     */
    @JsonProperty("alwaysPassFilter")
    @JsonRawValue
    private String alwaysPassFilter;

    /**
     * Filter handlers map for custom filter components (Initial).
     */
    @JsonProperty("filterHandlers")
    private Object filterHandlers;

    public String getQuickFilterText() {return quickFilterText;}

    public J setQuickFilterText(String quickFilterText)
    {
        this.quickFilterText = quickFilterText;
        return (J) this;
    }

    public Boolean getCacheQuickFilter() {return cacheQuickFilter;}

    public J setCacheQuickFilter(Boolean cacheQuickFilter)
    {
        this.cacheQuickFilter = cacheQuickFilter;
        return (J) this;
    }

    public Boolean getIncludeHiddenColumnsInQuickFilter() {return includeHiddenColumnsInQuickFilter;}

    public J setIncludeHiddenColumnsInQuickFilter(Boolean includeHiddenColumnsInQuickFilter)
    {
        this.includeHiddenColumnsInQuickFilter = includeHiddenColumnsInQuickFilter;
        return (J) this;
    }

    public String getQuickFilterParser() {return quickFilterParser;}

    public J setQuickFilterParserRaw(String quickFilterParser)
    {
        this.quickFilterParser = quickFilterParser;
        return (J) this;
    }

    public String getQuickFilterMatcher() {return quickFilterMatcher;}

    public J setQuickFilterMatcherRaw(String quickFilterMatcher)
    {
        this.quickFilterMatcher = quickFilterMatcher;
        return (J) this;
    }

    public Boolean getApplyQuickFilterBeforePivotOrAgg() {return applyQuickFilterBeforePivotOrAgg;}

    public J setApplyQuickFilterBeforePivotOrAgg(Boolean applyQuickFilterBeforePivotOrAgg)
    {
        this.applyQuickFilterBeforePivotOrAgg = applyQuickFilterBeforePivotOrAgg;
        return (J) this;
    }

    public String getIsExternalFilterPresent() {return isExternalFilterPresent;}

    /**
     * Set raw JS: e.g., "() => true"
     */
    public J setIsExternalFilterPresentRaw(String isExternalFilterPresent)
    {
        this.isExternalFilterPresent = isExternalFilterPresent;
        return (J) this;
    }

    public String getDoesExternalFilterPass() {return doesExternalFilterPass;}

    /**
     * Set raw JS: e.g., "(node) => true"
     */
    public J setDoesExternalFilterPassRaw(String doesExternalFilterPass)
    {
        this.doesExternalFilterPass = doesExternalFilterPass;
        return (J) this;
    }

    public Boolean getExcludeChildrenWhenTreeDataFiltering() {return excludeChildrenWhenTreeDataFiltering;}

    public J setExcludeChildrenWhenTreeDataFiltering(Boolean excludeChildrenWhenTreeDataFiltering)
    {
        this.excludeChildrenWhenTreeDataFiltering = excludeChildrenWhenTreeDataFiltering;
        return (J) this;
    }

    public String getAlwaysPassFilter() {return alwaysPassFilter;}

    /**
     * Set raw JS: e.g., "(params) => params.data?.alwaysVisible === true"
     */
    public J setAlwaysPassFilterRaw(String alwaysPassFilter)
    {
        this.alwaysPassFilter = alwaysPassFilter;
        return (J) this;
    }

    public Object getFilterHandlers() {return filterHandlers;}

    public J setFilterHandlers(Object filterHandlers)
    {
        this.filterHandlers = filterHandlers;
        return (J) this;
    }

    // ===== Locale callback (community) =====
    /**
     * Callback for localising text within the grid. (Initial)
     */
    @JsonProperty("getLocaleText")
    @JsonRawValue
    private String getLocaleText;

    public String getGetLocaleText() {return getLocaleText;}

    /**
     * Set raw JS: e.g., "(key, defaultValue) => translations[key] ?? defaultValue"
     */
    public J setGetLocaleTextRaw(String rawJs)
    {
        this.getLocaleText = rawJs;
        return (J) this;
    }

    // ===== Column Definitions extras (community) =====
    /**
     * An object map of custom column types.
     */
    @JsonProperty("columnTypes")
    private Object columnTypes;

    /**
     * Map of cell data types to their definitions.
     */
    @JsonProperty("dataTypeDefinitions")
    private Object dataTypeDefinitions;

    /**
     * Keeps the order of columns maintained after new Column Definitions are updated.
     */
    @JsonProperty("maintainColumnOrder")
    private Boolean maintainColumnOrder;

    /**
     * Resets pivot column order when impacted by filters/data/config changes.
     */
    @JsonProperty("enableStrictPivotColumnOrder")
    private Boolean enableStrictPivotColumnOrder;

    /**
     * Dots in field names are not treated as deep references.
     */
    @JsonProperty("suppressFieldDotNotation")
    private Boolean suppressFieldDotNotation;

    public Object getColumnTypes() {return columnTypes;}

    public J setColumnTypes(Object columnTypes)
    {
        this.columnTypes = columnTypes;
        return (J) this;
    }

    public Object getDataTypeDefinitions() {return dataTypeDefinitions;}

    public J setDataTypeDefinitions(Object dataTypeDefinitions)
    {
        this.dataTypeDefinitions = dataTypeDefinitions;
        return (J) this;
    }

    public Boolean getMaintainColumnOrder() {return maintainColumnOrder;}

    public J setMaintainColumnOrder(Boolean maintainColumnOrder)
    {
        this.maintainColumnOrder = maintainColumnOrder;
        return (J) this;
    }

    public Boolean getEnableStrictPivotColumnOrder() {return enableStrictPivotColumnOrder;}

    public J setEnableStrictPivotColumnOrder(Boolean enableStrictPivotColumnOrder)
    {
        this.enableStrictPivotColumnOrder = enableStrictPivotColumnOrder;
        return (J) this;
    }

    public Boolean getSuppressFieldDotNotation() {return suppressFieldDotNotation;}

    public J setSuppressFieldDotNotation(Boolean suppressFieldDotNotation)
    {
        this.suppressFieldDotNotation = suppressFieldDotNotation;
        return (J) this;
    }

    // ===== Misc performance/context/touch (community) =====
    /**
     * Turn on the value cache.
     */
    @JsonProperty("valueCache")
    private Boolean valueCache;

    /**
     * Configure the value cache to not expire after data updates.
     */
    @JsonProperty("valueCacheNeverExpires")
    private Boolean valueCacheNeverExpires;

    /**
     * Allow cell expressions.
     */
    @JsonProperty("enableCellExpressions")
    private Boolean enableCellExpressions;

    /**
     * Override which document is used.
     */
    @JsonProperty("getDocument")
    @JsonRawValue
    private String getDocument;

    /**
     * Disables touch support (but does not remove browser's simulated mouse events).
     */
    @JsonProperty("suppressTouch")
    private Boolean suppressTouch;

    /**
     * Disables change detection.
     */
    @JsonProperty("suppressChangeDetection")
    private Boolean suppressChangeDetection;

    /**
     * Tab index for the grid.
     */
    @JsonProperty("tabIndex")
    private Integer tabIndex;

    /**
     * Context object provided to callbacks.
     */
    @JsonProperty("context")
    private Object context;

    /**
     * Aligned grids: list or callback to provide them.
     */
    @JsonProperty("alignedGrids")
    private Object alignedGrids;

    /**
     * Map of component names to components.
     */
    @JsonProperty("components")
    private Object components;

    public Boolean getValueCache() {return valueCache;}

    public J setValueCache(Boolean valueCache)
    {
        this.valueCache = valueCache;
        return (J) this;
    }

    public Boolean getValueCacheNeverExpires() {return valueCacheNeverExpires;}

    public J setValueCacheNeverExpires(Boolean valueCacheNeverExpires)
    {
        this.valueCacheNeverExpires = valueCacheNeverExpires;
        return (J) this;
    }

    public Boolean getEnableCellExpressions() {return enableCellExpressions;}

    public J setEnableCellExpressions(Boolean enableCellExpressions)
    {
        this.enableCellExpressions = enableCellExpressions;
        return (J) this;
    }

    public String getGetDocument() {return getDocument;}

    /**
     * Set raw JS: e.g., "() => document" or a custom document getter.
     */
    public J setGetDocumentRaw(String rawJs)
    {
        this.getDocument = rawJs;
        return (J) this;
    }

    public Boolean getSuppressTouch() {return suppressTouch;}

    public J setSuppressTouch(Boolean suppressTouch)
    {
        this.suppressTouch = suppressTouch;
        return (J) this;
    }

    public Boolean getSuppressChangeDetection() {return suppressChangeDetection;}

    public J setSuppressChangeDetection(Boolean suppressChangeDetection)
    {
        this.suppressChangeDetection = suppressChangeDetection;
        return (J) this;
    }

    public Integer getTabIndex() {return tabIndex;}

    public J setTabIndex(Integer tabIndex)
    {
        this.tabIndex = tabIndex;
        return (J) this;
    }

    public Object getContext() {return context;}

    public J setContext(Object context)
    {
        this.context = context;
        return (J) this;
    }

    public Object getAlignedGrids() {return alignedGrids;}

    public J setAlignedGrids(Object alignedGrids)
    {
        this.alignedGrids = alignedGrids;
        return (J) this;
    }

    public Object getComponents() {return components;}

    public J setComponents(Object components)
    {
        this.components = components;
        return (J) this;
    }

    // ===== Accessories / Context Menu / Side Bar / Status Bar / Row Numbers / Find (community) =====
    /**
     * For customising the context menu (ContextMenuModule).
     */
    @JsonProperty("getContextMenuItems")
    @JsonRawValue
    private String getContextMenuItems;

    /**
     * Enterprise-only: status bar configuration moved to AgGridEnterpriseOptions. Retained for backward compatibility but not serialized.
     */
    @com.fasterxml.jackson.annotation.JsonIgnore
    private Object statusBar;

    /**
     * Enterprise-only: side bar configuration moved to AgGridEnterpriseOptions. Retained for backward compatibility but not serialized.
     */
    @com.fasterxml.jackson.annotation.JsonIgnore
    private Object sideBar;

    /**
     * Row Numbers feature: boolean | RowNumbersOptions (object).
     */
    @JsonProperty("rowNumbers")
    private Object rowNumbers;

    /**
     * Find: search value to look for across the grid.
     */
    @JsonProperty("findSearchValue")
    private String findSearchValue;

    /**
     * Find: options controlling find behaviour (FindModule).
     */
    @JsonProperty("findOptions")
    private Object findOptions;

    // ----- Accessories getters/setters -----
    public String getGetContextMenuItems() {return getContextMenuItems;}

    /**
     * Set raw JS: e.g., "(params) => ['copy','paste']"
     */
    public J setGetContextMenuItemsRaw(String rawJs)
    {
        this.getContextMenuItems = rawJs;
        return (J) this;
    }

    @Deprecated
    public Object getStatusBar() {return statusBar;}

    @Deprecated
    public J setStatusBar(Object statusBar)
    {
        this.statusBar = statusBar;
        return (J) this;
    }

    public Object getSideBar() {return sideBar;}

    /**
     * Accepts Boolean (enable/disable), String preset (e.g. "columns"), string[], or full definition object.
     */
    public J setSideBar(Object sideBar)
    {
        this.sideBar = sideBar;
        return (J) this;
    }

    public Object getRowNumbers() {return rowNumbers;}

    public J setRowNumbers(boolean enabled)
    {
        this.rowNumbers = enabled;
        return (J) this;
    }

    public J setRowNumbers(Object options)
    {
        this.rowNumbers = options;
        return (J) this;
    }

    public String getFindSearchValue() {return findSearchValue;}

    public J setFindSearchValue(String findSearchValue)
    {
        this.findSearchValue = findSearchValue;
        return (J) this;
    }

    public Object getFindOptions() {return findOptions;}

    public J setFindOptions(Object findOptions)
    {
        this.findOptions = findOptions;
        return (J) this;
    }

    // ===== Row Model type (community) =====
    /**
     * Sets the row model type: 'clientSide' | 'serverSide' | 'viewport' | 'infinite'. (Initial)
     */
    @JsonProperty("rowModelType")
    private String rowModelType;

    public String getRowModelType() {return rowModelType;}

    public J setRowModelType(String rowModelType)
    {
        this.rowModelType = rowModelType;
        return (J) this;
    }

    // ===== Additional callbacks & flags (community) =====
    /**
     * Callback version of property rowHeight to set height per row. Raw JS: (params) => number
     */
    @JsonProperty("getRowHeight")
    @JsonRawValue
    private String getRowHeight;

    /**
     * Return a business key string for the row node. Raw JS: (node) => string
     */
    @JsonProperty("getBusinessKeyForNode")
    @JsonRawValue
    private String getBusinessKeyForNode;

    /**
     * When true, the grid will not use animation frames when drawing rows while scrolling. (Initial)
     */
    @JsonProperty("suppressAnimationFrame")
    private Boolean suppressAnimationFrame;

    public String getGetRowHeight() {return getRowHeight;}

    /**
     * Set raw JS for getRowHeight, e.g. "(params) => params.data?.height || 25"
     */
    public J setGetRowHeightRaw(String rawJs)
    {
        this.getRowHeight = rawJs;
        return (J) this;
    }

    public String getGetBusinessKeyForNode() {return getBusinessKeyForNode;}

    /**
     * Set raw JS for getBusinessKeyForNode, e.g. "(node) => node.data?.id"
     */
    public J setGetBusinessKeyForNodeRaw(String rawJs)
    {
        this.getBusinessKeyForNode = rawJs;
        return (J) this;
    }

    public Boolean getSuppressAnimationFrame() {return suppressAnimationFrame;}

    public J setSuppressAnimationFrame(Boolean suppressAnimationFrame)
    {
        this.suppressAnimationFrame = suppressAnimationFrame;
        return (J) this;
    }

    /**
     * Convenience aliases for clarity with raw JS setters already present.
     */
    public J setIsFullWidthRowRaw(String rawJs)
    {
        this.isFullWidthRow = rawJs;
        return (J) this;
    }

    public J setProcessUnpinnedColumnsRaw(String rawJs)
    {
        this.processUnpinnedColumns = rawJs;
        return (J) this;
    }

    // ===== Column Auto-Size (community) =====
    /**
     * Suppresses auto-sizing columns via UI operations (Initial).
     */
    @JsonProperty("suppressAutoSize")
    private Boolean suppressAutoSize;

    /**
     * Extra pixels to add after auto-size calculation (default 20).
     */
    @JsonProperty("autoSizePadding")
    private Integer autoSizePadding;

    public Boolean getSuppressAutoSize() {return suppressAutoSize;}

    public J setSuppressAutoSize(Boolean suppressAutoSize)
    {
        this.suppressAutoSize = suppressAutoSize;
        return (J) this;
    }

    public Integer getAutoSizePadding() {return autoSizePadding;}

    public J setAutoSizePadding(Integer autoSizePadding)
    {
        this.autoSizePadding = autoSizePadding;
        return (J) this;
    }

    // ===== Grid State (community) =====
    /**
     * Initial grid state, read once during initialisation (Initial).
     */
    @JsonProperty("initialState")
    private Object initialState;

    public Object getInitialState() {return initialState;}

    public J setInitialState(Object initialState)
    {
        this.initialState = initialState;
        return (J) this;
    }

    // ===== Tree Data extras (community) =====
    /**
     * Field name containing an array of children nodes when using treeData=true.
     */
    @JsonProperty("treeDataChildrenField")
    private String treeDataChildrenField;

    /**
     * Field name to find the parent node when using treeData=true (requires getRowId).
     */
    @JsonProperty("treeDataParentIdField")
    private String treeDataParentIdField;

    public String getTreeDataChildrenField() {return treeDataChildrenField;}

    public J setTreeDataChildrenField(String treeDataChildrenField)
    {
        this.treeDataChildrenField = treeDataChildrenField;
        return (J) this;
    }

    public String getTreeDataParentIdField() {return treeDataParentIdField;}

    public J setTreeDataParentIdField(String treeDataParentIdField)
    {
        this.treeDataParentIdField = treeDataParentIdField;
        return (J) this;
    }

    // ===== Icons (community) =====
    /**
     * Icons to use inside the grid instead of the grid's default icons.
     * Accepts either a Map<String, Object> where values are strings (icon names/svg) or functions,
     * or a raw JavaScript object literal via {@link #setIconsRaw(String)}.
     */
    @JsonProperty("icons")
    private Object icons;

    /**
     * Get the icons configuration map or raw object.
     */
    public Object getIcons() {return icons;}

    /**
     * Set icons using a Java Map / object structure.
     */
    public J setIcons(Object icons)
    {
        this.icons = icons;
        return (J) this;
    }

    /**
     * Provide a raw JavaScript object literal for icons.
     * Example: "{ sortAscending: 'my-asc', sortDescending: 'my-desc', checkboxChecked: params => '...'}"
     */
    public J setIconsRaw(String rawJsObject)
    {
        this.icons = rawJsObject == null ? null : new RawJsFunction(rawJsObject);
        return (J) this;
    }

    /**
     * Minimal raw JS wrapper to serialize object literals without quotes.
     */
    static class RawJsFunction extends com.jwebmp.core.htmlbuilder.javascript.JavascriptFunction<RawJsFunction>
    {
        private final String raw;

        RawJsFunction(String raw) {this.raw = raw;}

        @Override
        public String renderFunction() {return raw == null ? "null" : raw;}
    }

    // ===== Typed enums & overloads added for fixed-value properties =====

    /**
     * Row Model Type: 'clientSide' | 'serverSide' | 'viewport' | 'infinite'.
     */
    public enum RowModelType
    {
        CLIENT_SIDE("clientSide"),
        SERVER_SIDE("serverSide"),
        VIEWPORT("viewport"),
        INFINITE("infinite");
        private final String json;

        RowModelType(String json) {this.json = json;}

        public String getJson() {return json;}

        @Override
        public String toString() {return json;}
    }

    /**
     * Typed overload to set the row model type using enum.
     */
    public J setRowModelType(RowModelType type)
    {
        this.rowModelType = type == null ? null : type.getJson();
        return (J) this;
    }

    /**
     * Default column resize behavior enum (currently only 'shift' supported).
     */
    public enum ColResizeDefault
    {
        SHIFT("shift");
        private final String json;

        ColResizeDefault(String json) {this.json = json;}

        public String getJson() {return json;}

        @Override
        public String toString() {return json;}
    }

    /**
     * Typed overload to set the default column resize behavior using enum.
     */
    public J setColResizeDefault(ColResizeDefault value)
    {
        this.colResizeDefault = value == null ? null : value.getJson();
        return (J) this;
    }
}
