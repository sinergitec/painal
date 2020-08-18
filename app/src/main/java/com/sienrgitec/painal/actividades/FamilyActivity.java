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
import com.sienrgitec.painal.pojo.entity.TtCtClienteAutorizados_;
import com.sienrgitec.painal.pojo.peticion.DsCtClienteAutorizados;
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
import static com.sienrgitec.painal.R.id.edad;
import static com.sienrgitec.painal.R.id.descripcion;
import static com.sienrgitec.painal.R.id.parentesco;
import static com.sienrgitec.painal.R.id.switch2;

public class FamilyActivity extends AppCompatActivity {

    private Button btnRegAutorizado;
    private EditText nombreET, aPaternoET, aMaternoET, edadET, parentescoET ;
    private Switch solAutoET;
    private ImageView back, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.family);

        back = findViewById(R.id.back);
        back.setOnClickListener(v -> regresaPantalla());

        home = findViewById(R.id.imageView7);
        home.setOnClickListener(v -> pantallaHome());


        nombreET   = findViewById(descripcion);
        aPaternoET = findViewById(apellidoP);
        aMaternoET = findViewById(apellidoM);
        edadET = findViewById(edad);
        parentescoET = findViewById(parentesco);
        solAutoET = findViewById(switch2);

        btnRegAutorizado = findViewById(R.id.autorizarBtn);
        btnRegAutorizado.setOnClickListener(v -> registroAotorizado());

    }

    private void registroAotorizado() {
        String nombre   = nombreET.getText().toString();
        String aPaterno = aPaternoET.getText().toString();
        String aMaterno = aMaternoET.getText().toString();
        String edad     = edadET.getText().toString();
        String parentesco = parentescoET.getText().toString();

        Boolean solAuto = solAutoET.isChecked();

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

        if(edad.isEmpty()){
            edadET.setError("Edad requerida");
            edadET.requestFocus();
        }

        if(parentesco.isEmpty()){
            parentescoET.setError("Apellido Materno requerido");
            parentescoET.requestFocus();
        }

        if(!nombre.isEmpty() && !aPaterno.isEmpty() && !aMaterno.isEmpty() && !edad.isEmpty() && !parentesco.isEmpty()){

            final Loading loading = new Loading(FamilyActivity.this);
            loading.iniciaDialogo("alert");

            TtCtClienteAutorizados_ objctCliAuto = new TtCtClienteAutorizados_();

            objctCliAuto.setiCliente(CarritoSingleton.getInstance().getCliente().getiCliente());
            objctCliAuto.setiAutorizado(0);
            objctCliAuto.setcNombre(nombre);
            objctCliAuto.setcApellidos(aPaterno + " " + aMaterno);
            objctCliAuto.setcEdad(edad);
            objctCliAuto.setcParentesco(parentesco);
            objctCliAuto.setlSolicitaAut(solAuto);
            objctCliAuto.setDtCreado(null);
            objctCliAuto.setDtModificado(null);
            objctCliAuto.setcUsuCrea(CarritoSingleton.getInstance().getUsuario_().getcUsuario());
            objctCliAuto.setcUsuModifica(CarritoSingleton.getInstance().getUsuario_().getcUsuario());


            Peticion peticion = new Peticion(new Request(new DsCtClienteAutorizados(new ArrayList<TtCtClienteAutorizados_>() {
                {
                    add(objctCliAuto);
                }
            })));

            final Painal service = ServiceGenerator.createService(Painal.class);
            final Call<Respuesta> call = service.ctClienteAutorizado(peticion);
            //System.out.println(call.);

            call.enqueue(new Callback<Respuesta>() {
                @Override
                public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                    System.out.println(response.toString());
                    loading.detenDialogo("alert");

                    Toast.makeText(FamilyActivity.this, "Registro Guardado", Toast.LENGTH_LONG).show();
                    Intent inicio = new Intent(FamilyActivity.this, FamilyListActivity.class);
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
    private void pantallaHome() {
        Intent regresa = new Intent(FamilyActivity.this, HomeActivity.class);
        startActivity(regresa);
    }

    private void regresaPantalla() {
        Intent regresa = new Intent(FamilyActivity.this, FamilyListActivity.class);
        startActivity(regresa);
    }
}
