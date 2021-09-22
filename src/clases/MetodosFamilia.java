/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import Familias.*;
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
public class MetodosFamilia {
    
    Connection con = null;
    static ResultSet rs=null;
    private Statement stmt=null;
    conexion conectar = new conexion();
    Object filas[] = new Object[5];
    TableRowSorter trs; // Variable Para lo del filtrado de la busqueda
    
    public void FamiliaCrear(String nombre)
    {  
        try 
        {
            con=conectar.conectarMySQL();
            stmt= con.createStatement();
            PreparedStatement insertarfamilia= con.prepareStatement("Insert into tblfamilia (famnombre,estatus)values(?,?);");
            insertarfamilia.setString(1, nombre);
            insertarfamilia.setString(2, "Activo");
            insertarfamilia.execute();
            insertarfamilia.close();
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
            
        } 
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    public int UltimoIdFamilia()
    {   int id=0;
       
        try 
        {
            con=conectar.conectarMySQL();
            stmt=con.createStatement();
            rs=stmt.executeQuery("select max(id_familia) from tblfamilia");
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
    
    
    public void Actualizar(int id,String nombre)
    {
        try 
        {
            con=conectar.conectarMySQL();
            stmt=con.createStatement();
            PreparedStatement actualizar = con.prepareStatement("update tblfamilia set famnombre=? where id_familia=?");
            actualizar.setString(1, nombre);
            actualizar.setInt(2, id);
            actualizar.executeUpdate();
            actualizar.close();
            JOptionPane.showMessageDialog(null, "Acutalizado Correctamente");
        } 
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    
    public void eliminar(int id)
    {
        try 
        {
            con=conectar.conectarMySQL();
            stmt=con.createStatement();
            PreparedStatement eliminar = con.prepareStatement("update tblfamilia set estatus='Cancelado' where id_familia =?");
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
        frmfamiliaBuscar.modelotablafamilia.addColumn("ID");
        frmfamiliaBuscar.modelotablafamilia.addColumn("Nombre");
        frmfamiliaBuscar.tblfamilabuscar.setModel(frmfamiliaBuscar.modelotablafamilia);
        frmfamilia.vezuna = true;
        tamañocolumnas();
        acomodofilas();
    }
    
    public void acomodofilas(){
        
        frmfamiliaBuscar.tblfamilabuscar.setRowHeight(30);    
        frmfamiliaBuscar.tcr.setHorizontalAlignment(SwingConstants.CENTER);
        frmfamiliaBuscar.tblfamilabuscar.getColumnModel().getColumn(0).setCellRenderer( frmfamiliaBuscar.tcr);
        frmfamiliaBuscar.tblfamilabuscar.getColumnModel().getColumn(1).setCellRenderer( frmfamiliaBuscar.tcr);    
    }
    public void tamañocolumnas()
    {
         TableColumnModel ModeloColumnas = frmfamiliaBuscar.tblfamilabuscar.getColumnModel();
          ModeloColumnas.getColumn(0).setPreferredWidth(50);
          ModeloColumnas.getColumn(1).setPreferredWidth(200);
    }
    
   
    
    public void FamiliaBuscar()
    { 
      
        try 
        {
            con=conectar.conectarMySQL();
            stmt=con.createStatement();
            rs= stmt.executeQuery("select * from tblfamilia where estatus='Activo';");
            while(rs.next())
            {
                filas[0]=rs.getInt(1);
                filas[1]=rs.getString(2);
                frmfamiliaBuscar.modelotablafamilia.addRow(filas);
            }
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public void FamiliaEditarPasar()
    {
        String id,nombre,precio,preciocompra,empaquetado;
        id=frmfamiliaBuscar.tblfamilabuscar.getValueAt(frmfamiliaBuscar.tblfamilabuscar.getSelectedRow(), 0).toString();
        nombre=frmfamiliaBuscar.tblfamilabuscar.getValueAt(frmfamiliaBuscar.tblfamilabuscar.getSelectedRow(), 1).toString();
        
        frmFamiliaEditar.lblidfamilia.setText(id);
        frmFamiliaEditar.txtNombreFamilia.setText(nombre);
        
        buscartabla("");
        frmfamiliaBuscar.txtfamiliabuscar.setText("");
        //frmArticulosEditar.cmbEmpaquetado.setSelectedItem(empaquetado);
    }
    
    public void ocultarbotones()
    {
        frmfamilia.btnFamiliaBuscar.setVisible(false);
        frmfamilia.btnFamiliaNuevo.setVisible(false);
        frmfamilia.btnFamiliasEditar.setVisible(false);
    }
    
    public void mostrarbotones()
    {
        frmfamilia.btnFamiliaBuscar.setVisible(true);
        frmfamilia.btnFamiliaNuevo.setVisible(true);
        frmfamilia.btnFamiliasEditar.setVisible(true);
    }
    
    public void buscartabla(String Articulo)
    {
            frmfamiliaBuscar.txtfamiliabuscar.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke){
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+Articulo, 1));
            }
        });
        trs = new TableRowSorter(frmfamiliaBuscar.tblfamilabuscar.getModel());
        frmfamiliaBuscar.tblfamilabuscar.setRowSorter(trs);
    }
    
}
