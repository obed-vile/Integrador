package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    // Puedes agregar métodos personalizados aquí, si es necesario
}
