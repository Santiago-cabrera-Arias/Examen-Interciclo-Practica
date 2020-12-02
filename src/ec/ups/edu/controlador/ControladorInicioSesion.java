/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.controlador;

import ec.ups.edu.modelo.Usuario;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author santi
 */
public class ControladorInicioSesion {

    private RandomAccessFile archivo;
    private int salto = 0;
    private int registro = 0;

    private static ControladorInicioSesion instancia;

    public static ControladorInicioSesion getInstancia() {

        if (instancia == null) {

            instancia = new ControladorInicioSesion();

        }

        return instancia;
    }

    
    public ControladorInicioSesion() {
        
        try {

            archivo = new RandomAccessFile("texto.txt", "rw");

        } catch (IOException ex) {

            ex.printStackTrace();

        }

    }

    /**
     * int correo = 50 int contrasena = 15 Strin opcion =30;
     *
     * registro = 95 + 6 = 101
     *
     */
    public boolean registrar(Usuario objeto) {

        try {

            archivo.seek(archivo.length());
            archivo.writeUTF(objeto.getCorreo());
            archivo.writeUTF(objeto.getContrasena());
            archivo.writeUTF(objeto.getTipoUsuario());
            
            
        } catch (IOException ex) {

            System.out.println("Error de lectura y escritura");
            ex.printStackTrace();

        }

        return false;

    }

    public Usuario validar(Usuario objeto) {

        int salto = 0;
        registro = 96;

        try {

            while (salto < archivo.length()) {
                archivo.seek(salto);

                String correoDelArchivo = archivo.readUTF().trim();
                String contrasenaDelArchivo = archivo.readUTF().trim();
                String tipoDeUsuario = archivo.readUTF().trim();
                
                System.out.println(correoDelArchivo);
                System.out.println(contrasenaDelArchivo);
                System.out.println(tipoDeUsuario);
                
                System.out.println(objeto.getCorreo());
                System.out.println(objeto.getContrasena());
                System.out.println(objeto.getTipoUsuario());
                
                if (correoDelArchivo.equals(objeto.getCorreo().trim()) && contrasenaDelArchivo.equals(objeto.getContrasena().trim()) 
                        && tipoDeUsuario.equals(objeto.getTipoUsuario().trim()) ) {

                    
                    Usuario usuario = new Usuario(correoDelArchivo, contrasenaDelArchivo, tipoDeUsuario);

                    
                    
                    return usuario;

                }
                
                
                
                salto += registro;

            }

        } catch (IOException ex) {

            ex.printStackTrace();

        }
        return null;

    }

}
