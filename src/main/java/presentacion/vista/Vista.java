package presentacion.vista;

import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import persistencia.conexion.Conexion;

public class Vista {

	private JFrame frame;
	private JTable tablaPersonas;
	private JTable tablaLocalidades;
	private JTable tablaTipoDeContactos;
	private JButton btnAgregarPersona;
	private JButton btnAgregarTipoDeContacto;
	private JButton btnAgregarLocalidad;
	private JButton btnEditarLocalidad;
	private JButton btnEditarTipoDeContacto;
	private JButton btnBorrar;
	private JButton btnEditar;
	private JButton btnBorrarLocalidad;
	private JButton btnBorrarTipoDeContacto;
	private JButton btnReporte;
	private JButton btnCerrarAgenda;
	private JButton btnConfigurarBaseDeDatos;
	private DefaultTableModel modelPersonas;
	private String[] nombreColumnas = {"Nombre y apellido", "Tel�fono", "Correo Electronico", "Fecha de Nacimiento", "Domicilio", "Tipo de Contacto" };
	private DefaultTableModel modelLocalidades;
	private String[] nombreColumnasLocalidades = {"Localidad"};
	private DefaultTableModel modelTipoDeContactos;
	private String[] nombreDeColumnasTipoDeContactos = {"Tipos de Contactos"};
	public Vista() {
		super();
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1170, 944);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(15, 93, 1116, 779);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setBounds(20, 16, 1081, 274);
		panel.add(spPersonas);
		
		JScrollPane spLocalidades = new JScrollPane();
		spLocalidades.setBounds(270, 407, 211, 266);
		panel.add(spLocalidades);
		
		JScrollPane spTipoDeContactos = new JScrollPane();
		spTipoDeContactos.setBounds(640, 407, 211, 266);
		panel.add(spTipoDeContactos);

		modelPersonas = new DefaultTableModel(null, nombreColumnas);
		tablaPersonas = new JTable(modelPersonas);
		
		modelLocalidades = new DefaultTableModel(null, nombreColumnasLocalidades);
		tablaLocalidades = new JTable(modelLocalidades);
		
		modelTipoDeContactos = new DefaultTableModel(null, nombreDeColumnasTipoDeContactos);
		tablaTipoDeContactos = new JTable(modelTipoDeContactos);

		tablaPersonas.getColumnModel().getColumn(0).setPreferredWidth(103);
		tablaPersonas.getColumnModel().getColumn(0).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(1).setResizable(false);

		spPersonas.setViewportView(tablaPersonas);
		
		tablaLocalidades.getColumnModel().getColumn(0).setPreferredWidth(20);
		tablaLocalidades.getColumnModel().getColumn(0).setResizable(false);

		spLocalidades.setViewportView(tablaLocalidades);
		
		tablaTipoDeContactos.getColumnModel().getColumn(0).setPreferredWidth(20);
		tablaTipoDeContactos.getColumnModel().getColumn(0).setResizable(false);

		spTipoDeContactos.setViewportView(tablaTipoDeContactos);

		btnAgregarPersona = new JButton("Agregar Persona");
		btnAgregarPersona.setBounds(88, 325, 235, 23);
		panel.add(btnAgregarPersona);
		
		btnAgregarTipoDeContacto = new JButton("Agregar Tipo de Contacto");
		btnAgregarTipoDeContacto.setBounds(866, 458, 235, 23);
		panel.add(btnAgregarTipoDeContacto);
		
		btnAgregarLocalidad= new JButton("Agregar Localidad");
		btnAgregarLocalidad.setBounds(20, 458, 235, 23);
		panel.add(btnAgregarLocalidad);

		btnEditar = new JButton("Editar Persona");
		btnEditar.setBounds(461, 301, 235, 23);
		panel.add(btnEditar);

		btnBorrar = new JButton("Borrar Persona");
		btnBorrar.setBounds(823, 325, 235, 23);
		panel.add(btnBorrar);
		
		btnBorrarLocalidad = new JButton("Borrar Localidad");
		btnBorrarLocalidad.setBounds(20, 584, 235, 23);
		panel.add(btnBorrarLocalidad);
		
