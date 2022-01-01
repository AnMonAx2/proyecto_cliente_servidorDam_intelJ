/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal_server;

import controlador.ControladorServidor;
import controlador.Clase_compartida;
import modelo.ModeloServidor_hilo;

import vista.VistaJFrame_log_servidor;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author sinNombre
 */
public class Main_server {

    /**
     * link comandos git https://viviryaprenderweb.com/10-comandos-git-esenciales-para-saber-por-donde-empezar/
     */
    public static void main(String[] args) throws IOException {
        VistaJFrame_log_servidor vista = new VistaJFrame_log_servidor(); // la ventana del servidor
        Clase_compartida clase_compartida=new Clase_compartida();

        int port=19999;
        ServerSocket ss=null;

        try {
            ss=new ServerSocket(port);
        } catch (IOException e) {
            System.err.println("IOException "+port);
        }
        System.out.println("<Server>: conected.. ");
        ControladorServidor controlador;

        boolean seguir=true;
        while (seguir){
            // para cada cliente se crea un hilo y se arranca en la class controlador

            ModeloServidor_hilo modelo_hiloCl = new ModeloServidor_hilo(ss, clase_compartida);
            controlador = new ControladorServidor(vista, modelo_hiloCl);
            modelo_hiloCl.setControlador(controlador);

            controlador.arrancar();

        }

        ss.close();






        
       // vista.setControlador(controlador);



        
    }


    
}

/*    VistaJFrame vista = new VistaJFrame();
    ModeloServidor_hilo modelo = new ModeloServidor_hilo();

    ControladorServidor controlador = new ControladorServidor(vista, modelo);

        vista.setControlador(controlador);
                modelo.setControlador(controlador);

                controlador.arrancar();*/
