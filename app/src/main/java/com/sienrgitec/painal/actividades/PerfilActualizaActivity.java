package com.sienrgitec.painal.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sienrgitec.painal.MainActivity;
import com.sienrgitec.painal.R;
import com.sienrgitec.painal.componente.Loading;
import com.sienrgitec.painal.pojo.entity.TtCtCliente_;
import com.sienrgitec.painal.pojo.entity.TtCtTelefono;
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

import static com.sienrgitec.painal.R.id.apellidoM;
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
        pwET       = findViewById(password);
        telefonoET = findViewById(telefono);

        btnRegistro = findViewById(R.id.registroBtn);
        btnRegistro.setOnClickListener(v -> actualizaCliente());

    }

    private void actualizaCliente() {

        final Loading loading = new Loading(PerfilActualizaActivity.this);
        loading.iniciaDialogo("alert");

        String nombre   = nombreET.getText().toString();
        String aPaterno = aPaternoET.getText().toString();
        String correo   = correoET.getText().toString();
        String pw       = pwET.getText().toString();
        String telefono = telefonoET.getText().toString();


        if(nombre.isEmpty()){
            nombreET.setError("Nombre requerido");
            nombreET.requestFocus();
        }

        if(aPaterno.isEmpty()){
            aPaternoET.setError("Apellido Paterno requerido");
            aPaternoET.requestFocus();
        }

        if(correo.isEmpty()){
            correoET.setError("Correo requerido");
            correoET.requestFocus();
        }

        if(pw.isEmpty()){
            pwET.setError("Contraseña requerido");
            pwET.requestFocus();
        }

        if(telefono.isEmpty()){
            telefonoET.setError("Telefono requerido");
            telefonoET.requestFocus();
        }


        if(!nombre.isEmpty() && !aPaterno.isEmpty() && !correo.isEmpty() && !pw.isEmpty() && !telefono.isEmpty()){

            TtCtCliente_ objctCliente = new TtCtCliente_();

            objctCliente.setcClave("");
            objctCliente.setcNombre(nombre);
            objctCliente.setcApellidos(aPaterno);
            objctCliente.setDtRegistro(null);
            objctCliente.setDtUltCompra(null);
            objctCliente.setDeUltCompra(null);
            objctCliente.setDePorcUltComision(null);
            objctCliente.setDeUltCompra(null);
            objctCliente.setDePorcUltPropina(null);
            objctCliente.setDeUltPropina(null);
            objctCliente.setICPCP(null);
            objctCliente.setcEmail(correo);
            objctCliente.setDtCreado(null);
            objctCliente.setDtModificado(null);
            objctCliente.setcUsuCrea("");
            objctCliente.setcUsuModifica("");

            TtCtUsuario_ ObjctUsuario = new TtCtUsuario_();
            ObjctUsuario.setcUsuario(correo);
            ObjctUsuario.setcPassword(pw);
            ObjctUsuario.setiPersona(0);
            ObjctUsuario.setiTipoPersona(5);
            ObjctUsuario.setlActivo(true);
            ObjctUsuario.setDtCreado(null);
            ObjctUsuario.setDtModificado(null);
            ObjctUsuario.setUsuarioC("");


            TtCtTelefono objctTelefono = new TtCtTelefono();

            objctTelefono.setiPersona(0);
            objctTelefono.setiTelefono(0);
            objctTelefono.setiTipoPersona(5);
            objctTelefono.setiTipoTelefono(1);
            objctTelefono.setcTelefono(telefono);
            objctTelefono.setlActivo(true);
            objctTelefono.setDtCreado(null);
            objctTelefono.setDtModificado(null);
            objctTelefono.setcUsuCrea(null);
            objctTelefono.setcUsuModifica(null);

            Peticion peticion = new Peticion(new Request(new DsCtCliente(new ArrayList<TtCtCliente_>() {
                {
                    add(objctCliente);
                }
            }, new ArrayList<TtCtUsuario_>() {
                {
                    add(ObjctUsuario);
                }
            }, new ArrayList<TtCtTelefono>() {
                {
                    add(objctTelefono);
                }
            } )));



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

                        Toast.makeText(PerfilActualizaActivity.this, "Usuario Creado" + " " + nombre, Toast.LENGTH_LONG).show();

                        Intent inicio = new Intent(PerfilActualizaActivity.this, MainActivity.class);
                        inicio.putExtra("usuario", correo);
                        inicio.putExtra("password", pw);
                        startActivity(inicio);

                    }else{
                        Toast.makeText(PerfilActualizaActivity.this, "No se pudo actualizar el usuario", Toast.LENGTH_LONG).show();
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
