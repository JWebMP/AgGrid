package com.jwebmp.plugins.aggrid.options.locale;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * CRTP-enabled Locale Text contract for AG Grid localisation.
 * This minimal interface exposes keys needed for Set Filter Mini Filter text customisation.
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface ILocaleText<J extends ILocaleText<J>> {

    /** Placeholder text for the Mini Filter input (default: "Search..."). */
    String getSearchOoo();
    J setSearchOoo(String searchOoo);

    /** Message shown when no matches are found in the Mini Filter. */
    String getNoMatches();
    J setNoMatches(String noMatches);
}
