package tutorials.hackro.com.prototipopagossfa.Interfaces.Services;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import tutorials.hackro.com.prototipopagossfa.Models.responseGeneraReferencia;

/**
 * Created by david on 25/07/16.
 */
public interface WsDiversos {

    @POST("generaReferencia")
    @FormUrlEncoded
    Call<responseGeneraReferencia> ValidarDisponibilidad(@Header("Authorization") String authorization,
                                                         @Field("id_usuario") String cantidad,
                                                         @Field("importe") String importe,
                                                         @Field("tipoPersona") String tipoPersona,
                                                         @Field("nombre") String nombre,
                                                         @Field("paterno") String paterno,
                                                         @Field("materno") String materno,
                                                         @Field("curp") String curp,
                                                         @Field("calle") String calle,
                                                         @Field("exterior") String exterior,
                                                         @Field("interior") String interior,
                                                         @Field("municipio") String municipio,
                                                         @Field("localidad") String localidad,
                                                         @Field("cp") String cp,
                                                         @Field("colonia") String colonia,
                                                         @Field("otraColonia") String otraColonia);

}
