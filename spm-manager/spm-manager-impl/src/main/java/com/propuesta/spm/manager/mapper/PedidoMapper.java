
package com.propuesta.spm.manager.mapper;

import com.propuesta.spm.manager.data.Pedido;
import com.propuesta.spm.model.entity.SpmPedido;
import java.util.ArrayList;
import java.util.List;

public final class PedidoMapper {

    private static void mapperToSpmPedido(Pedido from, SpmPedido to) {
        to.setIdPedido(from.getIdPedido());
        to.setFecha(from.getFecha());
        to.setDescripcion(from.getDescripcion());
    }

    private static void mapperToPedido(SpmPedido from, Pedido to) {
        to.setIdPedido(from.getIdPedido());
        to.setFecha(from.getFecha());
        to.setDescripcion(from.getDescripcion());
    }

    public static Pedido mapperToPedido(SpmPedido from) {
        if (from == null) {
            return null;
        }
        Pedido to = new Pedido();
        mapperToPedido(from, to);
        return to;
    }

    public static List<SpmPedido> mapperToSpmPedidoList(List<Pedido> fromList) {
        if (fromList == null) {
            return null;
        }
        List<SpmPedido> toList = new ArrayList();
        fromList.stream().forEach(from -> {
            SpmPedido to = mapperToSpmPedido(from);
            toList.add(to);
        });
        return toList;
    }

    public static SpmPedido mapperToSpmPedido(Pedido from) {
        if (from == null) {
            return null;
        }
        SpmPedido to = new SpmPedido();
        mapperToSpmPedido(from, to);
        return to;
    }

    public static List<Pedido> mapperToPedidoList(List<SpmPedido> fromList) {
        if (fromList == null) {
            return null;
        }
        List<Pedido> toList = new ArrayList();
        fromList.stream().forEach(from -> {
            Pedido to = mapperToPedido(from);
            toList.add(to);
        });
        return toList;
    }
}
