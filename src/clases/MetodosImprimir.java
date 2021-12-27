/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
    public void imprimirnotaoriginal(Integer idventa,String letras,String Cliente,int Filas){
         try 
        {   HashMap param = new HashMap();
             con =  conectar.conectarMySQL();
            JasperDesign jd = JRXmlLoader.load(new File("C:\\Users\\usuario\\JaspersoftWorkspace\\PuntoV").getAbsolutePath()+"\\Notaoriginal.jrxml"); 
            param.put("Numeronota", idventa);
            param.put("letras", letras );
            param.put("cantidadarticulos", Filas );
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr,param,con);
            OutputStream output = new FileOutputStream(new File("C:\\Users\\usuario\\Desktop\\prueba\\"
                        +Cliente+" "+"Nota N° "+" "+idventa+" original.pdf")); 
            JasperExportManager.exportReportToPdfStream(jp, output); 
            output.flush();
            output.close();
              
        } 
        catch (JRException | IOException ex) 
        {
            Logger.getLogger(MetodosImprimir.class.getName()).log(Level.SEVERE, null, ex);
        }
          File fileToPrint = new  File("C:\\Users\\usuario\\Desktop\\prueba\\"
                        +Cliente+" "+"Nota N° "+" "+idventa+" original.pdf");
      
        try 
        {
            Desktop.getDesktop().print(fileToPrint);
            JOptionPane.showMessageDialog(null, "olo");
        } 
        catch (IOException ex) 
        {
            JOptionPane.showMessageDialog(null, ex,"Error",JOptionPane.ERROR_MESSAGE);
        }  
    }
    
     public void imprimirnotacopia(Integer idventa,String letras,String Cliente,int Filas){
         try 
        {   HashMap param = new HashMap();
             con =  conectar.conectarMySQL();
            JasperDesign jd = JRXmlLoader.load(new File("C:\\Users\\usuario\\JaspersoftWorkspace\\PuntoV").getAbsolutePath()+"\\NotaCopia.jrxml"); 
            param.put("Numeronota", idventa);
            param.put("letras", letras );
            param.put("cantidadarticulos", Filas );
            JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(jr,param,con);
            OutputStream output = new FileOutputStream(new File("C:\\Users\\usuario\\Desktop\\prueba\\"
                        +Cliente+" "+"Nota N° "+" "+idventa+" Copia.pdf")); 
            JasperExportManager.exportReportToPdfStream(jp, output); 
            output.flush();
            output.close();
              
        } 
        catch (JRException | IOException ex) 
        {
            Logger.getLogger(MetodosImprimir.class.getName()).log(Level.SEVERE, null, ex);
        }
         File fileToPrint = new  File("C:\\Users\\usuario\\Desktop\\prueba\\"
                        +Cliente+" "+"Nota N° "+" "+idventa+" Copia.pdf");
      
        try 
        {
            Desktop.getDesktop().print(fileToPrint);
        } 
        catch (IOException ex) 
        {
            JOptionPane.showMessageDialog(null, ex,"Error",JOptionPane.ERROR_MESSAGE);
        }  
    }
     
}
