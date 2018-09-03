package main;

import javax.swing.UIManager;

import modelo.Agenda;
import persistencia.dao.mysql.DAOSQLFactory;
import presentacion.controlador.Controlador;
import presentacion.vista.Vista;


public class Main 
{

	public static void main(String[] args) 
	{
        try {
            // Selecciono el Look and Feel HiFiLookAndFeel
            //UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
            //UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel"); 
        	UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel");
        	//UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
        	
            // Inicio la Aplicacion
    		Vista vista = new Vista();
    		Agenda modelo = new Agenda(new DAOSQLFactory());
    		Controlador controlador = new Controlador(vista, modelo);
    		controlador.inicializar();	

        }
        catch (Exception ex) {
            ex.printStackTrace();
        }	
	}
}
