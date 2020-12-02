/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.vista;

import ec.ups.edu.controlador.ControladorInicioSesion;
import ec.ups.edu.modelo.Usuario;
import javax.swing.JMenu;
import javax.swing.JOptionPane;

/**
 *
 * @author santi
 */
public class VentanaInicioSesion extends javax.swing.JInternalFrame {

    ControladorInicioSesion controladorInicioSesion;
    VentanaPrincipal ventanaPrincipal;

    public VentanaInicioSesion(ControladorInicioSesion controladorInicioSesion, VentanaPrincipal ventanaPrincipal) {
        initComponents();

        this.controladorInicioSesion = controladorInicioSesion;
        this.ventanaPrincipal = ventanaPrincipal;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        btnIniciarSesion = new javax.swing.JButton();
        btnRegistrarse = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JPasswordField();
        comboBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setClosable(true);

        jLabel1.setText("Usuario");

        jLabel2.setText("Contrasena");

        btnIniciarSesion.setText("Iniciar Sesion");
        btnIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSesionActionPerformed(evt);
            }
        });

        btnRegistrarse.setText("Registrarse");
        btnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarseActionPerformed(evt);
            }
        });

        jLabel3.setText("Tipo de usuario");

        comboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMINISTRADOR", "DOCENTE" }));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("INICIO SESION");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(126, 126, 126))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(btnRegistrarse)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnIniciarSesion))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addComponent(jLabel1))
                                            .addComponent(jLabel2))))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtCorreo)
                                    .addComponent(txtContrasena)
                                    .addComponent(comboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(50, 50, 50))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarse)
                    .addComponent(btnIniciarSesion))
                .addGap(39, 39, 39))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void mostrarDatos() {
        
        String item = comboBox.getSelectedItem().toString();

        switch(item){
            
            case "ADMINISTRADOR":
            
                ventanaPrincipal.ventanaGestionssDocente().setVisible(true);
                
                break;
            
            case "DOCENTE":
                
                ventanaPrincipal.ventanaGestionEstudiante().setVisible(true);
                
                break;
                
                        
           default: JOptionPane.showMessageDialog(this, "Seleccione una opcion porfavor");
                    
                    
                
        }
    }
    
    public String nombre(){
        
        String nombreProfe = txtCorreo.getText();
        
        return nombreProfe;
        
    }


    private void btnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarseActionPerformed

        String correo = txtCorreo.getText();
        String contrasena = txtContrasena.getText();
        String tipoUsuario = comboBox.getItemAt(comboBox.getSelectedIndex());

        if (correo.isEmpty() || contrasena.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Llene todos los campos.");

        }else{

        Usuario usuario = new Usuario(correo, contrasena, tipoUsuario);
            
        controladorInicioSesion.registrar(usuario);

        JOptionPane.showMessageDialog(this, "Se ha registrado con exito");

        }
    }//GEN-LAST:event_btnRegistrarseActionPerformed

    
    private void btnIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSesionActionPerformed

        String correo = txtCorreo.getText();
        String contrasena = txtContrasena.getText();
        String tipoUsuario = comboBox.getItemAt(comboBox.getSelectedIndex());

        if (correo.isEmpty() || contrasena.isEmpty() || tipoUsuario.isEmpty()) {

            JOptionPane.showMessageDialog(this, "Llene los campos");

        } else {

            Usuario usuario = new Usuario(correo, contrasena, tipoUsuario);

             Usuario usuario1 =  controladorInicioSesion.validar(usuario);

            if (usuario1 != null) {

                JOptionPane.showMessageDialog(this, "Sesion iniciada con exito");
                mostrarDatos();
                
            } else {

                JOptionPane.showMessageDialog(this, "correo o contrasenas incorrectas");

            }

        }

     

    }//GEN-LAST:event_btnIniciarSesionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton btnRegistrarse;
    private javax.swing.JComboBox<String> comboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txtContrasena;
    private javax.swing.JTextField txtCorreo;
    // End of variables declaration//GEN-END:variables
}
