/*
 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 

 */
package principal;

import controlador.ControladorCliente;
import modelo.ModeloCliente;
import vista.IVista;
import vista.VistaJFrame_PrincipalLogin;
import vista.VistaJFrame_formularioRegistro;

/**
 *
 * @author sinNombre

 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IVista vista = new VistaJFrame_PrincipalLogin();// pantalla principal login
        ModeloCliente modelo = new ModeloCliente(vista);// thread
        
        ControladorCliente controlador = new ControladorCliente(vista, modelo);//compartida
        
        vista.setControlador(controlador);
        modelo.setControlador(controlador);
        
        controlador.arrancar();
    }
    
}
