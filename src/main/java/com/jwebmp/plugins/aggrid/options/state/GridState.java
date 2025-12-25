package com.jwebmp.plugins.aggrid.options.state;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jwebmp.core.base.angular.client.annotations.angular.NgDataType;
import com.jwebmp.core.base.angular.client.services.interfaces.INgDataType;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import org.jspecify.annotations.Nullable;

import java.util.List;
import java.util.Map;

/**
 * Represents the state of AG Grid.
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NgDataType
public class GridState<J extends GridState<J>> implements INgDataType<J>
{
    @JsonProperty("column")
    public @Nullable ColumnGroupState<?> column;

    @JsonProperty("filter")
    public @Nullable FilterState<?> filter;

    @JsonProperty("rowGroup")
    public @Nullable RowGroupState<?> rowGroup;

    @JsonProperty("pivot")
    public @Nullable PivotState<?> pivot;

    @JsonProperty("columnSelection")
    public @Nullable ColumnSelectionState<?> columnSelection;

    @JsonProperty("rangeSelection")
    public @Nullable RangeSelectionState<?> rangeSelection;

    @JsonProperty("scroll")
    public @Nullable ScrollState<?> scroll;

    @JsonProperty("sideBar")
    public @Nullable SideBarState<?> sideBar;

    @JsonProperty("focusedCell")
    public @Nullable FocusedCellState<?> focusedCell;

    @JsonProperty("pagination")
    public @Nullable PaginationState<?> pagination;

    public @Nullable ColumnGroupState<?> getColumn() { return column; }
    @SuppressWarnings("unchecked")
    public J setColumn(@Nullable ColumnGroupState<?> column) { this.column = column; return (J) this; }

    public @Nullable FilterState<?> getFilter() { return filter; }
    @SuppressWarnings("unchecked")
    public J setFilter(@Nullable FilterState<?> filter) { this.filter = filter; return (J) this; }

    public @Nullable RowGroupState<?> getRowGroup() { return rowGroup; }
    @SuppressWarnings("unchecked")
    public J setRowGroup(@Nullable RowGroupState<?> rowGroup) { this.rowGroup = rowGroup; return (J) this; }

    public @Nullable PivotState<?> getPivot() { return pivot; }
    @SuppressWarnings("unchecked")
    public J setPivot(@Nullable PivotState<?> pivot) { this.pivot = pivot; return (J) this; }

    public @Nullable ColumnSelectionState<?> getColumnSelection() { return columnSelection; }
    @SuppressWarnings("unchecked")
    public J setColumnSelection(@Nullable ColumnSelectionState<?> columnSelection) { this.columnSelection = columnSelection; return (J) this; }

    public @Nullable RangeSelectionState<?> getRangeSelection() { return rangeSelection; }
    @SuppressWarnings("unchecked")
    public J setRangeSelection(@Nullable RangeSelectionState<?> rangeSelection) { this.rangeSelection = rangeSelection; return (J) this; }

    public @Nullable ScrollState<?> getScroll() { return scroll; }
    @SuppressWarnings("unchecked")
    public J setScroll(@Nullable ScrollState<?> scroll) { this.scroll = scroll; return (J) this; }

    public @Nullable SideBarState<?> getSideBar() { return sideBar; }
    @SuppressWarnings("unchecked")
    public J setSideBar(@Nullable SideBarState<?> sideBar) { this.sideBar = sideBar; return (J) this; }

    public @Nullable FocusedCellState<?> getFocusedCell() { return focusedCell; }
    @SuppressWarnings("unchecked")
    public J setFocusedCell(@Nullable FocusedCellState<?> focusedCell) { this.focusedCell = focusedCell; return (J) this; }

    public @Nullable PaginationState<?> getPagination() { return pagination; }
    @SuppressWarnings("unchecked")
    public J setPagination(@Nullable PaginationState<?> pagination) { this.pagination = pagination; return (J) this; }

}
