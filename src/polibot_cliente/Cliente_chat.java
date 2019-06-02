package polibot_cliente;


import interfaces.Interface_servidor;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 *
 * @author wolfteinter
 */
public class Cliente_chat extends javax.swing.JFrame {

    /**
     * Creates new form Cliente_chat
     */
    private Interface_servidor servidor;
    private Cliente cliente;
    private String log;
    
    public Cliente_chat() {
        initComponents();
        //txtLog.setContentType("text/html");
        this.getContentPane().setBackground(new Color(108, 19, 43));
    }

    Cliente_chat(Cliente cliente) {
        initComponents();
        this.log = "";
        this.cliente = cliente;
        this.getContentPane().setBackground(new Color(108, 19, 43));
        this.txtLog.setContentType("text/html");
        String imagen = "<img src='file:assets_cliente/img/IPN.png'></img><br>"; 
        this.txtLog.setText(imagen);
        this.log = imagen;
        String nombre;
        nombre = cliente.getNombre().split(" ")[0];
        this.bienvenida.setText("Bienvenido(a) : "+nombre);
        try {
            Registry reg = LocateRegistry.getRegistry("127.0.0.1",1099);
            this.servidor = (Interface_servidor)reg.lookup("servidor");
        }
        catch (RemoteException ex) {
            ex.printStackTrace();
        }
        catch (NotBoundException ex) {
            ex.printStackTrace();
        }
        // Set listener al txtLog para que se abra el navegador al dar click sobre
        // los enlaces
        this.txtLog.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent hle) {
                if (HyperlinkEvent.EventType.ACTIVATED.equals(hle.getEventType())) {
                    System.out.println(hle.getURL());
                    Desktop desktop = Desktop.getDesktop();
                    try {
                        desktop.browse(hle.getURL().toURI());
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtMensaje = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnMostrarArchivos = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        bienvenida = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtLog = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(108, 19, 43));

        txtMensaje.setBackground(new java.awt.Color(187, 174, 177));
        txtMensaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMensajeKeyPressed(evt);
            }
        });

        jButton1.setText("Enviar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnMostrarArchivos.setText("Abrir archivos");
        btnMostrarArchivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarArchivosActionPerformed(evt);
            }
        });

        jButton3.setText("Desconectar");

        bienvenida.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        bienvenida.setForeground(java.awt.Color.white);
        bienvenida.setText("Bienvenido");

        txtLog.setEditable(false);
        jScrollPane2.setViewportView(txtLog);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMostrarArchivos)
                            .addComponent(bienvenida)
                            .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bienvenida)
                    .addComponent(jButton3))
                .addGap(13, 13, 13)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMostrarArchivos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!txtMensaje.getText().isEmpty()){
            try {
                String ans = "<br> <b>Tú</b>: "+txtMensaje.getText()+"<br>"+
                    "<b>Poli-bot: </b>"+this.servidor.resolver(txtMensaje.getText());
                txtLog.setText(this.log +ans);
                this.log += ans;
                txtMensaje.setText("");
            }
            catch (RemoteException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtMensajeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMensajeKeyPressed
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(!txtMensaje.getText().isEmpty()){
                try {
                    txtLog.setContentType("text/html");
                    String ans = "<br> <b>Tú: </b>" + txtMensaje.getText()+" <br>"
                        +"<b>Poli-bot: </b>"+this.servidor.resolver(txtMensaje.getText());
                    txtLog.setText(this.log + ans);
                    this.log += ans;
                    txtMensaje.setText("");
                }
                catch (RemoteException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_txtMensajeKeyPressed

    // Abrir carpeta en explorador de archivos
    private void btnMostrarArchivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarArchivosActionPerformed
        try {
            Desktop.getDesktop().open(new File("archivos_cliente/"));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnMostrarArchivosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Cliente_chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente_chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente_chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente_chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente_chat().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bienvenida;
    private javax.swing.JButton btnMostrarArchivos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JEditorPane txtLog;
    private javax.swing.JTextField txtMensaje;
    // End of variables declaration//GEN-END:variables
}
