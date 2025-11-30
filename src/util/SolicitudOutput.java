/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import Conceptos.Solicitud;
import java.io.File;
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
        
        //Esto para revisar que el archivo exista
        File revisarArchivo = new File("Data/Solicitudes.dat");
        boolean revisarExiste = revisarArchivo.exists();
        
        archivo = new FileOutputStream("Data/Solicitudes.dat",true);
        
        if(revisarExiste == false || revisarArchivo.length() == 0){
            salida = new ObjectOutputStream(archivo);
        } else {
            salida = new AnadirObjectOutputStream(archivo);
        }
     
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


//Hay que hacer otro metodo debido a que como este no carga toda la lista cada
//vez, sobreescribe valores al anadir algo nuevo

//Un comentario en este link explica lo de appending output stream
//Lo que hace es basicamente buscar el header y saltarselo, asi no
//corrompe el archivo
//https://stackoverflow.com/questions/1194656/appending-to-an-objectoutputstream

class AnadirObjectOutputStream extends ObjectOutputStream{
    public AnadirObjectOutputStream(FileOutputStream salida) throws IOException{
        super(salida);
    }
    @Override
    protected void writeStreamHeader() throws IOException{
        reset();
    }
}