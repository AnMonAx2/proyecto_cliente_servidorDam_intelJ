/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal_server;

import controlador.ControladorServidor;
import java.util.TreeSet;
import modelo.ModeloServidor;

import vista.IVista;
import vista.VistaJFrame;

/**
 *
 * @author sinNombre
 */
public class Main_server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        VistaJFrame vista = new VistaJFrame();
        ModeloServidor modelo = new ModeloServidor();

        ControladorServidor controlador = new ControladorServidor(vista, modelo);
        
        vista.setControlador(controlador);
        modelo.setControlador(controlador);
        
        controlador.arrancar();
        
    }
    
}
