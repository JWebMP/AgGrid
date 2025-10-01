package com.jwebmp.plugins.aggrid.options.selectors;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Field selector that serializes as a plain JSON string expression (e.g., "node.rowIndex + 1").
 * AG Grid accepts string expressions for valueGetter.
 */
public final class FieldSelectorExpression implements FieldSelector {

    private final String expression;

    public FieldSelectorExpression(String expression) {
        this.expression = expression;
    }

    @JsonValue
    public String asJson() {
        return expression;
    }

    @Override
    public String toString() {
        return expression;
    }
}
