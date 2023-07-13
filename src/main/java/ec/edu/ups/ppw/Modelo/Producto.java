package ec.edu.ups.ppw.Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Producto {
	
	@Id
	@GeneratedValue
	@Column(name="id_Producto")
	private int codigo;
	
	@Column(name="pro_Nombre", nullable=false)
	private String nombre;
	
	@Column(name="pro_Descripcion", nullable=false)
	private String descripcion;
	
	@Column(name="pro_precio")
	private float precio;

	public int getId_Producto() {
		return codigo;
	}

	public void setId_Producto(int id_Producto) {
		this.codigo = id_Producto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
}
