/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;


import Usuarios.frmClientesBuscar;
import Usuarios.frmClientesEditar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author carlo
 */
public class Metodos {
    Connection con = null;
     static ResultSet rs=null;
    private Statement stmt=null;
    conexion conectar = new conexion();
    Object filas[] = new Object[10];
     TableRowSorter trs; // Variable Para lo del filtrado de la busqueda

    public void guardarClientes(String Nombre, String telefono, int tipoPago, int dias,String colonia, String calle, int Numero, String interior, int cp){
        con = conectar.conectarMySQL();
        try {
            stmt = con.createStatement();
            PreparedStatement psInsert= con.prepareStatement("INSERT INTO tblClientes(nombre, telefono,tipoPago,diasCredito, colonia, calle, numeroExterior, interior, CP,estatus)"
                   + " VALUES (?,?,?,?,?,?,?,?,?,?)");
//            psInsert.setString(1, nombre);
            psInsert.setString(1, Nombre);
            psInsert.setString(2, telefono);
            psInsert.setInt(3,tipoPago);
            psInsert.setInt(4,dias);
            psInsert.setString(5,colonia);
            psInsert.setString(6,calle);
            psInsert.setInt(7,Numero);
            psInsert.setString(8,interior);
            psInsert.setInt(9,cp);
            psInsert.setString(10,"Activo");
            psInsert.execute();
            psInsert.close();
            JOptionPane.showMessageDialog(null,"Registro èxitoso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e);
       
            
        }
        
    }
    
    public int ultimoCliente (){
        int lasid=0;
        try
        {
             con = conectar.conectarMySQL();
             stmt=con.createStatement();
             rs =stmt.executeQuery("select max(idCliente) from tblClientes ");
             if(rs.next())
            {
                lasid=rs.getInt(1)+1;
            }
            
            con.close();
        }
        catch(SQLException ex)
        {
         JOptionPane.showMessageDialog(null,"Ocurrio el siguiente error:"+ex);
        }
        return lasid;
    }
    
    
    public void BuscarClientes(){
        try {
            con = conectar.conectarMySQL();
            stmt =con.createStatement();
            rs= stmt.executeQuery("Select * from tblClientes ;");
            while(rs.next())
            {
                filas[0] = rs.getString(1);
                filas[1] = rs.getString(2);
                filas[2] = rs.getString(3);
                filas[3] = rs.getString(4);
                filas[4] = rs.getString(5);
                filas[5] = rs.getString(6);
                filas[6] = rs.getString(7);
                filas[7] = rs.getString(8);
                filas[8] = rs.getString(9);
                filas[9] = rs.getString(10);
                frmClientesBuscar.tablaBuscar.addRow(filas);
            } 
            
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //Este MEtdodo es para pasar los datos del frmclientesbuscar al frmclienteseditar
    public void ClientesEditarPasar(){
        
        String id, nombre, telefono,tpago, diasCredito, colonia, calle, exterior, interior, cp;
        id = frmClientesBuscar.tblClientesBuscar.getValueAt(frmClientesBuscar.tblClientesBuscar.getSelectedRow(),0 ).toString();
        nombre=frmClientesBuscar.tblClientesBuscar.getValueAt(frmClientesBuscar.tblClientesBuscar.getSelectedRow(),1 ).toString();
        telefono=frmClientesBuscar.tblClientesBuscar.getValueAt(frmClientesBuscar.tblClientesBuscar.getSelectedRow(),2 ).toString();
        tpago=frmClientesBuscar.tblClientesBuscar.getValueAt(frmClientesBuscar.tblClientesBuscar.getSelectedRow(),3 ).toString();
        diasCredito=frmClientesBuscar.tblClientesBuscar.getValueAt(frmClientesBuscar.tblClientesBuscar.getSelectedRow(),4 ).toString();
        colonia=frmClientesBuscar.tblClientesBuscar.getValueAt(frmClientesBuscar.tblClientesBuscar.getSelectedRow(),5 ).toString();
        calle=frmClientesBuscar.tblClientesBuscar.getValueAt(frmClientesBuscar.tblClientesBuscar.getSelectedRow(),6 ).toString();
        exterior=frmClientesBuscar.tblClientesBuscar.getValueAt(frmClientesBuscar.tblClientesBuscar.getSelectedRow(),7 ).toString();
        interior=frmClientesBuscar.tblClientesBuscar.getValueAt(frmClientesBuscar.tblClientesBuscar.getSelectedRow(),8 ).toString();
        cp=frmClientesBuscar.tblClientesBuscar.getValueAt(frmClientesBuscar.tblClientesBuscar.getSelectedRow(),9 ).toString();
    
        
        frmClientesEditar.lblidCliente.setText(id);
        frmClientesEditar.txtNombreCliente.setText(nombre);
        frmClientesEditar.txtTelefonoCliente.setText(telefono);
        if("1".equals(tpago))
        {
           frmClientesEditar.cmbTipoPago.setSelectedIndex(0);
        }
        else
        {
            frmClientesEditar.cmbTipoPago.setSelectedIndex(1);
        }
        frmClientesEditar.txtDiasCreditoCliente.setText(diasCredito);
        frmClientesEditar.txtColonia.setText(colonia);
        frmClientesEditar.txtCalle.setText(calle);
        frmClientesEditar.txtExterior.setText(exterior);
        frmClientesEditar.txtInterior.setText(interior);
        frmClientesEditar.txtCP.setText(cp);
    
    
    }
 
    public void ClientesActualizar(int idCliente,String Nombre, String telefono, int tipoPago, int dias,String colonia, String calle, int Numero, String interior, int cp){
        try {
          con= conectar.conectarMySQL();
          stmt =con.createStatement();
          PreparedStatement Acutalizardatos = con.prepareStatement("Update tblClientes set nombre=?,telefono=?,tipoPago=?"
                  + ",diasCredito=?,colonia=?,calle=?,numeroExterior=?,interior=?,cp=? where idCliente = ?");
          Acutalizardatos.setString(1, Nombre);
          Acutalizardatos.setString(2, telefono);
          Acutalizardatos.setInt(3,tipoPago);
          Acutalizardatos.setInt(4, dias);
          Acutalizardatos.setString(5, colonia);
          Acutalizardatos.setString(6, calle);
          Acutalizardatos.setInt(7, Numero);
          Acutalizardatos.setString(8, interior);
          Acutalizardatos.setInt(9, cp);
          Acutalizardatos.setInt(10, idCliente);
          Acutalizardatos.executeUpdate();
          Acutalizardatos.close();
          
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
         
    public void limpiartablaclientesbuscarclientes() 
        {

            DefaultTableModel tb = (DefaultTableModel) frmClientesBuscar.tblClientesBuscar.getModel();
            int a = frmClientesBuscar.tblClientesBuscar.getRowCount() - 1;
            for (int i = a; i >= 0; i--) 
            {
                tb.removeRow(tb.getRowCount() - 1);
            }
        }
    
     public void buscarclientetabla(String cliente){
         frmClientesBuscar.txtClientesBuscar.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke){
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+cliente, 1));
            }
        });
        trs = new TableRowSorter(frmClientesBuscar.tblClientesBuscar.getModel());
        frmClientesBuscar.tblClientesBuscar.setRowSorter(trs);
    }
    
}
