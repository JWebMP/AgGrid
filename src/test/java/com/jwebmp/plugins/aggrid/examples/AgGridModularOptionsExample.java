package com.jwebmp.plugins.aggrid.examples;

import com.jwebmp.plugins.aggrid.options.AdvancedFilterOptions;
import com.jwebmp.plugins.aggrid.options.AgGridOptions;
import com.jwebmp.plugins.aggrid.options.ServerSideRowModelOptions;
import com.jwebmp.plugins.aggrid.options.enums.CellSelectionMode;
import com.jwebmp.plugins.aggrid.options.enums.DomLayoutType;
import com.jwebmp.plugins.aggrid.options.enums.EditType;
import com.jwebmp.plugins.aggrid.options.enums.RowSelectionMode;

/**
	* Example usage of the modular AG Grid options POC.
	* <p>
	* Demonstrates how to use the new modular architecture while maintaining
	* identical JSON serialization output to the monolithic approach.
	*
	* @author DevSuite
	* @since 2025
	*/
public class AgGridModularOptionsExample
{
		public static void main(String[] args)
		{
				// Example 1: Basic configuration with type-safe enums
				example1_BasicConfiguration();
				
				// Example 2: Server-side row model setup
				example2_ServerSideRowModel();
				
				// Example 3: Advanced filter configuration
				example3_AdvancedFilter();
				
				// Example 4: Fluent chaining
				example4_FluentChaining();
		}
		
		/**
			* Example 1: Basic grid configuration with type-safe enums
			*/
		private static void example1_BasicConfiguration()
		{
				System.out.println("=== Example 1: Basic Configuration ===");
				
				AgGridOptions<?> gridOptions = new AgGridOptions<>()
																																				.setCellSelection(CellSelectionMode.CELL)        // Type-safe enum
																																				.setDomLayout(DomLayoutType.AUTO_HEIGHT)         // Type-safe enum
																																				.setEditType(EditType.DOUBLE_CLICK)             // Type-safe enum
					;
				gridOptions
					.configureSelection()
					.setRowSelection(RowSelectionMode.MULTIPLE)      // Type-safe enum
				
				;
				
				System.out.println("Row Selection: " + gridOptions
																																												.configureSelection()
																																												.getRowSelection());
				System.out.println("Cell Selection: " + gridOptions.getCellSelection());
				System.out.println("DOM Layout: " + gridOptions.getDomLayout());
				System.out.println("Edit Type: " + gridOptions.getEditType());
				System.out.println();
		}
		
		/**
			* Example 2: Server-side row model configuration (NEW v34.2.0)
			*/
		private static void example2_ServerSideRowModel()
		{
				System.out.println("=== Example 2: Server-Side Row Model ===");
				
				AgGridOptions<?> gridOptions = new AgGridOptions<>();
				
				// Access server-side options via convenience method
				ServerSideRowModelOptions<?> ssrm = gridOptions.getServerSideRowModel();
				
				ssrm
					.setCacheBlockSize(100)
					.setMaxBlocksInCache(2)
					.setMaxConcurrentDatasourceRequests(2)
					.setBlockLoadDebounceMillis(100)
					.setSuppressServerSideFullWidthLoadingRow(false)
					.setServerSideDatasource("function(params) { " +
																															"console.log('Fetching rows:', params); " +
																															"// Call API to fetch data " +
																															"}")
					.setGetChildCount("function(data) { return data.childCount; }")
				;
				
				System.out.println("Cache Block Size: " + ssrm.getCacheBlockSize());
				System.out.println("Max Blocks in Cache: " + ssrm.getMaxBlocksInCache());
				System.out.println("Max Concurrent Requests: " + ssrm.getMaxConcurrentDatasourceRequests());
				System.out.println("Block Load Debounce: " + ssrm.getBlockLoadDebounceMillis());
				System.out.println();
		}
		
		/**
			* Example 3: Advanced filter configuration (NEW v34.2.0)
			*/
		private static void example3_AdvancedFilter()
		{
				System.out.println("=== Example 3: Advanced Filter ===");
				
				AgGridOptions<?> gridOptions = new AgGridOptions<>();
				
				AdvancedFilterOptions<?> filter = gridOptions.getAdvancedFilter();
				
				filter
					.setEnableAdvancedFilter(true)
					.setAdvancedFilterClassName("custom-filter-style")
					.setAdvancedFilterParentElement("#filter-container")
					.setOnAdvancedFilterChanged("function(event) { " +
																																		"console.log('Filter changed:', event.expression); " +
																																		"}")
				;
				
				System.out.println("Advanced Filter Enabled: " + filter.getEnableAdvancedFilter());
				System.out.println("Filter Class Name: " + filter.getAdvancedFilterClassName());
				System.out.println("Filter Parent Element: " + filter.getAdvancedFilterParentElement());
				System.out.println();
		}
		
