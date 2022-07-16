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
    private int identificador;
    private int numMax;
    private int numBanios;
    private double precio;
    private Date fechaReg;
    private String estado;
    private TipoHabitacion tipoHab;
    private Propiedad propiedad;
    private EstadoHabitacion estadoHab;
    private Promocion promocion;

    public Habitacion() {
    }

    public Habitacion(int identificador, int numMax, int numBanios, double precio, String estado, TipoHabitacion tipoHab, Propiedad propiedad, EstadoHabitacion estadoHab, Promocion promocion) {
        this.identificador = identificador;
        this.numMax = numMax;
        this.numBanios = numBanios;
        this.precio = precio;
        this.estado = estado;
        this.tipoHab = tipoHab;
        this.propiedad = propiedad;
        this.estadoHab = estadoHab;
        this.promocion = promocion;
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

    public int getNumBanios() {
        return numBanios;
    }

    public void setNumBanios(int numBanios) {
        this.numBanios = numBanios;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public TipoHabitacion getTipoHab() {
        return tipoHab;
    }

    public void setTipoHab(TipoHabitacion tipoHab) {
        this.tipoHab = tipoHab;
    }

    public Propiedad getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }

    public EstadoHabitacion getEstadoHab() {
        return estadoHab;
    }

    public void setEstadoHab(EstadoHabitacion estadoHab) {
        this.estadoHab = estadoHab;
    }

    public Promocion getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "identificador=" + identificador + ", numMax=" + numMax + ", numBanios=" + numBanios + ", precio=" + precio + ", fechaReg=" + fechaReg + ", estado=" + estado + ", tipoHab=" + tipoHab + ", propiedad=" + propiedad + ", estadoHab=" + estadoHab + ", promocion=" + promocion + '}';
    }
    
    
}
