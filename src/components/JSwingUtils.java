package components;

import java.util.ArrayList;
import javax.swing.JComboBox;
import model.Nacionalidad;
import model.Sexo;
import model.TipoIdentificacion;
import utilities.Servicios;

/**
 *
 * @author N1L0XD
 */
//Clase para cargar los combobox desde la BD.
public class JSwingUtils {

    private static JSwingUtils myInstance;
    private static ArrayList<Sexo> listaSexoBD = null;
    private static ArrayList<Nacionalidad> listaNacionalidadBD = null;
    private static ArrayList<TipoIdentificacion> listaTipoIdBD = null;

    private JSwingUtils() {
        listaSexoBD = new ArrayList<>();
        listaNacionalidadBD = new ArrayList<>();
        listaTipoIdBD = new ArrayList<>();
    }

    public static JSwingUtils getInstance() {
        if (myInstance == null) {
            myInstance = new JSwingUtils();
        }
        return myInstance;
    }

    public ArrayList<Sexo> getListaSexoBD() {
        return listaSexoBD;
    }

    public void setListaSexoBD(ArrayList<Sexo> listaSexoBD) {
        JSwingUtils.listaSexoBD = listaSexoBD;
    }    

    public ArrayList<Nacionalidad> getListaNacionalidadBD() {
        return listaNacionalidadBD;
    }

    public void setListaNacionalidadBD(ArrayList<Nacionalidad> listaNacionalidadBD) {
        JSwingUtils.listaNacionalidadBD = listaNacionalidadBD;
    }

    public ArrayList<TipoIdentificacion> getListaTipoIdBD() {
        return listaTipoIdBD;
    }

    public void setListaTipoIdBD(ArrayList<TipoIdentificacion> listaTipoIdBD) {
        JSwingUtils.listaTipoIdBD = listaTipoIdBD;
    }
    
    public static void cargarCombos(JComboBox<String> cmbSexo, JComboBox<String> cmbNacionalidad, JComboBox<String> cmbTipoId) {        
        cargarComboSexo(cmbSexo);
        cargarComboNacionalidad(cmbNacionalidad);
        cargarComboTipoId(cmbTipoId);
    }
    
    //Cargar elementos del combo con la tabla de la Base de datos
    public static void cargarComboSexo(JComboBox<String> cmbSexo) {   
        //Obtener los registros de la tabla de la base de datos
        getInstance().setListaSexoBD(Servicios.consultarTSexo());
        //Setear elementos del combo con la tabla de la Base de datos
        for (Sexo elemento : getInstance().getListaSexoBD()) {
            cmbSexo.addItem(elemento.getSexo());
        }
    }
    
    public static void cargarComboNacionalidad(JComboBox<String> cmbNacionalidad) {
        getInstance().setListaNacionalidadBD(Servicios.consultarTNacionalidad());
        for (Nacionalidad elemento : getInstance().getListaNacionalidadBD()) {
            cmbNacionalidad.addItem(elemento.getNacionalidad());
        }
    }

    public static void cargarComboTipoId(JComboBox<String> cmbTipoId) {
        getInstance().setListaTipoIdBD(Servicios.consultarTTipoId());
        for (TipoIdentificacion elemento : getInstance().getListaTipoIdBD()) {
            cmbTipoId.addItem(elemento.getSexo());
        }
    }
    

}
