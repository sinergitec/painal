package com.sienrgitec.painal.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.sienrgitec.painal.R;

import static com.sienrgitec.painal.R.id.agregar;

public class ContactoListActivity extends AppCompatActivity {

    private ImageView btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_contacto);



        btnAgregar = findViewById(agregar);
        btnAgregar.setOnClickListener(v -> agregarContacto());
    }

    private void agregarContacto() {
        Intent cont = new Intent(ContactoListActivity.this, ContactoActivity.class);
        startActivity(cont);
    }
}
