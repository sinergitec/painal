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
import static com.sienrgitec.painal.R.id.descripcion;
import static com.sienrgitec.painal.R.id.edad;
import static com.sienrgitec.painal.R.id.parentesco;
import static com.sienrgitec.painal.R.id.switch2;


public class FamilyActualiza extends AppCompatActivity {

    private Button btnRegActualiza;
    private EditText nombreET, aPaternoET, aMaternoET, edadET, parentescoET ;
    private Switch solAutoET;
    private Integer iAutorizado = 0;
    private ImageView back, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.family_actualiza);

        nombreET   = findViewById(descripcion);
        aPaternoET = findViewById(apellidoP);
        aMaternoET = findViewById(apellidoM);
        edadET = findViewById(edad);
        parentescoET = findViewById(parentesco);
        solAutoET = findViewById(switch2);

        back = findViewById(R.id.back);
        back.setOnClickListener(v -> regresaPantalla());

        home = findViewById(R.id.imageView7);
        home.setOnClickListener(v -> pantallaHome());



        Intent i = getIntent();
        TtCtClienteAutorizados_ fm = (TtCtClienteAutorizados_) i.getSerializableExtra("objActualizar");

        iAutorizado = fm.getiAutorizado();

        nombreET.setText(fm.getcNombre());
        aPaternoET.setText(fm.getcApellidos());
        edadET.setText(fm.getcEdad());
        parentescoET.setText(fm.getcParentesco());
        solAutoET.setChecked(fm.getlSolicitaAut());

        btnRegActualiza = findViewById(R.id.autorizarBtn);
        btnRegActualiza.setOnClickListener(v -> actualizaFamilia());
    }

    private void actualizaFamilia() {
        String nombre   = nombreET.getText().toString();
        String aPaterno = aPaternoET.getText().toString();
        String edad     = edadET.getText().toString();
        String parentesco = parentescoET.getText().toString();
        Boolean solAuto = solAutoET.isChecked();

        if(nombre.isEmpty()){
            nombreET.setError("Nombre requerido");
            nombreET.requestFocus();
        }

        if(aPaterno.isEmpty()){
            aPaternoET.setError("Apellidos requerido");
            aPaternoET.requestFocus();
        }

        if(edad.isEmpty()){
            edadET.setError("Edad requerida");
            edadET.requestFocus();
        }

        if(parentesco.isEmpty()){
            parentescoET.setError("Parentesco requerido");
            parentescoET.requestFocus();
        }

        if(!nombre.isEmpty() && !aPaterno.isEmpty() && !edad.isEmpty() && !parentesco.isEmpty()){

            final Loading loading = new Loading(FamilyActualiza.this);
            loading.iniciaDialogo("alert");

            TtCtClienteAutorizados_ objctCliAuto = new TtCtClienteAutorizados_();

            objctCliAuto.setiCliente(CarritoSingleton.getInstance().getCliente().getiCliente());
            objctCliAuto.setiAutorizado(iAutorizado);
            objctCliAuto.setcNombre(nombre);
            objctCliAuto.setcApellidos(aPaterno);
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
            final Call<Respuesta> call = service.ctClienteAutorizadosPut(peticion);
            //System.out.println(call.);

            call.enqueue(new Callback<Respuesta>() {
                @Override
                public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                    System.out.println(response.toString());
                    loading.detenDialogo("alert");

                    Toast.makeText(FamilyActualiza.this, "Registro Actualizado", Toast.LENGTH_LONG).show();
                    Intent inicio = new Intent(FamilyActualiza.this, FamilyListActivity.class);
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
        Intent regresa = new Intent(FamilyActualiza.this, HomeActivity.class);
        startActivity(regresa);
    }

    private void regresaPantalla() {
        Intent regresa = new Intent(FamilyActualiza.this, HomeActivity.class);
        startActivity(regresa);
    }
}
