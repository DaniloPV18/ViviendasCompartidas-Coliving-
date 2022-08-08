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
public class Pago {

    private int id;
    private String identificador;
    private double monto;
    private Date fechaReg;
    private Date fechaInicio;
    private Date fechaFinal;
    private String estado;
    private int metodoPago;
    private int huesped;
    private int tipoPago;
    private int habitacion;
    private int propiedad;

    public Pago() {
        this.fechaReg = new Date();
    }

    public Pago(String identificador, double monto, String estado, int metodoPago, int huesped, int tipoPago, int habitacion, int propiedad) {
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

    public Pago(String identificador, double monto, Date fechaInicio, Date fechaFinal, String estado, int metodoPago, int huesped, int tipoPago, int habitacion, int propiedad) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(int metodoPago) {
        this.metodoPago = metodoPago;
    }

    public int getHuesped() {
        return huesped;
    }

    public void setHuesped(int huesped) {
        this.huesped = huesped;
    }

    public int getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(int tipoPago) {
        this.tipoPago = tipoPago;
    }

    public int getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(int habitacion) {
        this.habitacion = habitacion;
    }

    public int getPropiedad() {
        return propiedad;
    }

    public void setPropiedad(int propiedad) {
        this.propiedad = propiedad;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    @Override
    public String toString() {
        return "Pago{" + "identificador=" + identificador + ", monto=" + monto + ", fechaReg=" + fechaReg + ", fechaInicio=" + fechaInicio + ", fechaFinal=" + fechaFinal + ", estado=" + estado + ", metodoPago=" + metodoPago + ", huesped=" + huesped + ", tipoPago=" + tipoPago + ", habitacion=" + habitacion + ", propiedad=" + propiedad + '}';
    }

}
