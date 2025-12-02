package com.jwebmp.plugins.aggrid.options;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import org.jspecify.annotations.Nullable;

/**
 * AG Grid Pagination Options.
 * Configures pagination behavior for displaying data in pages.
 *
 * @author DevSuite
 * @since 2025
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaginationOptions<J extends PaginationOptions<J>>
{
    @JsonProperty("pagination")
    private @Nullable Boolean pagination;

    @JsonProperty("paginationPageSize")
    private @Nullable Integer paginationPageSize;

    @JsonProperty("paginationPageSizeSelector")
    private @Nullable Object paginationPageSizeSelector;

    @JsonProperty("suppressPaginationPanel")
    private @Nullable Boolean suppressPaginationPanel;

    @JsonProperty("suppressPaginationGetRows")
    private @Nullable Boolean suppressPaginationGetRows;

    // Getters

    public @Nullable Boolean getPagination()
    {
        return pagination;
    }

    public @Nullable Integer getPaginationPageSize()
    {
        return paginationPageSize;
    }

    public @Nullable Object getPaginationPageSizeSelector()
    {
        return paginationPageSizeSelector;
    }

    public @Nullable Boolean getSuppressPaginationPanel()
    {
        return suppressPaginationPanel;
    }

    public @Nullable Boolean getSuppressPaginationGetRows()
    {
        return suppressPaginationGetRows;
    }

    // Setters with CRTP return type

    @SuppressWarnings("unchecked")
    public J setPagination(@Nullable Boolean pagination)
    {
        this.pagination = pagination;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setPaginationPageSize(@Nullable Integer paginationPageSize)
    {
        this.paginationPageSize = paginationPageSize;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setPaginationPageSizeSelector(@Nullable Object paginationPageSizeSelector)
    {
        this.paginationPageSizeSelector = paginationPageSizeSelector;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setSuppressPaginationPanel(@Nullable Boolean suppressPaginationPanel)
    {
        this.suppressPaginationPanel = suppressPaginationPanel;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setSuppressPaginationGetRows(@Nullable Boolean suppressPaginationGetRows)
    {
        this.suppressPaginationGetRows = suppressPaginationGetRows;
        return (J) this;
    }
}
