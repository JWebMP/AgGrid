package com.jwebmp.plugins.aggrid;

import com.google.common.base.Strings;
import com.guicedee.client.IGuiceContext;
import com.guicedee.guicedservlets.websockets.options.IGuicedWebSocket;
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
import com.jwebmp.core.base.angular.client.annotations.typescript.TsDependency;
import com.jwebmp.core.base.angular.client.services.EventBusService;
import com.jwebmp.core.base.angular.client.services.interfaces.IComponent;
import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.angular.implementations.WebSocketAbstractCallReceiver;
import com.jwebmp.core.base.html.DivSimple;
import com.jwebmp.core.plugins.ComponentInformation;
import com.jwebmp.core.base.angular.client.services.interfaces.AnnotationUtils;
import com.jwebmp.plugins.aggrid.cellrenderers.DefaultCellRenderer;
import com.jwebmp.plugins.aggrid.options.AgGridColumnDef;
import com.jwebmp.plugins.aggrid.options.AgGridOptions;
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
@NgImportReference(value = "ColDef", reference = "ag-grid-community")
@NgImportReference(value = "ColGroupDef", reference = "ag-grid-community")
@NgImportReference(value = "RowSelectedEvent", reference = "ag-grid-community")
@NgImportReference(value = "GetRowIdFunc", reference = "ag-grid-community")
@NgImportReference(value = "GetRowIdParams", reference = "ag-grid-community")


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


