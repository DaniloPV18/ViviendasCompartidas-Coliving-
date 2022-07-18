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
public class MetodoPago {

    private int id;
    private String identificador;
    private String metodo;
    private String estado;
    private Date fechaReg;

    public MetodoPago() {
        this.fechaReg = new Date();
    }

    public MetodoPago(String identificador, String metodo, String estado) {
        this.identificador = identificador;
        this.metodo = metodo;
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

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
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
        return "MetodoPago{" + "identificador=" + identificador + ", metodo=" + metodo + ", estado=" + estado + ", fechaReg=" + fechaReg + '}';
    }

}
