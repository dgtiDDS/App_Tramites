package tutorials.hackro.com.prototipopagossfa.Services;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tutorials.hackro.com.prototipopagossfa.Interfaces.Services.WsBanco;
import tutorials.hackro.com.prototipopagossfa.Interfaces.Services.WsDiversos;
import tutorials.hackro.com.prototipopagossfa.Interfaces.dataGeneral;
import tutorials.hackro.com.prototipopagossfa.Models.responseBancoPago;
import tutorials.hackro.com.prototipopagossfa.Models.responseGeneraReferencia;

/**
 * Created by david on 26/07/16.
 */
public class WsBancoImpl {


    private Retrofit retrofit;
    private WsBanco service;
    private Call<responseBancoPago> call;
    private dataGeneral data;
    private responseBancoPago responseString;

    public WsBancoImpl() {
        retrofit = new Retrofit.Builder()
                .baseUrl(data.urlService)//
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(WsBanco.class);

    }


    public responseBancoPago sendPayment(String cadena) {

        call = service.cobroBanco(cadena);

        call.enqueue(new Callback<responseBancoPago>() {
            @Override
            public void onResponse(Call<responseBancoPago> call, Response<responseBancoPago> response) {
              try {
                  responseString.setXml(response.body().getXml());
              }
              catch (Exception e){
                  Log.e("onFailure ", e.getMessage());
                  return;
              }

            }

            @Override
            public void onFailure(Call<responseBancoPago> call, Throwable t) {
                Log.e("onFailure ", t.getMessage());
                return;
            }
        });


        return responseString;
    }


}
