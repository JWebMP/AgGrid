package com.jwebmp.plugins.aggrid.options.state;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jwebmp.core.base.angular.client.annotations.angular.NgDataType;
import com.jwebmp.core.base.angular.client.services.interfaces.INgDataType;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import java.util.List;
import java.util.Map;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NgDataType
public class ColumnGroupState<T extends ColumnGroupState<T>> implements INgDataType<T> {
    @JsonProperty("columnState")
    public List<ColumnState<?>> columnState;
    @JsonProperty("columnGroupState")
    public List<Map<String, Object>> columnGroupState;
    @JsonProperty("columnOrder")
    public List<String> columnOrder;

    public List<ColumnState<?>> getColumnState() {
        return columnState;
    }

    @SuppressWarnings("unchecked")
    public T setColumnState(List<ColumnState<?>> columnState) {
        this.columnState = columnState;
        return (T) this;
    }

    public List<Map<String, Object>> getColumnGroupState() {
        return columnGroupState;
    }

    @SuppressWarnings("unchecked")
    public T setColumnGroupState(List<Map<String, Object>> columnGroupState) {
        this.columnGroupState = columnGroupState;
        return (T) this;
    }

    public List<String> getColumnOrder() {
        return columnOrder;
    }

    @SuppressWarnings("unchecked")
    public T setColumnOrder(List<String> columnOrder) {
        this.columnOrder = columnOrder;
        return (T) this;
    }
}
