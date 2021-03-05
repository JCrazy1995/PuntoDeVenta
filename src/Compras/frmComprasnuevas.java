/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compras;

import clases.MetodosCompras;
import clases.MetodosProveedores;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import proveedores.frmProveedorBuscar;
import proveedores.frmProveedores;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author usuario
 */
public class frmComprasnuevas extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmComprasnuevas
     */
    public Dimension desktopSize;// variable para posicionar el jinternal
    public Dimension FrameSize;// variable para posicionar el jinternal
    MetodosProveedores metprovedor = new MetodosProveedores();
    MetodosCompras metcomCompras = new MetodosCompras();
    public static DateFormat formatofecha = new SimpleDateFormat("dd/MM/yy");
    SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yy");// variable para el formato de la fecha a mostrar en el lblfechapago
    Date fecha; //Variable tomar fecha del jdate chooser
    static String fechapago; //fecha con formato a mostrar
    int dias;
    public static int fila=0,columna=0;
    public static int click=0;
    public static DefaultTableModel modelo = new DefaultTableModel();
    public static boolean controlModelo = false;

    public frmComprasnuevas() {
        initComponents();
        jdcfechacompra.setDate(new Date());
        jdcfechacompra.setEnabled(false);
        pnlTablaCompras.setVisible(false);
        lblidcompra.setText(metcomCompras.ultimoidcompra() + "");
        dobleclick();
    }

    public void prueba() {
        jdcfechacompra.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            @Override
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdcfechacompraPropertyChange(evt);
            }
        });
    }

    public void guardarcompra() {
        int idcompra, idproveedor,idarticulo;
        int filas = modelo.getRowCount();
        float total,cantidad,preciocompra;
        String fechacompra, fecha_pago;
        if (filas == 0 || "".equals(lblFechaPago.getText())) {
            JOptionPane.showMessageDialog(null, "Faltan datos para guardar");
            return;
        }
        SimpleDateFormat formatomysql = new SimpleDateFormat("yyyy-MM-dd");
        fecha_pago = formatomysql.format(metcomCompras.sumarRestarDiasFecha(fecha, dias));
        fechacompra = formatomysql.format(metcomCompras.sumarRestarDiasFecha(fecha, 0));
        idcompra = Integer.parseInt(lblidcompra.getText());
        idproveedor = Integer.parseInt(lblNproveedor.getText());
        total = Float.parseFloat(lblTotal.getText());
        metcomCompras.guardarcompras(idproveedor, total, fechacompra, fecha_pago);
         
        for(int x=0;x<filas;x++){
            idarticulo=Integer.parseInt(tblCompra.getValueAt(x, 0).toString());
            cantidad = Float.parseFloat(tblCompra.getValueAt(x, 3).toString());
            preciocompra = Float.parseFloat(tblCompra.getValueAt(x, 2).toString());
            metcomCompras.actualizarexistenciaaritculos(idarticulo, preciocompra, cantidad);
            metcomCompras.guardarcomprasmovimientos(idcompra,idarticulo,cantidad,preciocompra);
        }
        
        lblidcompra.setText(metcomCompras.ultimoidcompra() + "");
        limpiarFormulario();
    }
    
    
    public void limpiarFormulario(){
        lblNproveedor.setText("");
        lblProvedornombre1.setText("");
        lbltipopago.setText("");
        lbldiascredito.setText("");
        jdcfechacompra.setDate(new Date());
        lblFechaPago.setText("");
        modelo.setRowCount(0);
        lblTotal.setText("0");
        pnlTablaCompras.setVisible(false);
        jdcfechacompra.setEnabled(false);
    }
    
    public static void dobleclick()
    {
       
            tblCompra.addMouseListener(new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent Mouse_evt){
            
            
            if(Mouse_evt.getClickCount()==1 ){
               fila= tblCompra.getSelectedRow();
               frmeditaroeliminararticulotabla me=new frmeditaroeliminararticulotabla();
               columna = tblCompra.getColumnCount();
               frmeditaroeliminararticulotabla.totalCompra=Float.parseFloat(lblTotal.getText());
               frmeditaroeliminararticulotabla.totalfila=Float.parseFloat(tblCompra.getValueAt(fila, 4).toString());
               frmeditaroeliminararticulotabla.lblid.setText(tblCompra.getValueAt(fila, 0).toString());
               frmeditaroeliminararticulotabla.lblnombre.setText(tblCompra.getValueAt(fila, 1).toString());
               frmeditaroeliminararticulotabla.txtprecio.setText(tblCompra.getValueAt(fila, 2).toString());
               frmeditaroeliminararticulotabla.txtcantidad.setText(tblCompra.getValueAt(fila, 3).toString());
               frmeditaroeliminararticulotabla.lbltotal.setText(tblCompra.getValueAt(fila, 4).toString());
               me.setModal(true);
               frmCompras.panel2.add(me);
               me.setVisible(true);
              
               
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

        panRegistro = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblNproveedor = new javax.swing.JLabel();
        lbldiascredito = new javax.swing.JLabel();
        lblProvedornombre1 = new javax.swing.JLabel();
        lbltipopago = new javax.swing.JLabel();
        btnbuscarProveedor = new javax.swing.JButton();
        btnBuscarArticulos = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jdcfechacompra = new com.toedter.calendar.JDateChooser();
        lblFechaPago = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblidcompra = new javax.swing.JLabel();
        pnlTablaCompras = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCompra = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Prueba"));

        jLabel1.setText("N° Proveedor");

        jLabel2.setText("Proveedor");

        jLabel5.setText("Dias Credito:");

        jLabel6.setText("Tipo Pago");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblNproveedor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNproveedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbldiascredito.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblProvedornombre1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lbltipopago.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbldiascredito, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(lbltipopago, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblProvedornombre1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNproveedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblProvedornombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbltipopago, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbldiascredito, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnbuscarProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        btnbuscarProveedor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnbuscarProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarProveedorActionPerformed(evt);
            }
        });

        btnBuscarArticulos.setText("Buscar Articulos");
        btnBuscarArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarArticulosActionPerformed(evt);
            }
        });

        jLabel4.setText("Fecha Pago:");

        jLabel3.setText("Fecha Compra:");

        jdcfechacompra.setDateFormatString("dd/MM/y");
        jdcfechacompra.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdcfechacompraPropertyChange(evt);
            }
        });

        jLabel8.setText("N° Compra");

        lblidcompra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblidcompra.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblidcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblidcompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(btnbuscarProveedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(btnBuscarArticulos)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcfechacompra, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jdcfechacompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnbuscarProveedor)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(64, 64, 64)
                                .addComponent(btnBuscarArticulos))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        tblCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblCompra);

        javax.swing.GroupLayout pnlTablaComprasLayout = new javax.swing.GroupLayout(pnlTablaCompras);
        pnlTablaCompras.setLayout(pnlTablaComprasLayout);
        pnlTablaComprasLayout.setHorizontalGroup(
            pnlTablaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTablaComprasLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        pnlTablaComprasLayout.setVerticalGroup(
            pnlTablaComprasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTablaComprasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jLabel7.setText("Total:");

        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotal.setText("0");

        javax.swing.GroupLayout panRegistroLayout = new javax.swing.GroupLayout(panRegistro);
        panRegistro.setLayout(panRegistroLayout);
        panRegistroLayout.setHorizontalGroup(
            panRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlTablaCompras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panRegistroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );
        panRegistroLayout.setVerticalGroup(
            panRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTablaCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblTotal))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        btnGuardar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnGuardarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(btnGuardar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jdcfechacompraPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcfechacompraPropertyChange
        // TODO add your handling code here:
        try {
            fecha = jdcfechacompra.getDate();///tomo el valor del jdate chooser
            fechapago = formatofecha.format(fecha); ///le aplico el formato de dia/mes/año
            dias = Integer.parseInt(lbldiascredito.getText());
            lblFechaPago.setText(formateador.format(metcomCompras.sumarRestarDiasFecha(fecha, dias)));

        } catch (Exception e) {
        }
    }//GEN-LAST:event_jdcfechacompraPropertyChange

    private void btnBuscarArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarArticulosActionPerformed
        // TODO add your handling code here:
        if(lblNproveedor.getText().equals("")){
            JOptionPane.showMessageDialog(null, "No ha elegido proveedor");
        }
        frmComprasBuscarArticulo buscar = new frmComprasBuscarArticulo();
        buscar.setModal(true);
        desktopSize = frmCompras.panel2.getSize();
        FrameSize = buscar.getSize();
        buscar.setLocation((desktopSize.width - FrameSize.width)/2, (desktopSize.height- FrameSize.height)/2);
        frmCompras.panel2.add(buscar);
        buscar.show();
    }//GEN-LAST:event_btnBuscarArticulosActionPerformed

    private void btnbuscarProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarProveedorActionPerformed
        // TODO add your handling code here:
        frmProveedorBuscar buscar = new frmProveedorBuscar();
        buscar.setModal(true);
        buscar.setBounds(160, 180, 550, 450);
        frmCompras.panel2.add(buscar);
        desktopSize = frmCompras.panel2.getSize();
        FrameSize = buscar.getSize();
        buscar.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        frmProveedorBuscar.inicializador = 3;
        if (frmProveedores.vezuna == false) {
            metprovedor.tablaModelo();
        } else {
            frmProveedorBuscar.tblBuscar.setModel(frmProveedorBuscar.modeloTabla);
        }

        metprovedor.mostrarProveedores();
        buscar.show();

    }//GEN-LAST:event_btnbuscarProveedorActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        guardarcompra();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardarKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_btnGuardarKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarArticulos;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnbuscarProveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public static com.toedter.calendar.JDateChooser jdcfechacompra;
    public static javax.swing.JLabel lblFechaPago;
    public static javax.swing.JLabel lblNproveedor;
    public static javax.swing.JLabel lblProvedornombre1;
    public static javax.swing.JLabel lblTotal;
    public static javax.swing.JLabel lbldiascredito;
    public static javax.swing.JLabel lblidcompra;
    public static javax.swing.JLabel lbltipopago;
    private javax.swing.JPanel panRegistro;
    public static javax.swing.JPanel pnlTablaCompras;
    public static javax.swing.JTable tblCompra;
    // End of variables declaration//GEN-END:variables
}
