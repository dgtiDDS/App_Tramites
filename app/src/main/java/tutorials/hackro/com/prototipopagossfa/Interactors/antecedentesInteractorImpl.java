package tutorials.hackro.com.prototipopagossfa.Interactors;

import android.util.Base64;
import android.util.Log;

import tutorials.hackro.com.prototipopagossfa.Interfaces.Interactors.antecedentesInteractor;
import tutorials.hackro.com.prototipopagossfa.Interfaces.antecedentesonFinishListener;
import tutorials.hackro.com.prototipopagossfa.Models.responseGeneraReferencia;
import tutorials.hackro.com.prototipopagossfa.Services.WsDiversosImpl;

/**
 * Created by david on 25/07/16.
 */
public class antecedentesInteractorImpl implements antecedentesInteractor {

    private WsDiversosImpl wsDiversos;
    private String basicAuth;

    public antecedentesInteractorImpl() {
        wsDiversos = new WsDiversosImpl();
        basicAuth = "Basic " + Base64.encodeToString(String.format("%s:%s", "Username", "Password").getBytes(), Base64.NO_WRAP);
    }

    @Override
    public void validateFields(String cantidad, String importe, String tipoPersona, String nombre, String paterno, String materno, String curp, String calle, String exterior, String interior, String municipio, String localidad, String cp, String colonia, String otraColonia, antecedentesonFinishListener antecedentesonFinishListener) {
        try {
            if (!cantidad.equals("") && !importe.equals("") && !tipoPersona.equals("") && !nombre.equals("") && !paterno.equals("") && !materno.equals("") && !curp.equals("") && !calle.equals("") && !exterior.equals("") && !interior.equals("") && !municipio.equals("") && !localidad.equals("") && !cp.equals("") && !colonia.equals("")) {

                antecedentesonFinishListener.onSucess();

            } else {

                if (tipoPersona.equals("")) {
                    antecedentesonFinishListener.setErrorAntecedentes_tipo_persona_lbl();

                }
                if (nombre.equals("")) {
                    antecedentesonFinishListener.setErrorAntecedentes_nombre();
                }
                if (paterno.equals("")) {
                    antecedentesonFinishListener.setErrorAntecedentes_apellido_paterno_lbl();
                }
                if (materno.equals("")) {
                    antecedentesonFinishListener.setErrorAntecedentes_apellido_materno_lbl();
                }
                if (curp.equals("")) {
                    antecedentesonFinishListener.setErrorAntecedentes_curp_lbl();
                }
                if (calle.equals("")) {
                    antecedentesonFinishListener.setErrorAntecedentes_calle_lbl();
                }
                if (exterior.equals("")) {
                    antecedentesonFinishListener.setErrorAntecedentes_numero_exterior_lbl();
                }
                if (municipio.equals("")) {
                    antecedentesonFinishListener.setErrorAntecedentes_municipio_lbl();
                }
                if (localidad.equals("")) {
                    antecedentesonFinishListener.setErrorAntecedentes_localidad_lbl();
                }
                if (cp.equals("")) {
                    antecedentesonFinishListener.setErrorAntecedentes_cp_lbl();
                }
                if (colonia.equals("")) {
                    antecedentesonFinishListener.setErrorAntecedentes_colonia_lbl();
                }

                if (colonia.equals("") && otraColonia.equals("")) {
                    antecedentesonFinishListener.setErrorAntecedentes_otra_colonia_lbl();
                }
            }
        } catch (Exception e) {
            Log.e("Error: ", e.getMessage());
            antecedentesonFinishListener.failTicket();

        }
    }

    @Override
    public void responseResponse(String cantidad, String importe, String tipoPersona, String nombre, String paterno, String materno, String curp, String calle, String exterior, String interior, String municipio, String localidad, String cp, String colonia, String otraColonia, antecedentesonFinishListener antecedentesonFinishListener) {
        try {
            responseGeneraReferencia res = wsDiversos.requestWsDiversosImpl(basicAuth, cantidad, importe, tipoPersona, nombre, paterno, materno, curp, calle, exterior, interior, municipio, localidad, cp, colonia, otraColonia);
            if (res != null) {
                Log.e("Se esta logrando la conexion",res.toString());
                antecedentesonFinishListener.onSucess();
            } else {
                antecedentesonFinishListener.failTicket();
            }
        } catch (Exception e) {
            Log.e("Error: ", e.getMessage());
            antecedentesonFinishListener.failTicket();
        }
    }

}
