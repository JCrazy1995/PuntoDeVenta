/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;

import clases.MetodosVentas;
import clases.modalInternalFrame;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author usuario
 */
public class frmVentasBuscarArticulo2 extends modalInternalFrame {

    /**
     * Creates new form frmComprasBuscarArticulo
     */
    char validarnumeros;
    public static DefaultTableModel mo = new DefaultTableModel();
    public static boolean controlModelo = false;
    MetodosVentas met = new MetodosVentas();
    DecimalFormat df = new DecimalFormat("#.00");

    public frmVentasBuscarArticulo2() {
        initComponents();
//        met.busquedaArticulos();
        txtFiltroArticulos.requestFocus();
        pnltabla.setVisible(false);
        click();
    }

    void click() {
        tblVentassTabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent Mouse_evt) {
                if (Mouse_evt.getClickCount() == 2) {
                    enviar();
                }

            }
        });

    }

    public void enviar() {

        String id, nombre, preciocompra, precioventa;
        id = tblVentassTabla.getValueAt(tblVentassTabla.getSelectedRow(), 0).toString();
        nombre = tblVentassTabla.getValueAt(tblVentassTabla.getSelectedRow(), 1).toString();
        preciocompra = tblVentassTabla.getValueAt(tblVentassTabla.getSelectedRow(), 2).toString();
        precioventa = tblVentassTabla.getValueAt(tblVentassTabla.getSelectedRow(), 3).toString();
        lblid.setText(id);
        lblnombre.setText(nombre);
        txtprecioventa.setText(df.format(Double.parseDouble(preciocompra)) + "");
        txtpreciocompra.setText(df.format(Double.parseDouble(precioventa)) + "");
        txtcantidad.requestFocus();
        frmVentasBuscarArticulo2.txtFiltroArticulos.setText(null);
        pnltabla.setVisible(false);
    }

    public void botonguardar() {
        frmVentassnuevas.pnlTablaventas.setVisible(true);
        String id, nombre, preciocompra, precioventa, cantidad, totcompra;
        float total;
        Double totalcompra;
        id = lblid.getText();
        nombre = lblnombre.getText();
        precioventa = txtprecioventa.getText();
        preciocompra = txtpreciocompra.getText();
        cantidad = txtcantidad.getText();
        total = Float.parseFloat(lbltotal.getText());
        totcompra = df.format((Double.parseDouble(preciocompra) * Double.parseDouble(cantidad))) + "";
        totalcompra = Double.parseDouble(totcompra);
        met.enviarDatosVentas(id, nombre, precioventa, preciocompra, cantidad, total, totalcompra);
//        met.limpiarCamposFrmventasBuscarArticulo();
        txtFiltroArticulos.requestFocus();
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
        txtFiltroArticulos = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtcantidad = new javax.swing.JTextField();
        txtprecioventa = new javax.swing.JTextField();
        lblid = new javax.swing.JLabel();
        lblnombre = new javax.swing.JLabel();
        lbltotal = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtpreciocompra = new javax.swing.JTextField();
        btnagregarmovimiento = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        cbCodigoBusqueda = new javax.swing.JCheckBox();
        pnltabla = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVentassTabla = new javax.swing.JTable();

        jLabel1.setText("Nombre producto:");

        txtFiltroArticulos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFiltroArticulosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtFiltroArticulosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFiltroArticulosKeyTyped(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informacion del producto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel2.setText("ID producto:");

        jLabel3.setText("Nombre producto:");

        jLabel4.setText("Cantidad:");

        jLabel5.setText("Precio Venta:");

        jLabel6.setText("Total:");

        txtcantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcantidadKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcantidadKeyTyped(evt);
            }
        });

        txtprecioventa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtprecioventa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtprecioventaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtprecioventaKeyTyped(evt);
            }
        });

        lblid.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lbltotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setText("Precio Compra:");

        txtpreciocompra.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtpreciocompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpreciocompraKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtpreciocompraKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(63, 63, 63)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblid, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtpreciocompra, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                        .addComponent(lbltotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblnombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(txtprecioventa, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblid, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtprecioventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtpreciocompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        btnagregarmovimiento.setText("Agregar");
        btnagregarmovimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarmovimientoActionPerformed(evt);
            }
        });
        btnagregarmovimiento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnagregarmovimientoKeyPressed(evt);
            }
        });

        jButton3.setText("atras");
        jButton3.setFocusable(false);
        jButton3.setRequestFocusEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        cbCodigoBusqueda.setText("Codigo");

        tblVentassTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblVentassTabla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblVentassTablaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblVentassTabla);

        javax.swing.GroupLayout pnltablaLayout = new javax.swing.GroupLayout(pnltabla);
        pnltabla.setLayout(pnltablaLayout);
        pnltablaLayout.setHorizontalGroup(
            pnltablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnltablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnltablaLayout.setVerticalGroup(
            pnltablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnltablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFiltroArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbCodigoBusqueda))
                            .addComponent(pnltabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addComponent(btnagregarmovimiento)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFiltroArticulos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbCodigoBusqueda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnltabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnagregarmovimiento)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void txtcantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Double cantidad, precio, total;
            cantidad = Double.parseDouble(txtcantidad.getText());
            precio = Double.parseDouble(txtprecioventa.getText());
            total = precio * cantidad;
            lbltotal.setText(df.format(total) + "");
            txtprecioventa.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
    }//GEN-LAST:event_txtcantidadKeyPressed

    private void txtprecioventaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioventaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Double cantidad, precio, total;
            cantidad = Double.parseDouble(txtcantidad.getText());
            precio = Double.parseDouble(txtprecioventa.getText());
            total = precio * cantidad;
            lbltotal.setText(df.format(total) + "");
            txtpreciocompra.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
    }//GEN-LAST:event_txtprecioventaKeyPressed

    private void txtcantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcantidadKeyTyped
        // TODO add your handling code here:
        validarnumeros = evt.getKeyChar();
        if ((validarnumeros < '0' || validarnumeros > '9') && (validarnumeros <= ',' || validarnumeros > '.') || (validarnumeros == '-'))
            evt.consume();
    }//GEN-LAST:event_txtcantidadKeyTyped

    private void txtprecioventaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtprecioventaKeyTyped
        // TODO add your handling code here:
        validarnumeros = evt.getKeyChar();
        if ((validarnumeros < '0' || validarnumeros > '9') && (validarnumeros <= ',' || validarnumeros > '.') || (validarnumeros == '-'))
            evt.consume();
    }//GEN-LAST:event_txtprecioventaKeyTyped

    private void tblVentassTablaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblVentassTablaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            enviar();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
    }//GEN-LAST:event_tblVentassTablaKeyPressed

    private void txtFiltroArticulosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroArticulosKeyPressed
        // TODO add your handling code here:

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (mo.getRowCount() > 0) {
                tblVentassTabla.requestFocus();
                tblVentassTabla.changeSelection(0, 0, false, false);
            }

        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
    }//GEN-LAST:event_txtFiltroArticulosKeyPressed

    private void txtFiltroArticulosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroArticulosKeyTyped
        // TODO add your handling code here:

    }//GEN-LAST:event_txtFiltroArticulosKeyTyped

    private void txtFiltroArticulosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltroArticulosKeyReleased
        // TODO add your handling code here:
        String Articulo;
        int id;
        if ("".equals(txtFiltroArticulos.getText())) {
            pnltabla.setVisible(false);
        } else {
            met.modeloTablaBuscar();
            pnltabla.setVisible(true);

            try {
                id = Integer.parseInt(txtFiltroArticulos.getText().trim());
                met.filtradoBusquedaID(id);
            } catch (Exception e) {
                Articulo = txtFiltroArticulos.getText();
                met.filtradoBusquedaNombre(Articulo);
            }
        }


    }//GEN-LAST:event_txtFiltroArticulosKeyReleased

    private void btnagregarmovimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarmovimientoActionPerformed
        // TODO add your handling code here:
        botonguardar();


    }//GEN-LAST:event_btnagregarmovimientoActionPerformed

    private void btnagregarmovimientoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnagregarmovimientoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            botonguardar();
        }
        txtFiltroArticulos.requestFocus();
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
    }//GEN-LAST:event_btnagregarmovimientoKeyPressed

    private void txtpreciocompraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpreciocompraKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnagregarmovimiento.requestFocus();
        }
        if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
    }//GEN-LAST:event_txtpreciocompraKeyPressed

    private void txtpreciocompraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpreciocompraKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpreciocompraKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregarmovimiento;
    private javax.swing.JCheckBox cbCodigoBusqueda;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lblid;
    public static javax.swing.JLabel lblnombre;
    public static javax.swing.JLabel lbltotal;
    private javax.swing.JPanel pnltabla;
    public static javax.swing.JTable tblVentassTabla;
    public static javax.swing.JTextField txtFiltroArticulos;
    public static javax.swing.JTextField txtcantidad;
    public static javax.swing.JTextField txtpreciocompra;
    public static javax.swing.JTextField txtprecioventa;
    // End of variables declaration//GEN-END:variables
}
