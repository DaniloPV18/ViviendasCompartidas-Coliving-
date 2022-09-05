/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author NILOXD
 */
public class PromocionHabitacion {
    private String nombreVivienda;
    private int codigoHabitacion;
    private double precio;
    private double precioTotal;

    public PromocionHabitacion(String nombreVivienda, int codigoHabitacion, double precio, double precioTotal) {
        this.nombreVivienda = nombreVivienda;
        this.codigoHabitacion = codigoHabitacion;
        this.precio = precio;
        this.precioTotal = precioTotal;
    }

    public String getNombreVivienda() {
        return nombreVivienda;
    }

    public void setNombreVivienda(String nombreVivienda) {
        this.nombreVivienda = nombreVivienda;
    }

    public int getCodigoHabitacion() {
        return codigoHabitacion;
    }

    public void setCodigoHabitacion(int codigoHabitacion) {
        this.codigoHabitacion = codigoHabitacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        this.precioTotal = precioTotal;
    }

    @Override
    public String toString() {
        return "PromocionHabitacion{" + "nombreVivienda=" + nombreVivienda + ", codigoHabitacion=" + codigoHabitacion + ", precio=" + precio + ", precioTotal=" + precioTotal + '}';
    }
    
    
}
