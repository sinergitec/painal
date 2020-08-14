package com.sienrgitec.painal.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.componente.recycler.EvaluacionAdapter;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EvaluacionTActivity extends AppCompatActivity {

    private TextView tipoET;
    private RecyclerView recyclerEvaluacion;
    private ImageView  back, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_evaluacion_titlani);

        tipoET   = findViewById(R.id.tipo);

        back = findViewById(R.id.back);
        back.setOnClickListener(v -> regresaPantalla());

        home = findViewById(R.id.imageView7);
        home.setOnClickListener(v -> pantallaHome());

        obtenerTipoEvaluacion();
    }

    private void obtenerTipoEvaluacion() {

        final Painal service = ServiceGenerator.createService(Painal.class);
        Map<String, String> data = new HashMap<>();
        data.put("iplActivo", "true");
        data.put("ipcTipo", "Evaluacion al Titlani");

        final Call<Respuesta> call = service.ctEvaluacionGet(data);
        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                Respuesta res = response.body();

                if (response.isSuccessful()) {
                    if (res.getResponse().getOplError().equals("true"))
                        Toast.makeText(EvaluacionTActivity.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                    else {
                        recyclerEvaluacion = findViewById(R.id.listEvaluacion);
                        recyclerEvaluacion.setLayoutManager(new LinearLayoutManager(EvaluacionTActivity.this));
                        EvaluacionAdapter fm = new EvaluacionAdapter(EvaluacionTActivity.this, null);
                        fm.setList(res.getResponse().getTt_ctEvaluacion().getTt_ctEvaluacion());
                        recyclerEvaluacion.setAdapter(fm);
                    }
                } else {
                    Toast.makeText(EvaluacionTActivity.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {
                Toast.makeText(EvaluacionTActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void pantallaHome() {
        Intent regresa = new Intent(EvaluacionTActivity.this, HomeActivity.class);
        startActivity(regresa);
    }

    private void regresaPantalla() {
        Intent regresa = new Intent(EvaluacionTActivity.this, HomeActivity.class);
        startActivity(regresa);
    }
}
