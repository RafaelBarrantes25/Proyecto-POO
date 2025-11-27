/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import Conceptos.Estado;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Clase para abrir, cerrar y escribir objetos Estado de Estados.dat
 * @author Ian Alexander Valerio Steller
 * Carne: 2025085826
 */
public class EstadoOutput {
    FileOutputStream archivo;
    ObjectOutputStream salida;
    
    public void abrir() throws IOException{
        archivo = new FileOutputStream("Data/Estados.dat");
        salida = new ObjectOutputStream(archivo);
    }
    
    public void cerrar() throws IOException{
        if(salida != null){
            salida.close();
        }
    }
    
    public void escribir(Estado estado) throws IOException{
        if(salida != null){
            salida.writeObject(estado);
        }
    }
}
