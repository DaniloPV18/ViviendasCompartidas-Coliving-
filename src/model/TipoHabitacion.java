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
public class TipoHabitacion {
    private int id;
    private String identificador;
    private String tipoHabitacion;
    private String estado;
    private Date fechaReg;

    public TipoHabitacion() {
        this.fechaReg = new Date();
    }

    public TipoHabitacion(String identificador, String tipoHabitacion, String estado) {
        this.identificador = identificador;
        this.tipoHabitacion = tipoHabitacion;
        this.estado = estado;
        this.fechaReg = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
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
        return "TipoHabitacion{" + "identificador=" + identificador + ", tipoHabitacion=" + tipoHabitacion + ", estado=" + estado + ", fechaReg=" + fechaReg + '}';
    }

    
    
}
