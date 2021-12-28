/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import Inventarios.frminventarioregistro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author usuario
 */
public class MetodosInventarios {

    Connection con = null;
    static ResultSet rs = null;
    private Statement stmt = null;
    conexion conectar = new conexion();
    Object filas[] = new Object[10];

    public void modeloTablaregistroinventario() {
        if (frminventarioregistro.controlModelo == false) {
            frminventarioregistro.modelo.addColumn("ID Articulo");
            frminventarioregistro.modelo.addColumn("Nombre");
            frminventarioregistro.modelo.addColumn("Existencia");
            frminventarioregistro.tblregistrarinventario.setModel(frminventarioregistro.modelo);
            frminventarioregistro.controlModelo = true;
            TamañoColumnas();
        } else {
            frminventarioregistro.tblregistrarinventario.setModel(frminventarioregistro.modelo);
            TamañoColumnas();

        }
    }

    public static void TamañoColumnas() {
        TableColumnModel ModeloColumnas = frminventarioregistro.tblregistrarinventario.getColumnModel();
        ModeloColumnas.getColumn(0).setPreferredWidth(40);
        ModeloColumnas.getColumn(1).setPreferredWidth(200);
        ModeloColumnas.getColumn(2).setPreferredWidth(100);
        frminventarioregistro.tblregistrarinventario.setRowHeight(50);
    }

    public void llenartablaregistroinventario() {
        try {
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select idArticulos, artnombre, existencia from tblarticulos where estatus='Activo'"
                    + "order by artnombre;");
            while (rs.next()) {
                filas[0] = rs.getInt(1);
                filas[1] = rs.getString(2);
                filas[2] = rs.getFloat(3);
                frminventarioregistro.modelo.addRow(filas);
            }
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void registrarinventario() {
        int idarticulo;
        float existencia;
        int filasregistro = frminventarioregistro.modelo.getRowCount();
        for (int x = 0; x < filasregistro; x++) {
            idarticulo = Integer.parseInt(frminventarioregistro.tblregistrarinventario.getValueAt(x, 0).toString());
            existencia = Float.parseFloat(frminventarioregistro.tblregistrarinventario.getValueAt(x, 2).toString());
         try 
                {
                    con = conectar.conectarMySQL();
                    stmt = con.createStatement();
                     PreparedStatement psInsert= con.prepareStatement("update tblarticulos set Existencia =?  "
                             + "where idarticulos='"+idarticulo+"'");
               
            
                    psInsert.setDouble(1, existencia);         
                    psInsert.executeUpdate();
                   
               
                } 
              
              catch (SQLException ex)
                {
                    JOptionPane.showMessageDialog(null, ex);
                }   
        }
    }
}
