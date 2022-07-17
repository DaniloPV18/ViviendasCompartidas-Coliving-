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
public class TelefonoPersona {
    private int id;
    private String numTelefono;
    private int persona;
    private String estado;
    private Date fechaReg;

    public TelefonoPersona() {
        this.fechaReg = new Date();
    }

    public TelefonoPersona(String numTelefono, int persona, String estado) {
        this.numTelefono = numTelefono;
        this.persona = persona;
        this.estado = estado;
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

    public int getPersona() {
        return persona;
    }

    public void setPersona(int persona) {
        this.persona = persona;
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
        return "TelefonoPersona{" + "numTelefono=" + numTelefono + ", persona=" + persona + ", estado=" + estado + ", fechaReg=" + fechaReg + '}';
    }    
    
}
