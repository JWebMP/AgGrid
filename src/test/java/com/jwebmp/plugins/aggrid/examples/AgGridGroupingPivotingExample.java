package com.jwebmp.plugins.aggrid.examples;

import com.jwebmp.plugins.aggrid.options.AgGridOptions;
import com.jwebmp.plugins.aggrid.options.enums.GroupDisplayType;
import com.jwebmp.plugins.aggrid.options.enums.PivotPanelShowType;

/**
 * Extended Examples for Row Grouping and Row Pivoting Options
 * Demonstrates how to configure AG Grid with grouping and pivoting features.
 * Community Edition Feature
 */
public class AgGridGroupingPivotingExample
{
    /**
     * Example 1: Basic Row Grouping
     */
    public static AgGridOptions<?> basicRowGrouping()
    {
        var options = new AgGridOptions<>();
        options.configureRowGrouping()
                .setGroupDisplayType(GroupDisplayType.SINGLE_COLUMN.getJson())
                .setGroupDefaultExpanded(1)
                .setGroupMaintainOrder(true)
                .setSuppressGroupRowsSticky(false);
        return options;
    }

    /**
     * Example 2: Advanced Row Grouping with Aggregation
     */
    public static AgGridOptions<?> advancedRowGrouping()
    {
        var options = new AgGridOptions<>();
        options.configureRowGrouping()
                .setGroupDisplayType(GroupDisplayType.GROUP_ROWS.getJson())
                .setGroupDefaultExpanded(2)
                .setGroupTotalRow("top")
                .setGrandTotalRow("top");
        return options;
    }

    /**
     * Example 3: Basic Pivot Mode
     */
    public static AgGridOptions<?> basicPivotMode()
    {
        var options = new AgGridOptions<>();
        options.configureRowPivoting()
                .setPivotMode(true)
                .setPivotPanelShow(PivotPanelShowType.ALWAYS.getJson())
                .setPivotDefaultExpanded(1);
        return options;
    }

    /**
     * Example 4: Combined Grouping and Pivoting
     */
    public static AgGridOptions<?> combinedGroupingAndPivoting()
    {
        var options = new AgGridOptions<>();
        options.configureRowGrouping()
                .setGroupDisplayType(GroupDisplayType.MULTIPLE_COLUMNS.getJson())
                .setGroupDefaultExpanded(1);
        options.configureRowPivoting()
                .setPivotMode(true)
                .setPivotPanelShow(PivotPanelShowType.ALWAYS.getJson());
        return options;
    }

    /**
     * Example 5: Grouping with Aggregation
     */
    public static AgGridOptions<?> groupingWithAggregation()
    {
        var options = new AgGridOptions<>();
        options.configureRowGrouping()
                .setGroupDisplayType(GroupDisplayType.SINGLE_COLUMN.getJson())
                .setGroupDefaultExpanded(0)
                .setAggFuncsRaw("{ avg: function(values) { return values.reduce((a,b)=>a+b,0)/values.length; } }");
        return options;
    }

    /**
     * Example 6: Type-Safe Configuration
     */
    public static AgGridOptions<?> typeSafeConfig()
    {
        var options = new AgGridOptions<>();
        options.configureRowGrouping()
                .setGroupDisplayType(GroupDisplayType.GROUP_ROWS.getJson());
        return options;
    }

    /**
     * Example 7: Minimal Grouping
     */
    public static AgGridOptions<?> minimalGrouping()
    {
        var options = new AgGridOptions<>();
        options.configureRowGrouping()
                .setGroupDefaultExpanded(0)
                .setGroupDisplayType(GroupDisplayType.SINGLE_COLUMN.getJson());
        return options;
    }

    /**
     * Example 8: Minimal Pivot
     */
    public static AgGridOptions<?> minimalPivot()
    {
        var options = new AgGridOptions<>();
        options.configureRowPivoting()
                .setPivotMode(true)
                .setPivotPanelShow(PivotPanelShowType.ONLY_WHEN_PIVOTING.getJson());
        return options;
    }

    /**
     * Example 9: Production Configuration
     */
    public static AgGridOptions<?> productionConfig()
    {
        var options = new AgGridOptions<>();
        options.configureRowGrouping()
                .setGroupDisplayType(GroupDisplayType.SINGLE_COLUMN.getJson())
                .setGroupDefaultExpanded(1)
                .setRowGroupPanelShow("always");
        options.configureRowPivoting()
                .setPivotMode(true)
                .setPivotPanelShow(PivotPanelShowType.ALWAYS.getJson())
                .setPivotMaxGeneratedColumns(50);
        return options;
    }
}
