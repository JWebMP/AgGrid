package com.jwebmp.plugins.aggrid;

import com.google.common.base.Strings;
import com.guicedee.client.IGuiceContext;
import com.guicedee.client.services.websocket.IGuicedWebSocket;
import com.guicedee.services.jsonrepresentation.IJsonRepresentation;
import com.jwebmp.core.base.ajax.AjaxCall;
import com.jwebmp.core.base.ajax.AjaxResponse;
import com.jwebmp.core.base.angular.client.annotations.constructors.NgConstructorBody;
import com.jwebmp.core.base.angular.client.annotations.functions.NgAfterViewInit;
import com.jwebmp.core.base.angular.client.annotations.functions.NgOnDestroy;
import com.jwebmp.core.base.angular.client.annotations.references.NgComponentReference;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportModule;
import com.jwebmp.core.base.angular.client.annotations.references.NgImportReference;
import com.jwebmp.core.base.angular.client.annotations.structures.NgField;
import com.jwebmp.core.base.angular.client.annotations.structures.NgMethod;
import com.jwebmp.core.base.angular.client.services.EventBusService;
import com.jwebmp.core.base.angular.client.services.interfaces.AnnotationUtils;
import com.jwebmp.core.base.angular.client.services.interfaces.IComponent;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.angular.implementations.WebSocketAbstractCallReceiver;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.plugins.ComponentInformation;
import com.jwebmp.plugins.aggrid.cellrenderers.DefaultCellRenderer;
import com.jwebmp.plugins.aggrid.cellrenderers.ICellRenderer;
import com.jwebmp.plugins.aggrid.options.AgGridColumnDef;
import com.jwebmp.plugins.aggrid.options.AgGridOptions;
import com.jwebmp.plugins.aggrid.options.enums.RowSelectionMode;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
	* The AG Grid Component for JWebMP
	*
	* @author GedMarc
	* @version 1.0.0
	* @since 2023
	*/
@ComponentInformation(name = "AG Grid",
	description = "AG Grid is a feature-rich data grid supporting multiple frameworks",
	url = "https://www.ag-grid.com/",
	wikiUrl = "https://github.com/JWebMP/JWebMP-AgGrid/wiki")


//@TsDependency(value = "ag-grid-enterprise", version = "^33.0.0")

// Import references
@NgImportReference(value = "AgGridAngular", reference = "ag-grid-angular")
@NgImportModule("AgGridAngular")
@NgImportReference(value = "ClientSideRowModelApiModule", reference = "ag-grid-community")
@NgImportReference(value = "ClientSideRowModelModule", reference = "ag-grid-community")
@NgImportReference(value = "ColDef", reference = "ag-grid-community")
@NgImportReference(value = "ColGroupDef", reference = "ag-grid-community")
@NgImportReference(value = "RowSelectedEvent", reference = "ag-grid-community")
@NgImportReference(value = "GetRowIdFunc", reference = "ag-grid-community")
@NgImportReference(value = "GetRowIdParams", reference = "ag-grid-community")
@NgImportReference(value = "GridOptions", reference = "ag-grid-community")
@NgImportReference(value = "GridReadyEvent", reference = "ag-grid-community")
@NgImportReference(value = "GridApi", reference = "ag-grid-community")
@NgImportReference(value = "RowSelectionModule", reference = "ag-grid-community")
@NgImportReference(value = "RowSelectionOptions", reference = "ag-grid-community")
@NgImportReference(value = "ValidationModule", reference = "ag-grid-community")


//@NgImportReference(value = "ColDef, GridOptions, GridApi, ColumnApi, GridReadyEvent, CellValueChangedEvent", reference = "ag-grid-community")
//@NgImportReference(value = "HttpClient", reference = "@angular/common/http")
//@NgImportReference(value = "AllCommunityModule, ModuleRegistry", reference = "ag-grid-community")
//@NgImportReference(value = "AllEnterpriseModule", reference = "ag-grid-enterprise")

