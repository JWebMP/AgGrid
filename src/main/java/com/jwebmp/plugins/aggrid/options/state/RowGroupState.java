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
public class RowGroupState<T extends RowGroupState<T>> implements INgDataType<T> {
    @JsonProperty("groupColumnState")
    public List<ColumnState<?>> groupColumnState;
    @JsonProperty("expanded")
    public List<String> expanded;

    public List<ColumnState<?>> getGroupColumnState() {
        return groupColumnState;
    }

    @SuppressWarnings("unchecked")
    public T setGroupColumnState(List<ColumnState<?>> groupColumnState) {
        this.groupColumnState = groupColumnState;
        return (T) this;
    }

    public List<String> getExpanded() {
        return expanded;
    }

    @SuppressWarnings("unchecked")
    public T setExpanded(List<String> expanded) {
        this.expanded = expanded;
        return (T) this;
    }
}
