
package com.propuesta.spm.tools.mapper;

import com.propuesta.spm.manager.data.ParamValue;
import com.propuesta.spm.manager.data.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sipaco
 */
public class SerializaObjeto {

    public static ParamValue mapperToParamValue(Object obj) {
        ParamValue value = new ParamValue();
        if (obj instanceof Producto) {
            value.setValue(((Producto) obj).getIdProducto());
            value.setDescription(((Producto) obj).getNombre());
        }
        return value;
    }
    
    public static List<ParamValue> mapperToListParamValue (List<Producto> list) {
        List<ParamValue> result = new ArrayList<>();
        list.stream().forEach(obj -> {
            result.add(mapperToParamValue(obj));
        });
        return result;
    }
}
