package py.edu.facitec.l3.formulario;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import py.edu.facitec.l3.dao.ProductoDao;
import py.edu.facitec.l3.model.Producto;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class FormularioProducto extends JDialog {
	private JTextField tfCodigo;
	private JTextField tfPrecio;
	private JTextField tfStock;
	private JTextField tfDescripcion;

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
		getContentPane().setBackground(new Color(128, 128, 128));
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(null);
		
		JLabel lblCodigo = new JLabel("codigo:");
		lblCodigo.setForeground(new Color(250, 250, 210));
		lblCodigo.setBounds(10, 11, 46, 14);
		getContentPane().add(lblCodigo);
		
		JLabel lblDescripcion = new JLabel("descripcion");
		lblDescripcion.setBounds(10, 114, 73, -26);
		getContentPane().add(lblDescripcion);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(52, 8, 46, 20);
		getContentPane().add(tfCodigo);
		tfCodigo.setColumns(10);
		
		tfPrecio = new JTextField();
		tfPrecio.setBounds(76, 86, 144, 20);
		getContentPane().add(tfPrecio);
		tfPrecio.setColumns(10);
		
		JLabel lblPrecio = new JLabel("precio:");
		lblPrecio.setForeground(new Color(250, 250, 210));
		lblPrecio.setBounds(10, 157, 46, 14);
		getContentPane().add(lblPrecio);
		
		tfStock = new JTextField();
		tfStock.setBounds(63, 233, 86, 20);
		getContentPane().add(tfStock);
		tfStock.setColumns(10);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setForeground(new Color(250, 250, 210));
		lblStock.setBounds(10, 236, 46, 14);
		getContentPane().add(lblStock);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(297, 7, 89, 23);
		getContentPane().add(btnBuscar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 250, 205));
		panel.setBounds(10, 311, 564, 39);
		getContentPane().add(panel);
		
		JButton button = new JButton("Guardar");
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				guardarProducto();
			}
			
		});
		
		panel.add(button);
		
		JButton button_1 = new JButton("Modificar");
		panel.add(button_1);
		
		JButton button_2 = new JButton("Eliminar");
		panel.add(button_2);
		
		JButton button_3 = new JButton("Cancelar");
		panel.add(button_3);
		
		JButton button_4 = new JButton("Cerrar");
		panel.add(button_4);
		
		JLabel lblDescripcion_1 = new JLabel("descripcion:");
		lblDescripcion_1.setForeground(new Color(250, 250, 210));
		lblDescripcion_1.setBounds(10, 89, 73, 14);
		getContentPane().add(lblDescripcion_1);
		
		tfDescripcion = new JTextField();
		tfDescripcion.setBounds(76, 154, 144, 20);
		getContentPane().add(tfDescripcion);
		tfDescripcion.setColumns(10);

	}
	private void guardarProducto() {
		
		
		Producto producto = new Producto();
		producto.setDescripcion(tfDescripcion.getText());
		
		producto.setStock(Integer.parseInt(tfStock.getText()));
		producto.setPrecio(Integer.parseInt(tfPrecio.getText()));
		//servicio.getPaciente().setFechaAlta(new Date(sc.next()));*/

		ProductoDao.guardarProducto(producto);
	}
}
