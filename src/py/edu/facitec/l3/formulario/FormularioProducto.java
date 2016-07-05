package py.edu.facitec.l3.formulario;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;

import py.edu.facitec.l3.dao.ProductoDao;
import py.edu.facitec.l3.model.Producto;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioProducto extends JDialog {
	private JTextField tfCodigo;
	private JTextField tfDescripcion;
	private JTextField tfPrecio;
	private JTextField tfStock;
	private JButton btnGuardar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioProducto dialog = new FormularioProducto();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public FormularioProducto() {
		getContentPane().setBackground(new Color(60, 179, 113));
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(null);
		
		JLabel lblCodigo = new JLabel("codigo:");
		lblCodigo.setForeground(new Color(245, 255, 250));
		lblCodigo.setBounds(10, 21, 46, 14);
		getContentPane().add(lblCodigo);
		
		JLabel lblDescripcion = new JLabel("descripcion:");
		lblDescripcion.setForeground(new Color(245, 255, 250));
		lblDescripcion.setBounds(10, 99, 89, 14);
		getContentPane().add(lblDescripcion);
		
		JLabel lblPrecio = new JLabel("precio:");
		lblPrecio.setForeground(new Color(245, 255, 250));
		lblPrecio.setBounds(10, 172, 46, 14);
		getContentPane().add(lblPrecio);
		
		JLabel lblStock = new JLabel("stock:");
		lblStock.setForeground(new Color(245, 255, 250));
		lblStock.setBounds(10, 237, 46, 14);
		getContentPane().add(lblStock);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(46, 139, 87));
		panel.setBounds(10, 311, 564, 39);
		getContentPane().add(panel);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(Color.LIGHT_GRAY);
		btnGuardar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				guardarProducto();
			}
		});
		
		panel.add(btnGuardar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBackground(Color.LIGHT_GRAY);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				modificarProducto();
			}
		});
		panel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(Color.LIGHT_GRAY);
		btnEliminar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				eliminarProductoPorCodigo();
				limpiarCampos();
			}
		});
		panel.add(btnEliminar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				cerra();
			}
		});
		btnCerrar.setBackground(Color.LIGHT_GRAY);
		panel.add(btnCerrar);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(53, 18, 46, 20);
		getContentPane().add(tfCodigo);
		tfCodigo.setColumns(10);
		
		tfDescripcion = new JTextField();
		tfDescripcion.setBounds(89, 96, 153, 20);
		getContentPane().add(tfDescripcion);
		tfDescripcion.setColumns(10);
		
		tfPrecio = new JTextField();
		tfPrecio.setBounds(49, 169, 86, 20);
		getContentPane().add(tfPrecio);
		tfPrecio.setColumns(10);
		
		tfStock = new JTextField();
		tfStock.setBounds(49, 234, 86, 20);
		getContentPane().add(tfStock);
		tfStock.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(Color.LIGHT_GRAY);
		btnBuscar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				buscarProducto(Integer.parseInt(tfCodigo.getText()));
			}
		});
		btnBuscar.setBounds(99, 17, 89, 23);
		getContentPane().add(btnBuscar);

	}
	
	private void guardarProducto() {
		// si esta vacio el Campo de tex Descripcion
		//muestra un menasje
		if (tfDescripcion.getText().isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "Ingrese Descripción Del Producto");
			tfDescripcion.requestFocus();
			
		}else if (tfPrecio.getText().isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "Ingrese Precio Del Producto");
			tfPrecio.requestFocus();//Gana el foco y se posiciona sobre ese campo
			
		}else{
			
			Producto producto = new Producto();
			
			producto.setDecripcion(tfDescripcion.getText());
			producto.setPrecio(Integer.parseInt(tfPrecio.getText()));
			producto.setStock(Integer.parseInt(tfStock.getText()));
			
			ProductoDao.guardarProducto(producto);
			JOptionPane.showMessageDialog(this, " Se Ha Guardado El Producto " , "Aviso",1);
		}
	}
	
	private void buscarProducto(int id) {
			
			Producto p = ProductoDao.buscarProducto(id);
			
			if (p != null) {
				
				tfDescripcion.setText(p.getDecripcion());
				tfPrecio.setText(Integer.toString(p.getPrecio()));
				tfStock.setText(Integer.toString(p.getStock()));
				
			}else {
				JOptionPane.showMessageDialog(this,
						"No Existe Producto Con esa Desripcion","Aviso",1);
				limpiarCampos();
				tfCodigo.requestFocus();
			}
	}
	
	private void modificarProducto() {
		
		Producto producto = new Producto();
		
		producto.setCodigo(Integer.parseInt(tfCodigo.getText()));
		producto.setDecripcion(tfDescripcion.getText());
		producto.setPrecio(Integer.parseInt(tfPrecio.getText()));
		producto.setStock(Integer.parseInt(tfStock.getText()));
				
		ProductoDao.modificarProducto(producto);
		JOptionPane.showMessageDialog(this, " Se Ha Modificado El Producto " , "Aviso",1);
	}
	
	private void eliminarProductoPorCodigo() {
		
		if (tfCodigo.getText().isEmpty()) {
			
			JOptionPane.showMessageDialog(this, "Introduzca Codigo del Producto","Aviso", 3);
			tfCodigo.requestFocus();
			
		}else {
			int si = JOptionPane.showConfirmDialog(this, "Esta seguro de que desea eliminar el Producto","Aviso",
					JOptionPane.YES_NO_OPTION);
		if (si==0) {
			
			int productoId = Integer.parseInt(tfCodigo.getText());
			ProductoDao.eliminarProductoPorCodigo(productoId);
			JOptionPane.showMessageDialog(this, "Se Ha Eliminado El Producto");
			
		}else {
			limpiarCampos();
		}
	  }
	}
	
	private void limpiarCampos() {
		
		tfCodigo.selectAll();
		tfCodigo.requestFocus();
		tfDescripcion.setText("");
		tfPrecio.setText("");
		tfStock.setText("");
		
		
	}
	
	private void cerra() {
		
		this.dispose();

	}
}
