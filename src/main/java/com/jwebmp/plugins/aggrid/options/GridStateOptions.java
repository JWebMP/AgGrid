package com.jwebmp.plugins.aggrid.options;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jwebmp.core.base.angular.client.annotations.angular.NgDataType;
import com.jwebmp.core.base.angular.client.services.interfaces.INgDataType;
import com.jwebmp.core.htmlbuilder.javascript.JavaScriptPart;
import com.jwebmp.plugins.aggrid.options.state.GridState;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.io.Serializable;

/**
 * AG Grid State Options.
 * Configures the initial state of the grid, including filters, column state, etc.
 *
 * @author DevSuite
 * @since 2025
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@NgDataType
public class GridStateOptions<J extends GridStateOptions<J>> implements Serializable, INgDataType<J>
{
    /**
     * Initial grid state, read once during initialisation.
     */
    @JsonProperty("initialState")
    private @Nullable GridState<?> initialState;

    public @NonNull GridState<?> getInitialState()
    {
        if (initialState == null)
        {
            initialState = new GridState<>();
        }
        return initialState;
    }

    @SuppressWarnings("unchecked")
    public J setInitialState(@Nullable GridState<?> initialState)
    {
        this.initialState = initialState;
        return (J) this;
    }
}
