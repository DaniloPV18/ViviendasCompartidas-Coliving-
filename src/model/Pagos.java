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
public class Pagos {
    private String identificador;
    private double monto;
    private Date fechaReg;
    private Date fechaInicio;
    private Date fechaFinal;
    private String estado;
    private MetodoPago metodoPago;
    private Huesped huesped;
    private TipoPago tipoPago;
    private Habitacion habitacion;
    private Propiedad propiedad;

    public Pagos() {
        this.fechaReg = new Date();
    }

    public Pagos(String identificador, double monto, String estado, MetodoPago metodoPago, Huesped huesped, TipoPago tipoPago, Habitacion habitacion, Propiedad propiedad) {
        this.identificador = identificador;
        this.monto = monto;
        this.estado = estado;
        this.metodoPago = metodoPago;
        this.huesped = huesped;
        this.tipoPago = tipoPago;
        this.habitacion = habitacion;
        this.propiedad = propiedad;
        this.fechaReg = new Date();
    }

    public Pagos(String identificador, double monto, Date fechaInicio, Date fechaFinal, String estado, MetodoPago metodoPago, Huesped huesped, TipoPago tipoPago, Habitacion habitacion, Propiedad propiedad) {
        this.identificador = identificador;
        this.monto = monto;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.estado = estado;
        this.metodoPago = metodoPago;
        this.huesped = huesped;
        this.tipoPago = tipoPago;
        this.habitacion = habitacion;
        this.propiedad = propiedad;
        this.fechaReg = new Date();
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
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
        return "Pagos{" + "identificador=" + identificador + ", monto=" + monto + ", fechaReg=" + fechaReg + ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + ", estado=" + estado + ", metodoPago=" + metodoPago + ", huesped=" + huesped + ", tipoPago=" + tipoPago + ", habitacion=" + habitacion + ", propiedad=" + propiedad + '}';
    }
    
    
}
