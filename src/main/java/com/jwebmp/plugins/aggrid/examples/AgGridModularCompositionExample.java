package com.jwebmp.plugins.aggrid.examples;

import com.jwebmp.plugins.aggrid.options.AgGridOptions;
import com.jwebmp.plugins.aggrid.options.RenderingOptions;
import com.jwebmp.plugins.aggrid.options.enums.*;

/**
	* AG Grid Modular Composition Examples
	* <p>
	* Demonstrates the @JsonUnwrapped modular approach to configuring AG Grid.
	* This pattern allows clean separation of concerns while maintaining
	* backward-compatible flat JSON output.
	* <p>
	* PATTERN:
	* - Each feature has its own Option class (RenderingOptions, ServerSideRowModelOptions, etc.)
	* - AgGridOptions composes these via @JsonUnwrapped annotations
	* - All properties flatten into parent JSON (no nesting)
	* - Use configureXxx() methods for fluent chaining within each feature area
	*
	* @author DevSuite
	* @since 2025
	*/
public class AgGridModularCompositionExample
{
		// ============================================================
		// Example 1: Basic Rendering Configuration (Modular Style)
		// ============================================================
		
		public void example1_basicRendering()
		{
				AgGridOptions<?> options = new AgGridOptions<>();
				
				// Configure rendering options via modular composition
				options
					.configureRendering()
					.setAnimateRows(true)
					.setCellFlashDuration(500)
					.setCellFadeDuration(300)
				;
				
				// JSON Output: { "animateRows": true, "cellFlashDuration": 500, "cellFadeDuration": 300 }
		}
		
		// ============================================================
		// Example 2: Server-Side Row Model Configuration
		// ============================================================
		
		public void example2_serverSideRowModel()
		{
				AgGridOptions<?> options = new AgGridOptions<>();
				
				options
					.configureServerSideRowModel()
					.setCacheBlockSize(100)
					.setMaxConcurrentDatasourceRequests(2)
					.setPurgeClosedRowNodes(true)
				;
				
				// JSON Output: { "cacheBlockSize": 100, "maxConcurrentDatasourceRequests": 2, ... }
		}
		
		// ============================================================
		// Example 3: Advanced Filter Configuration
		// ============================================================
		
		public void example3_advancedFilter()
		{
				AgGridOptions<?> options = new AgGridOptions<>();
				
				options
					.configureAdvancedFilter()
					.setEnableAdvancedFilter(true)
					.setAdvancedFilterClassName("my-filter")
				;
				
				// JSON Output: { "enableAdvancedFilter": true, "advancedFilterClassName": "my-filter" }
		}
		
		// ============================================================
		// Example 4: Row Grouping Configuration (NEW Phase C)
		// ============================================================
		
		public void example4_rowGrouping()
		{
				AgGridOptions<?> options = new AgGridOptions<>();
				
				options
					.configureRowGrouping()
					.setGroupDisplayType(GroupDisplayType.SINGLE_COLUMN.getJson())
					.setGroupDefaultExpanded(2)
					.setShowOpenedGroup(true)
					.setRowGroupPanelShow("bottom")
				;
				
				// JSON Output: { "groupDisplayType": "singleColumn", "groupDefaultExpanded": 2, ... }
		}
		
		// ============================================================
		// Example 5: Row Pivoting Configuration (NEW Phase C)
		// ============================================================
		
		public void example5_rowPivoting()
		{
				AgGridOptions<?> options = new AgGridOptions<>();
				
				options
					.configureRowPivoting()
					.setPivotMode(true)
					.setPivotPanelShow(PivotPanelShowType.ALWAYS.getJson())
					.setPivotDefaultExpanded(1)
					.setPivotRowTotals("before")
				;
				
				// JSON Output: { "pivotMode": true, "pivotPanelShow": "always", ... }
		}
		
		// ============================================================
		// Example 6: Combined Rendering + Server-Side Setup
		// ============================================================
		
		public void example6_combinedRenderingAndServerSide()
		{
				AgGridOptions<?> options = new AgGridOptions<>();
				
				// Configure rendering
				options
					.configureRendering()
					.setAnimateRows(true)
					.setCellFlashDuration(500)
				;
				
				// Configure server-side row model separately
				options
					.configureServerSideRowModel()
					.setCacheBlockSize(100)
					.setMaxConcurrentDatasourceRequests(2)
				;
				
				// JSON Output: All properties flattened in parent object
				// { "animateRows": true, "cellFlashDuration": 500, "cacheBlockSize": 100, ... }
		}
		
		// ============================================================
		// Example 7: Combined Grouping + Pivoting (NEW Phase C Integration)
		// ============================================================
		
