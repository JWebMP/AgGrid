package com.jwebmp.plugins.aggrid.options;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * AG Grid Header & Sizing Options.
 * Configures header heights, row heights, and auto-sizing behavior.
 *
 * @author DevSuite
 * @since 2025
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HeaderSizingOptions<J extends HeaderSizingOptions<J>>
{
    @JsonProperty("headerHeight")
    private @Nullable Integer headerHeight;

    @JsonProperty("groupHeaderHeight")
    private @Nullable Integer groupHeaderHeight;

    @JsonProperty("floatingFiltersHeight")
    private @Nullable Integer floatingFiltersHeight;

    @JsonProperty("pivotHeaderHeight")
    private @Nullable Integer pivotHeaderHeight;

    @JsonProperty("pivotGroupHeaderHeight")
    private @Nullable Integer pivotGroupHeaderHeight;

    @JsonProperty("autoHeaderHeight")
    private @Nullable Boolean autoHeaderHeight;

    @JsonProperty("hidePaddedHeaderRows")
    private @Nullable Boolean hidePaddedHeaderRows;

    @JsonProperty("rowHeight")
    private @Nullable Integer rowHeight;

    // Getters

    public @Nullable Integer getHeaderHeight()
    {
        return headerHeight;
    }

    public @Nullable Integer getGroupHeaderHeight()
    {
        return groupHeaderHeight;
    }

    public @Nullable Integer getFloatingFiltersHeight()
    {
        return floatingFiltersHeight;
    }

    public @Nullable Integer getPivotHeaderHeight()
    {
        return pivotHeaderHeight;
    }

    public @Nullable Integer getPivotGroupHeaderHeight()
    {
        return pivotGroupHeaderHeight;
    }

    public @Nullable Boolean getAutoHeaderHeight()
    {
        return autoHeaderHeight;
    }

    public @Nullable Boolean getHidePaddedHeaderRows()
    {
        return hidePaddedHeaderRows;
    }

    public @Nullable Integer getRowHeight()
    {
        return rowHeight;
    }

    // Setters with CRTP return type

    @SuppressWarnings("unchecked")
    public J setHeaderHeight(@Nullable Integer headerHeight)
    {
        this.headerHeight = headerHeight;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setGroupHeaderHeight(@Nullable Integer groupHeaderHeight)
    {
        this.groupHeaderHeight = groupHeaderHeight;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setFloatingFiltersHeight(@Nullable Integer floatingFiltersHeight)
    {
        this.floatingFiltersHeight = floatingFiltersHeight;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setPivotHeaderHeight(@Nullable Integer pivotHeaderHeight)
    {
        this.pivotHeaderHeight = pivotHeaderHeight;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setPivotGroupHeaderHeight(@Nullable Integer pivotGroupHeaderHeight)
    {
        this.pivotGroupHeaderHeight = pivotGroupHeaderHeight;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setAutoHeaderHeight(@Nullable Boolean autoHeaderHeight)
    {
        this.autoHeaderHeight = autoHeaderHeight;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setHidePaddedHeaderRows(@Nullable Boolean hidePaddedHeaderRows)
    {
        this.hidePaddedHeaderRows = hidePaddedHeaderRows;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setRowHeight(@Nullable Integer rowHeight)
    {
        this.rowHeight = rowHeight;
        return (J) this;
    }
}
