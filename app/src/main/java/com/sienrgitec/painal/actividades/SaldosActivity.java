package com.sienrgitec.painal.actividades;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.sienrgitec.painal.MainActivity;
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

import static com.sienrgitec.painal.constante.Constantes.vdeSaldo;

public class SaldosActivity extends AppCompatActivity {

    private Button btnAgregar;
    private EditText etSaldo;
    private  String vcCuenta = "";
    private ImageView  back, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saldos);

        btnAgregar = findViewById(R.id.btnAgregarF);
        etSaldo    = findViewById(R.id.editTextNumberDecimal);

        back = findViewById(R.id.back);
        back.setOnClickListener(v -> regresaPantalla());

        home = findViewById(R.id.imageView7);
        home.setOnClickListener(v -> pantallaHome());




        ProgressDialog nDialog;
        nDialog = new ProgressDialog(SaldosActivity.this);
        nDialog.setMessage("Alerta...");
        nDialog.setTitle("Alerta");
        nDialog.setIndeterminate(false);
        nDialog.show();

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
                        /*Toast.makeText(SaldosActivity.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                        Intent home = new Intent(SaldosActivity.this, PerfilActivity.class);
                        startActivity(home);*/

                        etSaldo.setVisibility(View.INVISIBLE);
                        btnAgregar.setVisibility(View.INVISIBLE);

                        AlertDialog.Builder myBuild = new AlertDialog.Builder(SaldosActivity.this);
                        myBuild.setMessage("Aún no tienes ninguna cuenta de pago Comunidad Painal. Te invitamos a que te registres" +
                                " y conoce sus benebicios. ");
                        myBuild.setTitle(Html.fromHtml("<font color ='#FF0000'> ¡AVISO! </font>"));
                        myBuild.setPositiveButton("Registrate", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(SaldosActivity.this, "esta en construcción", Toast.LENGTH_LONG).show();
                                Toast.makeText(SaldosActivity.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                                Intent home = new Intent(SaldosActivity.this, PerfilActivity.class);
                                startActivity(home);
                                dialog.cancel();
                            }
                        });
                        myBuild.setNegativeButton("Más Tarde", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(SaldosActivity.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                                Intent home = new Intent(SaldosActivity.this, PerfilActivity.class);
                                startActivity(home);
                                dialog.cancel();
                            }
                        });

                        AlertDialog dialog = myBuild.create();
                        dialog.show();
                        nDialog.dismiss();

                    }else {
                        //Double vdeSaldos = Double.parseDouble(res.getResponse().getTt_credEncCPCP().getTtCredEncCPCP().get(0).getDeSaldo());
                        //etSaldo.setText(res.getResponse().getTt_credEncCPCP().getTtCredEncCPCP().get(0).getDeSaldo());

                        String vdeSaldo = new DecimalFormat("0.00").format(Double.parseDouble(res.getResponse().getTt_credEncCPCP().getTtCredEncCPCP().get(0).getDeSaldo()));
                        SpannableString txtdeCant = new SpannableString(vdeSaldo);
                        etSaldo.setText(txtdeCant);

                        vcCuenta = res.getResponse().getTt_credEncCPCP().getTtCredEncCPCP().get(0).getcCuenta();

                        btnAgregar.setOnClickListener(v -> CreaFondo());

                        nDialog.dismiss();
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

    private void pantallaHome() {
        Intent regresa = new Intent(SaldosActivity.this, HomeActivity.class);
        startActivity(regresa);
    }

    private void regresaPantalla() {
        Intent regresa = new Intent(SaldosActivity.this, PerfilActivity.class);
        startActivity(regresa);
    }
}