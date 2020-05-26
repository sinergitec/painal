package com.sienrgitec.painal.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.carrito.CarritoSingleton;
import com.sienrgitec.painal.componente.Loading;
import com.sienrgitec.painal.pojo.entity.TtCtContacto_;
import com.sienrgitec.painal.pojo.peticion.DsCtContacto;
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
import static com.sienrgitec.painal.R.id.descripcion;
import static com.sienrgitec.painal.R.id.obs;

public class ContactoActivity extends AppCompatActivity {

    private Button btnRegContacto;
    private EditText nombreET, aPaternoET, aMaternoET, obsET ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacto);

        nombreET   = findViewById(descripcion);
        aPaternoET = findViewById(apellidoP);
        aMaternoET = findViewById(apellidoM);
        obsET      = findViewById(obs);

        btnRegContacto = findViewById(R.id.contactoBtn);
        btnRegContacto.setOnClickListener(v -> registraContacto());

    }

    private void registraContacto() {

        final Loading loading = new Loading(ContactoActivity.this);
        loading.iniciaDialogo("alert");

        String nombre   = nombreET.getText().toString();
        String aPaterno = aPaternoET.getText().toString();
        String aMaterno = aMaternoET.getText().toString();
        String obs       = obsET.getText().toString();   //las observciones o son obligatorias

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

        if(!nombre.isEmpty() && !aPaterno.isEmpty() && !aMaterno.isEmpty()){

            TtCtContacto_ objctContacto = new TtCtContacto_();

            objctContacto.setiPersona(CarritoSingleton.getInstance().getCliente().getiCliente());
            objctContacto.setiContacto(0);
            objctContacto.setiTipoPersona(5);
            objctContacto.setItipoContacto(1);
            objctContacto.setcNombre(nombre);
            objctContacto.setcApellidos(aPaterno + " " + aMaterno );
            objctContacto.setcObs(obs);
            objctContacto.setDtCreado(null);
            objctContacto.setDtModificado(null);
            objctContacto.setcUsuCrea(CarritoSingleton.getInstance().getUsuario_().getcUsuario());
            objctContacto.setcUsuModifica(CarritoSingleton.getInstance().getUsuario_().getcUsuario());

            Peticion peticion = new Peticion(new Request(new DsCtContacto(new ArrayList<TtCtContacto_>() {
                {
                    add(objctContacto);
                }
            })));

            final Painal service = ServiceGenerator.createService(Painal.class);
            final Call<Respuesta> call = service.ctContacto(peticion);
            //System.out.println(call.);

            call.enqueue(new Callback<Respuesta>() {
                @Override
                public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                    System.out.println(response.toString());
                    loading.detenDialogo("alert");

                    Intent inicio = new Intent(ContactoActivity.this, ContactoListActivity.class);
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
