package com.sienrgitec.painal.actividades;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.pojo.entity.TtCtArtProveedor_;

public class ArticuloDetalleActivity extends AppCompatActivity {

    private TextView nombreArticulo;
    private EditText descripcionArticulo;
    private Button precioPieza;
    private Button precioGranel;
    private EditText cantidadArticulo;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.articulo_detalle);

        nombreArticulo = findViewById(R.id.articulo);
        descripcionArticulo = findViewById(R.id.descripcion);
        precioPieza = findViewById(R.id.piezas);
        precioGranel = findViewById(R.id.granel);
        cantidadArticulo = findViewById(R.id.cantidadProducto);

        Intent i = getIntent();
        TtCtArtProveedor_ articulo = (TtCtArtProveedor_) i.getSerializableExtra("articulo");
        nombreArticulo.setText(articulo.getCDescripcion());
        descripcionArticulo.setText(articulo.getCDescripcion());

        precioPieza.setOnClickListener(v -> {
            cambiaBackground(precioPieza, R.drawable.pieza_granel_borders);
            precioGranel.setBackgroundResource(0);
        });

        precioGranel.setOnClickListener(v -> {
            cambiaBackground(precioGranel, R.drawable.pieza_granel_borders);
            precioPieza.setBackgroundResource(0);
        });



    }

    private void cambiaBackground(Button boton, int drawable){
        final int sdk = android.os.Build.VERSION.SDK_INT;
        if(sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            boton.setBackgroundDrawable(ContextCompat.getDrawable(ArticuloDetalleActivity.this, drawable));
        } else {
            boton.setBackground(ContextCompat.getDrawable(ArticuloDetalleActivity.this, drawable));
        }
    }

}
