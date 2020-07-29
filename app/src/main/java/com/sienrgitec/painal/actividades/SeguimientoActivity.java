package com.sienrgitec.painal.actividades;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeguimientoActivity extends AppCompatActivity {

    private TextView pedido, estatus;
    private ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seguimiento_pedido);

        pedido = findViewById(R.id.ped);
        estatus = findViewById(R.id.estatus);

        final Painal service = ServiceGenerator.createService(Painal.class);
        Map<String, String> data = new HashMap<>();
        data.put("ipiPedido", "264");

        final Call<Respuesta> call = service.opEdoProc(data);
        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                Respuesta res = response.body();

                if (response.isSuccessful()) {
                    if (res.getResponse().getOplError().equals("true")) {
                        Toast.makeText(SeguimientoActivity.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                    }else {
                        pedido.setText(res.getResponse().getTtTtOpPedido().getTt_OpPedido().get(0).getIPedido());
                        estatus.setText(res.getResponse().getTtTtOpPedido().getTt_OpPedido().get(0).getcEdoProc());
                    }
                } else {
                    Toast.makeText(SeguimientoActivity.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {
                Toast.makeText(SeguimientoActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