// Import modules


// View child for accessing the grid API
// @NgViewChild("agGrid", "{ static: false }")
@NgImportReference(value = "ViewChild", reference = "@angular/core")
//@NgImportReference(value = "viewChild", reference = "@angular/core")


@NgAfterViewInit("""
	this.eventBusService.send(this.listenerName, {
	            className: this.clazzName,
	            listenerName: this.listenerName
	        }, this.listenerName);""")

@NgComponentReference(EventBusService.class)
@NgImportReference(value = "Subscription", reference = "rxjs")
@NgField("readonly subscription?: Subscription;")
@NgField("readonly handlerId :string;")
@NgField("readonly datasetHandlerId :string;")
@NgConstructorBody("this.datasetHandlerId = this.generateHandlerId();")
@NgConstructorBody("this.handlerId = this.generateHandlerId();")

@NgOnDestroy("""
	this.eventBusService.unregisterListener(this.listenerName, this.handlerId);
	""")

@NgImportReference(value = "v4 as uuidv4", reference = "uuid")
@NgMethod("""
	private generateHandlerId(): string {
	    return `${this.listenerName}-${uuidv4()}`;
	}
	""")

// Fields for grid API and column API
@NgImportReference(value = "GridApi", reference = "ag-grid-community")
@NgImportReference(value = "GridReadyEvent", reference = "ag-grid-community")
@NgField("gridApi?: GridApi;")

// Constructor for HTTP client
//@NgConstructorParameter("private http: HttpClient")
//@NgConstructorBody("// Register AG Grid modules\nModuleRegistry.registerModules([AllCommunityModule]);")

// Method for grid ready event
/*@NgMethod("""
            onGridReady(params: GridReadyEvent) {
                this.gridApi = params.api;
                this.columnApi = params.columnApi;

                // Emit the grid ready event
                this.gridReady.emit(params);

                // Auto-size columns if needed
                if (this.gridApi) {
                    this.gridApi.sizeColumnsToFit();
                }
            }
        """)*/

// Method for cell value changed event
/*@NgMethod("""
            onCellValueChanged(event: CellValueChangedEvent) {
                console.log('Cell value changed:', event);
                this.cellValueChanged.emit(event);
            }
        """)*/

public abstract class AgGrid<J extends AgGrid<J>> extends DivSimple<J> implements INgComponent<J>
{
		/**
			* The options for the grid
			*/
		private AgGridOptions<?> options;
		
		/**
			* Constructor for the AG Grid component
			*/
		public AgGrid()
		{
				setTag("ag-grid-angular");
				//addAttribute("class", "ag-theme-alpine");
				addAttribute("style", "width: 100%; height: 500px;");
				addAttribute("[context]", "{ componentParent: this }");
				
				// addAttribute("(gridReady)", "onGridReady($event)");
				//  addAttribute("(cellValueChanged)", "onCellValueChanged($event)");
				options = new AgGridOptions<>();
		}
		
		protected void registerWebSocketListeners()
		{
				if (!IGuicedWebSocket.isWebSocketReceiverRegistered(getListenerName()))
				{
						IGuicedWebSocket.addWebSocketMessageReceiver(new AgGridFetchDataReceiver(getListenerName(), (Class<? extends AgGrid<?>>) getClass()));
				}
		}
		
		protected String getListenerName()
		{
				return getID();
		}
		
		public abstract <T extends Collection<T> & IJsonRepresentation<T>> T fetchData();
		
		public abstract String getRowIdFieldName();
		
		protected static class AgGridFetchDataReceiver extends WebSocketAbstractCallReceiver<AgGridFetchDataReceiver>
		{
				private String listenerName;
				private Class<? extends AgGrid<?>> actionClass;
				
				public AgGridFetchDataReceiver()
				{
				}
				
				public AgGridFetchDataReceiver(String listenerName, Class<? extends AgGrid<?>> actionClass)
				{
						this.listenerName = listenerName;
						this.actionClass = actionClass;
				}
				
