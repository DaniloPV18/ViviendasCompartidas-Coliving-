/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author N1L0XD
 */
public class ServiciosDisponibles {
    private int id;
    private String servicio;
    private String estado;
    private Date fechaReg;

    public ServiciosDisponibles() {
        this.fechaReg = new Date();
    }

    public ServiciosDisponibles(String servicio, String estado) {
        this.servicio = servicio;
        this.estado = estado;
        this.fechaReg = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    @Override
    public String toString() {
        return "ServiciosDisponibles{" + "servicio=" + servicio + ", estado=" + estado + ", fechaReg=" + fechaReg + '}';
    }
    
    
    
}
