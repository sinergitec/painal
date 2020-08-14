package com.sienrgitec.painal.actividades;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.text.SpannableString;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.sienrgitec.painal.MainActivity;
import com.sienrgitec.painal.R;
import com.sienrgitec.painal.carrito.CarritoSingleton;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.sienrgitec.painal.R.id.textView13;
import static com.sienrgitec.painal.R.id.textView14;


public class PerfilActivity extends AppCompatActivity {

    private ImageView btnPerfil,btnDirecciones, btnSaldo, regreso, back, home;
    private TextView btnPerfilText, btnDireccionesText, btnConsultaSaldo;
    public String email = "";

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil);

        back = findViewById(R.id.back);
        back.setOnClickListener(v -> regresaPantalla());

        home = findViewById(R.id.imageView7);
        home.setOnClickListener(v -> pantallaHome());


        regreso = findViewById(R.id.regresa);
        regreso.setOnClickListener(v -> consultaSaldo());

        btnPerfilText = findViewById(textView13);
        btnPerfilText.setOnClickListener(v -> editaPerfil());

        btnDireccionesText = findViewById(textView14);
        btnDireccionesText.setOnClickListener(v -> editaDireccion());

        btnDirecciones = findViewById(R.id.imageView5);
        btnDirecciones.setOnClickListener(v -> editaDireccion());

        btnPerfil = findViewById(R.id.imageView3);
        btnPerfil.setOnClickListener(v -> editaPerfil());

        btnSaldo = findViewById(R.id.regresa);
        btnSaldo.setOnClickListener(v -> consultaSaldo());

        btnConsultaSaldo = findViewById(R.id.textView15);
        btnConsultaSaldo.setOnClickListener(v -> consultaSaldo());
    }

    private void pantallaHome() {
        Intent regresa = new Intent(PerfilActivity.this, HomeActivity.class);
        startActivity(regresa);
    }

    private void regresaPantalla() {
        Intent regresa = new Intent(PerfilActivity.this, HomeActivity.class);
        startActivity(regresa);
    }

    private void editaDireccion() {
        Intent direccion = new Intent(PerfilActivity.this, ListaDomicilioActivity.class);
        startActivity(direccion);
    }

    private void editaPerfil() {
        /**AndrosOHG-14/08/2020**/
        AlertDialog.Builder builder = new AlertDialog.Builder(PerfilActivity.this);
        builder.setTitle("Captura tu contraseña");

        final EditText password = new EditText(PerfilActivity.this);

        password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        builder.setView(password);


        builder.setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                email = password.getText().toString();

                if(password.getText().toString().isEmpty()){
                    Toast.makeText(PerfilActivity.this, "No se pyuede continuar.Debe capturar contraseña" , Toast.LENGTH_SHORT).show();
                    return;
                } else{

                    Log.e("else" ,"Validando contraseña");
                    BuscaContraseña(email);
                }
            }
        });
        builder.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }

    private void consultaSaldo(){
        Intent getSaldo = new Intent (PerfilActivity.this, SaldosActivity.class);
        startActivity(getSaldo);

    }

    private void BuscaContraseña(String vcPassword){

      /****/

        final Painal service = ServiceGenerator.createService(Painal.class);
        Map<String, String> data = new HashMap<>();
        data.put("ipcUsuario", String.valueOf(CarritoSingleton.getInstance().getCliente().getcEmail()));
        data.put("ipcPassword",vcPassword);

        final Call<Respuesta> call = service.ValidaPwCli(data);
        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                Respuesta res = response.body();

                if (response.isSuccessful()) {
                    if (res.getResponse().getOplError().equals("true")) {
                        Toast.makeText(PerfilActivity.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                        return;
                    }else {
                       Log.e("PerfilActivity", "pw correcto");
                        Intent perfil = new Intent(PerfilActivity.this, PerfilActualizaActivity.class);
                        startActivity(perfil);
                    }
                } else {
                    Toast.makeText(PerfilActivity.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {
                Toast.makeText(PerfilActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }
}

