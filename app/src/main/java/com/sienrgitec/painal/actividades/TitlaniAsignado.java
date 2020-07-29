package com.sienrgitec.painal.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.carrito.CarritoSingleton;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TitlaniAsignado extends AppCompatActivity {

    private TextView nombre, telefono;
    private ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.titlani_asignado);

        nombre = findViewById(R.id.nombreT);
        telefono = findViewById(R.id.telT);

        final Painal service = ServiceGenerator.createService(Painal.class);
        Map<String, String> data = new HashMap<>();
        data.put("ipiPedido", "264");

        final Call<Respuesta> call = service.consultaTitlani(data);
        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                Respuesta res = response.body();

                if (response.isSuccessful()) {
                    if (res.getResponse().getOplError().equals("true")) {
                        Toast.makeText(TitlaniAsignado.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                    }else {
                        String nombreP   = res.getResponse().getTt_ctPainani().getTt_ctPainani().get(0).getcNombre();
                        String apellidoP = res.getResponse().getTt_ctPainani().getTt_ctPainani().get(0).getcApellidoPat();
                        String apellidoM =  res.getResponse().getTt_ctPainani().getTt_ctPainani().get(0).getcApellidoMat();

                        nombre.setText(nombreP + " " + apellidoP + " " + apellidoM);
                        telefono.setText(res.getResponse().getTt_ctPainani().getTt_ctPainani().get(0).getcWhattsApp());
                    }
                } else {
                    Toast.makeText(TitlaniAsignado.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {
                Toast.makeText(TitlaniAsignado.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
