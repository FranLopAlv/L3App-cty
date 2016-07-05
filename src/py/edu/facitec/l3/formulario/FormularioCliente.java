package py.edu.facitec.l3.formulario;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import py.edu.facitec.l3.dao.ClienteDao;
import py.edu.facitec.l3.model.Cliente;
import py.edu.facitec.l3.util.ConexionManager;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioCliente extends JDialog {
	private JTextField tfNombre;
	private JTextField tfDireccion;
	private JTextField tfRuc;
	private JTextField tfCodigo;
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
					FormularioCliente dialog = new FormularioCliente();
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
	public FormularioCliente() {
		getContentPane().setBackground(new Color(60, 179, 113));
		setBounds(100, 100, 601, 400);
		getContentPane().setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setForeground(new Color(245, 255, 250));
		lblCodigo.setBounds(10, 17, 46, 14);
		getContentPane().add(lblCodigo);
		
		JLabel lblNombreDelCliente = new JLabel("Nombre Del Cliente:");
		lblNombreDelCliente.setForeground(new Color(245, 255, 250));
		lblNombreDelCliente.setBounds(10, 85, 127, 14);
		getContentPane().add(lblNombreDelCliente);
		
		JLabel lblRuc = new JLabel("Ruc:");
		lblRuc.setForeground(new Color(245, 255, 250));
		lblRuc.setBounds(282, 17, 46, 14);
		getContentPane().add(lblRuc);
		
		JLabel lblDirecci = new JLabel("Direcci\u00F3n:");
		lblDirecci.setForeground(new Color(245, 255, 250));
		lblDirecci.setBounds(10, 161, 68, 14);
		getContentPane().add(lblDirecci);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(128, 82, 200, 20);
		getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		tfDireccion = new JTextField();
		tfDireccion.setBounds(76, 158, 298, 73);
		getContentPane().add(tfDireccion);
		tfDireccion.setColumns(10);
		
		tfRuc = new JTextField();
		tfRuc.setBounds(320, 14, 146, 20);
		getContentPane().add(tfRuc);
		tfRuc.setColumns(10);
		
		tfCodigo = new JTextField();
		tfCodigo.setBounds(56, 14, 62, 20);
		getContentPane().add(tfCodigo);
		tfCodigo.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(46, 139, 87));
		panel.setBounds(10, 311, 564, 39);
		getContentPane().add(panel);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setForeground(Color.BLACK);
		btnGuardar.setBackground(Color.LIGHT_GRAY);
		btnGuardar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				guardarCliente();
			}
		});
		panel.add(btnGuardar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setForeground(Color.BLACK);
		btnModificar.setBackground(Color.LIGHT_GRAY);
		btnModificar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				modificarCliente();
			}
		});
		panel.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setBackground(Color.LIGHT_GRAY);
		btnEliminar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				EliminarClientePorID();
				limpiarCampos();
			}
		});
		panel.add(btnEliminar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.setForeground(Color.BLACK);
		btnCerrar.setBackground(Color.LIGHT_GRAY);
		btnCerrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				cerrar();
			}
		});
		panel.add(btnCerrar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBackground(Color.LIGHT_GRAY);
		btnBuscar.setForeground(new Color(0, 0, 0));
		btnBuscar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				buscarClientePorId(Integer.parseInt(tfCodigo.getText()));
			}
		});
		btnBuscar.setBounds(118, 13, 89, 23);
		getContentPane().add(btnBuscar);

	}
	
	private void guardarCliente() {
		
		if (tfNombre.getText().isEmpty()) {
			
			JOptionPane.showMessageDialog(null, " Ingrese Nombre del Cliente " , "Aviso",2);
			tfNombre.requestFocus();
			
		}else if (tfDireccion.getText().isEmpty()) {
			
			JOptionPane.showMessageDialog(null, " Ingrese Dirección Del Cliente " , "Aviso",2);
			tfDireccion.requestFocus();
			
		}else if (tfRuc.getText().isEmpty()) {
			
			JOptionPane.showMessageDialog(null, " Ingrese Ruc Del Cliente " , "Aviso",2);
			tfRuc.requestFocus();
			
		}else {
			
			Cliente cliente = new Cliente();
			
			cliente.setNombre(tfNombre.getText());
			cliente.setDireccion(tfDireccion.getText());
			cliente.setRuc(Integer.parseInt(tfRuc.getText()));
			
			ClienteDao.guardarCliente(cliente);
			JOptionPane.showMessageDialog(this, " Se Ha Guardado El Cliente " , "Aviso",1);
		}
	}
	
	private void modificarCliente() {
		
		Cliente cliente = new Cliente();
		
		cliente.setCdigo(Integer.parseInt(tfCodigo.getText()));
		cliente.setNombre(tfNombre.getText());
		cliente.setDireccion(tfDireccion.getText());
		cliente.setRuc(Integer.parseInt(tfRuc.getText()));
		
		ClienteDao.modificarCliente(cliente);
		JOptionPane.showMessageDialog(this, " Se Ha Guardado El Cliente " , "Aviso",1);

	}
	
	private void buscarClientePorId(int id) {
		
			Cliente c = ClienteDao.buscarClientePorId(id);
			
			if (c != null) {
				
				tfNombre.setText(c.getNombre());
				tfDireccion.setText(c.getDireccion());
				tfRuc.setText(Integer.toString(c.getRuc()));
				
			}else {
				JOptionPane.showMessageDialog(this,
						"No existe Cliente con Ese Codigo","Aviso",1);
				tfCodigo.requestFocus();
			}
	}
	
	private void EliminarClientePorID() {
		
		if (tfCodigo.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "Introduzca Codigo del Cliente","Aviso", 3);
			tfCodigo.requestFocus();
		}else {
			int si = JOptionPane.showConfirmDialog(this, "Esta seguro de que desea eliminar el Cliente","Aviso",
					JOptionPane.YES_NO_OPTION);
		if (si==0) {
			int clienteID = Integer.parseInt(tfCodigo.getText());
			ClienteDao.EliminarClientePorID(clienteID);
			JOptionPane.showMessageDialog(this, "Se Ha Eliminado El Cliente");
		}else {
			limpiarCampos();
		}
	  }
	}
	
	private void limpiarCampos() {
		
		tfCodigo.selectAll();
		tfCodigo.requestFocus();
		tfNombre.setText("");
		tfDireccion.setText("");
		tfRuc.setText("");

	}
	
	private void cerrar() {
		
		this.dispose();

	}
  }
