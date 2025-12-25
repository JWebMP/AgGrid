package com.jwebmp.plugins.aggrid.options;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

/**
 * Tree Data options for AG Grid.
 * Tree Data allows you to display data that has parent / child relationships where the relationships are
 * expressed as part of the data.
 *
 * @param <J> The type of the class extending these options
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TreeDataOptions<J extends TreeDataOptions<J>> extends JavaScriptPart<J>
{
    /**
     * Set to true to enable Tree Data.
     */
    @JsonProperty("treeData")
    private @Nullable Boolean treeData;

    /**
     * Callback used when Tree Data is enabled to determine the path of a row.
     * Example: "(data) => data.path"
     */
    @JsonProperty("getDataPath")
    @com.fasterxml.jackson.annotation.JsonRawValue
    private @Nullable String getDataPath;

    /**
     * Set the getDataPath callback using a raw JavaScript function or arrow function.
     * Example: "(data) => data.path"
     */
    public @NonNull J setGetDataPathRaw(String getDataPathRawJs)
    {
        this.getDataPath = getDataPathRawJs;
        return (J) this;
    }

    /**
     * Field name containing an array of children nodes when using treeData=true.
     */
    @JsonProperty("treeDataChildrenField")
    private @Nullable String treeDataChildrenField;

    /**
     * Field name to find the parent node when using treeData=true (requires getRowId).
     */
    @JsonProperty("treeDataParentIdField")
    private @Nullable String treeDataParentIdField;

    /**
     * Set to true to exclude children from being filtered when their parent matches the filter.
     */
    @JsonProperty("excludeChildrenWhenTreeDataFiltering")
    private @Nullable Boolean excludeChildrenWhenTreeDataFiltering;

    public @Nullable Boolean getTreeData()
    {
        return treeData;
    }

    public @NonNull J setTreeData(@Nullable Boolean treeData)
    {
        this.treeData = treeData;
        return (J) this;
    }

    public @Nullable String getGetDataPath()
    {
        return getDataPath;
    }

    public @NonNull J setGetDataPath(@Nullable String getDataPath)
    {
        this.getDataPath = getDataPath;
        return (J) this;
    }

    public @Nullable String getTreeDataChildrenField()
    {
        return treeDataChildrenField;
    }

    public @NonNull J setTreeDataChildrenField(@Nullable String treeDataChildrenField)
    {
        this.treeDataChildrenField = treeDataChildrenField;
        return (J) this;
    }

    public @Nullable String getTreeDataParentIdField()
    {
        return treeDataParentIdField;
    }

    public @NonNull J setTreeDataParentIdField(@Nullable String treeDataParentIdField)
    {
        this.treeDataParentIdField = treeDataParentIdField;
        return (J) this;
    }

    public @Nullable Boolean getExcludeChildrenWhenTreeDataFiltering()
    {
        return excludeChildrenWhenTreeDataFiltering;
    }

    public @NonNull J setExcludeChildrenWhenTreeDataFiltering(@Nullable Boolean excludeChildrenWhenTreeDataFiltering)
    {
        this.excludeChildrenWhenTreeDataFiltering = excludeChildrenWhenTreeDataFiltering;
        return (J) this;
    }
}
