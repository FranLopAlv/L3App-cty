package py.edu.facitec.l3.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import py.edu.facitec.l3.model.Cliente;
import py.edu.facitec.l3.model.Producto;
import py.edu.facitec.l3.util.ConexionManager;

public class ClienteDao {
	
	public static void guardarCliente(Cliente cliente) {
		
		String sql = "INSERT INTO tb_clientes(nombre, direccion, ruc ) "
				+ "VALUES ('"+cliente.getNombre()+"' , '"+cliente.getDireccion()+"' , "+cliente.getRuc()+")";

		System.out.println(sql);

		ConexionManager.abrirConexion();
		
		try {
			ConexionManager.stm.executeUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		ConexionManager.cerrarConexion();
	}
	
	public static Cliente buscarClientePorId(int id) {
		
        String sql ="select * from tb_clientes where cdigo = "+id+"; ";
		
		ConexionManager.abrirConexion();
		Cliente cliente= null;
		System.out.println(sql);
		
		try {
			ResultSet rs = ConexionManager.stm.executeQuery(sql);
			
			if (rs.next()) {
				
				cliente = new Cliente();
				cliente.setCdigo(rs.getInt("cdigo"));
				cliente.setNombre(rs.getString("nombre"));
				cliente.setDireccion(rs.getString("direccion"));
				cliente.setRuc(rs.getInt("ruc"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return cliente;
	}
	
	public static void modificarCliente(Cliente cliente) {
		
		String sql = "update tb_clientes set "
				+ "nombre='"+cliente.getNombre()+"',"
				+"direccion='"+cliente.getDireccion()+"',"
				+"ruc="+cliente.getRuc()+" where "
				+"codigo="+cliente.getCdigo()+" ";
		
		System.out.println(sql);
		ConexionManager.abrirConexion();
		
		try {
			ConexionManager.stm.execute(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		ConexionManager.cerrarConexion();
	}
	
	public static void  EliminarClientePorID(int codigo) {
		
         String sql ="delete from tb_clientes where cdigo="+codigo+"";
		
		 ConexionManager.abrirConexion();
		 
		 try {
			ConexionManager.stm.executeUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
