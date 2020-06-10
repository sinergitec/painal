package com.sienrgitec.painal.actividades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.carrito.CarritoSingleton;
import com.sienrgitec.painal.componente.recycler.ReferidosAdapter;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SaldosActivity extends AppCompatActivity {

    private Button btnAgregar;
    private EditText etSaldo;
    private  String vcCuenta = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saldos);

        btnAgregar = findViewById(R.id.btnAgregarF);
        etSaldo    = findViewById(R.id.editTextNumberDecimal);

        btnAgregar.setOnClickListener(v -> CreaFondo());

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
                        Intent home = new Intent(SaldosActivity.this, PerfilActivity.class);
                        startActivity(home);
                    }else {
                        //Double vdeSaldos = Double.parseDouble(res.getResponse().getTt_credEncCPCP().getTtCredEncCPCP().get(0).getDeSaldo());

                        //etSaldo.setText(res.getResponse().getTt_credEncCPCP().getTtCredEncCPCP().get(0).getDeSaldo());


                        String vdeSaldo = new DecimalFormat("0.00").format(Double.parseDouble(res.getResponse().getTt_credEncCPCP().getTtCredEncCPCP().get(0).getDeSaldo()));
                        SpannableString txtdeCant = new SpannableString(vdeSaldo);
                        etSaldo.setText(txtdeCant);

                        vcCuenta = res.getResponse().getTt_credEncCPCP().getTtCredEncCPCP().get(0).getcCuenta();




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
    private void CreaFondo() {
        Intent nvoFondo = new Intent(SaldosActivity.this, NvoPagoActivity.class);
        nvoFondo.putExtra("cuenta", vcCuenta);
        startActivity(nvoFondo);
    }
}