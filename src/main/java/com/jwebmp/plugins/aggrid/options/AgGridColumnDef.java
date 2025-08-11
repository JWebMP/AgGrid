package com.jwebmp.plugins.aggrid.options;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.jwebmp.core.base.angular.client.services.interfaces.AnnotationUtils;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.aggrid.cellrenderers.DefaultCellRenderer;
import com.jwebmp.plugins.aggrid.headers.DefaultHeaderComponent;

import java.util.List;

/**
 * The column definition for AG Grid
 *
 * @author YourName
 * @since 2023
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgGridColumnDef<J extends AgGridColumnDef<J>> extends JavaScriptPart<J>
{
    /**
     * The field name
     */
    @JsonProperty("field")
    private String field;

    /**
     * The column header
     */
    @JsonProperty("headerName")
    private String headerName;

    /**
     * Whether the column is sortable
     */
    @JsonProperty("sortable")
    private Boolean sortable;

    /**
     * Whether the column is filterable
     */
    @JsonProperty("filter")
    private Boolean filter;

    /**
     * Whether the column is resizable
     */
    @JsonProperty("resizable")
    private Boolean resizable;

    /**
     * The width of the column
     */
    @JsonProperty("width")
    private Integer width;

    /**
     * Whether the column is pinned
     */
    @JsonProperty("pinned")
    private String pinned;

    /**
     * The cell renderer component
     */
    @JsonProperty("cellRenderer")
    private DefaultCellRenderer<?> cellRenderer;

    /**
     * The cell renderer params
     */
    @JsonProperty("cellRendererParams")
    private Object cellRendererParams;

    /**
     * CSS styles for the header
     */
    @JsonProperty("headerStyle")
    private Object headerStyle;

    /**
     * CSS classes for the header
     */
    @JsonProperty("headerClass")
    private Object headerClass;

    /**
     * Tooltip for the header
     */
    @JsonProperty("headerTooltip")
    private String headerTooltip;

    /**
     * Custom Header Component (fully replaces the provided header component)
     */
    @JsonProperty("headerComponent")
    private DefaultHeaderComponent<?> headerComponent;

    /**
     * Parameters for the Provided Header Component, allowing template and inner header customization
     */
    @JsonProperty("headerComponentParams")
    private HeaderComponentParams headerComponentParams;

    /**
     * Whether to automatically adjust header height based on content
     */
    @JsonProperty("autoHeaderHeight")
    private Boolean autoHeaderHeight;

    /**
     * Whether to wrap header text
     */
    @JsonProperty("wrapHeaderText")
    private Boolean wrapHeaderText;

    /**
     * Child columns for column groups
     */
    @JsonProperty("children")
    private List<AgGridColumnDef<?>> children;

    /**
     * Determines when to show the column within a group
     * Values: 'open', 'closed', or null (always show)
     */
    @JsonProperty("columnGroupShow")
    private String columnGroupShow;

    /**
     * If true, child columns will always move together in the column order
     */
    @JsonProperty("marryChildren")
    private Boolean marryChildren;

    /**
     * If true, the column group can be opened and closed
     */
    @JsonProperty("openByDefault")
    private Boolean openByDefault;

    /**
     * If true, the column group header label will not remain visible when scrolling
     */
    @JsonProperty("suppressStickyLabel")
    private Boolean suppressStickyLabel;

    /**
     * If true, the column will not span the entire header height
     */
    @JsonProperty("suppressSpanHeaderHeight")
    private Boolean suppressSpanHeaderHeight;

    /**
     * If true, the column cannot be moved by dragging
     */
    @JsonProperty("suppressMovable")
    private Boolean suppressMovable;

    /**
     * Locks the column to a specific position ("left" or "right")
     */
    @JsonProperty("lockPosition")
    private String lockPosition;

    /**
     * If true, the column's visibility cannot be changed via the UI
     */
    @JsonProperty("lockVisible")
    private Boolean lockVisible;

    /**
     * If true, the column cannot be pinned or unpinned via the UI
     */
    @JsonProperty("lockPinned")
    private Boolean lockPinned;

    /**
     * The flex value for the column (used for responsive sizing)
     */
    @JsonProperty("flex")
    private Integer flex;

    /**
     * The minimum width for the column in pixels
     */
    @JsonProperty("minWidth")
    private Integer minWidth;

    /**
     * The maximum width for the column in pixels
     */
    @JsonProperty("maxWidth")
    private Integer maxWidth;

    /**
     * If true, the column will not be included when sizing columns to fit the grid
     */
    @JsonProperty("suppressSizeToFit")
    private Boolean suppressSizeToFit;

    /**
     * Function or value for column spanning
     * Allows cells to span multiple columns
     */
    @JsonProperty("colSpan")
    private Object colSpan;

    /**
     * Default constructor
     */
    public AgGridColumnDef()
    {
        // Default constructor
    }

    /**
     * Constructor with field name
     *
     * @param field The field name
     */
    public AgGridColumnDef(String field)
    {
        this.field = field;
        this.headerName = field;
    }

    /**
     * Constructor with field name and header
     *
     * @param field      The field name
     * @param headerName The column header
     */
    public AgGridColumnDef(String field, String headerName)
    {
        this.field = field;
        this.headerName = headerName;
    }

    /**
     * Gets the field name
     *
     * @return The field name
     */
    public String getField()
    {
        return field;
    }

    /**
     * Sets the field name
     *
     * @param field The field name
     * @return This object
     */
    public J setField(String field)
    {
        this.field = field;
        return (J) this;
    }

    /**
     * Gets the column header
     *
     * @return The column header
     */
    public String getHeaderName()
    {
        return headerName;
    }

    /**
     * Sets the column header
     *
     * @param headerName The column header
     * @return This object
     */
    public J setHeaderName(String headerName)
    {
        this.headerName = headerName;
        return (J) this;
    }

    /**
     * Gets whether the column is sortable
     *
     * @return Whether the column is sortable
     */
    public Boolean getSortable()
    {
        return sortable;
    }

    /**
     * Sets whether the column is sortable
     *
     * @param sortable Whether the column is sortable
     * @return This object
     */
    public J setSortable(Boolean sortable)
    {
        this.sortable = sortable;
        return (J) this;
    }

    /**
     * Gets whether the column is filterable
     *
     * @return Whether the column is filterable
     */
    public Boolean getFilter()
    {
        return filter;
    }

    /**
     * Sets whether the column is filterable
     *
     * @param filter Whether the column is filterable
     * @return This object
     */
    public J setFilter(Boolean filter)
    {
        this.filter = filter;
        return (J) this;
    }

    /**
     * Gets whether the column is resizable
     *
     * @return Whether the column is resizable
     */
    public Boolean getResizable()
    {
        return resizable;
    }

    /**
     * Sets whether the column is resizable
     *
     * @param resizable Whether the column is resizable
     * @return This object
     */
    public J setResizable(Boolean resizable)
    {
        this.resizable = resizable;
        return (J) this;
    }

    /**
     * Gets the width of the column
     *
     * @return The width of the column
     */
    public Integer getWidth()
    {
        return width;
    }

    /**
     * Sets the width of the column
     *
     * @param width The width of the column
     * @return This object
     */
    public J setWidth(Integer width)
    {
        this.width = width;
        return (J) this;
    }

    /**
     * Gets whether the column is pinned
     *
     * @return Whether the column is pinned
     */
    public String getPinned()
    {
        return pinned;
    }

    /**
     * Sets whether the column is pinned
     *
     * @param pinned Whether the column is pinned (e.g., "left", "right")
     * @return This object
     */
    public J setPinned(String pinned)
    {
        this.pinned = pinned;
        return (J) this;
    }

    /**
     * Gets the cell renderer component
     *
     * @return The cell renderer component
     */
    public String getCellRenderer()
    {
        if (cellRenderer == null)
        {
            return null;
        }
        return cellRenderer.toString();
    }

    /**
     * Gets the cell renderer component
     *
     * @return The cell renderer component
     */
    public DefaultCellRenderer<?> getCellRenderer(boolean raw)
    {
        return cellRenderer;
    }

    /**
     * Sets the cell renderer component
     *
     * @param cellRenderer The cell renderer component
     * @return This object
     */
    public J setCellRenderer(DefaultCellRenderer<?> cellRenderer)
    {
        this.cellRenderer = cellRenderer;
        return (J) this;
    }

    /**
     * Gets the cell renderer params
     *
     * @return The cell renderer params
     */
    public Object getCellRendererParams()
    {
        return cellRendererParams;
    }

    /**
     * Sets the cell renderer params
     *
     * @param cellRendererParams The cell renderer params
     * @return This object
     */
    public J setCellRendererParams(Object cellRendererParams)
    {
        this.cellRendererParams = cellRendererParams;
        return (J) this;
    }

    /**
     * Gets the CSS styles for the header
     *
     * @return The CSS styles for the header
     */
    public Object getHeaderStyle()
    {
        return headerStyle;
    }

    /**
     * Sets the CSS styles for the header
     *
     * @param headerStyle The CSS styles for the header
     * @return This object
     */
    public J setHeaderStyle(Object headerStyle)
    {
        this.headerStyle = headerStyle;
        return (J) this;
    }

    /**
     * Gets the CSS classes for the header
     *
     * @return The CSS classes for the header
     */
    public Object getHeaderClass()
    {
        return headerClass;
    }

    /**
     * Sets the CSS classes for the header
     *
     * @param headerClass The CSS classes for the header
     * @return This object
     */
    public J setHeaderClass(Object headerClass)
    {
        this.headerClass = headerClass;
        return (J) this;
    }

    /**
     * Gets the tooltip for the header
     *
     * @return The tooltip for the header
     */
    public String getHeaderTooltip()
    {
        return headerTooltip;
    }

    /**
     * Gets the custom header component
     *
     * @return The custom header component
     */
    public String getHeaderComponent()
    {
        if (headerComponent == null)
        {
            return null;
        }
        return headerComponent.toString();
    }

    /**
     * Gets the custom header component (raw type)
     *
     * @return The custom header component instance
     */
    public DefaultHeaderComponent<?> getHeaderComponent(boolean raw)
    {
        return headerComponent;
    }

    /**
     * Sets the custom header component
     *
     * @param headerComponent The custom header component
     * @return This object
     */
    public J setHeaderComponent(DefaultHeaderComponent<?> headerComponent)
    {
        this.headerComponent = headerComponent;
        return (J) this;
    }

    /**
     * Gets the headerComponentParams
     *
     * @return The headerComponentParams
     */
    public HeaderComponentParams getHeaderComponentParams()
    {
        return headerComponentParams;
    }

    /**
     * Sets the headerComponentParams
     *
     * @param headerComponentParams The params object
     * @return This object
     */
    public J setHeaderComponentParams(HeaderComponentParams headerComponentParams)
    {
        this.headerComponentParams = headerComponentParams;
        return (J) this;
    }

    /**
     * Sets the tooltip for the header
     *
     * @param headerTooltip The tooltip for the header
     * @return This object
     */
    public J setHeaderTooltip(String headerTooltip)
    {
        this.headerTooltip = headerTooltip;
        return (J) this;
    }

    /**
     * Gets whether to automatically adjust header height based on content
     *
     * @return Whether to automatically adjust header height
     */
    public Boolean getAutoHeaderHeight()
    {
        return autoHeaderHeight;
    }

    /**
     * Sets whether to automatically adjust header height based on content
     *
     * @param autoHeaderHeight Whether to automatically adjust header height
     * @return This object
     */
    public J setAutoHeaderHeight(Boolean autoHeaderHeight)
    {
        this.autoHeaderHeight = autoHeaderHeight;
        return (J) this;
    }

    /**
     * Gets whether to wrap header text
     *
     * @return Whether to wrap header text
     */
    public Boolean getWrapHeaderText()
    {
        return wrapHeaderText;
    }

    /**
     * Sets whether to wrap header text
     *
     * @param wrapHeaderText Whether to wrap header text
     * @return This object
     */
    public J setWrapHeaderText(Boolean wrapHeaderText)
    {
        this.wrapHeaderText = wrapHeaderText;
        return (J) this;
    }

    /**
     * Gets the child columns for column groups
     *
     * @return The child columns
     */
    public List<AgGridColumnDef<?>> getChildren()
    {
        return children;
    }

    /**
     * Sets the child columns for column groups
     *
     * @param children The child columns
     * @return This object
     */
    public J setChildren(List<AgGridColumnDef<?>> children)
    {
        this.children = children;
        return (J) this;
    }

    /**
     * Gets when to show the column within a group
     *
     * @return When to show the column ('open', 'closed', or null)
     */
    public String getColumnGroupShow()
    {
        return columnGroupShow;
    }

    /**
     * Sets when to show the column within a group
     *
     * @param columnGroupShow When to show the column ('open', 'closed', or null)
     * @return This object
     */
    public J setColumnGroupShow(String columnGroupShow)
    {
        this.columnGroupShow = columnGroupShow;
        return (J) this;
    }

    /**
     * Gets whether child columns will always move together
     *
     * @return Whether child columns will always move together
     */
    public Boolean getMarryChildren()
    {
        return marryChildren;
    }

    /**
     * Sets whether child columns will always move together
     *
     * @param marryChildren Whether child columns will always move together
     * @return This object
     */
    public J setMarryChildren(Boolean marryChildren)
    {
        this.marryChildren = marryChildren;
        return (J) this;
    }

    /**
     * Gets whether the column group is open by default
     *
     * @return Whether the column group is open by default
     */
    public Boolean getOpenByDefault()
    {
        return openByDefault;
    }

    /**
     * Sets whether the column group is open by default
     *
     * @param openByDefault Whether the column group is open by default
     * @return This object
     */
    public J setOpenByDefault(Boolean openByDefault)
    {
        this.openByDefault = openByDefault;
        return (J) this;
    }

    /**
     * Gets whether the column group header label will not remain visible when scrolling
     *
     * @return Whether the column group header label will not remain visible when scrolling
     */
    public Boolean getSuppressStickyLabel()
    {
        return suppressStickyLabel;
    }

    /**
     * Sets whether the column group header label will not remain visible when scrolling
     *
     * @param suppressStickyLabel Whether the column group header label will not remain visible when scrolling
     * @return This object
     */
    public J setSuppressStickyLabel(Boolean suppressStickyLabel)
    {
        this.suppressStickyLabel = suppressStickyLabel;
        return (J) this;
    }

    /**
     * Gets whether the column will not span the entire header height
     *
     * @return Whether the column will not span the entire header height
     */
    public Boolean getSuppressSpanHeaderHeight()
    {
        return suppressSpanHeaderHeight;
    }

    /**
     * Sets whether the column will not span the entire header height
     *
     * @param suppressSpanHeaderHeight Whether the column will not span the entire header height
     * @return This object
     */
    public J setSuppressSpanHeaderHeight(Boolean suppressSpanHeaderHeight)
    {
        this.suppressSpanHeaderHeight = suppressSpanHeaderHeight;
        return (J) this;
    }

    /**
     * Gets whether the column cannot be moved by dragging
     *
     * @return Whether the column cannot be moved by dragging
     */
    public Boolean getSuppressMovable()
    {
        return suppressMovable;
    }

    /**
     * Sets whether the column cannot be moved by dragging
     *
     * @param suppressMovable Whether the column cannot be moved by dragging
     * @return This object
     */
    public J setSuppressMovable(Boolean suppressMovable)
    {
        this.suppressMovable = suppressMovable;
        return (J) this;
    }

    /**
     * Gets the locked position of the column
     *
     * @return The locked position of the column ("left" or "right")
     */
    public String getLockPosition()
    {
        return lockPosition;
    }

    /**
     * Sets the locked position of the column
     *
     * @param lockPosition The locked position of the column ("left" or "right")
     * @return This object
     */
    public J setLockPosition(String lockPosition)
    {
        this.lockPosition = lockPosition;
        return (J) this;
    }

    /**
     * Gets whether the column's visibility cannot be changed via the UI
     *
     * @return Whether the column's visibility cannot be changed via the UI
     */
    public Boolean getLockVisible()
    {
        return lockVisible;
    }

    /**
     * Sets whether the column's visibility cannot be changed via the UI
     *
     * @param lockVisible Whether the column's visibility cannot be changed via the UI
     * @return This object
     */
    public J setLockVisible(Boolean lockVisible)
    {
        this.lockVisible = lockVisible;
        return (J) this;
    }

    /**
     * Gets whether the column cannot be pinned or unpinned via the UI
     *
     * @return Whether the column cannot be pinned or unpinned via the UI
     */
    public Boolean getLockPinned()
    {
        return lockPinned;
    }

    /**
     * Sets whether the column cannot be pinned or unpinned via the UI
     *
     * @param lockPinned Whether the column cannot be pinned or unpinned via the UI
     * @return This object
     */
    public J setLockPinned(Boolean lockPinned)
    {
        this.lockPinned = lockPinned;
        return (J) this;
    }

    /**
     * Gets the flex value for the column
     *
     * @return The flex value for the column
     */
    public Integer getFlex()
    {
        return flex;
    }

    /**
     * Sets the flex value for the column
     *
     * @param flex The flex value for the column
     * @return This object
     */
    public J setFlex(Integer flex)
    {
        this.flex = flex;
        return (J) this;
    }

    /**
     * Gets the minimum width for the column in pixels
     *
     * @return The minimum width for the column
     */
    public Integer getMinWidth()
    {
        return minWidth;
    }

    /**
     * Sets the minimum width for the column in pixels
     *
     * @param minWidth The minimum width for the column
     * @return This object
     */
    public J setMinWidth(Integer minWidth)
    {
        this.minWidth = minWidth;
        return (J) this;
    }

    /**
     * Gets the maximum width for the column in pixels
     *
     * @return The maximum width for the column
     */
    public Integer getMaxWidth()
    {
        return maxWidth;
    }

    /**
     * Sets the maximum width for the column in pixels
     *
     * @param maxWidth The maximum width for the column
     * @return This object
     */
    public J setMaxWidth(Integer maxWidth)
    {
        this.maxWidth = maxWidth;
        return (J) this;
    }

    /**
     * Gets whether the column will not be included when sizing columns to fit the grid
     *
     * @return Whether the column will not be included when sizing columns to fit the grid
     */
    public Boolean getSuppressSizeToFit()
    {
        return suppressSizeToFit;
    }

    /**
     * Sets whether the column will not be included when sizing columns to fit the grid
     *
     * @param suppressSizeToFit Whether the column will not be included when sizing columns to fit the grid
     * @return This object
     */
    public J setSuppressSizeToFit(Boolean suppressSizeToFit)
    {
        this.suppressSizeToFit = suppressSizeToFit;
        return (J) this;
    }

    /**
     * Gets the column span function or value
     *
     * @return The column span function or value
     */
    public Object getColSpan()
    {
        return colSpan;
    }

    /**
     * Sets the column span function or value
     * This allows cells to span multiple columns
     *
     * @param colSpan The column span function or value
     * @return This object
     */
    public J setColSpan(Object colSpan)
    {
        this.colSpan = colSpan;
        return (J) this;
    }
}
