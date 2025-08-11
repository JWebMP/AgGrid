package com.jwebmp.plugins.aggrid;

import com.jwebmp.core.base.angular.client.annotations.angularconfig.NgScript;
import com.jwebmp.core.base.angular.client.annotations.angularconfig.NgStyleSheet;
import com.jwebmp.core.base.angular.client.annotations.boot.NgBootConstructorBody;
import com.jwebmp.core.base.angular.client.annotations.boot.NgBootImportReference;
import com.jwebmp.core.base.angular.client.annotations.typescript.TsDependency;
import com.jwebmp.core.plugins.PluginInformation;
import com.jwebmp.core.plugins.PluginStatus;
import com.jwebmp.core.services.IPage;
import com.jwebmp.core.services.IPageConfigurator;
import jakarta.validation.constraints.NotNull;

/**
 * The AG Grid Page Configurator
 *
 * @author GedMarc
 * @since 2026
 */
@PluginInformation(pluginName = "AG Grid",
        pluginDescription = "AG Grid is a feature-rich data grid supporting multiple frameworks",
        pluginUniqueName = "ag-grid",
        pluginVersion = "33.0.0",
        pluginCategories = "grid, table, data, ui, web ui, framework",
        pluginSubtitle = "AG Grid is a feature-rich data grid supporting multiple frameworks",
        pluginSourceUrl = "https://www.ag-grid.com/",
        pluginWikiUrl = "https://github.com/JWebMP/JWebMP-AgGrid/wiki",
        pluginGitUrl = "https://github.com/JWebMP/JWebMP-AgGrid",
        pluginIconUrl = "",
        pluginIconImageUrl = "",
        pluginOriginalHomepage = "https://www.ag-grid.com/",
        pluginDownloadUrl = "https://mvnrepository.com/artifact/com.jwebmp.plugins/ag-grid",
        pluginGroupId = "com.jwebmp.plugins",
        pluginArtifactId = "ag-grid",
        pluginModuleName = "com.jwebmp.plugins.aggrid",
        pluginLastUpdatedDate = "2023-01-01",
        pluginStatus = PluginStatus.Released
)

@TsDependency(value = "ag-grid-community", version = "^33.0.0")
@TsDependency(value = "ag-grid-angular", version = "^33.0.0")


/*@NgScript(name = "AG Grid", value = "node_modules/ag-grid-community/dist/ag-grid-community.min.js")*/
//@NgStyleSheet(name = "AG Grid", value = "node_modules/ag-grid-community/styles/ag-grid.css")
//@NgStyleSheet(name = "AG Grid Theme", value = "node_modules/ag-grid-community/dist/styles/ag-theme-alpine.css")

@NgBootImportReference(value = "AllCommunityModule", reference = "ag-grid-community")
@NgBootImportReference(value = "ModuleRegistry", reference = "ag-grid-community")
@NgBootConstructorBody("ModuleRegistry.registerModules([AllCommunityModule]);")

public class AgGridPageConfigurator
        implements IPageConfigurator<AgGridPageConfigurator>, com.jwebmp.core.base.angular.client.services.TypescriptIndexPageConfigurator<AgGridPageConfigurator>
{
    /**
     * If this configurator is enabled
     */
    private static boolean enabled = true;

    /**
     * Constructs a new AgGridPageConfigurator
     */
    public AgGridPageConfigurator()
    {
        //Nothing needed
    }

    /**
     * Method isEnabled returns the enabled of this AgGridPageConfigurator object.
     * <p>
     * If this configurator is enabled
     *
     * @return the enabled (type boolean) of this AgGridPageConfigurator object.
     */
    public static boolean isEnabled()
    {
        return AgGridPageConfigurator.enabled;
    }

    /**
     * Method setEnabled sets the enabled of this AgGridPageConfigurator object.
     * <p>
     * If this configurator is enabled
     *
     * @param mustEnable the enabled of this AgGridPageConfigurator object.
     */
    public static void setEnabled(boolean mustEnable)
    {
        AgGridPageConfigurator.enabled = mustEnable;
    }

    @NotNull
    @Override
    public IPage<?> configure(IPage<?> page)
    {
        // Angular will handle the resource loading

        return page;
    }

    @Override
    public boolean enabled()
    {
        return AgGridPageConfigurator.enabled;
    }
}