				@Override
				public String getMessageDirector()
				{
						return listenerName;
				}
				
				@Override
				public io.smallrye.mutiny.Uni<AjaxResponse<?>> action(AjaxCall<?> call, AjaxResponse<?> response)
				{
						return io.smallrye.mutiny.Uni
														.createFrom()
														.item(() -> {
																try
																{
																		actionClass = (Class<? extends AgGrid<?>>) Class.forName(call.getClassName());
																		listenerName = call
																																		.getUnknownFields()
																																		.get("listenerName")
																																		.toString();
																}
																catch (ClassNotFoundException e)
																{
																		e.printStackTrace();
																}
																var initialEvents = IGuiceContext
																																					.get(actionClass)
																																					.fetchData();
																if (initialEvents == null)
																{
																		return null;
																}
																response.addDataResponse(listenerName, initialEvents);
																return response;
														});
				}
		}
		
		/**
			* Gets the options for the grid
			*
			* @return The options for the grid
			*/
		public AgGridOptions<?> getOptions()
		{
				if (options == null)
				{
						options = new AgGridOptions<>();
				}
				return options;
		}
		
		/**
			* Sets the options for the grid
			*
			* @param options The options for the grid
			* @return This object
			*/
		@NotNull
		public @org.jspecify.annotations.NonNull J setOptions(AgGridOptions<?> options)
		{
				this.options = options;
				return (J) this;
		}
		
		/**
			* Binds the row data to the grid
			*
			* @param variableName The variable name to bind to
			* @return This object
			*/
		public J bindRowData(String variableName)
		{
				addAttribute("[rowData]", variableName);
				return (J) this;
		}
		
		/**
			* Binds the column definitions to the grid
			*
			* @param variableName The variable name to bind to
			* @return This object
			*/
		public J bindColumnDefs(String variableName)
		{
				addAttribute("[columnDefs]", variableName);
				return (J) this;
		}
		
		/**
			* Enables pagination for the grid
			*
			* @return This object
			*/
		public J enablePagination()
		{
				addAttribute("[pagination]", "true");
				return (J) this;
		}
		
		/**
			* Binds the pagination page size to the grid
			*
			* @param variableName The variable name to bind to
			* @return This object
			*/
		public J bindPaginationPageSize(String variableName)
		{
				addAttribute("[paginationPageSize]", variableName);
				return (J) this;
		}
		
		/**
			* Enables row selection for the grid
			*
			* @param selectionMode The selection mode ("single" or "multiple")
			* @return This object
			*/
		public J enableRowSelection(RowSelectionMode selectionMode)
		{
						getOptions()
							.configureSelection()
							.setRowSelection(selectionMode)
						;
				// Attribute binding will be handled in init() using a component field instead of inlining
				return (J) this;
		}
		
		/**
			* Binds the default column definition to the grid
			*
			* @param variableName The variable name to bind to
			* @return This object
			*/
		public J bindDefaultColDef(String variableName)
		{
				addAttribute("[defaultColDef]", variableName);
				return (J) this;
		}
		
		/**
			* Sets the height of the grid
			*
			* @param height The height value (e.g., "500px", "100%")
			* @return This object
			*/
		public @org.jspecify.annotations.NonNull J setHeight(String height)
		{
				addStyle("height", height);
				return (J) this;
		}
		
		/**
			* Sets the width of the grid
			*
			* @param width The width value (e.g., "500px", "100%")
			* @return This object
			*/
		public @org.jspecify.annotations.NonNull J setWidth(String width)
		{
				addStyle("width", width);
				return (J) this;
		}
		
		/**
			* Sets the theme for the grid
			*
			* @param theme The theme name (e.g., "ag-theme-alpine", "ag-theme-balham")
			* @return This object
			*/
		public @org.jspecify.annotations.NonNull J setTheme(String theme)
		{
				addClass(theme);
				return (J) this;
		}
		
