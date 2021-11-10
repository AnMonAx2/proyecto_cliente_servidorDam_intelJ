/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ControladorCliente;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.IVista;
import static vista.IVista.*;
import vista.VistaJFrame2al_loguear;
import vista.VistaJFrame_PrincipalLogin;
import static modelo.ProtocoloCliente.*;

/**
 *
 * @author sinNombre
 */
public class ModeloCliente extends Thread {
    private ControladorCliente controlador;
    private final int PUERTO = 19999;
  //private final String HOST = "localhost";
   private final String HOST ="192.168.1.137";
    private Socket socket;
    private BufferedReader br;
    private BufferedWriter bw;
  
    
    private VistaJFrame_PrincipalLogin vista;
    
    // constructor , getter & Setter

    public ModeloCliente(IVista vista) {
        this.vista = (VistaJFrame_PrincipalLogin) vista;
        
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
     
    
    
    // Metodos de la clase    
    
    public void setControlador(ControladorCliente controlador){
        this.controlador = controlador;
    }
    
    public boolean conectarConElServidor(){
        boolean esconectado=false;
        try {
            socket = new Socket(HOST, PUERTO);
       
            esconectado=true;
            System.out.println("HOST "+HOST);
            InetAddress address = InetAddress.getLocalHost();
            System.out.println("IP Local :"+address.getHostAddress());
            
        } catch (IOException ex) {
          //  Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return esconectado;
        
    }
    
    public void crearFlujos(){
        try {
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
            
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);
        } catch (IOException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enviarMensaje(String mensaje){
        try {
            bw.write(mensaje);
            bw.newLine();
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String recibirMensaje(){
        try {
            String mensaje = br.readLine();
            return mensaje;
        } catch (IOException ex) {
            Logger.getLogger(ModeloCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    
    public void run(){
        while(true){
            String mensaje = recibirMensaje();
       
                String [] str=mensaje.split(SEPARADOR);
                String protocolo=str[0];
                String respuesta=str[1];


            switch(protocolo){
                    
                       case LOGIN_OK:                          
                           controlador.vista_muestra_msg(respuesta);                                               
                           VistaJFrame2al_loguear form=new VistaJFrame2al_loguear();// creo new frame
                           form.setVisible(true);//muestra
                           vista.dispose();   // cierro del actual                       
                          break;
                       case LOGIN_NOT_OK:
                           controlador.vista_muestra_msg(respuesta);                          
                          break; 
                       case REGISTER:
                           controlador.vista_muestra_msg(respuesta);                          
                          break; 
                                 
                              
                    default:
                          controlador.vista_muestra_msg("algo salio mal"); 
                        break;
                       }      
        
        }
    }
}
