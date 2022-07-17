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
public class Region {
    private String nombre;
    private String estado;
    private Date fechaReg;
    private Pais Pais;

    public Region() {
        this.fechaReg = new Date();
    }

    public Region(String nombre, String estado, Pais Pais) {
        this.nombre = nombre;
        this.estado = estado;
        this.Pais = Pais;
        this.fechaReg = new Date();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Pais getPais() {
        return Pais;
    }

    public void setPais(Pais Pais) {
        this.Pais = Pais;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    @Override
    public String toString() {
        return "Region{" + "nombre=" + nombre + ", estado=" + estado + ", fechaReg=" + fechaReg + ", Pais=" + Pais + '}';
    }
    
    
}
