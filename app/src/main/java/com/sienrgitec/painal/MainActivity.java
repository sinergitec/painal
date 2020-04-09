package com.sienrgitec.painal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sienrgitec.painal.constante.Constantes;
import com.sienrgitec.painal.pojo.error.Error;
import com.sienrgitec.painal.pojo.sesion.Session;
import com.sienrgitec.painal.servicio.Painal;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.sienrgitec.painal.R.id.email;
import static com.sienrgitec.painal.R.id.loginBtn;
import static com.sienrgitec.painal.R.id.password;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText usuario, contrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        btnLogin = findViewById(loginBtn);
        usuario = findViewById(email);
        contrasena = findViewById(password);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    public void login() {

        String usr = usuario.getText().toString();
        String pwd = contrasena.getText().toString();

        if(usr == null || usr.isEmpty()){
            usuario.setError("Usuario requerido");
            usuario.requestFocus();
        }

        if(pwd == null || pwd.isEmpty()){
            contrasena.setError("Contraseña requerida");
            contrasena.requestFocus();
        }

        if(usr != null && !usr.isEmpty() && pwd != null && !pwd.isEmpty()){
            Retrofit retro = new Retrofit.Builder()
                    .baseUrl(Constantes.URL_BASE_WS)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            final Painal sesion = retro.create(Painal.class);
            Call<Session> sesionCall = sesion.login(usr,pwd);
            sesionCall.enqueue(new Callback<Session>() {
                @Override
                public void onResponse(Call<Session> call, Response<Session> response) {
                    Session session = response.body();
                    if(session == null){
                        System.out.println("Sesion no iniciada");
                    } else {
                        System.out.println(session.toString());
                    }
                }

                @Override
                public void onFailure(Call<Session> call, Throwable t) {
                    System.out.println("Fallo el llamado al WS");
                    System.out.println(t.getMessage());
                }
            });

        } else
            return;
    }

}
