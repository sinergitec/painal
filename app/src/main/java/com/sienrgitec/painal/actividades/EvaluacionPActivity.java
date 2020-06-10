package com.sienrgitec.painal.actividades;

import android.os.Bundle;
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

public class EvaluacionPActivity extends AppCompatActivity {

    private TextView tipoET;
    private RecyclerView recyclerEvaluacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_evaluacion);

        tipoET   = findViewById(R.id.tipo);

        obtenerTipoEvaluacion();
    }

    private void obtenerTipoEvaluacion() {

        final Painal service = ServiceGenerator.createService(Painal.class);
        Map<String, String> data = new HashMap<>();
        data.put("iplActivo", "true");
        data.put("ipcTipo", "Evaluacion al Proveedor");

        final Call<Respuesta> call = service.ctEvaluacionGet(data);
        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                Respuesta res = response.body();

                if (response.isSuccessful()) {
                    if (res.getResponse().getOplError().equals("true"))
                        Toast.makeText(EvaluacionPActivity.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                    else {
                        recyclerEvaluacion = findViewById(R.id.listEvaluacion);
                        recyclerEvaluacion.setLayoutManager(new LinearLayoutManager(EvaluacionPActivity.this));
                        EvaluacionAdapter fm = new EvaluacionAdapter(EvaluacionPActivity.this, null);
                        fm.setList(res.getResponse().getTt_ctEvaluacion().getTt_ctEvaluacion());
                        recyclerEvaluacion.setAdapter(fm);
                    }
                } else {
                    Toast.makeText(EvaluacionPActivity.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {
                Toast.makeText(EvaluacionPActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
