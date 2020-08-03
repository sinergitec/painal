package com.sienrgitec.painal.actividades;

import android.content.Intent;
import android.graphics.drawable.Drawable;
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

    private TextView pedido, estatus, evaluaP, evaluaT;
    private ImageView foto, evaluaProv, evaluaTitlani;
    public static final int[] IMAGESESTATUS = {R.drawable.ic_pagado, R.drawable.ic_entregar, R.drawable.ic_cancelado,
                                               R.drawable.ic_surtido, R.drawable.ic_rechazado, R.drawable.ic_entrega_a_domicilio,
                                               R.drawable.ic_vegetal, R.drawable.ic_entrega };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seguimiento_pedido);

        pedido = findViewById(R.id.ped);
        estatus = findViewById(R.id.estatus);
        foto = findViewById(R.id.pedido);
        evaluaProv = findViewById(R.id.evaluaProv);
        evaluaTitlani = findViewById(R.id.evaluaTitlani);
        evaluaP = findViewById(R.id.proveedor);
        evaluaT = findViewById(R.id.titlani);

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

                        String status = res.getResponse().getTtTtOpPedido().getTt_OpPedido().get(0).getcEdoProc();

                        Drawable d = null;
                        Drawable eP = null;
                        Drawable eT = null;
                        switch(status) {
                            case "PAGADO":
                                d = getResources().getDrawable(IMAGESESTATUS[0]);
                                foto.setImageDrawable(d);
                                break;
                            case "EN RUTA":
                                d = getResources().getDrawable(IMAGESESTATUS[1]);
                                foto.setImageDrawable(d);
                                break;

                            case "CANCELADO":
                                d = getResources().getDrawable(IMAGESESTATUS[2]);
                                foto.setImageDrawable(d);
                                break;

                            case "SURTIDO":
                                d = getResources().getDrawable(IMAGESESTATUS[3]);
                                foto.setImageDrawable(d);
                                break;

                            case "RECHAZADO":
                                d = getResources().getDrawable(IMAGESESTATUS[4]);
                                foto.setImageDrawable(d);
                                break;

                            case "ENTREGADO":
                                d = getResources().getDrawable(IMAGESESTATUS[5]);
                                foto.setImageDrawable(d);

                                eP = getResources().getDrawable(IMAGESESTATUS[6]);
                                evaluaProv.setImageDrawable(eP);
                                evaluaProv.setOnClickListener(v -> evaluaProv());

                                eT = getResources().getDrawable(IMAGESESTATUS[7]);
                                evaluaTitlani.setImageDrawable(eT);
                                evaluaTitlani.setOnClickListener(v -> evaluaTitlani());

                                evaluaP.setText("Evaluación del Proveedor");
                                evaluaP.setOnClickListener(v -> evaluaProv());

                                evaluaT.setText("Evaluación del Titlani");
                                evaluaT.setOnClickListener(v -> evaluaTitlani());
                                break;

                            default:
                                d = getResources().getDrawable(IMAGESESTATUS[0]);
                                foto.setImageDrawable(d);
                                break;
                        }
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

    private void evaluaTitlani() {
        Intent perfil = new Intent(SeguimientoActivity.this,  EvaluacionTActivity .class);
        startActivity(perfil);
    }

    private void evaluaProv() {
        Intent perfil = new Intent(SeguimientoActivity.this, EvaluacionPActivity.class);
        startActivity(perfil);
    }
}
