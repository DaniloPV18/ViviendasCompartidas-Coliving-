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
public class Persona {
    private int id;
    private String identificador;
    private String nombres;
    private String apellidos;
    private Date fechaNac;
    private String email;
    private String estado;
    private Date fechaReg;
    private int tipoId;
    private int sexo;
    private int nacionalidad;

    public Persona() {
        this.fechaReg = new Date();
    }
    
    public Persona(String identificador, String nombres, String apellidos, Date fechaNac, String email, String estado, int tipoId, int sexo, int nacionalidad) {
        this.identificador = identificador;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNac = fechaNac;
        this.email = email;
        this.estado = estado;
        this.tipoId = tipoId;
        this.sexo = sexo;
        this.nacionalidad = nacionalidad;
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

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getTipoId() {
        return tipoId;
    }

    public void setTipoId(int tipoId) {
        this.tipoId = tipoId;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public int getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(int nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public Date getFechaReg() {
        return fechaReg;
    }

    public void setFechaReg(Date fechaReg) {
        this.fechaReg = fechaReg;
    }
    
    @Override
    public String toString() {
        return "Persona{" + "identificador=" + identificador + ", nombres=" + nombres + ", apellidos=" + apellidos + ", fechaNac=" + fechaNac + ", email=" + email + ", estado=" + estado + ", fechaReg=" + fechaReg + ", tipoId=" + tipoId + ", sexo=" + sexo + ", nacionalidad=" + nacionalidad + '}';
    }
    
    
    
}
