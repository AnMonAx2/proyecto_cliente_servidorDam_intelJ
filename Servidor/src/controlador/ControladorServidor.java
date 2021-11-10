/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloServidor;
import vista.IVista;

/**
 *
 * @author sinNombre
 */
public class ControladorServidor implements ActionListener {
    IVista vista;
    ModeloServidor modelo;

    public ControladorServidor(IVista vista, ModeloServidor modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }
    
    public void arrancar(){
        vista.hacerVisible();      
        modelo.abrirPuerto();
        vista.mostrarRespuesta("abriendo el puerto..."+modelo.getPUERTO());   
        modelo.esperarAlCliente();
        vista.mostrarRespuesta("Esperando al cliente...");
        modelo.crearFlujos();
        modelo.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    
    public void vista_muestra_msg(String mensaje){
        vista.mostrarRespuesta(mensaje);
    }
}
