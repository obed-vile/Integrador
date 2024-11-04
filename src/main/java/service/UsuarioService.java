package service;

import model.Usuario;
import java.util.Optional;

public interface UsuarioService {
    
    Usuario saveUsuario(Usuario usuario);
    Optional<Usuario> findUsuarioById(Integer id);
    Optional<Usuario> findUsuarioByEmail(String correo);
    void deleteUsuarioById(Integer id);
}
