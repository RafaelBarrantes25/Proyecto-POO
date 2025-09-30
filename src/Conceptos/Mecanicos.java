/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conceptos;

/**
 *
 * @author Rafael
*/ 
public class Mecanicos {
        String identificacion;
        String nombre;
        String puesto;

    public Mecanicos(String nombre, String placa, String telefono) {
        this.identificacion = nombre;
        this.nombre = placa;
        this.puesto = telefono;
    }
    
    public Mecanicos(){
        
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
        return "Cliente: "+this.getIdentificacion()+"Tel: "+this.getPuesto()+"Placa: "+this.getNombre();
    }
        
}
