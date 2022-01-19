/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloServidor_hiloDelCliente;
import vista.IVista;

/**
 *
 * @author sinNombre
 */
public class ControladorServidor implements ActionListener {
    IVista vista;
    ModeloServidor_hiloDelCliente modelo;

    public ControladorServidor(IVista vista, ModeloServidor_hiloDelCliente modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }
    
    public void arrancar(){
        vista.hacerVisible();      
       // modelo.abrirPuerto();
        vista.mostrarRespuesta("abriendo el puerto..."+modelo.getPUERTO());   
        modelo.esperarAlCliente();
        vista.mostrarRespuesta("Conectando cliente..."+modelo.getSocket());
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
