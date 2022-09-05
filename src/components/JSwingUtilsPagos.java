package components;

import controllerDAO.AdmViviendasDAO;
import java.util.ArrayList;
import javax.swing.JComboBox;
import model.Habitacion;
import model.PagoMetodo;
import model.PagoTipo;
import model.Vivienda;
import utilities.Servicios;

/**
 *
 * @author NILOXD
 */
public class JSwingUtilsPagos {

    private static JSwingUtilsPagos myInstance;
    private static ArrayList<Vivienda> listaViviendaBD = null;
    private static ArrayList<PagoMetodo> listaPagoMetodoBD = null;
    private static ArrayList<PagoTipo> listaPagoTipoBD = null;

    private JSwingUtilsPagos() {
        listaViviendaBD = new ArrayList<>();
        listaPagoMetodoBD = new ArrayList<>();
        listaPagoTipoBD = new ArrayList<>();
    }

    public static JSwingUtilsPagos getInstance() {
        if (myInstance == null) {
            myInstance = new JSwingUtilsPagos();
        }
        return myInstance;
    }

    public ArrayList<Vivienda> getListaViviendaBD() {
        return listaViviendaBD;
    }

    public void setListaViviendaBD(ArrayList<Vivienda> listaViviendaBD) {
        JSwingUtilsPagos.listaViviendaBD = listaViviendaBD;
    }

    public ArrayList<PagoMetodo> getListaPagoMetodoBD() {
        return listaPagoMetodoBD;
    }

    public void setListaPagoMetodoBD(ArrayList<PagoMetodo> listaPagoMetodoBD) {
        JSwingUtilsPagos.listaPagoMetodoBD = listaPagoMetodoBD;
    }

    public ArrayList<PagoTipo> getListaPagoTipoBD() {
        return listaPagoTipoBD;
    }

    public void setListaPagoTipoBD(ArrayList<PagoTipo> listaPagoTipoBD) {
        JSwingUtilsPagos.listaPagoTipoBD = listaPagoTipoBD;
    }

    public static void cargarCombos(JComboBox<String> cmbViviendaNombre, JComboBox<String> cmbMetodoPago, JComboBox<String> cmbTipoPago) {
        cargarComboVivienda(cmbViviendaNombre);
        cargarComboPagoMetodo(cmbMetodoPago);
        cargarComboPagoTipo(cmbTipoPago);
    }

    public static void cargarCombos(String nombreVivienda, JComboBox<String> cmbCodHab) {
        cargarComboCodHab(nombreVivienda,cmbCodHab);
    }

    public static void cargarComboVivienda(JComboBox<String> cmbVivienda) {
        getInstance().setListaViviendaBD(AdmViviendasDAO.consultar());
        for (Vivienda elemento : getInstance().getListaViviendaBD()) {
            cmbVivienda.addItem(elemento.getNombre());
        }
    }
    
    public static void cargarComboCodHab(String nombreVivienda, JComboBox<String> cmbVivienda) {
        cmbVivienda.removeAllItems();
        for (Habitacion elemento : Servicios.consultarHabitaciones(nombreVivienda)) {
            cmbVivienda.addItem(elemento.getIdentificador()+"");
        }
    }

    public static void cargarComboPagoMetodo(JComboBox<String> cmbPagoMetodo) {
        getInstance().setListaPagoMetodoBD(Servicios.consultarTPagoMetodo());
        for (PagoMetodo elemento : getInstance().getListaPagoMetodoBD()) {
            cmbPagoMetodo.addItem(elemento.getNombre());
        }
    }

    public static void cargarComboPagoTipo(JComboBox<String> cmbPagoTipo) {
        getInstance().setListaPagoTipoBD(Servicios.consultarTPagoTipo());
        for (PagoTipo elemento : getInstance().getListaPagoTipoBD()) {
            cmbPagoTipo.addItem(elemento.getNombre());
        }
    }
}
