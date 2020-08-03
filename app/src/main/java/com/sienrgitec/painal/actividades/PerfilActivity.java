package com.sienrgitec.painal.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sienrgitec.painal.R;

import static com.sienrgitec.painal.R.id.textView13;
import static com.sienrgitec.painal.R.id.textView14;

public class PerfilActivity extends AppCompatActivity {

    private ImageView btnPerfil,btnDirecciones, btnSaldo;
    private TextView btnPerfilText, btnDireccionesText, btnConsultaSaldo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil);

        btnPerfilText = findViewById(textView13);
        btnPerfilText.setOnClickListener(v -> editaPerfil());

        btnDireccionesText = findViewById(textView14);
        btnDireccionesText.setOnClickListener(v -> editaDireccion());

        btnDirecciones = findViewById(R.id.imageView5);
        btnDirecciones.setOnClickListener(v -> editaDireccion());

        btnPerfil = findViewById(R.id.imageView3);
        btnPerfil.setOnClickListener(v -> editaPerfil());

        btnSaldo = findViewById(R.id.imageView6);
        btnSaldo.setOnClickListener(v -> consultaSaldo());

        btnConsultaSaldo = findViewById(R.id.textView15);
        btnConsultaSaldo.setOnClickListener(v -> consultaSaldo());
    }

    private void editaDireccion() {
        Intent direccion = new Intent(PerfilActivity.this, ListaDomicilioActivity.class);
        startActivity(direccion);
    }

    private void editaPerfil() {
        Intent perfil = new Intent(PerfilActivity.this, PerfilActualizaActivity.class);
        startActivity(perfil);
    }

    private void consultaSaldo(){
        Intent getSaldo = new Intent (PerfilActivity.this, SaldosActivity.class);
        startActivity(getSaldo);

    }
}

