
package com.propuesta.spm.manager;

import bo.union.lang.ServiceException;
import bo.union.lang.ValidationException;
import com.propuesta.spm.manager.data.ParamValue;
import com.propuesta.spm.manager.data.Pedido;
import com.propuesta.spm.manager.data.Producto;
import com.propuesta.spm.manager.filter.PedidoFtr;
import com.propuesta.spm.manager.local.PedidoLocal;
import com.propuesta.spm.manager.local.ProductoLocal;
import com.propuesta.spm.manager.mapper.PedidoMapper;
import com.propuesta.spm.manager.mapper.ProductoMapper;
import com.propuesta.spm.model.entity.SpmPedido;
import com.propuesta.spm.model.entity.SpmProducto;
import com.propuesta.spm.tools.constantes.Fecha;
import com.propuesta.spm.tools.mapper.SerializaObjeto;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;

@Stateless
@Local(PedidoServ.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PedidoImpl implements PedidoServ {

    @EJB
    private PedidoLocal local;
    @EJB
    private ProductoLocal localProducto;

    @Override
    public List<Pedido> listarPedido(PedidoFtr filter) throws ServiceException{
        List<SpmPedido> list = local.listarPedido(filter);
        return PedidoMapper.mapperToPedidoList(list);
    }

    @Override
    public List<ParamValue> listarProducto() {
        List<ParamValue> result = new ArrayList<>();
        List<SpmProducto> list = localProducto.listarProducto();
        List<Producto> produtos = ProductoMapper.mapperToProductoList(list);
        if (produtos != null) {
            result = SerializaObjeto.mapperToListParamValue(produtos);
        }
        return result;
    }

    @Override
    public void crearPedido(Pedido value) throws ServiceException {
        ValidationException validate = new ValidationException(PedidoLocal.OBJECT_NAME);
        SpmPedido entity = PedidoMapper.mapperToSpmPedido(value);
        List<Producto> listProducto = value.getListProducto();
        validaProductosRepetido(listProducto, validate);
        entity.setFecha(Fecha.fechaActual());
        local.crearPedido(entity);
    }

    @Override
    public void editarPedido(Pedido value) throws ServiceException{
        ValidationException validate = new ValidationException(PedidoLocal.OBJECT_NAME);
        SpmPedido entity = PedidoMapper.mapperToSpmPedido(value);
        List<Producto> listProducto = value.getListProducto();
        validaProductosRepetido(listProducto, validate);
        local.editarPedido(entity);
    }

    @Override
    public void borrarPedido(Pedido value) {
        SpmPedido entity = PedidoMapper.mapperToSpmPedido(value);
        local.borrarPedido(entity);
    }

    private void validaProductosRepetido(List<Producto> list, ValidationException validate) throws ServiceException {
        validate.addWhen(tieneDuplicados(list), "El pedido tiene productos duplicados");
        validate.throwException();
    }

    public boolean tieneDuplicados(final List<Producto> list) {
        List<Producto> result = mapDuplicados(list).values().stream()
                .filter(duplicates -> duplicates.size() > 1)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        return !result.isEmpty() ? true : false;
    }

    private Map<Long, List<Producto>> mapDuplicados(List<Producto> personList) {
        return personList.stream().collect(groupingBy(Producto::getIdProducto));
    }
}
