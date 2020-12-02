/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.ups.edu.controlador;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author santi
 */
public abstract class ControladorAbstracto <T>{
    
    public abstract boolean create(T objeto);
    public abstract T read(String cedula);
    public abstract boolean update(T objeto);
    public abstract boolean delete(String cedula);
    public abstract List<T> lista();
    
        
    
    
}