		/**
			* Adds a grid ready event listener
			*/
		
		private String gridReadyEvent;
		
		/**
			* Adds a cell value changed event listener
			*/
		
		private String cellValueChangedEvent;
		
		/**
			* Adds a column definition to the grid options
			*
			* @param columnDef The column definition to add
			* @return This object
			*/
		public J addColumnDef(AgGridColumnDef<?> columnDef)
		{
				getOptions()
					.getColumnDefs()
					.add(columnDef)
				;
				return (J) this;
		}
		
		/**
			* Adds multiple column definitions to the grid options
			*
			* @param columnDefs The column definitions to add
			* @return This object
			*/
		public J addColumnDefs(List<AgGridColumnDef<?>> columnDefs)
		{
				getOptions()
					.getColumnDefs()
					.addAll(columnDefs)
				;
				return (J) this;
		}
		
		/**
			* Adds row data to the grid options
			*
			* @param rowData The row data to add
			* @return This object
			*/
		public J addRowData(Object rowData)
		{
				Object existing = getOptions().getRowData();
				if (existing instanceof List)
				{
						((List<Object>) existing).add(rowData);
				}
				return (J) this;
		}
		
		/**
			* Adds multiple row data items to the grid options
			*
			* @param rowData The row data items to add
			* @return This object
			*/
		public J addRowData(List<Object> rowData)
		{
				Object existing = getOptions().getRowData();
				if (existing instanceof List)
				{
						((List<Object>) existing).addAll(rowData);
				}
				return (J) this;
		}
		
		@Override
		protected void init()
		{
				if (!isInitialized())
				{
						addConfiguration(AnnotationUtils.getNgField("readonly listenerName = '" + getID() + "';", false, true));
						addConfiguration(AnnotationUtils.getNgField("readonly clazzName = '%s';".formatted(getClass().getCanonicalName()), false, true));
						
						registerWebSocketListeners();
						
						addAttribute("#" + getID(), "");
						// Initialize the grid with options
						if (options != null)
						{
								addAttribute("[gridOptions]", "options");
								if (options.getColumnDefs() != null)
								{
										for (AgGridColumnDef<?> columnDef : options.getColumnDefs())
										{
												if (columnDef.getCellRenderer() != null)
												{
														addConfiguration(AnnotationUtils
																																.getNgComponentReference((Class<? extends IComponent<?>>) columnDef
																																																																																											.getCellRenderer(true)
																																																																																											.getClass())
																																.setReferenceOnly(true));
												}
												if (columnDef.getHeaderComponent() != null)
												{
														addConfiguration(AnnotationUtils
																																.getNgComponentReference((Class<? extends IComponent<?>>) columnDef
																																																																																											.getHeaderComponent(true)
																																																																																											.getClass())
																																.setReferenceOnly(true));
												}
												if (columnDef.getHeaderComponentParams() != null && columnDef
																																																																	.getHeaderComponentParams()
																																																																	.getInnerHeaderComponent() != null)
												{
														addConfiguration(AnnotationUtils
																																.getNgComponentReference((Class<? extends IComponent<?>>) columnDef
																																																																																											.getHeaderComponentParams()
																																																																																											.getInnerHeaderComponent()
																																																																																											.getClass())
																																.setReferenceOnly(true));
												}
										}
								}
								
								
								if (options.getColumnDefs() != null && !options
																																																	.getColumnDefs()
																																																	.isEmpty())
								{
										addAttribute("[columnDefs]", "columnDefs");
								}
								
								if (!Strings.isNullOrEmpty(options.getRowDataRaw()))
								{
										addAttribute("[rowData]", options.getRowDataRaw());
								}
								else if (options.getRowData() != null && (options.getRowData() instanceof List))
								{
										List<?> rowDataList = (List<?>) options.getRowData();
										if (!rowDataList.isEmpty())
										{
												addAttribute("[rowData]", "rowData");
										}
								}
								
								if (options
													.configureRowPivoting()
													.getPivotMode() != null && options
																																									.configureRowPivoting()
																																									.getPivotMode())
								{
										addAttribute("[pagination]", "true");
								}
								
								if (options.getPaginationPageSize() != null)
								{
										addAttribute("[paginationPageSize]",
																							options
																								.getPaginationPageSize()
																								.toString());
								}
								
								if (options.getRowHeight() != null)
								{
										addAttribute("[rowHeight]", options.getRowHeight() + "");
								}
								
								if (options
													.configureSelection()
													.getRowSelection() != null)
								{
										// Bind to a component field rather than inlining the object to avoid breaking HTML
										addAttribute("[rowSelection]",
																							"'" + options
																														.configureSelection()
																														.getRowSelection()
																														.getValue() + "'");
								}
								if (options.getDefaultColDef() != null)
								{
										addAttribute("[defaultColDef]", "defaultColDef");
								}
								
								// Bind suppressAggFuncInHeader when provided so it reflects in the template/TS
								if (options
													.getRowGrouping()
													.getSuppressAggFuncInHeader() != null)
								{
										addAttribute("[suppressAggFuncInHeader]",
																							options
																								.getRowGrouping()
																								.getSuppressAggFuncInHeader() + "");
								}
								
								if (!Strings.isNullOrEmpty(getRowIdFieldName()))
								{
										addAttribute("[getRowId]", "getRowId");
								}
						}
				}
				super.init();
		}
		
