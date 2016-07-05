package py.edu.facitec.l3.movimiento;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextField;

import py.edu.facitec.l3.dao.ClienteDao;
import py.edu.facitec.l3.dao.ProductoDao;
import py.edu.facitec.l3.model.Cliente;
import py.edu.facitec.l3.model.Producto;

import java.awt.Panel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormularioDevolucion extends JDialog {
	private JTextField tfCodigoCliente_devolucion;
	private JTextField tfNombreCliente_devolucion;
	private JTextField tfFecha;
	private JTextField tfCodigoProducto_devolucion;
	private JTextField tfDescripcionProducto_devolucion;
	private JTextField tfPrecioProducto_devolucion;
	private JTextField tfStockProducto_devolucion;
	private JTextField tfStockActualProducto_devolucion;
	private JTextField tfDireccionCliente_devolucion;
	private JTextField tfRucCliente_devolucion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormularioDevolucion dialog = new FormularioDevolucion();
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
	public FormularioDevolucion() {
		getContentPane().setBackground(new Color(60, 179, 113));
		setBounds(100, 100, 730, 454);
		getContentPane().setLayout(null);
		
		JLabel lblFacturaDeProductos = new JLabel("REGISTROS");
		lblFacturaDeProductos.setBackground(Color.WHITE);
		lblFacturaDeProductos.setForeground(Color.WHITE);
		lblFacturaDeProductos.setFont(new Font("Dialog", Font.BOLD, 30));
		lblFacturaDeProductos.setBounds(248, 0, 191, 54);
		getContentPane().add(lblFacturaDeProductos);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(46, 139, 87));
		panel.setBounds(10, 96, 481, 118);
		getContentPane().add(panel);
		
		JLabel label = new JLabel("Cliente");
		label.setForeground(new Color(255, 250, 250));
		label.setFont(new Font("Dialog", Font.BOLD, 15));
		label.setBounds(153, 11, 174, 14);
		panel.add(label);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setForeground(new Color(255, 250, 250));
		lblCodigo.setFont(new Font("Dialog", Font.BOLD, 13));
		lblCodigo.setBounds(10, 43, 65, 14);
		panel.add(lblCodigo);
		
		tfCodigoCliente_devolucion = new JTextField();
		tfCodigoCliente_devolucion.addMouseListener(new MouseAdapter() {
			
		});
		tfCodigoCliente_devolucion.addKeyListener(new KeyAdapter() {
			
		});
		tfCodigoCliente_devolucion.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfCodigoCliente_devolucion.setColumns(10);
		tfCodigoCliente_devolucion.setBounds(69, 40, 46, 20);
		panel.add(tfCodigoCliente_devolucion);
		
		tfNombreCliente_devolucion = new JTextField();
		tfNombreCliente_devolucion.setBackground(new Color(255, 250, 250));
		tfNombreCliente_devolucion.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfNombreCliente_devolucion.setColumns(10);
		tfNombreCliente_devolucion.setBounds(264, 43, 189, 20);
		panel.add(tfNombreCliente_devolucion);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNombre.setForeground(new Color(255, 250, 250));
		lblNombre.setBounds(193, 46, 72, 14);
		panel.add(lblNombre);
		
		JLabel lblRuc = new JLabel("Ruc:");
		lblRuc.setFont(new Font("Dialog", Font.BOLD, 13));
		lblRuc.setForeground(new Color(255, 250, 250));
		lblRuc.setBounds(257, 91, 46, 14);
		panel.add(lblRuc);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n:");
		lblDireccin.setForeground(new Color(255, 250, 250));
		lblDireccin.setFont(new Font("Dialog", Font.BOLD, 13));
		lblDireccin.setBounds(10, 91, 65, 14);
		panel.add(lblDireccin);
		
		tfDireccionCliente_devolucion = new JTextField();
		tfDireccionCliente_devolucion.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfDireccionCliente_devolucion.setBounds(85, 88, 152, 20);
		panel.add(tfDireccionCliente_devolucion);
		tfDireccionCliente_devolucion.setColumns(10);
		
		tfRucCliente_devolucion = new JTextField();
		tfRucCliente_devolucion.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfRucCliente_devolucion.setBounds(301, 89, 152, 20);
		panel.add(tfRucCliente_devolucion);
		tfRucCliente_devolucion.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(46, 139, 87));
		panel_1.setBounds(10, 239, 687, 152);
		getContentPane().add(panel_1);
		
		JLabel lblCodigo_1 = new JLabel("Codigo");
		lblCodigo_1.setForeground(new Color(255, 250, 250));
		lblCodigo_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblCodigo_1.setBounds(10, 43, 57, 14);
		panel_1.add(lblCodigo_1);
		
		tfCodigoProducto_devolucion = new JTextField();
		tfCodigoProducto_devolucion.addKeyListener(new KeyAdapter() {
			
		});
		tfCodigoProducto_devolucion.setBackground(new Color(255, 250, 250));
		tfCodigoProducto_devolucion.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfCodigoProducto_devolucion.setColumns(10);
		tfCodigoProducto_devolucion.setBounds(10, 64, 46, 20);
		panel_1.add(tfCodigoProducto_devolucion);
		
		JLabel label_3 = new JLabel("Descripcion");
		label_3.setForeground(new Color(255, 250, 250));
		label_3.setFont(new Font("Dialog", Font.BOLD, 13));
		label_3.setBounds(77, 43, 115, 14);
		panel_1.add(label_3);
		
		tfDescripcionProducto_devolucion = new JTextField();
		tfDescripcionProducto_devolucion.setBackground(new Color(255, 250, 250));
		tfDescripcionProducto_devolucion.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfDescripcionProducto_devolucion.setColumns(10);
		tfDescripcionProducto_devolucion.setBounds(77, 64, 246, 20);
		panel_1.add(tfDescripcionProducto_devolucion);
		
		JLabel label_4 = new JLabel("Precio Compra");
		label_4.setForeground(new Color(255, 250, 250));
		label_4.setFont(new Font("Dialog", Font.BOLD, 13));
		label_4.setBounds(10, 102, 126, 14);
		panel_1.add(label_4);
		
		tfPrecioProducto_devolucion = new JTextField();
		tfPrecioProducto_devolucion.setBackground(new Color(255, 250, 250));
		tfPrecioProducto_devolucion.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfPrecioProducto_devolucion.setColumns(10);
		tfPrecioProducto_devolucion.setBounds(10, 122, 143, 20);
		panel_1.add(tfPrecioProducto_devolucion);
		
		tfStockProducto_devolucion = new JTextField();
		tfStockProducto_devolucion.setBackground(new Color(255, 250, 250));
		tfStockProducto_devolucion.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfStockProducto_devolucion.setColumns(10);
		tfStockProducto_devolucion.setBounds(178, 122, 84, 20);
		panel_1.add(tfStockProducto_devolucion);
		
		JLabel lblStockAnterior = new JLabel("Stock Anterior");
		lblStockAnterior.setForeground(new Color(255, 250, 250));
		lblStockAnterior.setFont(new Font("Dialog", Font.BOLD, 13));
		lblStockAnterior.setBounds(176, 102, 96, 14);
		panel_1.add(lblStockAnterior);
		
		tfStockActualProducto_devolucion = new JTextField();
		tfStockActualProducto_devolucion.setBackground(new Color(255, 250, 250));
		tfStockActualProducto_devolucion.setFont(new Font("Tahoma", Font.BOLD, 12));
		tfStockActualProducto_devolucion.setColumns(10);
		tfStockActualProducto_devolucion.setBounds(415, 64, 102, 20);
		panel_1.add(tfStockActualProducto_devolucion);
		
		JLabel lblStockActual = new JLabel("Stock Actual");
		lblStockActual.setForeground(new Color(255, 250, 250));
		lblStockActual.setFont(new Font("Dialog", Font.BOLD, 13));
		lblStockActual.setBounds(415, 30, 84, 14);
		panel_1.add(lblStockActual);
		
		JLabel lblDatoProductos = new JLabel("Dato De Productos");
		lblDatoProductos.setForeground(new Color(255, 250, 250));
		lblDatoProductos.setFont(new Font("Dialog", Font.BOLD, 15));
		lblDatoProductos.setBounds(10, 11, 202, 21);
		panel_1.add(lblDatoProductos);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(new Color(46, 139, 87));
		panel_2.setBounds(10, 10, 181, 54);
		getContentPane().add(panel_2);
		
		JLabel lblNFactura = new JLabel("Fecha Registro");
		panel_2.add(lblNFactura);
		lblNFactura.setForeground(new Color(255, 250, 250));
		lblNFactura.setFont(new Font("Dialog", Font.BOLD, 13));
		
		tfFecha = new JTextField();
		panel_2.add(tfFecha);
		tfFecha.setColumns(10);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(501, 96, 132, 44);
		getContentPane().add(btnBuscar);
		btnBuscar.setForeground(Color.BLACK);
		btnBuscar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				buscarCliente(Integer.parseInt(tfCodigoCliente_devolucion.getText()));
				CalcularStock();
				fecha_hora();
			}
		});
		btnBuscar.setFont(new Font("Dialog", Font.BOLD, 15));
		btnBuscar.setBackground(Color.LIGHT_GRAY);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				cerrar();
			}
		});
		btnCerrar.setFont(new Font("Dialog", Font.BOLD, 15));
		btnCerrar.setForeground(Color.BLACK);
		btnCerrar.setBackground(Color.LIGHT_GRAY);
		btnCerrar.setBounds(525, 151, 89, 37);
		getContentPane().add(btnCerrar);

	}
	private void buscarCliente(int id) {
		
		Cliente c= ClienteDao.buscarClientePorId(id);
		Producto pr = ProductoDao.buscarProducto(id);
		
		if (c !=null & pr!=null) {
			
			tfNombreCliente_devolucion.setText(c.getNombre());
			tfDireccionCliente_devolucion.setText(c.getDireccion());
			tfRucCliente_devolucion.setText(Integer.toString(c.getRuc()));
		
			tfCodigoProducto_devolucion.setText(Integer.toString(pr.getCodigo()));
			tfDescripcionProducto_devolucion.setText(pr.getDecripcion());
			tfPrecioProducto_devolucion.setText(Integer.toString(pr.getPrecio()));
			tfStockProducto_devolucion.setText(Integer.toString(pr.getStock()));
			
		}else {
			JOptionPane.showMessageDialog(this, "No Existe Cliente Con Ese Codigo");
			tfCodigoCliente_devolucion.requestFocus();
		}

	}
	
	public void CalcularStock(){//Calcula Stock Sumando los Datos ingresados
		
		int stock = Integer.parseInt(tfStockProducto_devolucion.getText());
		int sumar= stock+stock;
		tfStockActualProducto_devolucion.setText(Integer.toString(sumar));
		
	} 
	
	private void fecha_hora() {//Muestra La fecha por Defecto
		
		Calendar cal= Calendar.getInstance();
		String fechaa=cal.get(Calendar.DATE)+"/"+cal.get(Calendar.MONTH)+"/"+cal.get(cal.YEAR);
		this.tfFecha.setText(fechaa);

	}
	
	private void cerrar() {
	    
		this.dispose();

	}
}
