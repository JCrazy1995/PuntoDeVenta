/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proveedores;

import clases.MetodosProveedores;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author usuario
 */
public class frmProveedorBuscar extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmProveedorBuscar
     */
    public static DefaultTableModel modeloTabla = new DefaultTableModel(){
        @Override
        public boolean isCellEditable(int filas, int columnas) {
         return false;   
        }
        
    };
    MetodosProveedores met= new MetodosProveedores();
    public static int contador =0;
    public static int inicializador=0;
     Dimension desktopSize;
    Dimension FrameSize;
    public frmProveedorBuscar() {
        initComponents();
        click();
    }
    void click()
    {
        tblBuscar.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent Mouse_evt){
            if(Mouse_evt.getClickCount()==2){
               
                if(inicializador==2)//Abrir Editar
                {    if(contador>=1)//No abre dos veces el formulario frmClientes Editar.
                    {
                    }
                    else
                    {//abra el formulario de editar.
                         enviar();
//                        met.buscarclientetabla("");
                    }
                }
                else
                {
                    //No ejecuta el doble clic
                }
            }  
        }
        });
    }
    
    public void enviar(){
        frmProveedorEditar edi= new frmProveedorEditar();
        frmProveedores.panel2.add(edi);
        desktopSize = frmProveedores.panel2.getSize();
        FrameSize = edi.getSize();
        edi.setLocation((desktopSize.width - FrameSize.width)/1, (desktopSize.height- FrameSize.height)/120);
        edi.show();
        contador=1;
        btnPrueba.setEnabled(false);
//        lblRegresar.setEnabled(false);
        met.enviardatos();
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
        txtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBuscar = new javax.swing.JTable();
        lblRegresar = new javax.swing.JLabel();
        btnPrueba = new javax.swing.JButton();

        jLabel1.setText("Nombre");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        tblBuscar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblBuscar);

        lblRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/regresar.png"))); // NOI18N
        lblRegresar.setToolTipText("");
        lblRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegresarMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblRegresarMousePressed(evt);
            }
        });

        btnPrueba.setText("jButton1");
        btnPrueba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPruebaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(45, 45, 45)
                        .addComponent(txtBuscar)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblRegresar)
                .addGap(18, 18, 18)
                .addComponent(btnPrueba)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblRegresar)
                    .addComponent(btnPrueba))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarMouseClicked
        // TODO add your handling code here:
        frmProveedorBuscar.modeloTabla.setRowCount(0);
        met.mostrarbotones();
        this.dispose();
    }//GEN-LAST:event_lblRegresarMouseClicked

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        // TODO add your handling code here:
       
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
         String proveedor;
         proveedor=txtBuscar.getText().trim();
        met.filtrarDatosTableBuscar(proveedor);
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnPruebaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPruebaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnPruebaActionPerformed

    private void lblRegresarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarMousePressed
        // TODO add your handling code here:
//        frmProveedorBuscar.modeloTabla.setRowCount(0);
//        this.dispose();
    }//GEN-LAST:event_lblRegresarMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrueba;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblRegresar;
    public static javax.swing.JTable tblBuscar;
    public static javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}