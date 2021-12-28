/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;

import clases.MetodosImprimir;
import clases.MetodosVentas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import puntodeventa.frmMenu;

/**
 *
 * @author usuario
 */
public class frmVentas extends javax.swing.JFrame {

    /**
     * Creates new form frmCompras
     */
    public Dimension desktopSize;// variable para posicionar el jinternal
    public Dimension FrameSize;// variable para posicionar el jinternal
    MetodosVentas metventas = new MetodosVentas();
    MetodosImprimir metimprimir = new MetodosImprimir();

    public frmVentas() {
        initComponents();
        tamañopantalla();
    }

    public void tamañopantalla() {
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new Dimension(screenSize.width, screenSize.height));
        panel2.setSize(new Dimension(screenSize.width, screenSize.height));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/wanda.jpg"));
        Image image2 = icon.getImage();
        panel2 = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image2,0,0,getWidth(),getHeight(),this);
            }

        };
        btnRegresar = new javax.swing.JButton();
        btnventasnuevas = new javax.swing.JButton();
        btnreimprimir = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        lblminimizar = new javax.swing.JLabel();
        lblcerrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jDesktopPane1.setBackground(java.awt.Color.gray);

        btnRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/regresar.png"))); // NOI18N
        btnRegresar.setToolTipText("Regresar");
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnventasnuevas.setText("Registrar");
        btnventasnuevas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnventasnuevasActionPerformed(evt);
            }
        });

        btnreimprimir.setText("Reimprimir");
        btnreimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreimprimirActionPerformed(evt);
            }
        });

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        panel2.setLayer(btnRegresar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(btnventasnuevas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(btnreimprimir, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(btncancelar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(panel2Layout.createSequentialGroup()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(btnventasnuevas)
                        .addGap(56, 56, 56)
                        .addComponent(btncancelar))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(btnreimprimir)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnventasnuevas)
                    .addComponent(btncancelar))
                .addGap(29, 29, 29)
                .addComponent(btnreimprimir)
                .addGap(0, 246, Short.MAX_VALUE))
        );

        lblminimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/minimizar.png"))); // NOI18N
        lblminimizar.setToolTipText("Minimizar");
        lblminimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblminimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblminimizarMouseClicked(evt);
            }
        });

        lblcerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cerrar.png"))); // NOI18N
        lblcerrar.setToolTipText("Cerrar");
        lblcerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblcerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblcerrarMouseClicked(evt);
            }
        });

        jDesktopPane1.setLayer(panel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lblminimizar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lblcerrar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(0, 474, Short.MAX_VALUE)
                .addComponent(lblminimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblcerrar))
            .addComponent(panel2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcerrar)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lblminimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblminimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblminimizarMouseClicked
        // TODO add your handling code here:

        this.setExtendedState(this.CROSSHAIR_CURSOR);
    }//GEN-LAST:event_lblminimizarMouseClicked

    private void lblcerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcerrarMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_lblcerrarMouseClicked

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        frmMenu menu = new frmMenu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnventasnuevasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnventasnuevasActionPerformed
        // TODO add your handling code here:
        frmVentassnuevas ventas = new frmVentassnuevas();
        panel2.add(ventas);
        desktopSize = panel2.getSize();
        FrameSize = ventas.getSize();
        ventas.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);

        metventas.modeloTablaVentas();
        ventas.show();
    }//GEN-LAST:event_btnventasnuevasActionPerformed

    private void btnreimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreimprimirActionPerformed
        // TODO add your handling code here:
        frmrventasreimprimir.modelo.setRowCount(0);
        frmrventasreimprimir reimprimir = new frmrventasreimprimir();
        panel2.add(reimprimir);
        desktopSize = panel2.getSize();
        FrameSize = reimprimir.getSize();
        reimprimir.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        reimprimir.show();
        metimprimir.modelotablareimprimir();
        metimprimir.llenartablareimpiresion();
    }//GEN-LAST:event_btnreimprimirActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:
        
        frmventasbuscarcancelar.modelo.setRowCount(0);
        frmventasbuscarcancelar cancelar = new frmventasbuscarcancelar();
        panel2.add(cancelar);
        desktopSize = panel2.getSize();
        FrameSize = cancelar.getSize();
        cancelar.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        cancelar.show();
        metventas.modelotablabuscarcancelar();
        metventas.llenartablabuscarcancelar();
    }//GEN-LAST:event_btncancelarActionPerformed

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
            java.util.logging.Logger.getLogger(frmVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btnreimprimir;
    private javax.swing.JButton btnventasnuevas;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel lblcerrar;
    private javax.swing.JLabel lblminimizar;
    public static javax.swing.JDesktopPane panel2;
    // End of variables declaration//GEN-END:variables
}
