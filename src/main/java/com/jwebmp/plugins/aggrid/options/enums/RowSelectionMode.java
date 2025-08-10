package com.jwebmp.plugins.aggrid.options.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enum for row selection modes in AG Grid
 *
 * @author Junie
 * @since 2025-08-09
 */
public enum RowSelectionMode
{
    /**
     * Single row selection mode
     */
    SINGLE("singleRow"),
    
    /**
     * Multiple row selection mode
     */
    MULTIPLE("multiple");
    
    private final String value;
    
    RowSelectionMode(String value)
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
    public static RowSelectionMode fromString(String value)
    {
        for (RowSelectionMode mode : RowSelectionMode.values())
        {
            if (mode.value.equalsIgnoreCase(value))
            {
                return mode;
            }
        }
        return null;
    }
}