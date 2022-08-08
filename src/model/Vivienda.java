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
public class Vivienda {

    private int id;
    private String identificador;
    private String nombre;
    private String email;
    private String direccion;
    private int numHab;
    private Date fechaReg;/*Colocar BD*/
    private int anfitrion;
    private int tipoVivienda;
    private int estadoVivienda;
    private int ciudad;

    public Vivienda() {
        this.fechaReg = new Date();
    }

    public Vivienda(String identificador, String nombre, String email, String direccion, int numHab, int anfitrion, int tipoVivienda, int estadoVivienda, int ciudad) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.numHab = numHab;
        this.anfitrion = anfitrion;
        this.tipoVivienda = tipoVivienda;
        this.estadoVivienda = estadoVivienda;
        this.ciudad = ciudad;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumHab() {
        return numHab;
    }

    public void setNumHab(int numHab) {
        this.numHab = numHab;
    }

    public int getAnfitrion() {
        return anfitrion;
    }

    public void setAnfitrion(int anfitrion) {
        this.anfitrion = anfitrion;
    }

    public int getTipoVivienda() {
        return tipoVivienda;
    }

    public void setTipoVivienda(int tipoVivienda) {
        this.tipoVivienda = tipoVivienda;
    }

    public int getEstadoVivienda() {
        return estadoVivienda;
    }

    public void setEstadoVivienda(int estadoVivienda) {
        this.estadoVivienda = estadoVivienda;
    }

    public int getCiudad() {
        return ciudad;
    }

    public void setCiudad(int ciudad) {
        this.ciudad = ciudad;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }

    @Override
    public String toString() {
        return "Propiedad{" + "identificador=" + identificador + ", nombre=" + nombre + ", email=" + email + ", direccion=" + direccion + ", numHab=" + numHab + ", fechaReg=" + fechaReg + ", anfitrion=" + anfitrion + ", tipoVivienda=" + tipoVivienda + ", estadoPropidad=" + estadoVivienda + ", ciudad=" + ciudad + '}';
    }

}
