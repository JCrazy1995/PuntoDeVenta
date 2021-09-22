/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Familias;

import clases.MetodosArticulos;
import clases.MetodosFamilia;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class frmFamiliaNuevos extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmArticulosCrear
     */
    MetodosFamilia met = new MetodosFamilia();
    char validarnumeros;
    
    public frmFamiliaNuevos() {
        initComponents();
        
    }
    
    public void comprobarvacios() {
        if ("".equals(txtNombreFamilia.getText())) {
            JOptionPane.showMessageDialog(this, "No dejar Campos Vacios");
        } else {
            
            String nombre;
            nombre = txtNombreFamilia.getText();
            met.FamiliaCrear(nombre);
            lblfamilia.setText(met.UltimoIdFamilia() + "");
            txtNombreFamilia.setText("");
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblfamilia = new javax.swing.JLabel();
        txtNombreFamilia = new javax.swing.JTextField();
        btnArticulosAgregar = new javax.swing.JButton();
        lblregresar = new javax.swing.JLabel();

        jLabel1.setText("N° Articulo:");

        jLabel2.setText("Nombre:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblfamilia.setText("0");

        txtNombreFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreFamiliaActionPerformed(evt);
            }
        });
        txtNombreFamilia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreFamiliaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreFamiliaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lblfamilia, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 66, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtNombreFamilia)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblfamilia)
                .addGap(18, 18, 18)
                .addComponent(txtNombreFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnArticulosAgregar.setText("Agregar");
        btnArticulosAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArticulosAgregarActionPerformed(evt);
            }
        });
        btnArticulosAgregar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnArticulosAgregarKeyPressed(evt);
            }
        });

        lblregresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/regresar.png"))); // NOI18N
        lblregresar.setToolTipText("Regresar");
        lblregresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblregresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblregresarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblregresar)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(btnArticulosAgregar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblregresar)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(btnArticulosAgregar)
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreFamiliaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreFamiliaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreFamiliaActionPerformed

    private void btnArticulosAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArticulosAgregarActionPerformed
        // TODO add your handling code here:
        comprobarvacios();
        
    }//GEN-LAST:event_btnArticulosAgregarActionPerformed

    private void txtNombreFamiliaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreFamiliaKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtNombreFamiliaKeyTyped

    private void txtNombreFamiliaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreFamiliaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnArticulosAgregar.requestFocus();
        }
    }//GEN-LAST:event_txtNombreFamiliaKeyPressed

    private void btnArticulosAgregarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnArticulosAgregarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            comprobarvacios();
        }

    }//GEN-LAST:event_btnArticulosAgregarKeyPressed

    private void lblregresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblregresarMouseClicked
        // TODO add your handling code here:
        this.dispose();
        met.mostrarbotones();
    }//GEN-LAST:event_lblregresarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArticulosAgregar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public static javax.swing.JLabel lblfamilia;
    private javax.swing.JLabel lblregresar;
    private javax.swing.JTextField txtNombreFamilia;
    // End of variables declaration//GEN-END:variables
}
