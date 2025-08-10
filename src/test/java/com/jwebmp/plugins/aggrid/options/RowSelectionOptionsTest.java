package com.jwebmp.plugins.aggrid.options;

import com.jwebmp.plugins.aggrid.options.enums.CheckboxLocation;
import com.jwebmp.plugins.aggrid.options.enums.RowSelectionMode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for RowSelectionOptions class
 */
public class RowSelectionOptionsTest
{
    @Test
    public void testRowSelectionOptions()
    {
        // Create row selection options
        RowSelectionOptions<?> options = new RowSelectionOptions<>();
        
        // Test default values
        assertNull(options.getMode());
        assertNull(options.getCheckboxes());
        assertNull(options.getCheckboxLocation());
        assertNull(options.getHideDisabledCheckboxes());
        assertNull(options.getEnableClickSelection());
        assertNull(options.getCopySelectedRows());
        assertNull(options.getEnableSelectionWithoutKeys());
        assertNull(options.getMasterSelects());
        
        // Test setting values
        options.setMode(RowSelectionMode.MULTIPLE);
        options.setCheckboxes(true);
        options.setCheckboxLocation(CheckboxLocation.SELECTION_COLUMN);
        options.setHideDisabledCheckboxes(true);
        options.setEnableClickSelection(true);
        options.setCopySelectedRows(true);
        options.setEnableSelectionWithoutKeys(false);
        options.setMasterSelects("self");
        
        // Test getting values
        assertEquals(RowSelectionMode.MULTIPLE, options.getMode());
        assertTrue(options.getCheckboxes());
        assertEquals(CheckboxLocation.SELECTION_COLUMN, options.getCheckboxLocation());
        assertTrue(options.getHideDisabledCheckboxes());
        assertEquals(true, options.getEnableClickSelection());
        assertTrue(options.getCopySelectedRows());
        assertFalse(options.getEnableSelectionWithoutKeys());
        assertEquals("self", options.getMasterSelects());
        
        // Test constructor with mode
        RowSelectionOptions<?> optionsWithMode = new RowSelectionOptions<>(RowSelectionMode.SINGLE);
        assertEquals(RowSelectionMode.SINGLE, optionsWithMode.getMode());
        
        // Test string-based checkbox location
        options.setCheckboxLocationString("autoGroupColumn");
        assertEquals(CheckboxLocation.AUTO_GROUP_COLUMN, options.getCheckboxLocation());
    }
    
    @Test
    public void testSingleRowSelection()
    {
        // Create row selection options for single selection
        RowSelectionOptions<?> options = new RowSelectionOptions<>();
        options.setMode(RowSelectionMode.SINGLE);
        
        // Verify mode is set correctly
        assertEquals(RowSelectionMode.SINGLE, options.getMode());
        
        // Test with different click selection options
        options.setEnableClickSelection(true);
        assertEquals(true, options.getEnableClickSelection());
        
        options.setEnableClickSelection("enableSelection");
        assertEquals("enableSelection", options.getEnableClickSelection());
        
        options.setEnableClickSelection("enableDeselection");
        assertEquals("enableDeselection", options.getEnableClickSelection());
        
        // Test with checkboxes disabled
        options.setCheckboxes(false);
        assertFalse(options.getCheckboxes());
    }
}