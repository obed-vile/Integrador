package service;

import model.Empleado;
import repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImp implements EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoServiceImp(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public Empleado saveEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public Optional<Empleado> findEmpleadoById(Integer id) {
        return empleadoRepository.findById(id);
    }

    @Override
    public Optional<Empleado> findEmpleadoByEmail(String correo) {
        return empleadoRepository.findByCorreo(correo);
    }

    @Override
    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public void deleteEmpleadoById(Integer id) {
        empleadoRepository.deleteById(id);
    }
}
