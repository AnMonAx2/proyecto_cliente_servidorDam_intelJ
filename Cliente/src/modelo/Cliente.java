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
public class Cliente {

    private String nombre;
    private String nick;
    private String email;
    private String password;

    public Cliente() {

    }

    public Cliente(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Cliente(String nombre, String nick, String email, String password) {
        this.nombre = nombre;
        this.nick = nick;
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "Data{" + "email=" + email + ", password=" + password + '}';
    }
}