package com.sienrgitec.painal.actividades;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.carrito.CarritoSingleton;
import com.sienrgitec.painal.componente.recycler.ListaDomicilioAdapter;

public class ListaDomicilioActivity extends AppCompatActivity {

    private RecyclerView rvListaDomicilios;
    private Button ubicacionActual;
    private View fragmentMapa;
    private boolean banderaMostrarMapa = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_direcciones);

        ubicacionActual = findViewById(R.id.ubicacionActual);
        rvListaDomicilios = findViewById(R.id.rvListaDomicilios);
        fragmentMapa = findViewById(R.id.fragmentMapa);
        LinearLayoutManager llm = new LinearLayoutManager(ListaDomicilioActivity.this);
        rvListaDomicilios.setLayoutManager(llm);
        ListaDomicilioAdapter listaDomicilioAdapter = new ListaDomicilioAdapter(ListaDomicilioActivity.this,null);
        listaDomicilioAdapter.setList(CarritoSingleton.getInstance().getDomicilio());
        rvListaDomicilios.setAdapter(listaDomicilioAdapter);
        fragmentMapa.setVisibility(View.INVISIBLE);

        ubicacionActual.setOnClickListener(v -> {
            if(!banderaMostrarMapa){
                fragmentMapa.setVisibility(View.VISIBLE);
                banderaMostrarMapa = true;
            } else {
                fragmentMapa.setVisibility(View.INVISIBLE);
                banderaMostrarMapa = false;
            }
        });

    }

}
