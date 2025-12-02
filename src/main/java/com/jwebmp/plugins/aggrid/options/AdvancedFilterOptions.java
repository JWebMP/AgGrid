package com.jwebmp.plugins.aggrid.options;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import org.jspecify.annotations.Nullable;

/**
 * AG Grid Advanced Filter options.
 * Controls the advanced filter UI and configuration.
 * NEW in AG Grid v34.2.0 - Community Edition support.
 *
 * @author DevSuite
 * @since 2025
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AdvancedFilterOptions<J extends AdvancedFilterOptions<J>>
{
    /**
     * Enable the Advanced Filter feature.
     */
    @JsonProperty("enableAdvancedFilter")
    private @Nullable Boolean enableAdvancedFilter;

    /**
     * Column definitions to display in the Advanced Filter.
     * Expects a raw JavaScript array of column definitions.
     * Signature: IAdvancedFilterBuilderParams['columns']
     */
    @JsonProperty("advancedFilterBuilderParams")
    @JsonRawValue
    private @Nullable String advancedFilterBuilderParams;

    /**
     * The parent element for the Advanced Filter UI.
     * Can be a DOM element reference or selector string.
     */
    @JsonProperty("advancedFilterParentElement")
    private @Nullable String advancedFilterParentElement;

    /**
     * Custom CSS class to apply to the Advanced Filter container.
     */
    @JsonProperty("advancedFilterClassName")
    private @Nullable String advancedFilterClassName;

    /**
     * Callback function invoked when the Advanced Filter expression changes.
     * Signature: (expression: AdvancedFilterExpression | null) => void
     */
    @JsonProperty("onAdvancedFilterChanged")
    @JsonRawValue
    private @Nullable String onAdvancedFilterChanged;

    // Getters

    public @Nullable Boolean getEnableAdvancedFilter()
    {
        return enableAdvancedFilter;
    }

    public @Nullable String getAdvancedFilterBuilderParams()
    {
        return advancedFilterBuilderParams;
    }

    public @Nullable String getAdvancedFilterParentElement()
    {
        return advancedFilterParentElement;
    }

    public @Nullable String getAdvancedFilterClassName()
    {
        return advancedFilterClassName;
    }

    public @Nullable String getOnAdvancedFilterChanged()
    {
        return onAdvancedFilterChanged;
    }

    // Setters with CRTP return type

    @SuppressWarnings("unchecked")
    public J setEnableAdvancedFilter(@Nullable Boolean enableAdvancedFilter)
    {
        this.enableAdvancedFilter = enableAdvancedFilter;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setAdvancedFilterBuilderParams(@Nullable String advancedFilterBuilderParams)
    {
        this.advancedFilterBuilderParams = advancedFilterBuilderParams;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setAdvancedFilterParentElement(@Nullable String advancedFilterParentElement)
    {
        this.advancedFilterParentElement = advancedFilterParentElement;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setAdvancedFilterClassName(@Nullable String advancedFilterClassName)
    {
        this.advancedFilterClassName = advancedFilterClassName;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setOnAdvancedFilterChanged(@Nullable String onAdvancedFilterChanged)
    {
        this.onAdvancedFilterChanged = onAdvancedFilterChanged;
        return (J) this;
    }
}
