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
public class HabitacionEstado {

    private int id;
    private String estado;
    private Date fechaReg;

    public HabitacionEstado() {
        this.fechaReg = new Date();
    }

    public HabitacionEstado(String estado) {
        this.estado = estado;
        this.fechaReg = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    @Override
    public String toString() {
        return "HabitacionEstado{" + "estadoHabitacion="  + estado + ", fechaReg=" + fechaReg + '}';
    }

}
