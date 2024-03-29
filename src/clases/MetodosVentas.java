/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import Usuarios.frmClientesBuscar;
import Ventas.frmVentasBuscarArticulo2;
import Ventas.frmVentasCancelar;
import Ventas.frmVentassnuevas;
import Ventas.frmventasbuscarcancelar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author usuario
 */
public class MetodosVentas {

    Connection con = null;
    static ResultSet rs = null;
    private Statement stmt = null;
    conexion conectar = new conexion();
    Object filas[] = new Object[10];
    TableRowSorter trs;
    public static DateFormat formatofecha = new SimpleDateFormat("dd/MM/yy");
    DecimalFormat df = new DecimalFormat("#.00");
    Date fecha;

    public void regresarCliente() {
        Date fechaEnviar;
        String id, nombre, telefono, tipopago, diascredito, colonia, calle, nexterior, cp, fechaformato;
        id = frmClientesBuscar.tblClientesBuscar.getValueAt(frmClientesBuscar.tblClientesBuscar.getSelectedRow(), 0).toString();
        nombre = frmClientesBuscar.tblClientesBuscar.getValueAt(frmClientesBuscar.tblClientesBuscar.getSelectedRow(), 1).toString();
        telefono = frmClientesBuscar.tblClientesBuscar.getValueAt(frmClientesBuscar.tblClientesBuscar.getSelectedRow(), 2).toString();
        tipopago = frmClientesBuscar.tblClientesBuscar.getValueAt(frmClientesBuscar.tblClientesBuscar.getSelectedRow(), 3).toString();
        diascredito = frmClientesBuscar.tblClientesBuscar.getValueAt(frmClientesBuscar.tblClientesBuscar.getSelectedRow(), 4).toString();
        colonia = frmClientesBuscar.tblClientesBuscar.getValueAt(frmClientesBuscar.tblClientesBuscar.getSelectedRow(), 5).toString();
        calle = frmClientesBuscar.tblClientesBuscar.getValueAt(frmClientesBuscar.tblClientesBuscar.getSelectedRow(), 6).toString();
        nexterior = frmClientesBuscar.tblClientesBuscar.getValueAt(frmClientesBuscar.tblClientesBuscar.getSelectedRow(), 7).toString();
        cp = frmClientesBuscar.tblClientesBuscar.getValueAt(frmClientesBuscar.tblClientesBuscar.getSelectedRow(), 9).toString();
        frmVentassnuevas.lblcliente.setText(nombre);
        frmVentassnuevas.lblncliente.setText(id);
        frmVentassnuevas.lbltelefono.setText(telefono);
        frmVentassnuevas.lbltipopago.setText(tipopago);
        frmVentassnuevas.lbldiascredito.setText(diascredito);
        frmVentassnuevas.lblcolonia.setText(colonia);
        frmVentassnuevas.lblcalle.setText(calle);
        frmVentassnuevas.lblnexterior.setText(nexterior);
        frmVentassnuevas.lblcp.setText(cp);
        frmVentassnuevas.jdcfechaventa.setEnabled(true);
        fechaEnviar = frmVentassnuevas.jdcfechaventa.getDate();
        frmVentassnuevas.lblFechaPago.setText(frmVentassnuevas.formatofecha.format(sumarRestarDiasFecha(fechaEnviar, Integer.parseInt(diascredito))));

    }

    public void modeloTablaBuscar() {

        if (frmVentasBuscarArticulo2.controlModelo == false) {
            frmVentasBuscarArticulo2.mo.addColumn("ID");
            frmVentasBuscarArticulo2.mo.addColumn("Nombre");
            frmVentasBuscarArticulo2.mo.addColumn("Precio Venta:");
            frmVentasBuscarArticulo2.mo.addColumn("Precio Compra:");
            frmVentasBuscarArticulo2.tblVentassTabla.setModel(frmVentasBuscarArticulo2.mo);
            frmVentasBuscarArticulo2.controlModelo = true;
        } else {
            frmVentasBuscarArticulo2.tblVentassTabla.setModel(frmVentasBuscarArticulo2.mo);
        }

    }

    public void modeloTablaVentas() {
        if (frmVentassnuevas.controlModelo == false) {
            frmVentassnuevas.modelo.addColumn("ID Articulo");
            frmVentassnuevas.modelo.addColumn("Nombre");
            frmVentassnuevas.modelo.addColumn("Precio Venta");
            frmVentassnuevas.modelo.addColumn("Precio Compra");
            frmVentassnuevas.modelo.addColumn("Cantidad");
            frmVentassnuevas.modelo.addColumn("Total Venta");
            frmVentassnuevas.modelo.addColumn("Total Compra");
            frmVentassnuevas.tblVenta.setModel(frmVentassnuevas.modelo);
            frmVentassnuevas.controlModelo = true;
        } else {
            frmVentassnuevas.tblVenta.setModel(frmVentassnuevas.modelo);

        }
    }