		/**
			* Configures a column to use a cell renderer that implements INgComponent
			*
			* @param columnDef    The column definition to configure
			* @param cellRenderer The cell renderer class
			* @return This object
			*/
		public J configureCellRenderer(AgGridColumnDef<?> columnDef, ICellRenderer<?> cellRenderer)
		{
				// Add component reference for the renderer
				addConfiguration(AnnotationUtils.getNgComponentReference((Class<? extends IComponent<?>>) cellRenderer.getClass()));
				// Set the cell renderer on the column definition
				columnDef.setCellRenderer(cellRenderer);
				return (J) this;
		}
		
		/**
			* Creates a column with a cell renderer that implements INgComponent
			*
			* @param field             The field name
			* @param headerName        The column header
			* @param cellRendererClass The cell renderer class
			* @return The configured column definition
			*/
		public AgGridColumnDef<?> createColumnWithCellRenderer(String field, String headerName, DefaultCellRenderer<?> cellRendererClass)
		{
				// Add component reference for the renderer
				addConfiguration(AnnotationUtils.getNgComponentReference((Class<? extends IComponent<?>>) cellRendererClass.getClass()));
				
				// Create and configure the column definition
				AgGridColumnDef<?> columnDef = new AgGridColumnDef<>(field, headerName);
				columnDef.setCellRenderer(cellRendererClass);
				
				// Add the column to the grid
				addColumnDef(columnDef);
				
				return columnDef;
		}
		
