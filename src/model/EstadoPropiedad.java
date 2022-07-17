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
public class EstadoPropiedad {
    private String identificador;
    private String estadoPropiedad;
    private String estado;
    private Date fechaReg;

    public EstadoPropiedad() {
        this.fechaReg = new Date();
    }

    public EstadoPropiedad(String identificador, String estadoPropiedad, String estado) {
        this.identificador = identificador;
        this.estadoPropiedad = estadoPropiedad;
        this.estado = estado;
        this.fechaReg = new Date();
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getEstadoPropiedad() {
        return estadoPropiedad;
    }

    public void setEstadoPropiedad(String estadoPropiedad) {
        this.estadoPropiedad = estadoPropiedad;
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
        return "EstadoPropiedad{" + "identificador=" + identificador + ", estadoPropiedad=" + estadoPropiedad + ", estado=" + estado + ", fechaReg=" + fechaReg + '}';
    }
    
    
}
