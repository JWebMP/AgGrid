package com.jwebmp.plugins.aggrid.cellrenderers;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportModule;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.annotations.structures.NgField;
import com.jwebmp.core.base.angular.client.annotations.structures.NgInterface;
import com.jwebmp.core.base.angular.client.annotations.structures.NgMethod;
import com.jwebmp.core.base.angular.client.services.interfaces.AnnotationUtils;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.plugins.aggrid.cellrenderers.ICellRenderer;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.plugins.ComponentInformation;
import lombok.Getter;

import java.util.List;

/**
	* A default cell renderer for AG Grid that can be extended by other cell renderers that returns the row object as 'value'
	*
	* @author GedMarc
	* @version 1.0.0
	* @since 2023
	*/
@ComponentInformation(name = "Default Cell Renderer",
	description = "A default cell renderer for AG Grid that can be extended by other cell renderers",
	url = "https://www.ag-grid.com/angular-data-grid/component-cell-renderer/",
	wikiUrl = "https://github.com/JWebMP/JWebMP-AgGrid/wiki")

// Import references
@NgImportReference(value = "ICellRendererAngularComp", reference = "ag-grid-angular")
@NgImportReference(value = "ICellRendererParams", reference = "ag-grid-community")

// Field for the cell value
@NgField("value: any = '';")
@NgField("params :any;")

@NgInterface("ICellRendererAngularComp")

// Method to initialize the cell renderer
@NgMethod("""
	    agInit(params: ICellRendererParams): void {
	        this.value = params.data;
	        this.params = params;
	    }
	""")

public class DefaultCellRenderer<J extends DefaultCellRenderer<J>> extends DivSimple<J> implements ICellRenderer<J>
{
		private static final String refreshMethod = """
			    refresh(params: ICellRendererParams): boolean {
			        this.value = params.data;
			        this.params = params;
			        return %s;
			    }
			""";
		
		@Getter
		private boolean refresh = false;
		
		public @org.jspecify.annotations.NonNull J setRefresh(boolean refresh)
		{
				this.refresh = refresh;
				return (J)this;
		}
		
		@Override
		public List<String> methods()
		{
				var s =  ICellRenderer.super.methods();
				s.add(refreshMethod.formatted(refresh + ""));
				return s;
		}
		
		/**
			* Constructor for the default cell renderer
			*/
		public DefaultCellRenderer()
		{
				setTag("span");
		}
		
		@Override
		public void init()
		{
				if (!isInitialized())
				{
						// Default initialization - can be overridden by subclasses
						//add("{{ value }}");
				}
				super.init();
		}
		
		@Override
		public Boolean standaloneOverride()
		{
				return true; // This component will be generated as a standalone component
		}
		
		@JsonRawValue
		@JsonValue
		public String jsonRenderValue()
		{
				return AnnotationUtils.getTsFilename(getClass());
		}
}
