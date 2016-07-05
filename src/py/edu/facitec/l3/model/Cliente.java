package py.edu.facitec.l3.model;
/*
 * 
 * @author franciscoLopez
 * 
 * */
public class Cliente {
	
	private int cdigo;
	private String nombre;
	private String direccion;
	private int ruc;
	
	public Cliente() {
		super();
		this.cdigo=0;
		this.nombre="";
		this.direccion="";
		this.ruc=0;
	}

	public Cliente(int cdigo, String nombre, String direccion, int ruc) {
		super();
		this.cdigo = cdigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.ruc = ruc;
	}

	public int getCdigo() {
		return cdigo;
	}

	public void setCdigo(int cdigo) {
		this.cdigo = cdigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getRuc() {
		return ruc;
	}

	public void setRuc(int ruc) {
		this.ruc = ruc;
	}
	
}
