/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SubFamilias;



import clases.MetodosSubFamilia;
import puntodeventa.frmMenu;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;



/**
 *
 * @author usuario
 */
public class frmsubfamilia extends javax.swing.JFrame {

    /**
     * Creates new form frmArticulos3
     */
    public Dimension desktopSize;// variable para posicionar el jinternal
    public Dimension FrameSize;// variable para posicionar el jinternal
     MetodosSubFamilia met = new MetodosSubFamilia();
    public static boolean vezuna;
    public frmsubfamilia() {
        initComponents();
        tamañopantalla();
        
       
    }

      public void tamañopantalla(){
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

        panel2 = new javax.swing.JDesktopPane();
        ImageIcon icon = new ImageIcon(getClass().getResource("/Imagenes/naruto.jpg"));
        Image image2 = icon.getImage();
        panel1 = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image2,0,0,getWidth(),getHeight(),this);
            }
        }
        ;
        btnsubFamiliasEditar = new javax.swing.JButton();
        btnsubFamiliaNuevo = new javax.swing.JButton();
        btnsubFamiliaBuscar = new javax.swing.JButton();
        lblRegresar = new javax.swing.JLabel();
        lblminimizar = new javax.swing.JLabel();
        lblcerrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        panel2.setBackground(java.awt.Color.gray);

        panel1.setBackground(new java.awt.Color(171, 181, 214));

        btnsubFamiliasEditar.setText("Editar");
        btnsubFamiliasEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsubFamiliasEditarActionPerformed(evt);
            }
        });

        btnsubFamiliaNuevo.setText("Nuevo");
        btnsubFamiliaNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsubFamiliaNuevoActionPerformed(evt);
            }
        });

        btnsubFamiliaBuscar.setText("Buscar");
        btnsubFamiliaBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsubFamiliaBuscarActionPerformed(evt);
            }
        });

        lblRegresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/regresar.png"))); // NOI18N
        lblRegresar.setToolTipText("Regresar");
        lblRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblRegresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRegresarMouseClicked(evt);
            }
        });

        panel1.setLayer(btnsubFamiliasEditar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel1.setLayer(btnsubFamiliaNuevo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel1.setLayer(btnsubFamiliaBuscar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel1.setLayer(lblRegresar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnsubFamiliaBuscar)
                    .addComponent(btnsubFamiliaNuevo)
                    .addComponent(btnsubFamiliasEditar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(lblRegresar)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(lblRegresar)
                .addGap(44, 44, 44)
                .addComponent(btnsubFamiliaBuscar)
                .addGap(18, 18, 18)
                .addComponent(btnsubFamiliasEditar)
                .addGap(35, 35, 35)
                .addComponent(btnsubFamiliaNuevo)
                .addGap(0, 268, Short.MAX_VALUE))
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

        panel2.setLayer(panel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(lblminimizar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel2.setLayer(lblcerrar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addContainerGap(578, Short.MAX_VALUE)
                .addComponent(lblminimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblcerrar))
            .addComponent(panel1)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcerrar)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lblminimizar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel1))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel2)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsubFamiliasEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsubFamiliasEditarActionPerformed
        // TODO add your handling code here:
        
        frmSubfamiliaBuscar editar = new frmSubfamiliaBuscar();
        
        panel1.add(editar);
        desktopSize = panel1.getSize();
        FrameSize = editar.getSize();
        editar.setLocation((desktopSize.width - FrameSize.width)/150, (desktopSize.height- FrameSize.height)/8);
        if (vezuna==false)
        {
            met.ModeloTabla();
            vezuna=true;
        }
        else
        {
            frmSubfamiliaBuscar.tblsubfamilabuscar.setModel(frmSubfamiliaBuscar.modelotablasubfamilia);
            met.tamañocolumnas();
            met.acomodofilas();
        }
        met.SubFamiliaBuscar();
        frmSubfamiliaBuscar.inicializador=2;
        editar.show();
        met.ocultarbotones();
    }//GEN-LAST:event_btnsubFamiliasEditarActionPerformed

    private void btnsubFamiliaNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsubFamiliaNuevoActionPerformed
        // TODO add your handling code here:
        frmSubFamiliaNuevos crear = new frmSubFamiliaNuevos();
        panel1.add(crear);
        desktopSize = panel1.getSize();
        FrameSize = crear.getSize();
        crear.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        crear.show();
        int id = met.UltimoIdSubFamilia();
        frmSubFamiliaNuevos.lblsubfamilia.setText(id+"");
        met.ocultarbotones();
        met.rellenarcmbfamilia();
    }//GEN-LAST:event_btnsubFamiliaNuevoActionPerformed

    private void btnsubFamiliaBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsubFamiliaBuscarActionPerformed
        // TODO add your handling code here:
        frmSubfamiliaBuscar buscar = new frmSubfamiliaBuscar();
        panel1.add(buscar);
        desktopSize = panel1.getSize();
        FrameSize = buscar.getSize();
        buscar.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        if (vezuna==false)
        {
            met.ModeloTabla();
        }
        else
        {
            frmSubfamiliaBuscar.tblsubfamilabuscar.setModel(frmSubfamiliaBuscar.modelotablasubfamilia);
            met.tamañocolumnas();
            met.acomodofilas();
        }
        met.SubFamiliaBuscar();
        frmSubfamiliaBuscar.inicializador=1;
        buscar.show();
        met.ocultarbotones();
    }//GEN-LAST:event_btnsubFamiliaBuscarActionPerformed

    private void lblminimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblminimizarMouseClicked
        // TODO add your handling code here:

        this.setExtendedState(this.CROSSHAIR_CURSOR);
    }//GEN-LAST:event_lblminimizarMouseClicked

    private void lblcerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblcerrarMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_lblcerrarMouseClicked

    private void lblRegresarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRegresarMouseClicked
        // TODO add your handling code here:
        this.dispose();
        frmMenu menu= new frmMenu();
        menu.setVisible(true);
    }//GEN-LAST:event_lblRegresarMouseClicked

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
            java.util.logging.Logger.getLogger(frmsubfamilia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmsubfamilia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmsubfamilia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmsubfamilia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmsubfamilia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnsubFamiliaBuscar;
    public static javax.swing.JButton btnsubFamiliaNuevo;
    public static javax.swing.JButton btnsubFamiliasEditar;
    private javax.swing.JLabel lblRegresar;
    private javax.swing.JLabel lblcerrar;
    private javax.swing.JLabel lblminimizar;
    public static javax.swing.JDesktopPane panel1;
    private javax.swing.JDesktopPane panel2;
    // End of variables declaration//GEN-END:variables
}