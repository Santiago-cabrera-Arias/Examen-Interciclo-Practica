/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.controlador;

import ec.ups.edu.modelo.Profesor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santi
 */
public class ControladorProfesor extends ControladorAbstracto<Profesor> {

    private static ControladorProfesor instancia;

    public static ControladorProfesor getInstancia() {

        if (instancia == null) {

            instancia = new ControladorProfesor();

        }

        return instancia;
    }

    private RandomAccessFile archivo;
    private int salto = 0;
    private int registro = 0;

    /**
     * cedula = 10 nombre = 15 apellido = 15 direccion = 30 genero = 10 combobox
     * =30
     *
     * 110 + 12 = 122
     */
    public ControladorProfesor() {

        try {
            archivo = new RandomAccessFile("profesor.txt", "rw");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ControladorProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public boolean create(Profesor objeto) {

        try {
            archivo.seek(archivo.length());
            archivo.writeUTF(objeto.getCedula());
            archivo.writeUTF(objeto.getNombre());
            archivo.writeUTF(objeto.getApellido());
            archivo.writeUTF(objeto.getDireccion());
            archivo.writeUTF(objeto.getGenero());
            archivo.writeUTF(objeto.getAsignar());

        } catch (IOException ex) {
            Logger.getLogger(ControladorProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    @Override
    public Profesor read(String cedula) {

        salto = 0;
        registro = 122;

        try {

            while (salto < archivo.length()) {

                archivo.seek(salto);
                String cedulaDelArchivo = archivo.readUTF().trim();

                if (cedula.equals(cedulaDelArchivo)) {

                    Profesor profesor = new Profesor(cedulaDelArchivo, archivo.readUTF().trim(), archivo.readUTF().trim(),
                            archivo.readUTF().trim(), archivo.readUTF().trim(), archivo.readUTF().trim());

                    return profesor;

                }

                salto += registro;

            }

        } catch (IOException ex) {
            Logger.getLogger(ControladorProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public boolean update(Profesor objeto) {

        salto = 0;
        registro = 122;

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
                    archivo.writeUTF(objeto.getAsignar().trim());

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
        registro = 122;
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
                    archivo.writeUTF(String.format("%-" + 30 + "s", cadena));

                }

                salto += registro;

            }

        } catch (IOException ex) {
            Logger.getLogger(ControladorProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    @Override
    public List<Profesor> lista() {

        List<Profesor> listar = new ArrayList<>();

        salto = 0;
        registro = 122;

        try {

            while (salto < archivo.length()) {

                archivo.seek(salto);
                String cedula = archivo.readUTF().trim();

                if (!cedula.equals("")) {

                    Profesor profesor = new Profesor(cedula, archivo.readUTF().trim(), archivo.readUTF().trim(),
                            archivo.readUTF().trim(), archivo.readUTF().trim(), archivo.readUTF().trim());

                    listar.add(profesor);

                }

                salto += registro;

            }
        } catch (IOException ex) {
            Logger.getLogger(ControladorProfesor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listar;

    }

}
