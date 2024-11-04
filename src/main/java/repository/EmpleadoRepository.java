package repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
	Optional<Empleado> findByCorreo(String correo);
}
