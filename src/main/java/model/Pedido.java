package model;

import java.util.Date;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="pedidos")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer numPed;
	private String tipoComprobante;
	private Date FechaPedido;
	private double total;
	
	@ManyToOne
	private Usuario usuario;
	
	@OneToMany(mappedBy = "pedido")
	List<Carrito> carrito;

	public Pedido() {
	}

	public Pedido(Integer numPed, String tipoComprobante, Date fechaPedido, double total) {
		this.numPed = numPed;
		this.tipoComprobante = tipoComprobante;
		this.FechaPedido = fechaPedido;
		this.total = total;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumPed() {
		return numPed;
	}

	public void setNumPed(Integer numPed) {
		this.numPed = numPed;
	}

	public String getTipoComprobante() {
		return tipoComprobante;
	}

	public void setTipoComprobante(String tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}

	public Date getFechaPedido() {
		return FechaPedido;
	}

	public void setFechaPedido(Date fechaPedido) {
		FechaPedido = fechaPedido;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Carrito> getCarrito() {
		return carrito;
	}

	public void setCarrito(List<Carrito> carrito) {
		this.carrito = carrito;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", numPed=" + numPed + ", tipoComprobante=" + tipoComprobante + ", FechaPedido="
				+ FechaPedido + ", total=" + total + "]";
	}


	
	
}
