package com.sienrgitec.painal.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.componente.Loading;
import com.sienrgitec.painal.pojo.entity.TtCtClienteAutorizados_;
import com.sienrgitec.painal.pojo.entity.Tt_OpClienteReferidos_;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EliminaAutorizados extends AppCompatActivity {

    private Button btnAcepta, BtnRechaza;
    private Integer iCliente = 0;
    private Integer iAutorizado = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_eliminar);

        Intent i = getIntent();
        TtCtClienteAutorizados_ fm = (TtCtClienteAutorizados_) i.getSerializableExtra("objEliminar");

        iAutorizado = fm.getiAutorizado();
        iCliente    = fm.getiCliente();

        btnAcepta = findViewById(R.id.btnSi);
        btnAcepta.setOnClickListener(v -> elimino(iCliente,iAutorizado));

        BtnRechaza = findViewById(R.id.btnNo);
        BtnRechaza.setOnClickListener(v -> regreso());
    }

    private void elimino(Integer ipiCliente, Integer ipiAutorizado) {

        final Loading loading = new Loading(EliminaAutorizados.this);
        loading.iniciaDialogo("alert");


        final Painal service = ServiceGenerator.createService(Painal.class);
        Map<String, Integer> data = new HashMap<>();
        data.put("ipiCliente", ipiCliente);
        data.put("ipiAutorizado", ipiAutorizado);
        final Call<Respuesta> call = service.ctClienteAutorizadosDelete(data);

        call.enqueue(new Callback<Respuesta>() {

            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                loading.detenDialogo("alert");
                Respuesta res = response.body();

                if (response.isSuccessful()) {
                    if (res.getResponse().getOplError().equals("true")){
                        Toast.makeText(EliminaAutorizados.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(EliminaAutorizados.this, "Registro Eliminado", Toast.LENGTH_LONG).show();

                        Intent inicio = new Intent(EliminaAutorizados.this, FamilyListActivity.class);
                        startActivity(inicio);
                    }
                } else {
                    Toast.makeText(EliminaAutorizados.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {
                loading.detenDialogo("alert");
                Toast.makeText(EliminaAutorizados.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    private void regreso() {
        Intent inicio = new Intent(EliminaAutorizados.this, FamilyListActivity.class);
        startActivity(inicio);
    }

}
