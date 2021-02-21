/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author usuario
 */
 

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import proveedores.frmProveedorBuscar;
import proveedores.frmProveedorEditar;
import proveedores.frmProveedores;

public class MetodosProveedores {
    Connection con = null;
    static ResultSet rs=null;
    private Statement stmt=null;
    conexion conectar = new conexion();
    TableRowSorter trs; // Variable Para lo del filtrado de la busqueda
    Object filas[] = new Object[5];
    public void AgregarProveedor(String nombre,String telefono,int tipopago,String dias)
    {
        try 
        {
           con=conectar.conectarMySQL();
           stmt=con.createStatement();
           PreparedStatement agregar = con.prepareStatement("insert into tblProveedores (nombre,telefono,tipoPago,"
                   + "diasCredito,estatus) values(?,?,?,?,?);");
           agregar.setString(1, nombre);
           agregar.setString(2, telefono);
           agregar.setInt(3, tipopago);
           agregar.setString(4, dias);
           agregar.setString(5, "Activo");
           agregar.execute();
           agregar.close();
           JOptionPane.showMessageDialog(null, "Agregado Correctamente","Realizado",JOptionPane.INFORMATION_MESSAGE);
           
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e,"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public int ultimoid()
    {
        int lasid=0;
        try 
        {
            con=conectar.conectarMySQL();
            stmt=con.createStatement();
            rs=stmt.executeQuery("Select max(idProveedor) from tblproveedores;");
            if(rs.next())
            {
                lasid=rs.getInt(1)+1;
            }
        } 
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        return lasid;
    }
    
    public void ocultarbotones(){
        frmProveedores.btnNuevo.setVisible(false);
        frmProveedores.btnBuscar.setVisible(false);
        frmProveedores.btnEditar.setVisible(false);
    }
    
    public void tablaModelo(){
        frmProveedorBuscar.modeloTabla.addColumn("Numero");
        frmProveedorBuscar.modeloTabla.addColumn("Nombre");
        frmProveedorBuscar.modeloTabla.addColumn("Telefono");
        frmProveedorBuscar.modeloTabla.addColumn("Tipo pago");
        frmProveedorBuscar.modeloTabla.addColumn("Días de credito");
        frmProveedorBuscar.tblBuscar.setModel(frmProveedorBuscar.modeloTabla);
        frmProveedores.vezuna = true;
    }
    
    public void mostrarbotones(){
        frmProveedores.btnNuevo.setVisible(true);
        frmProveedores.btnBuscar.setVisible(true);
        frmProveedores.btnEditar.setVisible(true);
    }
    
    public void mostrarProveedores(){
        try {
            int TipoPago;
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from tblProveedores where estatus ='Activo';");
            while (rs.next()){
                filas[0] = rs.getInt(1);
                filas[1] = rs.getString(2);
                filas[2] = rs.getString (3);
                TipoPago = rs.getInt(4);
                if(TipoPago==1)
                {
                    filas[3]="Contado";
                }
                else
                {
                    filas[3]="Crédito";
                }
                filas[4] = rs.getInt(5);      
                frmProveedorBuscar.modeloTabla.addRow(filas);
            }
        } catch (SQLException e) {
        }
    }
    
    public void filtrarDatosTableBuscar(String proveedor){
        frmProveedorBuscar.txtBuscar.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke){
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+proveedor, 1));
            }
        });
        trs = new TableRowSorter(frmProveedorBuscar.tblBuscar.getModel());
        frmProveedorBuscar.tblBuscar.setRowSorter(trs);
    }
    
    public void enviardatos(){
        
        String id,diasCredito, tipoPago, nombre,  telefono;
        id=frmProveedorBuscar.tblBuscar.getValueAt(frmProveedorBuscar.tblBuscar.getSelectedRow(), 0).toString();
        nombre=frmProveedorBuscar.tblBuscar.getValueAt(frmProveedorBuscar.tblBuscar.getSelectedRow(), 1).toString();
        telefono=frmProveedorBuscar.tblBuscar.getValueAt(frmProveedorBuscar.tblBuscar.getSelectedRow(), 2).toString();
        tipoPago=frmProveedorBuscar.tblBuscar.getValueAt(frmProveedorBuscar.tblBuscar.getSelectedRow(), 3).toString();
        diasCredito=frmProveedorBuscar.tblBuscar.getValueAt(frmProveedorBuscar.tblBuscar.getSelectedRow(), 4).toString();
        
        frmProveedorEditar.lblidProvedor.setText(id);
        frmProveedorEditar.txtnombre.setText(nombre);
        frmProveedorEditar.txttelefono.setText(telefono);
        frmProveedorEditar.cmbtipopago.setSelectedItem(tipoPago);
        frmProveedorEditar.txtdiascredito.setText(diasCredito);
    }
    
    public void Update(int id, String nombre, String telefono, int tipo, int dias){
        try {
            con = conectar.conectarMySQL();
            stmt= con.createStatement();
            PreparedStatement actualizar = con.prepareStatement("update tblproveedores set nombre=?,"
                    + "telefono=?, tipoPago=?, diasCredito=? where idProveedor=?");
            actualizar.setString(1, nombre);
            actualizar.setString(2, telefono);
            actualizar.setInt(3, tipo);
            actualizar.setInt(4, dias);
            actualizar.setInt(5, id);
            actualizar.executeUpdate();
            actualizar.close();
            JOptionPane.showMessageDialog(null, "Exitoso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public void limpiarTablaProveedores(){
        frmProveedorBuscar.modeloTabla.setRowCount(0);
        
    }
    
}

