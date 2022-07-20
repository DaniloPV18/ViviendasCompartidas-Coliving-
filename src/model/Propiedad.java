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
public class Propiedad {

    private int id;
    private String identificador;
    private String nombre;
    private String email;
    private String direccion;
    private int numHab;
    private Date fechaReg;/*Colocar BD*/
    private int anfitrion;
    private int tipoPropiedad;
    private int estadoPropiedad;
    private int ciudad;

    public Propiedad() {
        this.fechaReg = new Date();
    }

    public Propiedad(String identificador, String nombre, String email, String direccion, int numHab, int anfitrion, int tipoPropiedad, int estadoPropiedad, int ciudad) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.numHab = numHab;
        this.anfitrion = anfitrion;
        this.tipoPropiedad = tipoPropiedad;
        this.estadoPropiedad = estadoPropiedad;
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

    public int getTipoPropiedad() {
        return tipoPropiedad;
    }

    public void setTipoPropiedad(int tipoPropiedad) {
        this.tipoPropiedad = tipoPropiedad;
    }

    public int getEstadoPropiedad() {
        return estadoPropiedad;
    }

    public void setEstadoPropiedad(int estadoPropiedad) {
        this.estadoPropiedad = estadoPropiedad;
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
        return "Propiedad{" + "identificador=" + identificador + ", nombre=" + nombre + ", email=" + email + ", direccion=" + direccion + ", numHab=" + numHab + ", fechaReg=" + fechaReg + ", anfitrion=" + anfitrion + ", tipoPropiedad=" + tipoPropiedad + ", estadoPropidad=" + estadoPropiedad + ", ciudad=" + ciudad + '}';
    }

}
