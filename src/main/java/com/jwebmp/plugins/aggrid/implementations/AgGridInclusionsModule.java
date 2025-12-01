package com.jwebmp.plugins.aggrid.implementations;

import com.guicedee.client.services.config.IGuiceScanModuleInclusions;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

/**
 * Module inclusions for AG Grid
 */
public class AgGridInclusionsModule
        implements IGuiceScanModuleInclusions<AgGridInclusionsModule>
{
    @Override
    public @NotNull Set<String> includeModules()
    {
        Set<String> strings = new HashSet<>();
        strings.add("com.jwebmp.plugins.aggrid");
        return strings;
    }
}