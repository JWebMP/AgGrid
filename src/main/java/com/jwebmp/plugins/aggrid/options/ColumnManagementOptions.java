package com.jwebmp.plugins.aggrid.options;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.jspecify.annotations.Nullable;

/**
 * AG Grid Column Management Options.
 * Controls column visibility, moving, sizing, and pinning.
 *
 * @author DevSuite
 * @since 2025
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ColumnManagementOptions<J extends ColumnManagementOptions<J>>
{
    @JsonProperty("suppressColumnMoveAnimation")
    private @Nullable Boolean suppressColumnMoveAnimation;

    @JsonProperty("suppressDragLeaveHidesColumns")
    private @Nullable Boolean suppressDragLeaveHidesColumns;

    @JsonProperty("suppressMoveWhenColumnDragging")
    private @Nullable Boolean suppressMoveWhenColumnDragging;

    @JsonProperty("suppressDragColumnIntoGroup")
    private @Nullable Boolean suppressDragColumnIntoGroup;

    @JsonProperty("suppressCutOnKey")
    private @Nullable Boolean suppressCutOnKey;

    @JsonProperty("suppressClipboardPaste")
    private @Nullable Boolean suppressClipboardPaste;

    @JsonProperty("suppressLastEmptyLinePeristance")
    private @Nullable Boolean suppressLastEmptyLinePeristance;

    @JsonProperty("suppressFocusAfterFilterChanged")
    private @Nullable Boolean suppressFocusAfterFilterChanged;

    @JsonProperty("suppressRowClickSelection")
    private @Nullable Boolean suppressRowClickSelection;

    @JsonProperty("suppressCellClickSelection")
    private @Nullable Boolean suppressCellClickSelection;

    // Getters

    public @Nullable Boolean getSuppressColumnMoveAnimation()
    {
        return suppressColumnMoveAnimation;
    }

    public @Nullable Boolean getSuppressDragLeaveHidesColumns()
    {
        return suppressDragLeaveHidesColumns;
    }

    public @Nullable Boolean getSuppressMoveWhenColumnDragging()
    {
        return suppressMoveWhenColumnDragging;
    }

    public @Nullable Boolean getSuppressDragColumnIntoGroup()
    {
        return suppressDragColumnIntoGroup;
    }

    public @Nullable Boolean getSuppressCutOnKey()
    {
        return suppressCutOnKey;
    }

    public @Nullable Boolean getSuppressClipboardPaste()
    {
        return suppressClipboardPaste;
    }

    public @Nullable Boolean getSuppressLastEmptyLinePeristance()
    {
        return suppressLastEmptyLinePeristance;
    }

    public @Nullable Boolean getSuppressFocusAfterFilterChanged()
    {
        return suppressFocusAfterFilterChanged;
    }

    public @Nullable Boolean getSuppressRowClickSelection()
    {
        return suppressRowClickSelection;
    }

    public @Nullable Boolean getSuppressCellClickSelection()
    {
        return suppressCellClickSelection;
    }

    // Setters with CRTP return type

    @SuppressWarnings("unchecked")
    public J setSuppressColumnMoveAnimation(@Nullable Boolean suppressColumnMoveAnimation)
    {
        this.suppressColumnMoveAnimation = suppressColumnMoveAnimation;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setSuppressDragLeaveHidesColumns(@Nullable Boolean suppressDragLeaveHidesColumns)
    {
        this.suppressDragLeaveHidesColumns = suppressDragLeaveHidesColumns;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setSuppressMoveWhenColumnDragging(@Nullable Boolean suppressMoveWhenColumnDragging)
    {
        this.suppressMoveWhenColumnDragging = suppressMoveWhenColumnDragging;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setSuppressDragColumnIntoGroup(@Nullable Boolean suppressDragColumnIntoGroup)
    {
        this.suppressDragColumnIntoGroup = suppressDragColumnIntoGroup;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setSuppressCutOnKey(@Nullable Boolean suppressCutOnKey)
    {
        this.suppressCutOnKey = suppressCutOnKey;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setSuppressClipboardPaste(@Nullable Boolean suppressClipboardPaste)
    {
        this.suppressClipboardPaste = suppressClipboardPaste;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setSuppressLastEmptyLinePeristance(@Nullable Boolean suppressLastEmptyLinePeristance)
    {
        this.suppressLastEmptyLinePeristance = suppressLastEmptyLinePeristance;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setSuppressFocusAfterFilterChanged(@Nullable Boolean suppressFocusAfterFilterChanged)
    {
        this.suppressFocusAfterFilterChanged = suppressFocusAfterFilterChanged;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setSuppressRowClickSelection(@Nullable Boolean suppressRowClickSelection)
    {
        this.suppressRowClickSelection = suppressRowClickSelection;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setSuppressCellClickSelection(@Nullable Boolean suppressCellClickSelection)
    {
        this.suppressCellClickSelection = suppressCellClickSelection;
        return (J) this;
    }
}
