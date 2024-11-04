package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.UsuarioService;
import model.Usuario;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios") // 
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Registro de un nuevo usuario
    @PostMapping("/registro")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
        // Verifica si el usuario ya existe
        if (usuarioService.findUsuarioByEmail(usuario.getCorreo()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null); // El usuario ya existe
        }
        usuario.setRol("cliente"); // Asigna un rol por defecto
        Usuario savedUsuario = usuarioService.saveUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUsuario);
    }

    @PostMapping("/login")
    public void login(@RequestBody Usuario usuario, HttpSession session, HttpServletResponse response) throws IOException {
        Optional<Usuario> user = usuarioService.findUsuarioByEmail(usuario.getCorreo());

        if (user.isPresent() && user.get().getContraseña().equals(usuario.getContraseña())) {
            session.setAttribute("idusuario", user.get().getId());
            response.sendRedirect("/newinicio");  // Redirigir a la página principal
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid credentials"); // Enviar error 401
        }
    }
    
    // Cerrar sesión
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {
        session.invalidate(); // Invalida la sesión
        return ResponseEntity.ok("Logout successful");
    }

    // Obtener usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findUsuarioById(@PathVariable Integer id) {
        Optional<Usuario> usuario = usuarioService.findUsuarioById(id);
        return usuario.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    // Obtener usuario por correo
    @GetMapping("/correo/{correo}")
    public ResponseEntity<Usuario> findUsuarioByEmail(@PathVariable String correo) {
        Optional<Usuario> usuario = usuarioService.findUsuarioByEmail(correo);
        return usuario.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    // Eliminar usuario por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuarioById(@PathVariable Integer id) {
        try {
            usuarioService.deleteUsuarioById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}

