/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conceptos;

/**
 *
 * @author Rafael
 */
public class Servicios {
        String identificacion;
        String nombre;
        String precio;

    public Servicios(String nombre, String placa, String telefono) {
        this.identificacion = nombre;
        this.nombre = placa;
        this.precio = telefono;
    }
    
    public Servicios(){
        
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    
    @Override
    public String toString(){
        return "Cliente: "+this.getIdentificacion()+"Tel: "+this.getPrecio()+"Placa: "+this.getNombre();
    }
        
}
