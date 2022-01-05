/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author sinNombre
 */
public class Usuario {

    private String nombre;
    private String nick;
    private String pw;
    private String telefono;

    public Usuario() {

    }

    public Usuario(String pw, String telefono) {
        this.pw = pw;
        this.telefono = telefono;
    }

    public Usuario(String nick, String pw, String nombre, String telefono) {
        this.nick = nick;
        this.pw = pw;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", nick='" + nick + '\'' +
                ", pw='" + pw + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}