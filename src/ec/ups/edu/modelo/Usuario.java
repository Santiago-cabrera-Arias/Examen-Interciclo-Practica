/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.modelo;

import java.util.Objects;

/**
 *
 * @author santi
 */
public class Usuario {

    private String correo;
    private String contrasena;
    private String tipoUsuario;

    public Usuario() {
    }

    public Usuario(String correo, String contrasena, String tipoUsuario) {
        this.setCorreo(correo);
        this.setContrasena(contrasena);
        this.setTipoUsuario(tipoUsuario);

    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {

        this.tipoUsuario = validarEspacios(tipoUsuario, 30);

    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {

        this.correo = validarEspacios(correo, 50);

    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {

        this.contrasena = validarEspacios(contrasena, 10);

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.correo);
        hash = 47 * hash + Objects.hashCode(this.contrasena);
        hash = 47 * hash + Objects.hashCode(this.tipoUsuario);
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        if (!Objects.equals(this.contrasena, other.contrasena)) {
            return false;
        }
        if (!Objects.equals(this.tipoUsuario, other.tipoUsuario)) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return "Usuario{" + "correo=" + correo + ", contrasena=" + contrasena + ", tipoUsuario=" + tipoUsuario + '}';
    }

}
