package com.jwebmp.plugins.aggrid.options.selectors;

/**
 * Contract for AG Grid field selectors (e.g., valueGetter).
 * Implementations control how they serialize to JSON via @JsonValue or @JsonRawValue.
 */
public interface FieldSelector {
    // Marker interface; implementations provide @JsonValue serialization.
}
