package com.sienrgitec.painal.actividades;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.sienrgitec.painal.R;

import static com.sienrgitec.painal.R.id.apellidoM;
import static com.sienrgitec.painal.R.id.apellidoP;
import static com.sienrgitec.painal.R.id.email;
import static com.sienrgitec.painal.R.id.nombre;
import static com.sienrgitec.painal.R.id.password;
import static com.sienrgitec.painal.R.id.telefono;


public class RegistroActivity extends AppCompatActivity {

    private Button btnRegistro;
    private EditText nombreET, aPaternoET, aMaternoET, correoET, pwET, telefonoET;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("Dentro de registro");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_usuario);

        nombreET   = findViewById(nombre);
        aPaternoET = findViewById(apellidoP);
        aMaternoET = findViewById(apellidoM);
        correoET   = findViewById(email);
        pwET       = findViewById(password);
        telefonoET = findViewById(telefono);

        btnRegistro = findViewById(R.id.registroBtn);
        btnRegistro.setOnClickListener(v -> registraCliente());

    }

    private void registraCliente() {
        String nombre   = nombreET.getText().toString();
        String aPaterno = aPaternoET.getText().toString();
        String aMaterno = aMaternoET.getText().toString();
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

        if(aMaterno.isEmpty()){
            aMaternoET.setError("Apellido Materno requerido");
            aMaternoET.requestFocus();
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


        if(!nombre.isEmpty() && !aPaterno.isEmpty() && !aMaterno.isEmpty() && !correo.isEmpty() && !pw.isEmpty() && !telefono.isEmpty()){

        }

        System.out.println("nombre" + nombre);
        System.out.println("aPaterno" + aPaterno);
        System.out.println("aMaterno" + aMaterno);
        System.out.println("correo" + correo);
        System.out.println("pw" + pw);
        System.out.println("telefono" + telefono);

    }
}
