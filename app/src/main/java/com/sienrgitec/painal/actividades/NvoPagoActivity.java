package com.sienrgitec.painal.actividades;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.sienrgitec.painal.MainActivity;
import com.sienrgitec.painal.R;
import com.sienrgitec.painal.carrito.CarritoSingleton;
import com.sienrgitec.painal.componente.Loading;
import com.sienrgitec.painal.pojo.entity.TtCredDetCPCP_;
import com.sienrgitec.painal.pojo.entity.TtCtClienteAutorizados_;
import com.sienrgitec.painal.pojo.peticion.DsCtClienteAutorizados;
import com.sienrgitec.painal.pojo.peticion.DsCtContacto;
import com.sienrgitec.painal.pojo.peticion.Peticion;
import com.sienrgitec.painal.pojo.peticion.Request;
import com.sienrgitec.painal.pojo.peticion.ds_NvoPago;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NvoPagoActivity extends AppCompatActivity {

    private EditText etcCuenta, etdMonto,etcReferencia, etcObservaciones;
    private Button btnPago;
    private String vcMovimiento = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nvo_pago);


        Intent i = getIntent();
        String vcCuenta = getIntent().getExtras().getString("cuenta");

        etcCuenta = findViewById(R.id.etCuenta);
        etdMonto  = findViewById(R.id.etMonto);
        etcReferencia = findViewById(R.id.etReferencia);
        etcObservaciones = findViewById(R.id.etObs);
        btnPago = findViewById(R.id.btnRegistroP);

         btnPago.setOnClickListener(v -> CreaDeposito());
         etcCuenta.setText(vcCuenta);
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_pirates:
                if (checked)
                    // Pirates are the best
                    vcMovimiento = "Deposito";
                    break;
           /* case R.id.radio_ninjas:
                if (checked)
                    // Ninjas rule
                    vcMovimiento = "Abono";
                    break;*/
        }
    }

    private void CreaDeposito(){


        /**AndrosOHg 28-07-2020**/
        ProgressDialog nDialog;
        nDialog = new ProgressDialog(NvoPagoActivity.this);
        nDialog.setMessage("Cargando...");
        nDialog.setTitle("Recarga Saldo");
        nDialog.setIndeterminate(false);
        nDialog.show();
        /**--------------------**/




        final Loading loading = new Loading(NvoPagoActivity.this);
        loading.iniciaDialogo("alert");

        String vcCuenta = etcCuenta.getText().toString();
        String vdeMonto = etdMonto.getText().toString();
        String vcReferencia = etcReferencia.getText().toString();
        String vcObservaciones = etcObservaciones.getText().toString();


        if(vcMovimiento == ""){
            Toast.makeText(NvoPagoActivity.this, "Debe indicar un tipo de movimiento", Toast.LENGTH_LONG).show();
            return;
        }

        if (vcCuenta.isEmpty()){
            Toast.makeText(NvoPagoActivity.this, "El numero de cuneta no puede estar vacío", Toast.LENGTH_LONG).show();
            return;
        }


        if (vdeMonto.isEmpty()){
            Toast.makeText(NvoPagoActivity.this, "El monto debe ser mayor a Cero", Toast.LENGTH_LONG).show();
            return;
        }

        if(vcReferencia.isEmpty()){
            Toast.makeText(NvoPagoActivity.this, "Debe indicar una referencia", Toast.LENGTH_LONG).show();
            return;
        }

        TtCredDetCPCP_ objAbono = new TtCredDetCPCP_();
        objAbono.setcCuenta(vcCuenta);
        objAbono.setcMov(vcMovimiento);
        objAbono.setDeMonto(vdeMonto);
        objAbono.setcReferencia(vcReferencia);
        objAbono.setcObs(vcObservaciones);
        objAbono.setlAutorizado(false);
        objAbono.setcUsuCrea(CarritoSingleton.getInstance().getCliente().getcUsuCrea());
        objAbono.setcUsuModifica(CarritoSingleton.getInstance().getCliente().getcUsuCrea());

        Peticion peticion = new Peticion(new Request(new ds_NvoPago(new ArrayList<TtCredDetCPCP_>() {
            {
                add(objAbono);
            }
        })));

        final Painal service = ServiceGenerator.createService(Painal.class);
        final Call<Respuesta> call = service.credDetCPCPPost(peticion);
        //System.out.println(call.);

        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                System.out.println(response.toString());
                loading.detenDialogo("alert");

                if(response.isSuccessful()){
                    Respuesta res = response.body();

                    if(res.getResponse().getOplError().equals("true")){
                        Toast.makeText(NvoPagoActivity.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                        return;
                    }

                    /**AndrosOHG 28-07-2020**/
                    AlertDialog.Builder myBuild = new AlertDialog.Builder(NvoPagoActivity.this);
                    myBuild.setMessage("En breve será aproada su recarga ");
                    myBuild.setTitle(Html.fromHtml("<font color ='#FF0000'> ¡Solicitud Exitosa! </font>"));
                    myBuild.setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent inicio = new Intent(NvoPagoActivity.this, HomeActivity.class);
                            startActivity(inicio);

                        }
                    });
                    AlertDialog dialog = myBuild.create();
                    dialog.show();
                    nDialog.dismiss();

                    /**--------------------**/


                    /*Toast.makeText(NvoPagoActivity.this, "Solicitud Exitosa", Toast.LENGTH_LONG).show();
                    Intent inicio = new Intent(NvoPagoActivity.this, HomeActivity.class);
                    startActivity(inicio);*/

                }else{
                    Toast.makeText(NvoPagoActivity.this, "No se pudo crear la solicitud de abono", Toast.LENGTH_LONG).show();
                }

                System.out.println(response.toString());

                /**/

            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {
                System.out.println(t.getMessage());
                loading.detenDialogo("alert");
            }
        });
    }
}