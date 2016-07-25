package tutorials.hackro.com.prototipopagossfa.Interfaces.Interactors;

import tutorials.hackro.com.prototipopagossfa.Interfaces.antecedentesonFinishListener;

/**
 * Created by david on 25/07/16.
 */
public interface antecedentesInteractor {

    void validateFields(
            String cantidad,
            String importe,
            String tipoPersona,
            String nombre,
            String paterno,
            String materno,
            String curp,
            String calle,
            String exterior,
            String interior,
            String municipio,
            String localidad,
            String cp,
            String colonia,
            String otraColonia, antecedentesonFinishListener antecedentesonFinishListener
    );
}
