package py.edu.facitec.l3.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import py.edu.facitec.l3.model.Cliente;
import py.edu.facitec.l3.model.Devolucion;
import py.edu.facitec.l3.util.ConexionManager;

public class DevolucionDao {
	
	public static void guardarDevolucion(Devolucion devolucion) {
		
		String sql = "INSERT INTO tb_producto(dev_factura, dev_fecha, dev_stockActual)"
				 + " VALUES ("+devolucion.getFactura()+" , "
				 + "'"+devolucion.getFecha()+"' "
				 + ", "+devolucion.getStockactual()+")";
			
			System.out.println(sql);
			ConexionManager.abrirConexion();
			
			try {
				ConexionManager.stm.executeUpdate(sql);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			ConexionManager.cerrarConexion();
	}
	public static Devolucion buscarClientePorId(int id) {
		
		String sql = "SELECT * FROM bd_producto  WHERE codigo = "+id+" ";
		System.out.println(sql);

		ConexionManager.abrirConexion();
		Devolucion devolucion=null;
		
		try {
			ResultSet rs= ConexionManager.stm.executeQuery(sql);
			if (rs.next()) {
				
				devolucion= new Devolucion();
				devolucion.setFactura(rs.getInt("dev_factura"));
				devolucion.setFecha(rs.getString("dev_fecha"));
				devolucion.setStockactual(rs.getInt("dev_stockActual"));
				devolucion.setDecripcion(rs.getString("Descripcion"));
				devolucion.setPrecio(rs.getInt("precio"));
				devolucion.setStock(rs.getInt("stock"));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		ConexionManager.cerrarConexion();
		return devolucion;
	}

}
