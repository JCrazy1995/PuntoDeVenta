/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;

import clases.MetodosImprimir;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author usuario
 */
public class frmrventasreimprimir extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmrventasreimprimir
     */
    String cliente,

    /**
     * Creates new form frmrventasreimprimir
     */
    numero;
    TableRowSorter trs;
    int filavalor = -1;
    public static DefaultTableModel modelo = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int filas, int columnas) {
            return false;
        }

    };
    ;
    MetodosImprimir metimprimir = new MetodosImprimir();
    public static boolean controlModelo;

    public frmrventasreimprimir() {
        initComponents();
        chbCopia.setSelected(true);
    }

    public void valorfila() {
        try {
            filavalor = tblreimprimecliente.getSelectedRow();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seleccionar Venta Para su Visualización");
        }
        if (filavalor > -1) {
            cliente = tblreimprimecliente.getValueAt(filavalor, 1).toString();
            numero = tblreimprimecliente.getValueAt(filavalor, 0).toString();

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

        txtbuscarcliente = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblreimprimecliente = new javax.swing.JTable();
        btnvernota = new javax.swing.JButton();
        chbCopia = new javax.swing.JCheckBox();
        btnreimprimir = new javax.swing.JButton();

        txtbuscarcliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarclienteKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 559, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        tblreimprimecliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblreimprimecliente);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 22, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        btnvernota.setText("Visualizar");
        btnvernota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvernotaActionPerformed(evt);
            }
        });

        chbCopia.setText("Copia");

        btnreimprimir.setText("Imprimir");
        btnreimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreimprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(txtbuscarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbCopia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnvernota)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnreimprimir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtbuscarcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnvernota)
                    .addComponent(chbCopia)
                    .addComponent(btnreimprimir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbuscarclienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarclienteKeyReleased
        // TODO add your handling code here:
        txtbuscarcliente.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + txtbuscarcliente.getText(), 1));
            }
        });
        trs = new TableRowSorter(tblreimprimecliente.getModel());
        tblreimprimecliente.setRowSorter(trs);
    }//GEN-LAST:event_txtbuscarclienteKeyReleased

    private void btnvernotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvernotaActionPerformed
        // TODO add your handling code here:
        valorfila();
        JOptionPane.showMessageDialog(null, cliente +"  "+numero);
        if (chbCopia.isSelected()) {
            metimprimir.visualizarnotaCopia(cliente, numero);

        } else {
            metimprimir.visualizarnotaOriginal(cliente, numero);
        }
    }//GEN-LAST:event_btnvernotaActionPerformed

    private void btnreimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreimprimirActionPerformed
        // TODO add your handling code here:
        valorfila();
        if (chbCopia.isSelected()) {
            metimprimir.ReImprimirnotaCopia(cliente, numero);

        } else {
            metimprimir.ReImprimirnotaOriginal(cliente, numero);
        }
    }//GEN-LAST:event_btnreimprimirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnreimprimir;
    private javax.swing.JButton btnvernota;
    private javax.swing.JCheckBox chbCopia;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable tblreimprimecliente;
    private javax.swing.JTextField txtbuscarcliente;
    // End of variables declaration//GEN-END:variables
}
