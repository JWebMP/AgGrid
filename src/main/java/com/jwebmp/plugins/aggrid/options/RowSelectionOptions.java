package com.jwebmp.plugins.aggrid.options;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.aggrid.options.enums.CheckboxLocation;
import com.jwebmp.plugins.aggrid.options.enums.RowSelectionMode;

/**
 * Options for row selection in AG Grid
 *
 * @author Junie
 * @since 2025-08-09
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RowSelectionOptions<J extends RowSelectionOptions<J>> extends JavaScriptPart<J>
{
    /**
     * The row selection mode (single or multiple)
     */
    @JsonProperty("mode")
    private RowSelectionMode mode;
    
    /**
     * Whether to show checkboxes for row selection
     */
    @JsonProperty("checkboxes")
    private Boolean checkboxes;
    
    /**
     * Where to display checkboxes
     */
    @JsonProperty("checkboxLocation")
    private CheckboxLocation checkboxLocation;
    
    /**
     * Whether to hide disabled checkboxes for non-selectable rows
     */
    @JsonProperty("hideDisabledCheckboxes")
    private Boolean hideDisabledCheckboxes;
    
    /**
     * Whether to enable row selection by clicking on the row
     */
    @JsonProperty("enableClickSelection")
    private Object enableClickSelection;
    
    /**
     * Whether to copy selected rows when copying
     */
    @JsonProperty("copySelectedRows")
    private Boolean copySelectedRows;
    
    /**
     * Whether to allow row selection without modifier keys
     */
    @JsonProperty("enableSelectionWithoutKeys")
    private Boolean enableSelectionWithoutKeys;
    
    /**
     * Determines the selection behavior of master rows
     */
    @JsonProperty("masterSelects")
    private String masterSelects;
    
    /**
     * Default constructor
     */
    public RowSelectionOptions()
    {
        // Default constructor
    }
    
    /**
     * Constructor with mode
     *
     * @param mode The row selection mode
     */
    public RowSelectionOptions(RowSelectionMode mode)
    {
        this.mode = mode;
    }
    
    /**
     * Gets the row selection mode
     *
     * @return The row selection mode
     */
    public RowSelectionMode getMode()
    {
        return mode;
    }
    
    /**
     * Sets the row selection mode
     *
     * @param mode The row selection mode
     * @return This object
     */
    public @org.jspecify.annotations.NonNull J setMode(RowSelectionMode mode)
    {
        this.mode = mode;
        return (J) this;
    }
    
    /**
     * Gets whether to show checkboxes for row selection
     *
     * @return Whether to show checkboxes
     */
    public Boolean getCheckboxes()
    {
        return checkboxes;
    }
    
    /**
     * Sets whether to show checkboxes for row selection
     *
     * @param checkboxes Whether to show checkboxes
     * @return This object
     */
    public @org.jspecify.annotations.NonNull J setCheckboxes(Boolean checkboxes)
    {
        this.checkboxes = checkboxes;
        return (J) this;
    }
    
    /**
     * Gets where to display checkboxes
     *
     * @return Where to display checkboxes
     */
    public CheckboxLocation getCheckboxLocation()
    {
        return checkboxLocation;
    }
    
    /**
     * Sets where to display checkboxes
     *
     * @param checkboxLocation Where to display checkboxes
     * @return This object
     */
    public @org.jspecify.annotations.NonNull J setCheckboxLocation(CheckboxLocation checkboxLocation)
    {
        this.checkboxLocation = checkboxLocation;
        return (J) this;
    }
    
    /**
     * Sets where to display checkboxes using a string value
     *
     * @param checkboxLocation Where to display checkboxes ("selectionColumn" or "autoGroupColumn")
     * @return This object
     */
    public @org.jspecify.annotations.NonNull J setCheckboxLocationString(String checkboxLocation)
    {
        this.checkboxLocation = CheckboxLocation.fromString(checkboxLocation);
        return (J) this;
    }
    
    /**
     * Gets whether to hide disabled checkboxes for non-selectable rows
     *
     * @return Whether to hide disabled checkboxes
     */
    public Boolean getHideDisabledCheckboxes()
    {
        return hideDisabledCheckboxes;
    }
    
    /**
     * Sets whether to hide disabled checkboxes for non-selectable rows
     *
     * @param hideDisabledCheckboxes Whether to hide disabled checkboxes
     * @return This object
     */
    public @org.jspecify.annotations.NonNull J setHideDisabledCheckboxes(Boolean hideDisabledCheckboxes)
    {
        this.hideDisabledCheckboxes = hideDisabledCheckboxes;
        return (J) this;
    }
    
    /**
     * Gets whether to enable row selection by clicking on the row
     *
     * @return Whether to enable click selection
     */
    public Object getEnableClickSelection()
    {
        return enableClickSelection;
    }
    
    /**
     * Sets whether to enable row selection by clicking on the row
     *
     * @param enableClickSelection Whether to enable click selection (true, false, "enableSelection", "enableDeselection")
     * @return This object
     */
    public @org.jspecify.annotations.NonNull J setEnableClickSelection(Object enableClickSelection)
    {
        this.enableClickSelection = enableClickSelection;
        return (J) this;
    }
    
    /**
     * Gets whether to copy selected rows when copying
     *
     * @return Whether to copy selected rows
     */
    public Boolean getCopySelectedRows()
    {
        return copySelectedRows;
    }
    
    /**
     * Sets whether to copy selected rows when copying
     *
     * @param copySelectedRows Whether to copy selected rows
     * @return This object
     */
    public @org.jspecify.annotations.NonNull J setCopySelectedRows(Boolean copySelectedRows)
    {
        this.copySelectedRows = copySelectedRows;
        return (J) this;
    }
    
    /**
     * Gets whether to allow row selection without modifier keys
     *
     * @return Whether to allow selection without keys
     */
    public Boolean getEnableSelectionWithoutKeys()
    {
        return enableSelectionWithoutKeys;
    }
    
    /**
     * Sets whether to allow row selection without modifier keys
     *
     * @param enableSelectionWithoutKeys Whether to allow selection without keys
     * @return This object
     */
    public @org.jspecify.annotations.NonNull J setEnableSelectionWithoutKeys(Boolean enableSelectionWithoutKeys)
    {
        this.enableSelectionWithoutKeys = enableSelectionWithoutKeys;
        return (J) this;
    }
    
    /**
     * Gets the selection behavior of master rows
     *
     * @return The master selection behavior
     */
    public String getMasterSelects()
    {
        return masterSelects;
    }
    
    /**
     * Sets the selection behavior of master rows
     *
     * @param masterSelects The master selection behavior ("self" or "detail")
     * @return This object
     */
    public @org.jspecify.annotations.NonNull J setMasterSelects(String masterSelects)
    {
        this.masterSelects = masterSelects;
        return (J) this;
    }
}