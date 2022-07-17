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
public class Reservas {
    private String identificador;
    private Date fechaInicial;
    private Date fechaFinal;
    private Date fechaReg;
    private String estado;
    private Pagos pago;
    private Huesped huesped;

    public Reservas() {
        this.fechaReg = new Date();
    }

    public Reservas(String identificador, Date fechaInicial, Date fechaFinal, String estado, Pagos pago, Huesped huesped) {
        this.identificador = identificador;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.estado = estado;
        this.pago = pago;
        this.huesped = huesped;
        this.fechaReg = new Date();
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
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

    public Pagos getPago() {
        return pago;
    }

    public void setPago(Pagos pago) {
        this.pago = pago;
    }

    public Huesped getHuesped() {
        return huesped;
    }

    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    @Override
    public String toString() {
        return "Reservas{" + "identificador=" + identificador + ", fechaInicial=" + fechaInicial + ", fechaFinal=" + fechaFinal + ", fechaReg=" + fechaReg + ", estado=" + estado + ", pago=" + pago + ", huesped=" + huesped + '}';
    }
    
    
}
