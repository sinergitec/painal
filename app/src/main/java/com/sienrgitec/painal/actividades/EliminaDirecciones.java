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
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;

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

        ipiPersona = CarritoSingleton.getInstance().getCliente().getiCliente();
        ipiDomicilio = Integer.parseInt(fm.getIDomicilio());

        btnAcepta = findViewById(R.id.btnSi);
        btnAcepta.setOnClickListener(v -> elimino(ipiPersona,ipiDomicilio,ipcPersona));

        BtnRechaza = findViewById(R.id.btnNo);
        BtnRechaza.setOnClickListener(v -> regreso());

    }

    private void elimino(Integer ipiPersona, Integer ipiDomicilio, String ipcPersona) {
        final Loading loading = new Loading(EliminaDirecciones.this);
        loading.iniciaDialogo("alert");

        final Painal service = ServiceGenerator.createService(Painal.class);
        Map<String, String> data = new HashMap<>();
        data.put("ipiPersona", ipiPersona.toString());
        data.put("ipiDomicilio", ipiDomicilio.toString());
        data.put("ipcPersona", ipcPersona);
        final Call<Respuesta> call = service.eliminaDomicilio(data);

        call.enqueue(new Callback<Respuesta>() {

            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                loading.detenDialogo("alert");
                Respuesta res = response.body();

                if (response.isSuccessful()) {
                    if (res.getResponse().getOplError().equals("true")){
                        Toast.makeText(EliminaDirecciones.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(EliminaDirecciones.this, "Registro Eliminado", Toast.LENGTH_LONG).show();

                        Intent inicio = new Intent(EliminaDirecciones.this, ListaDomicilioActivity.class);
                        startActivity(inicio);
                    }
                } else {
                    Toast.makeText(EliminaDirecciones.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {
                loading.detenDialogo("alert");
                Toast.makeText(EliminaDirecciones.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    private void regreso() {
        Intent inicio = new Intent(EliminaDirecciones.this, ListaDomicilioActivity.class);
        startActivity(inicio);
    }
}
