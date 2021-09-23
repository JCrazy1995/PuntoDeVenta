/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import SubFamilias.*;
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
public class MetodosSubFamilia {

    Connection con = null;
    static ResultSet rs = null;
    private Statement stmt = null;
    conexion conectar = new conexion();
    Object filas[] = new Object[5];
    TableRowSorter trs; // Variable Para lo del filtrado de la busqueda

    public void SubFamiliaCrear(String nombre,String nombrefamilia) {
        try {
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            PreparedStatement insertarfamilia = con.prepareStatement("Insert into tblsubfamilia (id_familia,subnombre,estatus)values(?,?,?);");
            insertarfamilia.setInt(1, obtenercmbfamilia(nombrefamilia));
            insertarfamilia.setString(2, nombre);
            insertarfamilia.setString(3, "Activo");
            insertarfamilia.execute();
            insertarfamilia.close();
            JOptionPane.showMessageDialog(null, "Registro Exitoso");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public int UltimoIdSubFamilia() {
        int id = 0;

        try {
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select max(id_subfamilia) from tblsubfamilia");
            if (rs.next()) {
                id = rs.getInt(1) + 1;
            }
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return id;
    }

    public void Actualizar(int id, String nombre, String nombrefamilia) {
        try {
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            PreparedStatement actualizar = con.prepareStatement("update tblsubfamilia set subnombre= ?  where id_subfamilia= ?");
            actualizar.setString(1, nombre);
            actualizar.setInt(2, id);
            actualizar.executeUpdate();
            actualizar.close();
            con.close();
            
            
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
             actualizar = con.prepareStatement("update tblsubfamilia  set id_familia= ? where id_subfamilia= ?");
            actualizar.setInt(1, obtenercmbfamilia(nombrefamilia));
             actualizar.setInt(2, id);
            actualizar.executeUpdate();
            actualizar.close();
            
            con.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        JOptionPane.showMessageDialog(null, "Actualizado correctamente");
        
    }

    public void eliminar(int id) {
        try {
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            PreparedStatement eliminar = con.prepareStatement("update tblsubfamilia set estatus='Cancelado' where id_subfamilia =?");
            eliminar.setInt(1, id);
            eliminar.executeUpdate();
            eliminar.close();
            JOptionPane.showMessageDialog(null, "SubFamilia Eliminado");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void rellenarcmbfamilia() {
        try {
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select famnombre from tblfamilia where estatus='Activo';");
            while (rs.next()) {
                frmSubFamiliaNuevos.cmbFamilia.addItem(rs.getString(1));
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
                frmSubFamiliaEditar.cmbfamilia.addItem(rs.getString(1));
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

    public void ModeloTabla() {
        //Añado las Columnas
        frmSubfamiliaBuscar.modelotablasubfamilia.addColumn("ID");
        frmSubfamiliaBuscar.modelotablasubfamilia.addColumn("SubFamilia");
        frmSubfamiliaBuscar.modelotablasubfamilia.addColumn("Familia");
        frmSubfamiliaBuscar.tblsubfamilabuscar.setModel(frmSubfamiliaBuscar.modelotablasubfamilia);
        frmsubfamilia.vezuna = true;
        tamañocolumnas();
        acomodofilas();
    }

    public void acomodofilas() {

        frmSubfamiliaBuscar.tblsubfamilabuscar.setRowHeight(30);
        frmSubfamiliaBuscar.tcr.setHorizontalAlignment(SwingConstants.CENTER);
        frmSubfamiliaBuscar.tblsubfamilabuscar.getColumnModel().getColumn(0).setCellRenderer(frmSubfamiliaBuscar.tcr);
        frmSubfamiliaBuscar.tblsubfamilabuscar.getColumnModel().getColumn(1).setCellRenderer(frmSubfamiliaBuscar.tcr);
        frmSubfamiliaBuscar.tblsubfamilabuscar.getColumnModel().getColumn(2).setCellRenderer(frmSubfamiliaBuscar.tcr);

    }

    public void tamañocolumnas() {
        TableColumnModel ModeloColumnas = frmSubfamiliaBuscar.tblsubfamilabuscar.getColumnModel();
        ModeloColumnas.getColumn(0).setPreferredWidth(50);
        ModeloColumnas.getColumn(1).setPreferredWidth(80);
        ModeloColumnas.getColumn(2).setPreferredWidth(80);
    }

    public void SubFamiliaBuscar() {
        try {
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select tblsubfamilia.*,tblfamilia.famnombre from tblsubfamilia "
                    + "inner join tblfamilia on tblfamilia.id_familia = tblsubfamilia.id_familia "
                    + "where  tblsubfamilia.estatus ='Activo';");
            while (rs.next()) {
                filas[0] = rs.getInt(1);
                filas[1] = rs.getString(3);
                filas[2] = rs.getString(5);
                frmSubfamiliaBuscar.modelotablasubfamilia.addRow(filas);
            }
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void SubFamiliaEditarPasar() {
        String id, nombre, familia;
        id = frmSubfamiliaBuscar.tblsubfamilabuscar.getValueAt(frmSubfamiliaBuscar.tblsubfamilabuscar.getSelectedRow(), 0).toString();
        nombre = frmSubfamiliaBuscar.tblsubfamilabuscar.getValueAt(frmSubfamiliaBuscar.tblsubfamilabuscar.getSelectedRow(), 1).toString();
         familia = frmSubfamiliaBuscar.tblsubfamilabuscar.getValueAt(frmSubfamiliaBuscar.tblsubfamilabuscar.getSelectedRow(), 2).toString();
         
        frmSubFamiliaEditar.lblidsubfamilia.setText(id);
        frmSubFamiliaEditar.txtNombreSubFamilia.setText(nombre);
        rellenarcmbfamiliaeditar();
        frmSubFamiliaEditar.cmbfamilia.setSelectedIndex(obtenercmbfamilia(familia)-1);

        buscartabla("");
        frmSubfamiliaBuscar.txtsubfamiliabuscar.setText("");
        //frmArticulosEditar.cmbEmpaquetado.setSelectedItem(empaquetado);
    }

    public void ocultarbotones() {
        frmsubfamilia.btnsubFamiliaBuscar.setVisible(false);
        frmsubfamilia.btnsubFamiliaNuevo.setVisible(false);
        frmsubfamilia.btnsubFamiliasEditar.setVisible(false);
    }

    public void mostrarbotones() {
        frmsubfamilia.btnsubFamiliaBuscar.setVisible(true);
        frmsubfamilia.btnsubFamiliaNuevo.setVisible(true);
        frmsubfamilia.btnsubFamiliasEditar.setVisible(true);
    }

    public void buscartabla(String Articulo) {
        frmSubfamiliaBuscar.txtsubfamiliabuscar.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + Articulo, 1));
            }
        });
        trs = new TableRowSorter(frmSubfamiliaBuscar.tblsubfamilabuscar.getModel());
        frmSubfamiliaBuscar.tblsubfamilabuscar.setRowSorter(trs);
    }

}
