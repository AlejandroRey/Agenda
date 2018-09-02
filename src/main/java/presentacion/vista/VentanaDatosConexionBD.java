package presentacion.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdesktop.swingx.prompt.PromptSupport;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;

public class VentanaDatosConexionBD extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPanel;
	private JTextField textFieldUsuario;
	private JTextField textFieldContraseña;
	private JTextField textFieldIp;
	private JTextField textFieldPuerto;

	public VentanaDatosConexionBD(final String filename) {
		setTitle("Conexi\u00F3n SQL");
		setModal(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 308, 354);
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanel);
		contentPanel.setLayout(null);

		JLabel lblTitulo = new JLabel("(*) Datos necesarios para establecer la conexi\u00F3n SQL");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblTitulo.setBounds(10, 11, 264, 24);
		contentPanel.add(lblTitulo);

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsuario.setBounds(10, 54, 85, 14);
		contentPanel.add(lblUsuario);

		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(105, 51, 169, 20);
		contentPanel.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		PromptSupport.setPrompt("*", textFieldUsuario);

		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblContrasea.setBounds(10, 105, 85, 14);
		contentPanel.add(lblContrasea);

		textFieldContraseña = new JTextField();
		textFieldContraseña.setBounds(105, 103, 169, 20);
		contentPanel.add(textFieldContraseña);
		textFieldContraseña.setColumns(10);
		PromptSupport.setPrompt("*", textFieldContraseña);

		JLabel lblIp = new JLabel("IP:");
		lblIp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIp.setBounds(10, 156, 85, 14);
		contentPanel.add(lblIp);

		textFieldIp = new JTextField();
		textFieldIp.setBounds(105, 150, 169, 20);
		contentPanel.add(textFieldIp);
		textFieldIp.setColumns(10);
		PromptSupport.setPrompt("*", textFieldIp);

		JLabel lblPuerto = new JLabel("Puerto:");
		lblPuerto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPuerto.setBounds(10, 207, 85, 14);
		contentPanel.add(lblPuerto);

		textFieldPuerto = new JTextField();
		textFieldPuerto.setBounds(106, 205, 168, 20);
		contentPanel.add(textFieldPuerto);
		textFieldPuerto.setColumns(10);
		PromptSupport.setPrompt("*", textFieldPuerto);

		JButton btnAceptar = new JButton("ACEPTAR");
		btnAceptar.setBounds(10, 257, 124, 24);
		contentPanel.add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// Validar datos ingresados
				if(textFieldUsuario.getText().length() == 0 || textFieldContraseña.getText().length() == 0 || textFieldIp.getText().length() == 0 || textFieldPuerto.getText().length() == 0) {
					if (textFieldUsuario.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "INGRESA EL USUARIO", "ALERTA",
								JOptionPane.WARNING_MESSAGE);
					}
					if (textFieldContraseña.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "INGRESA LA CONTRASEñA", "ALERTA",
								JOptionPane.WARNING_MESSAGE);
					}
					if (textFieldIp.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "INGRESA EL IP", "ALERTA",
								JOptionPane.WARNING_MESSAGE);
					}
					if (textFieldPuerto.getText().length() == 0) {
						JOptionPane.showMessageDialog(null, "INGRESA EL PUERTO", "ALERTA",
								JOptionPane.WARNING_MESSAGE);
					}
				} else {
					// Escribir DATOS para establecer la conexion SQL
					dispose();
					FileWriter fw;
					try {
						fw = new FileWriter(filename);
						fw.write(textFieldUsuario.getText() + System.lineSeparator() + textFieldContraseña.getText()
								+ System.lineSeparator() + textFieldIp.getText() + System.lineSeparator()
								+ textFieldPuerto.getText());
						fw.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(144, 257, 130, 24);
		contentPanel.add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

	}
}
