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
    static ResultSet rs=null;
    private Statement stmt=null;
    conexion conectar = new conexion();
    Object filas[] = new Object[5];
    TableRowSorter trs;
    
    public void regresarproveedor(){
        String id,nombre,tipopago,diascredito;
       id= frmProveedorBuscar.tblBuscar.getValueAt(frmProveedorBuscar.tblBuscar.getSelectedRow(), 0).toString();
       nombre = frmProveedorBuscar.tblBuscar.getValueAt(frmProveedorBuscar.tblBuscar.getSelectedRow(), 1).toString();
       tipopago=frmProveedorBuscar.tblBuscar.getValueAt(frmProveedorBuscar.tblBuscar.getSelectedRow(), 3).toString();
       diascredito= frmProveedorBuscar.tblBuscar.getValueAt(frmProveedorBuscar.tblBuscar.getSelectedRow(), 4).toString();
       frmComprasnuevas.lblProvedornombre1.setText(nombre);
       frmComprasnuevas.lblNproveedor.setText(id);
       frmComprasnuevas.lbltipopago.setText(tipopago);
       frmComprasnuevas.lbldiascredito.setText(diascredito);
       frmComprasnuevas.jdcfechacompra.setEnabled(true);
    }
    
    public void modeloTablaBuscar(){
                
        if(frmComprasBuscarArticulo.controlModelo==false){
            frmComprasBuscarArticulo.mo.addColumn("ID");
            frmComprasBuscarArticulo.mo.addColumn("Nombre");
            frmComprasBuscarArticulo.mo.addColumn("Precio");
            frmComprasBuscarArticulo.tblComprasTabla.setModel(frmComprasBuscarArticulo.mo);
            frmComprasBuscarArticulo.controlModelo=true;
        }
        
    }
    
    public void modeloTablaCompras(){
        if(frmComprasnuevas.controlModelo==false){
            frmComprasnuevas.modelo.addColumn("ID Articulo");
            frmComprasnuevas.modelo.addColumn("Nombre");
            frmComprasnuevas.modelo.addColumn("Precio");
            frmComprasnuevas.modelo.addColumn("Cantidad");
            frmComprasnuevas.modelo.addColumn("Total");
            frmComprasnuevas.tblCompra.setModel(frmComprasnuevas.modelo);
            frmComprasnuevas.controlModelo=true;
        }
    }
    
    public static Date sumarRestarDiasFecha(Date fecha, int dias) 
        {
        Calendar calendar = Calendar.getInstance();
	calendar.setTime(fecha); // Configuramos la fecha que se recibe
        calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0
        return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
        }
   
    
    public void busquedaArticulos(){
        try 
        {
            con=conectar.conectarMySQL();
            stmt=con.createStatement();
            rs= stmt.executeQuery("select idArticulos, nombre, precio_compra from tblarticulos where estatus='Activo';");
            while(rs.next())
            {
                filas[0]=rs.getInt(1);
                filas[1]=rs.getString(2);
                filas[2]=rs.getFloat(3);
                frmComprasBuscarArticulo.mo.addRow(filas);
            }
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public void filtradoBusquedaNombre(String busqueda){
        try 
        {
            frmComprasBuscarArticulo.mo.setRowCount(0);
            con=conectar.conectarMySQL();
            stmt=con.createStatement();
            rs= stmt.executeQuery("select idArticulos, nombre, precio_compra from tblarticulos where estatus='Activo'"
                    + "and nombre like '%"+busqueda+"%';");
            while(rs.next())
            {
                filas[0]=rs.getInt(1);
                filas[1]=rs.getString(2);
                filas[2]=rs.getFloat(3);
                frmComprasBuscarArticulo.mo.addRow(filas);
            }
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public void filtradoBusquedaID(int busqueda){
        try 
        {
            frmComprasBuscarArticulo.mo.setRowCount(0);
            con=conectar.conectarMySQL();
            stmt=con.createStatement();
            rs= stmt.executeQuery("select idArticulos, nombre, precio_compra from tblarticulos where estatus='Activo'"
                    + "and idArticulos like '%"+busqueda+"%';");
            while(rs.next())
            {
                filas[0]=rs.getInt(1);
                filas[1]=rs.getString(2);
                filas[2]=rs.getFloat(3);
                frmComprasBuscarArticulo.mo.addRow(filas);
            }
            con.close();
        } 
        catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    
      public void buscartabla(String Articulo)
    {
            frmComprasBuscarArticulo.txtFiltroArticulos.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent ke){
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+Articulo, 1));
            }
        });
        trs = new TableRowSorter(frmComprasBuscarArticulo.tblComprasTabla.getModel());
        frmComprasBuscarArticulo.tblComprasTabla.setRowSorter(trs);
    }
      
      
     public void limpiarCamposFrmComprasBuscarArticulo(){
         frmComprasBuscarArticulo.lblid.setText("");
         frmComprasBuscarArticulo.lblnombre.setText("");
         frmComprasBuscarArticulo.lbltotal.setText("0.0");
         frmComprasBuscarArticulo.txtcantidad.setText("0.0");
         frmComprasBuscarArticulo.txtprecio.setText("0.0");
     }
     
      public void enviarDatosCompras(String ID,String nombre, String precio, String cantidad, float total){
          float suma,lbl;
          Object f[]=new Object[5]; 
          f[0]=ID;
          f[1]=nombre;
          f[2]=precio;
          f[3]=cantidad;
          f[4]=total;
          frmComprasnuevas.modelo.addRow(f);
          frmComprasnuevas.tblCompra.setModel(frmComprasnuevas.modelo);
          lbl=Float.parseFloat(frmComprasnuevas.lblTotal.getText());
          suma=total+lbl;
          frmComprasnuevas.lblTotal.setText(suma+"");
      }
      
}
