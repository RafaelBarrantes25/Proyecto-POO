/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conceptos;

import java.io.Serializable;

/**
 * Clase Servicio con atributos y métodos
 * @author Jose Rafael Barrantes Quesada
 * Carné: 2025122443
 * @author Ian Alexander Valerio Steller
 * Carné: 2025085826
 */
public class Servicio implements Serializable{
        String identificacion;
        String nombre;
        String precio;

    public Servicio(String identificacion, String nombre, String precio) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.precio = precio;
    }
    
    public Servicio(){
        
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
        return "Identificacion: "+this.getIdentificacion()+"Servicio: "+this.getNombre()+"Precio: "+this.getPrecio();
    }
        
}
