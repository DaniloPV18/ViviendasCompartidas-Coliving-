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
public class PagoTipo {

    private int id;
    private int identificador;
    private String nombre;
    private String estado;
    private Date fechaReg;

    public PagoTipo() {
        this.fechaReg = new Date();
    }

    public PagoTipo(int identificador, String nombre, String estado) {
        this.identificador = identificador;
        this.nombre = nombre;
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

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    @Override
    public String toString() {
        return "PagoTipo{" + "identificador=" + identificador + ", nombre=" + nombre + ", estado=" + estado + ", fechaReg=" + fechaReg + '}';
    }

}
