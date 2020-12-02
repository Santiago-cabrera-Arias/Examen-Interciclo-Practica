/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.modelo;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author santi
 */
public class Profesor {

    private String cedula;
    private String nombre;
    private String apellido;
    private String direccion;
    private String genero;
    private String asignar;

    public Profesor(String cedula) {
        this.cedula = cedula;
    }

    public Profesor(String cedula, String nombre, String apellido, String direccion, String genero, String asignar) {
       
        this.setCedula(cedula);
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setDireccion(direccion);
        this.setGenero(genero);
        this.setAsignar(asignar);
    }

    public String validarEspacios(String cadena, int numero) {
        if (cadena.length() == numero) {
            return cadena;
        } else {
            if (cadena.length() > numero) {
                cadena = cadena.substring(0, numero);
                return cadena;
            } else {
                for (int i = cadena.length(); i < numero; i++) {
                    cadena += " ";
                }
                return cadena;
            }
        }
    }

    /**
     * cedula = 10 nombre = 15 apellido = 15 direccion = 30 genero = 10 combobox
     * =30
     *
     * 130 + 12 = 122
     */
    public String getAsignar() {
        return asignar;
    }

    public void setAsignar(String asignar) {

        this.asignar = validarEspacios(asignar, 30);

    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {

        this.cedula = validarEspacios(cedula, 10);

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = validarEspacios(nombre, 15);

    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {

        this.apellido = validarEspacios(apellido, 15);

    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {

        this.direccion = validarEspacios(direccion, 30);

    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {

        this.genero = validarEspacios(genero, 10);

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.cedula);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Profesor other = (Profesor) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Profesor{" + "cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", genero=" + genero + ", asignar=" + asignar + '}';
    }

}
