package com.jwebmp.plugins.aggrid.headers;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.annotations.structures.NgField;
import com.jwebmp.core.base.angular.client.annotations.structures.NgInterface;
import com.jwebmp.core.base.angular.client.annotations.structures.NgMethod;
import com.jwebmp.core.base.angular.client.services.interfaces.AnnotationUtils;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.plugins.ComponentInformation;

/**
 * Base custom header component for AG Grid headers. Implements IHeaderAngularComp contract.
 * Use this to fully replace the header content when needed.
 */
@ComponentInformation(name = "Default Header Component",
        description = "A default custom header component for AG Grid that can be extended to fully control header rendering.",
        url = "https://www.ag-grid.com/angular-data-grid/column-headers/",
        wikiUrl = "https://github.com/JWebMP/JWebMP-AgGrid/wiki")

// Angular references
@NgImportReference(value = "IHeaderAngularComp", reference = "ag-grid-angular")
@NgImportReference(value = "IHeaderParams", reference = "ag-grid-community")

@NgField("displayName: string = '';")
@NgField("params?: IHeaderParams")

@NgInterface("IHeaderAngularComp")

@NgMethod("""
        agInit(params: IHeaderParams): void {
            this.displayName = params.displayName;
            this.params = params;
        }
        """)

@NgMethod("""
        refresh(params: IHeaderParams): boolean {
            this.displayName = params.displayName;
            this.params = params;
            return true;
        }
        """)
public class DefaultHeaderComponent<J extends DefaultHeaderComponent<J>> extends DivSimple<J> implements INgComponent<J>
{
    public DefaultHeaderComponent()
    {
        setTag("div");
    }

    @Override
    protected void init()
    {
        if (!isInitialized())
        {
            
        }
        super.init();
    }

    @Override
    public Boolean standaloneOverride()
    {
        return true;
    }

    @JsonRawValue
    @JsonValue
    public String jsonRenderValue()
    {
        return AnnotationUtils.getTsFilename(getClass());
    }
}
