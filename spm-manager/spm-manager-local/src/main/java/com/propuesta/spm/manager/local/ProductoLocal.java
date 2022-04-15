

package com.propuesta.spm.manager.local;

import com.propuesta.spm.model.entity.SpmProducto;
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
public class ProductoLocal {

	public static final String OBJECT_NAME = "Producto";
	public static final String OBJECT_ID = "Id de " + OBJECT_NAME;
	@PersistenceContext(unitName = Config.UNIT_NAME_MNG)
	private EntityManager em;

        public List<SpmProducto> listarProducto (){
            List<SpmProducto> list = new ArrayList<>();
            Query q = em.createQuery("SELECT o FROM SpmProducto o");
            list = q.getResultList();
            return list.isEmpty() ? null : list;
        }
        
	public SpmProducto buscarProducto(Long idProducto) {
		return em.find(SpmProducto.class, idProducto);
	}

	public SpmProducto crearProducto(SpmProducto value) {
		em.persist(value);
		return value;
	}

	public SpmProducto editarProducto(SpmProducto entity) {
		em.merge(entity);
		return entity;
	}

	public SpmProducto borrarProducto(SpmProducto entity) {
		em.remove(em.contains(entity) ? entity : em.merge(entity));
		return entity;
	}

}
