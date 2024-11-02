package service;


import java.util.List;
import java.util.Optional;

import model.Pedido;
import model.Usuario;

public interface PedidoService {
	
	List<Pedido> findAll();
	Optional<Pedido> findById(Integer id);
	Pedido save (Pedido orden);
	String generarNumeroOrden();
	List<Pedido> findByUsuario (Usuario usuario);

}
