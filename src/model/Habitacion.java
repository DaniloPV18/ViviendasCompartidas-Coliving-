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
public class Habitacion {

    private int id;
    private int identificador;
    private int numMax;
    private boolean banio;
    private double precio;
    private Date fechaReg;
    private int tipoHab;
    private int propiedad;
    private int estadoHab;
    private int promocion;

    public Habitacion() {
        this.fechaReg = new Date();
    }

    public Habitacion(int identificador, int numMax, boolean banio, double precio, int tipoHab, int propiedad, int estadoHab, int promocion) {
        this.identificador = identificador;
        this.numMax = numMax;
        this.banio = banio;
        this.precio = precio;
        this.tipoHab = tipoHab;
        this.propiedad = propiedad;
        this.estadoHab = estadoHab;
        this.promocion = promocion;
        this.fechaReg = new Date();
    }
    
    public Habitacion(int identificador, int numMax, boolean banio, double precio, int tipoHab, int propiedad, int estadoHab) {
        this.identificador = identificador;
        this.numMax = numMax;
        this.banio = banio;
        this.precio = precio;
        this.tipoHab = tipoHab;
        this.propiedad = propiedad;
        this.estadoHab = estadoHab;
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

    public int getNumMax() {
        return numMax;
    }

    public void setNumMax(int numMax) {
        this.numMax = numMax;
    }

    public boolean getBanios() {
        return banio;
    }

    public void setBanios(boolean banio) {
        this.banio = banio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getTipoHab() {
        return tipoHab;
    }

    public void setTipoHab(int tipoHab) {
        this.tipoHab = tipoHab;
    }

    public int getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(int propiedad) {
        this.propiedad = propiedad;
    }

    public int getEstadoHab() {
        return estadoHab;
    }

    public void setEstadoHab(int estadoHab) {
        this.estadoHab = estadoHab;
    }

    public int getPromocion() {
        return promocion;
    }

    public void setPromocion(int promocion) {
        this.promocion = promocion;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "identificador=" + identificador + ", numMax=" + numMax + ", tieneBanios=" + banio + ", precio=" + precio + ", fechaReg=" + fechaReg + ", tipoHab=" + tipoHab + ", propiedad=" + propiedad + ", estadoHab=" + estadoHab + ", promocion=" + promocion + '}';
    }

}
