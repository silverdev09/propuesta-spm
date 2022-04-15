
package com.propuesta.spm.manager;

import bo.union.lang.ServiceException;
import com.propuesta.spm.manager.data.Producto;
import com.propuesta.spm.manager.filter.ProductoFtr;
import com.propuesta.spm.manager.local.ProductoLocal;
import com.propuesta.spm.manager.mapper.PedidoMapper;
import com.propuesta.spm.manager.mapper.ProductoMapper;
import com.propuesta.spm.model.entity.SpmProducto;
import java.util.ArrayList;
import javax.ejb.*;

import java.util.List;

@Stateless
@Local(ProductoServ.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ProductoImpl implements ProductoServ {

    @EJB
    private ProductoLocal local;

    @Override
    public List<Producto> listarProducto(ProductoFtr filter) throws ServiceException {
        List<SpmProducto> list = local.listarProducto(filter);
        List<Producto> result = new ArrayList<>();
        for (SpmProducto pr : list) {
            Producto p = ProductoMapper.mapperToProducto(pr);
            p.setListPedido(PedidoMapper.mapperToPedidoList(pr.getListPedido()));
            result.add(p);
        }
        return result;
    }

    @Override
    public void crearProducto(Producto value) {
        SpmProducto entity = ProductoMapper.mapperToSpmProducto(value);
        local.crearProducto(entity);
    }

    @Override
    public void editarProducto(Producto value) {
        SpmProducto entity = ProductoMapper.mapperToSpmProducto(value);
        local.editarProducto(entity);
    }

    @Override
    public void borrarProducto(Producto value) {
        SpmProducto entity = ProductoMapper.mapperToSpmProducto(value);
        local.borrarProducto(entity);
    }
}
