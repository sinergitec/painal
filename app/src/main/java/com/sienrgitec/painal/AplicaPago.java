package com.sienrgitec.painal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AplicaPago extends AppCompatActivity {

    private TextView etContacto, etDomicilio, etMonto;
    private Button btnPagar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aplica_pago);

        etContacto  = findViewById (R.id.textView28);
        etDomicilio = findViewById(R.id.textView29);
        etMonto     = findViewById(R.id.textView25);
        btnPagar    = findViewById(R.id.btnPagoF);

    }
}