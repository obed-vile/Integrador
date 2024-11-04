package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import model.Usuario;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	Optional<Usuario> findByCorreo(String correo);
}
