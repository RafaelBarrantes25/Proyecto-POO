/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conceptos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase Mecánicos con atributos y métodos
 * @author Jose Rafael Barrantes Quesada
 * Carné: 2025122443
 * @author Ian Alexander Valerio Steller
 * Carné: 2025085826
*/ 
public class Mecanico implements Serializable{
        String identificacion;
        String nombre;
        String puesto;
        ArrayList<String> serviciosValidados;

    public Mecanico(String identificacion, String nombre, String puesto, ArrayList servicios) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.puesto = puesto;
        this.serviciosValidados = servicios;
    }
    
    public Mecanico(){
        this.serviciosValidados = new ArrayList<String>();
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

    public ArrayList<String> getServiciosValidados() {
        return serviciosValidados;
    }

    public void setServiciosValidados(ArrayList<String> serviciosValidados) {
        this.serviciosValidados = serviciosValidados;
    }
    
    //Imprime todos los servicios del mecánico
    public void imprimirServicios(){
        System.out.println(this.nombre);
        for(String s : this.serviciosValidados){
            System.out.println(s);
        }
    }
    
    @Override
    public String toString(){
        return "Identificacion: "+this.getIdentificacion()+"Nombre: "+this.getNombre()+"Puesto: "+this.getPuesto();
    }
        
}
