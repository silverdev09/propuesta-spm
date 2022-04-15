
package com.propuesta.spm.manager;

import com.propuesta.spm.manager.data.Producto;
import com.propuesta.spm.manager.local.ProductoLocal;
import com.propuesta.spm.manager.mapper.ProductoMapper;
import com.propuesta.spm.model.entity.SpmProducto;
import javax.ejb.*;

import java.util.List;

@Stateless
@Local(ProductoServ.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class ProductoImpl implements ProductoServ {

    @EJB
    private ProductoLocal local;

    @Override
    public List<Producto> listarProducto() {
        List<SpmProducto> result = local.listarProducto();
        return ProductoMapper.mapperToProductoList(result);
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
