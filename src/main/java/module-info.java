import com.guicedee.guicedinjection.interfaces.IGuiceScanModuleInclusions;
import com.jwebmp.plugins.aggrid.implementations.AgGridInclusionsModule;

module com.jwebmp.plugins.aggrid {

    exports com.jwebmp.plugins.aggrid;
    exports com.jwebmp.plugins.aggrid.cellrenderers;
    exports com.jwebmp.plugins.aggrid.headers;
    exports com.jwebmp.plugins.aggrid.options;
    exports com.jwebmp.plugins.aggrid.options.enums;

    requires com.jwebmp.core;
    requires com.jwebmp.client;
    requires transitive com.jwebmp.core.base.angular.client;

    requires jakarta.validation;
    requires java.logging;

    requires com.guicedee.client;
    requires com.fasterxml.jackson.databind;
    requires com.guicedee.jsonrepresentation;
    requires com.jwebmp.core.angular;
    requires com.fasterxml.jackson.core;
    requires static lombok;

    provides com.jwebmp.core.services.IPageConfigurator with com.jwebmp.plugins.aggrid.AgGridPageConfigurator;
    provides IGuiceScanModuleInclusions with AgGridInclusionsModule;

    opens com.jwebmp.plugins.aggrid to com.fasterxml.jackson.databind, com.jwebmp.core;
    opens com.jwebmp.plugins.aggrid.options to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
    opens com.jwebmp.plugins.aggrid.headers to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
    opens com.jwebmp.plugins.aggrid.cellrenderers to com.fasterxml.jackson.databind, com.jwebmp.core, com.google.guice;
    opens com.jwebmp.plugins.aggrid.implementations to com.google.guice;
}
