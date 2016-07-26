package tutorials.hackro.com.prototipopagossfa.Interfaces.Presenters;

/**
 * Created by david on 25/07/16.
 */
public interface antecedentesPresenter {


    void validateFields(String cantidad, String importe, String tipoPersona, String nombre, String paterno, String materno, String curp, String calle, String exterior, String interior, String municipio, String localidad, String cp, String colonia, String otraColonia);
    void onDestroy();
    void requestData(String cantidad, String importe, String tipoPersona, String nombre, String paterno, String materno, String curp, String calle, String exterior, String interior, String municipio, String localidad, String cp, String colonia, String otraColonia);



}
