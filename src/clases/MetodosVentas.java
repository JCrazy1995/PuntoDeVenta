/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import Compras.frmComprasBuscarArticulo;
import Compras.frmComprasnuevas;
import Usuarios.frmClientesBuscar;
import Ventas.frmVentasBuscarArticulo2;
import Ventas.frmVentassnuevas;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
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
    Object filas[] = new Object[6];
    TableRowSorter trs;

    public void regresarCliente() {
        Date fechaEnviar;
        String id, nombre,telefono, tipopago, diascredito,colonia,calle,nexterior,cp,fechaformato;
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
            frmVentassnuevas.modelo.addColumn("Precio Compra");
            frmVentassnuevas.modelo.addColumn("Precio Venta");
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
            rs = stmt.executeQuery("select idArticulos, nombre, precio_compra from tblarticulos where estatus='Activo';");
            while (rs.next()) {
                filas[0] = rs.getInt(1);
                filas[1] = rs.getString(2);
                filas[2] = rs.getFloat(3);
                frmComprasBuscarArticulo.mo.addRow(filas);
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
            rs = stmt.executeQuery("select idArticulos, nombre, precio_compra,precio_venta from tblarticulos where estatus='Activo'"
                    + "and nombre like '%" + busqueda + "%';");
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
            rs = stmt.executeQuery("select idArticulos, nombre, precio_compra,precio_venta from tblarticulos where estatus='Activo'"
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

    public void enviarDatosCompras(String ID, String nombre, String precioventa,String preciocompra, String cantidad, float total,float totalcompra) {
        float sumaventa,sumacompra, lbltotalventa,lbltotalcompra,utilidad;
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
        lbltotalventa = Float.parseFloat(frmVentassnuevas.lblTotalVenta.getText());
        lbltotalcompra=Float.parseFloat(frmVentassnuevas.lblTotalcompra.getText());
        sumaventa = total + lbltotalventa;
        sumacompra = totalcompra+lbltotalcompra;
        frmVentassnuevas.lblTotalVenta.setText(sumaventa + "");
        frmVentassnuevas.lblTotalcompra.setText(sumacompra + "");
        lbltotalventa = Float.parseFloat(frmVentassnuevas.lblTotalVenta.getText());
        lbltotalcompra=Float.parseFloat(frmVentassnuevas.lblTotalcompra.getText());
        utilidad= lbltotalventa-lbltotalcompra;
        frmVentassnuevas.lblutilidad.setText(utilidad+"");
    }

    public void guardarventa(int idproveedor, float total, String fechaventa, String fechapago) {
        try {
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            PreparedStatement guardar = con.prepareStatement("insert into tblventas (idcliente,total,abono,saldo"
                    + ",fecha_compra,pagada,estatus,fecha_pago) values (?,?,0,?,?,0,'Activa',?)");
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
        }

    }

    public void guardarventasmovimientos(int idcompra, int idarticulo, float cantidad, float preciocompra,float precioventa) {
        try {
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            PreparedStatement guardarmovimientos = con.prepareStatement("insert into tblventassmovimientos (idventa,"
                    + "idarticulo,cantidad,preciocompra,precioventa) values(?,?,?,?,?)");
            guardarmovimientos.setInt(1, idcompra);
            guardarmovimientos.setInt(2, idarticulo);
            guardarmovimientos.setFloat(3, cantidad);
            guardarmovimientos.setFloat(4, preciocompra);
            guardarmovimientos.setFloat(5, precioventa);
            guardarmovimientos.execute();
            guardarmovimientos.close();
            JOptionPane.showMessageDialog(null, "se guardo correctamente movimientos");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void actualizarexistenciaaritculos(int idarticulo, float preciocompra, float cantidad) {
        try {
            float existencia =0;
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select tblarticulos.existencia from tblarticulos where "
                    + "idarticulos='"+ idarticulo+ "'");
            if (rs.next()) {
                existencia = rs.getFloat(1);
            }
            existencia = existencia+cantidad;
            PreparedStatement acutalizarexistencia = con.prepareStatement("update tblarticulos set precio_compra=?"
                    + ",existencia=? where idArticulos=?");
            acutalizarexistencia.setFloat(1, preciocompra);
            acutalizarexistencia.setFloat(2, existencia);
            acutalizarexistencia.setInt(3, idarticulo);
            acutalizarexistencia.executeUpdate();
            acutalizarexistencia.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public int ultimoidcompra() {
        int lasid = 0;
        try {
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select max(idCompras) from tblcompras;");
            if (rs.next()) {
                lasid = rs.getInt(1) + 1;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return lasid;
    }

    
    
}
