package com.sienrgitec.painal.actividades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.carrito.CarritoSingleton;
import com.sienrgitec.painal.componente.recycler.ReferidosAdapter;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SaldosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saldos);


        final Painal service = ServiceGenerator.createService(Painal.class);
        Map<String, String> data = new HashMap<>();
        data.put("ipiCliente", String.valueOf(CarritoSingleton.getInstance().getCliente().getiCliente()));

        final Call<Respuesta> call = service.credEncCPCP(data);
        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                Respuesta res = response.body();

                if (response.isSuccessful()) {
                    if (res.getResponse().getOplError().equals("true")) {
                        Toast.makeText(SaldosActivity.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                        Intent getSaldo = new Intent(SaldosActivity.this, PerfilActivity.class);
                        startActivity(getSaldo);
                    }else {

                    }
                } else {
                    Toast.makeText(SaldosActivity.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {
                Toast.makeText(SaldosActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }
}