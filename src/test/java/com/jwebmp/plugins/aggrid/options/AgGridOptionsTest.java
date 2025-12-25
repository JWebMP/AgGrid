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