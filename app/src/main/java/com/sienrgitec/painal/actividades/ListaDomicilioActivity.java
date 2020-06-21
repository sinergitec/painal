package com.sienrgitec.painal.actividades;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.carrito.CarritoSingleton;
import com.sienrgitec.painal.componente.recycler.ListaDomicilioAdapter;

public class ListaDomicilioActivity extends AppCompatActivity {

    private RecyclerView rvListaDomicilios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_direcciones);

        rvListaDomicilios = findViewById(R.id.rvListaDomicilios);
        LinearLayoutManager llm = new LinearLayoutManager(ListaDomicilioActivity.this);
        rvListaDomicilios.setLayoutManager(llm);
        ListaDomicilioAdapter listaDomicilioAdapter = new ListaDomicilioAdapter(ListaDomicilioActivity.this,null);
        listaDomicilioAdapter.setList(CarritoSingleton.getInstance().getDomicilio());
        rvListaDomicilios.setAdapter(listaDomicilioAdapter);

    }

}
