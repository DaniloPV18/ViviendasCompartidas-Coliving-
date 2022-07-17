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
public class TipoIdentificacion {
    private int id;
    private String identificador;
    private String sexo;
    private String estado;
    private Date fechaReg;

    public TipoIdentificacion() {
        this.fechaReg = new Date();
    }

    public TipoIdentificacion(String identificador, String sexo, String estado) {
        this.identificador = identificador;
        this.sexo = sexo;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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
        return "TipoIdentificacion{" + "identificador=" + identificador + ", sexo=" + sexo + ", estado=" + estado + ", fechaReg=" + fechaReg + '}';
    }
    
    
}
