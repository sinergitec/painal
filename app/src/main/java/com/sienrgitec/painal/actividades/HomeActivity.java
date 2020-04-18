package com.sienrgitec.painal.actividades;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.sienrgitec.painal.R;
import com.sienrgitec.painal.constante.Constantes;
import com.sienrgitec.painal.pojo.error.ErrorUtils;
import com.sienrgitec.painal.pojo.error.Errors;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.pojo.sesion.Session;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        final Painal service = ServiceGenerator.createService(Painal.class);
        Map<String, String> data = new HashMap<>();
        final Call<Respuesta> call = service.consulta(data);

        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {

                if(response.isSuccessful()){
                    Respuesta res = response.body();
                    System.out.println(res.toString());
                } else {
                    /*try {
                        Errors error = ErrorUtils.parseError(response);
                        Toast.makeText(HomeActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(HomeActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }*/

                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {
                System.out.println("Error: " + t.getMessage());
            }
        });

    }

}
