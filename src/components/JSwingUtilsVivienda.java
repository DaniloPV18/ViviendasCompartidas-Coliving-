package components;

import java.util.ArrayList;
import javax.swing.JComboBox;
import model.*;
import utilities.Servicios;

/**
 *
 * @author N1L0XD
 */
//Clase para cargar los combobox desde la BD.
public class JSwingUtilsVivienda {

    private static JSwingUtilsVivienda myInstance;
    private static ArrayList<Anfitrion> listaAnfitrionBD = null;
    private static ArrayList<Ciudad> listaCiudadBD = null;
    private static ArrayList<ViviendaTipo> listaViviendaTipoBD = null;

    private JSwingUtilsVivienda() {
        listaAnfitrionBD = new ArrayList<>();
        listaCiudadBD = new ArrayList<>();
        listaViviendaTipoBD = new ArrayList<>();
    }

    public static JSwingUtilsVivienda getInstance() {
        if (myInstance == null) {
            myInstance = new JSwingUtilsVivienda();
        }
        return myInstance;
    }

    public ArrayList<Anfitrion> getListaAnfitrionBD() {
        return listaAnfitrionBD;
    }

    public void setListaAnfitrionBD(ArrayList<Anfitrion> listaAnfitrionBD) {
        JSwingUtilsVivienda.listaAnfitrionBD = listaAnfitrionBD;
    }    

    public ArrayList<Ciudad> getListaCiudadBD() {
        return listaCiudadBD;
    }

    public void setListaCiudadBD(ArrayList<Ciudad> listaCiudadBD) {
        JSwingUtilsVivienda.listaCiudadBD = listaCiudadBD;
    }

    public ArrayList<ViviendaTipo> getListaViviendaTipoBD() {
        return listaViviendaTipoBD;
    }

    public void setListaViviendaTipoBD(ArrayList<ViviendaTipo> listaViviendaTipoBD) {
        JSwingUtilsVivienda.listaViviendaTipoBD = listaViviendaTipoBD;
    }
    
    public static void cargarCombos(JComboBox<String> cmbCedulaAnfitrion, JComboBox<String> cmbCiudad, JComboBox<String> cmbViviendaTipo) {        
        cargarComboAnfitrion(cmbCedulaAnfitrion);
        cargarComboCiudad(cmbCiudad);
        cargarComboViviendaTipo(cmbViviendaTipo);
    }
    
    //Cargar elementos del combo con la tabla de la Base de datos
    public static void cargarComboAnfitrion(JComboBox<String> cmbCedulaAnfitrion) {   
        //Obtener los registros de la tabla de la base de datos
        getInstance().setListaAnfitrionBD(Servicios.consultarTAnfitrion());
        //Setear elementos del combo con la tabla de la Base de datos
        for (Anfitrion elemento : getInstance().getListaAnfitrionBD()) {
            cmbCedulaAnfitrion.addItem(elemento.getIdentificador());
        }
    }
    
    public static void cargarComboCiudad(JComboBox<String> cmbCiudad) {
        getInstance().setListaCiudadBD(Servicios.consultarTCiudad());
        for (Ciudad elemento : getInstance().getListaCiudadBD()) {
            cmbCiudad.addItem(elemento.getNombre());
        }
    }

    public static void cargarComboViviendaTipo(JComboBox<String> cmbViviendaTipo) {
        getInstance().setListaViviendaTipoBD(Servicios.consultarTViviendaTipo());
        for (ViviendaTipo elemento : getInstance().getListaViviendaTipoBD()) {
            cmbViviendaTipo.addItem(elemento.getEstado());
        }
    }

}
