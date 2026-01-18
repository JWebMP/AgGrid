package com.jwebmp.plugins.aggrid.options;

import com.jwebmp.plugins.aggrid.options.enums.RowSelectionMode;
import com.jwebmp.plugins.aggrid.options.state.FilterState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AgGridOptionsTest
{
		
		@Test
		void configureSelection()
		{
				AgGridOptions<?> options = new AgGridOptions<>();
				options
					.configureSelection()
					.setRowSelection(RowSelectionMode.MULTIPLE);
				
				options
					.configureRowGrouping()
					.setRowGroupPanelShow("onlyWhenGrouping");
				
				System.out.println(options.toJson());
		}

		@Test
		void testVirtualisation()
		{
				AgGridOptions<?> options = new AgGridOptions<>();
				options.setSuppressColumnVirtualisation(true)
				       .setSuppressRowVirtualisation(true);

				String json = options.toJson();
				System.out.println("JSON Output (Virtualisation): " + json);
				assertTrue(json.contains("\"suppressColumnVirtualisation\":true") || json.contains("\"suppressColumnVirtualisation\" : true"));
				assertTrue(json.contains("\"suppressRowVirtualisation\":true") || json.contains("\"suppressRowVirtualisation\" : true"));

				options.setSuppressHorizontalScroll(true)
				       .setSuppressTabbing(true)
				       .setSuppressScrollOnNewData(true);

				json = options.toJson();
				assertTrue(json.contains("\"suppressHorizontalScroll\":true") || json.contains("\"suppressHorizontalScroll\" : true"));
				assertTrue(json.contains("\"suppressTabbing\":true") || json.contains("\"suppressTabbing\" : true"));
				assertTrue(json.contains("\"suppressScrollOnNewData\":true") || json.contains("\"suppressScrollOnNewData\" : true"));
		}

		@Test
		void testAnimation()
		{
				AgGridOptions<?> options = new AgGridOptions<>();
				options.setAnimateRows(true)
				       .setSuppressColumnMoveAnimation(true)
				       .setSuppressAnimationFrame(true);

				String json = options.toJson();
				System.out.println("JSON Output (Animation): " + json);
				assertTrue(json.contains("\"animateRows\":true") || json.contains("\"animateRows\" : true"));
				assertTrue(json.contains("\"suppressColumnMoveAnimation\":true") || json.contains("\"suppressColumnMoveAnimation\" : true"));
				assertTrue(json.contains("\"suppressAnimationFrame\":true") || json.contains("\"suppressAnimationFrame\" : true"));
		}

		@Test
		void testSizing()
		{
				AgGridOptions<?> options = new AgGridOptions<>();
				options.setRowHeight(25)
				       .setAutoSizeStrategy(com.jwebmp.plugins.aggrid.options.enums.AutoSizeStrategy.FIT_GRID_WIDTH)
				       .setColResizeDefault("shift")
				       .setSkipHeaderOnAutoSize(true);

				String json = options.toJson();
				System.out.println("JSON Output (Sizing): " + json);
				assertTrue(json.contains("\"rowHeight\":25") || json.contains("\"rowHeight\" : 25"));
				assertTrue(json.contains("\"autoSizeStrategy\":\"fitGridWidth\"") || json.contains("\"autoSizeStrategy\" : \"fitGridWidth\""));
				assertTrue(json.contains("\"colResizeDefault\":\"shift\"") || json.contains("\"colResizeDefault\" : \"shift\""));
				assertTrue(json.contains("\"skipHeaderOnAutoSize\":true") || json.contains("\"skipHeaderOnAutoSize\" : true"));
		}

		@Test
		void testMenuHide()
		{
				AgGridOptions<?> options = new AgGridOptions<>();
				options.setSuppressMenuHide(true);

				String json = options.toJson();
				System.out.println("JSON Output (MenuHide): " + json);
				assertTrue(json.contains("\"suppressMenuHide\":true") || json.contains("\"suppressMenuHide\" : true"));
		}

		@Test
		void testTreeData()
		{
				AgGridOptions<?> options = new AgGridOptions<>();
				options.setTreeData(true);
				options
					.configureTreeData()
					.setGetDataPath("(data) => data.path")
					.setTreeDataChildrenField("children")
				;
				
				String json = options.toJson();
				System.out.println("JSON Output: " + json);
				assertTrue(json.contains("\"treeData\":true") || json.contains("\"treeData\" : true"));
				assertTrue(json.contains("\"getDataPath\":(data) => data.path") || json.contains("\"getDataPath\" : (data) => data.path"));
				assertTrue(json.contains("\"treeDataChildrenField\":\"children\"") || json.contains("\"treeDataChildrenField\" : \"children\""));
		}
		
		@Test
		void testInitialFilterModelConvenience()
		{
				AgGridOptions<?> options = new AgGridOptions<>();
				
				java.util.Map<String, Object> filterModel = new java.util.HashMap<>();
				
				java.util.Map<String, Object> scoreFilter = new java.util.HashMap<>();
				scoreFilter.put("filterType", "number");
				scoreFilter.put("type", "greaterThan");
				scoreFilter.put("filter", 50);
				filterModel.put("score", scoreFilter);
				
				options.setInitialFilterModel(filterModel);
				
				String json = options.toJson();
				System.out.println("JSON Output (Convenience): " + json);
				
				assertTrue(json.contains("\"initialState\""));
				assertTrue(json.contains("\"filter\""));
				assertTrue(json.contains("\"filterModel\""));
				assertTrue(json.contains("\"score\""));
				assertTrue(json.contains("\"greaterThan\""));
				
				
				java.util.Map<String, Object> stringObjectHashMap = new java.util.HashMap<>();
				
				java.util.Map<String, Object> stringObjectHashMap1 = new java.util.HashMap<>();
				stringObjectHashMap1.put("filterType", "text");
				stringObjectHashMap1.put("type", "equals");
				stringObjectHashMap1.put("filter", "Scale");
				stringObjectHashMap.put("type", stringObjectHashMap1);
				
				options
					.configureGridState()
					.getInitialState()
					.setFilter(new FilterState<>().setFilterModel(stringObjectHashMap))
				;
				System.out.println(options.toJson());
				
		}
}