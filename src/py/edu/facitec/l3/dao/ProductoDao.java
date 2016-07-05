package py.edu.facitec.l3.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import py.edu.facitec.l3.model.Producto;
import py.edu.facitec.l3.util.ConexionManager;

/*
 * 
 * @author fran lopez
 * esta clase sera responsable por el acceso
 * a datos en ça tabla clientes
 * */

public class ProductoDao {
	
	public static void guardarProducto(Producto producto) {
		
		String sql = "INSERT INTO tb_producto(descripcion, precio, stock)"
			 + " VALUES ('"+producto.getDecripcion()+"' ,"
			 + " "+producto.getPrecio()+" , "
			 + ""+producto.getStock()+")";
		
		System.out.println(sql);
		ConexionManager.abrirConexion();
		
		try {
			ConexionManager.stm.executeUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		ConexionManager.cerrarConexion();
	}
	
	public static Producto buscarProducto(int id) {
		
		String sql ="select * from tb_producto where codigo = "+id+"; ";
		
		ConexionManager.abrirConexion();
		Producto producto= null;
		System.out.println(sql);
		
		try {
			//executar el sql que montamos contra la base de datos devolviendo resultado
			ResultSet rs = ConexionManager.stm.executeQuery(sql);
			
			//si tiene un resultado
			if (rs.next()) {
				
				producto = new Producto();//instancio mi clase, para crear objeto
				
				producto.setCodigo(rs.getInt("codigo"));
				producto.setDecripcion(rs.getString("descripcion"));
				producto.setPrecio(rs.getInt("precio"));
				producto.setStock(rs.getInt("stock"));
				
			}
		} catch (SQLException e) {
		    
			e.printStackTrace();
		}
		return producto;
	}
	
	public static void modificarProducto(Producto producto) {
		
		String sql = "update tb_producto set "
				+ "descripcion='"+producto.getDecripcion()+"',"
				+"precio="+producto.getPrecio()+", "
				+"stock="+producto.getStock()+" where "
				+"codigo="+producto.getCodigo()+" ";
					
	    System.out.println(sql);
	    ConexionManager.abrirConexion();
	    
	    try {
			ConexionManager.stm.execute(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	    ConexionManager.cerrarConexion();
	}
	
	public static void eliminarProductoPorCodigo(int codigo) {
		
		String sql ="delete from tb_producto where codigo="+codigo+"";
		
		ConexionManager.abrirConexion();
		
		try {
			ConexionManager.stm.executeUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
}
