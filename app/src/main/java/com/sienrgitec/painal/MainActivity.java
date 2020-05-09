package com.sienrgitec.painal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
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
    }

    public void login() {
        final Loading loading = new Loading(MainActivity.this);
        loading.iniciaDialogo("alert");
        String usr = usernameET.getText().toString();
        String pwd = passwordET.getText().toString();

        if(usr.isEmpty()){
            usernameET.setError("Usuario requerido");
            usernameET.requestFocus();
        }

        if(pwd.isEmpty()){
            passwordET.setError("Contraseña requerida");
            passwordET.requestFocus();
        }

        if(!usr.isEmpty() && !pwd.isEmpty()){
            /*final Retrofit retro = new Retrofit.Builder()
                    .baseUrl(Constantes.URL_BASE_WS)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();*/

            /* final Painal session = retro.create(Painal.class);
            final Call<Session> sessionCall = session.login(usr,pwd);
            sessionCall.enqueue(new Callback<Session>() {
                @Override
                public void onResponse(Call<Session> call, Response<Session> response) {
                    loading.detenDialogo("alert");
                    final Session session = response.body();
                    if(session == null){
                        Toast.makeText(MainActivity.this, getString(R.string.msgErrorLogin), Toast.LENGTH_LONG).show();
                    } else {
                        Intent vistaNueva = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(vistaNueva);
                    }
                }

                @Override
                public void onFailure(Call<Session> call, Throwable t) {
                    loading.detenDialogo("alert");
                    Toast.makeText(MainActivity.this, getString(R.string.msgErrorWSLogin), Toast.LENGTH_LONG).show();
                }
            });*/

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
        Intent registrarse = new Intent(MainActivity.this, RegistroActivity.class);
        startActivity(registrarse);
    }

    private void recuperaPassword() {
        Intent ingresaPw = new Intent(MainActivity.this, IngresaPasswordActivity.class);
        startActivity(ingresaPw);
    }
}
