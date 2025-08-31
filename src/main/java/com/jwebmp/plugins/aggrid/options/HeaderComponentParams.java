package com.jwebmp.plugins.aggrid.options;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jwebmp.plugins.aggrid.headers.DefaultInnerHeaderComponent;

/**
 * Represents headerComponentParams for AG Grid headers, allowing template overrides and inner header components.
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HeaderComponentParams
{
    /**
     * Custom HTML template for the Provided Header Component. Should re-use the same data-ref attributes.
     */
    @JsonProperty("template")
    private String template;

    /**
     * A custom inner header component to render the header text area, retaining grid-managed functionality.
     */
    @JsonProperty("innerHeaderComponent")
    private DefaultInnerHeaderComponent<?> innerHeaderComponent;

    /**
     * Additional parameters passed to the innerHeaderComponent.
     */
    @JsonProperty("innerHeaderComponentParams")
    private Object innerHeaderComponentParams;

    public String getTemplate()
    {
        return template;
    }

    public HeaderComponentParams setTemplate(String template)
    {
        this.template = template;
        return this;
    }

    public DefaultInnerHeaderComponent<?> getInnerHeaderComponent()
    {
        return innerHeaderComponent;
    }

    public HeaderComponentParams setInnerHeaderComponent(DefaultInnerHeaderComponent<?> innerHeaderComponent)
    {
        this.innerHeaderComponent = innerHeaderComponent;
        return this;
    }

    public Object getInnerHeaderComponentParams()
    {
        return innerHeaderComponentParams;
    }

    public HeaderComponentParams setInnerHeaderComponentParams(Object innerHeaderComponentParams)
    {
        this.innerHeaderComponentParams = innerHeaderComponentParams;
        return this;
    }
}
