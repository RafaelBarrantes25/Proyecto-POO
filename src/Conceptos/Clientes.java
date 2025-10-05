/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conceptos;

/**
 * Clase Clientes con atributos y métodos
 * @author Jose Rafael Barrantes Quesada
 * Carné: 2025122443
 * @author Ian Alexander Valerio Steller
 * Carné: 2025085826
 */
public class Clientes {
        String id;
        String nombre;
        String placa;
        String telefono;
        String email;

    public Clientes(String id, String nombre, String placa, String telefono, String email) {
        this.id = id;
        this.nombre = nombre;
        this.placa = placa;
        this.telefono = telefono;
        this.email = email;
    }
    
    public Clientes(){
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString(){
        return("Cliente: "+this.getNombre()+"ID: "+this.getId()+"Telefono: "+
               this.getTelefono()+"Placa: "+this.getPlaca()+"Email: "+this.getEmail());
    }
        
}
