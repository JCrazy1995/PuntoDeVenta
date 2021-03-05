/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import Compras.frmComprasBuscarArticulo;
import Compras.frmComprasnuevas;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;
import proveedores.frmProveedorBuscar;
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
public class MetodosCompras {

    Connection con = null;
    static ResultSet rs = null;
    private Statement stmt = null;
    conexion conectar = new conexion();
    Object filas[] = new Object[5];
    TableRowSorter trs;

    public void regresarproveedor() {
        Date fechaEnviar;
        String id, nombre, tipopago, diascredito,fechaformato;
        id = frmProveedorBuscar.tblBuscar.getValueAt(frmProveedorBuscar.tblBuscar.getSelectedRow(), 0).toString();
        nombre = frmProveedorBuscar.tblBuscar.getValueAt(frmProveedorBuscar.tblBuscar.getSelectedRow(), 1).toString();
        tipopago = frmProveedorBuscar.tblBuscar.getValueAt(frmProveedorBuscar.tblBuscar.getSelectedRow(), 3).toString();
        diascredito = frmProveedorBuscar.tblBuscar.getValueAt(frmProveedorBuscar.tblBuscar.getSelectedRow(), 4).toString();
        frmComprasnuevas.lblProvedornombre1.setText(nombre);
        frmComprasnuevas.lblNproveedor.setText(id);
        frmComprasnuevas.lbltipopago.setText(tipopago);
        frmComprasnuevas.lbldiascredito.setText(diascredito);
        frmComprasnuevas.jdcfechacompra.setEnabled(true);
        fechaEnviar = frmComprasnuevas.jdcfechacompra.getDate();
        frmComprasnuevas.lblFechaPago.setText(frmComprasnuevas.formatofecha.format(sumarRestarDiasFecha(fechaEnviar, Integer.parseInt(diascredito))));
        
    }

    public void modeloTablaBuscar() {

        if (frmComprasBuscarArticulo.controlModelo == false) {
            frmComprasBuscarArticulo.mo.addColumn("ID");
            frmComprasBuscarArticulo.mo.addColumn("Nombre");
            frmComprasBuscarArticulo.mo.addColumn("Precio");
            frmComprasBuscarArticulo.tblComprasTabla.setModel(frmComprasBuscarArticulo.mo);
            frmComprasBuscarArticulo.controlModelo = true;
        } else {
            frmComprasBuscarArticulo.tblComprasTabla.setModel(frmComprasBuscarArticulo.mo);
        }

    }

    public void modeloTablaCompras() {
        if (frmComprasnuevas.controlModelo == false) {
            frmComprasnuevas.modelo.addColumn("ID Articulo");
            frmComprasnuevas.modelo.addColumn("Nombre");
            frmComprasnuevas.modelo.addColumn("Precio");
            frmComprasnuevas.modelo.addColumn("Cantidad");
            frmComprasnuevas.modelo.addColumn("Total");
            frmComprasnuevas.tblCompra.setModel(frmComprasnuevas.modelo);
            frmComprasnuevas.controlModelo = true;
        } else {
            frmComprasnuevas.tblCompra.setModel(frmComprasnuevas.modelo);

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
            frmComprasBuscarArticulo.mo.setRowCount(0);
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select idArticulos, nombre, precio_compra from tblarticulos where estatus='Activo'"
                    + "and nombre like '%" + busqueda + "%';");
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

    public void filtradoBusquedaID(int busqueda) {
        try {
            frmComprasBuscarArticulo.mo.setRowCount(0);
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select idArticulos, nombre, precio_compra from tblarticulos where estatus='Activo'"
                    + "and idArticulos like '%" + busqueda + "%';");
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

    public void buscartabla(String Articulo) {
        frmComprasBuscarArticulo.txtFiltroArticulos.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + Articulo, 1));
            }
        });
        trs = new TableRowSorter(frmComprasBuscarArticulo.tblComprasTabla.getModel());
        frmComprasBuscarArticulo.tblComprasTabla.setRowSorter(trs);
    }

    public void limpiarCamposFrmComprasBuscarArticulo() {
        frmComprasBuscarArticulo.lblid.setText("");
        frmComprasBuscarArticulo.lblnombre.setText("");
        frmComprasBuscarArticulo.lbltotal.setText("0.0");
        frmComprasBuscarArticulo.txtcantidad.setText("");
        frmComprasBuscarArticulo.txtprecio.setText("0.0");
    }

    public void enviarDatosCompras(String ID, String nombre, String precio, String cantidad, float total) {
        float suma, lbl;
        Object f[] = new Object[5];
        f[0] = ID;
        f[1] = nombre;
        f[2] = precio;
        f[3] = cantidad;
        f[4] = total;
        frmComprasnuevas.modelo.addRow(f);
        frmComprasnuevas.tblCompra.setModel(frmComprasnuevas.modelo);
        lbl = Float.parseFloat(frmComprasnuevas.lblTotal.getText());
        suma = total + lbl;
        frmComprasnuevas.lblTotal.setText(suma + "");
    }

    public void guardarcompras(int idproveedor, float total, String fechacompra, String fechapago) {
        try {
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            PreparedStatement guardar = con.prepareStatement("insert into tblcompras (idProveedor,total,abono,saldo"
                    + ",fecha_compra,pagada,estatus,fecha_pago) values (?,?,0,?,?,0,'Activa',?)");
            guardar.setInt(1, idproveedor);
            guardar.setFloat(2, total);
            guardar.setFloat(3, total);
            guardar.setString(4, fechacompra);
            guardar.setString(5, fechapago);
            guardar.execute();
            guardar.close();
            JOptionPane.showMessageDialog(null, "Se Grabo Correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void guardarcomprasmovimientos(int idcompra, int idarticulo, float cantidad, float preciocompra) {
        try {
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            PreparedStatement guardarmovimientos = con.prepareStatement("insert into tblcomprasmovimientos (idcompra,"
                    + "idarticulo,cantidad,preciocompra) values(?,?,?,?)");
            guardarmovimientos.setInt(1, idcompra);
            guardarmovimientos.setInt(2, idarticulo);
            guardarmovimientos.setFloat(3, cantidad);
            guardarmovimientos.setFloat(4, preciocompra);
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
