package com.jwebmp.plugins.aggrid.options.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enum for DOM layout types in AG Grid.
 * Determines the layout mode for the grid.
 *
 * @author DevSuite
 * @since 2025
 */
public enum DomLayoutType
{
    /**
     * Standard layout with all grid features.
     */
    NORMAL("normal"),

    /**
     * Auto-height layout that adjusts to content.
     */
    AUTO_HEIGHT("autoHeight"),

    /**
     * Print layout optimized for printing.
     */
    PRINT("print");

    private final String value;

    DomLayoutType(String value)
    {
        this.value = value;
    }

    @JsonValue
    public String getValue()
    {
        return value;
    }

    public static DomLayoutType fromString(String value)
    {
        for (DomLayoutType type : DomLayoutType.values())
        {
            if (type.value.equalsIgnoreCase(value))
            {
                return type;
            }
        }
        return null;
    }

    @Override
    public String toString()
    {
        return value;
    }
}
