/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import Conceptos.Cliente;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Clase para abrir, cerrar y leer objetos Cliente de Clientes.dat
 * @author Ian Alexander Valerio Steller
 * Carne: 2025085826
 */
public class ClienteInput {
    FileInputStream archivo;
    ObjectInputStream entrada;
    
    public void abrir() throws IOException{
        archivo = new FileInputStream("Data/Clientes.dat");
        entrada = new ObjectInputStream(archivo);
    }
    
    public void cerrar() throws IOException{
        if(entrada != null){
            entrada.close();
        }
    }
    
    public Cliente leer() throws IOException, ClassNotFoundException{
        Cliente cliente = null;
        
        if(entrada != null){
            try{
                cliente = (Cliente)entrada.readObject();
                
            } catch(EOFException e){
                return null;
            }
        }
        return cliente;
    }
}
