package com.jwebmp.plugins.aggrid.options;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * AG Grid Export Options.
 * Configures data export functionality (CSV, Excel, etc.).
 *
 * @author DevSuite
 * @since 2025
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExportOptions<J extends ExportOptions<J>>
{
    @JsonProperty("suppressExcelExport")
    private @Nullable Boolean suppressExcelExport;

    @JsonProperty("suppressCsvExport")
    private @Nullable Boolean suppressCsvExport;

    @JsonProperty("suppressPdfExport")
    private @Nullable Boolean suppressPdfExport;

    @JsonProperty("columnSeparator")
    private @Nullable String columnSeparator;

    // Getters

    public @Nullable Boolean getSuppressExcelExport()
    {
        return suppressExcelExport;
    }

    public @Nullable Boolean getSuppressCsvExport()
    {
        return suppressCsvExport;
    }

    public @Nullable Boolean getSuppressPdfExport()
    {
        return suppressPdfExport;
    }

    public @Nullable String getColumnSeparator()
    {
        return columnSeparator;
    }

    // Setters with CRTP return type

    @SuppressWarnings("unchecked")
    public J setSuppressExcelExport(@Nullable Boolean suppressExcelExport)
    {
        this.suppressExcelExport = suppressExcelExport;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setSuppressCsvExport(@Nullable Boolean suppressCsvExport)
    {
        this.suppressCsvExport = suppressCsvExport;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setSuppressPdfExport(@Nullable Boolean suppressPdfExport)
    {
        this.suppressPdfExport = suppressPdfExport;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setColumnSeparator(@Nullable String columnSeparator)
    {
        this.columnSeparator = columnSeparator;
        return (J) this;
    }
}
