package tutorials.hackro.com.prototipopagossfa.Interactors;

import tutorials.hackro.com.prototipopagossfa.Interfaces.Interactors.antecedentesInteractor;
import tutorials.hackro.com.prototipopagossfa.Interfaces.antecedentesonFinishListener;

/**
 * Created by david on 25/07/16.
 */
public class antecedentesInteractorImpl implements antecedentesInteractor {

    @Override
    public void validateFields(String cantidad, String importe, String tipoPersona, String nombre, String paterno, String materno, String curp, String calle, String exterior, String interior, String municipio, String localidad, String cp, String colonia, String otraColonia, antecedentesonFinishListener antecedentesonFinishListener) {


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


    }



}
