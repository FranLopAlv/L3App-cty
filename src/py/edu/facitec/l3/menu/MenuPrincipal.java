package py.edu.facitec.l3.menu;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.EmptyBorder;

import py.edu.facitec.l3.formulario.FormularioCliente;
import py.edu.facitec.l3.formulario.FormularioProducto;
import py.edu.facitec.l3.movimiento.FormularioDevolucion;

import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Panel;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal dialog = new MenuPrincipal();
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
	public MenuPrincipal() {
		getContentPane().setBackground(new Color(143, 188, 143));
		setBounds(100, 100, 648, 341);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnRegistros = new JMenu("Registros");
		mnRegistros.setBackground(new Color(46, 139, 87));
		menuBar.add(mnRegistros);
		
		JMenuItem mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				verFormularioCliente();
			}
		});
		mnRegistros.add(mntmClientes);
		
		JMenuItem mntmProductos = new JMenuItem("Productos");
		mntmProductos.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				verFormularioProducto();//Visualizar FormularioProducto
			}
		});
		mnRegistros.add(mntmProductos);
		
		JMenu mnMovimiento = new JMenu("Movimiento");
		menuBar.add(mnMovimiento);
		
		JMenuItem mntmDevolucion = new JMenuItem("Devolucion");
		mntmDevolucion.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				verFormularioDevolucion();//Visualizar el Formulario Devolucion
			}
		});
		mnMovimiento.add(mntmDevolucion);
		
		JMenu mnCerrar = new JMenu("Cerrar");
		menuBar.add(mnCerrar);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				cerrar();//Cierra La Ventana MenuPrincipal
			}
		});
		mnCerrar.add(mntmSalir);

	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
	
	private void verFormularioCliente() {
		
		FormularioCliente frmCliente= new FormularioCliente();
		frmCliente.setVisible(true);
		
	}
	
	private void verFormularioProducto() {
		
		FormularioProducto frmProducto= new FormularioProducto();
		frmProducto.setVisible(true);
		
	}
	
	private void verFormularioDevolucion() {
		
		FormularioDevolucion frmDevolucion= new FormularioDevolucion();
		frmDevolucion.setVisible(true);

	}
	
	private void cerrar() {
		
		this.dispose();

	}
}
