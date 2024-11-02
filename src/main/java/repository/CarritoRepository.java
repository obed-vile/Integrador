package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import model.Carrito;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Integer> {

}
