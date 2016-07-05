package py.edu.facitec.l3.model;
/*
 * 
 * @author franciscoLopez
 * 
 * */

public class Devolucion extends Producto{
	private int factura;
	private String fecha;
	private int stockactual;
	
	public Devolucion() {
		super();
		this.factura=0;
		this.fecha="";
		this.stockactual=0;
	}

	public Devolucion(int factura, String fecha, int stockactual) {
		super();
		this.factura = factura;
		this.fecha = fecha;
		this.stockactual = stockactual;
	}

	public int getFactura() {
		return factura;
	}

	public void setFactura(int factura) {
		this.factura = factura;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getStockactual() {
		return stockactual;
	}

	public void setStockactual(int stockactual) {
		this.stockactual = stockactual;
	}

	@Override
	public String toString() {
		return "Devolucion [factura=" + factura + ", fecha=" + fecha + ", stockactual=" + stockactual + "]";
	}

	
}
