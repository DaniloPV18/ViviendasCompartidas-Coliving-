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
public class Promocion {
    private int id;
    private Date fechaInicio;
    private Date fechaFinal;
    private int descuento;
    private String estado;
    private Date fechaReg;

    public Promocion() {
        this.fechaReg = new Date();
    }

    public Promocion(Date fechaInicio, Date fechaFinal, int descuento, String estado) {
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.descuento = descuento;
        this.estado = estado;
        this.fechaReg = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
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
        return "Promocion{" + "fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + ", descuento=" + descuento + ", estado=" + estado + ", fechaReg=" + fechaReg + '}';
    }
    
    
}
