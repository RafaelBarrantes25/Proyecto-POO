/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import Conceptos.Mecanico;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Clase para abrir, cerrar y leer objetos Mecanico de Mecanicos.dat
 * @author Ian Alexander Valerio Steller
 * Carne: 2025085826
 */
public class MecanicoInput {
    FileInputStream archivo;
    ObjectInputStream entrada;
    
    public void abrir() throws IOException{
        archivo = new FileInputStream("Data/Mecanicos.dat");
        entrada = new ObjectInputStream(archivo);
    }
    
    public void cerrar() throws IOException{
        if(entrada != null){
            entrada.close();
        }
    }
    
    public Mecanico leer() throws IOException, ClassNotFoundException{
        Mecanico mecanico = null;
        
        if(entrada != null){
            try{
                mecanico = (Mecanico)entrada.readObject();
                
            } catch(EOFException e){
                return null;
            }
        }
        return mecanico;
    }
}