		btnBorrarTipoDeContacto = new JButton("Borrar Tipo De Contacto");
		btnBorrarTipoDeContacto.setBounds(866, 584, 235, 23);
		panel.add(btnBorrarTipoDeContacto);
		
		btnEditarLocalidad = new JButton("Editar Localidad");
		btnEditarLocalidad.setBounds(20, 521, 235, 23);
		panel.add(btnEditarLocalidad);
		
		btnEditarTipoDeContacto = new JButton("Editar Tipo de Contacto");
		btnEditarTipoDeContacto.setBounds(866, 521, 235, 23);
		panel.add(btnEditarTipoDeContacto);
		
		btnCerrarAgenda = new JButton("Cerrar Agenda");
		btnCerrarAgenda.setBounds(866, 726, 235, 23);
		panel.add(btnCerrarAgenda);
		
		btnReporte = new JButton("Ver Reporte");
		btnReporte.setBounds(461, 369, 235, 23);
		panel.add(btnReporte);
		
		JLabel lblAgenda = new JLabel("AGENDA");
		lblAgenda.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblAgenda.setHorizontalAlignment(SwingConstants.CENTER);
		lblAgenda.setBounds(466, 16, 234, 61);
		frame.getContentPane().add(lblAgenda);
		
		btnConfigurarBaseDeDatos = new JButton("Configurar Base de Datos");
		btnConfigurarBaseDeDatos.setBounds(461, 335, 235, 23);
		panel.add(btnConfigurarBaseDeDatos);
	}

	public void show() {
		this.frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int confirm = JOptionPane.showOptionDialog(null, "Estas seguro que quieres salir de la Agenda!?",
						"Confirmaci�n", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (confirm == 0) {
					Conexion.getConexion().cerrarConexion();
					System.exit(0);
				}
			}
		});
		this.frame.setVisible(true);
	}
	
	public void cerrarAgenda() {
		int confirm = JOptionPane.showOptionDialog(null, "Estas seguro que quieres salir de la Agenda!?",
				"Confirmaci�n", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
		if (confirm == 0) {
			Conexion.getConexion().cerrarConexion();
			System.exit(0);
		}
	}
	
	public JButton getBtnAgregarPersona() {
		return btnAgregarPersona;
	}
	
	public JButton getBtnAgregarTipoDeContacto() {
		return btnAgregarTipoDeContacto;
	}
	
	public JButton getBtnAgregarLocalidad() {
		return btnAgregarLocalidad;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}
	
	public JButton getBtnBorrarLocalidad() {
		return btnBorrarLocalidad;
	}
	
	public JButton getBtnBorrarTipoDeContacto() {
		return btnBorrarTipoDeContacto;
	}
	
	public JButton getBtnEditar() {
		return btnEditar;
	}
		

	public JButton getBtnEditarLocalidad() {
		return btnEditarLocalidad;
	}

	public JButton getBtnEditarTipoDeContacto() {
		return btnEditarTipoDeContacto;
	}

	public JButton getBtnCerrarAgenda() {
		return btnCerrarAgenda;
	}
	
	public JButton getBtnConfigurarBaseDeDatos() {
		return btnConfigurarBaseDeDatos;
	}
	
	public DefaultTableModel getModelPersonas() {
		return modelPersonas;
	}

	public JTable getTablaPersonas() {
		return tablaPersonas;
	}

	public String[] getNombreColumnas() {
		return nombreColumnas;
	}
	
	public DefaultTableModel getModelLocalidades() {
		return modelLocalidades;
	}
	
	public JTable getTablaLocalidades() {
		return tablaLocalidades;
	}
	
	public String[] getNombreColumnaLocalidades() {
		return nombreColumnasLocalidades;
	}
	
	public DefaultTableModel getModelTipoDeContactos() {
		return modelTipoDeContactos;
	}
	
	public JTable getTablaTipoDeContactos() {
		return tablaTipoDeContactos;
	}
	
	public String[] getNombreColumnaTipoDeContactos() {
		return nombreDeColumnasTipoDeContactos;
	}

	public JButton getBtnReporte() {
		return btnReporte;
	}
}
