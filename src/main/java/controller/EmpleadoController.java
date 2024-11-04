package controller;

import model.Empleado;
import service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/administracion")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    @Autowired
    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    // Crear un nuevo empleado
    @PostMapping
    public ResponseEntity<Empleado> saveEmpleado(@RequestBody Empleado empleado) {
        Empleado savedEmpleado = empleadoService.saveEmpleado(empleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmpleado);
    }

    @PostMapping("/login")
    public void login(@RequestBody Empleado empleado, HttpSession session, HttpServletResponse response) throws IOException {
        Optional<Empleado> emp = empleadoService.findEmpleadoByEmail(empleado.getCorreo());

        if (emp.isPresent() && emp.get().getContraseña().equals(empleado.getContraseña())) {
            session.setAttribute("idempleado", emp.get().getId());
            response.sendRedirect("/perfil");  // Redirigir a la página principal
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Invalid credentials"); // Enviar error 401
        }
    }


    // Obtener todos los empleados
    @GetMapping
    public ResponseEntity<List<Empleado>> getAllEmpleados() {
        List<Empleado> empleados = empleadoService.getAllEmpleados();
        return ResponseEntity.ok(empleados);
    }

    // Obtener empleado por ID
    @GetMapping("/{id}")
    public ResponseEntity<Empleado> findEmpleadoById(@PathVariable Integer id) {
        Optional<Empleado> empleado = empleadoService.findEmpleadoById(id);
        return empleado.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    // Obtener empleado por correo
    @GetMapping("/correo/{correo}")
    public ResponseEntity<Empleado> findEmpleadoByEmail(@PathVariable String correo) {
        Optional<Empleado> empleado = empleadoService.findEmpleadoByEmail(correo);
        return empleado.map(ResponseEntity::ok)
                       .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    // Eliminar empleado por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmpleadoById(@PathVariable Integer id) {
        try {
            empleadoService.deleteEmpleadoById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
