package com.jwebmp.plugins.aggrid.options;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AgGridColumnDefTest {

    @Test
    void testNewProperties() {
        AgGridColumnDef<?> columnDef = new AgGridColumnDef<>();
        columnDef.setField("athlete");
        columnDef.setColId("athleteId");
        columnDef.setType("nonEditableColumn");
        columnDef.setEditable(true);
        columnDef.setCellStyle(new java.util.HashMap<String, String>() {{ put("backgroundColor", "red"); }});
        columnDef.setValueParserRaw("params => Number(params.newValue)");
        columnDef.setValueSetterRaw("params => { params.data.value = params.newValue; return true; }");
        columnDef.setRowSpanRaw("params => params.data.rowSpan");
        columnDef.setAggFunc("sum");
        columnDef.setPivot(true);
        columnDef.setPivotIndex(1);
        columnDef.setEnablePivot(true);
        columnDef.setRowDrag(true);
        columnDef.setDndSource(true);
        columnDef.setToolPanelClass("my-tool-panel-class");

        String json = columnDef.toJson();
        System.out.println("ColumnDef JSON Output: " + json);

        assertTrue(json.contains("\"field\" : \"athlete\""));
        assertTrue(json.contains("\"colId\" : \"athleteId\""));
        assertTrue(json.contains("\"type\" : \"nonEditableColumn\""));
        assertTrue(json.contains("\"editable\" : true"));
        assertTrue(json.contains("\"cellStyle\" : {"));
        assertTrue(json.contains("\"backgroundColor\" : \"red\""));
        assertTrue(json.contains("\"valueParser\":params => Number(params.newValue)") || json.contains("\"valueParser\" : params => Number(params.newValue)"));
        assertTrue(json.contains("\"valueSetter\":params => { params.data.value = params.newValue; return true; }") || json.contains("\"valueSetter\" : params => { params.data.value = params.newValue; return true; }"));
        assertTrue(json.contains("\"rowSpan\":params => params.data.rowSpan") || json.contains("\"rowSpan\" : params => params.data.rowSpan"));
        assertTrue(json.contains("\"aggFunc\" : \"sum\""));
        assertTrue(json.contains("\"pivot\" : true"));
        assertTrue(json.contains("\"pivotIndex\" : 1"));
        assertTrue(json.contains("\"enablePivot\" : true"));
        assertTrue(json.contains("\"rowDrag\" : true"));
        assertTrue(json.contains("\"dndSource\" : true"));
        assertTrue(json.contains("\"toolPanelClass\" : \"my-tool-panel-class\""));
    }

    @Test
    void testRawFunctions() {
        AgGridColumnDef<?> columnDef = new AgGridColumnDef<>();
        columnDef.setEditableRaw("params => params.data.canEdit");
        columnDef.setCellStyleRaw("params => params.value > 10 ? {color: 'red'} : null");
        columnDef.setAggFuncRaw("(params) => params.values.length");

        String json = columnDef.toJson();
        System.out.println("Raw Functions JSON Output: " + json);

        assertTrue(json.contains("\"editable\":params => params.data.canEdit") || json.contains("\"editable\" : params => params.data.canEdit"));
        assertTrue(json.contains("\"cellStyle\":params => params.value > 10 ? {color: 'red'} : null") || json.contains("\"cellStyle\" : params => params.value > 10 ? {color: 'red'} : null"));
        assertTrue(json.contains("\"aggFunc\":(params) => params.values.length") || json.contains("\"aggFunc\" : (params) => params.values.length"));
    }

    @Test
    void testTypedProperties() {
        AgGridColumnDef<?> columnDef = new AgGridColumnDef<>();
        columnDef.setType(java.util.Arrays.asList("type1", "type2"));
        columnDef.setRowSpan(2);

        String json = columnDef.toJson();
        System.out.println("Typed Properties JSON Output: " + json);

        assertTrue(json.contains("\"type\" : [ \"type1\", \"type2\" ]") || json.contains("\"type\":[\"type1\",\"type2\"]"));
        assertTrue(json.contains("\"rowSpan\" : 2") || json.contains("\"rowSpan\":2"));
    }
}
