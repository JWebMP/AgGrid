package com.jwebmp.plugins.aggrid.options.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enum for checkbox location options in AG Grid
 *
 * @author Junie
 * @since 2025-08-09
 */
public enum CheckboxLocation
{
    /**
     * Display checkboxes in a dedicated selection column
     */
    SELECTION_COLUMN("selectionColumn"),
    
    /**
     * Display checkboxes in the auto group column
     */
    AUTO_GROUP_COLUMN("autoGroupColumn");
    
    private final String value;
    
    CheckboxLocation(String value)
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
    public static CheckboxLocation fromString(String value)
    {
        for (CheckboxLocation location : CheckboxLocation.values())
        {
            if (location.value.equalsIgnoreCase(value))
            {
                return location;
            }
        }
        return null;
    }
}