		public void example7_combinedGroupingAndPivoting()
		{
				AgGridOptions<?> options = new AgGridOptions<>();
				
				// Configure row grouping
				options
					.configureRowGrouping()
					.setGroupDisplayType(GroupDisplayType.SINGLE_COLUMN.getJson())
					.setGroupDefaultExpanded(2)
					.setGroupTotalRow("bottom")
				;
				
				// Configure row pivoting separately
				options
					.configureRowPivoting()
					.setPivotMode(true)
					.setPivotPanelShow(PivotPanelShowType.ONLY_WHEN_PIVOTING.getJson())
					.setPivotMaxGeneratedColumns(20)
				;
				
				// JSON Output: All grouping + pivoting properties flattened
				// { "groupDisplayType": "singleColumn", "pivotMode": true, ... }
		}
		
		// ============================================================
		// Example 8: Comprehensive Configuration (All Modular Areas)
		// ============================================================
		
		public void example8_comprehensiveConfiguration()
		{
				AgGridOptions<?> options = new AgGridOptions<>();
				
				// Rendering configuration
				options
					.configureRendering()
					.setAnimateRows(true)
					.setCellFlashDuration(500)
				;
				
				// Server-side configuration
				options
					.configureServerSideRowModel()
					.setCacheBlockSize(100)
					.setMaxConcurrentDatasourceRequests(2)
				;
				
				// Advanced filter configuration
				options
					.configureAdvancedFilter()
					.setEnableAdvancedFilter(true);
				
				// Row grouping configuration (NEW Phase C)
				options
					.configureRowGrouping()
					.setGroupDisplayType(GroupDisplayType.SINGLE_COLUMN.getJson())
					.setGroupDefaultExpanded(2)
				;
				
				// Row pivoting configuration (NEW Phase C)
				options
					.configureRowPivoting()
					.setPivotMode(false)
					.setPivotMaxGeneratedColumns(30)
				;
				
				// Top-level properties
				options
					.setDomLayout(DomLayoutType.AUTO_HEIGHT)
					.setEditType(EditType.DOUBLE_CLICK)
					.configureSelection()
					.setRowSelection(RowSelectionMode.MULTIPLE)
				;
				
				// JSON Output: All properties flattened in parent object
		}
		
		// ============================================================
		// Example 9: Reusable Configuration Objects
		// ============================================================
		
		public void example9_reuseableConfiguration()
		{
				// Create reusable rendering configuration
				RenderingOptions<?> standardRendering = new RenderingOptions<>();
				standardRendering
					.setAnimateRows(true)
					.setCellFlashDuration(500)
					.setCellFadeDuration(300)
				;
				
				// Apply to multiple option sets
				AgGridOptions<?> options1 = new AgGridOptions<>();
				options1.setRendering(standardRendering);
				
				AgGridOptions<?> options2 = new AgGridOptions<>();
				options2.setRendering(standardRendering);
				
				// Both options share the same rendering configuration
		}
		
		// ============================================================
		// Example 10: Progressive Configuration Building
		// ============================================================
		
		public void example10_progressiveBuilding()
		{
				AgGridOptions<?> options = new AgGridOptions<>();
				
				// Start with basic configuration
				options
					.configureRendering()
					.setAnimateRows(true);
				
				// Add conditional configuration
				boolean useServerSide = true;
				if (useServerSide)
				{
						options
							.configureServerSideRowModel()
							.setCacheBlockSize(100);
				}
				
				// Add conditional advanced features
				boolean enableGrouping = true;
				if (enableGrouping)
				{
						options
							.configureRowGrouping()
							.setGroupDisplayType(GroupDisplayType.SINGLE_COLUMN.getJson());
				}
				
				boolean enablePivoting = false;
				if (enablePivoting)
				{
						options
							.configureRowPivoting()
							.setPivotMode(true);
				}
		}
		
		// ============================================================
		// Example 11: Monolithic vs Modular Comparison
		// ============================================================
		
		public void example11_monolithicVsModular()
		{
				// MONOLITHIC APPROACH - AgGridOptions (direct field access)
				AgGridOptions monolithic = new AgGridOptions();
				monolithic
					.configureRendering()
					.setAnimateRows(true);
				monolithic
					.configureServerSideRowModel()
					.setCacheBlockSize(100);
				monolithic
					.configureRowGrouping()
					.setGroupDisplayType(GroupDisplayType.SINGLE_COLUMN.getJson());
				monolithic
					.configureRowPivoting()
					.setPivotMode(true);
				
				// MODULAR APPROACH - AgGridOptions (@JsonUnwrapped composition)
				AgGridOptions<?> modular = new AgGridOptions<>();
				modular
					.configureRendering()
					.setAnimateRows(true);
				modular
					.configureServerSideRowModel()
					.setCacheBlockSize(100);
				modular
					.configureRowGrouping()
					.setGroupDisplayType(GroupDisplayType.SINGLE_COLUMN.getJson());
				modular
					.configureRowPivoting()
					.setPivotMode(true);
				
				// JSON OUTPUT IS IDENTICAL for both approaches!
				// { "animateRows": true, "cacheBlockSize": 100, "groupDisplayType": "singleColumn", "pivotMode": true }
		}
		
