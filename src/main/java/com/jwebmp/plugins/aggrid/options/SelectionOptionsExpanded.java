package com.jwebmp.plugins.aggrid.options;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jwebmp.plugins.aggrid.options.enums.RowSelectionMode;
import org.jspecify.annotations.Nullable;

/**
 * AG Grid Selection Options.
 * Configures row and cell selection behavior.
 *
 * @author DevSuite
 * @since 2025
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SelectionOptionsExpanded<J extends SelectionOptionsExpanded<J>>
{
    @JsonProperty("rowSelection")
    private @Nullable RowSelectionMode rowSelection;

    @JsonProperty("cellSelection")
    private @Nullable String cellSelection;

    @JsonProperty("rowMultiSelectWithClick")
    private @Nullable Boolean rowMultiSelectWithClick;

    @JsonProperty("suppressRowDeselection")
    private @Nullable Boolean suppressRowDeselection;

    @JsonProperty("suppressCellSelection")
    private @Nullable Boolean suppressCellSelection;

    @JsonProperty("suppressMultiRangeSelection")
    private @Nullable Boolean suppressMultiRangeSelection;

    @JsonProperty("suppressMultiSort")
    private @Nullable Boolean suppressMultiSort;

    // Getters

    public @Nullable RowSelectionMode getRowSelection()
    {
        return rowSelection;
    }

    public @Nullable String getCellSelection()
    {
        return cellSelection;
    }

    public @Nullable Boolean getRowMultiSelectWithClick()
    {
        return rowMultiSelectWithClick;
    }

    public @Nullable Boolean getSuppressRowDeselection()
    {
        return suppressRowDeselection;
    }

    public @Nullable Boolean getSuppressCellSelection()
    {
        return suppressCellSelection;
    }

    public @Nullable Boolean getSuppressMultiRangeSelection()
    {
        return suppressMultiRangeSelection;
    }

    public @Nullable Boolean getSuppressMultiSort()
    {
        return suppressMultiSort;
    }

    // Setters with CRTP return type

    @SuppressWarnings("unchecked")
    public J setRowSelection(@Nullable RowSelectionMode rowSelection)
    {
        this.rowSelection = rowSelection;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setCellSelection(@Nullable String cellSelection)
    {
        this.cellSelection = cellSelection;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setRowMultiSelectWithClick(@Nullable Boolean rowMultiSelectWithClick)
    {
        this.rowMultiSelectWithClick = rowMultiSelectWithClick;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setSuppressRowDeselection(@Nullable Boolean suppressRowDeselection)
    {
        this.suppressRowDeselection = suppressRowDeselection;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setSuppressCellSelection(@Nullable Boolean suppressCellSelection)
    {
        this.suppressCellSelection = suppressCellSelection;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setSuppressMultiRangeSelection(@Nullable Boolean suppressMultiRangeSelection)
    {
        this.suppressMultiRangeSelection = suppressMultiRangeSelection;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setSuppressMultiSort(@Nullable Boolean suppressMultiSort)
    {
        this.suppressMultiSort = suppressMultiSort;
        return (J) this;
    }
}
