package com.jwebmp.plugins.aggrid.options;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import org.jspecify.annotations.Nullable;

/**
 * AG Grid Editing Options.
 * Configures cell and row editing behavior.
 *
 * @author DevSuite
 * @since 2025
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EditingOptions<J extends EditingOptions<J>>
{
    @JsonProperty("editType")
    private @Nullable String editType;

    @JsonProperty("singleClickEdit")
    private @Nullable Boolean singleClickEdit;

    @JsonProperty("suppressClickEdit")
    private @Nullable Boolean suppressClickEdit;

    @JsonProperty("stopEditingWhenCellsLoseFocus")
    private @Nullable Boolean stopEditingWhenCellsLoseFocus;

    @JsonProperty("stopEditingWhenGridLosesFocus")
    private @Nullable Boolean stopEditingWhenGridLosesFocus;

    @JsonProperty("enterMovesDown")
    private @Nullable Boolean enterMovesDown;

    @JsonProperty("enterMovesDownAfterEdit")
    private @Nullable Boolean enterMovesDownAfterEdit;

    @JsonProperty("suppressKeyboardEvent")
    @JsonRawValue
    private @Nullable String suppressKeyboardEvent;

    // Getters

    public @Nullable String getEditType()
    {
        return editType;
    }

    public @Nullable Boolean getSingleClickEdit()
    {
        return singleClickEdit;
    }

    public @Nullable Boolean getSuppressClickEdit()
    {
        return suppressClickEdit;
    }

    public @Nullable Boolean getStopEditingWhenCellsLoseFocus()
    {
        return stopEditingWhenCellsLoseFocus;
    }

    public @Nullable Boolean getStopEditingWhenGridLosesFocus()
    {
        return stopEditingWhenGridLosesFocus;
    }

    public @Nullable Boolean getEnterMovesDown()
    {
        return enterMovesDown;
    }

    public @Nullable Boolean getEnterMovesDownAfterEdit()
    {
        return enterMovesDownAfterEdit;
    }

    public @Nullable String getSuppressKeyboardEvent()
    {
        return suppressKeyboardEvent;
    }

    // Setters with CRTP return type

    @SuppressWarnings("unchecked")
    public J setEditType(@Nullable String editType)
    {
        this.editType = editType;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setSingleClickEdit(@Nullable Boolean singleClickEdit)
    {
        this.singleClickEdit = singleClickEdit;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setSuppressClickEdit(@Nullable Boolean suppressClickEdit)
    {
        this.suppressClickEdit = suppressClickEdit;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setStopEditingWhenCellsLoseFocus(@Nullable Boolean stopEditingWhenCellsLoseFocus)
    {
        this.stopEditingWhenCellsLoseFocus = stopEditingWhenCellsLoseFocus;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setStopEditingWhenGridLosesFocus(@Nullable Boolean stopEditingWhenGridLosesFocus)
    {
        this.stopEditingWhenGridLosesFocus = stopEditingWhenGridLosesFocus;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setEnterMovesDown(@Nullable Boolean enterMovesDown)
    {
        this.enterMovesDown = enterMovesDown;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setEnterMovesDownAfterEdit(@Nullable Boolean enterMovesDownAfterEdit)
    {
        this.enterMovesDownAfterEdit = enterMovesDownAfterEdit;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setSuppressKeyboardEvent(@Nullable String suppressKeyboardEvent)
    {
        this.suppressKeyboardEvent = suppressKeyboardEvent;
        return (J) this;
    }
}
