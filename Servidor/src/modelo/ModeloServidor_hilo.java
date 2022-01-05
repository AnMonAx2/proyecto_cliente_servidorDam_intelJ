/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.Clase_compartida;
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

    Clase_compartida clase_compartida;

    public ModeloServidor_hilo(ServerSocket ss,  Clase_compartida cc ){
         this.serverSocket =ss;
         this.clase_compartida=cc;
    }

    public void setControlador(ControladorServidor controlador){
        this.controlador = controlador;
    }

    
    public void esperarAlCliente(){
        try {
            socket = serverSocket.accept();
            clase_compartida.listSocketAdd(socket);// add el socket cl al listado

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
            if(!mensaje.isEmpty()|| mensaje.getBytes().length==0)
                return mensaje;
        } catch (IOException ex) {
            System.err.println("IOException recibirMensaje "+ex.getMessage());
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
             if(mensaje!=null || mensaje.length()!=0){
                 controlador.vista_muestra_msg("mensaje recibido "+mensaje);
                 System.out.println("mensaje recibido "+mensaje.length());
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

                     if(clase_compartida.comprobarLogin(email, pw)){// aqui se comprueba q existe el usuario
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
                     String nick=str[1];
                     String pw=str[2];
                     String nombre=str[3];
                     String telefono=str[4];
                     controlador.vista_muestra_msg("El cliente dice: " +nick+"\t "+
                            pw+"\t "+nombre+"\t "+telefono +"\t ");
                     // creo new Usuario
                     Usuario usuario=new Usuario(str[1], str[2], str[3], str[4]);
                     //llama M en la clase_compartida para guardar los datos cl+ el socket del mismo
                     clase_compartida.addDatos_registroBD(usuario, getSocket());

                 }

             }
         
        }
    }

    
}