		// ============================================================
		// Example 12: JSON Serialization Behavior (@JsonUnwrapped)
		// ============================================================
		
		public void example12_jsonSerialization()
		{
				AgGridOptions<?> options = new AgGridOptions<>();
				
				options
					.configureRendering()
					.setAnimateRows(true)
					.setCellFlashDuration(500)
				;
				
				options
					.configureRowGrouping()
					.setGroupDisplayType(GroupDisplayType.SINGLE_COLUMN.getJson());
				
				// IMPORTANT: @JsonUnwrapped means NO intermediate objects in JSON output!
				// Without @JsonUnwrapped, would serialize as:
				// { "rendering": { "animateRows": true, "cellFlashDuration": 500 }, ... }
				
				// WITH @JsonUnwrapped, serializes as:
				// { "animateRows": true, "cellFlashDuration": 500, "groupDisplayType": "singleColumn", ... }
				
				// This maintains backward compatibility with existing JSON schemas
		}
		
		// ============================================================
		// Example 13: Feature Discovery via IDE Autocomplete
		// ============================================================
		
		public void example13_featureDiscovery()
		{
				AgGridOptions<?> options = new AgGridOptions<>();
				
				// IDE autocomplete helps discover available features:
				// options.configure| <- IDE shows: configureRendering(), configureServerSideRowModel(), etc.
				
				// Each configure method returns a specialized option class:
				// options.configureRendering().set| <- IDE shows rendering-specific methods
				// options.configureRowGrouping().set| <- IDE shows grouping-specific methods
				// options.configureRowPivoting().set| <- IDE shows pivoting-specific methods
				
				// This self-documenting API makes feature discovery easy
		}
		
		// ============================================================
		// Example 14: Type-Safe Enum Usage with Modular Approach
		// ============================================================
		
		public void example14_typeSafeEnums()
		{
				AgGridOptions<?> options = new AgGridOptions<>();
				
				// Type-safe enums converted to string values
				options
					.configureRowGrouping()
					.setGroupDisplayType(GroupDisplayType.SINGLE_COLUMN.getJson());  // Type-safe enum
				
				// Type-safe enums for Pivot Panel
				options
					.configureRowPivoting()
					.setPivotPanelShow(PivotPanelShowType.ONLY_WHEN_PIVOTING.getJson());  // Type-safe enum
				
				// This prevents invalid string values by using enum.value() for serialization
				// Instead of: setGroupDisplayType("singleColumn")  // Prone to typos
				// Use:        setGroupDisplayType(GroupDisplayType.SINGLE_COLUMN.value())  // Type-safe
		}
		
		// ============================================================
		// Example 15: Production-Recommended Configuration Pattern
		// ============================================================
		
		public void example15_productionPattern()
		{
				// Create a production-ready grid configuration
				AgGridOptions<?> gridOptions = createProductionGridConfiguration();
				
				// The configuration is now ready for JSON serialization
				// and sending to the frontend AG Grid JavaScript library
		}
		
		/**
			* Production-recommended configuration following best practices:
			* - Clear separation of concerns
			* - Type-safe configuration
			* - Readable and maintainable code
			* - Reusable components
			*/
		private AgGridOptions<?> createProductionGridConfiguration()
		{
				AgGridOptions<?> options = new AgGridOptions<>();
				
				// Performance optimization - enable row animation only for important transitions
				options
					.configureRendering()
					.setAnimateRows(true)
					.setCellFlashDuration(500)
					.setCellFadeDuration(300)
				;
				
				// Server-side data loading - configure for large datasets
				options
					.configureServerSideRowModel()
					.setCacheBlockSize(100)
					.setMaxConcurrentDatasourceRequests(2)
				;
				
				// Filtering capabilities
				options
					.configureAdvancedFilter()
					.setEnableAdvancedFilter(true);
				
				// Row organization - use grouping for hierarchy
				options
					.configureRowGrouping()
					.setGroupDisplayType(GroupDisplayType.SINGLE_COLUMN.getJson())
					.setGroupDefaultExpanded(1)
					.setRowGroupPanelShow("bottom")
				;
				
				// Row pivoting - optional, depending on data requirements
				options
					.configureRowPivoting()
					.setPivotMode(false)  // Disabled by default, user can enable
					.setPivotPanelShow(PivotPanelShowType.ALWAYS.getJson())
					.setPivotMaxGeneratedColumns(20)
				;
				
				// User interaction
				options
					.setEditType(EditType.DOUBLE_CLICK)
					.configureSelection()
					.setRowSelection(RowSelectionMode.MULTIPLE)
				;
				
				return options;
		}
}


