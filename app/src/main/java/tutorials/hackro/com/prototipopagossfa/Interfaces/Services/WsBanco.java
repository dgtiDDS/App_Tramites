package tutorials.hackro.com.prototipopagossfa.Interfaces.Services;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import tutorials.hackro.com.prototipopagossfa.Models.responseBancoPago;

/**
 * Created by david on 26/07/16.
 */
public interface WsBanco {


    @FormUrlEncoded
    @POST("cobroXml")
    Call<responseBancoPago> cobroBanco(@Field("xml")String  xml);
}
