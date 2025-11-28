/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conceptos;

import java.io.Serializable;

/**
 * Clase Estado con atributos y métodos
 * @author Ian Alexander Valerio Steller
 * Carné: 2025085826
 */
public class Estado implements Serializable{
    String identificacion;
    String nombre;

    public Estado(String identificacion, String nombre) {
        this.identificacion = identificacion;
        this.nombre = nombre;
    }
    
    public Estado(){}

    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Estado{" + "identificacion=" + identificacion + ", nombre=" + nombre + '}';
    }
}
