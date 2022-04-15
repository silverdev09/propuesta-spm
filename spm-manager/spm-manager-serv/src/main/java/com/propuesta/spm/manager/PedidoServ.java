
package com.propuesta.spm.manager;

import bo.union.lang.ServiceException;
import com.propuesta.spm.manager.data.ParamValue;
import com.propuesta.spm.manager.data.Pedido;
import com.propuesta.spm.manager.filter.PedidoFtr;
import java.util.List;

public interface PedidoServ {

    public List<Pedido> listarPedido(PedidoFtr filter) throws ServiceException;

    public List<ParamValue> listarProducto();

    public void crearPedido(Pedido value) throws ServiceException;

    public void editarPedido(Pedido value) throws ServiceException;

    public void borrarPedido(Pedido value) throws ServiceException;
}
