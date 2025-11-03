package com.jwebmp.plugins.aggrid.cellrenderers;

import com.jwebmp.core.base.angular.client.services.interfaces.INgComponent;
import com.jwebmp.core.base.interfaces.IComponentHierarchyBase;

/**
 * A common abstract type for AG Grid cell renderers used by column definitions.
 * Both {@link DefaultCellRenderer} and {@link ValueCellRenderer} implement this.
 *
 * @param <J> CRTP self type
 */
public interface ICellRenderer<J extends ICellRenderer<J> & IComponentHierarchyBase<?, J>> extends INgComponent<J>
{
    // Marker interface to allow AgGrid APIs to accept any supported cell renderer
}
