package com.jwebmp.plugins.aggrid.options.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * AG Grid Pivot Panel Show Type Enum
 * Defines when the pivot panel should be displayed.
 * Community Edition Feature
 *
 * @author YourName
 * @since 2025
 */
public enum PivotPanelShowType
{
    /**
     * Pivot panel is always shown.
     */
    ALWAYS("always"),

    /**
     * Pivot panel is only shown when pivoting is active.
     */
    ONLY_WHEN_PIVOTING("onlyWhenPivoting"),

    /**
     * Pivot panel is never shown.
     */
    NEVER("never");

    private final String json;

    PivotPanelShowType(String json)
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
    public static PivotPanelShowType fromString(String value)
    {
        if (value == null)
        {
            return null;
        }
        for (PivotPanelShowType type : PivotPanelShowType.values())
        {
            if (type.json.equalsIgnoreCase(value))
            {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown PivotPanelShowType: " + value);
    }
}
