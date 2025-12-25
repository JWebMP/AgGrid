package com.jwebmp.plugins.aggrid.options.state;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jwebmp.core.base.angular.client.annotations.angular.NgDataType;
import com.jwebmp.core.base.angular.client.services.interfaces.INgDataType;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NgDataType
public class FocusedCellState<T extends FocusedCellState<T>> implements INgDataType<T> {
    @JsonProperty("colId")
    public String colId;
    @JsonProperty("rowIndex")
    public Integer rowIndex;
    @JsonProperty("rowPinned")
    public String rowPinned;

    public String getColId() {
        return colId;
    }

    @SuppressWarnings("unchecked")
    public T setColId(String colId) {
        this.colId = colId;
        return (T) this;
    }

    public Integer getRowIndex() {
        return rowIndex;
    }

    @SuppressWarnings("unchecked")
    public T setRowIndex(Integer rowIndex) {
        this.rowIndex = rowIndex;
        return (T) this;
    }

    public String getRowPinned() {
        return rowPinned;
    }

    @SuppressWarnings("unchecked")
    public T setRowPinned(String rowPinned) {
        this.rowPinned = rowPinned;
        return (T) this;
    }
}
