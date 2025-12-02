package com.jwebmp.plugins.aggrid.options;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import org.jspecify.annotations.Nullable;

/**
 * AG Grid Filtering Options.
 * Configures filtering behavior including quick filter and external filter.
 *
 * @author DevSuite
 * @since 2025
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FilteringOptions<J extends FilteringOptions<J>>
{
    @JsonProperty("quickFilterText")
    private @Nullable String quickFilterText;

    @JsonProperty("caseInsensitiveSort")
    private @Nullable Boolean caseInsensitiveSort;

    @JsonProperty("floatingFilter")
    private @Nullable Boolean floatingFilter;

    @JsonProperty("enableRtl")
    private @Nullable Boolean enableRtl;

    @JsonProperty("externalFilterChanged")
    @JsonRawValue
    private @Nullable String externalFilterChanged;

    @JsonProperty("isExternalFilterPresent")
    @JsonRawValue
    private @Nullable String isExternalFilterPresent;

    @JsonProperty("doesExternalFilterPass")
    @JsonRawValue
    private @Nullable String doesExternalFilterPass;

    @JsonProperty("onFilterChanged")
    @JsonRawValue
    private @Nullable String onFilterChanged;

    // Getters

    public @Nullable String getQuickFilterText()
    {
        return quickFilterText;
    }

    public @Nullable Boolean getCaseInsensitiveSort()
    {
        return caseInsensitiveSort;
    }

    public @Nullable Boolean getFloatingFilter()
    {
        return floatingFilter;
    }

    public @Nullable Boolean getEnableRtl()
    {
        return enableRtl;
    }

    public @Nullable String getExternalFilterChanged()
    {
        return externalFilterChanged;
    }

    public @Nullable String getIsExternalFilterPresent()
    {
        return isExternalFilterPresent;
    }

    public @Nullable String getDoesExternalFilterPass()
    {
        return doesExternalFilterPass;
    }

    public @Nullable String getOnFilterChanged()
    {
        return onFilterChanged;
    }

    // Setters with CRTP return type

    @SuppressWarnings("unchecked")
    public J setQuickFilterText(@Nullable String quickFilterText)
    {
        this.quickFilterText = quickFilterText;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setCaseInsensitiveSort(@Nullable Boolean caseInsensitiveSort)
    {
        this.caseInsensitiveSort = caseInsensitiveSort;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setFloatingFilter(@Nullable Boolean floatingFilter)
    {
        this.floatingFilter = floatingFilter;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setEnableRtl(@Nullable Boolean enableRtl)
    {
        this.enableRtl = enableRtl;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setExternalFilterChanged(@Nullable String externalFilterChanged)
    {
        this.externalFilterChanged = externalFilterChanged;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setIsExternalFilterPresent(@Nullable String isExternalFilterPresent)
    {
        this.isExternalFilterPresent = isExternalFilterPresent;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setDoesExternalFilterPass(@Nullable String doesExternalFilterPass)
    {
        this.doesExternalFilterPass = doesExternalFilterPass;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setOnFilterChanged(@Nullable String onFilterChanged)
    {
        this.onFilterChanged = onFilterChanged;
        return (J) this;
    }
}
