package com.sienrgitec.painal.actividades;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.componente.Loading;
import com.sienrgitec.painal.constante.Constantes;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.sienrgitec.painal.R.id.consulta;
import static com.sienrgitec.painal.R.id.recupera;

public class IngresaPasswordActivity extends AppCompatActivity {
    private Button btnConsulta;
    private EditText password;
    Constantes constantes;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recupera_pw);
        password  = findViewById(R.id.correo);
        btnConsulta = findViewById(consulta);
        btnConsulta.setOnClickListener(v -> recuperaPassword());
    }

    private void recuperaPassword() {

        final Loading loading = new Loading(IngresaPasswordActivity.this);
        loading.iniciaDialogo("alert");

        String usr = password.getText().toString();

        System.out.println("usuario" + usr);

        if (usr.isEmpty()) {
            password.setError("Correo requerido");
            password.requestFocus();
        } else {
            final Painal service = ServiceGenerator.createService(Painal.class);
            Map<String, String> data = new HashMap<>();
            data.put("ipcEmail", usr);
            data.put("ipcPersona","cliente");
            final Call<Respuesta> call = service.recuperapw(data);
            call.enqueue(new Callback<Respuesta>() {
                @Override
                public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                    loading.detenDialogo("alert");
                    Respuesta res = response.body();
                    if(response.isSuccessful()) {
                        if (res.getResponse().getOplError().equals("true"))
                            openDialog(res);
                        else {
                            if (res.getResponse().getTtCtUsuario() != null
                                    && res.getResponse().getTtCtUsuario().getTtCtUsuario().size() > 0) {
                                openDialog1(res);

                            }

                        }
                    }else{
                        openDialog2(res);
                    }
                }

                private void openDialog(Respuesta res) {
                    RecuperaPassword recuperaPassword = new RecuperaPassword(res.getResponse().getOpcError(),"");
                    recuperaPassword.show(getSupportFragmentManager(),null);
                }

                private void openDialog1(Respuesta res) {
                    RecuperaPassword recuperaPassword = new RecuperaPassword(res.getResponse().getTtCtUsuario().getTtCtUsuario().get(0).getcPassword(),
                            res.getResponse().getTtCtUsuario().getTtCtUsuario().get(0).getcUsuario());
                    recuperaPassword.show(getSupportFragmentManager(), null);
                }

                private void openDialog2(Respuesta res) {
                    RecuperaPassword recuperaPassword = new RecuperaPassword(res.getResponse().getOpcError(),"");
                    recuperaPassword.show(getSupportFragmentManager(),null);
                }

                @Override
                public void onFailure(Call<Respuesta> call, Throwable t) {
                    loading.detenDialogo("alert");
                    RecuperaPassword recuperaPassword = new RecuperaPassword(t.getMessage(),"");
                    recuperaPassword.show(getSupportFragmentManager(),null);
                }
            });
        }
    }
}
