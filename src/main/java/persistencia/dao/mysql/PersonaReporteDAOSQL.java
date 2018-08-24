package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.TreeSet;

import dto.PersonaReporteDTO;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.PersonaReporteDAO;

public class PersonaReporteDAOSQL implements PersonaReporteDAO {

	private static final String readall = "SELECT p.nombre, p.telefono, p.email, p.fechaDeNacimiento, p.calle, "
										+ "p.altura, p.piso, p.departamento, p.localidad, c.tipoDeContacto FROM "
										+ "(SELECT p.nombre, p.telefono, p.email, p.fechaDeNacimiento, p.idTipoDeContacto, "
										+ "d.calle, d.altura, d.piso, d.departamento, d.localidad, d.idDomicilio FROM personas AS p "
										+ "INNER JOIN "
										+ "(SELECT d.calle, d.altura, d.piso, d.departamento, " 
										+ "l.localidad, d.idDomicilio " 
										+ "FROM domicilios AS d "
										+ "INNER JOIN locadidades AS l "
										+ "ON d.idLocalidad = l.idLocalidad) AS d "
										+ "ON p.idDomicilio = d.idDomicilio) AS p "
										+ "INNER JOIN "
										+ "tiposdecontactos AS c "
										+ "ON p.idTipoDeContacto = c.idTipoDeContacto;";
	
	public Set<PersonaReporteDTO> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; // Guarda el resultado de la query
		Set<PersonaReporteDTO> personasReporte = new TreeSet<>();
		Conexion conexion = Conexion.getConexion();
		try {
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				personasReporte.add(new PersonaReporteDTO(
									resultSet.getString("nombre"), 
									resultSet.getString("telefono"),
									resultSet.getString("email"), 
									resultSet.getDate("fechaDeNacimiento"), 
									resultSet.getString("calle"),
									resultSet.getInt("altura"),
									resultSet.getInt("piso"),
									resultSet.getInt("departamento"),
									resultSet.getString("localidad"), 
									resultSet.getString("tipoDeContacto"), 
									null, 
									null, 
									null));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return personasReporte;
	}

}
