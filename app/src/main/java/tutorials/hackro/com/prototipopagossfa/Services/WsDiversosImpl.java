package tutorials.hackro.com.prototipopagossfa.Services;

import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tutorials.hackro.com.prototipopagossfa.Interfaces.Services.WsDiversos;
import tutorials.hackro.com.prototipopagossfa.Interfaces.dataGeneral;
import tutorials.hackro.com.prototipopagossfa.Models.responseGeneraReferencia;

/**
 * Created by david on 26/07/16.
 */
public class WsDiversosImpl {

    private dataGeneral data;
    private Retrofit retrofit;
    private WsDiversos service;
    private Call<responseGeneraReferencia> call;
    private responseGeneraReferencia responseReferencia;

    public WsDiversosImpl() {
        retrofit = new Retrofit.Builder()
                .baseUrl(data.urlService)//
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(WsDiversos.class);
    }


    public responseGeneraReferencia requestWsDiversosImpl(String authorization, String cantidad, String importe, String tipoPersona, String nombre, String paterno, String materno, String curp, String calle, String exterior, String interior, String municipio, String localidad, String cp, String colonia, String otraColonia) {


        call = service.ValidarDisponibilidad(authorization, cantidad, importe, tipoPersona, nombre, paterno, materno, curp, calle, exterior, interior, municipio, localidad, cp, colonia, otraColonia);

        call.enqueue(new Callback<responseGeneraReferencia>() {
            @Override
            public void onResponse(Call<responseGeneraReferencia> call, Response<responseGeneraReferencia> response) {
                //final responseGeneraReferencia res = new responseGeneraReferencia(response.body().getSecuencia(),response.body().getNumeroReferencia(),response.body().getNombre(),response.body().getClaveServicio(),response.body().getDescripcionCorta(),response.body().getTotal(),response.body().getFechaVigencia(),response.body().getFechaEmision(),response.body().getPagos(),response.body().getDescripcionServicio(),response.body().getEstatus(),response.body().getDescripcionEstatus());
               try {
                   responseReferencia = new responseGeneraReferencia(response.body().getSecuencia(), response.body().getNumeroReferencia(), response.body().getNombre(), response.body().getClaveServicio(), response.body().getDescripcionCorta(), response.body().getTotal(), response.body().getFechaVigencia(), response.body().getFechaEmision(), response.body().getPagos(), response.body().getDescripcionServicio(), response.body().getEstatus(), response.body().getDescripcionEstatus());
               }
               catch (Exception e){
                   Log.e("onFailure ", e.getMessage());

                   return;
               }

            }

            @Override
            public void onFailure(Call<responseGeneraReferencia> call, Throwable t) {
                Log.e("onFailure ", t.getMessage());
                return;
            }

        });


        return responseReferencia;
    }
}
