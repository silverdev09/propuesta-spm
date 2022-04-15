
package com.propuesta.spm.manager;

import com.propuesta.spm.manager.data.Pedido;
import java.util.List;

public interface PedidoServ {

	public List<Pedido> listarPedido();

	public void crearPedido(Pedido value);

	public void editarPedido(Pedido value);

	public void borrarPedido(Pedido value);
}
