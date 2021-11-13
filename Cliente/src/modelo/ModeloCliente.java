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

import vista.VistaJFrame_PrincipalLogin;
import static modelo.ProtocoloCliente.*;
import vista.VistaJFrame_formularioRegistro;
import vista.VistaJFrame_menuAplicacion;

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
  
    
    private VistaJFrame_PrincipalLogin vista_login;
    private VistaJFrame_formularioRegistro vista_register;
    private VistaJFrame_menuAplicacion vista_menu;
    
    // constructor , getter & Setter

    public ModeloCliente(IVista vista) {
        this.vista_login = (VistaJFrame_PrincipalLogin) vista; 
        
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
    
    

    // recibe la respuesto del servidor- depende de la primera palabra-protocolo determina
    // donde/ el frame q se muestra
    public void run(){
        while(true){
            String mensaje = recibirMensaje();
       
                String [] str=mensaje.split(SEPARADOR);
                String protocolo=str[0];
                String respuesta=str[1]; // del servidor
               
                System.out.println("recibirMensaje "+mensaje);

            switch(protocolo){
                    
                       case LOGIN_OK:   // crea new Jframe y lo abre                        
                           controlador.vista_muestra_msg(respuesta);                                               
                           vista_menu=new VistaJFrame_menuAplicacion();// creo new frame
                           vista_menu.setControlador(controlador);
                           vista_menu.inicializar();
                           vista_menu.hacerVisible();
                           vista_login.cerrar();// cierro del actual                       
                          break;
                       case LOGIN_NOT_OK:
                           controlador.vista_muestra_msg(respuesta);                          
                          break; 
                       case REGISTER: // crea new Jframe y lo abre    
                           controlador.vista_muestra_msg(respuesta); 
                           vista_register=new  VistaJFrame_formularioRegistro ();
                           vista_register.setControlador(controlador);
                           vista_register.inicializar();
                           vista_register.hacerVisible();
                           
                          break; 
                        case REGISTER_FORM:                           
                           vista_register.mostrarRespuesta(respuesta);
                           //controlador.vista_muestra_msg(respuesta); 
                                              
                          break;    
                                 
                              
                    default:
                          controlador.vista_muestra_msg("algo salio mal"); 
                        break;
                       }      
        
        }
    }

    public VistaJFrame_formularioRegistro getVista_register() {
        return vista_register;
    }
    
    
}
