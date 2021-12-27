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
import java.util.logging.Level;
import java.util.logging.Logger;

import static modelo.ProtocoloServer.*;

/**
 *
 * @author sinNombre
 */
public class ModeloServidor_hilo extends Thread {
    private ControladorServidor controlador;
    private final int PUERTO = 19999;

    private Socket socket;
    private ServerSocket serverSocket;

    private BufferedReader br;
    private BufferedWriter bw;
    private int contador=1; // para contar los fallos al loguear

    private List <Socket> listSocket =new ArrayList();// !! meter otro tipo lista
    private Map<String, String> datosLogin=new TreeMap();

    Clase_compartida clase_compartida;

    public ModeloServidor_hilo(ServerSocket ss,  Clase_compartida cc ){
         datosLogin.put("a", "a");
         this.serverSocket =ss;
         this.clase_compartida=cc;
    }
    
    
    
    
    public void setControlador(ControladorServidor controlador){
        this.controlador = controlador;
    }

    
    public void esperarAlCliente(){
        try {
            socket = serverSocket.accept();
            listSocket.add(socket);// add el socket cl al listado
            System.out.println("socket cliente "+socket);
            System.out.println("cliente conectados "+listSocket.size());
        } catch (IOException ex) {
            Logger.getLogger(ModeloServidor_hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearFlujos(){
        try {
            //obtengo flujo entrada
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            //flujo salida
            OutputStream os = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);
        } catch (IOException ex) {
            Logger.getLogger(ModeloServidor_hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void enviarMensaje(String mensaje){
        try {
            bw.write(mensaje);
            bw.newLine();
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(ModeloServidor_hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String recibirMensaje(){
        try {
            String mensaje = br.readLine();
            return mensaje;
        } catch (IOException ex) {
            Logger.getLogger(ModeloServidor_hilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public int getPUERTO() {
        return PUERTO;
    }

    public Socket getSocket() {
        return socket;
    }
    

    
    //servidor procesa la peticion recibido del cliente
    public void run(){
        while(true){
             String mensaje = recibirMensaje();
             System.out.println("mensaje = "+mensaje);
             if(!mensaje.isEmpty()){
                 controlador.vista_muestra_msg("mensaje recibido "+mensaje);
                 System.out.println("mensaje recibido "+mensaje);
                 String [] str=mensaje.split(SEPARADOR);


                 if(str.length==2 && str[1].equals(SIN_DATOS) ){// login : con campos vacios

                     if(str[0].equals(LOGIN)){
                         enviarMensaje(LOGIN_NOT_OK+SEPARADOR+" CAMPOS estan vacio "+contador);
                         contador++;
                     } if(str[0].equals(REGISTER_FORM)){
                         enviarMensaje(REGISTER_FORM_NOT_OK +SEPARADOR+" CAMPOS formulario no pueden estar vacio ");

                     }

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
                     enviarMensaje(LOGIN_NOT_OK+SEPARADOR+" No han enviado datos "+contador);
                     contador++;
                 }


                 else if(str[0].equals(REGISTER) ){
                     enviarMensaje(REGISTER+SEPARADOR+" Registro en curso..");

                 }

                 else if(str[0].equals(REGISTER_FORM) ){
                     enviarMensaje(REGISTER_FORM+SEPARADOR+" Registrado OK-pendiente meter datos en la bd");
                     String nombre=str[1];
                     String email=str[2];
                     String telefono=str[3];
                     String nick=str[4];
                     controlador.vista_muestra_msg("El cliente dice: " + str[1]+"\t "+
                             str[2]+"\t "+ str[3]+"\t "+ str[4]+"\t ");

                     // crear obj cliente y add bd

                 }

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
