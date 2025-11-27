/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import Conceptos.Estado;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Clase para abrir, cerrar y leer objetos Estado de Estados.dat
 * @author Ian Alexander Valerio Steller
 * Carne: 2025085826
 */
public class EstadoInput {
    FileInputStream archivo;
    ObjectInputStream entrada;
    
    public void abrir() throws IOException{
        archivo = new FileInputStream("Data/Estados.dat");
        entrada = new ObjectInputStream(archivo);
    }
    
    public void cerrar() throws IOException{
        if(entrada != null){
            entrada.close();
        }
    }
    
    public Estado leer() throws IOException, ClassNotFoundException{
        Estado estado = null;
        
        if(entrada != null){
            try{
                estado = (Estado)entrada.readObject();
                
            } catch(EOFException e){
                return null;
            }
        }
        return estado;
    }
}
