/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventas;

import Usuarios.frmClientes;
import Usuarios.frmClientesBuscar;
import clases.Metodos;
import clases.MetodosVentas;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author usuario
 */
public class frmVentassnuevas extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmComprasnuevas
     */
    public Dimension desktopSize;// variable para posicionar el jinternal
    public Dimension FrameSize;// variable para posicionar el jinternal
    Metodos metcliente = new Metodos();
    MetodosVentas metventas = new MetodosVentas();
    public static DateFormat formatofecha = new SimpleDateFormat("dd/MM/yy");
    SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yy");// variable para el formato de la fecha a mostrar en el lblfechapago
    Date fecha; //Variable tomar fecha del jdate chooser
    static String fechapago; //fecha con formato a mostrar
    int dias;
    public static int fila = 0, columna = 0;
    public static int click = 0;
    public static DefaultTableModel modelo = new DefaultTableModel();
    public static boolean controlModelo = false;

    public frmVentassnuevas() {
        initComponents();
        jdcfechaventa.setDate(new Date());
        jdcfechaventa.setEnabled(false);
        pnlTablaventas.setVisible(false);
        lblidventa.setText(metventas.ultimoidcompra() + "");
        dobleclick();
    }

    public void prueba() {
        jdcfechaventa.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            @Override
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdcfechaventaPropertyChange(evt);
            }
        });
    }
