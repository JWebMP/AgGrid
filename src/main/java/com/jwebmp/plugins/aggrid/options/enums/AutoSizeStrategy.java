package com.jwebmp.plugins.aggrid.options.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enum for auto-size strategy options in AG Grid
 *
 * @author Junie
 * @since 2025-08-09
 */
public enum AutoSizeStrategy
{
    /**
     * Fit columns to the grid width
     */
    FIT_GRID_WIDTH("fitGridWidth"),
    
    /**
     * Fit columns to a provided width
     */
    FIT_PROVIDED_WIDTH("fitProvidedWidth"),
    
    /**
     * Fit columns to their cell contents
     */
    FIT_CELL_CONTENTS("fitCellContents");
    
    private final String value;
    
    AutoSizeStrategy(String value)
    {
        this.value = value;
    }
    
    /**
     * Gets the string value for JSON serialization
     *
     * @return The string value
     */
    @JsonValue
    public String getValue()
    {
        return value;
    }
    
    /**
     * Converts a string value to the enum
     *
     * @param value The string value
     * @return The enum value, or null if not found
     */
    public static AutoSizeStrategy fromString(String value)
    {
        for (AutoSizeStrategy strategy : AutoSizeStrategy.values())
        {
            if (strategy.value.equalsIgnoreCase(value))
            {
                return strategy;
            }
        }
        return null;
    }
}