package com.jwebmp.plugins.aggrid.options.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enum for edit types in AG Grid.
 * Determines when and how cell editing is triggered.
 *
 * @author DevSuite
 * @since 2025
 */
public enum EditType
{
    /**
     * Cell editing triggered by API call.
     */
    API_EDITING("apiEditing"),

    /**
     * Cell editing triggered by double-click.
     */
    DOUBLE_CLICK("doubleClick");

    private final String value;

    EditType(String value)
    {
        this.value = value;
    }

    @JsonValue
    public String getValue()
    {
        return value;
    }

    public static EditType fromString(String value)
    {
        for (EditType type : EditType.values())
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
