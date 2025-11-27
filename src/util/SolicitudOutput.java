/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import Conceptos.Solicitud;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Clase para abrir, cerrar y escribir objetos Solicitud de Solicitudes.dat
 * @author Ian Alexander Valerio Steller
 * Carne: 2025085826
 */
public class SolicitudOutput {
    FileOutputStream archivo;
    ObjectOutputStream salida;
    
    public void abrir() throws IOException{
        archivo = new FileOutputStream("Data/Solicitudes.dat");
        salida = new ObjectOutputStream(archivo);
    }
    
    public void cerrar() throws IOException{
        if(salida != null){
            salida.close();
        }
    }
    
    public void escribir(Solicitud solicitud) throws IOException{
        if(salida != null){
            salida.writeObject(solicitud);
        }
    }
}
