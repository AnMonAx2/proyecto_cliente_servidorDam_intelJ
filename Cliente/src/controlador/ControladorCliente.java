/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.ModeloCliente;
import vista.IVista;
import static modelo.ProtocoloCliente.*;


/**
 *
 * @author sinNombre
 */
public class ControladorCliente implements ActionListener {
    IVista vista;
    ModeloCliente modelo;

    public ControladorCliente(IVista vista, ModeloCliente modelo) {
        this.vista = vista;
        this.modelo = modelo;
    }
    
    // arranca el la vista login , conecta el server y crea los flujos
    public void arrancar(){
        vista.hacerVisible();
        vista.inicializar(); 
               
        if( modelo.conectarConElServidor()){ // si ha cionectado con server
            modelo.crearFlujos();// crea los flujos
            modelo.start();// arranco el hilo del cliente
       }else{
            JOptionPane.showMessageDialog(null, "imposible conectar ");
            vista.cerrar();
        }
      
    }

    // cliente envia datos o hace peticion
    // depende de la palabra-protocolo entra en witch
    // envio la peticion al servidor
    @Override
    public void actionPerformed(ActionEvent e) {
        String mensaje;
        System.out.println("\ne.getActionCommand() "+e.getActionCommand());
        switch(e.getActionCommand()){
            case LOGIN:  
                 mensaje=LOGIN+SEPARADOR+vista.getMensajeAEnviar();// login:email:pw
                 modelo.enviarMensaje(mensaje);
                break;
            case REGISTER: 
                 mensaje=REGISTER+SEPARADOR;
                 modelo.enviarMensaje(mensaje);
                 break;  
             case REGISTER_FORM:                
                 mensaje=REGISTER_FORM+SEPARADOR + modelo.getVista_register().getMensajeAEnviar();
                 modelo.enviarMensaje(mensaje);
                 break; 
        }
    }
    
    public void vista_muestra_msg(String mensaje){
        vista.mostrarRespuesta(mensaje);
    }
}
