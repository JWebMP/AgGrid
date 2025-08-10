package com.jwebmp.plugins.aggrid.options;

import com.jwebmp.plugins.aggrid.cellrenderers.FullWidthCellRenderer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for full width rows functionality in AgGridOptions
 */
public class AgGridOptionsFullWidthRowsTest
{
    @Test
    public void testFullWidthRowsOptions()
    {
        // Create grid options
        AgGridOptions<?> options = new AgGridOptions<>();
        
        // Test default values
        assertNull(options.getIsFullWidthRow());
        assertNull(options.getFullWidthCellRenderer());
        assertNull(options.getEmbedFullWidthRows());
        
        // Test setting values
        options.setIsFullWidthRow("params => params.data.fullWidth === true");
        options.setFullWidthCellRenderer("MyCustomFullWidthRenderer");
        options.setEmbedFullWidthRows(true);
        
        // Test getting values
        assertEquals("params => params.data.fullWidth === true", options.getIsFullWidthRow());
        assertEquals("MyCustomFullWidthRenderer", options.getFullWidthCellRenderer());
        assertTrue(options.getEmbedFullWidthRows());
    }
    
    @Test
    public void testFullWidthCellRendererWithClassName()
    {
        // Create grid options
        AgGridOptions<?> options = new AgGridOptions<>();
        
        // Test setting cell renderer with class name
        options.setFullWidthCellRendererClassName("CustomFullWidthRenderer");
        
        // Test getting value
        assertEquals("CustomFullWidthRenderer", options.getFullWidthCellRenderer());
    }
    
    // This test is commented out because the method is not yet implemented
    // We would need to add a method to AgGridOptions similar to the one in AgGridColumnDef
    /*
    @Test
    public void testFullWidthCellRendererWithClass()
    {
        // Create grid options
        AgGridOptions<?> options = new AgGridOptions<>();
        
        // Test setting cell renderer with class
        options.setFullWidthCellRenderer(FullWidthCellRenderer.class);
        
        // Test getting value
        assertEquals("FullWidthCellRenderer", options.getFullWidthCellRenderer());
    }
    */
}