///acomodar lo de guardar venta

    public void guardarventa() {
        int idventa, idcliente, idarticulo;
        int filas = modelo.getRowCount();
        float total, cantidad, preciocompra, precioventa;
        String fechaventa, fecha_pago;
        if (filas == 0 || "".equals(lblFechaPago.getText())) {
            JOptionPane.showMessageDialog(null, "Faltan datos para guardar");
            return;
        }
        SimpleDateFormat formatomysql = new SimpleDateFormat("yyyy-MM-dd");
        fecha_pago = formatomysql.format(metventas.sumarRestarDiasFecha(fecha, dias));
        fechaventa = formatomysql.format(metventas.sumarRestarDiasFecha(fecha, 0));
        idventa = Integer.parseInt(lblidventa.getText());
        idcliente = Integer.parseInt(lblncliente.getText());
        total = Float.parseFloat(lblTotalVenta.getText());
        metventas.guardarventa(idcliente, total, fechaventa, fecha_pago);

        for (int x = 0; x < filas; x++) {
            idarticulo = Integer.parseInt(tblVenta.getValueAt(x, 0).toString());
            cantidad = Float.parseFloat(tblVenta.getValueAt(x, 4).toString());
            preciocompra = Float.parseFloat(tblVenta.getValueAt(x, 2).toString());
            precioventa = Float.parseFloat(tblVenta.getValueAt(x, 3).toString());
            metventas.actualizarexistenciaaritculos(idarticulo, preciocompra, cantidad);
            metventas.guardarventasmovimientos(idventa, idarticulo, cantidad, preciocompra, precioventa);
        }

        lblidventa.setText(metventas.ultimoidcompra() + "");
        limpiarFormulario();
    }

    public void limpiarFormulario() {
        lblncliente.setText("");
        lblcliente.setText("");
        lbltipopago.setText("");
        lbldiascredito.setText("");
        jdcfechaventa.setDate(new Date());
        lblFechaPago.setText("");
        modelo.setRowCount(0);
        lblTotalVenta.setText("0");
        pnlTablaventas.setVisible(false);
        jdcfechaventa.setEnabled(false);
    }

    public static void dobleclick() {

        tblVenta.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent Mouse_evt) {

                if (Mouse_evt.getClickCount() == 1) {
                    fila = tblVenta.getSelectedRow();
                    frmeditaroeliminararticulotabla me = new frmeditaroeliminararticulotabla();
                    columna = tblVenta.getColumnCount();
                    frmeditaroeliminararticulotabla.totalCompra = Float.parseFloat(lblTotalVenta.getText());
                    frmeditaroeliminararticulotabla.totalfila = Float.parseFloat(tblVenta.getValueAt(fila, 4).toString());
                    frmeditaroeliminararticulotabla.lblid.setText(tblVenta.getValueAt(fila, 0).toString());
                    frmeditaroeliminararticulotabla.lblnombre.setText(tblVenta.getValueAt(fila, 1).toString());
                    frmeditaroeliminararticulotabla.txtprecio.setText(tblVenta.getValueAt(fila, 2).toString());
                    frmeditaroeliminararticulotabla.txtcantidad.setText(tblVenta.getValueAt(fila, 3).toString());
                    frmeditaroeliminararticulotabla.lbltotal.setText(tblVenta.getValueAt(fila, 4).toString());
                    me.setModal(true);
                    frmVentas.panel2.add(me);
                    me.setVisible(true);

                }

            }
        });

    }

    void buscararticulo() {
        if (lblncliente.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No ha elegido Cliente");
        }
        frmVentasBuscarArticulo3 buscar = new frmVentasBuscarArticulo3();
        buscar.setModal(true);
        desktopSize = frmVentas.panel2.getSize();
        FrameSize = buscar.getSize();
        buscar.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        frmVentas.panel2.add(buscar);
        buscar.show();
    }

    void buscarcliente() {
        frmClientesBuscar buscar = new frmClientesBuscar();
//        buscar.setBounds(160, 180, 550, 450);
        frmVentas.panel2.add(buscar);
        desktopSize = frmVentas.panel2.getSize();
        FrameSize = buscar.getSize();
        buscar.setLocation((desktopSize.width - FrameSize.width) / 2, (desktopSize.height - FrameSize.height) / 2);
        frmClientesBuscar.inicializador = 3;
        if (frmClientes.vezuna == false) {
            metcliente.ModeloTabla();
        } else {
            frmClientesBuscar.tblClientesBuscar.setModel(frmClientesBuscar.tablaBuscar);
        }

        metcliente.BuscarClientes();
        buscar.show();
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
        lblncliente = new javax.swing.JLabel();
        lbldiascredito = new javax.swing.JLabel();
        lblcliente = new javax.swing.JLabel();
        lbltipopago = new javax.swing.JLabel();
        lbltelefono = new javax.swing.JLabel();
        btnbuscarCliente = new javax.swing.JButton();
        btnBuscarArticulos = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jdcfechaventa = new com.toedter.calendar.JDateChooser();
        lblFechaPago = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblidventa = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblcolonia = new javax.swing.JLabel();
        lblcp = new javax.swing.JLabel();
        lblcalle = new javax.swing.JLabel();
        lblnexterior = new javax.swing.JLabel();
        pnlTablaventas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVenta = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblTotalcompra = new javax.swing.JLabel();
        lblTotalVenta = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Prueba"));

        jLabel1.setText("Colonia:");

        jLabel2.setText("Calle:");

        jLabel5.setText("CP:");

        jLabel6.setText("N° Exterior:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))))
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

        lblncliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblncliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbldiascredito.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblcliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lbltipopago.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lbltelefono.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbldiascredito, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbltipopago, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblcliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblncliente, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                    .addComponent(lbltelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblncliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbltipopago, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbldiascredito, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbltelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnbuscarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lupa.png"))); // NOI18N
        btnbuscarCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnbuscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarClienteActionPerformed(evt);
            }
        });
        btnbuscarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnbuscarClienteKeyPressed(evt);
            }
        });

        btnBuscarArticulos.setText("Buscar Articulos");
        btnBuscarArticulos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarArticulosActionPerformed(evt);
            }
        });
        btnBuscarArticulos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnBuscarArticulosKeyPressed(evt);
            }
        });

        jLabel4.setText("Fecha Pago:");

        jLabel3.setText("Fecha Venta:");

        jdcfechaventa.setDateFormatString("dd/MM/y");
        jdcfechaventa.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdcfechaventaPropertyChange(evt);
            }
        });

        jLabel8.setText("N° Venta");

        lblidventa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblidventa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(lblidventa, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblidventa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setText("N° Cliente:");

        jLabel10.setText("Cliente:");

        jLabel11.setText("Dias Credito:");

        jLabel12.setText("Tipo Pago:");

        jLabel13.setText("Telefono:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblcolonia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblcp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblcalle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        lblnexterior.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblcp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblnexterior, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblcalle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblcolonia, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblcolonia, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblcalle, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblnexterior, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblcp, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(402, 402, 402)
                        .addComponent(btnBuscarArticulos))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btnbuscarCliente))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jdcfechaventa, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jdcfechaventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblFechaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(btnbuscarCliente)))
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarArticulos))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tblVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblVenta);

        javax.swing.GroupLayout pnlTablaventasLayout = new javax.swing.GroupLayout(pnlTablaventas);
        pnlTablaventas.setLayout(pnlTablaventasLayout);
        pnlTablaventasLayout.setHorizontalGroup(
            pnlTablaventasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTablaventasLayout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlTablaventasLayout.setVerticalGroup(
            pnlTablaventasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTablaventasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jLabel7.setText("Total  Compra:");

        jLabel14.setText("Total Venta:");

        lblTotalcompra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalcompra.setText("0");

        lblTotalVenta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTotalVenta.setText("0");

        javax.swing.GroupLayout panRegistroLayout = new javax.swing.GroupLayout(panRegistro);
        panRegistro.setLayout(panRegistroLayout);
        panRegistroLayout.setHorizontalGroup(
            panRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panRegistroLayout.createSequentialGroup()
                        .addComponent(pnlTablaventas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panRegistroLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalcompra, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(lblTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        panRegistroLayout.setVerticalGroup(
            panRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panRegistroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTablaventas, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(lblTotalcompra)
                        .addComponent(lblTotalVenta))
                    .addGroup(panRegistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)))
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
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jdcfechaventaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcfechaventaPropertyChange
        // TODO add your handling code here:
        try {
            fecha = jdcfechaventa.getDate();///tomo el valor del jdate chooser
            fechapago = formatofecha.format(fecha); ///le aplico el formato de dia/mes/año
            dias = Integer.parseInt(lbldiascredito.getText());
            lblFechaPago.setText(formateador.format(metventas.sumarRestarDiasFecha(fecha, dias)));

        } catch (Exception e) {
        }
    }//GEN-LAST:event_jdcfechaventaPropertyChange

    private void btnBuscarArticulosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarArticulosActionPerformed
        // TODO add your handling code here:
        buscararticulo();
    }//GEN-LAST:event_btnBuscarArticulosActionPerformed

    private void btnbuscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarClienteActionPerformed
        // TODO add your handling code here:
        buscarcliente();

    }//GEN-LAST:event_btnbuscarClienteActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        guardarventa();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnGuardarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnGuardarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            guardarventa();
        }
    }//GEN-LAST:event_btnGuardarKeyPressed

    private void btnBuscarArticulosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnBuscarArticulosKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buscararticulo();
        }
    }//GEN-LAST:event_btnBuscarArticulosKeyPressed

    private void btnbuscarClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnbuscarClienteKeyPressed
        // TODO add your handling code here:
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            buscarcliente();
        }
    }//GEN-LAST:event_btnbuscarClienteKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscarArticulos;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnbuscarCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    public static com.toedter.calendar.JDateChooser jdcfechaventa;
    public static javax.swing.JLabel lblFechaPago;
    public static javax.swing.JLabel lblTotalVenta;
    public static javax.swing.JLabel lblTotalcompra;
    public static javax.swing.JLabel lblcalle;
    public static javax.swing.JLabel lblcliente;
    public static javax.swing.JLabel lblcolonia;
    public static javax.swing.JLabel lblcp;
    public static javax.swing.JLabel lbldiascredito;
    public static javax.swing.JLabel lblidventa;
    public static javax.swing.JLabel lblncliente;
    public static javax.swing.JLabel lblnexterior;
    public static javax.swing.JLabel lbltelefono;
    public static javax.swing.JLabel lbltipopago;
    public static javax.swing.JPanel panRegistro;
    public static javax.swing.JPanel pnlTablaventas;
    public static javax.swing.JTable tblVenta;
    // End of variables declaration//GEN-END:variables
}
