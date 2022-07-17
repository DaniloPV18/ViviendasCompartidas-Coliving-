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
public class TipoPropiedad {
    private String identificador;
    private String tipoPropiedad;
    private String estado;
    private Date fechaReg;

    public TipoPropiedad() {
        this.fechaReg = new Date();
    }

    public TipoPropiedad(String identificador, String tipoPropiedad, String estado) {
        this.identificador = identificador;
        this.tipoPropiedad = tipoPropiedad;
        this.estado = estado;
        this.fechaReg = new Date();
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getTipoPropiedad() {
        return tipoPropiedad;
    }

    public void setTipoPropiedad(String tipoPropiedad) {
        this.tipoPropiedad = tipoPropiedad;
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
        return "TipoPropiedad{" + "identificador=" + identificador + ", tipoPropiedad=" + tipoPropiedad + ", estado=" + estado + ", fechaReg=" + fechaReg + '}';
    }
    
    
}
