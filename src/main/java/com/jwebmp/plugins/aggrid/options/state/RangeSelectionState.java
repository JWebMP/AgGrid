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
public class RangeSelectionState<T extends RangeSelectionState<T>> implements INgDataType<T> {
    @JsonProperty("cellRanges")
    public List<Map<String, Object>> cellRanges;

    public List<Map<String, Object>> getCellRanges() {
        return cellRanges;
    }

    @SuppressWarnings("unchecked")
    public T setCellRanges(List<Map<String, Object>> cellRanges) {
        this.cellRanges = cellRanges;
        return (T) this;
    }
}
