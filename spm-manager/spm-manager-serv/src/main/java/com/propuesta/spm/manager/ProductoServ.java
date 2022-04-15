
package com.propuesta.spm.manager;

import bo.union.lang.ServiceException;
import com.propuesta.spm.manager.data.Producto;
import com.propuesta.spm.manager.filter.ProductoFtr;
import java.util.List;

public interface ProductoServ {

	public List<Producto> listarProducto(ProductoFtr filter) throws ServiceException;

	public void crearProducto(Producto value);

	public void editarProducto(Producto value);

	public void borrarProducto(Producto value);
}
