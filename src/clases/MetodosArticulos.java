/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import Articulos.frmArticulos3;
import Articulos.frmArticulosBuscar;
import Articulos.frmArticulosEditar;
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
    static ResultSet rs=null;
    private Statement stmt=null;
    conexion conectar = new conexion();
    Object filas[] = new Object[5];
    TableRowSorter trs; // Variable Para lo del filtrado de la busqueda
    
    public void ArticulosCrear(String nombre,float precio,float preciocompra,String empaquetado)
    {  
        try 
        {
            con=conectar.conectarMySQL();
            stmt= con.createStatement();
            PreparedStatement InsertarArticulos= con.prepareStatement("Insert into tblarticulos (nombre,precio_venta,"
                    + "precio_compra,existencia,inventario_fisico,empaquetado,estatus)values(?,?,?,?,?,?,?);");
            InsertarArticulos.setString(1, nombre);
            InsertarArticulos.setFloat(2, precio);
            InsertarArticulos.setFloat(3, preciocompra);
            InsertarArticulos.setFloat(4, 0);
            InsertarArticulos.setFloat(5, 0);
            InsertarArticulos.setString(6, empaquetado);
            InsertarArticulos.setString(7, "Activo");
            InsertarArticulos.execute();
            InsertarArticulos.close();
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
            
        } 
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    public int UltimoIdArticulo()
    {   int id=0;
       
        try 
        {
            con=conectar.conectarMySQL();
            stmt=con.createStatement();
            rs=stmt.executeQuery("select max(idArticulos) from tblarticulos");
            if(rs.next())
            {
                id=rs.getInt(1)+1;
            }
            con.close();
        }
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
        return id;
    }
    
    
    public void Actualizar(int id,String nombre,float precio,float preciocompra,String empaquetado)
    {
        try 
        {
            con=conectar.conectarMySQL();
            stmt=con.createStatement();
            PreparedStatement actualizar = con.prepareStatement("update tblarticulos set nombre=?,precio_venta=?"
                    + ",precio_compra=?,empaquetado=? where idArticulos=?");
            actualizar.setString(1, nombre);
            actualizar.setFloat(2, precio);
            actualizar.setFloat(3, preciocompra);
            actualizar.setString(4, empaquetado);
            actualizar.setInt(5, id);
            actualizar.executeUpdate();
            actualizar.close();
            JOptionPane.showMessageDialog(null, "Acutalizado Correctamente");
        } 
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    
    public void elimiar(int id)
    {
        try 
        {
            con=conectar.conectarMySQL();
            stmt=con.createStatement();
            PreparedStatement eliminar = con.prepareStatement("update tblarticulos set estatus='Cancelado' where idArticulos =?");
            eliminar.setInt(1, id);
            eliminar.executeUpdate();
            eliminar.close();
            JOptionPane.showMessageDialog(null, "Articulo Eliminado");
        } 
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public  void ModeloTabla()
    {
        //Añado las Columnas
        frmArticulosBuscar.modelotablaArticulos.addColumn("ID");
        frmArticulosBuscar.modelotablaArticulos.addColumn("Nombre");
        frmArticulosBuscar.modelotablaArticulos.addColumn("Precio");
        frmArticulosBuscar.modelotablaArticulos.addColumn("P.Compra");
        frmArticulosBuscar.modelotablaArticulos.addColumn("Empaquetado");  
        frmArticulosBuscar.tblArticulosbuscar.setModel(frmArticulosBuscar.modelotablaArticulos);
        frmArticulos3.vezuna = true;
        tamañocolumnas();
        acomodofilas();
    }
    
    public void acomodofilas()
    {
        
        frmArticulosBuscar.tblArticulosbuscar.setRowHeight(30);    
        frmArticulosBuscar.tcr.setHorizontalAlignment(SwingConstants.CENTER);
        frmArticulosBuscar.tblArticulosbuscar.getColumnModel().getColumn(0).setCellRenderer( frmArticulosBuscar.tcr);
        frmArticulosBuscar.tblArticulosbuscar.getColumnModel().getColumn(1).setCellRenderer( frmArticulosBuscar.tcr); 
        frmArticulosBuscar.tblArticulosbuscar.getColumnModel().getColumn(2).setCellRenderer( frmArticulosBuscar.tcr); 
        frmArticulosBuscar.tblArticulosbuscar.getColumnModel().getColumn(3).setCellRenderer( frmArticulosBuscar.tcr);  
        frmArticulosBuscar.tblArticulosbuscar.getColumnModel().getColumn(4).setCellRenderer( frmArticulosBuscar.tcr); 
        
    }
    public void tamañocolumnas()
    {
         TableColumnModel ModeloColumnas = frmArticulosBuscar.tblArticulosbuscar.getColumnModel();
          ModeloColumnas.getColumn(0).setPreferredWidth(50);
          ModeloColumnas.getColumn(1).setPreferredWidth(200);
          ModeloColumnas.getColumn(2).setPreferredWidth(80);
          ModeloColumnas.getColumn(3).setPreferredWidth(80);
          ModeloColumnas.getColumn(4).setPreferredWidth(80);
    }
    
   
    
    public void ArticulosBuscar()
    { 
      
        try 
        {
            con=conectar.conectarMySQL();
            stmt=con.createStatement();
            rs= stmt.executeQuery("select * from tblarticulos where estatus='Activo';");
            while(rs.next())
            {
                filas[0]=rs.getInt(1);
                filas[1]=rs.getString(2);
                filas[2]=rs.getFloat(3);
                filas[3]=rs.getFloat(4);
                filas[4]=rs.getString(7);
                frmArticulosBuscar.modelotablaArticulos.addRow(filas);
            }
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public void ArticulosEditarPasar()
    {
        String id,nombre,precio,preciocompra,empaquetado;
        id=frmArticulosBuscar.tblArticulosbuscar.getValueAt(frmArticulosBuscar.tblArticulosbuscar.getSelectedRow(), 0).toString();
        nombre=frmArticulosBuscar.tblArticulosbuscar.getValueAt(frmArticulosBuscar.tblArticulosbuscar.getSelectedRow(), 1).toString();
        precio=frmArticulosBuscar.tblArticulosbuscar.getValueAt(frmArticulosBuscar.tblArticulosbuscar.getSelectedRow(), 2).toString();
        preciocompra=frmArticulosBuscar.tblArticulosbuscar.getValueAt(frmArticulosBuscar.tblArticulosbuscar.getSelectedRow(), 3).toString();
        empaquetado=frmArticulosBuscar.tblArticulosbuscar.getValueAt(frmArticulosBuscar.tblArticulosbuscar.getSelectedRow(), 4).toString();
        
        frmArticulosEditar.lblidArticulo.setText(id);
        frmArticulosEditar.txtNombreArticulo.setText(nombre);
        frmArticulosEditar.txtPrecioArticulo.setText(precio);
        frmArticulosEditar.txtPrecioCompra.setText(preciocompra);
        buscartabla("");
        frmArticulosBuscar.txtArticulosBuscar.setText("");
        //frmArticulosEditar.cmbEmpaquetado.setSelectedItem(empaquetado);
    }
    
    public void ocultarbotones()
    {
        frmArticulos3.btnArticulosBuscar.setVisible(false);
        frmArticulos3.btnArticulosEditar.setVisible(false);
        frmArticulos3.btnNuevo.setVisible(false);
    }
    
    public void mostrarbotones()
    {
        frmArticulos3.btnArticulosBuscar.setVisible(true);
        frmArticulos3.btnArticulosEditar.setVisible(true);
        frmArticulos3.btnNuevo.setVisible(true);
    }
    
    public void buscartabla(String Articulo)
    {
            frmArticulosBuscar.txtArticulosBuscar.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke){
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+Articulo, 1));
            }
        });
        trs = new TableRowSorter(frmArticulosBuscar.tblArticulosbuscar.getModel());
        frmArticulosBuscar.tblArticulosbuscar.setRowSorter(trs);
    }
    
}
