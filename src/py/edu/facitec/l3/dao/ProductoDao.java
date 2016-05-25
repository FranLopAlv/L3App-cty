package py.edu.facitec.l3.dao;

import java.sql.SQLException;

import py.edu.facitec.l3.model.Producto;
import py.edu.facitec.l3.util.ConexionManager;

public class ProductoDao {
	public static void guardarProducto(Producto producto) {
		String sql ="insert into  db_productos(descripcion,stock,precio) "
				+ "values ('"+producto.getDescripcion()+"' , "+producto.getStock()+" , "+producto.getPrecio()+")";
		
		System.out.println(sql);
		ConexionManager.abrirConexion();
		
		try {
			ConexionManager.stm.executeUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		ConexionManager.cerrarConexion();
	}

}
