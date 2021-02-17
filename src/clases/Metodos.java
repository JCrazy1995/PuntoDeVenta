/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author carlo
 */
public class Metodos {
    Connection con = null;
     static ResultSet rs=null;
    private Statement stmt=null;
    conexion conectar = new conexion();
    
    public void guardarClientes(String Nombre, String telefono, int tipoPago, int dias,String colonia, String calle, int Numero, String interior, int cp){
        con = conectar.conectarMySQL();
        try {
            stmt = con.createStatement();
            PreparedStatement psInsert= con.prepareStatement("INSERT INTO tblClientes(nombre, telefono,tipoPago,diasCredito, colonia, calle, numeroExterior, interior, CP)"
                   + " VALUES (?,?,?,?,?,?,?,?,?)");
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
}
