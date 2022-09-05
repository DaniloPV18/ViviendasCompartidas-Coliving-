/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.Anfitrion;

/**
 *
 * @author NILOXD
 */
public class AdmPagos {

    public static boolean validarDatos(String idHuesped, String nombreVivienda, String codHab, String metodoPago, String dinero, String codHab0, JDateChooser dtcFechaInicio, JDateChooser dtcFechaFin) {
        /* Obtener las llaves foráneas de los combobox a través de los ArrayList */
//        int idSexo = AnfitrionArrayListsFK.getSexoFK(fkSexo);
//        int idTipoId = AnfitrionArrayListsFK.getIdentificacionTipoFK(fkTipoID);
//        int idNacionalidad = AnfitrionArrayListsFK.getNacionalidadFK(fkNacionalidad);
        /* Validar que los datos ingresados sean los solicitados */
//        p = new Anfitrion(identificador, nombres, apellidos, dtcFechaNac.getDate(), email, "HABILITADO", idTipoId, idSexo, idNacionalidad);
//        if (Validaciones.vAnfitrion(p)) {
//            p = Conversiones.anfitrionUpperCase(p);
//            return true;
//        }
        return false;
    }

    public static void cargarAnfitrion(String identificadorHuesped, JTextField txtNombreHuesped) {
        Anfitrion x = AdmAnfitriones.buscarCedula(identificadorHuesped);
        if (x != null) {
            txtNombreHuesped.setForeground(Color.BLACK);
            txtNombreHuesped.setText(x.getNombres() + " " + x.getApellidos());
        } else {
            txtNombreHuesped.setForeground(Color.RED);
            txtNombreHuesped.setText("NO SE HA ENCONTRADO");
        }
    }

    public static int getIndexTable(JTable tblPromo) {
        return tblPromo.getSelectedRow();
    }

}
