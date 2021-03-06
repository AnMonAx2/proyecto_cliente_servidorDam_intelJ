/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ControladorCliente;
import controlador.Controlador_datosRecibidos;

import java.awt.Dimension;
import java.awt.Toolkit;

import static modelo.ModeloProtocoloCliente.*;


/*
 PENDIENTE

*/

/**
 *
 * @author sinNombre
 */
public class VistaJFrame_formularioRegistro extends javax.swing.JFrame implements IVista {
    ControladorCliente controlador;
    Controlador_datosRecibidos controladordata;
    /**
     * Creates new form VistaJFrame
     */
    public VistaJFrame_formularioRegistro() {
        initComponents();
        centreWindow();
        controladordata=new Controlador_datosRecibidos();
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel_icon = new javax.swing.JLabel();
        label_signIn = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        txt_nick = new javax.swing.JTextField();
        jPanel_respuesta_servidor = new javax.swing.JPanel();
        jLabel_login_error = new javax.swing.JLabel();
        jPanel_botones = new javax.swing.JPanel();
        jButton_volver = new javax.swing.JButton();
        jButton_registro_form = new javax.swing.JButton();
        txt_name = new javax.swing.JTextField();
        txt_pw = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));

        jPanel1.setBackground(new java.awt.Color(229, 229, 229));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel_icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icons8-usuario-de-g??nero-neutro-50.png"))); // NOI18N

        label_signIn.setBackground(new java.awt.Color(229, 229, 229));
        label_signIn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        label_signIn.setText("Register");
        label_signIn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txt_telefono.setText("Your phone");
        txt_telefono.setToolTipText("");
        txt_telefono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_telefono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_telefonoMouseClicked(evt);
            }
        });

        txt_nick.setText("Your nick");
        txt_nick.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_nick.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_nickMouseClicked(evt);
            }
        });

        jPanel_respuesta_servidor.setBackground(new java.awt.Color(255, 255, 255));

        jLabel_login_error.setForeground(new java.awt.Color(204, 0, 51));
        jLabel_login_error.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel_respuesta_servidorLayout = new javax.swing.GroupLayout(jPanel_respuesta_servidor);
        jPanel_respuesta_servidor.setLayout(jPanel_respuesta_servidorLayout);
        jPanel_respuesta_servidorLayout.setHorizontalGroup(
            jPanel_respuesta_servidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel_login_error, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
        );
        jPanel_respuesta_servidorLayout.setVerticalGroup(
            jPanel_respuesta_servidorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_respuesta_servidorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel_login_error, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton_volver.setBackground(new java.awt.Color(0, 153, 255));
        jButton_volver.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_volver.setForeground(new java.awt.Color(255, 255, 255));
        jButton_volver.setText("VOLVER");
        jButton_volver.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_volver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_volverMouseClicked(evt);
            }
        });

        jButton_registro_form.setBackground(new java.awt.Color(0, 153, 255));
        jButton_registro_form.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_registro_form.setForeground(new java.awt.Color(255, 255, 255));
        jButton_registro_form.setText("REGISTER");
        jButton_registro_form.setActionCommand("REGISTER_FORM");
        jButton_registro_form.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton_registro_form.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_registro_formActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel_botonesLayout = new javax.swing.GroupLayout(jPanel_botones);
        jPanel_botones.setLayout(jPanel_botonesLayout);
        jPanel_botonesLayout.setHorizontalGroup(
            jPanel_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_botonesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton_registro_form, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jButton_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        jPanel_botonesLayout.setVerticalGroup(
            jPanel_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_botonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_botonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_volver, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_registro_form, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txt_name.setText("Your name ");
        txt_name.setToolTipText("");
        txt_name.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_nameMouseClicked(evt);
            }
        });

        txt_pw.setText("Your password");
        txt_pw.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_pw.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_pwMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel_icon)
                        .addGap(18, 18, 18)
                        .addComponent(label_signIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel_botones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_name, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txt_nick))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txt_telefono)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_respuesta_servidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_pw, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label_signIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel_icon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(txt_telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txt_nick, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel_respuesta_servidor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jPanel_botones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(146, 146, 146)
                    .addComponent(txt_pw, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(344, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 133, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void txt_telefonoMouseClicked(java.awt.event.MouseEvent evt) {                                          
        txt_telefono.setText("");
        mostrarPanelRespuesta_y_ocultarPanelBotones();
     
    }                                         

    private void txt_nickMouseClicked(java.awt.event.MouseEvent evt) {                                      
         txt_nick.setText("");
         mostrarPanelRespuesta_y_ocultarPanelBotones();

    }                                     

    private void txt_nameMouseClicked(java.awt.event.MouseEvent evt) {                                      
          txt_name.setText("");
          mostrarPanelRespuesta_y_ocultarPanelBotones();
    }                                     

    private void txt_pwMouseClicked(java.awt.event.MouseEvent evt) {                                    
        // TODO add your handling code here:
         txt_pw.setText("");
         mostrarPanelRespuesta_y_ocultarPanelBotones();
    }                                   

    private void jButton_volverMouseClicked(java.awt.event.MouseEvent evt) {                                            
        // TODO add your handling code here:
        cerrar();
    }                                           

    private void jButton_registro_formActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
         jButton_registro_form.setActionCommand(REGISTER_FORM);
    }                                                     


    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton_registro_form;
    private javax.swing.JButton jButton_volver;
    private javax.swing.JLabel jLabel_icon;
    private javax.swing.JLabel jLabel_login_error;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel_botones;
    private javax.swing.JPanel jPanel_respuesta_servidor;
    private javax.swing.JLabel label_signIn;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_nick;
    private javax.swing.JTextField txt_pw;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration                   



    @Override
    public void mostrarRespuesta(String mensaje) {
        jPanel_respuesta_servidor.setVisible(true);
        jLabel_login_error.setText(mensaje);
        
        jPanel_botones.setVisible(false);
        
    }

    @Override
    public void resetLogin() {
        txt_telefono.setText("Your name");
        txt_nick.setText("Your nick");
        txt_pw.setText("Your email");
        txt_name.setText("Your name");
        jPanel_botones.setVisible(true);
    }

    @Override
    public void setControlador(ControladorCliente controlador) {
        this.controlador = controlador;
    }

    @Override
    public void hacerVisible() {
        setVisible(true);
        jPanel_respuesta_servidor.setVisible(false);  
       
    }
    
    @Override
    public void inicializar(){
        jButton_registro_form.addActionListener(controlador);
    }

   
    @Override
    public String getMensajeAEnviar() {
        if(txt_telefono.getText().isEmpty() || txt_nick.getText().isEmpty()||
                txt_pw.getText().isEmpty() || txt_name.getText().isEmpty()){
            resetLogin();
            return SIN_DATOS;
        }else{ // se comprueba que los datos introducidos son validos
            if(controladordata.comprobarDatos(txt_name.getText(),txt_pw.getText(),
                    txt_telefono.getText(),txt_nick.getText())){
                return txt_name.getText()+SEPARADOR+txt_pw.getText()+SEPARADOR+
                        txt_telefono.getText()+SEPARADOR+txt_nick.getText();
            }else{
                resetLogin();
                return SIN_DATOS;
            }
    }
            
        
      
    }

    @Override
    public void cerrar() {
         this.dispose();
    }

    @Override
    public void centreWindow() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - this.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - this.getHeight()) / 2);
        this.setLocation(x, y);
    }
    
    
/*   public static void centreWindow(Window frame) {
    Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
    int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
    frame.setLocation(x, y);
}*/

    private void mostrarPanelRespuesta_y_ocultarPanelBotones() {
        jPanel_respuesta_servidor.setVisible(false);
        jPanel_botones.setVisible(true);
    }

}
