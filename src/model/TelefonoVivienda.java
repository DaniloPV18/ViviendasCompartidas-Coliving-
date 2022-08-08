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
public class TelefonoVivienda {

    private int id;
    private String numTelefono;
    private String estado;
    private Date fechaReg;
    private Vivienda vivienda;

    public TelefonoVivienda() {
        this.fechaReg = new Date();
    }

    public TelefonoVivienda(String numTelefono, String estado, Vivienda vivienda) {
        this.numTelefono = numTelefono;
        this.estado = estado;
        this.vivienda = vivienda;
        this.fechaReg = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Vivienda getVivienda() {
        return vivienda;
    }

    public void setVivienda(Vivienda vivienda) {
        this.vivienda = vivienda;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    @Override
    public String toString() {
        return "TelefonoPropiedad{" + "numTelefono=" + numTelefono + ", estado=" + estado + ", fechaReg=" + fechaReg + ", vivienda=" + vivienda + '}';
    }

}
