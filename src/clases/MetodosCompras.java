/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import Compras.frmComprasnuevas;
import java.util.Calendar;
import java.util.Date;
import proveedores.frmProveedorBuscar;

/**
 *
 * @author usuario
 */
public class MetodosCompras {
    
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
    }
    
    public static Date sumarRestarDiasFecha(Date fecha, int dias) 
        {
        Calendar calendar = Calendar.getInstance();
	calendar.setTime(fecha); // Configuramos la fecha que se recibe
        calendar.add(Calendar.DAY_OF_YEAR, dias);  // numero de días a añadir, o restar en caso de días<0
        return calendar.getTime(); // Devuelve el objeto Date con los nuevos días añadidos
        }
    
}
