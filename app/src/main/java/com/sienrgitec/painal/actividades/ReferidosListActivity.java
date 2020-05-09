package com.sienrgitec.painal.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.sienrgitec.painal.MainActivity;
import com.sienrgitec.painal.R;

import static com.sienrgitec.painal.R.id.agregar;
import static com.sienrgitec.painal.R.id.recupera;
import static com.sienrgitec.painal.R.id.referidos;

public class ReferidosListActivity extends AppCompatActivity {

    private ImageView btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_referidos);

        btnAgregar = findViewById(agregar);
        btnAgregar.setOnClickListener(v -> agregarReferidos());
    }

    private void agregarReferidos() {
        Intent ref = new Intent(ReferidosListActivity.this, ReferidosActivity.class);
        startActivity(ref);
    }
}
