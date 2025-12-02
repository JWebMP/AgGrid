package com.jwebmp.plugins.aggrid.options.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enum for cell selection modes in AG Grid v34.2.0+.
 * Determines how cells are selected in the grid.
 *
 * @author DevSuite
 * @since 2025
 */
public enum CellSelectionMode
{
    /**
     * Multiple individual cells can be selected.
     */
    CELL("cell"),

    /**
     * Entire rows are selected (range selection follows row boundaries).
     */
    ROW("row");

    private final String value;

    CellSelectionMode(String value)
    {
        this.value = value;
    }

    @JsonValue
    public String getValue()
    {
        return value;
    }

    public static CellSelectionMode fromString(String value)
    {
        for (CellSelectionMode mode : CellSelectionMode.values())
        {
            if (mode.value.equalsIgnoreCase(value))
            {
                return mode;
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
