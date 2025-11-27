/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import Conceptos.Solicitud;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Clase para abrir, cerrar y leer objetos Solicitud de Solicitud.dat
 * @author Ian Alexander Valerio Steller
 * Carne: 2025085826
 */
public class SolicitudInput {
    FileInputStream archivo;
    ObjectInputStream entrada;
    
    public void abrir() throws IOException{
        archivo = new FileInputStream("Data/Solicitudes.dat");
        entrada = new ObjectInputStream(archivo);
    }
    
    public void cerrar() throws IOException{
        if(entrada != null){
            entrada.close();
        }
    }
    
    public Solicitud leer() throws IOException, ClassNotFoundException{
        Solicitud solicitud = null;
        
        if(entrada != null){
            try{
                solicitud = (Solicitud)entrada.readObject();
                
            } catch(EOFException e){
                return null;
            }
        }
        return solicitud;
    }
}
