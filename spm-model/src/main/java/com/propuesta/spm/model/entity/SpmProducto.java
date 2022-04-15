/*
 * ┌─────────────────────────────────────────────────────────────────┐
 * │   ____                          _   _       _   __              │
 * │  | __ )  __ _ _ __   ___ ___   | | | |_ __ (_) /_/  _ __        │
 * │  |  _ \ / _` | '_ \ / __/ _ \  | | | | '_ \| |/ _ \| '_ \       │
 * │  | |_) | (_| | | | | (_| (_) | | |_| | | | | | (_) | | | |┌┐┌┐  │
 * │  |____/ \__,_|_| |_|\___\___/   \___/|_| |_|_|\___/|_| |_|└┐├┤  │
 * │                                  _                        └┘┘└  │
 * │  _ __  _ __ ___  _   _  ___  ___| |_ ___     ___ ___  _ __ ___  │
 * │ | '_ \| '__/ _ \| | | |/ _ \/ __| __/ _ \   / __/ _ \| '__/ _ \ │
 * │ | |_) | | | (_) | |_| |  __/ (__| || (_) | | (_| (_) | | |  __/ │
 * │ | .__/|_|  \___/ \__, |\___|\___|\__\___/   \___\___/|_|  \___| │
 * │ |_|              |___/                                          │
 * ├─────────────────────────────────────────────────────────────────┤
 * │ Copyright©2021 - http://www.bancounion.com.bo/core/licence.html │
 * └─────────────────────────────────────────────────────────────────┘
 */
package com.propuesta.spm.model.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author spm
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

}