package com.sienrgitec.painal.actividades;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.sienrgitec.painal.R;

import static com.sienrgitec.painal.R.id.email;
import static com.sienrgitec.painal.R.id.loginBtn;
import static com.sienrgitec.painal.R.id.password;

public class RegistroActivity extends AppCompatActivity {

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("Dentro de registro");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro_usuario);

    }


}
