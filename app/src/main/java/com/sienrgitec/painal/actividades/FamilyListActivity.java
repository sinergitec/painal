package com.sienrgitec.painal.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.sienrgitec.painal.R;

import static com.sienrgitec.painal.R.id.agregar;

public class FamilyListActivity  extends AppCompatActivity {

    private ImageView btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_family);

        btnAgregar = findViewById(agregar);
        btnAgregar.setOnClickListener(v -> agregarFamilia());
    }

    private void agregarFamilia() {
        Intent cont = new Intent(FamilyListActivity.this, FamilyActivity.class);
        startActivity(cont);
    }
}
