/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import Articulos.frmArticulos3;
import Articulos.frmArticulosBuscar;
import Articulos.frmArticulosEditar;
import Articulos.frmArticulosNuevos;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author usuario
 */
public class MetodosArticulos {

    Connection con = null;
    static ResultSet rs = null;
    private Statement stmt = null;
    conexion conectar = new conexion();
    Object filas[] = new Object[8];
    TableRowSorter trs; // Variable Para lo del filtrado de la busqueda

    public void ArticulosCrear(String nombre, float precio, float preciocompra, String empaquetado, String familia, String subfamilia) {
        try {
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            PreparedStatement InsertarArticulos = con.prepareStatement("Insert into tblarticulos (nombre,precio_venta,"
                    + "precio_compra,existencia,inventario_fisico,empaquetado,estatus,id_familia,id_subfamilia)values(?,?,?,?,?,?,?,?,?);");
            InsertarArticulos.setString(1, nombre);
            InsertarArticulos.setFloat(2, precio);
            InsertarArticulos.setFloat(3, preciocompra);
            InsertarArticulos.setFloat(4, 0);
            InsertarArticulos.setFloat(5, 0);
            InsertarArticulos.setString(6, empaquetado);
            InsertarArticulos.setString(7, "Activo");
            InsertarArticulos.setInt(8, obtenercmbfamilia(familia));
            InsertarArticulos.setInt(9, obtenercmbsubfamilia(subfamilia));
            InsertarArticulos.execute();
            InsertarArticulos.close();
            JOptionPane.showMessageDialog(null, "Registro Exitoso");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public int UltimoIdArticulo() {
        int id = 0;

        try {
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select max(idArticulos) from tblarticulos");
            if (rs.next()) {
                id = rs.getInt(1) + 1;
            }
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return id;
    }

    public void Actualizar(int id, String nombre, float precio, float preciocompra, String empaquetado,String familia,String subfamilia) {
        try {
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            PreparedStatement actualizar = con.prepareStatement("update tblarticulos set nombre=?,precio_venta=?"
                    + ",precio_compra=?,empaquetado=?,id_familia =?,id_subfamilia=? where idArticulos=?");
            actualizar.setString(1, nombre);
            actualizar.setFloat(2, precio);
            actualizar.setFloat(3, preciocompra);
            actualizar.setString(4, empaquetado);
            actualizar.setInt(5, obtenercmbfamilia(familia));
            actualizar.setInt(6, obtenercmbsubfamilia(subfamilia));
            actualizar.setInt(7, id);
            actualizar.executeUpdate();
            actualizar.close();
            JOptionPane.showMessageDialog(null, "Acutalizado Correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void eliminar(int id) {
        try {
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            PreparedStatement eliminar = con.prepareStatement("update tblarticulos set estatus='Cancelado' where idArticulos =?");
            eliminar.setInt(1, id);
            eliminar.executeUpdate();
            eliminar.close();
            JOptionPane.showMessageDialog(null, "Articulo Eliminado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void ModeloTabla() {
        //Añado las Columnas
        frmArticulosBuscar.modelotablaArticulos.addColumn("ID");
        frmArticulosBuscar.modelotablaArticulos.addColumn("Nombre");
        frmArticulosBuscar.modelotablaArticulos.addColumn("Precio");
        frmArticulosBuscar.modelotablaArticulos.addColumn("P.Compra");
        frmArticulosBuscar.modelotablaArticulos.addColumn("Empaquetado");
        frmArticulosBuscar.modelotablaArticulos.addColumn("Familia");
        frmArticulosBuscar.modelotablaArticulos.addColumn("SubFamilia");
        frmArticulosBuscar.tblArticulosbuscar.setModel(frmArticulosBuscar.modelotablaArticulos);
        frmArticulos3.vezuna = true;
        tamañocolumnas();
        acomodofilas();
    }

    public void acomodofilas() {

        frmArticulosBuscar.tblArticulosbuscar.setRowHeight(30);
        frmArticulosBuscar.tcr.setHorizontalAlignment(SwingConstants.CENTER);
        frmArticulosBuscar.tblArticulosbuscar.getColumnModel().getColumn(0).setCellRenderer(frmArticulosBuscar.tcr);
        frmArticulosBuscar.tblArticulosbuscar.getColumnModel().getColumn(1).setCellRenderer(frmArticulosBuscar.tcr);
        frmArticulosBuscar.tblArticulosbuscar.getColumnModel().getColumn(2).setCellRenderer(frmArticulosBuscar.tcr);
        frmArticulosBuscar.tblArticulosbuscar.getColumnModel().getColumn(3).setCellRenderer(frmArticulosBuscar.tcr);
        frmArticulosBuscar.tblArticulosbuscar.getColumnModel().getColumn(4).setCellRenderer(frmArticulosBuscar.tcr);
        frmArticulosBuscar.tblArticulosbuscar.getColumnModel().getColumn(5).setCellRenderer(frmArticulosBuscar.tcr);
        frmArticulosBuscar.tblArticulosbuscar.getColumnModel().getColumn(6).setCellRenderer(frmArticulosBuscar.tcr);

    }

    public void tamañocolumnas() {
        TableColumnModel ModeloColumnas = frmArticulosBuscar.tblArticulosbuscar.getColumnModel();
        ModeloColumnas.getColumn(0).setPreferredWidth(30);
        ModeloColumnas.getColumn(1).setPreferredWidth(180);
        ModeloColumnas.getColumn(2).setPreferredWidth(80);
        ModeloColumnas.getColumn(3).setPreferredWidth(80);
        ModeloColumnas.getColumn(4).setPreferredWidth(90);
        ModeloColumnas.getColumn(5).setPreferredWidth(70);
        ModeloColumnas.getColumn(6).setPreferredWidth(80);
    }

    public void ArticulosBuscar() {

        try {
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs = stmt.executeQuery(" select tblarticulos.*,tblfamilia.famnombre,tblsubfamilia.subnombre from tblarticulos inner join tblfamilia on tblfamilia.id_familia = tblarticulos.id_familia"
                    + " inner join tblsubfamilia on tblsubfamilia.id_subfamilia = tblarticulos.id_subfamilia"
                    + "  where tblarticulos.estatus='Activo';");
            while (rs.next()) {
                filas[0] = rs.getInt(1);
                filas[1] = rs.getString(2);
                filas[2] = rs.getFloat(3);
                filas[3] = rs.getFloat(4);
                filas[4] = rs.getString(7);
                filas[5] = rs.getString(11);
                filas[6] = rs.getString(12);
                frmArticulosBuscar.modelotablaArticulos.addRow(filas);
            }
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void ArticulosEditarPasar() {
        String id, nombre, precio, preciocompra, empaquetado,familia,subfamilia;
        int valfamilia,valsubfamilia;
        id = frmArticulosBuscar.tblArticulosbuscar.getValueAt(frmArticulosBuscar.tblArticulosbuscar.getSelectedRow(), 0).toString();
        nombre = frmArticulosBuscar.tblArticulosbuscar.getValueAt(frmArticulosBuscar.tblArticulosbuscar.getSelectedRow(), 1).toString();
        precio = frmArticulosBuscar.tblArticulosbuscar.getValueAt(frmArticulosBuscar.tblArticulosbuscar.getSelectedRow(), 2).toString();
        preciocompra = frmArticulosBuscar.tblArticulosbuscar.getValueAt(frmArticulosBuscar.tblArticulosbuscar.getSelectedRow(), 3).toString();
        empaquetado = frmArticulosBuscar.tblArticulosbuscar.getValueAt(frmArticulosBuscar.tblArticulosbuscar.getSelectedRow(), 4).toString();
        familia = frmArticulosBuscar.tblArticulosbuscar.getValueAt(frmArticulosBuscar.tblArticulosbuscar.getSelectedRow(), 5).toString();
        subfamilia= frmArticulosBuscar.tblArticulosbuscar.getValueAt(frmArticulosBuscar.tblArticulosbuscar.getSelectedRow(), 6).toString();        
        
        
        frmArticulosEditar.lblidArticulo.setText(id);
        frmArticulosEditar.txtNombreArticulo.setText(nombre);
        frmArticulosEditar.txtPrecioArticulo.setText(precio);
        frmArticulosEditar.txtPrecioCompra.setText(preciocompra);
        rellenarcmbfamiliaeditar();
        valfamilia=obtenercmbfamilia(familia);
        rellenarcmbsubfamiliaeditar(valfamilia);
        valsubfamilia=obtenercmbsubfamilia(subfamilia);
        frmArticulosEditar.cmbfamilia.setSelectedIndex(valfamilia-1);
         frmArticulosEditar.cmbsubfamilia.setSelectedIndex(valsubfamilia-1);
        buscartabla("");
        frmArticulosBuscar.txtArticulosBuscar.setText("");
        //frmArticulosEditar.cmbEmpaquetado.setSelectedItem(empaquetado);
    }

    public void ocultarbotones() {
        frmArticulos3.btnArticulosBuscar.setVisible(false);
        frmArticulos3.btnArticulosEditar.setVisible(false);
        frmArticulos3.btnNuevo.setVisible(false);
    }

    public void mostrarbotones() {
        frmArticulos3.btnArticulosBuscar.setVisible(true);
        frmArticulos3.btnArticulosEditar.setVisible(true);
        frmArticulos3.btnNuevo.setVisible(true);
    }

    public void buscartabla(String Articulo) {
        frmArticulosBuscar.txtArticulosBuscar.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + Articulo, 1));
            }
        });
        trs = new TableRowSorter(frmArticulosBuscar.tblArticulosbuscar.getModel());
        frmArticulosBuscar.tblArticulosbuscar.setRowSorter(trs);
    }

    public void rellenarcmbfamilia() {
        try {
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select famnombre,id_familia from tblfamilia where estatus='Activo';");
            while (rs.next()) {
                frmArticulosNuevos.cmbfamilia.addItem(rs.getString(1));
            }
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void rellenarcmbfamiliaeditar() {
        try {
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select famnombre,id_familia from tblfamilia where estatus='Activo';");
            while (rs.next()) {
                frmArticulosEditar.cmbfamilia.addItem(rs.getString(1));
            }
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public int obtenercmbfamilia(String nombre) {
        int idfamilia = 0;
        try {

            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select id_familia from tblfamilia where famnombre='" + nombre + "';");
            if (rs.next()) {
                idfamilia = rs.getInt(1);
            }
            con.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return idfamilia;
    }

    public void rellenarcmbsubfamilia(int id) {
        try {
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select subnombre,id_subfamilia from tblsubfamilia where id_familia='" + id + "' and estatus='Activo';");
            while (rs.next()) {
                frmArticulosNuevos.cmbsubfamilia.addItem(rs.getString(1));
            }
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
     public void rellenarcmbsubfamiliaeditar(int id) {
        try {
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select subnombre,id_subfamilia from tblsubfamilia where id_familia='" + id + "' and estatus='Activo';");
            while (rs.next()) {
                frmArticulosEditar.cmbsubfamilia.addItem(rs.getString(1));
            }
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public int obtenercmbsubfamilia(String nombre) {
        int idfamilia = 0;
        try {

            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select id_subfamilia from tblsubfamilia where subnombre='" + nombre + "';");
            if (rs.next()) {
                idfamilia = rs.getInt(1);
            }
            con.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return idfamilia;
    }

}
