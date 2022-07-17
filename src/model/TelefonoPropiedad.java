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
public class TelefonoPropiedad {
    private int id;
    private String numTelefono;    
    private String estado;
    private Date fechaReg;
    private Propiedad propiedad;

    public TelefonoPropiedad() {
        this.fechaReg = new Date();
    }

    public TelefonoPropiedad(String numTelefono, String estado, Propiedad propiedad) {
        this.numTelefono = numTelefono;
        this.estado = estado;
        this.propiedad = propiedad;
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

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    @Override
    public String toString() {
        return "TelefonoPropiedad{" + "numTelefono=" + numTelefono + ", estado=" + estado + ", fechaReg=" + fechaReg + ", propiedad=" + propiedad + '}';
    }    
    
}
