package service;

import java.util.Optional;

import model.Usuario;

public interface UsuarioService {
	Optional<Usuario> findById(Integer id);
	Usuario save(Usuario usuario);
	Optional<Usuario> findByEmail(String email);

}
