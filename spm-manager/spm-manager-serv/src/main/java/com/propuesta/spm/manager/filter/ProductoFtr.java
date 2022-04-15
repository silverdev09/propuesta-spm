
package com.propuesta.spm.manager.filter;

import bo.union.comp.FilterElement;
import bo.union.comp.filter.MapFilter;
import bo.union.comp.filter.ValueFilter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@XmlAccessorType(XmlAccessType.PROPERTY)
public class ProductoFtr extends MapFilter implements Serializable {

    private static final long serialVersionUID = 1L;
    @FilterElement
    private ValueFilter<Long> idProducto;
    @FilterElement
    private ValueFilter<String> nombre;

    public ValueFilter<Long> getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(ValueFilter<Long> idProducto) {
        this.idProducto = idProducto;
    }



    public ValueFilter<String> getNombre() {
        return nombre;
    }

    public void setNombre(ValueFilter<String> nombre) {
        this.nombre = nombre;
    }

    

}
