package com.sienrgitec.painal.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.carrito.CarritoSingleton;
import com.sienrgitec.painal.componente.Loading;
import com.sienrgitec.painal.pojo.entity.TtCtArtProveedor_;
import com.sienrgitec.painal.pojo.entity.Tt_OpClienteReferidos_;
import com.sienrgitec.painal.pojo.peticion.DsOpClienteReferidos;
import com.sienrgitec.painal.pojo.peticion.Peticion;
import com.sienrgitec.painal.pojo.peticion.Request;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.sienrgitec.painal.R.id.apellidoM;
import static com.sienrgitec.painal.R.id.apellidoP;
import static com.sienrgitec.painal.R.id.email;
import static com.sienrgitec.painal.R.id.nombre;
import static com.sienrgitec.painal.R.id.switch1;
import static com.sienrgitec.painal.R.id.telefono;

public class RefActualizaActivity extends AppCompatActivity {

    private Button btnRegActualiza;
    private EditText nombreET, aPaternoET, aMaternoET, emailET, telefonoET ;
    private Switch autorizaET;
    private Integer iReferido = 0;
    private ImageView back, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.referidos_actualiza);

        nombreET   = findViewById(nombre);
        aPaternoET = findViewById(apellidoP);
        aMaternoET = findViewById(apellidoM);
        emailET   = findViewById(email);
        telefonoET = findViewById(telefono);
        autorizaET = findViewById(switch1);

        back = findViewById(R.id.back);
        back.setOnClickListener(v -> regresaPantalla());

        home = findViewById(R.id.imageView7);
        home.setOnClickListener(v -> pantallaHome());

        Intent i = getIntent();
        Tt_OpClienteReferidos_ ref = (Tt_OpClienteReferidos_) i.getSerializableExtra("objActualizar");
        iReferido = ref.getiReferido();

        nombreET.setText(ref.getcNombre());
        aPaternoET.setText(ref.getCapellidos());
        emailET.setText(ref.getcEMail());
        telefonoET.setText(ref.getcTelefono());
        autorizaET.setChecked(ref.getlAfiliado());

        btnRegActualiza = findViewById(R.id.referirBtn);
        btnRegActualiza.setOnClickListener(v -> actualizaReferidos());
    }

    private void actualizaReferidos() {
        String nombre   = nombreET.getText().toString();
        String aPaterno = aPaternoET.getText().toString();
        String correo   = emailET.getText().toString();
        String telefono = telefonoET.getText().toString();

        Boolean autoriza = autorizaET.isChecked();

        if(nombre.isEmpty()){
            nombreET.setError("Nombre requerido");
            nombreET.requestFocus();
        }

        if(aPaterno.isEmpty()){
            aPaternoET.setError("Apellidos requeridos");
            aPaternoET.requestFocus();
        }

        if(correo.isEmpty()){
            emailET.setError("Correo requerido");
            emailET.requestFocus();
        }

        if(telefono.isEmpty()){
            telefonoET.setError("Telefono requerido");
            telefonoET.requestFocus();
        }

        if(!nombre.isEmpty() && !aPaterno.isEmpty() && !correo.isEmpty()  && !telefono.isEmpty()){

            final Loading loading = new Loading(RefActualizaActivity.this);
            loading.iniciaDialogo("alert");

            Tt_OpClienteReferidos_ objopReferidos = new Tt_OpClienteReferidos_();

            objopReferidos.setiCliente(CarritoSingleton.getInstance().getCliente().getiCliente());
            objopReferidos.setiReferido(iReferido);
            objopReferidos.setcNombre(nombre);
            objopReferidos.setCapellidos(aPaterno);
            objopReferidos.setcEMail(correo);
            objopReferidos.setcTelefono(telefono);
            objopReferidos.setcCveReferido("");
            objopReferidos.setlAfiliado(autoriza);
            objopReferidos.setDtCreado(null);
            objopReferidos.setDtModificado(null);
            objopReferidos.setcUsuCrea(CarritoSingleton.getInstance().getUsuario_().getcUsuario());
            objopReferidos.setcUsuModifica(CarritoSingleton.getInstance().getUsuario_().getcUsuario());

            Peticion peticion = new Peticion(new Request(new DsOpClienteReferidos(new ArrayList<Tt_OpClienteReferidos_>() {
                {
                    add(objopReferidos);
                }
            })));

            final Painal service = ServiceGenerator.createService(Painal.class);
            final Call<Respuesta> call = service.opClienteReferidosPut(peticion);

            call.enqueue(new Callback<Respuesta>() {
                @Override
                public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                    System.out.println(response.toString());
                    loading.detenDialogo("alert");

                    Toast.makeText(RefActualizaActivity.this, "Registro Actualizado", Toast.LENGTH_LONG).show();
                    Intent inicio = new Intent(RefActualizaActivity.this, ReferidosListActivity.class);
                    startActivity(inicio);
                }

                @Override
                public void onFailure(Call<Respuesta> call, Throwable t) {
                    System.out.println(t.getMessage());
                    Toast.makeText(RefActualizaActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    loading.detenDialogo("alert");
                }
            });
        }
    }

    private void pantallaHome() {
        Intent regresa = new Intent(RefActualizaActivity.this, HomeActivity.class);
        startActivity(regresa);
    }

    private void regresaPantalla() {
        Intent regresa = new Intent(RefActualizaActivity.this, HomeActivity.class);
        startActivity(regresa);
    }
}
