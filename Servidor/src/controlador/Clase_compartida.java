package controlador;

import modelo.Usuario;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * created by sinNombre on dic., 27/12/2021
 */
public class Clase_compartida {

    private Map<String, String> datosLogin=new TreeMap();
    public List<Socket> listSocket =new ArrayList();// !! meter otro tipo lista

    public Clase_compartida() {
        datosLogin.put("a", "a");

    }

    public void listSocketAdd(Socket socket){
        this.listSocket.add(socket);
        System.out.println("listSocket.size "+listSocket.size());
    }





    //!email.equals("") || !password.equals("")
    public synchronized boolean comprobarLogin(String email, String password) {
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


    public void addDatos_registroBD(Usuario usuario, Socket socket) {
        datosLogin.put(usuario.getNick(), usuario.getPassword());
        System.out.println(usuario.toString());
        System.out.println(socket);
    }
}
