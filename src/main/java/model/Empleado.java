package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="empleados")
public class Empleado extends Usuario{
	
	private String puesto;
	private double salario;
	
	public Empleado() {
	}

	public Empleado(String nombre, String apellido, String direccion, int telefono, int dni, String correo, String contraseña, 
            String puesto, double salario ) {
	super(nombre, apellido, direccion, telefono, dni, correo, contraseña);
	this.puesto = puesto;
	this.salario = salario;

	}


	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
    @Override
    public String toString() {
        return "Empleado [id=" + getId() + ", nombre=" + getNombre() + ", apellido=" + getApellido() + ", direccion=" 
                + getDireccion() + ", telefono=" + getTelefono() + ", dni=" + getDni() + ", correo=" + getCorreo() 
                + ", contraseña=" + getContraseña() +  ", puesto=" + puesto + ", salario=" + salario 
                +  "]";
    }

}
