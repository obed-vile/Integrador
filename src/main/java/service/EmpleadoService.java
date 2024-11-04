package service;

import model.Empleado;

import java.util.List;
import java.util.Optional;

public interface EmpleadoService {

    Empleado saveEmpleado(Empleado empleado);
    Optional<Empleado> findEmpleadoById(Integer id);
    Optional<Empleado> findEmpleadoByEmail(String correo);
    List<Empleado> getAllEmpleados();
    void deleteEmpleadoById(Integer id);
}
