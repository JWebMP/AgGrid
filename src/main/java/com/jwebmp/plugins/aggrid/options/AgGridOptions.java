package com.jwebmp.plugins.aggrid.options;

import com.fasterxml.jackson.annotation.*;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.aggrid.options.enums.*;
import org.jspecify.annotations.NonNull;
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
     * Tree Data options - treeData, getDataPath, children/parent fields.
     * Properties are unwrapped into parent JSON.
     */
    @JsonUnwrapped
    private TreeDataOptions<?> treeDataOptions = new TreeDataOptions<>();
    /**
     * Grid state options - initialState.
     * Properties are unwrapped into parent JSON.
     */
    @JsonUnwrapped
    private GridStateOptions<?> gridState = new GridStateOptions<>();
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

    public PaginationOptions<?> getPaginationOptions()
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

    public TreeDataOptions<?> getTreeDataOptions()
    {
        return treeDataOptions;
    }

    public GridStateOptions<?> getGridState()
    {
        return gridState;
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
    public J setPaginationOptions(PaginationOptions<?> pagination)
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
    public J setTreeDataOptions(TreeDataOptions<?> treeDataOptions)
    {
        this.treeDataOptions = treeDataOptions;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setGridState(GridStateOptions<?> gridState)
    {
        this.gridState = gridState;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setCellSelection(@Nullable CellSelectionMode cellSelection)
    {
        this.cellSelection = cellSelection;
        if (selectionExpanded != null)
        {
            selectionExpanded.setCellSelection(cellSelection != null ? cellSelection.toString() : null);
        }
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
        if (editing != null)
        {
            editing.setEditType(editType != null ? editType.toString() : null);
        }
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

    @SuppressWarnings("unchecked")
    public <T extends TreeDataOptions<T>> T configureTreeData()
    {
        return (T) treeDataOptions;
    }

    /**
     * Configure grid state options fluently.
     *
     * @return The GridStateOptions instance.
     */
    @SuppressWarnings("unchecked")
    public <GS extends GridStateOptions<GS>> GS configureGridState()
    {
        return (GS) gridState;
    }

    /**
     * Get whether Tree Data mode is enabled.
     */
    public Boolean getTreeData()
    {
        return treeDataOptions.getTreeData();
    }

    /**
     * Enable/disable Tree Data mode.
     */
    @SuppressWarnings("unchecked")
    public @NonNull J setTreeData(Boolean treeData)
    {
        treeDataOptions.setTreeData(treeData);
        return (J) this;
    }

    /**
     * Set the getDataPath callback using a raw JavaScript function or arrow function.
     * Example: "(data) => data.path"
     */
    @SuppressWarnings("unchecked")
    public @NonNull J setGetDataPathRaw(String getDataPathRawJs)
    {
        treeDataOptions.setGetDataPathRaw(getDataPathRawJs);
        return (J) this;
    }

    /**
     * Convenience method to set the initial filter model.
     * This wraps the provided model into gridOptions.initialState.filter.filterModel.
     *
     * @param filterModel The filter model to set.
     * @return This options instance.
     */
    @SuppressWarnings("unchecked")
    public J setInitialFilterModel(java.util.Map<String, Object> filterModel)
    {
        configureGridState()
                .getInitialState()
                .setFilter(new com.jwebmp.plugins.aggrid.options.state.FilterState<>().setFilterModel(filterModel));
        return (J) this;
    }

    /**
     * Set to false to disable row animation which is enabled by default.
     */
    public @Nullable Boolean getAnimateRows()
    {
        return rendering.getAnimateRows();
    }

    /**
     * Set to false to disable row animation which is enabled by default.
     */
    @SuppressWarnings("unchecked")
    public J setAnimateRows(@Nullable Boolean animateRows)
    {
        rendering.setAnimateRows(animateRows);
        return (J) this;
    }

    /**
     * Duration in milliseconds that a cell remains in the flashed state after changes.
     */
    public @Nullable Integer getCellFlashDuration()
    {
        return rendering.getCellFlashDuration();
    }

    /**
     * Duration in milliseconds that a cell remains in the flashed state after changes.
     */
    @SuppressWarnings("unchecked")
    public J setCellFlashDuration(@Nullable Integer cellFlashDuration)
    {
        rendering.setCellFlashDuration(cellFlashDuration);
        return (J) this;
    }

    /**
     * Duration in milliseconds for the fade-out of the flashed state.
     */
    public @Nullable Integer getCellFadeDuration()
    {
        return rendering.getCellFadeDuration();
    }

    /**
     * Duration in milliseconds for the fade-out of the flashed state.
     */
    @SuppressWarnings("unchecked")
    public J setCellFadeDuration(@Nullable Integer cellFadeDuration)
    {
        rendering.setCellFadeDuration(cellFadeDuration);
        return (J) this;
    }

    /**
     * When true, allow cells to flash even when the change was caused by filtering.
     */
    public @Nullable Boolean getAllowShowChangeAfterFilter()
    {
        return rendering.getAllowShowChangeAfterFilter();
    }

    /**
     * When true, allow cells to flash even when the change was caused by filtering.
     */
    @SuppressWarnings("unchecked")
    public J setAllowShowChangeAfterFilter(@Nullable Boolean allowShowChangeAfterFilter)
    {
        rendering.setAllowShowChangeAfterFilter(allowShowChangeAfterFilter);
        return (J) this;
    }

    /**
     * Set to true to enable pagination.
     */
    public @Nullable Boolean getPagination()
    {
        return pagination.getPagination();
    }

    /**
     * Set to true to enable pagination.
     */
    @SuppressWarnings("unchecked")
    public J setPagination(@Nullable Boolean pagination)
    {
        this.pagination.setPagination(pagination);
        return (J) this;
    }

    /**
     * Set the pagination page size.
     */
    @SuppressWarnings("unchecked")
    public J setPaginationPageSize(@Nullable Integer paginationPageSize)
    {
        this.pagination.setPaginationPageSize(paginationPageSize);
        return (J) this;
    }

    /**
     * Set the pagination page size selector.
     */
    public @Nullable Object getPaginationPageSizeSelector()
    {
        return pagination.getPaginationPageSizeSelector();
    }

    /**
     * Set the pagination page size selector.
     */
    @SuppressWarnings("unchecked")
    public J setPaginationPageSizeSelector(@Nullable Object paginationPageSizeSelector)
    {
        this.pagination.setPaginationPageSizeSelector(paginationPageSizeSelector);
        return (J) this;
    }

    /**
     * Set to true to suppress the pagination panel.
     */
    public @Nullable Boolean getSuppressPaginationPanel()
    {
        return pagination.getSuppressPaginationPanel();
    }

    /**
     * Set to true to suppress the pagination panel.
     */
    @SuppressWarnings("unchecked")
    public J setSuppressPaginationPanel(@Nullable Boolean suppressPaginationPanel)
    {
        this.pagination.setSuppressPaginationPanel(suppressPaginationPanel);
        return (J) this;
    }

    /**
     * Set to true to suppress pagination get rows.
     */
    public @Nullable Boolean getSuppressPaginationGetRows()
    {
        return pagination.getSuppressPaginationGetRows();
    }

    /**
     * Set to true to suppress pagination get rows.
     */
    @SuppressWarnings("unchecked")
    public J setSuppressPaginationGetRows(@Nullable Boolean suppressPaginationGetRows)
    {
        this.pagination.setSuppressPaginationGetRows(suppressPaginationGetRows);
        return (J) this;
    }

    /**
     * Set to true to suppress the column move animation.
     */
    public @Nullable Boolean getSuppressColumnMoveAnimation()
    {
        return columnManagement.getSuppressColumnMoveAnimation();
    }

    /**
     * Set to true to suppress the column move animation.
     */
    @SuppressWarnings("unchecked")
    public J setSuppressColumnMoveAnimation(@Nullable Boolean suppressColumnMoveAnimation)
    {
        this.columnManagement.setSuppressColumnMoveAnimation(suppressColumnMoveAnimation);
        return (J) this;
    }

    /**
     * Set to true to suppress drag leave hides columns.
     */
    public @Nullable Boolean getSuppressDragLeaveHidesColumns()
    {
        return columnManagement.getSuppressDragLeaveHidesColumns();
    }

    /**
     * Set to true to suppress drag leave hides columns.
     */
    @SuppressWarnings("unchecked")
    public J setSuppressDragLeaveHidesColumns(@Nullable Boolean suppressDragLeaveHidesColumns)
    {
        this.columnManagement.setSuppressDragLeaveHidesColumns(suppressDragLeaveHidesColumns);
        return (J) this;
    }

    /**
     * Set to true to suppress move when column dragging.
     */
    public @Nullable Boolean getSuppressMoveWhenColumnDragging()
    {
        return columnManagement.getSuppressMoveWhenColumnDragging();
    }

    /**
     * Set to true to suppress move when column dragging.
     */
    @SuppressWarnings("unchecked")
    public J setSuppressMoveWhenColumnDragging(@Nullable Boolean suppressMoveWhenColumnDragging)
    {
        this.columnManagement.setSuppressMoveWhenColumnDragging(suppressMoveWhenColumnDragging);
        return (J) this;
    }

    /**
     * Set to true to suppress drag column into group.
     */
    public @Nullable Boolean getSuppressDragColumnIntoGroup()
    {
        return columnManagement.getSuppressDragColumnIntoGroup();
    }

    /**
     * Set to true to suppress drag column into group.
     */
    @SuppressWarnings("unchecked")
    public J setSuppressDragColumnIntoGroup(@Nullable Boolean suppressDragColumnIntoGroup)
    {
        this.columnManagement.setSuppressDragColumnIntoGroup(suppressDragColumnIntoGroup);
        return (J) this;
    }

    /**
     * Set to true to suppress cut on key.
     */
    public @Nullable Boolean getSuppressCutOnKey()
    {
        return columnManagement.getSuppressCutOnKey();
    }

    /**
     * Set to true to suppress cut on key.
     */
    @SuppressWarnings("unchecked")
    public J setSuppressCutOnKey(@Nullable Boolean suppressCutOnKey)
    {
        this.columnManagement.setSuppressCutOnKey(suppressCutOnKey);
        return (J) this;
    }

    /**
     * Set to true to suppress clipboard paste.
     */
    public @Nullable Boolean getSuppressClipboardPaste()
    {
        return columnManagement.getSuppressClipboardPaste();
    }

    /**
     * Set to true to suppress clipboard paste.
     */
    @SuppressWarnings("unchecked")
    public J setSuppressClipboardPaste(@Nullable Boolean suppressClipboardPaste)
    {
        this.columnManagement.setSuppressClipboardPaste(suppressClipboardPaste);
        return (J) this;
    }

    /**
     * Set to true to suppress last empty line persistence.
     */
    public @Nullable Boolean getSuppressLastEmptyLinePeristance()
    {
        return columnManagement.getSuppressLastEmptyLinePeristance();
    }

    /**
     * Set to true to suppress last empty line persistence.
     */
    @SuppressWarnings("unchecked")
    public J setSuppressLastEmptyLinePeristance(@Nullable Boolean suppressLastEmptyLinePeristance)
    {
        this.columnManagement.setSuppressLastEmptyLinePeristance(suppressLastEmptyLinePeristance);
        return (J) this;
    }

    /**
     * Set to true to suppress focus after filter changed.
     */
    public @Nullable Boolean getSuppressFocusAfterFilterChanged()
    {
        return columnManagement.getSuppressFocusAfterFilterChanged();
    }

    /**
     * Set to true to suppress focus after filter changed.
     */
    @SuppressWarnings("unchecked")
    public J setSuppressFocusAfterFilterChanged(@Nullable Boolean suppressFocusAfterFilterChanged)
    {
        this.columnManagement.setSuppressFocusAfterFilterChanged(suppressFocusAfterFilterChanged);
        return (J) this;
    }

    /**
     * Set to true to suppress row click selection.
     */
    public @Nullable Boolean getSuppressRowClickSelection()
    {
        return columnManagement.getSuppressRowClickSelection();
    }

    /**
     * Set to true to suppress row click selection.
     */
    @SuppressWarnings("unchecked")
    public J setSuppressRowClickSelection(@Nullable Boolean suppressRowClickSelection)
    {
        this.columnManagement.setSuppressRowClickSelection(suppressRowClickSelection);
        return (J) this;
    }

    /**
     * Set to true to suppress cell click selection.
     */
    public @Nullable Boolean getSuppressCellClickSelection()
    {
        return columnManagement.getSuppressCellClickSelection();
    }

    /**
     * Set to true to suppress cell click selection.
     */
    @SuppressWarnings("unchecked")
    public J setSuppressCellClickSelection(@Nullable Boolean suppressCellClickSelection)
    {
        this.columnManagement.setSuppressCellClickSelection(suppressCellClickSelection);
        return (J) this;
    }

    /**
     * Set the header height.
     */
    public @Nullable Integer getHeaderHeight()
    {
        return headerSizing.getHeaderHeight();
    }

    /**
     * Set the header height.
     */
    @SuppressWarnings("unchecked")
    public J setHeaderHeight(@Nullable Integer headerHeight)
    {
        this.headerSizing.setHeaderHeight(headerHeight);
        return (J) this;
    }

    /**
     * Set the group header height.
     */
    public @Nullable Integer getGroupHeaderHeight()
    {
        return headerSizing.getGroupHeaderHeight();
    }

    /**
     * Set the group header height.
     */
    @SuppressWarnings("unchecked")
    public J setGroupHeaderHeight(@Nullable Integer groupHeaderHeight)
    {
        this.headerSizing.setGroupHeaderHeight(groupHeaderHeight);
        return (J) this;
    }

    /**
     * Set the floating filters height.
     */
    public @Nullable Integer getFloatingFiltersHeight()
    {
        return headerSizing.getFloatingFiltersHeight();
    }

    /**
     * Set the floating filters height.
     */
    @SuppressWarnings("unchecked")
    public J setFloatingFiltersHeight(@Nullable Integer floatingFiltersHeight)
    {
        this.headerSizing.setFloatingFiltersHeight(floatingFiltersHeight);
        return (J) this;
    }

    /**
     * Set the pivot header height.
     */
    public @Nullable Integer getPivotHeaderHeight()
    {
        return headerSizing.getPivotHeaderHeight();
    }

    /**
     * Set the pivot header height.
     */
    @SuppressWarnings("unchecked")
    public J setPivotHeaderHeight(@Nullable Integer pivotHeaderHeight)
    {
        this.headerSizing.setPivotHeaderHeight(pivotHeaderHeight);
        return (J) this;
    }

    /**
     * Set the pivot group header height.
     */
    public @Nullable Integer getPivotGroupHeaderHeight()
    {
        return headerSizing.getPivotGroupHeaderHeight();
    }

    /**
     * Set the pivot group header height.
     */
    @SuppressWarnings("unchecked")
    public J setPivotGroupHeaderHeight(@Nullable Integer pivotGroupHeaderHeight)
    {
        this.headerSizing.setPivotGroupHeaderHeight(pivotGroupHeaderHeight);
        return (J) this;
    }

    /**
     * Set to true to enable auto header height.
     */
    public @Nullable Boolean getAutoHeaderHeight()
    {
        return headerSizing.getAutoHeaderHeight();
    }

    /**
     * Set to true to enable auto header height.
     */
    @SuppressWarnings("unchecked")
    public J setAutoHeaderHeight(@Nullable Boolean autoHeaderHeight)
    {
        this.headerSizing.setAutoHeaderHeight(autoHeaderHeight);
        return (J) this;
    }

    /**
     * Set to true to hide padded header rows.
     */
    public @Nullable Boolean getHidePaddedHeaderRows()
    {
        return headerSizing.getHidePaddedHeaderRows();
    }

    /**
     * Set to true to hide padded header rows.
     */
    @SuppressWarnings("unchecked")
    public J setHidePaddedHeaderRows(@Nullable Boolean hidePaddedHeaderRows)
    {
        this.headerSizing.setHidePaddedHeaderRows(hidePaddedHeaderRows);
        return (J) this;
    }

    /**
     * Set the single click edit behavior.
     */
    public @Nullable Boolean getSingleClickEdit()
    {
        return editing.getSingleClickEdit();
    }

    /**
     * Set the single click edit behavior.
     */
    @SuppressWarnings("unchecked")
    public J setSingleClickEdit(@Nullable Boolean singleClickEdit)
    {
        this.editing.setSingleClickEdit(singleClickEdit);
        return (J) this;
    }

    /**
     * Set to true to suppress click edit.
     */
    public @Nullable Boolean getSuppressClickEdit()
    {
        return editing.getSuppressClickEdit();
    }

    /**
     * Set to true to suppress click edit.
     */
    @SuppressWarnings("unchecked")
    public J setSuppressClickEdit(@Nullable Boolean suppressClickEdit)
    {
        this.editing.setSuppressClickEdit(suppressClickEdit);
        return (J) this;
    }

    /**
     * Set to true to stop editing when cells lose focus.
     */
    public @Nullable Boolean getStopEditingWhenCellsLoseFocus()
    {
        return editing.getStopEditingWhenCellsLoseFocus();
    }

    /**
     * Set to true to stop editing when cells lose focus.
     */
    @SuppressWarnings("unchecked")
    public J setStopEditingWhenCellsLoseFocus(@Nullable Boolean stopEditingWhenCellsLoseFocus)
    {
        this.editing.setStopEditingWhenCellsLoseFocus(stopEditingWhenCellsLoseFocus);
        return (J) this;
    }

    /**
     * Set to true to stop editing when grid loses focus.
     */
    public @Nullable Boolean getStopEditingWhenGridLosesFocus()
    {
        return editing.getStopEditingWhenGridLosesFocus();
    }

    /**
     * Set to true to stop editing when grid loses focus.
     */
    @SuppressWarnings("unchecked")
    public J setStopEditingWhenGridLosesFocus(@Nullable Boolean stopEditingWhenGridLosesFocus)
    {
        this.editing.setStopEditingWhenGridLosesFocus(stopEditingWhenGridLosesFocus);
        return (J) this;
    }

    /**
     * Set to true if enter moves focus down.
     */
    public @Nullable Boolean getEnterMovesDown()
    {
        return editing.getEnterMovesDown();
    }

    /**
     * Set to true if enter moves focus down.
     */
    @SuppressWarnings("unchecked")
    public J setEnterMovesDown(@Nullable Boolean enterMovesDown)
    {
        this.editing.setEnterMovesDown(enterMovesDown);
        return (J) this;
    }

    /**
     * Set to true if enter moves focus down after edit.
     */
    public @Nullable Boolean getEnterMovesDownAfterEdit()
    {
        return editing.getEnterMovesDownAfterEdit();
    }

    /**
     * Set to true if enter moves focus down after edit.
     */
    @SuppressWarnings("unchecked")
    public J setEnterMovesDownAfterEdit(@Nullable Boolean enterMovesDownAfterEdit)
    {
        this.editing.setEnterMovesDownAfterEdit(enterMovesDownAfterEdit);
        return (J) this;
    }

    /**
     * Set the suppress keyboard event callback.
     */
    public @Nullable String getSuppressKeyboardEvent()
    {
        return editing.getSuppressKeyboardEvent();
    }

    /**
     * Set the suppress keyboard event callback.
     */
    @SuppressWarnings("unchecked")
    public J setSuppressKeyboardEvent(@Nullable String suppressKeyboardEvent)
    {
        this.editing.setSuppressKeyboardEvent(suppressKeyboardEvent);
        return (J) this;
    }

    /**
     * Set the quick filter text.
     */
    public @Nullable String getQuickFilterText()
    {
        return filtering.getQuickFilterText();
    }

    /**
     * Set the quick filter text.
     */
    @SuppressWarnings("unchecked")
    public J setQuickFilterText(@Nullable String quickFilterText)
    {
        this.filtering.setQuickFilterText(quickFilterText);
        return (J) this;
    }

    /**
     * Set to true to enable case insensitive sort.
     */
    public @Nullable Boolean getCaseInsensitiveSort()
    {
        return filtering.getCaseInsensitiveSort();
    }

    /**
     * Set to true to enable case insensitive sort.
     */
    @SuppressWarnings("unchecked")
    public J setCaseInsensitiveSort(@Nullable Boolean caseInsensitiveSort)
    {
        this.filtering.setCaseInsensitiveSort(caseInsensitiveSort);
        return (J) this;
    }

    /**
     * Set to true to enable floating filter.
     */
    public @Nullable Boolean getFloatingFilter()
    {
        return filtering.getFloatingFilter();
    }

    /**
     * Set to true to enable floating filter.
     */
    @SuppressWarnings("unchecked")
    public J setFloatingFilter(@Nullable Boolean floatingFilter)
    {
        this.filtering.setFloatingFilter(floatingFilter);
        return (J) this;
    }

    /**
     * Set to true to enable RTL.
     */
    public @Nullable Boolean getEnableRtl()
    {
        return filtering.getEnableRtl();
    }

    /**
     * Set to true to enable RTL.
     */
    @SuppressWarnings("unchecked")
    public J setEnableRtl(@Nullable Boolean enableRtl)
    {
        this.filtering.setEnableRtl(enableRtl);
        return (J) this;
    }

    /**
     * Set the external filter changed callback.
     */
    public @Nullable String getExternalFilterChanged()
    {
        return filtering.getExternalFilterChanged();
    }

    /**
     * Set the external filter changed callback.
     */
    @SuppressWarnings("unchecked")
    public J setExternalFilterChanged(@Nullable String externalFilterChanged)
    {
        this.filtering.setExternalFilterChanged(externalFilterChanged);
        return (J) this;
    }

    /**
     * Set the is external filter present callback.
     */
    public @Nullable String getIsExternalFilterPresent()
    {
        return filtering.getIsExternalFilterPresent();
    }

    /**
     * Set the is external filter present callback.
     */
    @SuppressWarnings("unchecked")
    public J setIsExternalFilterPresent(@Nullable String isExternalFilterPresent)
    {
        this.filtering.setIsExternalFilterPresent(isExternalFilterPresent);
        return (J) this;
    }

    /**
     * Set the does external filter pass callback.
     */
    public @Nullable String getDoesExternalFilterPass()
    {
        return filtering.getDoesExternalFilterPass();
    }

    /**
     * Set the does external filter pass callback.
     */
    @SuppressWarnings("unchecked")
    public J setDoesExternalFilterPass(@Nullable String doesExternalFilterPass)
    {
        this.filtering.setDoesExternalFilterPass(doesExternalFilterPass);
        return (J) this;
    }

    /**
     * Set the on filter changed callback.
     */
    public @Nullable String getOnFilterChanged()
    {
        return filtering.getOnFilterChanged();
    }

    /**
     * Set the on filter changed callback.
     */
    @SuppressWarnings("unchecked")
    public J setOnFilterChanged(@Nullable String onFilterChanged)
    {
        this.filtering.setOnFilterChanged(onFilterChanged);
        return (J) this;
    }

    /**
     * Set to true to suppress Excel export.
     */
    public @Nullable Boolean getSuppressExcelExport()
    {
        return export.getSuppressExcelExport();
    }

    /**
     * Set to true to suppress Excel export.
     */
    @SuppressWarnings("unchecked")
    public J setSuppressExcelExport(@Nullable Boolean suppressExcelExport)
    {
        this.export.setSuppressExcelExport(suppressExcelExport);
        return (J) this;
    }

    /**
     * Set to true to suppress CSV export.
     */
    public @Nullable Boolean getSuppressCsvExport()
    {
        return export.getSuppressCsvExport();
    }

    /**
     * Set to true to suppress CSV export.
     */
    @SuppressWarnings("unchecked")
    public J setSuppressCsvExport(@Nullable Boolean suppressCsvExport)
    {
        this.export.setSuppressCsvExport(suppressCsvExport);
        return (J) this;
    }

    /**
     * Set to true to suppress PDF export.
     */
    public @Nullable Boolean getSuppressPdfExport()
    {
        return export.getSuppressPdfExport();
    }

    /**
     * Set to true to suppress PDF export.
     */
    @SuppressWarnings("unchecked")
    public J setSuppressPdfExport(@Nullable Boolean suppressPdfExport)
    {
        this.export.setSuppressPdfExport(suppressPdfExport);
        return (J) this;
    }

    /**
     * Set the column separator for export.
     */
    public @Nullable String getColumnSeparator()
    {
        return export.getColumnSeparator();
    }

    /**
     * Set the column separator for export.
     */
    @SuppressWarnings("unchecked")
    public J setColumnSeparator(@Nullable String columnSeparator)
    {
        this.export.setColumnSeparator(columnSeparator);
        return (J) this;
    }

    /**
     * Set the row selection mode.
     */
    public @Nullable RowSelectionMode getRowSelection()
    {
        return selectionExpanded.getRowSelection();
    }

    /**
     * Set the row selection mode.
     */
    @SuppressWarnings("unchecked")
    public J setRowSelection(@Nullable RowSelectionMode rowSelection)
    {
        this.selectionExpanded.setRowSelection(rowSelection);
        return (J) this;
    }

    /**
     * Set to true to enable row multi select with click.
     */
    public @Nullable Boolean getRowMultiSelectWithClick()
    {
        return selectionExpanded.getRowMultiSelectWithClick();
    }

    /**
     * Set to true to enable row multi select with click.
     */
    @SuppressWarnings("unchecked")
    public J setRowMultiSelectWithClick(@Nullable Boolean rowMultiSelectWithClick)
    {
        this.selectionExpanded.setRowMultiSelectWithClick(rowMultiSelectWithClick);
        return (J) this;
    }

    /**
     * Set to true to suppress row deselection.
     */
    public @Nullable Boolean getSuppressRowDeselection()
    {
        return selectionExpanded.getSuppressRowDeselection();
    }

    /**
     * Set to true to suppress row deselection.
     */
    @SuppressWarnings("unchecked")
    public J setSuppressRowDeselection(@Nullable Boolean suppressRowDeselection)
    {
        this.selectionExpanded.setSuppressRowDeselection(suppressRowDeselection);
        return (J) this;
    }

    /**
     * Set to true to suppress cell selection.
     */
    public @Nullable Boolean getSuppressCellSelection()
    {
        return selectionExpanded.getSuppressCellSelection();
    }

    /**
     * Set to true to suppress cell selection.
     */
    @SuppressWarnings("unchecked")
    public J setSuppressCellSelection(@Nullable Boolean suppressCellSelection)
    {
        this.selectionExpanded.setSuppressCellSelection(suppressCellSelection);
        return (J) this;
    }

    /**
     * Set to true to suppress multi range selection.
     */
    public @Nullable Boolean getSuppressMultiRangeSelection()
    {
        return selectionExpanded.getSuppressMultiRangeSelection();
    }

    /**
     * Set to true to suppress multi range selection.
     */
    @SuppressWarnings("unchecked")
    public J setSuppressMultiRangeSelection(@Nullable Boolean suppressMultiRangeSelection)
    {
        this.selectionExpanded.setSuppressMultiRangeSelection(suppressMultiRangeSelection);
        return (J) this;
    }

    /**
     * Set to true to suppress multi sort.
     */
    public @Nullable Boolean getSuppressMultiSort()
    {
        return selectionExpanded.getSuppressMultiSort();
    }

    /**
     * Set to true to suppress multi sort.
     */
    @SuppressWarnings("unchecked")
    public J setSuppressMultiSort(@Nullable Boolean suppressMultiSort)
    {
        this.selectionExpanded.setSuppressMultiSort(suppressMultiSort);
        return (J) this;
    }

    /**
     * Set to true to enable advanced filter.
     */
    public @Nullable Boolean getEnableAdvancedFilter()
    {
        return advancedFilter.getEnableAdvancedFilter();
    }

    /**
     * Set to true to enable advanced filter.
     */
    @SuppressWarnings("unchecked")
    public J setEnableAdvancedFilter(@Nullable Boolean enableAdvancedFilter)
    {
        this.advancedFilter.setEnableAdvancedFilter(enableAdvancedFilter);
        return (J) this;
    }

    /**
     * Set the advanced filter builder params.
     */
    public @Nullable String getAdvancedFilterBuilderParams()
    {
        return advancedFilter.getAdvancedFilterBuilderParams();
    }

    /**
     * Set the advanced filter builder params.
     */
    @SuppressWarnings("unchecked")
    public J setAdvancedFilterBuilderParams(@Nullable String advancedFilterBuilderParams)
    {
        this.advancedFilter.setAdvancedFilterBuilderParams(advancedFilterBuilderParams);
        return (J) this;
    }

    /**
     * Set the advanced filter parent element.
     */
    public @Nullable String getAdvancedFilterParentElement()
    {
        return advancedFilter.getAdvancedFilterParentElement();
    }

    /**
     * Set the advanced filter parent element.
     */
    @SuppressWarnings("unchecked")
    public J setAdvancedFilterParentElement(@Nullable String advancedFilterParentElement)
    {
        this.advancedFilter.setAdvancedFilterParentElement(advancedFilterParentElement);
        return (J) this;
    }

    /**
     * Set the advanced filter class name.
     */
    public @Nullable String getAdvancedFilterClassName()
    {
        return advancedFilter.getAdvancedFilterClassName();
    }

    /**
     * Set the advanced filter class name.
     */
    @SuppressWarnings("unchecked")
    public J setAdvancedFilterClassName(@Nullable String advancedFilterClassName)
    {
        this.advancedFilter.setAdvancedFilterClassName(advancedFilterClassName);
        return (J) this;
    }

    /**
     * Set the on advanced filter changed callback.
     */
    public @Nullable String getOnAdvancedFilterChanged()
    {
        return advancedFilter.getOnAdvancedFilterChanged();
    }

    /**
     * Set the on advanced filter changed callback.
     */
    @SuppressWarnings("unchecked")
    public J setOnAdvancedFilterChanged(@Nullable String onAdvancedFilterChanged)
    {
        this.advancedFilter.setOnAdvancedFilterChanged(onAdvancedFilterChanged);
        return (J) this;
    }

    /**
     * Set the row group panel show behavior.
     */
    public @Nullable String getRowGroupPanelShow()
    {
        return rowGrouping.getRowGroupPanelShow();
    }

    /**
     * Set the row group panel show behavior.
     */
    @SuppressWarnings("unchecked")
    public J setRowGroupPanelShow(@Nullable String rowGroupPanelShow)
    {
        this.rowGrouping.setRowGroupPanelShow(rowGroupPanelShow);
        return (J) this;
    }

    /**
     * Set the pivot mode.
     */
    public @Nullable Boolean getPivotMode()
    {
        return rowPivoting.getPivotMode();
    }

    /**
     * Set the pivot mode.
     */
    @SuppressWarnings("unchecked")
    public J setPivotMode(@Nullable Boolean pivotMode)
    {
        this.rowPivoting.setPivotMode(pivotMode);
        return (J) this;
    }

    /**
     * Set the pivot panel show behavior.
     */
    public @Nullable String getPivotPanelShow()
    {
        return rowPivoting.getPivotPanelShow();
    }

    /**
     * Set the pivot panel show behavior.
     */
    @SuppressWarnings("unchecked")
    public J setPivotPanelShow(@Nullable String pivotPanelShow)
    {
        this.rowPivoting.setPivotPanelShow(pivotPanelShow);
        return (J) this;
    }

    /**
     * Set the server side datasource.
     */
    public @Nullable String getServerSideDatasource()
    {
        return serverSideRowModel.getServerSideDatasource();
    }

    /**
     * Set the server side datasource.
     */
    @SuppressWarnings("unchecked")
    public J setServerSideDatasource(@Nullable String serverSideDatasource)
    {
        this.serverSideRowModel.setServerSideDatasource(serverSideDatasource);
        return (J) this;
    }

    /**
     * Set the cache block size.
     */
    public @Nullable Integer getCacheBlockSize()
    {
        return serverSideRowModel.getCacheBlockSize();
    }

    /**
     * Set the cache block size.
     */
    @SuppressWarnings("unchecked")
    public J setCacheBlockSize(@Nullable Integer cacheBlockSize)
    {
        this.serverSideRowModel.setCacheBlockSize(cacheBlockSize);
        return (J) this;
    }

    /**
     * Set the max blocks in cache.
     */
    public @Nullable Integer getMaxBlocksInCache()
    {
        return serverSideRowModel.getMaxBlocksInCache();
    }

    /**
     * Set the max blocks in cache.
     */
    @SuppressWarnings("unchecked")
    public J setMaxBlocksInCache(@Nullable Integer maxBlocksInCache)
    {
        this.serverSideRowModel.setMaxBlocksInCache(maxBlocksInCache);
        return (J) this;
    }

    /**
     * Set the group display type.
     */
    public @Nullable String getGroupDisplayType()
    {
        return rowGrouping.getGroupDisplayType();
    }

    /**
     * Set the group display type.
     */
    @SuppressWarnings("unchecked")
    public J setGroupDisplayType(@Nullable String groupDisplayType)
    {
        this.rowGrouping.setGroupDisplayType(groupDisplayType);
        return (J) this;
    }

    /**
     * Set the group row renderer.
     */
    public @Nullable String getGroupRowRenderer()
    {
        return rowGrouping.getGroupRowRenderer();
    }

    /**
     * Set the group row renderer.
     */
    @SuppressWarnings("unchecked")
    public J setGroupRowRenderer(@Nullable String groupRowRenderer)
    {
        this.rowGrouping.setGroupRowRenderer(groupRowRenderer);
        return (J) this;
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
				@JsonIgnore
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
}
