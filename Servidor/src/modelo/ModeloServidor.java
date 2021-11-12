/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ControladorServidor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import static vista.IVista.*;
import static modelo.ProtocoloServer.*;

/**
 *
 * @author sinNombre
 */
public class ModeloServidor extends Thread {
    private ControladorServidor controlador;
    private final int PUERTO = 19999;
    private ServerSocket ss;
    private Socket socket;
    private BufferedReader br;
    private BufferedWriter bw;
    private int contador=1;
    //private TreeSet<Socket> treeSocket_clientes;
    private List <Socket> listSDocket=new ArrayList();
   
    
    private Map<String, String> datosLogin=new TreeMap();

    public ModeloServidor() {
         datosLogin.put("a", "a");
         //treeSocket_clientes=new TreeSet();
    }
    
    
    
    
    public void setControlador(ControladorServidor controlador){
        this.controlador = controlador;
    }
    
    public void abrirPuerto(){
        try {
            ss = new ServerSocket(PUERTO);
            
        } catch (IOException ex) {
            Logger.getLogger(ModeloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void esperarAlCliente(){
        try {
            socket = ss.accept();
            //treeSocket_clientes.add(socket); // add el socket del cliente 
            listSDocket.add(socket);
            System.out.println("socket cliente "+socket);
        } catch (IOException ex) {
            Logger.getLogger(ModeloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
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
            Logger.getLogger(ModeloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enviarMensaje(String mensaje){
        try {
            bw.write(mensaje);
            bw.newLine();
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(ModeloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String recibirMensaje(){
        try {
            String mensaje = br.readLine();
            return mensaje;
        } catch (IOException ex) {
            Logger.getLogger(ModeloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public int getPUERTO() {
        return PUERTO;
    }

    public Socket getSocket() {
        return socket;
    }
    
    
    
    
    
    
    //pendiente modificar a SWITCH
    public void run(){
        while(true){
             String mensaje = recibirMensaje();
             System.out.println("mensaje recibido "+mensaje);
             String [] str=mensaje.split(SEPARADOR);
               
                       
              if(str.length==2 && str[1].equals(NULLA)){// login : NULLA
                    enviarMensaje(LOGIN_NOT_OK+SEPARADOR+" CAMPOS estan vacio "+contador);                          
                          contador++;
              }
              else if(str[0].equals(LOGIN) && str.length==3){// LOGIN:email:pw
                   
                   String email=str[1];
                   String pw=str[2];                 

                   controlador.vista_muestra_msg("El cliente dice: " + email+"\t pw "+pw);
                   
                   if(comprobarLogin(email, pw)){// aqui se comprueba q existe el usuario
                       // login ok
                       enviarMensaje(LOGIN_OK+SEPARADOR+" ");

                   }else{
                          enviarMensaje(LOGIN_NOT_OK+SEPARADOR+" ERROR AL LOGUEAR "+contador);                          
                          contador++;
                   }
                   
                   
              } else if(str[0].equals(LOGIN_NOT_OK) ){
                   enviarMensaje(LOGIN_NOT_OK+SEPARADOR+" no han enviado datos "+contador);
                   contador++;
              }
                          
              
              else if(str[0].equals(REGISTER) ){
                   enviarMensaje(REGISTER+SEPARADOR+" Registrando pendiente");
                   
              }
              
               else if(str[0].equals(REGISTER_FORM) ){
                   System.out.println("REGISTER_FORM");
                   enviarMensaje(REGISTER_FORM+SEPARADOR+" Registrado OK");
                   
              }
             
         
        }
    }
    

    //!email.equals("") || !password.equals("")
    private boolean comprobarLogin(String email, String password) {
    
        boolean esta_registrado=false;
         
         if(!datosLogin.isEmpty()){
             if(datosLogin.containsKey(email)){
                 if(datosLogin.get(email).equals(password)){
                     return true;
                 }
             }
         }
      return esta_registrado;     
    }
    
}
