package com.jwebmp.plugins.aggrid.options.state;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jwebmp.core.base.angular.client.annotations.angular.NgDataType;
import com.jwebmp.core.base.angular.client.services.interfaces.INgDataType;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import org.jspecify.annotations.Nullable;

/**
 * Represents the state of a column in AG Grid.
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NgDataType
public class ColumnState<J extends ColumnState<J>> implements INgDataType<J>
{
    @JsonProperty("colId")
    public String colId;

    @JsonProperty("width")
    public @Nullable Integer width;

    @JsonProperty("flex")
    public @Nullable Integer flex;

    @JsonProperty("hide")
    public @Nullable Boolean hide;

    @JsonProperty("pinned")
    public @Nullable String pinned;

    @JsonProperty("sort")
    public @Nullable String sort;

    @JsonProperty("sortIndex")
    public @Nullable Integer sortIndex;

    @JsonProperty("rowGroup")
    public @Nullable Boolean rowGroup;

    @JsonProperty("rowGroupIndex")
    public @Nullable Integer rowGroupIndex;

    @JsonProperty("pivot")
    public @Nullable Boolean pivot;

    @JsonProperty("pivotIndex")
    public @Nullable Integer pivotIndex;

    @JsonProperty("aggFunc")
    public @Nullable String aggFunc;

    public String getColId() { return colId; }
    @SuppressWarnings("unchecked")
    public J setColId(String colId) { this.colId = colId; return (J) this; }

    public @Nullable Integer getWidth() { return width; }
    @SuppressWarnings("unchecked")
    public J setWidth(@Nullable Integer width) { this.width = width; return (J) this; }

    public @Nullable Integer getFlex() { return flex; }
    @SuppressWarnings("unchecked")
    public J setFlex(@Nullable Integer flex) { this.flex = flex; return (J) this; }

    public @Nullable Boolean getHide() { return hide; }
    @SuppressWarnings("unchecked")
    public J setHide(@Nullable Boolean hide) { this.hide = hide; return (J) this; }

    public @Nullable String getPinned() { return pinned; }
    @SuppressWarnings("unchecked")
    public J setPinned(@Nullable String pinned) { this.pinned = pinned; return (J) this; }

    public @Nullable String getSort() { return sort; }
    @SuppressWarnings("unchecked")
    public J setSort(@Nullable String sort) { this.sort = sort; return (J) this; }

    public @Nullable Integer getSortIndex() { return sortIndex; }
    @SuppressWarnings("unchecked")
    public J setSortIndex(@Nullable Integer sortIndex) { this.sortIndex = sortIndex; return (J) this; }

    public @Nullable Boolean getRowGroup() { return rowGroup; }
    @SuppressWarnings("unchecked")
    public J setRowGroup(@Nullable Boolean rowGroup) { this.rowGroup = rowGroup; return (J) this; }

    public @Nullable Integer getRowGroupIndex() { return rowGroupIndex; }
    @SuppressWarnings("unchecked")
    public J setRowGroupIndex(@Nullable Integer rowGroupIndex) { this.rowGroupIndex = rowGroupIndex; return (J) this; }

    public @Nullable Boolean getPivot() { return pivot; }
    @SuppressWarnings("unchecked")
    public J setPivot(@Nullable Boolean pivot) { this.pivot = pivot; return (J) this; }

    public @Nullable Integer getPivotIndex() { return pivotIndex; }
    @SuppressWarnings("unchecked")
    public J setPivotIndex(@Nullable Integer pivotIndex) { this.pivotIndex = pivotIndex; return (J) this; }

    public @Nullable String getAggFunc() { return aggFunc; }
    @SuppressWarnings("unchecked")
    public J setAggFunc(@Nullable String aggFunc) { this.aggFunc = aggFunc; return (J) this; }
}
