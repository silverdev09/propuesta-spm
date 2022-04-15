
package com.propuesta.spm.manager.rest;

import bo.union.lang.ServiceException;
import com.propuesta.spm.manager.PedidoServ;
import com.propuesta.spm.manager.data.ParamValue;
import com.propuesta.spm.manager.data.Pedido;
import com.propuesta.spm.manager.filter.PedidoFtr;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Administrador de pedidos
 */
@Path("pedido")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PedidoRest {

    @EJB
    private PedidoServ serv;

    @GET
    @Path("info")
    public String info() {
        return "Info Service: " + this + " by " + serv;
    }

    @POST
    @Path("filter")
    public List<Pedido> listarPedido(PedidoFtr filter) throws ServiceException{
        return serv.listarPedido(filter);
    }
    
    @POST
    @Path("list/producto")
    public List<ParamValue> listarProducto() {
        return serv.listarProducto();
    }

    @POST
    @Path("crear")
    public void crearPedido(Pedido value) throws ServiceException{
        serv.crearPedido(value);
    }

    @POST
    @Path("editar")
    public void editarPedido(Pedido value) throws ServiceException {
        serv.editarPedido(value);
    }

    @POST
    @Path("borrar")
    public void borrarPedido(Pedido value) throws ServiceException{
        serv.borrarPedido(value);
    }
}
