package persistencia.dao.interfaz;

import java.util.Set;

import dto.PersonaReporteDTO;

public interface PersonaReporteDAO {
	
	public Set<PersonaReporteDTO> readAll();

}
