package com.sienrgitec.painal.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.carrito.CarritoSingleton;
import com.sienrgitec.painal.componente.RVAdapter;
import com.sienrgitec.painal.componente.recycler.ListaDomicilioAdapter;
import com.sienrgitec.painal.pojo.entity.TtCtDomicilio_;

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
        ListaDomicilioAdapter listaDomicilioAdapter = new ListaDomicilioAdapter(ListaDomicilioActivity.this, new RVAdapter.OnViewHolderClick() {
            @Override
            public void onClick(View view, int position, Object item) {
                CarritoSingleton.getInstance().setDomicilioActual((TtCtDomicilio_) item);
                Intent inicio = new Intent(ListaDomicilioActivity.this, HomeActivity.class);
                startActivity(inicio);
            }
        });
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
