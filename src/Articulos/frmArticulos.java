/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Articulos;

import clases.Metodos;
import clases.MetodosArticulos;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

/**
 *
 * @author usuario
 */
public class frmArticulos extends javax.swing.JFrame {

    /**
     * Creates new form frmArticulos
     */
     
    public Dimension desktopSize;// variable para posicionar el jinternal
    public Dimension FrameSize;// variable para posicionar el jinternal
    MetodosArticulos met = new MetodosArticulos();
    public static boolean vezuna;
    public frmArticulos() {
        initComponents();
        //tamañopantalla();
       
        
    }
    
    public void tamañopantalla()
    {
        Toolkit t = Toolkit.getDefaultToolkit();
       Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
       this.setSize(new Dimension(screenSize.width, screenSize.height));
       panelarticulos.setSize(new Dimension(screenSize.width, screenSize.height));
    }
    public void abrirbuscar()
    {   frmArticulosBuscar buscar = new frmArticulosBuscar();
        panelarticulos.add(buscar);
        desktopSize = panelarticulos.getSize();
        FrameSize = buscar.getSize();
        if (vezuna==false)
        {
            met.ModeloTabla();
        }
        else
        {
            frmArticulosBuscar.tblArticulosbuscar.setModel(frmArticulosBuscar.modelotablaArticulos);
            met.tamañocolumnas();       
            met.acomodofilas();
        }
        met.ArticulosBuscar();
        frmArticulosBuscar.inicializador=1;
        buscar.show();   
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelarticulos = new javax.swing.JPanel();
        lblminimizar = new javax.swing.JLabel();
        lblcerrar = new javax.swing.JLabel();
        panelarticulos2 = new javax.swing.JPanel();
        btnNuevo = new javax.swing.JButton();
        btnArticulosBuscar = new javax.swing.JButton();
        btnArticulosEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

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

        javax.swing.GroupLayout panelarticulosLayout = new javax.swing.GroupLayout(panelarticulos);
        panelarticulos.setLayout(panelarticulosLayout);
        panelarticulosLayout.setHorizontalGroup(
            panelarticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelarticulosLayout.createSequentialGroup()
                .addGap(0, 318, Short.MAX_VALUE)
                .addComponent(lblminimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblcerrar))
        );
        panelarticulosLayout.setVerticalGroup(
            panelarticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelarticulosLayout.createSequentialGroup()
                .addGroup(panelarticulosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblcerrar)
                    .addComponent(lblminimizar))
                .addGap(220, 220, 220))
        );

        javax.swing.GroupLayout panelarticulos2Layout = new javax.swing.GroupLayout(panelarticulos2);
        panelarticulos2.setLayout(panelarticulos2Layout);
        panelarticulos2Layout.setHorizontalGroup(
            panelarticulos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 385, Short.MAX_VALUE)
        );
        panelarticulos2Layout.setVerticalGroup(
            panelarticulos2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 246, Short.MAX_VALUE)
        );

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnArticulosBuscar.setText("Buscar");
        btnArticulosBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArticulosBuscarActionPerformed(evt);
            }
        });

        btnArticulosEditar.setText("Editar");
        btnArticulosEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArticulosEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelarticulos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnNuevo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(btnArticulosBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(btnArticulosEditar)))
                .addContainerGap(266, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panelarticulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(btnArticulosBuscar)
                        .addGap(12, 12, 12)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(22, 22, 22)
                        .addComponent(btnArticulosEditar)
                        .addGap(57, 57, 57))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelarticulos2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(panelarticulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        frmArticulosNuevos crear = new frmArticulosNuevos();
        panelarticulos2.add(crear);
        desktopSize = panelarticulos2.getSize();
        FrameSize = crear.getSize();
        crear.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        crear.show();
        int id = met.UltimoIdArticulo();
        frmArticulosNuevos.lblidArticulo.setText(id+"");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnArticulosBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArticulosBuscarActionPerformed
        // TODO add your handling code here:
       frmArticulosBuscar buscar = new frmArticulosBuscar();
        panelarticulos.add(buscar);
        desktopSize = panelarticulos.getSize();
        FrameSize = buscar.getSize();
         buscar.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        if (vezuna==false)
        {
            met.ModeloTabla();
        }
        else
        {
            frmArticulosBuscar.tblArticulosbuscar.setModel(frmArticulosBuscar.modelotablaArticulos);
            met.tamañocolumnas();       
            met.acomodofilas();
        }
        met.ArticulosBuscar();
        frmArticulosBuscar.inicializador=1;
        buscar.show();   
        
    }//GEN-LAST:event_btnArticulosBuscarActionPerformed

    private void btnArticulosEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArticulosEditarActionPerformed
        // TODO add your handling code here:
        frmArticulosBuscar editar = new frmArticulosBuscar();
        panelarticulos.add(editar);
        desktopSize = panelarticulos.getSize();
        FrameSize = editar.getSize();
         editar.setLocation((desktopSize.width - FrameSize.width)/150, (desktopSize.height- FrameSize.height)/150);
        if (vezuna==false)
        {
            met.ModeloTabla();
        }
        else
        {
            frmArticulosBuscar.tblArticulosbuscar.setModel(frmArticulosBuscar.modelotablaArticulos);
            met.tamañocolumnas();       
            met.acomodofilas();
        }
        met.ArticulosBuscar();
        frmArticulosBuscar.inicializador=2;
        editar.show();   
         editar.show();   editar.show();  
    }//GEN-LAST:event_btnArticulosEditarActionPerformed

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
            java.util.logging.Logger.getLogger(frmArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmArticulos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmArticulos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArticulosBuscar;
    private javax.swing.JButton btnArticulosEditar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel lblcerrar;
    private javax.swing.JLabel lblminimizar;
    public static javax.swing.JPanel panelarticulos;
    public static javax.swing.JPanel panelarticulos2;
    // End of variables declaration//GEN-END:variables
}
