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
 * Base inner header component for AG Grid headers that can be extended by users.
 * Implements the IInnerHeaderAngularComp contract on the Angular side.
 */
@ComponentInformation(name = "Default Inner Header Component",
        description = "A default inner header component for AG Grid that can be extended to customize header label rendering.",
        url = "https://www.ag-grid.com/angular-data-grid/column-headers/",
        wikiUrl = "https://github.com/JWebMP/JWebMP-AgGrid/wiki")

// Import references used by Angular
@NgImportReference(value = "IInnerHeaderAngularComp", reference = "ag-grid-angular")
@NgImportReference(value = "IHeaderParams", reference = "ag-grid-community")

// Simple field to hold display name
@NgField("displayName: string = '';")
@NgField("params?: IHeaderParams")

// Declare Angular interface
@NgInterface("IInnerHeaderAngularComp")

// agInit for the inner header component
@NgMethod("""
        agInit(params: IHeaderParams): void {
            this.displayName = params.displayName;
            this.params = params;
        }
        """)

// refresh for the inner header component
@NgMethod("""
        refresh(params: IHeaderParams): boolean {
            this.displayName = params.displayName;
            this.params = params;
            return true;
        }
        """)
public class DefaultInnerHeaderComponent<J extends DefaultInnerHeaderComponent<J>> extends DivSimple<J> implements INgComponent<J>
{
    public DefaultInnerHeaderComponent()
    {
        setTag("span");
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
