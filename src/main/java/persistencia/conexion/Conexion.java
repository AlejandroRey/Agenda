package persistencia.conexion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

import javax.swing.JOptionPane;

import presentacion.vista.VentanaDatosConexionBD;

public class Conexion {

	public static Conexion instancia;
	private Connection connection;
	private Logger log = Logger.getLogger(Conexion.class);	

	private Conexion() {

		// OBTENER USUARIO Y CONTRASEÑA DE UN TXT.
		String filename = "C:\\Users\\" + System.getProperty("user.name") + "\\Desktop\\loginSQL.txt";
		String usuarioBD = "";
		String contraseñaBD = "";
		String ipBD = "";
		String puertoBD = "";

		BufferedReader bufferedReader = null;
		FileReader fileReader = null;
		try {
			// Leer usuarioBD y contraseñaBD para realizar el logueo.
			fileReader = new FileReader(filename);
			bufferedReader = new BufferedReader(fileReader);

			usuarioBD = bufferedReader.readLine();
			contraseñaBD = bufferedReader.readLine();
			ipBD = bufferedReader.readLine();
			puertoBD = bufferedReader.readLine();
			System.out.println("Usuario: " + usuarioBD);
			System.out.println("Contraseña: " + contraseñaBD);
			System.out.println("IP: " + ipBD);
			System.out.println("Puerto: " + puertoBD);
			if (usuarioBD == null || usuarioBD.length() == 0 || contraseñaBD == null || contraseñaBD.length() == 0
					|| ipBD == null || ipBD.length() == 0 || puertoBD == null || puertoBD.length() == 0) {
				System.out.println("No hay suficientes datos para realizar el logueo.");
				// Borramos el txt para que la proxima vez pida nuevamente los datos.
				if (bufferedReader != null)
					bufferedReader.close();
				if (fileReader != null)
					fileReader.close();
				File file = new File(filename);
				file.delete();
				if (file.delete()) {
					System.out.println("TXT borrado.");
				}
				// Pedimos al usuario que ingrese usuarioBd y contraseñaBD
				VentanaDatosConexionBD ventanaDatosConexionBD = new VentanaDatosConexionBD(filename);
				ventanaDatosConexionBD.show();
				// LEEMOS DE NUEVO EL TXT
				fileReader = new FileReader(filename);
				bufferedReader = new BufferedReader(fileReader);

				usuarioBD = bufferedReader.readLine();
				contraseñaBD = bufferedReader.readLine();
				ipBD = bufferedReader.readLine();
				puertoBD = bufferedReader.readLine();
				System.out.println("Usuario: " + usuarioBD);
				System.out.println("Contraseña: " + contraseñaBD);
				System.out.println("IP: " + ipBD);
				System.out.println("Puerto: " + puertoBD);
				if (usuarioBD == null || usuarioBD.length() == 0 || contraseñaBD == null || contraseñaBD.length() == 0
						|| ipBD == null || ipBD.length() == 0 || puertoBD == null || puertoBD.length() == 0) {
					System.out.println("No hay suficientes datos para realizar el logueo.");
					// Borramos el txt para que la proxima vez pida nuevamente los datos.
					file.delete();
					System.out.println("TXT borrado.");
				} else {
					System.out.println("LOGUEO EXITOSO.");
				}
			} else {
				System.out.println("LOGUEO EXITOSO.");
			}
		} catch (IOException e) {
			System.out.println("El archivo no esta creado.");
			try {
				// Creamos el txt y le pedimos al usuario que ingrese usuario y contraseña.
				Path path = Paths.get(filename);
				Files.createDirectories(path.getParent());
				Files.createFile(path);
				System.out.println("El archivo txt se ha creado exitosamente.");
				// Pedimos al usuario que ingrese usuarioBd y contraseñaBD
				VentanaDatosConexionBD ventanaDatosConexionBD = new VentanaDatosConexionBD(filename);
				ventanaDatosConexionBD.show();
				// LEEMOS DE NUEVO EL TXT
				fileReader = new FileReader(filename);
				bufferedReader = new BufferedReader(fileReader);

				usuarioBD = bufferedReader.readLine();
				contraseñaBD = bufferedReader.readLine();
				ipBD = bufferedReader.readLine();
				puertoBD = bufferedReader.readLine();
				System.out.println("Usuario: " + usuarioBD);
				System.out.println("Contraseña: " + contraseñaBD);
				System.out.println("IP: " + ipBD);
				System.out.println("Puerto: " + puertoBD);
				if (usuarioBD == null || usuarioBD.length() == 0 || contraseñaBD == null || contraseñaBD.length() == 0
						|| ipBD == null || ipBD.length() == 0 || puertoBD == null || puertoBD.length() == 0) {
					System.out.println("No hay suficientes datos para realizar el logueo.");
					// Borramos el txt para que la proxima vez pida nuevamente los datos.
					File file = new File(filename);
					file.delete();
					System.out.println("TXT borrado.");
				} else {
					System.out.println("LOGUEO EXITOSO.");
				}
				
			} catch (IOException e1) {
				System.out.println("La siguiente ruta: " + filename + " no existe.");
			}
		} finally {
			try {
				if (bufferedReader != null)
					bufferedReader.close();
				if (fileReader != null)
					fileReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection("jdbc:mysql://" +  ipBD + ":" +  puertoBD + "/agenda", usuarioBD, contraseñaBD);
			//this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda","root","root");
			log.info("Conexión exitosa");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "INGRESASTE MAL LOS DATOS PARA LA CONEXION, POR FAVOR VUELVA A EJECUTAR LA APLICACION", "ALERTA",
					JOptionPane.WARNING_MESSAGE);
			// Borramos el txt para que la proxima vez pida nuevamente los datos.
			File file = new File(filename);
			file.delete();
			log.error("Conexión fallida", e);
			System.exit(0);
		}

	}

	public static Conexion getConexion() {
		if (instancia == null) {
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getSQLConexion() {
		return this.connection;
	}

	public void cerrarConexion() {
		try {
			this.connection.close();
			log.info("Conexion cerrada");
		} catch (SQLException e) {
			log.error("Error al cerrar la conexión!", e);
		}
		instancia = null;
	}
	
}