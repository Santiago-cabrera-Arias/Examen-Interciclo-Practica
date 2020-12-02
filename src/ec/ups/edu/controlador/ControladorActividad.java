/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.controlador;

import ec.ups.edu.modelo.Actividad;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author santi
 */
public class ControladorActividad {

    
    private int salto = 0;
    private int registro = 0;
    private Pattern patron;
    private Matcher corpus;
    
    public String extraerContenido(String Obteneturl) throws MalformedURLException, IOException {
        
        
        URL url = new URL(Obteneturl);
        URLConnection ConexionUrl = url.openConnection();
        InputStream is = ConexionUrl.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String contenido = "";
        String linea = br.readLine();
        while (null != linea) {
            contenido += linea;
            linea = br.readLine();
        }
        return contenido;

        
        
    }
    
     public String MostrarLinks(String contenido) {
        Pattern pattern = Pattern.compile("((href=)\"(\\/store\\/apps\\/details)(.)(id=)(.\\S*)\")");
        Matcher matcher = pattern.matcher(contenido);
        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
        return null;
    }
     
     public String obtenerTitulo(String texto){
       corpus=patron.matcher(texto);
        while(corpus.find()){
            String titulo = (corpus.group(0));
            return titulo;
        }
        return "Fallo"; 
    }
     
     
}
