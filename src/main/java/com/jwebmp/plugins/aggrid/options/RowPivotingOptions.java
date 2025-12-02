package com.jwebmp.plugins.aggrid.options;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * Row Pivoting and Cross-Tabulation Configuration Options for AG Grid
 * Provides all options for row pivoting, pivot panel, and pivot result configuration.
 * Community Edition Feature
 *
 * @param <J> Self-type for fluent CRTP pattern
 * @author YourName
 * @since 2025
 */
public class RowPivotingOptions<J extends RowPivotingOptions<J>> extends JavaScriptPart<J>
{
    // ===== [1] PIVOT MODE & PANEL =====

    /**
     * Whether pivot mode is enabled.
     */
    @JsonProperty("pivotMode")
    private Boolean pivotMode;

    /**
     * Whether to show the pivot panel. Values: 'always', 'onlyWhenPivoting', 'never'.
     */
    @JsonProperty("pivotPanelShow")
    private String pivotPanelShow;

    /**
     * Whether pivot groups are expanded by default.
     */
    @JsonProperty("pivotDefaultExpanded")
    private Integer pivotDefaultExpanded;

    // ===== [2] PIVOT RESULTS & COLUMNS =====

    /**
     * Where to place pivot total rows. Values: 'before', 'after'.
     */
    @JsonProperty("pivotRowTotals")
    private String pivotRowTotals;

    /**
     * Whether to suppress the auto-generated pivot column.
     */
    @JsonProperty("pivotSuppressAutoColumn")
    private Boolean pivotSuppressAutoColumn;

    /**
     * Maximum number of columns to generate from pivoting.
     */
    @JsonProperty("pivotMaxGeneratedColumns")
    private Integer pivotMaxGeneratedColumns;

    /**
     * Callback to process pivot result column definitions. Raw JavaScript.
     */
    @JsonProperty("processPivotResultColDef")
    @JsonRawValue
    private String processPivotResultColDef;

    /**
     * Callback to process pivot result column group definitions. Raw JavaScript.
     */
    @JsonProperty("processPivotResultColGroupDef")
    @JsonRawValue
    private String processPivotResultColGroupDef;

    // ===== [3] PIVOT GROUPS & EXPANSION =====

    /**
     * Whether to suppress expandable pivot groups.
     */
    @JsonProperty("suppressExpandablePivotGroups")
    private Boolean suppressExpandablePivotGroups;

    /**
     * Whether to remove the pivot header row when there's only a single value column.
     */
    @JsonProperty("removePivotHeaderRowWhenSingleValueColumn")
    private Boolean removePivotHeaderRowWhenSingleValueColumn;

    /**
     * Field separator used in pivot result column names.
     */
    @JsonProperty("pivotFieldSeparator")
    private String pivotFieldSeparator;

    // ===== GETTERS & SETTERS =====

    public Boolean getPivotMode()
    {
        return pivotMode;
    }

    public @org.jspecify.annotations.NonNull J setPivotMode(Boolean pivotMode)
    {
        this.pivotMode = pivotMode;
        return (J) this;
    }

    public String getPivotPanelShow()
    {
        return pivotPanelShow;
    }

    public @org.jspecify.annotations.NonNull J setPivotPanelShow(String pivotPanelShow)
    {
        this.pivotPanelShow = pivotPanelShow;
        return (J) this;
    }

    public Integer getPivotDefaultExpanded()
    {
        return pivotDefaultExpanded;
    }

    public @org.jspecify.annotations.NonNull J setPivotDefaultExpanded(Integer pivotDefaultExpanded)
    {
        this.pivotDefaultExpanded = pivotDefaultExpanded;
        return (J) this;
    }

    public String getPivotRowTotals()
    {
        return pivotRowTotals;
    }

    public @org.jspecify.annotations.NonNull J setPivotRowTotals(String pivotRowTotals)
    {
        this.pivotRowTotals = pivotRowTotals;
        return (J) this;
    }

    public Boolean getPivotSuppressAutoColumn()
    {
        return pivotSuppressAutoColumn;
    }

    public @org.jspecify.annotations.NonNull J setPivotSuppressAutoColumn(Boolean pivotSuppressAutoColumn)
    {
        this.pivotSuppressAutoColumn = pivotSuppressAutoColumn;
        return (J) this;
    }

    public Integer getPivotMaxGeneratedColumns()
    {
        return pivotMaxGeneratedColumns;
    }

    public @org.jspecify.annotations.NonNull J setPivotMaxGeneratedColumns(Integer pivotMaxGeneratedColumns)
    {
        this.pivotMaxGeneratedColumns = pivotMaxGeneratedColumns;
        return (J) this;
    }

    public String getProcessPivotResultColDef()
    {
        return processPivotResultColDef;
    }

    public @org.jspecify.annotations.NonNull J setProcessPivotResultColDefRaw(String processPivotResultColDefRawJs)
    {
        this.processPivotResultColDef = processPivotResultColDefRawJs;
        return (J) this;
    }

    public String getProcessPivotResultColGroupDef()
    {
        return processPivotResultColGroupDef;
    }

    public @org.jspecify.annotations.NonNull J setProcessPivotResultColGroupDefRaw(String processPivotResultColGroupDefRawJs)
    {
        this.processPivotResultColGroupDef = processPivotResultColGroupDefRawJs;
        return (J) this;
    }

    public Boolean getSuppressExpandablePivotGroups()
    {
        return suppressExpandablePivotGroups;
    }

    public @org.jspecify.annotations.NonNull J setSuppressExpandablePivotGroups(Boolean suppressExpandablePivotGroups)
    {
        this.suppressExpandablePivotGroups = suppressExpandablePivotGroups;
        return (J) this;
    }

    public Boolean getRemovePivotHeaderRowWhenSingleValueColumn()
    {
        return removePivotHeaderRowWhenSingleValueColumn;
    }

    public @org.jspecify.annotations.NonNull J setRemovePivotHeaderRowWhenSingleValueColumn(Boolean removePivotHeaderRowWhenSingleValueColumn)
    {
        this.removePivotHeaderRowWhenSingleValueColumn = removePivotHeaderRowWhenSingleValueColumn;
        return (J) this;
    }

    public String getPivotFieldSeparator()
    {
        return pivotFieldSeparator;
    }

    public @org.jspecify.annotations.NonNull J setPivotFieldSeparator(String pivotFieldSeparator)
    {
        this.pivotFieldSeparator = pivotFieldSeparator;
        return (J) this;
    }
}
