package com.sienrgitec.painal.actividades;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.carrito.CarritoSingleton;
import com.sienrgitec.painal.pojo.carrito.Carrito;
import com.sienrgitec.painal.pojo.entity.TtCtArtProveedor_;

public class ArticuloDetalleActivity extends AppCompatActivity {

    private TextView nombreArticulo;
    private EditText descripcionArticulo, etObs, etPresentacion;
    private Button precioPieza;
    private Button precioGranel;
    private Button agregarElemento;
    private Button quitarElemento;
    private TextView cantidadArticulo;
    private Button agregarCarrito;

    private Integer contadorPza = 0;
    private Double contadorGranel = 0.0;
    private boolean banderaContador = false;
    private Double saltoContadorGranel = 0.0;

    TtCtArtProveedor_ articulo = new TtCtArtProveedor_();


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.articulo_detalle);


        nombreArticulo = findViewById(R.id.articulo);
        descripcionArticulo = findViewById(R.id.descripcion);
        precioPieza = findViewById(R.id.piezas);
        precioGranel = findViewById(R.id.granel);
        cantidadArticulo = findViewById(R.id.cantidadArticulo);
        agregarElemento = findViewById(R.id.agregar);
        quitarElemento = findViewById(R.id.quitar);
        agregarCarrito = findViewById(R.id.agregar2);

        etObs = findViewById(R.id.observaciones);
        etPresentacion = findViewById(R.id.etPresentacion);

        Intent i = getIntent();
        articulo = (TtCtArtProveedor_) i.getSerializableExtra("articulo");
        nombreArticulo.setText(articulo.getCDescripcion());
        descripcionArticulo.setText(articulo.getCDescripcion());
        etPresentacion.setText("Presentacion: " + articulo.getCPresentacion());
        saltoContadorGranel = articulo.getDeGramosPieza();
        actualizaCantidadArticulo();

        precioPieza.setOnClickListener(v -> {
            cambiaBackground(precioPieza, R.drawable.pieza_granel_borders);
            precioGranel.setBackgroundResource(0);
            banderaContador = false;
            actualizaCantidadArticulo();
        });

        precioGranel.setOnClickListener(v -> {
            cambiaBackground(precioGranel, R.drawable.pieza_granel_borders);
            precioPieza.setBackgroundResource(0);
            banderaContador = true;
            actualizaCantidadArticulo();
        });

        agregarElemento.setOnClickListener(v -> {
            sumaCantidadArticulo();
            actualizaCantidadArticulo();
        });

        quitarElemento.setOnClickListener(v -> {
            restaCantidadArticulo();
            actualizaCantidadArticulo();
        });

        agregarCarrito.setOnClickListener(v -> {
            String vcObsArt = etObs.getText().toString();
            Carrito carrito = new Carrito(articulo, banderaContador ? contadorGranel : contadorPza, articulo.getDePrecioVtaPza(),
                    banderaContador ? "g" : "pz", vcObsArt);

            Log.e("Piezas , ", "Piezas " + contadorPza);
            carrito.setMonto(contadorPza * carrito.getMonto());
            carrito.setObs(etObs.getText().toString());
            CarritoSingleton.getInstance().agregaCarrito(v.getContext(), carrito);
        });

    }

    private void actualizaCantidadArticulo(){
        cantidadArticulo.setText(banderaContador ? (contadorGranel.toString() + " g") : contadorPza.toString());
    }

    private void sumaCantidadArticulo(){
        this.contadorPza += 1;
        this.contadorGranel += this.saltoContadorGranel;
    }

    private void restaCantidadArticulo(){
        if(contadorPza > 0)
            this.contadorPza -= 1;

        if(contadorGranel > 0.0)
            this.contadorGranel -= this.saltoContadorGranel;
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
