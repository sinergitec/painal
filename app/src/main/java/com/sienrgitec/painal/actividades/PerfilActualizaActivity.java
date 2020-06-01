package com.sienrgitec.painal.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.carrito.CarritoSingleton;
import com.sienrgitec.painal.componente.Loading;
import com.sienrgitec.painal.pojo.carrito.Carrito;
import com.sienrgitec.painal.pojo.entity.TtCtCliente_;
import com.sienrgitec.painal.pojo.entity.TtCtTelefono_;
import com.sienrgitec.painal.pojo.entity.TtCtUsuario_;
import com.sienrgitec.painal.pojo.peticion.DsCtCliente;
import com.sienrgitec.painal.pojo.peticion.Peticion;
import com.sienrgitec.painal.pojo.peticion.Request;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.sienrgitec.painal.R.id.apellidoP;
import static com.sienrgitec.painal.R.id.descripcion;
import static com.sienrgitec.painal.R.id.email;
import static com.sienrgitec.painal.R.id.password;
import static com.sienrgitec.painal.R.id.telefono;

public class PerfilActualizaActivity extends AppCompatActivity {

    private Button btnRegistro;
    private EditText nombreET, aPaternoET, aMaternoET, correoET, pwET, telefonoET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil_actualiza);

        nombreET   = findViewById(descripcion);
        aPaternoET = findViewById(apellidoP);
        correoET   = findViewById(email);
        telefonoET = findViewById(telefono);

        btnRegistro = findViewById(R.id.registroBtn);
        btnRegistro.setOnClickListener(v -> actualizaCliente());

        nombreET.setText(CarritoSingleton.getInstance().getCliente().getcNombre());
        aPaternoET.setText(CarritoSingleton.getInstance().getCliente().getcApellidos());
        correoET.setText(CarritoSingleton.getInstance().getCliente().getcEmail());
        telefonoET.setText(CarritoSingleton.getInstance().getTelefono().getcTelefono());

        System.out.println("cliente" + CarritoSingleton.getInstance().getCliente().getiCliente());

    }

    private void actualizaCliente() {

        final Loading loading = new Loading(PerfilActualizaActivity.this);
        loading.iniciaDialogo("alert");

        String nombre   = nombreET.getText().toString();
        String aPaterno = aPaternoET.getText().toString();
        String correo   = correoET.getText().toString();
        String telefono = telefonoET.getText().toString();


        if(nombre.isEmpty()){
            nombreET.setError("Nombre requerido");
            nombreET.requestFocus();
            loading.detenDialogo("alert");
        }

        if(aPaterno.isEmpty()){
            aPaternoET.setError("Apellido Paterno requerido");
            aPaternoET.requestFocus();
            loading.detenDialogo("alert");
        }

        if(!nombre.isEmpty() && !aPaterno.isEmpty() && !correo.isEmpty() && !telefono.isEmpty()){

            TtCtCliente_ objctCliente = new TtCtCliente_();

            objctCliente.setiCliente(CarritoSingleton.getInstance().getCliente().getiCliente());
            objctCliente.setcClave(CarritoSingleton.getInstance().getCliente().getcClave());

            CarritoSingleton.getInstance().getCliente().setcNombre(nombre);
            CarritoSingleton.getInstance().getCliente().setcApellidos(aPaterno);
            objctCliente.setcNombre(CarritoSingleton.getInstance().getCliente().getcNombre());
            objctCliente.setcApellidos(CarritoSingleton.getInstance().getCliente().getcApellidos());
            objctCliente.setDtRegistro(CarritoSingleton.getInstance().getCliente().getDtRegistro());
            objctCliente.setDtUltCompra(CarritoSingleton.getInstance().getCliente().getDtUltCompra());
            objctCliente.setDeUltCompra(CarritoSingleton.getInstance().getCliente().getDeUltCompra());
            objctCliente.setDePorcUltComision(CarritoSingleton.getInstance().getCliente().getDePorcUltComision());
            objctCliente.setDeUltCompra(CarritoSingleton.getInstance().getCliente().getDeUltCompra());
            objctCliente.setDePorcUltPropina(CarritoSingleton.getInstance().getCliente().getDePorcUltPropina());
            objctCliente.setDeUltPropina(CarritoSingleton.getInstance().getCliente().getDeUltPropina());
            objctCliente.setICPCP(CarritoSingleton.getInstance().getCliente().getICPCP());
            objctCliente.setcEmail(CarritoSingleton.getInstance().getCliente().getcEmail());
            objctCliente.setDtCreado(CarritoSingleton.getInstance().getCliente().getDtCreado());
            objctCliente.setDtModificado(CarritoSingleton.getInstance().getCliente().getDtModificado());
            objctCliente.setcUsuCrea(CarritoSingleton.getInstance().getCliente().getcUsuCrea());
            objctCliente.setcUsuModifica(CarritoSingleton.getInstance().getCliente().getcUsuModifica());


            Peticion peticion = new Peticion(new Request(new DsCtCliente(new ArrayList<TtCtCliente_>() {
                {
                    add(objctCliente);
                }
            }), 0));



            final Painal service = ServiceGenerator.createService(Painal.class);
            final Call<Respuesta> call = service.ctClientePut(peticion);
            //System.out.println(call.);

            call.enqueue(new Callback<Respuesta>() {
                @Override
                public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                    loading.detenDialogo("alert");
                    if(response.isSuccessful()){
                        Respuesta res = response.body();

                        if(res.getResponse().getOplError().equals("true")){
                            Toast.makeText(PerfilActualizaActivity.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                            return;
                        }
                        else{
                            Toast.makeText(PerfilActualizaActivity.this, "Registro Actualizado", Toast.LENGTH_LONG).show();
                            Intent perfil = new Intent(PerfilActualizaActivity.this, PerfilActivity.class);
                            startActivity(perfil);
                        }
                    }else{
                        Toast.makeText(PerfilActualizaActivity.this, response.message(), Toast.LENGTH_LONG).show();
                    }
                    System.out.println(response.toString());
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