		/**
			* Example 4: Complex fluent chaining with multiple option groups
			*/
		private static void example4_FluentChaining()
		{
				System.out.println("=== Example 4: Complex Configuration ===");
				
				// Create options with comprehensive configuration
				AgGridOptions<?> gridOptions = new AgGridOptions<>()
																																				// Set top-level enums
																																				.setCellSelection(CellSelectionMode.ROW)
																																				.setDomLayout(DomLayoutType.NORMAL)
																																				.setEditType(EditType.API_EDITING)
					;
				gridOptions
					.configureSelection()
					.setRowSelection(RowSelectionMode.MULTIPLE);
				
				// Configure rendering
				gridOptions
					.getRendering()
					.setAnimateRows(true)
					.setCellFlashDuration(500)
					.setCellFadeDuration(100)
					.setAllowShowChangeAfterFilter(true)
				;
				
				// Configure server-side row model
				gridOptions
					.getServerSideRowModel()
					.setCacheBlockSize(50)
					.setMaxBlocksInCache(5)
					.setMaxConcurrentDatasourceRequests(3)
					.setServerSideSortAllLevels(true)
					.setServerSideEnableClientSideSort(false)
				;
				
				// Configure advanced filter
				gridOptions
					.getAdvancedFilter()
					.setEnableAdvancedFilter(true)
					.setAdvancedFilterClassName("modern-filter")
				;
				
				System.out.println("Configuration Complete!");
				System.out.println("Rendering Options:");
				System.out.println("  - Animate Rows: " + gridOptions
																																															.getRendering()
																																															.getAnimateRows());
				System.out.println("  - Cell Flash Duration: " + gridOptions
																																																						.getRendering()
																																																						.getCellFlashDuration());
				
				System.out.println("Server-Side Options:");
				System.out.println("  - Cache Block Size: " + gridOptions
																																																			.getServerSideRowModel()
																																																			.getCacheBlockSize());
				System.out.println("  - Max Blocks in Cache: " + gridOptions
																																																						.getServerSideRowModel()
																																																						.getMaxBlocksInCache());
				
				System.out.println("Advanced Filter Options:");
				System.out.println("  - Enabled: " + gridOptions
																																										.getAdvancedFilter()
																																										.getEnableAdvancedFilter());
				System.out.println("  - Class Name: " + gridOptions
																																													.getAdvancedFilter()
																																													.getAdvancedFilterClassName());
				System.out.println();
		}
		
		/**
			* Example 5: Type-safe enum usage (no more magic strings!)
			*/
		public static void example5_TypeSafeEnums()
		{
				System.out.println("=== Example 5: Type-Safe Enums ===");
				
				// OLD WAY (monolithic - error-prone):
				// gridOptions.setRowSelection("multiRow");  // String - easy to typo!
				// gridOptions.setCellSelection("cll");      // Typo - won't be caught at compile time
				
				// NEW WAY (modular - type-safe):
				AgGridOptions<?> options = new AgGridOptions<>();
				options.configureSelection().setRowSelection(RowSelectionMode.MULTIPLE);    // ✅ Type-safe
				options.setCellSelection(CellSelectionMode.CELL);      // ✅ Caught at compile time
				// options.setCellSelection(CellSelectionMode.INVALID); // ❌ Compile error!
				
				// Enums serialize to correct string values automatically
				System.out.println("RowSelectionMode.MULTIPLE -> \"" + RowSelectionMode.MULTIPLE.getValue() + "\"");
				System.out.println("CellSelectionMode.CELL -> \"" + CellSelectionMode.CELL.getValue() + "\"");
				System.out.println("DomLayoutType.AUTO_HEIGHT -> \"" + DomLayoutType.AUTO_HEIGHT.getValue() + "\"");
				System.out.println();
		}
		
		/**
			* Example 6: Comparing monolithic vs modular approach
			*/
		public static void example6_ApproachComparison()
		{
				System.out.println("=== Example 6: Monolithic vs Modular ===");
				System.out.println();
				System.out.println("MONOLITHIC APPROACH (Old - 4,770 line file):");
				System.out.println("  AgGridOptions options = new AgGridOptions<>");
				System.out.println("    .setAnimateRows(true)");
				System.out.println("    .setServerSideDatasource(\"...\")");
				System.out.println("    .setEnableAdvancedFilter(true);");
				System.out.println("  // Hard to find which section each property belongs to");
				System.out.println();
				System.out.println("MODULAR APPROACH (New - Multiple focused classes):");
				System.out.println("  AgGridOptions options = new AgGridOptions<>");
				System.out.println("    .getRendering().setAnimateRows(true)");
				System.out.println("    .getServerSideRowModel().setServerSideDatasource(\"...\")");
				System.out.println("    .getAdvancedFilter().setEnableAdvancedFilter(true);");
				System.out.println("  // Clear organization, better IDE support");
				System.out.println();
				System.out.println("JSON OUTPUT: IDENTICAL");
				System.out.println("  { \"animateRows\": true, \"serverSideDatasource\": \"...\", \"enableAdvancedFilter\": true }");
				System.out.println();
		}
}


