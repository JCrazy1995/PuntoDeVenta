/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proveedores;

import clases.MetodosProveedores;
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
public class frmProveedores extends javax.swing.JFrame {

    /**
     * Creates new form frmProveedores
     */
    public Dimension desktopSize;// variable para posicionar el jinternal
    public Dimension FrameSize;// variable para posicionar el jinternal
    MetodosProveedores met= new MetodosProveedores();
    public static boolean vezuna = false;
    int lasid ;//varible saber el ulrimo id ingresado en la bd
    public frmProveedores() {
        initComponents();
        tamañopantalla();
    }
     public void tamañopantalla()
    {
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
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/nana.jpg"));
        Image image2 = icon.getImage();
        panel2 = new javax.swing.JDesktopPane(){

            public void paintComponent(Graphics g){
                g.drawImage(image2,0,0,getWidth(),getHeight(),this);
            }
        }

        ;
        btnNuevo = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        lblminimizar = new javax.swing.JLabel();
        lblcerrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jDesktopPane1.setBackground(java.awt.Color.gray);

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        panel2.setLayer(btnNuevo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(btnBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(btnEditar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(btnRegresar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNuevo)
                    .addComponent(btnBuscar)
                    .addComponent(btnEditar)
                    .addComponent(btnRegresar))
                .addContainerGap(504, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevo)
                .addGap(29, 29, 29)
                .addComponent(btnBuscar)
                .addGap(44, 44, 44)
                .addComponent(btnEditar)
                .addGap(18, 18, 18)
                .addComponent(btnRegresar)
                .addContainerGap(257, Short.MAX_VALUE))
        );

        lblminimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/minimizar.png"))); // NOI18N
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
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblminimizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblcerrar))
            .addComponent(panel2)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblminimizar)
                    .addComponent(lblcerrar))
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

    private void lblcerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcerrarMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_lblcerrarMouseClicked

    private void lblminimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblminimizarMouseClicked
        // TODO add your handling code here:
         this.setExtendedState(this.CROSSHAIR_CURSOR);
    }//GEN-LAST:event_lblminimizarMouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
         lasid= met.ultimoid();
        frmProveedorNuevo nuevo = new frmProveedorNuevo();
       
        panel2.add(nuevo);
        desktopSize = panel2.getSize();
        FrameSize = nuevo.getSize();
        nuevo.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        nuevo.show();
        frmProveedorNuevo.lblidProvedor.setText(lasid+"");
        met.ocultarbotones();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        frmProveedorBuscar buscar = new frmProveedorBuscar();
        panel2.add(buscar);
        desktopSize = panel2.getSize();
        FrameSize = buscar.getSize();
        buscar.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        if(vezuna==false){
             met.tablaModelo();
        }
        else{
            frmProveedorBuscar.tblBuscar.setModel(frmProveedorBuscar.modeloTabla);
        }
        buscar.show();
        met.mostrarProveedores();
        met.ocultarbotones();
       frmProveedorBuscar.inicializador=1;
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        frmProveedorBuscar editar = new frmProveedorBuscar();
        panel2.add(editar);
        desktopSize = panel2.getSize();
        FrameSize = editar.getSize();
        editar.setLocation((desktopSize.width - FrameSize.width)/8, (desktopSize.height- FrameSize.height)/3);
        if(vezuna==false){
             met.tablaModelo();
        }
        else{
            frmProveedorBuscar.tblBuscar.setModel(frmProveedorBuscar.modeloTabla);
        }
        editar.show();
         met.mostrarProveedores();
         met.ocultarbotones();
        frmProveedorBuscar.inicializador=2;
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        frmMenu menu= new frmMenu();
        menu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(frmProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmProveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmProveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnBuscar;
    public static javax.swing.JButton btnEditar;
    public static javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel lblcerrar;
    private javax.swing.JLabel lblminimizar;
    public static javax.swing.JDesktopPane panel2;
    // End of variables declaration//GEN-END:variables
}
