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
public class SideBarState<T extends SideBarState<T>> implements INgDataType<T> {
    @JsonProperty("visible")
    public Boolean visible;
    @JsonProperty("openToolPanel")
    public String openToolPanel;

    public Boolean getVisible() {
        return visible;
    }

    @SuppressWarnings("unchecked")
    public T setVisible(Boolean visible) {
        this.visible = visible;
        return (T) this;
    }

    public String getOpenToolPanel() {
        return openToolPanel;
    }

    @SuppressWarnings("unchecked")
    public T setOpenToolPanel(String openToolPanel) {
        this.openToolPanel = openToolPanel;
        return (T) this;
    }
}
