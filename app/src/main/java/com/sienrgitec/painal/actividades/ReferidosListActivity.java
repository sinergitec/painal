package com.sienrgitec.painal.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sienrgitec.painal.MainActivity;
import com.sienrgitec.painal.R;
import com.sienrgitec.painal.carrito.CarritoSingleton;
import com.sienrgitec.painal.componente.recycler.FamilyAdapter;
import com.sienrgitec.painal.componente.recycler.ReferidosAdapter;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.sienrgitec.painal.R.id.agregar;
import static com.sienrgitec.painal.R.id.imageView10;
import static com.sienrgitec.painal.R.id.imageView8;
import static com.sienrgitec.painal.R.id.recupera;
import static com.sienrgitec.painal.R.id.referidos;

public class ReferidosListActivity extends AppCompatActivity {

    private ImageView btnAgregar;
    private RecyclerView recyclerReferidos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_referidos);
        listReferidos();
        btnAgregar = findViewById(agregar);
        btnAgregar.setOnClickListener(v -> agregarReferidos());
    }

    private void agregarReferidos() {
        Intent ref = new Intent(ReferidosListActivity.this, ReferidosActivity.class);
        startActivity(ref);
    }

    private void listReferidos() {

        final Painal service = ServiceGenerator.createService(Painal.class);
        Map<String, String> data = new HashMap<>();
        data.put("ipiCliente", String.valueOf(CarritoSingleton.getInstance().getCliente().getiCliente()));

        final Call<Respuesta> call = service.opClienteReferidos(data);
        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                Respuesta res = response.body();

                if (response.isSuccessful()) {
                    if (res.getResponse().getOplError().equals("true"))
                        Toast.makeText(ReferidosListActivity.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                    else {
                        recyclerReferidos = findViewById(R.id.listReferidos);
                        recyclerReferidos.setLayoutManager(new LinearLayoutManager(ReferidosListActivity.this));
                        ReferidosAdapter fm = new ReferidosAdapter(ReferidosListActivity.this, null);
                        fm.setList(res.getResponse().getTt_opClienteReferidos().getTt_opClienteReferidos());
                        recyclerReferidos.setAdapter(fm);
                    }
                } else {
                    Toast.makeText(ReferidosListActivity.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {
                Toast.makeText(ReferidosListActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }
}