		@Override
		public List<String> fields()
		{
				List<String> fields = new ArrayList<>();
				
				// Add column definitions field if needed
				if (options != null && options.getColumnDefs() != null && !options
																																																																.getColumnDefs()
																																																																.isEmpty())
				{
						fields.add("columnDefs: (ColDef | ColGroupDef)[] = " + options
																																																														.getColumnDefs()
																																																														.toString() + ";");
				}
				
				// Add row data binding
				if (options != null)
				{
						if (!Strings.isNullOrEmpty(options.getRowDataRaw()))
						{
								// Bind directly to the provided TS/Angular expression
								addAttribute("[rowData]", options.getRowDataRaw());
						}
						else if (options.getRowData() != null && (options.getRowData() instanceof List))
						{
								List<?> rowDataList = (List<?>) options.getRowData();
								if (!rowDataList.isEmpty())
								{
										// Emit a local TS field and bind to it
										fields.add("rowData: any[] = " + rowDataList
																																												.toString() + ";");
										addAttribute("[rowData]", "rowData");
								}
						}
				}
				
				fields.add("getRowId: GetRowIdFunc = (params: GetRowIdParams) => String(params.data." + getRowIdFieldName() + ");");
				
				// Add default column definition field
				if (options != null && options.getDefaultColDef() != null)
				{
						String defCol = String.valueOf(options.getDefaultColDef());
						if (Strings.isNullOrEmpty(defCol) || "{}".equals(defCol.trim()))
						{
								fields.add("defaultColDef: ColDef = { sortable: true, filter: true, resizable: true };");
						}
						else
						{
								fields.add("defaultColDef: ColDef = " + defCol + ";");
						}
						addAttribute("[defaultColDef]", "defaultColDef");
				}
				else
				{
						fields.add("defaultColDef: ColDef = { sortable: true, filter: true, resizable: true };");
						addAttribute("[defaultColDef]", "defaultColDef");
				}
				
				fields.add("@ViewChild('" + getID() + "') " + getID() + "? : AgGridAngular;");
				
				if (options != null)
				{
						String defCol = String.valueOf(options);
						if (Strings.isNullOrEmpty(defCol) || "{}".equals(defCol.trim()))
						{
								fields.add("options: GridOptions = {};");
						}
						else
						{
								fields.add("options: GridOptions = " + options.toString() + ";");
						}
				}
				
				return fields;
		}
		
		@Override
		public List<String> methods()
		{
				var s = INgComponent.super.methods();
				var strings = onRowSelectJS();
				
				s.add("""
											rowSelected($event: RowSelectedEvent<any>) {
											    this.%s?.api.refreshHeader();
											    %s
											}""".formatted(getID(), String.join("\n\t\t", strings)));
				return s;
		}
		
		private static final String updateDataString = """
			this.subscription = this.eventBusService.listen(this.listenerName, this.handlerId)
			  .subscribe({
			      next: (message: any) => {
			          if (message) {
			              if (Array.isArray(message)) {
			                  // message is an array of items (or strings)
			                  const rows: any[] = [];
			                  for (let m of message) {
			                      if (typeof m === 'string') {
			                          try { rows.push(...(JSON.parse(m) ?? [])); } catch {}
			                      } else {
			                          rows.push(m);
			                      }
			                  }
			                  if (this.TABLE_ID?.api) {
			                      this.TABLE_ID.api.setGridOption('rowData', rows);
			                  } else if (this.TABLE_ID) {
			                      this.TABLE_ID.rowData = rows;
			                  }
			              } else {
			                  // single message
			                  let rows: any[] | undefined;
			                  if (typeof message === 'string') {
			                      try { rows = JSON.parse(message); } catch {}
			                  } else {
			                      rows = Array.isArray(message) ? message : [message];
			                  }
			                  if (rows) {
			                      if (this.TABLE_ID?.api) {
			                          this.TABLE_ID.api.setGridOption('rowData', rows);
			                      } else if (this.TABLE_ID) {
			                          this.TABLE_ID.rowData = rows;
			                      }
			                  }
			              }
			          } else {
			              // message is falsy -> clear data
			              if (this.TABLE_ID?.api) {
			                  this.TABLE_ID.api.setGridOption('rowData', []);
			              } else if (this.TABLE_ID) {
			                  this.TABLE_ID.rowData = [];
			              }
			          }
			      },
			      error: (error: any) => {
			          console.log(error);
			      },
			  })
			""";
		
		@Override
		public List<String> constructorBody()
		{
				var out = INgComponent.super.constructorBody();
				// Dynamically target the ViewChild reference based on this component's ID
				// Replace the placeholder identifier 'TABLE_ID' in updateDataString with the actual ID
				String viewChildId = getID();
				String dynamicUpdateData = updateDataString.replace("TABLE_ID", viewChildId);
				out.add(dynamicUpdateData);
				return out;
		}
		
		public List<String> onRowSelectJS()
		{
				return new ArrayList<>();
		}
}
