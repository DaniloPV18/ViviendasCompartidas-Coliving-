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
public class Huesped{
    private int id;
    private int identificador;
    private String estado;
    private Date fechaReg;

    public Huesped(int identificador, String estado) {
        this.identificador = identificador;
        this.estado = estado;
        this.fechaReg = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
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
        return "Huesped{" + "id=" + id + ", identificador=" + identificador + ", estado=" + estado + ", fechaReg=" + fechaReg + '}';
    }
    
}
