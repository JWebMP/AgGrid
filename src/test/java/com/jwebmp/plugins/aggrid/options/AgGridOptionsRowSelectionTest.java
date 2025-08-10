package com.jwebmp.plugins.aggrid.options;

import com.jwebmp.plugins.aggrid.options.enums.CheckboxLocation;
import com.jwebmp.plugins.aggrid.options.enums.RowSelectionMode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for row selection functionality in AgGridOptions
 */
public class AgGridOptionsRowSelectionTest
{
    @Test
    public void testRowSelectionOptions()
    {
        // Create grid options
        AgGridOptions<?> options = new AgGridOptions<>();
        
        // Test default values
        assertNull(options.getRowSelection());
        
        // Test setting row selection options
        RowSelectionOptions<?> rowSelectionOptions = new RowSelectionOptions<>();
        rowSelectionOptions.setMode(RowSelectionMode.MULTIPLE);
        options.setRowSelection(rowSelectionOptions);
        
        // Test getting row selection options
        assertNotNull(options.getRowSelection());
        assertEquals(RowSelectionMode.MULTIPLE, options.getRowSelection().getMode());
        
        // Test setting row selection mode directly
        options = new AgGridOptions<>();
        options.setRowSelectionMode(RowSelectionMode.SINGLE);
        
        // Test getting row selection options after setting mode directly
        assertNotNull(options.getRowSelection());
        assertEquals(RowSelectionMode.SINGLE, options.getRowSelection().getMode());
        
        // Test selection column definition
        AgGridColumnDef<?> selectionColumnDef = new AgGridColumnDef<>();
        selectionColumnDef.setWidth(50);
        selectionColumnDef.setHeaderTooltip("Select rows");
        
        options.setSelectionColumnDef(selectionColumnDef);
        
        // Test getting selection column definition
        assertNotNull(options.getSelectionColumnDef());
        assertEquals(50, options.getSelectionColumnDef().getWidth());
        assertEquals("Select rows", options.getSelectionColumnDef().getHeaderTooltip());
    }
    
    @Test
    public void testSingleRowSelection()
    {
        // Create grid options
        AgGridOptions<?> options = new AgGridOptions<>();
        
        // Set single row selection mode
        options.setRowSelectionMode(RowSelectionMode.SINGLE);
        
        // Verify the mode is set correctly
        assertNotNull(options.getRowSelection());
        assertEquals(RowSelectionMode.SINGLE, options.getRowSelection().getMode());
        
        // Test with a complete row selection options object
        RowSelectionOptions<?> rowSelectionOptions = new RowSelectionOptions<>();
        rowSelectionOptions.setMode(RowSelectionMode.SINGLE);
        rowSelectionOptions.setCheckboxes(false);
        rowSelectionOptions.setEnableClickSelection(true);
        rowSelectionOptions.setHideDisabledCheckboxes(true);
        rowSelectionOptions.setCheckboxLocation(CheckboxLocation.SELECTION_COLUMN);
        
        options.setRowSelection(rowSelectionOptions);
        
        // Verify all properties are set correctly
        assertNotNull(options.getRowSelection());
        assertEquals(RowSelectionMode.SINGLE, options.getRowSelection().getMode());
        assertFalse(options.getRowSelection().getCheckboxes());
        assertEquals(true, options.getRowSelection().getEnableClickSelection());
        assertTrue(options.getRowSelection().getHideDisabledCheckboxes());
        assertEquals(CheckboxLocation.SELECTION_COLUMN, options.getRowSelection().getCheckboxLocation());
    }
}