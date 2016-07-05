package py.edu.facitec.l3.model;
/*
 * 
 * @author franciscoLopez
 * 
 * */
public class Producto {
	//Inicializar los atributos
	private int codigo;
	private String decripcion;
	private int precio;
	private int stock;
	
	public Producto() {//ConstructorPor Defecto
		super();
		this.codigo=0;
		this.decripcion="";
		this.precio=0;
		this.stock=0;
	}
    //ConstructorPorParametros
	public Producto(int codigo, String decripcion, int precio, int stock) {
		super();
		this.codigo = codigo;
		this.decripcion = decripcion;
		this.precio = precio;
		this.stock = stock;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDecripcion() {
		return decripcion;
	}
	public void setDecripcion(String decripcion) {
		this.decripcion = decripcion;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", decripcion=" + decripcion + ", precio=" + precio + ", stock=" + stock
				+ "]";
	}
	
}
