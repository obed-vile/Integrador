package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import model.Carrito;

public interface CarritoRepository extends JpaRepository<Carrito, Integer> {
    // Métodos personalizados, si son necesarios
}