    public static Date sumarRestarDiasFecha(Date fecha, int dias) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha); // Configuramos la fecha que se recibe
        calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0
        return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
    }

    public void busquedaArticulos() {
        try {
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select idArticulos, artnombre, precio_compra from tblarticulos where estatus='Activo';");
            while (rs.next()) {
                filas[0] = rs.getInt(1);
                filas[1] = rs.getString(2);
                filas[2] = rs.getFloat(3);
                frmVentasBuscarArticulo2.mo.addRow(filas);
            }
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void filtradoBusquedaNombre(String busqueda) {
        try {
            frmVentasBuscarArticulo2.mo.setRowCount(0);
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select idArticulos, artnombre, precio_compra,precio_venta from tblarticulos where estatus='Activo'"
                    + "and artnombre like '%" + busqueda + "%' ;");
            while (rs.next()) {
                filas[0] = rs.getInt(1);
                filas[1] = rs.getString(2);
                filas[2] = rs.getFloat(4);
                filas[3] = rs.getFloat(3);
                frmVentasBuscarArticulo2.mo.addRow(filas);
            }
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void filtradoBusquedaID(int busqueda) {
        try {
            frmVentasBuscarArticulo2.mo.setRowCount(0);
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select idArticulos, artnombre, precio_compra,precio_venta from tblarticulos where estatus='Activo'"
                    + "and idArticulos like '%" + busqueda + "%';");
            while (rs.next()) {
                filas[0] = rs.getInt(1);
                filas[1] = rs.getString(2);
                filas[2] = rs.getFloat(4);
                filas[3] = rs.getFloat(3);
                frmVentasBuscarArticulo2.mo.addRow(filas);
            }
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void buscartabla(String Articulo) {
        frmVentasBuscarArticulo2.txtFiltroArticulos.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + Articulo, 1));
            }
        });
        trs = new TableRowSorter(frmVentasBuscarArticulo2.tblVentassTabla.getModel());
        frmVentasBuscarArticulo2.tblVentassTabla.setRowSorter(trs);
    }

    public void limpiarCamposFrmventasBuscarArticulo() {
        frmVentasBuscarArticulo2.lblid.setText("");
        frmVentasBuscarArticulo2.lblnombre.setText("");
        frmVentasBuscarArticulo2.lbltotal.setText("0.0");
        frmVentasBuscarArticulo2.txtcantidad.setText("");
        frmVentasBuscarArticulo2.txtpreciocompra.setText("0.0");
        frmVentasBuscarArticulo2.txtprecioventa.setText("0.0");
    }

    public void enviarDatosVentas(String ID, String nombre, String precioventa, String preciocompra, String cantidad, float total, double totalcompra) {
        double sumaventa, sumacompra, lbltotalventa, lbltotalcompra, utilidad;
        Object f[] = new Object[7];
        f[0] = ID;
        f[1] = nombre;
        f[2] = precioventa;
        f[3] = preciocompra;
        f[4] = cantidad;
        f[5] = total;
        f[6] = totalcompra;
        frmVentassnuevas.modelo.addRow(f);
        frmVentassnuevas.tblVenta.setModel(frmVentassnuevas.modelo);
        lbltotalventa = Double.parseDouble(frmVentassnuevas.lblTotalVenta.getText());
        lbltotalcompra = Double.parseDouble(frmVentassnuevas.lblTotalcompra.getText());
        sumaventa = total + lbltotalventa;
        sumacompra = totalcompra + lbltotalcompra;
        frmVentassnuevas.lblTotalVenta.setText(df.format(sumaventa) + "");
        frmVentassnuevas.lblTotalcompra.setText(df.format(sumacompra) + "");
        lbltotalventa = Double.parseDouble(frmVentassnuevas.lblTotalVenta.getText());
        lbltotalcompra = Double.parseDouble(frmVentassnuevas.lblTotalcompra.getText());
        utilidad = lbltotalventa - lbltotalcompra;
        frmVentassnuevas.lblutilidad.setText(df.format(utilidad) + "");
    }

    public void guardarventa(int idproveedor, float total, String fechaventa, String fechapago) {
        try {
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            PreparedStatement guardar = con.prepareStatement("insert into tblventas (idcliente,total,abono,saldo"
                    + ",fecha_venta,pagada,estatus,fecha_pago) values (?,?,0,?,?,0,'Activa',?)");
            guardar.setInt(1, idproveedor);
            guardar.setFloat(2, total);
            guardar.setFloat(3, total);
            guardar.setString(4, fechaventa);
            guardar.setString(5, fechapago);
            guardar.execute();
            guardar.close();
            JOptionPane.showMessageDialog(null, "Se Grabo Correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }

    }

    public void guardarventasmovimientos(int idventa, int idarticulo, float cantidad, float preciocompra, float precioventa, float totalmovimiento) {
        try {
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            PreparedStatement guardarmovimientos = con.prepareStatement("insert into tblventasmovimientos (idventas,"
                    + "idarticulo,cantidad,preciocompra,precioventa,totalmovimiento) values(?,?,?,?,?,?)");
            guardarmovimientos.setInt(1, idventa);
            guardarmovimientos.setInt(2, idarticulo);
            guardarmovimientos.setFloat(3, cantidad);
            guardarmovimientos.setFloat(4, preciocompra);
            guardarmovimientos.setFloat(5, precioventa);
            guardarmovimientos.setFloat(6, totalmovimiento);
            guardarmovimientos.execute();
            guardarmovimientos.close();
//            JOptionPane.showMessageDialog(null, "se guardo correctamente movimientos");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }

    public void actualizarexistenciaaritculos(int idarticulo, float cantidad) {
        try {
            float existencia = 0;
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select tblarticulos.existencia from tblarticulos where "
                    + "idarticulos='" + idarticulo + "'");
            if (rs.next()) {
                existencia = rs.getFloat(1);
            }
            existencia = existencia + cantidad;
            PreparedStatement acutalizarexistencia = con.prepareStatement("update tblarticulos set existencia =?"
                    + " where idarticulos=?");
            acutalizarexistencia.setFloat(1, existencia);
            acutalizarexistencia.setInt(2, idarticulo);
            acutalizarexistencia.executeUpdate();
            acutalizarexistencia.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }

    public int ultimoidventa() {
        int lasid = 0;
        try {
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select max(idventas) from tblventas;");
            if (rs.next()) {
                lasid = rs.getInt(1) + 1;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return lasid;
    }

    public void modelotablabuscarcancelar() {
        if (frmventasbuscarcancelar.controlModelo == false) {
            frmventasbuscarcancelar.modelo.addColumn("N° Nota");
            frmventasbuscarcancelar.modelo.addColumn("Nombre");
            frmventasbuscarcancelar.modelo.addColumn("Fecha");
            frmventasbuscarcancelar.modelo.addColumn("Fecha Pago");
            frmventasbuscarcancelar.modelo.addColumn("Total");
            frmventasbuscarcancelar.modelo.addColumn("Pagada");
            frmventasbuscarcancelar.tblbuscanotacancelar.setModel(frmventasbuscarcancelar.modelo);
            TamañoColumnas();
            frmventasbuscarcancelar.controlModelo = true;
        } else {
            frmventasbuscarcancelar.tblbuscanotacancelar.setModel(frmventasbuscarcancelar.modelo);
            TamañoColumnas();

        }
    }

    public static void TamañoColumnas() {
        TableColumnModel ModeloColumnas = frmventasbuscarcancelar.tblbuscanotacancelar.getColumnModel();
        ModeloColumnas.getColumn(0).setPreferredWidth(70);
        ModeloColumnas.getColumn(1).setPreferredWidth(200);
        ModeloColumnas.getColumn(2).setPreferredWidth(100);
        ModeloColumnas.getColumn(3).setPreferredWidth(100);
        ModeloColumnas.getColumn(4).setPreferredWidth(100);
        ModeloColumnas.getColumn(5).setPreferredWidth(80);
        frmventasbuscarcancelar.tblbuscanotacancelar.setRowHeight(25);
    }

    public void llenartablabuscarcancelar() {
        try {
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select tblventas.idventas,tblclientes.clinombre,tblventas.fecha_venta"
                    + ",tblventas.fecha_pago,tblventas.total,tblventas.pagada from tblventas"
                    + " inner join tblclientes on tblclientes.idCliente=tblventas.idCliente "
                    + "where tblclientes.estatus ='Activo' and tblventas.estatus ='activa';");
            String pagada;
            while (rs.next()) {
                filas[0] = rs.getString(1);///id
                filas[1] = rs.getString(2);///nombre
                filas[2] = rs.getString(3);///fecha venta
                if (rs.getInt(6) == 1) {
                    pagada = "SI";
                } else {
                    pagada = "NO";
                }

                filas[3] = rs.getString(4);///fecha Pago
                filas[4] = rs.getString(5);//total
                filas[5] = pagada;
                frmventasbuscarcancelar.modelo.addRow(filas);
            }

            con.close();
        } catch (SQLException e) {

        }
    }

    public void modeloTablaVentascancelar() {
        if (frmVentasCancelar.controlModelo == false) {
            frmVentasCancelar.modelo.addColumn("ID Articulo");
            frmVentasCancelar.modelo.addColumn("Nombre");
            frmVentasCancelar.modelo.addColumn("Precio Venta");
            frmVentasCancelar.modelo.addColumn("Precio Compra");
            frmVentasCancelar.modelo.addColumn("Cantidad");
            frmVentasCancelar.modelo.addColumn("Total Venta");
            frmVentasCancelar.modelo.addColumn("Total Compra");
            frmVentasCancelar.tblVentacancelar.setModel(frmVentasCancelar.modelo);
            frmVentasCancelar.controlModelo = true;
        } else {
            frmVentasCancelar.tblVentacancelar.setModel(frmVentasCancelar.modelo);

        }
    }

    public void rellenarventascancelar(int idventa) {
        float cantidad, precioventa, preciocompra;
        try {
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select tblventas.idventas,tblclientes.idcliente,tblclientes.clinombre"
                    + ",tblclientes.tipopago,tblclientes.diascredito,tblclientes.telefono,tblclientes.colonia"
                    + ",tblclientes.calle,tblclientes.numeroexterior,tblclientes.cp,tblventas.fecha_venta"
                    + ",tblventas.fecha_pago,tblarticulos.artnombre,tblventasmovimientos.idarticulo"
                    + ",tblventasmovimientos.precioventa,tblventasmovimientos.preciocompra"
                    + ",tblventasmovimientos.cantidad,tblventas.total from tblarticulos "
                    + "inner join tblventasmovimientos on tblventasmovimientos.idarticulo = tblarticulos.idarticulos "
                    + "inner join tblventas on tblventas.idventas = tblventasmovimientos.idventas"
                    + " inner join tblclientes on tblclientes.idcliente=tblventas.idcliente"
                    + " where tblventas.idventas =" + idventa + ";");
            String pagada;
            if (rs.next()) {
                frmVentasCancelar.lblidventa.setText(rs.getString(1));
                frmVentasCancelar.lblcliente.setText(rs.getString(2));
                frmVentasCancelar.lblncliente.setText(rs.getString(3));
                frmVentasCancelar.lbltipopago.setText(rs.getString(4));
                frmVentasCancelar.lbldiascredito.setText(rs.getString(5));
                frmVentasCancelar.lbltelefono.setText(rs.getString(6));
                frmVentasCancelar.lblcolonia.setText(rs.getString(7));
                frmVentasCancelar.lblcalle.setText(rs.getString(8));
                frmVentasCancelar.lblnexterior.setText(rs.getString(9));
                frmVentasCancelar.lblcp.setText(rs.getString(10));
                fecha = rs.getDate(11);
                frmVentasCancelar.lblFechaVenta.setText(formatofecha.format(fecha));
                fecha = rs.getDate(12);
                frmVentasCancelar.lblFechaPago.setText(formatofecha.format(fecha));
                frmVentasCancelar.lblTotalVenta.setText(rs.getString(18));

            }
            while (rs.next()) {
                cantidad = rs.getFloat(17);
                precioventa = rs.getFloat(15);
                preciocompra = rs.getFloat(16);
                filas[0] = rs.getString(14);///id articulo
                filas[1] = rs.getString(13);///nombre articulo
                filas[2] = df.format(precioventa);///precio venta
                filas[3] = df.format(preciocompra);///preciocompra 
                filas[4] = df.format(cantidad);//cantidad
                filas[5] = df.format(cantidad * precioventa);//totalventa
                filas[6] = df.format(cantidad * preciocompra);//totalcompra
                frmVentasCancelar.modelo.addRow(filas);
            }

            con.close();
        } catch (SQLException e) {

        }
    }

    public void cancelarventa(int id) {
        try {
            float existencia = 0;
            con = conectar.conectarMySQL();
            PreparedStatement acutalizarexistencia = con.prepareStatement("update tblventas set estatus =Cancelada"
                    + " where idventas=?");
            acutalizarexistencia.setInt(1, id);
            acutalizarexistencia.executeUpdate();
            acutalizarexistencia.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }

    
     public void actualizarexistenciaaritculosventacancelada(int idarticulo, float cantidad) {
        try {
            float existencia = 0;
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select tblarticulos.existencia from tblarticulos where "
                    + "idarticulos='" + idarticulo + "'");
            if (rs.next()) {
                existencia = rs.getFloat(1);
            }
            existencia = existencia - cantidad;
            PreparedStatement acutalizarexistencia = con.prepareStatement("update tblarticulos set existencia =?"
                    + " where idarticulos=?");
            acutalizarexistencia.setFloat(1, existencia);
            acutalizarexistencia.setInt(2, idarticulo);
            acutalizarexistencia.executeUpdate();
            acutalizarexistencia.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            e.printStackTrace();
        }
    }
}
