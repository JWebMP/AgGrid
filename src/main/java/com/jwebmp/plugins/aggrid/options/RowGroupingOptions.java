package com.jwebmp.plugins.aggrid.options;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

/**
 * Row Grouping and Aggregation Configuration Options for AG Grid
 * Provides all options for row grouping, aggregation, and total row functionality.
 * Community Edition Feature - NEW in v34.2.0
 *
 * @param <J> Self-type for fluent CRTP pattern
 * @author YourName
 * @since 2025
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RowGroupingOptions<J extends RowGroupingOptions<J>> extends JavaScriptPart<J>
{
    // ===== [1] GROUPING DISPLAY & RENDERING =====

    /**
     * How to display groups. Options: 'singleColumn', 'multipleColumns', 'groupRows', 'custom'.
     */
    @JsonProperty("groupDisplayType")
    private String groupDisplayType;

    /**
     * Column definition for the auto group column created by the grid.
     */
    @JsonProperty("autoGroupColumnDef")
    private AgGridColumnDef<?> autoGroupColumnDef;

    /**
     * Cell renderer for group rows.
     */
    @JsonProperty("groupRowRenderer")
    private String groupRowRenderer;

    /**
     * Parameters for the group row renderer.
     */
    @JsonProperty("groupRowRendererParams")
    private Object groupRowRendererParams;

    /**
     * Whether to show the open/closed group indicator.
     */
    @JsonProperty("showOpenedGroup")
    private Boolean showOpenedGroup;

    /**
     * Whether to hide parent groups when they only have one child.
     */
    @JsonProperty("groupHideParentOfSingleChild")
    private Boolean groupHideParentOfSingleChild;

    /**
     * Whether to hide parent groups.
     */
    @JsonProperty("groupHideOpenParents")
    private Boolean groupHideOpenParents;

    /**
     * When selecting a group node, also select its children.
     * See AG Grid: groupSelectsChildren
     */
    @JsonProperty("groupSelectsChildren")
    private Boolean groupSelectsChildren;

    /**
     * When true, select/deselect only filtered children when using group selection.
     */
    @JsonProperty("groupSelectsFiltered")
    private Boolean groupSelectsFiltered;

    // ===== [2] GROUPING EXPANSION & BEHAVIOR =====

    /**
     * Whether groups are expanded by default.
     */
    @JsonProperty("groupDefaultExpanded")
    private Integer groupDefaultExpanded;

    /**
     * Callback to determine if a group is expanded by default. Raw JavaScript.
     */
    @JsonProperty("isGroupOpenByDefault")
    @JsonRawValue
    private String isGroupOpenByDefault;

    /**
     * Whether group rows stick to the top when scrolling.
     */
    @JsonProperty("suppressGroupRowsSticky")
    private Boolean suppressGroupRowsSticky;

    /**
     * Whether the group column can be moved.
     */
    @JsonProperty("groupLockGroupColumns")
    private Integer groupLockGroupColumns;

    /**
     * Whether to maintain the group order.
     */
    @JsonProperty("groupMaintainOrder")
    private Boolean groupMaintainOrder;

    /**
     * Whether to allow unbalanced groups.
     */
    @JsonProperty("groupAllowUnbalanced")
    private Boolean groupAllowUnbalanced;

    /**
     * Comparator for initial group row order. Raw JavaScript.
     */
    @JsonProperty("initialGroupOrderComparator")
    @JsonRawValue
    private String initialGroupOrderComparator;

    // ===== [3] GROUP PANEL & UI =====

    /**
     * Whether to show the Row Group Panel. Values: 'always', 'onlyWhenPivoting', 'never'.
     */
    @JsonProperty("rowGroupPanelShow")
    private String rowGroupPanelShow;

    /**
     * Whether to suppress sorting in the row group panel.
     */
    @JsonProperty("rowGroupPanelSuppressSort")
    private Boolean rowGroupPanelSuppressSort;

    /**
     * Suppress changes to column visibility when grouping.
     */
    @JsonProperty("suppressGroupChangesColumnVisibility")
    private Boolean suppressGroupChangesColumnVisibility;

    /**
     * Group hierarchy configuration. Raw JavaScript object.
     */
    @JsonProperty("groupHierarchyConfig")
    @JsonRawValue
    private String groupHierarchyConfig;

    // ===== [4] AGGREGATION FUNCTIONS =====

    /**
     * Aggregation functions available. Raw JavaScript object.
     */
    @JsonProperty("aggFuncs")
    @JsonRawValue
    private String aggFuncs;

    /**
     * Whether aggregation functions are read-only.
     */
    @JsonProperty("functionsReadOnly")
    private Boolean functionsReadOnly;

    /**
     * Whether to suppress the aggregation function name in the header.
     */
    @JsonProperty("suppressAggFuncInHeader")
    private Boolean suppressAggFuncInHeader;

    /**
     * Whether to aggregate only changed columns (for transactions).
     */
    @JsonProperty("aggregateOnlyChangedColumns")
    private Boolean aggregateOnlyChangedColumns;

    /**
     * Whether to suppress aggregation for filtered-only rows.
     */
    @JsonProperty("suppressAggFilteredOnly")
    private Boolean suppressAggFilteredOnly;

    /**
     * Aggregation filtering mode.
     */
    @JsonProperty("groupAggFiltering")
    private String groupAggFiltering;

    /**
     * Whether to suppress blank headers for groups.
     */
    @JsonProperty("groupSuppressBlankHeader")
    private Boolean groupSuppressBlankHeader;

    // ===== [5] TOTAL ROWS =====

    /**
     * Whether to show total rows for groups.
     */
    @JsonProperty("groupTotalRow")
    private String groupTotalRow;

    /**
     * Whether to show a grand total row at the end.
     */
    @JsonProperty("grandTotalRow")
    private String grandTotalRow;

    /**
     * Whether to suppress sticky total rows.
     */
    @JsonProperty("suppressStickyTotalRow")
    private Boolean suppressStickyTotalRow;

    /**
     * Whether to always aggregate at the root level.
     */
    @JsonProperty("alwaysAggregateAtRootLevel")
    private Boolean alwaysAggregateAtRootLevel;

    /**
     * Callback to determine the aggregation value for a group row. Raw JavaScript.
     */
    @JsonProperty("getGroupRowAgg")
    @JsonRawValue
    private String getGroupRowAgg;

    // ===== [6] SERVER-SIDE ROW MODEL GROUPING =====

    /**
     * Whether expanding all rows affects all pages in Server-Side Row Model.
     */
    @JsonProperty("ssrmExpandAllAffectsAllRows")
    private Boolean ssrmExpandAllAffectsAllRows;

    // ===== GETTERS & SETTERS =====

    public String getGroupDisplayType()
    {
        return groupDisplayType;
    }

    public @org.jspecify.annotations.NonNull J setGroupDisplayType(String groupDisplayType)
    {
        this.groupDisplayType = groupDisplayType;
        return (J) this;
    }

    public AgGridColumnDef<?> getAutoGroupColumnDef()
    {
        if (autoGroupColumnDef == null)
        {
            autoGroupColumnDef = new AgGridColumnDef<>();
        }
        return autoGroupColumnDef;
    }

    public @org.jspecify.annotations.NonNull J setAutoGroupColumnDef(AgGridColumnDef<?> autoGroupColumnDef)
    {
        this.autoGroupColumnDef = autoGroupColumnDef;
        return (J) this;
    }

    public String getGroupRowRenderer()
    {
        return groupRowRenderer;
    }

    public @org.jspecify.annotations.NonNull J setGroupRowRenderer(String groupRowRenderer)
    {
        this.groupRowRenderer = groupRowRenderer;
        return (J) this;
    }

    public Object getGroupRowRendererParams()
    {
        return groupRowRendererParams;
    }

    public @org.jspecify.annotations.NonNull J setGroupRowRendererParams(Object groupRowRendererParams)
    {
        this.groupRowRendererParams = groupRowRendererParams;
        return (J) this;
    }

    public Boolean getShowOpenedGroup()
    {
        return showOpenedGroup;
    }

    public @org.jspecify.annotations.NonNull J setShowOpenedGroup(Boolean showOpenedGroup)
    {
        this.showOpenedGroup = showOpenedGroup;
        return (J) this;
    }

    public Boolean getGroupHideParentOfSingleChild()
    {
        return groupHideParentOfSingleChild;
    }

    public @org.jspecify.annotations.NonNull J setGroupHideParentOfSingleChild(Boolean groupHideParentOfSingleChild)
    {
        this.groupHideParentOfSingleChild = groupHideParentOfSingleChild;
        return (J) this;
    }

    public Boolean getGroupHideOpenParents()
    {
        return groupHideOpenParents;
    }

    public @org.jspecify.annotations.NonNull J setGroupHideOpenParents(Boolean groupHideOpenParents)
    {
        this.groupHideOpenParents = groupHideOpenParents;
        return (J) this;
    }

    /**
     * @return whether selecting a group selects its children
     */
    public Boolean getGroupSelectsChildren()
    {
        return groupSelectsChildren;
    }

    public @org.jspecify.annotations.NonNull J setGroupSelectsChildren(Boolean groupSelectsChildren)
    {
        this.groupSelectsChildren = groupSelectsChildren;
        return (J) this;
    }

    /**
     * @return whether group selection applies only to filtered children
     */
    public Boolean getGroupSelectsFiltered()
    {
        return groupSelectsFiltered;
    }

    public @org.jspecify.annotations.NonNull J setGroupSelectsFiltered(Boolean groupSelectsFiltered)
    {
        this.groupSelectsFiltered = groupSelectsFiltered;
        return (J) this;
    }

    public Integer getGroupDefaultExpanded()
    {
        return groupDefaultExpanded;
    }

    public @org.jspecify.annotations.NonNull J setGroupDefaultExpanded(Integer groupDefaultExpanded)
    {
        this.groupDefaultExpanded = groupDefaultExpanded;
        return (J) this;
    }

    public String getIsGroupOpenByDefault()
    {
        return isGroupOpenByDefault;
    }

    public @org.jspecify.annotations.NonNull J setIsGroupOpenByDefaultRaw(String isGroupOpenByDefaultRawJs)
    {
        this.isGroupOpenByDefault = isGroupOpenByDefaultRawJs;
        return (J) this;
    }

    public Boolean getSuppressGroupRowsSticky()
    {
        return suppressGroupRowsSticky;
    }

    public @org.jspecify.annotations.NonNull J setSuppressGroupRowsSticky(Boolean suppressGroupRowsSticky)
    {
        this.suppressGroupRowsSticky = suppressGroupRowsSticky;
        return (J) this;
    }

    public Integer getGroupLockGroupColumns()
    {
        return groupLockGroupColumns;
    }

    public @org.jspecify.annotations.NonNull J setGroupLockGroupColumns(Integer groupLockGroupColumns)
    {
        this.groupLockGroupColumns = groupLockGroupColumns;
        return (J) this;
    }

    public Boolean getGroupMaintainOrder()
    {
        return groupMaintainOrder;
    }

    public @org.jspecify.annotations.NonNull J setGroupMaintainOrder(Boolean groupMaintainOrder)
    {
        this.groupMaintainOrder = groupMaintainOrder;
        return (J) this;
    }

    public Boolean getGroupAllowUnbalanced()
    {
        return groupAllowUnbalanced;
    }

    public @org.jspecify.annotations.NonNull J setGroupAllowUnbalanced(Boolean groupAllowUnbalanced)
    {
        this.groupAllowUnbalanced = groupAllowUnbalanced;
        return (J) this;
    }

    public String getInitialGroupOrderComparator()
    {
        return initialGroupOrderComparator;
    }

    public @org.jspecify.annotations.NonNull J setInitialGroupOrderComparatorRaw(String initialGroupOrderComparatorRawJs)
    {
        this.initialGroupOrderComparator = initialGroupOrderComparatorRawJs;
        return (J) this;
    }

    public String getRowGroupPanelShow()
    {
        return rowGroupPanelShow;
    }

    public @org.jspecify.annotations.NonNull J setRowGroupPanelShow(String rowGroupPanelShow)
    {
        this.rowGroupPanelShow = rowGroupPanelShow;
        return (J) this;
    }

    public Boolean getRowGroupPanelSuppressSort()
    {
        return rowGroupPanelSuppressSort;
    }

    public @org.jspecify.annotations.NonNull J setRowGroupPanelSuppressSort(Boolean rowGroupPanelSuppressSort)
    {
        this.rowGroupPanelSuppressSort = rowGroupPanelSuppressSort;
        return (J) this;
    }

    public Boolean getSuppressGroupChangesColumnVisibility()
    {
        return suppressGroupChangesColumnVisibility;
    }

    public @org.jspecify.annotations.NonNull J setSuppressGroupChangesColumnVisibility(Boolean suppressGroupChangesColumnVisibility)
    {
        this.suppressGroupChangesColumnVisibility = suppressGroupChangesColumnVisibility;
        return (J) this;
    }

    public String getGroupHierarchyConfig()
    {
        return groupHierarchyConfig;
    }

    public @org.jspecify.annotations.NonNull J setGroupHierarchyConfigRaw(String groupHierarchyConfigRawJs)
    {
        this.groupHierarchyConfig = groupHierarchyConfigRawJs;
        return (J) this;
    }

    public String getAggFuncs()
    {
        return aggFuncs;
    }

    public @org.jspecify.annotations.NonNull J setAggFuncsRaw(String aggFuncsRawJs)
    {
        this.aggFuncs = aggFuncsRawJs;
        return (J) this;
    }

    public Boolean getFunctionsReadOnly()
    {
        return functionsReadOnly;
    }

    public @org.jspecify.annotations.NonNull J setFunctionsReadOnly(Boolean functionsReadOnly)
    {
        this.functionsReadOnly = functionsReadOnly;
        return (J) this;
    }

    public Boolean getSuppressAggFuncInHeader()
    {
        return suppressAggFuncInHeader;
    }

    public @org.jspecify.annotations.NonNull J setSuppressAggFuncInHeader(Boolean suppressAggFuncInHeader)
    {
        this.suppressAggFuncInHeader = suppressAggFuncInHeader;
        return (J) this;
    }

    public Boolean getAggregateOnlyChangedColumns()
    {
        return aggregateOnlyChangedColumns;
    }

    public @org.jspecify.annotations.NonNull J setAggregateOnlyChangedColumns(Boolean aggregateOnlyChangedColumns)
    {
        this.aggregateOnlyChangedColumns = aggregateOnlyChangedColumns;
        return (J) this;
    }

    public Boolean getSuppressAggFilteredOnly()
    {
        return suppressAggFilteredOnly;
    }

    public @org.jspecify.annotations.NonNull J setSuppressAggFilteredOnly(Boolean suppressAggFilteredOnly)
    {
        this.suppressAggFilteredOnly = suppressAggFilteredOnly;
        return (J) this;
    }

    public String getGroupAggFiltering()
    {
        return groupAggFiltering;
    }

    public @org.jspecify.annotations.NonNull J setGroupAggFiltering(String groupAggFiltering)
    {
        this.groupAggFiltering = groupAggFiltering;
        return (J) this;
    }

    public Boolean getGroupSuppressBlankHeader()
    {
        return groupSuppressBlankHeader;
    }

    public @org.jspecify.annotations.NonNull J setGroupSuppressBlankHeader(Boolean groupSuppressBlankHeader)
    {
        this.groupSuppressBlankHeader = groupSuppressBlankHeader;
        return (J) this;
    }

    public String getGroupTotalRow()
    {
        return groupTotalRow;
    }

    public @org.jspecify.annotations.NonNull J setGroupTotalRow(String groupTotalRow)
    {
        this.groupTotalRow = groupTotalRow;
        return (J) this;
    }

    public String getGrandTotalRow()
    {
        return grandTotalRow;
    }

    public @org.jspecify.annotations.NonNull J setGrandTotalRow(String grandTotalRow)
    {
        this.grandTotalRow = grandTotalRow;
        return (J) this;
    }

    public Boolean getSuppressStickyTotalRow()
    {
        return suppressStickyTotalRow;
    }

    public @org.jspecify.annotations.NonNull J setSuppressStickyTotalRow(Boolean suppressStickyTotalRow)
    {
        this.suppressStickyTotalRow = suppressStickyTotalRow;
        return (J) this;
    }

    public Boolean getAlwaysAggregateAtRootLevel()
    {
        return alwaysAggregateAtRootLevel;
    }

    public @org.jspecify.annotations.NonNull J setAlwaysAggregateAtRootLevel(Boolean alwaysAggregateAtRootLevel)
    {
        this.alwaysAggregateAtRootLevel = alwaysAggregateAtRootLevel;
        return (J) this;
    }

    public String getGetGroupRowAgg()
    {
        return getGroupRowAgg;
    }

    public @org.jspecify.annotations.NonNull J setGetGroupRowAggRaw(String getGroupRowAggRawJs)
    {
        this.getGroupRowAgg = getGroupRowAggRawJs;
        return (J) this;
    }

    public Boolean getSsrmExpandAllAffectsAllRows()
    {
        return ssrmExpandAllAffectsAllRows;
    }

    public @org.jspecify.annotations.NonNull J setSsrmExpandAllAffectsAllRows(Boolean ssrmExpandAllAffectsAllRows)
    {
        this.ssrmExpandAllAffectsAllRows = ssrmExpandAllAffectsAllRows;
        return (J) this;
    }
}
