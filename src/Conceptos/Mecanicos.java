/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conceptos;

import java.util.ArrayList;

/**
 * Clase Mecánicos con atributos y métodos
 * @author Rafael
 * Carné: 
 * @author Ian Alexander Valerio Steller
 * Carné: 2025085826
*/ 
public class Mecanicos {
        String identificacion;
        String nombre;
        String puesto;
        ArrayList<Servicios> servicios;

    public Mecanicos(String identificacion, String nombre, String puesto) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.puesto = puesto;
        this.servicios = new ArrayList<Servicios>();
    }
    
    public Mecanicos(){
        this.servicios = new ArrayList<Servicios>();
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

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    @Override
    public String toString(){
        return "Identificacion: "+this.getIdentificacion()+"Nombre: "+this.getNombre()+"Puesto: "+this.getPuesto();
    }
        
}
