package com.sienrgitec.painal.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.carrito.CarritoSingleton;
import com.sienrgitec.painal.pojo.entity.TtCtComisiones_;
import com.sienrgitec.painal.pojo.entity.TtCtFormasPago_;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AplicaPago extends AppCompatActivity {

    private TextView etContacto, etDomicilio, etMonto;
    private Button btnPagar;
    RelativeLayout rlEstadoProc, rlPropinas;
    private Integer iFormaPago = 0, iComision = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aplica_pago);



        rlEstadoProc = findViewById(R.id.edoproc);
        rlPropinas  = findViewById(R.id.edoprop);
        etContacto  = findViewById (R.id.textView28);
        etDomicilio = findViewById(R.id.textView29);
        etMonto     = findViewById(R.id.textView25);
        btnPagar    = findViewById(R.id.btnPagoF);

        CargaFPagos();
        CargaComisiones();

    }

    private void CargaFPagos(){

        final Painal service = ServiceGenerator.createService(Painal.class);
        Map<String, String> data = new HashMap<>();
        //data.put("ipiCliente", String.valueOf(CarritoSingleton.getInstance().getCliente().getiCliente()));

        final Call<Respuesta> call = service.ctFormasPago(data);
        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                Respuesta res = response.body();

                if (response.isSuccessful()) {
                    if (res.getResponse().getOplError().equals("true")) {
                        Toast.makeText(AplicaPago.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();

                    }else {
                        int vxMod = 0, vyMod = 0,viPago = 0;
                        RadioGroup rgEstadoP = new RadioGroup(AplicaPago.this);
                        rgEstadoP.setOrientation(RadioGroup.HORIZONTAL);

                        for (final TtCtFormasPago_ objctFPago : res.getResponse().getTt_ctFormasPago().getTtCtFormasPago()) {

                            viPago = viPago + 1;

                            RadioButton rbEdoProceso = new RadioButton(AplicaPago.this);
                            rbEdoProceso.setText(objctFPago.getcFormaPago());
                            rbEdoProceso.setHeight(75);
                            rbEdoProceso.setLayoutParams(new RadioGroup.LayoutParams(180, 50)); //150

                            rgEstadoP.addView(rbEdoProceso);

                            if (viPago % 3 == 0) {
                                vxMod = 0;
                                vyMod = vyMod + 35;
                            } else {
                                vxMod = vxMod + 80;
                            }

                            rbEdoProceso.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    iFormaPago =  objctFPago.getiFormaPago();

                                }
                            });

                        }
                        rlEstadoProc.addView(rgEstadoP);
                    }
                } else {
                    Toast.makeText(AplicaPago.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {
                Toast.makeText(AplicaPago.this, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });

    }

    private void CargaComisiones(){
        final Painal service = ServiceGenerator.createService(Painal.class);
        Map<String, String> data = new HashMap<>();
        data.put("ipiPersona", String.valueOf(5));

        final Call<Respuesta> call = service.ctComisiones(data);
        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                Respuesta res = response.body();

                if (response.isSuccessful()) {
                    if (res.getResponse().getOplError().equals("true")) {
                        Toast.makeText(AplicaPago.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();

                    }else {
                        int vxMod = 0, vyMod = 0,viPago = 0;
                        RadioGroup rgPropinas = new RadioGroup(AplicaPago.this);
                        rgPropinas.setOrientation(RadioGroup.HORIZONTAL);

                        for (final TtCtComisiones_ objCtComision : res.getResponse().getTtCtComisiones().getTtCtComisiones_()) {

                            viPago = viPago + 1;

                            RadioButton rbAgregaP = new RadioButton(AplicaPago.this);
                            rbAgregaP.setText(objCtComision.getDeValor().toString());
                            rbAgregaP.setHeight(75);
                            rbAgregaP.setLayoutParams(new RadioGroup.LayoutParams(180, 50)); //150

                            rgPropinas.addView(rbAgregaP);

                            if (viPago % 3 == 0) {
                                vxMod = 0;
                                vyMod = vyMod + 35;
                            } else {
                                vxMod = vxMod + 80;
                            }

                            rbAgregaP.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    iComision =  objCtComision.getiComision();

                                }
                            });

                        }
                        rlPropinas.addView(rgPropinas);
                    }
                } else {
                    Toast.makeText(AplicaPago.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {
                Toast.makeText(AplicaPago.this, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });



    }
}