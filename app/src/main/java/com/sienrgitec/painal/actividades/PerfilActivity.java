package com.sienrgitec.painal.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sienrgitec.painal.R;

import static com.sienrgitec.painal.R.id.recupera;
import static com.sienrgitec.painal.R.id.textView13;
import static com.sienrgitec.painal.R.id.textView14;

public class PerfilActivity extends AppCompatActivity {

    private ImageView btnPerfil,btnDirecciones;
    private TextView btnPerfilText, btnDireccionesText, btnConsultaSaldo, btnEvaluaProv, btnEvaluaTitlani;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.perfil);

        btnPerfilText = findViewById(textView13);
        btnPerfilText.setOnClickListener(v -> editaPerfil());

        btnDireccionesText = findViewById(textView14);
        btnDireccionesText.setOnClickListener(v -> editaPerfil());

        btnPerfil = findViewById(R.id.imageView3);
        btnPerfil.setOnClickListener(v -> editaPerfil());

        btnConsultaSaldo = findViewById(R.id.textView15);
        btnConsultaSaldo.setOnClickListener(v -> consultaSaldo());

        btnConsultaSaldo = findViewById(R.id.textView15);
        btnConsultaSaldo.setOnClickListener(v -> evaluaProv());

        btnEvaluaProv = findViewById(R.id.textView9);
        btnEvaluaProv.setOnClickListener(v -> evaluaTitlani());


    }

    private void editaPerfil() {
        Intent perfil = new Intent(PerfilActivity.this, PerfilActualizaActivity.class);
        startActivity(perfil);
    }

    private void consultaSaldo(){
        Intent getSaldo = new Intent (PerfilActivity.this, SaldosActivity.class);
        startActivity(getSaldo);

    }

    private void evaluaTitlani() {

    }

    private void evaluaProv() {

    }
}
