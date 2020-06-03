package com.sienrgitec.painal.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sienrgitec.painal.MainActivity;
import com.sienrgitec.painal.R;
import com.sienrgitec.painal.carrito.CarritoSingleton;
import com.sienrgitec.painal.componente.Loading;
import com.sienrgitec.painal.pojo.entity.TtCtCliente_;
import com.sienrgitec.painal.pojo.entity.TtCtContacto_;
import com.sienrgitec.painal.pojo.entity.Tt_OpClienteReferidos_;
import com.sienrgitec.painal.pojo.peticion.DsCtContacto;
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

public class ReferidosActivity extends AppCompatActivity {

    private Button btnReferir;
    private EditText nombreET, aPaternoET, aMaternoET, emailET, telefonoET ;
    private Switch autoriza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.referidos);

        nombreET   = findViewById(R.id.descripcion);
        aPaternoET = findViewById(apellidoP);
        aMaternoET = findViewById(apellidoM);
        emailET   = findViewById(email);
        telefonoET = findViewById(telefono);
        autoriza = findViewById(switch1);


        btnReferir = findViewById(R.id.referirBtn);
        btnReferir.setOnClickListener(v -> registraReferidos());
    }

    private void registraReferidos() {
        final Loading loading = new Loading(ReferidosActivity.this);
        loading.iniciaDialogo("alert");

        String nombre   = nombreET.getText().toString();
        String aPaterno = aPaternoET.getText().toString();
        String aMaterno = aMaternoET.getText().toString();
        String correo   = emailET.getText().toString();
        String telefono = telefonoET.getText().toString();

        Boolean autoriza = this.autoriza.isChecked();

        if(nombre.isEmpty()){
            nombreET.setError("Nombre requerido");
            nombreET.requestFocus();
        }

        if(aPaterno.isEmpty()){
            aPaternoET.setError("Apellido Paterno requerido");
            aPaternoET.requestFocus();
        }

        if(aMaterno.isEmpty()){
            aMaternoET.setError("Apellido Materno requerido");
            aMaternoET.requestFocus();
        }

        if(correo.isEmpty()){
            emailET.setError("Correo requerido");
            emailET.requestFocus();
        }

        if(telefono.isEmpty()){
            telefonoET.setError("Telefono requerido");
            telefonoET.requestFocus();
        }


        if(!nombre.isEmpty() && !aPaterno.isEmpty() && !aMaterno.isEmpty() && !correo.isEmpty()  && !telefono.isEmpty()){

            Tt_OpClienteReferidos_ objopReferidos = new Tt_OpClienteReferidos_();

            objopReferidos.setiCliente(CarritoSingleton.getInstance().getCliente().getiCliente());
            objopReferidos.setiReferido(0);
            objopReferidos.setcNombre(nombre);
            objopReferidos.setCapellidos(aPaterno + " " + aMaterno);
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
            final Call<Respuesta> call = service.opClienteReferidos(peticion);
            //System.out.println(call.);

            call.enqueue(new Callback<Respuesta>() {
                @Override
                public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                    System.out.println(response.toString());
                    loading.detenDialogo("alert");

                    Intent inicio = new Intent(ReferidosActivity.this, ReferidosListActivity.class);
                    startActivity(inicio);

                }

                @Override
                public void onFailure(Call<Respuesta> call, Throwable t) {
                    System.out.println(t.getMessage());
                    loading.detenDialogo("alert");
                }
            });
        }
    }
}
