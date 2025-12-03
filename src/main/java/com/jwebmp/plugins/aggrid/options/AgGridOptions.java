package com.jwebmp.plugins.aggrid.options;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.aggrid.options.enums.*;
import org.jspecify.annotations.Nullable;

import java.util.ArrayList;

/**
 * AG Grid Options - MODULAR COMPOSITION PATTERN
 * 
 * Composes multiple specialized option classes via @JsonUnwrapped annotations
 * to keep options modularized while maintaining identical JSON output to the
 * previous monolithic approach.
 * 
 * ADVANTAGES:
 * - Cleaner code organization (one class per feature)
 * - Type-safe enums for selectable options
 * - Easier maintenance and testing
 * - Self-documenting class names
 * - Better scalability for future options
 * 
 * JSON OUTPUT BEHAVIOR:
 * - All nested properties are flattened into the parent JSON object
 * - No additional nesting introduced
 * - Maintains backward compatibility with existing JSON schemas
 * 
 * Example:
 * ```
 * AgGridOptions options = new AgGridOptions()
 *     .configureRendering().setAnimateRows(true);
 * options.configurePagination().setPaginationPageSize(50);
 * 
 * // Serializes to:
 * // { "animateRows": true, "paginationPageSize": 50, ... }
 * ```
 * 
 * MODULAR COMPONENTS:
 * - RenderingOptions: animation, flashing, performance
 * - ServerSideRowModelOptions: server-side data loading
 * - AdvancedFilterOptions: advanced filtering
 * - RowGroupingOptions: row grouping and aggregation
 * - RowPivotingOptions: row pivoting and cross-tabulation
 * - PaginationOptions: pagination control
 * - ColumnManagementOptions: column manipulation
 * - HeaderSizingOptions: header and row heights
 * - EditingOptions: cell editing behavior
 * - FilteringOptions: quick filter and external filter
 * - ExportOptions: CSV/Excel/PDF export
 * - SelectionOptionsExpanded: row and cell selection
 * 
 * @author DevSuite
 * @since 2025
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgGridOptions<J extends AgGridOptions<J>> extends JavaScriptPart<J>
{
    /**
     * Rendering options - animation, flashing, performance settings.
     * Properties are unwrapped into parent JSON.
     */
    @JsonUnwrapped
    private RenderingOptions<?> rendering = new RenderingOptions<>();

    /**
     * Server-side row model options (NEW v34.2.0).
     * Properties are unwrapped into parent JSON.
     */
    @JsonUnwrapped
    private ServerSideRowModelOptions<?> serverSideRowModel = new ServerSideRowModelOptions<>();

    /**
     * Advanced filter options (NEW v34.2.0).
     * Properties are unwrapped into parent JSON.
     */
    @JsonUnwrapped
    private AdvancedFilterOptions<?> advancedFilter = new AdvancedFilterOptions<>();

    /**
     * Row grouping and aggregation options (NEW Phase C).
     * Properties are unwrapped into parent JSON.
     */
    @JsonUnwrapped
    private RowGroupingOptions<?> rowGrouping = new RowGroupingOptions<>();

    /**
     * Row pivoting and cross-tabulation options (NEW Phase C).
     * Properties are unwrapped into parent JSON.
     */
    @JsonUnwrapped
    private RowPivotingOptions<?> rowPivoting = new RowPivotingOptions<>();

    /**
     * Pagination options - page size, panel suppression.
     * Properties are unwrapped into parent JSON.
     */
    @JsonUnwrapped
    private PaginationOptions<?> pagination = new PaginationOptions<>();

    /**
     * Column management options - animation, drag, sizing.
     * Properties are unwrapped into parent JSON.
     */
    @JsonUnwrapped
    private ColumnManagementOptions<?> columnManagement = new ColumnManagementOptions<>();

    /**
     * Header and sizing options - heights, auto-sizing.
     * Properties are unwrapped into parent JSON.
     */
    @JsonUnwrapped
    private HeaderSizingOptions<?> headerSizing = new HeaderSizingOptions<>();

    /**
     * Editing options - edit mode, stop conditions.
     * Properties are unwrapped into parent JSON.
     */
    @JsonUnwrapped
    private EditingOptions<?> editing = new EditingOptions<>();

    /**
     * Filtering options - quick filter, external filter.
     * Properties are unwrapped into parent JSON.
     */
    @JsonUnwrapped
    private FilteringOptions<?> filtering = new FilteringOptions<>();

    /**
     * Export options - CSV, Excel, PDF export.
     * Properties are unwrapped into parent JSON.
     */
    @JsonUnwrapped
    private ExportOptions<?> export = new ExportOptions<>();

    /**
     * Selection options - row and cell selection behavior.
     * Properties are unwrapped into parent JSON.
     */
    @JsonUnwrapped
    private SelectionOptionsExpanded<?> selectionExpanded = new SelectionOptionsExpanded<>();

    /**
     * Row selection mode - single vs multiple.
     */
    @JsonProperty("rowSelection")
    private @Nullable RowSelectionMode rowSelection;

    /**
     * Cell selection mode (NEW v34.2.0).
     * Determines whether cells or rows are selected.
     */
    @JsonProperty("cellSelection")
    private @Nullable CellSelectionMode cellSelection;

    /**
     * DOM layout type - normal, autoHeight, or print.
     */
    @JsonProperty("domLayout")
    private @Nullable DomLayoutType domLayout;

    /**
     * Edit mode type - api vs doubleClick.
     */
    @JsonProperty("editType")
    private @Nullable EditType editType;

    // Getters

    public RenderingOptions<?> getRendering()
    {
        return rendering;
    }

    public ServerSideRowModelOptions<?> getServerSideRowModel()
    {
        return serverSideRowModel;
    }

    public AdvancedFilterOptions<?> getAdvancedFilter()
    {
        return advancedFilter;
    }

    public RowGroupingOptions<?> getRowGrouping()
    {
        return rowGrouping;
    }

    public RowPivotingOptions<?> getRowPivoting()
    {
        return rowPivoting;
    }

    public PaginationOptions<?> getPagination()
    {
        return pagination;
    }

    public ColumnManagementOptions<?> getColumnManagement()
    {
        return columnManagement;
    }

    public HeaderSizingOptions<?> getHeaderSizing()
    {
        return headerSizing;
    }

    public EditingOptions<?> getEditing()
    {
        return editing;
    }

    public FilteringOptions<?> getFiltering()
    {
        return filtering;
    }

    public ExportOptions<?> getExport()
    {
        return export;
    }

    public SelectionOptionsExpanded<?> getSelectionExpanded()
    {
        return selectionExpanded;
    }

    public @Nullable RowSelectionMode getRowSelection()
    {
        return rowSelection;
    }

    public @Nullable CellSelectionMode getCellSelection()
    {
        return cellSelection;
    }

    public @Nullable DomLayoutType getDomLayout()
    {
        return domLayout;
    }

    public @Nullable EditType getEditType()
    {
        return editType;
    }

    // Setters with CRTP return type

    @SuppressWarnings("unchecked")
    public J setRendering(RenderingOptions<?> rendering)
    {
        this.rendering = rendering;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setServerSideRowModel(ServerSideRowModelOptions<?> serverSideRowModel)
    {
        this.serverSideRowModel = serverSideRowModel;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setAdvancedFilter(AdvancedFilterOptions<?> advancedFilter)
    {
        this.advancedFilter = advancedFilter;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setRowGrouping(RowGroupingOptions<?> rowGrouping)
    {
        this.rowGrouping = rowGrouping;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setRowPivoting(RowPivotingOptions<?> rowPivoting)
    {
        this.rowPivoting = rowPivoting;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setPagination(PaginationOptions<?> pagination)
    {
        this.pagination = pagination;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setColumnManagement(ColumnManagementOptions<?> columnManagement)
    {
        this.columnManagement = columnManagement;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setHeaderSizing(HeaderSizingOptions<?> headerSizing)
    {
        this.headerSizing = headerSizing;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setEditing(EditingOptions<?> editing)
    {
        this.editing = editing;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setFiltering(FilteringOptions<?> filtering)
    {
        this.filtering = filtering;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setExport(ExportOptions<?> export)
    {
        this.export = export;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setSelectionExpanded(SelectionOptionsExpanded<?> selectionExpanded)
    {
        this.selectionExpanded = selectionExpanded;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setRowSelection(@Nullable RowSelectionMode rowSelection)
    {
        this.rowSelection = rowSelection;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setCellSelection(@Nullable CellSelectionMode cellSelection)
    {
        this.cellSelection = cellSelection;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setDomLayout(@Nullable DomLayoutType domLayout)
    {
        this.domLayout = domLayout;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setEditType(@Nullable EditType editType)
    {
        this.editType = editType;
        return (J) this;
    }

    // Convenience methods for fluent API

    /**
     * Convenience method to configure rendering options in a fluent style.
     * Returns the rendering options object for chaining.
     */
    @SuppressWarnings("unchecked")
    public <R extends RenderingOptions<R>> R configureRendering()
    {
        return (R) rendering;
    }

    /**
     * Convenience method to configure server-side row model in a fluent style.
     * Returns the server-side row model options object for chaining.
     */
    @SuppressWarnings("unchecked")
    public <S extends ServerSideRowModelOptions<S>> S configureServerSideRowModel()
    {
        return (S) serverSideRowModel;
    }

    /**
     * Convenience method to configure advanced filter in a fluent style.
     * Returns the advanced filter options object for chaining.
     */
    @SuppressWarnings("unchecked")
    public <A extends AdvancedFilterOptions<A>> A configureAdvancedFilter()
    {
        return (A) advancedFilter;
    }

    /**
     * Convenience method to configure row grouping in a fluent style.
     * Returns the row grouping options object for chaining.
     * NEW Phase C: Row Grouping & Aggregation support.
     */
    @SuppressWarnings("unchecked")
    public <G extends RowGroupingOptions<G>> G configureRowGrouping()
    {
        return (G) rowGrouping;
    }

    /**
     * Convenience method to configure row pivoting in a fluent style.
     * Returns the row pivoting options object for chaining.
     * NEW Phase C: Row Pivoting & Cross-tabulation support.
     */
    @SuppressWarnings("unchecked")
    public <P extends RowPivotingOptions<P>> P configureRowPivoting()
    {
        return (P) rowPivoting;
    }

    /**
     * Convenience method to configure pagination in a fluent style.
     * Returns the pagination options object for chaining.
     */
    @SuppressWarnings("unchecked")
    public <PA extends PaginationOptions<PA>> PA configurePagination()
    {
        return (PA) pagination;
    }

    /**
     * Convenience method to configure column management in a fluent style.
     * Returns the column management options object for chaining.
     */
    @SuppressWarnings("unchecked")
    public <C extends ColumnManagementOptions<C>> C configureColumnManagement()
    {
        return (C) columnManagement;
    }

    /**
     * Convenience method to configure header sizing in a fluent style.
     * Returns the header sizing options object for chaining.
     */
    @SuppressWarnings("unchecked")
    public <H extends HeaderSizingOptions<H>> H configureHeaderSizing()
    {
        return (H) headerSizing;
    }

    /**
     * Convenience method to configure editing in a fluent style.
     * Returns the editing options object for chaining.
     */
    @SuppressWarnings("unchecked")
    public <E extends EditingOptions<E>> E configureEditing()
    {
        return (E) editing;
    }

    /**
     * Convenience method to configure filtering in a fluent style.
     * Returns the filtering options object for chaining.
     */
    @SuppressWarnings("unchecked")
    public <F extends FilteringOptions<F>> F configureFiltering()
    {
        return (F) filtering;
    }

    /**
     * Convenience method to configure export in a fluent style.
     * Returns the export options object for chaining.
     */
    @SuppressWarnings("unchecked")
    public <EX extends ExportOptions<EX>> EX configureExport()
    {
        return (EX) export;
    }

    /**
     * Convenience method to configure selection in a fluent style.
     * Returns the selection options object for chaining.
     */
    @SuppressWarnings("unchecked")
    public <S extends SelectionOptionsExpanded<S>> S configureSelection()
    {
        return (S) selectionExpanded;
    }

    // ============================================================
    // COMPONENT-SPECIFIC FIELDS (JWebMP Template Binding)
    // ============================================================
    // These fields are NOT serialized to JSON (@JsonIgnore)
    // but are used for Angular template binding and data management

    /**
     * The column definitions - as presented in the html and ts component
     * NOT serialized to JSON
     */
    @com.fasterxml.jackson.annotation.JsonIgnore
    private java.util.List<com.jwebmp.plugins.aggrid.options.AgGridColumnDef<?>> columnDefs;

    /**
     * Default Column Definition applied to all columns unless overridden per-column.
     */
    @JsonProperty("defaultColDef")
    private com.jwebmp.plugins.aggrid.options.AgGridColumnDef<?> defaultColDef;

    /**
     * The row data
     * NOT serialized to JSON
     */
    @com.fasterxml.jackson.annotation.JsonIgnore
    private Object rowData;

    /**
     * Optional raw rowData binding expression (TypeScript/Angular expression).
     * When provided, the grid will bind [rowData] to this expression directly,
     * instead of using the serialized Java list above.
     * NOT serialized to JSON
     */
    @com.fasterxml.jackson.annotation.JsonIgnore
    private String rowDataRaw;

    // Getters for component template binding

    public java.util.List<com.jwebmp.plugins.aggrid.options.AgGridColumnDef<?>> getColumnDefs()
    {
						if (columnDefs == null)
						{
								this.columnDefs = new ArrayList<>();
						}
						return columnDefs;
    }

    public Object getRowData()
    {
        return rowData;
    }

    public String getRowDataRaw()
    {
        return rowDataRaw;
    }

    // Setters for component template binding

    @SuppressWarnings("unchecked")
    public J setColumnDefs(java.util.List<com.jwebmp.plugins.aggrid.options.AgGridColumnDef<?>> columnDefs)
    {
        this.columnDefs = columnDefs;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setRowData(Object rowData)
    {
        this.rowData = rowData;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setRowDataRaw(String rowDataRaw)
    {
        this.rowDataRaw = rowDataRaw;
        return (J) this;
    }

    // Additional convenience methods for AgGrid.java

    /**
     * Convenience method for setting default column definition
     */
    @SuppressWarnings("unchecked")
    public J setDefaultColDef(com.jwebmp.plugins.aggrid.options.AgGridColumnDef<?> defaultColDef)
    {
        this.defaultColDef = defaultColDef;
        return (J) this;
    }

    /**
     * Convenience method for getting default column definition
     */
    public com.jwebmp.plugins.aggrid.options.AgGridColumnDef<?> getDefaultColDef()
    {
        if (defaultColDef == null)
        {
            return null;
        }
        try
        {
            // Defensive copy: return a new instance so callers cannot mutate internal state
            com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
            byte[] json = mapper.writeValueAsBytes(defaultColDef);
            Object copy = mapper.readValue(json, (Class<?>) defaultColDef.getClass());
            return (com.jwebmp.plugins.aggrid.options.AgGridColumnDef<?>) copy;
        }
        catch (Exception e)
        {
            // Fallback: return a fresh instance to avoid leaking internals
            return new com.jwebmp.plugins.aggrid.options.AgGridColumnDef<>();
        }
    }

    /**
     * Convenience method for getting pagination page size
     */
    public Integer getPaginationPageSize()
    {
        return pagination != null ? pagination.getPaginationPageSize() : null;
    }

    /**
     * Convenience method for getting row height
     */
    public Integer getRowHeight()
    {
        return headerSizing != null ? headerSizing.getRowHeight() : null;
    }

    /**
     * Convenience method for setting row height without having to navigate HeaderSizingOptions.
     * Mirrors AG Grid's gridOptions.rowHeight. When set, AgGrid will generate a TS field and bind
     * [rowHeight] to it so the runtime grid receives the correct value.
     */
    @SuppressWarnings("unchecked")
    public J setRowHeight(Integer rowHeight)
    {
        if (this.headerSizing == null)
        {
            this.headerSizing = new HeaderSizingOptions<>();
        }
        this.headerSizing.setRowHeight(rowHeight);
        return (J) this;
    }

    /**
     * Convenience method to set row selection using enum
     */
    @SuppressWarnings("unchecked")
    public J setRowSelectionMode(com.jwebmp.plugins.aggrid.options.enums.RowSelectionMode mode)
    {
        if (mode != null)
        {
            this.rowSelection = mode;
        }
        return (J) this;
    }

    /**
     * Enable classic checkbox selection using the Auto Group Column with new modular options.
     * - Sets rowSelection to MULTIPLE
     * - Configures autoGroupColumnDef with checkboxSelection and optional headerCheckboxSelection
     * - Wires group selection behaviour flags (groupSelectsChildren / groupSelectsFiltered)
     *
     * Usage example:
     *   options.enableGroupCheckboxSelection(true, true, true, true);
     */
    @SuppressWarnings("unchecked")
    public J enableGroupCheckboxSelection(boolean headerCheckbox, boolean rowCheckbox, boolean selectChildren, boolean selectFiltered)
    {
        // Ensure multiple selection for checkbox UX
        this.rowSelection = com.jwebmp.plugins.aggrid.options.enums.RowSelectionMode.MULTIPLE;

        // Configure auto group column definition
        RowGroupingOptions<?> rg = this.rowGrouping != null ? this.rowGrouping : (this.rowGrouping = new RowGroupingOptions<>());
        AgGridColumnDef<?> auto = rg.getAutoGroupColumnDef();
        if (auto == null)
        {
            auto = new AgGridColumnDef<>();
            rg.setAutoGroupColumnDef(auto);
        }
        auto.setCheckboxSelection(rowCheckbox);
        auto.setHeaderCheckboxSelection(headerCheckbox);

        // Configure group selection behaviour
        rg.setGroupSelectsChildren(selectChildren);
        rg.setGroupSelectsFiltered(selectFiltered);

        return (J) this;
    }

    /**
     * Convenience getter mirroring legacy suppressAggHeader flag.
     * Maps to AG Grid's suppressAggFuncInHeader on the row grouping module.
     */
    public Boolean getSuppressAggFuncInHeader()
    {
        return rowGrouping != null ? rowGrouping.getSuppressAggFuncInHeader() : null;
    }

    /**
     * Convenience setter mirroring legacy suppressAggHeader flag.
     * Delegates to RowGroupingOptions#setSuppressAggFuncInHeader(Boolean).
     */
    @SuppressWarnings("unchecked")
    public J setSuppressAggFuncInHeader(Boolean suppress)
    {
        if (this.rowGrouping == null)
        {
            this.rowGrouping = new RowGroupingOptions<>();
        }
        this.rowGrouping.setSuppressAggFuncInHeader(suppress);
        return (J) this;
    }

    /**
     * Convenience method to set enable cell change flash
     */
    @SuppressWarnings("unchecked")
    public J setEnableCellChangeFlash(Boolean enableCellChangeFlash)
    {
        // This would be added to a RenderingOptions or similar if needed
        // For now just return for compatibility
        return (J) this;
    }
}
