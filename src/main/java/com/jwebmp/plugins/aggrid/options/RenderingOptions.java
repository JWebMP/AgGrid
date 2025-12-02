package com.jwebmp.plugins.aggrid.options;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * AG Grid rendering options.
 * Controls animation, flashing, virtualization and display performance.
 *
 * @author DevSuite
 * @since 2025
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RenderingOptions<J extends RenderingOptions<J>>
{
    /**
     * Set to false to disable row animation which is enabled by default.
     */
    @JsonProperty("animateRows")
    private @Nullable Boolean animateRows;

    /**
     * Duration in milliseconds that a cell remains in the flashed state after changes.
     * If 0, the cell will not flash.
     */
    @JsonProperty("cellFlashDuration")
    private @Nullable Integer cellFlashDuration;

    /**
     * Duration in milliseconds for the fade-out of the flashed state.
     */
    @JsonProperty("cellFadeDuration")
    private @Nullable Integer cellFadeDuration;

    /**
     * When true, allow cells to flash even when the change was caused by filtering.
     * Default is false.
     */
    @JsonProperty("allowShowChangeAfterFilter")
    private @Nullable Boolean allowShowChangeAfterFilter;

    // Getters

    public @Nullable Boolean getAnimateRows()
    {
        return animateRows;
    }

    public @Nullable Integer getCellFlashDuration()
    {
        return cellFlashDuration;
    }

    public @Nullable Integer getCellFadeDuration()
    {
        return cellFadeDuration;
    }

    public @Nullable Boolean getAllowShowChangeAfterFilter()
    {
        return allowShowChangeAfterFilter;
    }

    // Setters with CRTP return type

    @SuppressWarnings("unchecked")
    public J setAnimateRows(@Nullable Boolean animateRows)
    {
        this.animateRows = animateRows;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setCellFlashDuration(@Nullable Integer cellFlashDuration)
    {
        this.cellFlashDuration = cellFlashDuration;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setCellFadeDuration(@Nullable Integer cellFadeDuration)
    {
        this.cellFadeDuration = cellFadeDuration;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setAllowShowChangeAfterFilter(@Nullable Boolean allowShowChangeAfterFilter)
    {
        this.allowShowChangeAfterFilter = allowShowChangeAfterFilter;
        return (J) this;
    }
}
