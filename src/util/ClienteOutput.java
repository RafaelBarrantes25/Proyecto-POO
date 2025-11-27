/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import Conceptos.Cliente;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Clase para abrir, cerrar y escribir objetos Cliente de Clientes.dat
 * @author Ian Alexander Valerio Steller
 * Carne: 2025085826
 */
public class ClienteOutput {
    FileOutputStream archivo;
    ObjectOutputStream salida;
    
    public void abrir() throws IOException{
        archivo = new FileOutputStream("Data/Clientes.dat");
        salida = new ObjectOutputStream(archivo);
    }
    
    public void cerrar() throws IOException{
        if(salida != null){
            salida.close();
        }
    }
    
    public void escribir(Cliente cliente) throws IOException{
        if(salida != null){
            salida.writeObject(cliente);
        }
    }
}
