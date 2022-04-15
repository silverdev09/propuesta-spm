
package com.propuesta.spm.manager.rest;

import com.propuesta.spm.manager.ProductoServ;
import com.propuesta.spm.manager.data.Producto;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Administrador de productos
 */
@Path("producto")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductoRest {

    @EJB
    private ProductoServ serv;

    @GET
    @Path("info")
    public String info() {
        return "Info Service: " + this + " by " + serv;
    }

    @POST
    @Path("listar")
    public List<Producto> listarProducto() {
        return serv.listarProducto();
    }

    @POST
    @Path("crear")
    public void crearProducto(Producto value) {
        serv.crearProducto(value);
    }

    @POST
    @Path("editar")
    public void editarProducto(Producto value) {
        serv.editarProducto(value);
    }

    @POST
    @Path("borrar")
    public void borrarProducto(Producto value) {
        serv.borrarProducto(value);
    }
}
