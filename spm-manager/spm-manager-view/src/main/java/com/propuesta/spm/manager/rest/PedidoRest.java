
package com.propuesta.spm.manager.rest;

import com.propuesta.spm.manager.PedidoServ;
import com.propuesta.spm.manager.data.Pedido;
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
    @Path("listar")
    public List<Pedido> listarPedido() {
        return serv.listarPedido();
    }

    @POST
    @Path("crear")
    public void crearPedido(Pedido value) {
        serv.crearPedido(value);
    }

    @POST
    @Path("editar")
    public void editarPedido(Pedido value) {
        serv.editarPedido(value);
    }

    @POST
    @Path("borrar")
    public void borrarPedido(Pedido value) {
        serv.borrarPedido(value);
    }
}
