/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorCliente;

/**
 *
 * @author sinNombre
 */
public interface IVista {
    
    public void mostrarRespuesta(String mensaje);
    public void resetLogin();
    public void setControlador(ControladorCliente controlador);
    public void hacerVisible();
    public void inicializar();
    public String getMensajeAEnviar();
    public void cerrar();
}
