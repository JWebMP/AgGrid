package com.jwebmp.plugins.aggrid.options.filters;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Marker interface for column filter parameters (community/enterprise) following CRTP.
 * Concrete filter params (e.g., Set Filter params) should extend this in their respective modules.
 */
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY, getterVisibility = JsonAutoDetect.Visibility.NONE, setterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface IFilterParams<J extends IFilterParams<J>> {
}
