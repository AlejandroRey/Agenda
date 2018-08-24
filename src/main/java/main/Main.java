package main;

import java.util.Set;

import dto.PersonaReporteDTO;
import modelo.Agenda;
import persistencia.dao.mysql.DAOSQLFactory;
import persistencia.dao.mysql.PersonaReporteDAOSQL;
import presentacion.controlador.Controlador;
import presentacion.vista.Vista;


public class Main 
{

	public static void main(String[] args) 
	{
		Vista vista = new Vista();
		Agenda modelo = new Agenda(new DAOSQLFactory());
		Controlador controlador = new Controlador(vista, modelo);
		controlador.inicializar();
		
//		PersonaReporteDAOSQL p = new PersonaReporteDAOSQL();
//		Set<PersonaReporteDTO> s = p.readAll();
//		for (PersonaReporteDTO personaReporteDTO : s) {
//			System.out.println(personaReporteDTO.getNombre());
//		}
		
	}
}
