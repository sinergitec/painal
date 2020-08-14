package com.sienrgitec.painal.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.carrito.CarritoSingleton;
import com.sienrgitec.painal.componente.recycler.FamilyAdapter;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.sienrgitec.painal.R.id.agregar;

public class FamilyListActivity  extends AppCompatActivity {

    private ImageView btnAgregar, back, home;;
    private RecyclerView recyclerFamily;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_family);
        listFamily();
        btnAgregar = findViewById(agregar);
        btnAgregar.setOnClickListener(v -> agregarFamilia());

        back = findViewById(R.id.back);
        back.setOnClickListener(v -> regresaPantalla());

        home = findViewById(R.id.imageView7);
        home.setOnClickListener(v -> pantallaHome());

    }

    private void agregarFamilia() {
        Intent cont = new Intent(FamilyListActivity.this, FamilyActivity.class);
        startActivity(cont);
    }

    private void  listFamily() {

        final Painal service = ServiceGenerator.createService(Painal.class);
        Map<String, String> data = new HashMap<>();
                data.put("ipiCliente", String.valueOf(CarritoSingleton.getInstance().getCliente().getiCliente()));

        final Call<Respuesta> call = service.ctClienteAutorizados(data);
        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                Respuesta res = response.body();

                if (response.isSuccessful()) {
                    if (res.getResponse().getOplError().equals("true"))
                        Toast.makeText(FamilyListActivity.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                    else {
                        recyclerFamily = findViewById(R.id.listFamilia);
                        recyclerFamily.setLayoutManager(new LinearLayoutManager(FamilyListActivity.this));
                        FamilyAdapter fm = new FamilyAdapter(FamilyListActivity.this, null);
                        fm.setList(res.getResponse().getTt_ctClienteAutorizados().getTt_ctClienteAutorizados());
                        recyclerFamily.setAdapter(fm);
                    }
                } else {
                    Toast.makeText(FamilyListActivity.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {
                Toast.makeText(FamilyListActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }

    private void pantallaHome() {
        Intent regresa = new Intent(FamilyListActivity.this, HomeActivity.class);
        startActivity(regresa);
    }

    private void regresaPantalla() {
        Intent regresa = new Intent(FamilyListActivity.this, HomeActivity.class);
        startActivity(regresa);
    }
}
