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
public class TipoPago {
    private int id;
    private int identificador;
    private String tipoPago;
    private String estado;
    private Date fechaReg;

    public TipoPago() {
        this.fechaReg = new Date();
    }

    public TipoPago(int identificador, String tipoPago, String estado) {
        this.identificador = identificador;
        this.tipoPago = tipoPago;
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

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
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
        return "TipoPago{" + "identificador=" + identificador + ", tipoPago=" + tipoPago + ", estado=" + estado + ", fechaReg=" + fechaReg + '}';
    }
    
    
}
