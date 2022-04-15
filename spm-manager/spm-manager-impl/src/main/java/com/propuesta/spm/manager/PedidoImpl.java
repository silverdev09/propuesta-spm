
package com.propuesta.spm.manager;

import com.propuesta.spm.manager.data.Pedido;
import com.propuesta.spm.manager.local.PedidoLocal;
import com.propuesta.spm.manager.mapper.PedidoMapper;
import com.propuesta.spm.model.entity.SpmPedido;
import javax.ejb.*;

import java.util.List;

@Stateless
@Local(PedidoServ.class)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class PedidoImpl implements PedidoServ {

    @EJB
    private PedidoLocal local;

    @Override
    public List<Pedido> listarPedido() {
        List<SpmPedido> result = local.listarPedido();
        return PedidoMapper.mapperToPedidoList(result);
    }

    @Override
    public void crearPedido(Pedido value) {
        SpmPedido entity = PedidoMapper.mapperToSpmPedido(value);
        local.crearPedido(entity);
    }

    @Override
    public void editarPedido(Pedido value) {
        SpmPedido entity = PedidoMapper.mapperToSpmPedido(value);
        local.editarPedido(entity);
    }

    @Override
    public void borrarPedido(Pedido value) {
        SpmPedido entity = PedidoMapper.mapperToSpmPedido(value);
        local.borrarPedido(entity);
    }
}
