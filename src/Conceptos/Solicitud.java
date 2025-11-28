/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conceptos;

import java.util.Vector;

/**
 * Clase Solicitud con atributos y métodos
 * @author Ian Alexander Valerio Steller
 * Carné: 2025085826
 */
public class Solicitud {
    String identificacion;
    String placa;
    String servicio;
    String cliente;
    String observaciones;
    String mecanico;
    String estado;
    Vector<String> otrosServicios;

    public Solicitud(String identificacion, String placa, String servicio, String cliente, String observaciones, String mecanico, String estado, Vector<String> otrosServicios) {
        this.identificacion = identificacion;
        this.placa = placa;
        this.servicio = servicio;
        this.cliente = cliente;
        this.observaciones = observaciones;
        this.mecanico = mecanico;
        this.estado = estado;
        this.otrosServicios = otrosServicios;
    }
    
    public Solicitud(){}
    
    public void solicitar(){
    }
    
    public void atender(){
    }
    
    public void consultar(){
    }
}
