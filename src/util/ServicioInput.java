/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import Conceptos.Servicio;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Clase para abrir, cerrar y leer objetos Servicio de Servicios.dat
 * @author Ian Alexander Valerio Steller
 * Carne: 2025085826
 */
public class ServicioInput {
    FileInputStream archivo;
    ObjectInputStream entrada;
    
    public void abrir() throws IOException{
        archivo = new FileInputStream("Data/Servicios.dat");
        entrada = new ObjectInputStream(archivo);
    }
    
    public void cerrar() throws IOException{
        if(entrada != null){
            entrada.close();
        }
    }
    
    public Servicio leer() throws IOException, ClassNotFoundException{
        Servicio servicio = null;
        
        if(entrada != null){
            try{
                servicio = (Servicio)entrada.readObject();
                
            } catch(EOFException e){
                return null;
            }
        }
        return servicio;
    }
}
