package com.jwebmp.plugins.aggrid.options.selectors;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Field selector that serializes as raw JavaScript (e.g., function or arrow function).
 * Use with care; only valid when embedding into a JS/TS context (not strict JSON).
 */
public final class FieldSelectorRaw implements FieldSelector {

    private final String rawJavascript;

    public FieldSelectorRaw(String rawJavascript) {
        this.rawJavascript = rawJavascript;
    }

    @JsonValue
    @JsonRawValue
    public String asRaw() {
        return rawJavascript;
    }

    @Override
    public String toString() {
        return rawJavascript;
    }
}
