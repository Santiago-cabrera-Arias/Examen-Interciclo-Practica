/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.controlador;

import ec.ups.edu.modelo.Estudiantes;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author santi
 */
public class ControladorEstudiante extends ControladorAbstracto<Estudiantes> {

    private RandomAccessFile archivo;
    private int salto = 0;
    private int registro = 0;

     private static ControladorEstudiante instancia;

    public static ControladorEstudiante getInstancia() {

        if (instancia == null) {

            instancia = new ControladorEstudiante();

        }

        return instancia;
    }

    public ControladorEstudiante() {

        try {
            archivo = new RandomAccessFile("estudiantes.txt", "rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControladorEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * cedula = 10 nombre = 15 apellido = 15 direccion = 30 genero = 10.
     *
     * 80 + 10 = 90
     */
    @Override
    public boolean create(Estudiantes objeto) {

        try {
            archivo.seek(archivo.length());
            archivo.writeUTF(objeto.getCedula());
            archivo.writeUTF(objeto.getNombre());
            archivo.writeUTF(objeto.getApellido());
            archivo.writeUTF(objeto.getDireccion());
            archivo.writeUTF(objeto.getGenero());

        } catch (IOException ex) {
            Logger.getLogger(ControladorProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    @Override
    public Estudiantes read(String cedula) {

        salto = 0;
        registro = 90;

        try {

            while (salto < archivo.length()) {

                archivo.seek(salto);
                String cedulaDelArchivo = archivo.readUTF().trim();

                if (cedulaDelArchivo.equals(cedula)) {

                    Estudiantes estudiantes = new Estudiantes(cedula, archivo.readUTF().trim(), archivo.readUTF().trim(),
                            archivo.readUTF().trim(), archivo.readUTF().trim());

                    return estudiantes;

                }

                salto += registro;

            }

        } catch (IOException ex) {
            Logger.getLogger(ControladorEstudiante.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    @Override
    public boolean update(Estudiantes objeto) {

        salto = 0;
        registro = 90;

        try {

            while (salto < archivo.length()) {

                archivo.seek(salto);
                String cedulaDelArchivo = archivo.readUTF();

                if (cedulaDelArchivo.equals(objeto.getCedula())) {

                    archivo.writeUTF(objeto.getCedula().trim());
                    archivo.writeUTF(objeto.getNombre().trim());
                    archivo.writeUTF(objeto.getApellido().trim());
                    archivo.writeUTF(objeto.getDireccion().trim());
                    archivo.writeUTF(objeto.getGenero().trim());

                    return true;

                }

                salto += registro;

            }

            return false;
        } catch (IOException ex) {
            Logger.getLogger(ControladorProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    @Override
    public boolean delete(String cedula) {

        salto = 0;
        registro = 90;
        String cadena = "";

        try {

            while (salto < archivo.length()) {

                archivo.seek(salto);

                String cedulaDelArchivo = archivo.readUTF().trim();

                if (cedulaDelArchivo.equals(cedula)) {

                    archivo.seek(salto);

                    archivo.writeUTF(String.format("%-" + 10 + "s", cadena));
                    archivo.writeUTF(String.format("%-" + 15 + "s", cadena));
                    archivo.writeUTF(String.format("%-" + 15 + "s", cadena));
                    archivo.writeUTF(String.format("%-" + 30 + "s", cadena));
                    archivo.writeUTF(String.format("%-" + 10 + "s", cadena));

                }

                salto += registro;

            }

        } catch (IOException ex) {
            Logger.getLogger(ControladorProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public List<Estudiantes> lista() {

        List<Estudiantes> listar = new ArrayList<>();

        salto = 0;
        registro = 90;

        try {

            while (salto < archivo.length()) {

                archivo.seek(salto);
                String cedula = archivo.readUTF().trim();

                if (!cedula.equals("")) {

                    Estudiantes estudiante = new Estudiantes(cedula, archivo.readUTF().trim(), archivo.readUTF().trim(),
                            archivo.readUTF().trim(), archivo.readUTF().trim());

                    listar.add(estudiante);

                }

                salto += registro;

            }
        } catch (IOException ex) {
            Logger.getLogger(ControladorProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listar;

    }
    
    
        
    private Pattern patron;
    private Matcher corpus;
    
    public boolean validar(String texto){
        
        //crea un matcher para especificar el corpus a buscar.
        corpus = patron.matcher(texto);
        return corpus.find();//busqueda del texto.metodo del corpus "matcher"
        
    }
    
    public void ingresarPatron(String texto){
        
        patron = Pattern.compile(texto);
        
        
    }
    
    public void buscar(){
        
        
        
    }
    
    
}
