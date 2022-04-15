

package com.propuesta.spm.manager;

import com.propuesta.spm.manager.data.Producto;
import java.util.List;

public interface ProductoServ {

	public List<Producto> listarProducto();

	public void crearProducto(Producto value);

	public void editarProducto(Producto value);

	public void borrarProducto(Producto value);
}
