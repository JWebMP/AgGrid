package com.jwebmp.plugins.aggrid.cellrenderers;

import com.jwebmp.core.base.angular.client.annotations.references.NgImportModule;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.annotations.structures.NgField;
import com.jwebmp.core.base.angular.client.annotations.structures.NgMethod;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.plugins.ComponentInformation;

/**
 * A full width cell renderer for AG Grid that spans the entire width of the grid
 *
 * @author Junie
 * @version 1.0.0
 * @since 2025-08-09
 */
@ComponentInformation(name = "Full Width Cell Renderer",
        description = "A cell renderer for AG Grid that spans the entire width of the grid",
        url = "https://www.ag-grid.com/angular-data-grid/full-width-rows/",
        wikiUrl = "https://github.com/JWebMP/JWebMP-AgGrid/wiki")

// Import references
@NgImportReference(value = "ICellRendererAngularComp", reference = "ag-grid-angular")
@NgImportReference(value = "ICellRendererParams", reference = "ag-grid-community")
@NgImportModule("CommonModule")

// Fields for the full width cell renderer
@NgField("data: any = null;")
@NgField("rowId: string = '';")
@NgField("pinned: string | null = null;")

// Method to initialize the full width cell renderer
@NgMethod("""
            agInit(params: ICellRendererParams): void {
                this.data = params.data;
                this.rowId = params.node.id;
                this.pinned = params.pinned;
            }
        """)

// Method to refresh the full width cell renderer
@NgMethod("""
            refresh(params: ICellRendererParams): boolean {
                this.data = params.data;
                return true;
            }
        """)

public class FullWidthCellRenderer<J extends FullWidthCellRenderer<J>> extends DivSimple<J> implements INgComponent<J>
{
    /**
     * Constructor for the full width cell renderer
     */
    public FullWidthCellRenderer()
    {
        setTag("div");
        addClass("ag-full-width-row");
    }

    @Override
    public void init()
    {
        if (!isInitialized())
        {
            // Default initialization - can be overridden by subclasses
            add("""
                <div class="full-width-container">
                    <div class="full-width-details">
                        <h3>Full Width Row</h3>
                        <p>Row ID: {{ rowId }}</p>
                        <p *ngIf="data">Data: {{ data | json }}</p>
                        <p *ngIf="pinned">Pinned: {{ pinned }}</p>
                    </div>
                </div>
            """);
            
            // Add some basic styling
            addStyle("padding", "10px");
            addStyle("background-color", "#f5f5f5");
            addStyle("border-bottom", "1px solid #ddd");
        }
        super.init();
    }

    @Override
    public Boolean standaloneOverride()
    {
        return true; // This component will be generated as a standalone component
    }
}