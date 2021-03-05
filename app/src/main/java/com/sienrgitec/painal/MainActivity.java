package com.sienrgitec.painal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sienrgitec.painal.actividades.HomeActivity;
import com.sienrgitec.painal.actividades.IngresaPasswordActivity;
import com.sienrgitec.painal.actividades.RegistroActivity;
import com.sienrgitec.painal.carrito.CarritoSingleton;
import com.sienrgitec.painal.componente.Loading;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.sienrgitec.painal.R.id.email;
import static com.sienrgitec.painal.R.id.loginBtn;
import static com.sienrgitec.painal.R.id.password;
import static com.sienrgitec.painal.R.id.registro;
import static com.sienrgitec.painal.R.id.recupera;
import static com.sienrgitec.painal.constante.Constantes.vdeSaldo;
import static com.sienrgitec.painal.constante.Constantes.vcUrlImg;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText usernameET, passwordET;
    private TextView btnRegistro, btnRecupera;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        btnLogin = findViewById(loginBtn);
        usernameET  = findViewById(email);
        passwordET  = findViewById(password);
        btnRegistro = findViewById(registro);
        btnLogin.setOnClickListener(v -> login());
        btnRegistro.setOnClickListener(v -> registrate());
        btnRecupera = findViewById(recupera);
        btnRecupera.setOnClickListener(v -> recuperaPassword());

        Intent i = getIntent();
        String usuario = (String) i.getSerializableExtra("usuario");
        String password = (String) i.getSerializableExtra("password");

        if(usuario != null && !usuario.equals("") && password != null && !password.equals("")){
            usernameET.setText(usuario);
            passwordET.setText(password);
        }

    }

    public void login() {
        final Loading loading = new Loading(MainActivity.this);
        loading.iniciaDialogo("alert");
        String usr = usernameET.getText().toString();
        String pwd = passwordET.getText().toString();

        Double vdeSaldoCli = 0.00;

        if(usr.isEmpty()){
            usernameET.setError("Usuario requerido");
            usernameET.requestFocus();
        }

        if(pwd.isEmpty()){
            passwordET.setError("Contraseña requerida");
            passwordET.requestFocus();
        }

        if(!usr.isEmpty() && !pwd.isEmpty()){

            final Painal service = ServiceGenerator.createService(Painal.class);
            Map<String, String> data = new HashMap<>();
            data.put("ipcUsuario", usr);
            data.put("ipcPassword", pwd);
            final Call<Respuesta> call = service.login(data);
            call.enqueue(new Callback<Respuesta>() {
                @Override
                public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                    Respuesta res = response.body();
                    loading.detenDialogo("alert");
                    if(response.isSuccessful()) {
                        if (res.getResponse().getOplError().equals("true"))
                            Toast.makeText(MainActivity.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                        else {
                            if (res.getResponse().getTtCtUsuario() != null
                                    && res.getResponse().getTtCtUsuario().getTtCtUsuario().size() > 0) {

                                Toast.makeText(MainActivity.this,
                                        "BIENVENIDO " + res.getResponse().getTtCtUsuario().getTtCtUsuario().get(0).getcUsuario(),
                                        Toast.LENGTH_LONG).show();

                                CarritoSingleton.getInstance().setCliente
                                        (res.getResponse().getTtCtCliente().getTtCtCliente_().get(0));
                                CarritoSingleton.getInstance().setUsuario_
                                        (res.getResponse().getTtCtUsuario().getTtCtUsuario().get(0));

                                if(!res.getResponse().getTtCtTelefono().getTtCtTelefono().isEmpty()){
                                    CarritoSingleton.getInstance().setTelefono
                                            (res.getResponse().getTtCtTelefono().getTtCtTelefono().get(0));
                                }

                                if(!res.getResponse().getTt_ctDomicilio().getTt_ctDomicilio().isEmpty()){

                                    CarritoSingleton.getInstance().setDomicilio
                                            (res.getResponse().getTt_ctDomicilio().getTt_ctDomicilio());

                                    CarritoSingleton.getInstance().setDomicilioActual
                                            (res.getResponse().getTt_ctDomicilio().getTt_ctDomicilio().get(0));
                                }

                                vdeSaldo = res.getResponse().getOpdeSaldo();
                                vcUrlImg = res.getResponse().getOpcUrlImg();

                                Intent inicio = new Intent(MainActivity.this, HomeActivity.class);
                                startActivity(inicio);
                            }
                        }
                    }else{
                        Toast.makeText(MainActivity.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<Respuesta> call, Throwable t) {
                    Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
                    loading.detenDialogo("alert");
                }
            });
        } else
            return;
    }

    private void registrate() {
        Toast.makeText(MainActivity.this, "Trasladando a pantalla de Registro", Toast.LENGTH_LONG).show();

        Intent registrarse = new Intent(MainActivity.this, RegistroActivity.class);
        startActivity(registrarse);
    }

    private void recuperaPassword() {
        Toast.makeText(MainActivity.this, "Trasladando a pantalla de Recupera Contraseña", Toast.LENGTH_LONG).show();

        Intent ingresaPw = new Intent(MainActivity.this, IngresaPasswordActivity.class);
        startActivity(ingresaPw);
    }
}
