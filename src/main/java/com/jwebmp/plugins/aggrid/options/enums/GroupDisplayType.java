package com.jwebmp.plugins.aggrid.options.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * AG Grid Group Display Type Enum
 * Defines how grouped rows are displayed in the grid.
 * Community Edition Feature
 *
 * @author YourName
 * @since 2025
 */
public enum GroupDisplayType
{
    /**
     * Group columns are displayed in a single column (default).
     */
    SINGLE_COLUMN("singleColumn"),

    /**
     * Group columns are displayed in multiple columns.
     */
    MULTIPLE_COLUMNS("multipleColumns"),

    /**
     * Groups are displayed as regular rows with expand/collapse.
     */
    GROUP_ROWS("groupRows"),

    /**
     * Custom group display via custom renderer.
     */
    CUSTOM("custom");

    private final String json;

    GroupDisplayType(String json)
    {
        this.json = json;
    }

    @JsonValue
    public String getJson()
    {
        return json;
    }

    @Override
    public String toString()
    {
        return json;
    }

    /**
     * Factory method to convert string to enum.
     */
    public static GroupDisplayType fromString(String value)
    {
        if (value == null)
        {
            return null;
        }
        for (GroupDisplayType type : GroupDisplayType.values())
        {
            if (type.json.equalsIgnoreCase(value))
            {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown GroupDisplayType: " + value);
    }
}
