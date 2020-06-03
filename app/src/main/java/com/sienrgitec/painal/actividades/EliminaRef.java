package com.sienrgitec.painal.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.componente.Loading;
import com.sienrgitec.painal.pojo.entity.Tt_OpClienteReferidos_;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EliminaRef extends AppCompatActivity {

    private Button btnAcepta, BtnRechaza;
    private Integer iCliente = 0;
    private Integer iReferido = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_eliminar);

        Intent i = getIntent();
        Tt_OpClienteReferidos_ ref = (Tt_OpClienteReferidos_) i.getSerializableExtra("objEliminar");

        iReferido = ref.getiReferido();
        iCliente  = ref.getiCliente();

        btnAcepta = findViewById(R.id.btnSi);
        btnAcepta.setOnClickListener(v -> elimino(iCliente,iReferido));

        BtnRechaza = findViewById(R.id.btnNo);
        BtnRechaza.setOnClickListener(v -> regreso());
    }

    private void elimino(Integer ipiCliente, Integer ipiReferido) {

        final Loading loading = new Loading(EliminaRef.this);
        loading.iniciaDialogo("alert");


        final Painal service = ServiceGenerator.createService(Painal.class);
        Map<String, Integer> data = new HashMap<>();
        data.put("ipiCliente", ipiCliente);
        data.put("ipiReferido", ipiReferido);
        final Call<Respuesta> call = service.opClienteReferidosDelete(data);

        call.enqueue(new Callback<Respuesta>() {

            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                loading.detenDialogo("alert");
                Respuesta res = response.body();

                if (response.isSuccessful()) {
                    if (res.getResponse().getOplError().equals("true")){
                        Toast.makeText(EliminaRef.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(EliminaRef.this, "Registro Eliminado", Toast.LENGTH_LONG).show();

                        Intent inicio = new Intent(EliminaRef.this, ReferidosListActivity.class);
                        startActivity(inicio);
                    }
                } else {
                    Toast.makeText(EliminaRef.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {
                loading.detenDialogo("alert");
                Toast.makeText(EliminaRef.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    private void regreso() {
        Intent inicio = new Intent(EliminaRef.this, ReferidosListActivity.class);
        startActivity(inicio);
    }
}
