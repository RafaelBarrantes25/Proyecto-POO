/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conceptos;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Clase Solicitud con atributos y métodos
 * @author Ian Alexander Valerio Steller
 * Carné: 2025085826
 */
public class Solicitud implements Serializable{
    String identificacion;
    String placa;
    String servicio;
    String cliente;
    String observaciones;
    String mecanico;
    String estado;
    ArrayList<String> otrosServicios;

    public Solicitud(String identificacion, String placa, String servicio, String cliente, String observaciones, String mecanico, String estado, ArrayList<String> otrosServicios) {
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

    public String getIdentificacion() {
        return identificacion;
    }

    public String getPlaca() {
        return placa;
    }

    public String getServicio() {
        return servicio;
    }

    public String getCliente() {
        return cliente;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public String getMecanico() {
        return mecanico;
    }

    public String getEstado() {
        return estado;
    }

    public ArrayList<String> getOtrosServicios() {
        return otrosServicios;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setOtrosServicios(ArrayList<String> otrosServicios) {
        this.otrosServicios = otrosServicios;
    }

    @Override
    public String toString() {
        return "Solicitud{" + "identificacion=" + identificacion + ", placa=" + placa + ", servicio=" + servicio + ", cliente=" + cliente + ", observaciones=" + observaciones + ", mecanico=" + mecanico + ", estado=" + estado + ", otrosServicios=" + otrosServicios + '}';
    }
    
    public void solicitar(){
    }
    
    public void atender(){
    }
    
    public void consultar(){
    }
}
