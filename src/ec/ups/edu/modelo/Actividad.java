/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.modelo;

/**
 *
 * @author santi
 */
public class Actividad {
    
    private int curso;
    private String tema;

    public Actividad() {
    }

    public Actividad(int curso, String tema) {
        this.curso = curso;
        this.tema = tema;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + this.curso;
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
        final Actividad other = (Actividad) obj;
        if (this.curso != other.curso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Actividad{" + "curso=" + curso + ", tema=" + tema + '}';
    }
    
    
}
