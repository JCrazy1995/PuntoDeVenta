/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import Ventas.frmrventasreimprimir;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author usuario
 */
public class MetodosImprimir {

    Connection con = null;
    static ResultSet rs = null;
    private Statement stmt = null;
    conexion conectar = new conexion();
    Object filas[] = new Object[6];

    public void imprimirnotaoriginal(Integer idventa, String letras, String Cliente, int Filas) {
        try {
            HashMap param = new HashMap();
            con = conectar.conectarMySQL();
            JasperDesign jd = JRXmlLoader.load(new File("C:\\Users\\usuario\\JaspersoftWorkspace\\PuntoV").getAbsolutePath() + "\\Notaoriginal.jrxml");
            param.put("Numeronota", idventa);
            param.put("letras", letras);
            param.put("cantidadarticulos", Filas);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, param, con);
            OutputStream output = new FileOutputStream(new File("C:\\Users\\usuario\\Desktop\\prueba\\"
                    + Cliente + " " + "Nota N° " + " " + idventa + " original.pdf"));
            JasperExportManager.exportReportToPdfStream(jp, output);
            output.flush();
            output.close();

        } catch (JRException | IOException ex) {
            Logger.getLogger(MetodosImprimir.class.getName()).log(Level.SEVERE, null, ex);
        }
        File fileToPrint = new File("C:\\Users\\usuario\\Desktop\\prueba\\"
                + Cliente + " " + "Nota N° " + " " + idventa + " original.pdf");

        try {
            Desktop.getDesktop().print(fileToPrint);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void imprimirnotacopia(Integer idventa, String letras, String Cliente, int Filas) {
        try {
            HashMap param = new HashMap();
            con = conectar.conectarMySQL();
            JasperDesign jd = JRXmlLoader.load(new File("C:\\Users\\usuario\\JaspersoftWorkspace\\PuntoV").getAbsolutePath() + "\\NotaCopia.jrxml");
            param.put("Numeronota", idventa);
            param.put("letras", letras);
            param.put("cantidadarticulos", Filas);
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr, param, con);
            OutputStream output = new FileOutputStream(new File("C:\\Users\\usuario\\Desktop\\prueba\\"
                    + Cliente + " " + "Nota N° " + " " + idventa + " Copia.pdf"));
            JasperExportManager.exportReportToPdfStream(jp, output);
            output.flush();
            output.close();

        } catch (JRException | IOException ex) {
            Logger.getLogger(MetodosImprimir.class.getName()).log(Level.SEVERE, null, ex);
        }
        File fileToPrint = new File("C:\\Users\\usuario\\Desktop\\prueba\\"
                + Cliente + " " + "Nota N° " + " " + idventa + " Copia.pdf");

        try {
            Desktop.getDesktop().print(fileToPrint);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void modelotablareimprimir() {
        if (frmrventasreimprimir.controlModelo == false) {
            frmrventasreimprimir.modelo.addColumn("N° Nota");
            frmrventasreimprimir.modelo.addColumn("Nombre");
            frmrventasreimprimir.modelo.addColumn("Fecha");
            frmrventasreimprimir.modelo.addColumn("Fecha Pago");
            frmrventasreimprimir.modelo.addColumn("Total");
            frmrventasreimprimir.modelo.addColumn("Pagada");
            frmrventasreimprimir.tblreimprimecliente.setModel(frmrventasreimprimir.modelo);
            TamañoColumnas();
            frmrventasreimprimir.controlModelo = true;
        } else {
            frmrventasreimprimir.tblreimprimecliente.setModel(frmrventasreimprimir.modelo);
            TamañoColumnas();

        }
    }

    public static void TamañoColumnas() {
        TableColumnModel ModeloColumnas = frmrventasreimprimir.tblreimprimecliente.getColumnModel();
        ModeloColumnas.getColumn(0).setPreferredWidth(70);
        ModeloColumnas.getColumn(1).setPreferredWidth(200);
        ModeloColumnas.getColumn(2).setPreferredWidth(100);
        ModeloColumnas.getColumn(3).setPreferredWidth(100);
        ModeloColumnas.getColumn(4).setPreferredWidth(100);
        ModeloColumnas.getColumn(5).setPreferredWidth(80);
        frmrventasreimprimir.tblreimprimecliente.setRowHeight(25);
    }

    public void llenartablareimpiresion() {
        try {
            con = conectar.conectarMySQL();
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select tblventas.idventas,tblclientes.clinombre,tblventas.fecha_venta"
                    + ",tblventas.fecha_pago,tblventas.total,tblventas.pagada from tblventas "
                    + "inner join tblclientes on tblclientes.idCliente=tblventas.idCliente"
                    + " where tblclientes.estatus ='Activo' and tblventas.estatus ='activa';");
            String pagada;
            while (rs.next()) {
                filas[0] = rs.getString(1);///id
                filas[1] = rs.getString(2);///nombre
                filas[2] = rs.getString(3);///fecha venta
                if (rs.getInt(6) == 1) {
                    pagada = "SI";
                } else {
                    pagada = "NO";
                }

                filas[3] = rs.getString(4);///fecha Pago
                filas[4] = rs.getString(5);//total
                filas[5] = pagada;
                frmrventasreimprimir.modelo.addRow(filas);
            }

            con.close();
        } catch (SQLException e) {

        }
    }

    public void visualizarnotaOriginal(String Cliente, String idventa) {
        try {
            File path = new File("C:\\Users\\usuario\\Desktop\\prueba\\"
                    + Cliente + " " + "Nota N° " + " " + idventa + " original.pdf");
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void visualizarnotaCopia(String Cliente, String idventa) {
        try {
            File path = new File("C:\\Users\\usuario\\Desktop\\prueba\\"
                    + Cliente + " " + "Nota N° " + " " + idventa + " Copia.pdf");
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void ReImprimirnotaOriginal(String Cliente, String idventa) {
        try {
            File path = new File("C:\\Users\\usuario\\Desktop\\prueba\\"
                    + Cliente + " " + "Nota N° " + " " + idventa + " original.pdf");
             Desktop.getDesktop().print(path);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void ReImprimirnotaCopia(String Cliente, String idventa) {
        try {
            File path = new File("C:\\Users\\usuario\\Desktop\\prueba\\"
                    + Cliente + " " + "Nota N° " + " " + idventa + " original.pdf");
              Desktop.getDesktop().print(path);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
