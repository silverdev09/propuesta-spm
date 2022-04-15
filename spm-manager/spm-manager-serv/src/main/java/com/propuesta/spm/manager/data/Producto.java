
package com.propuesta.spm.manager.data;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author spm
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @XmlElement
    private Long idProducto;
    @XmlElement
    private String nombre;
    @XmlElement
    private List<Pedido> listPedido;

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Pedido> getListPedido() {
        return listPedido;
    }

    public void setListPedido(List<Pedido> listPedido) {
        this.listPedido = listPedido;
    }

}
