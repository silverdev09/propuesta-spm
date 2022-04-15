
package com.propuesta.spm.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author sipaco
 */
@Entity
@Table(name = "SPM_PRODUCTO")
@Cacheable(false)
public class SpmProducto implements Serializable {

    @Id
    @GeneratedValue(generator = "SPM_SEQ_PRODUCTO", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SPM_SEQ_PRODUCTO", sequenceName = "SPM_SEQ_PRODUCTO", allocationSize = 1)
    @Column(name = "ID_PRODUCTO")
    private Long idProducto;
    @Basic
    @Column(name = "NOMBRE")
    private String nombre;
    @ManyToMany(mappedBy = "listProducto")
    private List<SpmPedido> listPedido;

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

    public List<SpmPedido> getListPedido() {
        if (listPedido == null) {
            listPedido = new ArrayList<>();
        }
        return listPedido;
    }

    public void setListPedido(List<SpmPedido> listPedido) {
        this.listPedido = listPedido;
    }

    public void addListPedido(SpmPedido listPedido) {
        getListPedido().add(listPedido);
    }

    public void removeListPedido(SpmPedido listPedido) {
        getListPedido().remove(listPedido);
    }

}