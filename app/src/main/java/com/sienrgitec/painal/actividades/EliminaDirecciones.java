package com.sienrgitec.painal.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.carrito.CarritoSingleton;
import com.sienrgitec.painal.componente.Loading;
import com.sienrgitec.painal.pojo.entity.TtCtClienteAutorizados_;
import com.sienrgitec.painal.pojo.entity.TtCtDomicilio_;
import com.sienrgitec.painal.pojo.peticion.DsCtClienteAutorizados;
import com.sienrgitec.painal.pojo.peticion.DsCtDomicilio;
import com.sienrgitec.painal.pojo.peticion.Peticion;
import com.sienrgitec.painal.pojo.peticion.Request;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EliminaDirecciones extends AppCompatActivity {

    private Button btnAcepta, BtnRechaza;
    private Integer ipiPersona = 0;
    private Integer ipiDomicilio = 0;
    private String ipcPersona = "Cliente";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_eliminar);

        Intent i = getIntent();
        TtCtDomicilio_ fm = (TtCtDomicilio_) i.getSerializableExtra("objEliminar");

        btnAcepta = findViewById(R.id.btnSi);
        btnAcepta.setOnClickListener(v -> elimino(fm));

        BtnRechaza = findViewById(R.id.btnNo);
        BtnRechaza.setOnClickListener(v -> regreso());

    }

    private void elimino(TtCtDomicilio_ domicilio) {
        final Loading loading = new Loading(EliminaDirecciones.this);
        loading.iniciaDialogo("alert");

        domicilio.setLActivo(false);

        Peticion peticion = new Peticion(new Request(new DsCtDomicilio(new ArrayList<TtCtDomicilio_>() {
            {
                add(domicilio);
            }
        })));

        final Painal service = ServiceGenerator.createService(Painal.class);
        final Call<Respuesta> call = service.ctDomicilioPut(peticion);

        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                System.out.println(response.toString());
                loading.detenDialogo("alert");

                Intent inicio = new Intent(EliminaDirecciones.this, ListaDomicilioActivity.class);
                startActivity(inicio);

            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {
                System.out.println(t.getMessage());
                loading.detenDialogo("alert");
            }
        });
    }

    private void regreso() {
        Intent inicio = new Intent(EliminaDirecciones.this, ListaDomicilioActivity.class);
        startActivity(inicio);
    }
}
