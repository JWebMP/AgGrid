package com.jwebmp.plugins.aggrid.options;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import org.jspecify.annotations.Nullable;

/**
 * AG Grid server-side row model options.
 * Configures server-side data loading, caching, transactions, and callbacks.
 * NEW in AG Grid v34.2.0 - Community Edition support.
 *
 * @author DevSuite
 * @since 2025
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerSideRowModelOptions<J extends ServerSideRowModelOptions<J>>
{
    /**
     * DataSource callback for fetching rows from server.
     * Signature: (params: IServerSideGetRowsParams) => void
     */
    @JsonProperty("serverSideDatasource")
    @JsonRawValue
    private @Nullable String serverSideDatasource;

    /**
     * Number of rows to load in each block (default 100).
     */
    @JsonProperty("cacheBlockSize")
    private @Nullable Integer cacheBlockSize;

    /**
     * Maximum number of blocks to keep in cache (default 2).
     */
    @JsonProperty("maxBlocksInCache")
    private @Nullable Integer maxBlocksInCache;

    /**
     * Maximum concurrent datasource requests (default 2).
     */
    @JsonProperty("maxConcurrentDatasourceRequests")
    private @Nullable Integer maxConcurrentDatasourceRequests;

    /**
     * Debounce time in milliseconds for block loading (default 0).
     */
    @JsonProperty("blockLoadDebounceMillis")
    private @Nullable Integer blockLoadDebounceMillis;

    /**
     * Suppress server-side full width loading row display.
     */
    @JsonProperty("suppressServerSideFullWidthLoadingRow")
    private @Nullable Boolean suppressServerSideFullWidthLoadingRow;

    /**
     * Remove closed row node data from memory (default false).
     */
    @JsonProperty("purgeClosedRowNodes")
    private @Nullable Boolean purgeClosedRowNodes;

    /**
     * Separator used for pivot result field names (default '_').
     */
    @JsonProperty("serverSidePivotResultFieldSeparator")
    private @Nullable String serverSidePivotResultFieldSeparator;

    /**
     * Sort all levels on server side (default false).
     */
    @JsonProperty("serverSideSortAllLevels")
    private @Nullable Boolean serverSideSortAllLevels;

    /**
     * Enable client-side sorting when using server-side model.
     */
    @JsonProperty("serverSideEnableClientSideSort")
    private @Nullable Boolean serverSideEnableClientSideSort;

    /**
     * Only refresh filtered groups (default false).
     */
    @JsonProperty("serverSideOnlyRefreshFilteredGroups")
    private @Nullable Boolean serverSideOnlyRefreshFilteredGroups;

    /**
     * Initial number of rows to request from server (default 1).
     */
    @JsonProperty("serverSideInitialRowCount")
    private @Nullable Integer serverSideInitialRowCount;

    /**
     * Callback to get child count for rows.
     * Signature: (params: IServerSideGetChildCountParams) => number
     */
    @JsonProperty("getChildCount")
    @JsonRawValue
    private @Nullable String getChildCount;

    /**
     * Callback to get group level parameters.
     * Signature: (params: IServerSideGetGroupLevelParamsParams) => ServerSideGroupLevelParams
     */
    @JsonProperty("getServerSideGroupLevelParams")
    @JsonRawValue
    private @Nullable String getServerSideGroupLevelParams;

    /**
     * Callback to determine if group is open by default.
     * Signature: (params: IsServerSideGroupOpenByDefaultParams) => boolean
     */
    @JsonProperty("isServerSideGroupOpenByDefault")
    @JsonRawValue
    private @Nullable String isServerSideGroupOpenByDefault;

    /**
     * Callback to determine if server-side transaction should be applied.
     * Signature: (params: IsApplyServerSideTransactionParams) => boolean
     */
    @JsonProperty("isApplyServerSideTransaction")
    @JsonRawValue
    private @Nullable String isApplyServerSideTransaction;

    /**
     * Callback to determine if row is a server-side group.
     * Signature: (data: any) => boolean
     */
    @JsonProperty("isServerSideGroup")
    @JsonRawValue
    private @Nullable String isServerSideGroup;

    /**
     * Callback to get server-side group key.
     * Signature: (data: any) => string
     */
    @JsonProperty("getServerSideGroupKey")
    @JsonRawValue
    private @Nullable String getServerSideGroupKey;

    // Getters

    public @Nullable String getServerSideDatasource()
    {
        return serverSideDatasource;
    }

    public @Nullable Integer getCacheBlockSize()
    {
        return cacheBlockSize;
    }

    public @Nullable Integer getMaxBlocksInCache()
    {
        return maxBlocksInCache;
    }

    public @Nullable Integer getMaxConcurrentDatasourceRequests()
    {
        return maxConcurrentDatasourceRequests;
    }

    public @Nullable Integer getBlockLoadDebounceMillis()
    {
        return blockLoadDebounceMillis;
    }

    public @Nullable Boolean getSuppressServerSideFullWidthLoadingRow()
    {
        return suppressServerSideFullWidthLoadingRow;
    }

    public @Nullable Boolean getPurgeClosedRowNodes()
    {
        return purgeClosedRowNodes;
    }

    public @Nullable String getServerSidePivotResultFieldSeparator()
    {
        return serverSidePivotResultFieldSeparator;
    }

    public @Nullable Boolean getServerSideSortAllLevels()
    {
        return serverSideSortAllLevels;
    }

    public @Nullable Boolean getServerSideEnableClientSideSort()
    {
        return serverSideEnableClientSideSort;
    }

    public @Nullable Boolean getServerSideOnlyRefreshFilteredGroups()
    {
        return serverSideOnlyRefreshFilteredGroups;
    }

    public @Nullable Integer getServerSideInitialRowCount()
    {
        return serverSideInitialRowCount;
    }

    public @Nullable String getGetChildCount()
    {
        return getChildCount;
    }

    public @Nullable String getGetServerSideGroupLevelParams()
    {
        return getServerSideGroupLevelParams;
    }

    public @Nullable String getIsServerSideGroupOpenByDefault()
    {
        return isServerSideGroupOpenByDefault;
    }

    public @Nullable String getIsApplyServerSideTransaction()
    {
        return isApplyServerSideTransaction;
    }

    public @Nullable String getIsServerSideGroup()
    {
        return isServerSideGroup;
    }

    public @Nullable String getGetServerSideGroupKey()
    {
        return getServerSideGroupKey;
    }

    // Setters with CRTP return type

    @SuppressWarnings("unchecked")
    public J setServerSideDatasource(@Nullable String serverSideDatasource)
    {
        this.serverSideDatasource = serverSideDatasource;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setCacheBlockSize(@Nullable Integer cacheBlockSize)
    {
        this.cacheBlockSize = cacheBlockSize;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setMaxBlocksInCache(@Nullable Integer maxBlocksInCache)
    {
        this.maxBlocksInCache = maxBlocksInCache;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setMaxConcurrentDatasourceRequests(@Nullable Integer maxConcurrentDatasourceRequests)
    {
        this.maxConcurrentDatasourceRequests = maxConcurrentDatasourceRequests;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setBlockLoadDebounceMillis(@Nullable Integer blockLoadDebounceMillis)
    {
        this.blockLoadDebounceMillis = blockLoadDebounceMillis;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setSuppressServerSideFullWidthLoadingRow(@Nullable Boolean suppressServerSideFullWidthLoadingRow)
    {
        this.suppressServerSideFullWidthLoadingRow = suppressServerSideFullWidthLoadingRow;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setPurgeClosedRowNodes(@Nullable Boolean purgeClosedRowNodes)
    {
        this.purgeClosedRowNodes = purgeClosedRowNodes;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setServerSidePivotResultFieldSeparator(@Nullable String serverSidePivotResultFieldSeparator)
    {
        this.serverSidePivotResultFieldSeparator = serverSidePivotResultFieldSeparator;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setServerSideSortAllLevels(@Nullable Boolean serverSideSortAllLevels)
    {
        this.serverSideSortAllLevels = serverSideSortAllLevels;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setServerSideEnableClientSideSort(@Nullable Boolean serverSideEnableClientSideSort)
    {
        this.serverSideEnableClientSideSort = serverSideEnableClientSideSort;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setServerSideOnlyRefreshFilteredGroups(@Nullable Boolean serverSideOnlyRefreshFilteredGroups)
    {
        this.serverSideOnlyRefreshFilteredGroups = serverSideOnlyRefreshFilteredGroups;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setServerSideInitialRowCount(@Nullable Integer serverSideInitialRowCount)
    {
        this.serverSideInitialRowCount = serverSideInitialRowCount;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setGetChildCount(@Nullable String getChildCount)
    {
        this.getChildCount = getChildCount;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setGetServerSideGroupLevelParams(@Nullable String getServerSideGroupLevelParams)
    {
        this.getServerSideGroupLevelParams = getServerSideGroupLevelParams;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setIsServerSideGroupOpenByDefault(@Nullable String isServerSideGroupOpenByDefault)
    {
        this.isServerSideGroupOpenByDefault = isServerSideGroupOpenByDefault;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setIsApplyServerSideTransaction(@Nullable String isApplyServerSideTransaction)
    {
        this.isApplyServerSideTransaction = isApplyServerSideTransaction;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setIsServerSideGroup(@Nullable String isServerSideGroup)
    {
        this.isServerSideGroup = isServerSideGroup;
        return (J) this;
    }

    @SuppressWarnings("unchecked")
    public J setGetServerSideGroupKey(@Nullable String getServerSideGroupKey)
    {
        this.getServerSideGroupKey = getServerSideGroupKey;
        return (J) this;
    }
}
