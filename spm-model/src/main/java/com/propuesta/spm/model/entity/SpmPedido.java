
package com.propuesta.spm.model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author sipaco
 */
@Entity
@Table(name = "SPM_PEDIDO")
@Cacheable(false)
public class SpmPedido implements Serializable {

    @Id
    @GeneratedValue(generator = "SPM_SEQ_PEDIDO", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SPM_SEQ_PEDIDO", sequenceName = "SPM_SEQ_PEDIDO", allocationSize = 1)
    @Column(name = "ID_PEDIDO")
    private Long idPedido;
    @Basic
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @ManyToMany
    @JoinTable(name = "SPM_ORDEN", joinColumns = @JoinColumn(name = "ID_PEDIDO"), inverseJoinColumns = @JoinColumn(name = "ID_PRODUCTO"))
    private List<SpmProducto> listProducto;

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<SpmProducto> getListProducto() {
        if (listProducto == null) {
            listProducto = new ArrayList<>();
        }
        return listProducto;
    }

    public void setListProducto(List<SpmProducto> listProducto) {
        this.listProducto = listProducto;
    }

    public void addListProducto(SpmProducto listProducto) {
        getListProducto().add(listProducto);
        listProducto.getListPedido().add(this);
    }

    public void removeListProducto(SpmProducto listProducto) {
        getListProducto().remove(listProducto);
        listProducto.getListPedido().remove(this);
    }

}