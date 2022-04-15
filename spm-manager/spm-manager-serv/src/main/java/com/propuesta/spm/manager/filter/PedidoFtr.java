
package com.propuesta.spm.manager.filter;

import bo.union.comp.FilterElement;
import bo.union.comp.filter.MapFilter;
import bo.union.comp.filter.ValueFilter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class PedidoFtr extends MapFilter implements Serializable {

    private static final long serialVersionUID = 1L;
    @FilterElement
    private ValueFilter<Long> idPedido;
    @FilterElement
    private ValueFilter<String> descripcion;
    @FilterElement
    private ValueFilter<Date> fecha;

    public ValueFilter<Long> getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(ValueFilter<Long> idPedido) {
        this.idPedido = idPedido;
    }

    public ValueFilter<String> getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(ValueFilter<String> descripcion) {
        this.descripcion = descripcion;
    }

    public ValueFilter<Date> getFecha() {
        return fecha;
    }

    public void setFecha(ValueFilter<Date> fecha) {
        this.fecha = fecha;
    }

}
