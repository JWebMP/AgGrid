package com.jwebmp.plugins.aggrid.options.locale;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Minimal implementation of AG Grid localeText for Mini Filter customisation.
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class LocaleText implements ILocaleText<LocaleText> {

    @JsonProperty("searchOoo")
    private String searchOoo;

    @JsonProperty("noMatches")
    private String noMatches;

    @Override
    public String getSearchOoo() {
        return searchOoo;
    }

    @Override
    public LocaleText setSearchOoo(String searchOoo) {
        this.searchOoo = searchOoo;
        return this;
    }

    @Override
    public String getNoMatches() {
        return noMatches;
    }

    @Override
    public LocaleText setNoMatches(String noMatches) {
        this.noMatches = noMatches;
        return this;
    }
}
