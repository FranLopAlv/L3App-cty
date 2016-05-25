package py.edu.facitec.l3.model;

import java.util.Date;

public class Producto {
	
	private int codigo;
	private String descripcion;
	private int stock;
	private int precio;
	private Date fecha_registro;
	
	
	public Producto() {
		super();
		this.codigo=0;
		this.descripcion="";
		this.stock=0;
		this.precio=0;
		this.fecha_registro= new Date();
	}
	
	public Producto(int codigo, String descripcion, int stock, int precio, Date fecha_registro) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.stock = stock;
		this.precio = precio;
		this.fecha_registro = fecha_registro;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}
    

	

}
