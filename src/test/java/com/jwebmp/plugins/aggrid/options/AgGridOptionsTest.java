package com.jwebmp.plugins.aggrid.options;

import com.jwebmp.plugins.aggrid.options.enums.RowSelectionMode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AgGridOptionsTest
{
		
		@Test
		void configureSelection()
		{
				AgGridOptions<?> options = new AgGridOptions<>();
				options
					.configureSelection()
					.setRowSelection(RowSelectionMode.MULTIPLE);
			
				options.configureRowGrouping().setRowGroupPanelShow("onlyWhenGrouping");
				
				System.out.println(options.toJson());
		}
}