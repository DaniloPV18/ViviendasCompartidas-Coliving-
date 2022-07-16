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
public class EstadoHabitacion {
    private String identificador;
    private String estadoHabitacion;
    private String estado;
    private Date fechaReg;

    public EstadoHabitacion() {
        this.fechaReg = new Date();
    }

    public EstadoHabitacion(String identificador, String estadoHabitacion, String estado) {
        this.identificador = identificador;
        this.estadoHabitacion = estadoHabitacion;
        this.estado = estado;
        this.fechaReg = new Date();
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getEstadoHabitacion() {
        return estadoHabitacion;
    }

    public void setEstadoHabitacion(String estadoHabitacion) {
        this.estadoHabitacion = estadoHabitacion;
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
        return "EstadoHabitacion{" + "identificador=" + identificador + ", estadoHabitacion=" + estadoHabitacion + ", estado=" + estado + ", fechaReg=" + fechaReg + '}';
    }

    
}
