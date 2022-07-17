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
public class Ciudad {
    private int id;
    private int identificador;
    private String nombre;
    private String estado;
    private Date fechaReg;
    private Region region;

    public Ciudad() {
        this.fechaReg = new Date();
    }
    
    public Ciudad(int identificador, String nombre, String estado, Region region) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.estado = estado;
        this.region = region;
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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    @Override
    public String toString() {
        return "Ciudad{" + "identificador=" + identificador + ", nombre=" + nombre + ", estado=" + estado + ", fechaReg=" + fechaReg + ", region=" + region + '}';
    }
    
    
    
}