@NgConstructorBody("""
        this.subscription = this.eventBusService.listen(this.listenerName, this.handlerId)
              .subscribe({
                  next: (message: any) => {
                      if (message) {
                          if (Array.isArray(message)) {
                          alert('array instructions table : ' + JSON.stringify(message));
                          /*    for (let m of message) {
                                  if (typeof m == 'string')
                                      this.chartConfiguration.set(JSON.parse(m));
                                  else
                                      this.chartConfiguration.set(m);
                              }*/
                          }
                      }else {
                        alert('normal instructions table : ' + JSON.stringify(message));
                        /*  if (typeof message == 'string')
                              this.chartConfiguration.set(JSON.parse(message));
                          else
                              this.chartConfiguration.set(message);*/
                      }
                  },
                  error: (error: any) => {
                      console.log(error);
                  },
              })
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

    protected static class AgGridFetchDataReceiver extends WebSocketAbstractCallReceiver
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
        public AjaxResponse<?> action(AjaxCall<?> call, AjaxResponse<?> response)
        {
            try
            {
                actionClass = (Class<? extends AgGrid<?>>) Class.forName(call.getClassName());
                listenerName = call.getUnknownFields()
                                   .get("listenerName")
                                   .toString();
            }
            catch (ClassNotFoundException e)
            {
                e.printStackTrace();
            }
            var initialEvents = IGuiceContext.get(actionClass)
                                             .fetchData();
            if (initialEvents == null)
            {
                return null;
            }
            response.addDataResponse(listenerName, initialEvents);
            return response;
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
    public J setOptions(AgGridOptions<?> options)
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
    public J enableRowSelection(String selectionMode)
    {
        if (selectionMode != null)
        {
            // Map common strings to the enum where necessary
            // 'single' -> SINGLE (serializes to 'singleRow'), 'multiple' -> MULTIPLE
            com.jwebmp.plugins.aggrid.options.enums.RowSelectionMode mode;
            if ("single".equalsIgnoreCase(selectionMode) || "singlerow".equalsIgnoreCase(selectionMode))
            {
                mode = com.jwebmp.plugins.aggrid.options.enums.RowSelectionMode.SINGLE;
            }
            else if ("multiple".equalsIgnoreCase(selectionMode))
            {
                mode = com.jwebmp.plugins.aggrid.options.enums.RowSelectionMode.MULTIPLE;
            }
            else
            {
                // Try to resolve using enum helper, falls back to MULTIPLE if unrecognized
                com.jwebmp.plugins.aggrid.options.enums.RowSelectionMode resolved = com.jwebmp.plugins.aggrid.options.enums.RowSelectionMode.fromString(selectionMode);
                mode = resolved != null ? resolved : com.jwebmp.plugins.aggrid.options.enums.RowSelectionMode.MULTIPLE;
            }
            getOptions().setRowSelectionMode(mode);
        }
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
    public J setHeight(String height)
    {
        addAttribute("style", "width: 100%; height: " + height + ";");
        return (J) this;
    }

    /**
     * Sets the width of the grid
     *
     * @param width The width value (e.g., "500px", "100%")
     * @return This object
     */
    public J setWidth(String width)
    {
        String currentStyle = getAttribute("style");
        if (currentStyle != null && currentStyle.contains("height"))
        {
            String height = currentStyle.substring(currentStyle.indexOf("height: ") + 8);
            height = height.substring(0, height.indexOf(";"));
            addAttribute("style", "width: " + width + "; height: " + height + ";");
        }
        else
        {
            addAttribute("style", "width: " + width + "; height: 500px;");
        }
        return (J) this;
    }

    /**
     * Sets the theme for the grid
     *
     * @param theme The theme name (e.g., "ag-theme-alpine", "ag-theme-balham")
     * @return This object
     */
    public J setTheme(String theme)
    {
        addAttribute("class", theme);
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
        getOptions().getColumnDefs()
                    .add(columnDef);
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
        getOptions().getColumnDefs()
                    .addAll(columnDefs);
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
        getOptions().getRowData()
                    .add(rowData);
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
        getOptions().getRowData()
                    .addAll(rowData);
        return (J) this;
    }

    @Override
    protected void init()
    {
        if (!isInitialized())
        {
            addConfiguration(AnnotationUtils.getNgField("readonly listenerName = '" + getID() + "';"));
            addConfiguration(AnnotationUtils.getNgField("readonly clazzName = '%s';".formatted(getClass().getCanonicalName())));

            registerWebSocketListeners();

            addAttribute("#" + getID(), "");
            // Initialize the grid with options
            if (options != null)
            {
                if (options.getColumnDefs() != null)
                {
                    for (AgGridColumnDef<?> columnDef : options.getColumnDefs())
                    {
                        if (columnDef.getCellRenderer() != null)
                        {
                            addConfiguration(AnnotationUtils.getNgComponentReference((Class<? extends IComponent<?>>) columnDef.getCellRenderer(true)
                                                                                                                               .getClass())
                                                            .setReferenceOnly(true));
                        }
                        if (columnDef.getHeaderComponent() != null)
                        {
                            addConfiguration(AnnotationUtils.getNgComponentReference((Class<? extends IComponent<?>>) columnDef.getHeaderComponent(true)
                                                                                                                               .getClass())
                                                            .setReferenceOnly(true));
                        }
                        if (columnDef.getHeaderComponentParams() != null && columnDef.getHeaderComponentParams()
                                                                                     .getInnerHeaderComponent() != null)
                        {
                            addConfiguration(AnnotationUtils.getNgComponentReference((Class<? extends IComponent<?>>) columnDef.getHeaderComponentParams()
                                                                                                                               .getInnerHeaderComponent()
                                                                                                                               .getClass())
                                                            .setReferenceOnly(true));
                        }
                    }
                }


                if (options.getColumnDefs() != null && !options.getColumnDefs()
                                                               .isEmpty())
                {
                    addAttribute("[columnDefs]", "columnDefs");
                }

                if (!Strings.isNullOrEmpty(options.getRowDataRaw()))
                {
                    addAttribute("[rowData]", options.getRowDataRaw());
                }
                else if (options.getRowData() != null && !options.getRowData()
                                                                 .isEmpty())
                {
                    addAttribute("[rowData]", "rowData");
                }

                if (options.getPagination() != null && options.getPagination())
                {
                    addAttribute("[pagination]", "true");
                }

                if (options.getPaginationPageSize() != null)
                {
                    addAttribute("[paginationPageSize]", options.getPaginationPageSize()
                                                                .toString());
                }

                if (options.getRowHeight() != null)
                {
                    addAttribute("[rowHeight]", "rowHeight");
                }

                if (options.getRowSelection() != null)
                {
                    // Bind to a component field rather than inlining the object to avoid breaking HTML
                    addAttribute("[rowSelection]", "rowSelection");
                }
                if (options.getDefaultColDef() != null)
                {
                    addAttribute("[defaultColDef]", "defaultColDef");
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
     * @param columnDef         The column definition to configure
     * @param cellRendererClass The cell renderer class
     * @return This object
     */
    public J configureCellRenderer(AgGridColumnDef<?> columnDef, DefaultCellRenderer<?> cellRendererClass)
    {
        // Add component reference for the renderer
        addConfiguration(AnnotationUtils.getNgComponentReference((Class<? extends IComponent<?>>) cellRendererClass.getClass()));
        // Set the cell renderer on the column definition
        columnDef.setCellRenderer(cellRendererClass);
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
        if (options != null && options.getColumnDefs() != null && !options.getColumnDefs()
                                                                          .isEmpty())
        {
            fields.add("columnDefs: (ColDef | ColGroupDef)[] = " + options.getColumnDefs()
                                                                          .toString() + ";");
        }

        // Add row data field if needed (only when not using raw binding)
        if (options != null && Strings.isNullOrEmpty(options.getRowDataRaw()) && options.getRowData() != null && !options.getRowData()
                                                                                                                         .isEmpty())
        {
            addAttribute("[rowData]", options.getRowDataRaw());
            addAttribute("*ngIf", options.getRowDataRaw());
            //fields.add("rowData: any[] = " + options.getRowData()
            //                                        .toString() + ";");
        }

        fields.add("getRowId: GetRowIdFunc = (params: GetRowIdParams) => String(params.data." + getRowIdFieldName() + ");");

        // Add default column definition field
        if (options != null && options.getDefaultColDef() != null)
        {
            fields.add("defaultColDef: ColDef = " + options.getDefaultColDef()
                                                           .toString() + ";");
        }
        else
        {
            fields.add("defaultColDef: ColDef = { sortable: true, filter: true, resizable: true };");
            addAttribute("[defaultColDef]", "defaultColDef");
        }

        // Add row height field if provided, and bind to it in the template
        if (options != null && options.getRowHeight() != null)
        {
            fields.add("rowHeight: number = " + options.getRowHeight()
                                                       .toString() + ";");
        }

        // Add row selection field if provided, and bind to it in the template
        if (options != null && options.getRowSelection() != null)
        {
            fields.add("rowSelection: any = " + options.getRowSelection()
                                                       .toString() + ";");
        }

        fields.add("@ViewChild('" + getID() + "') " + getID() + "? : AgGridAngular;");

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

    public List<String> onRowSelectJS()
    {
        return new ArrayList<>();
    }
}
