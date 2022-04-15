
package com.propuesta.spm.manager.mapper;

import com.propuesta.spm.manager.data.Producto;
import com.propuesta.spm.model.entity.SpmProducto;
import java.util.ArrayList;
import java.util.List;

public final class ProductoMapper {

    private static void mapperToSpmProducto(Producto from, SpmProducto to) {
        to.setIdProducto(from.getIdProducto());
        to.setNombre(from.getNombre());
    }

    private static void mapperToProducto(SpmProducto from, Producto to) {
        to.setIdProducto(from.getIdProducto());
        to.setNombre(from.getNombre());
    }

    public static Producto mapperToProducto(SpmProducto from) {
        if (from == null) {
            return null;
        }
        Producto to = new Producto();
        mapperToProducto(from, to);
        return to;
    }

    public static List<SpmProducto> mapperToSpmProductoList(List<Producto> fromList) {
        if (fromList == null) {
            return null;
        }
        List<SpmProducto> toList = new ArrayList();
        fromList.stream().forEach(from -> {
            SpmProducto to = mapperToSpmProducto(from);
            toList.add(to);
        });
        return toList;
    }

    public static SpmProducto mapperToSpmProducto(Producto from) {
        if (from == null) {
            return null;
        }
        SpmProducto to = new SpmProducto();
        mapperToSpmProducto(from, to);
        return to;
    }

    public static List<Producto> mapperToProductoList(List<SpmProducto> fromList) {
        if (fromList == null) {
            return null;
        }
        List<Producto> toList = new ArrayList();
        fromList.stream().forEach(from -> {
            Producto to = mapperToProducto(from);
            toList.add(to);
        });
        return toList;
    }
}
