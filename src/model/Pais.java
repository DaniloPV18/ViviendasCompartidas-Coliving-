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
public class Pais {
    private String identificador;
    private String nombre;
    private Date fechaReg;
    private String estado;   

    public Pais() {
        this.fechaReg = new Date();
    }

    public Pais(String identificador, String nombre, String estado) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.estado = estado;
        this.fechaReg = new Date();
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
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

    public Date getFechaReg() {
        return fechaReg;
    }

    @Override
    public String toString() {
        return "Pais{" + "identificador=" + identificador + ", nombre=" + nombre + ", fechaReg=" + fechaReg + ", estado=" + estado + '}';
    }
    
    
}
