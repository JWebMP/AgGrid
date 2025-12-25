package com.jwebmp.plugins.aggrid.options.state;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jwebmp.core.base.angular.client.annotations.angular.NgDataType;
import com.jwebmp.core.base.angular.client.services.interfaces.INgDataType;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NgDataType
public class PivotState<T extends PivotState<T>> implements INgDataType<T> {
    @JsonProperty("pivotMode")
    public Boolean pivotMode;
    @JsonProperty("pivotColumnState")
    public List<ColumnState<?>> pivotColumnState;

    public Boolean getPivotMode() {
        return pivotMode;
    }

    @SuppressWarnings("unchecked")
    public T setPivotMode(Boolean pivotMode) {
        this.pivotMode = pivotMode;
        return (T) this;
    }

    public List<ColumnState<?>> getPivotColumnState() {
        return pivotColumnState;
    }

    @SuppressWarnings("unchecked")
    public T setPivotColumnState(List<ColumnState<?>> pivotColumnState) {
        this.pivotColumnState = pivotColumnState;
        return (T) this;
    }
}
