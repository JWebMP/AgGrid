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

    /**
     * Set to true to disable column virtualization.
     */
    @JsonProperty("suppressColumnVirtualisation")
    private @Nullable Boolean suppressColumnVirtualisation;

    /**
     * Set to true to disable row virtualization.
     */
    @JsonProperty("suppressRowVirtualisation")
    private @Nullable Boolean suppressRowVirtualisation;

    /**
     * Set to true to suppress row hover highlight.
     */
    @JsonProperty("suppressRowHoverHighlight")
    private @Nullable Boolean suppressRowHoverHighlight;

    /**
     * Set to true to suppress horizontal scroll.
     */
    @JsonProperty("suppressHorizontalScroll")
    private @Nullable Boolean suppressHorizontalScroll;

    /**
     * Set to true to suppress tabbing.
     */
    @JsonProperty("suppressTabbing")
    private @Nullable Boolean suppressTabbing;

    /**
     * Set to true to suppress scroll on new data.
     */
    @JsonProperty("suppressScrollOnNewData")
    private @Nullable Boolean suppressScrollOnNewData;

    /**
     * When true, the grid will not use animation frames when drawing rows while scrolling.
     */
    @JsonProperty("suppressAnimationFrame")
    private @Nullable Boolean suppressAnimationFrame;

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

    public @Nullable Boolean getSuppressColumnVirtualisation()
    {
        return suppressColumnVirtualisation;
    }

    public @Nullable Boolean getSuppressRowVirtualisation()
    {
        return suppressRowVirtualisation;
    }

    public @Nullable Boolean getSuppressRowHoverHighlight()
    {
        return suppressRowHoverHighlight;
    }

    public @Nullable Boolean getSuppressHorizontalScroll()
    {
        return suppressHorizontalScroll;
    }

    public @Nullable Boolean getSuppressTabbing()
    {
        return suppressTabbing;
    }

    public @Nullable Boolean getSuppressScrollOnNewData()
    {
        return suppressScrollOnNewData;
    }

    public @Nullable Boolean getSuppressAnimationFrame()
    {
        return suppressAnimationFrame;
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

    @SuppressWarnings("unchecked")
    public J setSuppressColumnVirtualisation(@Nullable Boolean suppressColumnVirtualisation)
    {
        this.suppressColumnVirtualisation = suppressColumnVirtualisation;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setSuppressRowVirtualisation(@Nullable Boolean suppressRowVirtualisation)
    {
        this.suppressRowVirtualisation = suppressRowVirtualisation;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setSuppressRowHoverHighlight(@Nullable Boolean suppressRowHoverHighlight)
    {
        this.suppressRowHoverHighlight = suppressRowHoverHighlight;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setSuppressHorizontalScroll(@Nullable Boolean suppressHorizontalScroll)
    {
        this.suppressHorizontalScroll = suppressHorizontalScroll;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setSuppressTabbing(@Nullable Boolean suppressTabbing)
    {
        this.suppressTabbing = suppressTabbing;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setSuppressScrollOnNewData(@Nullable Boolean suppressScrollOnNewData)
    {
        this.suppressScrollOnNewData = suppressScrollOnNewData;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setSuppressAnimationFrame(@Nullable Boolean suppressAnimationFrame)
    {
        this.suppressAnimationFrame = suppressAnimationFrame;
        return (J) this;
    }
}
