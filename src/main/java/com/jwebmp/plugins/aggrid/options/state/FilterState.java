package com.jwebmp.plugins.aggrid.options.state;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jwebmp.core.base.angular.client.annotations.angular.NgDataType;
import com.jwebmp.core.base.angular.client.services.interfaces.INgDataType;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;

import java.util.Map;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NgDataType
public class FilterState<T extends FilterState<T>> implements INgDataType<T> {
    @JsonProperty("filterModel")
    public Map<String, Object> filterModel;

    public Map<String, Object> getFilterModel() {
        return filterModel;
    }

    @SuppressWarnings("unchecked")
    public T setFilterModel(Map<String, Object> filterModel) {
        this.filterModel = filterModel;
        return (T) this;
    }
}
