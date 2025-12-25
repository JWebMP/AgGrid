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
public class ScrollState<T extends ScrollState<T>> implements INgDataType<T> {
    @JsonProperty("top")
    public Integer top;
    @JsonProperty("left")
    public Integer left;

    public Integer getTop() {
        return top;
    }

    @SuppressWarnings("unchecked")
    public T setTop(Integer top) {
        this.top = top;
        return (T) this;
    }

    public Integer getLeft() {
        return left;
    }

    @SuppressWarnings("unchecked")
    public T setLeft(Integer left) {
        this.left = left;
        return (T) this;
    }
}
