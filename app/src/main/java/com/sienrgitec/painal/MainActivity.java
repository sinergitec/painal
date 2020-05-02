package com.sienrgitec.painal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sienrgitec.painal.actividades.HomeActivity;
import com.sienrgitec.painal.actividades.RecuperaPassword;
import com.sienrgitec.painal.actividades.RegistroActivity;
import com.sienrgitec.painal.componente.Loading;
import com.sienrgitec.painal.constante.Constantes;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.pojo.sesion.Session;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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

            final Loading loading = new Loading(MainActivity.this);
            loading.iniciaDialogo("alert");

            final Retrofit retro = new Retrofit.Builder()
                    .baseUrl(Constantes.URL_BASE_WS)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            final Painal session = retro.create(Painal.class);
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
            });

        } else
            return;
    }

    private void registrate() {
        Intent registrarse = new Intent(MainActivity.this, RegistroActivity.class);
        startActivity(registrarse);
    }


    private void recuperaPassword() {
        openDialog();
    }

    private void openDialog() {

        RecuperaPassword recuperaPassword = new RecuperaPassword();
        recuperaPassword.show(getSupportFragmentManager(),"Recupera Contraseña");

    }
}
