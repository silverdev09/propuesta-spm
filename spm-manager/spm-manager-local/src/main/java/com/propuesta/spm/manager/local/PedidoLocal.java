
package com.propuesta.spm.manager.local;

import bo.union.comp.filter.MapFilter;
import bo.union.lang.ServiceException;
import bo.union.persist.qfilter.QFilter;
import com.propuesta.spm.model.entity.SpmPedido;
import com.propuesta.spm.tools.Config;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
@LocalBean
public class PedidoLocal {

    public static final String OBJECT_NAME = "Pedido";
    public static final String OBJECT_ID = "Id de " + OBJECT_NAME;
    @PersistenceContext(unitName = Config.UNIT_NAME_MNG)
    private EntityManager em;

    public List<SpmPedido> listarPedido(MapFilter filter) throws ServiceException {
        return QFilter.filter(em, SpmPedido.class, filter);
    }

    public List<SpmPedido> listarPedido() {
        List<SpmPedido> list = new ArrayList<>();
        Query q = em.createQuery("SELECT o FROM SpmPedido o");
        list = q.getResultList();
        return list.isEmpty() ? null : list;
    }

    public SpmPedido buscarPedido(Long idPedido) {
        return em.find(SpmPedido.class, idPedido);
    }

    public SpmPedido crearPedido(SpmPedido value) {
        em.persist(value);
        return value;
    }

    public SpmPedido editarPedido(SpmPedido entity) {
        em.merge(entity);
        return entity;
    }

    public SpmPedido borrarPedido(SpmPedido entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
        return entity;
    }

}
