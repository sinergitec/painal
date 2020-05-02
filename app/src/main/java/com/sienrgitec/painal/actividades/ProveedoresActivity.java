package com.sienrgitec.painal.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.componente.RVAdapter;
import com.sienrgitec.painal.componente.recycler.ProvClasifAdapter;
import com.sienrgitec.painal.componente.recycler.SubGirosAdapter;
import com.sienrgitec.painal.pojo.entity.TtCtCategoriaProv_;
import com.sienrgitec.painal.pojo.entity.TtCtSubCategoriaProv;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;

public class ProveedoresActivity  extends AppCompatActivity {

    private RecyclerView rvCatProv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.proveedores);

        Intent i = getIntent();
        List<TtCtCategoriaProv_> listCatProv = (ArrayList<TtCtCategoriaProv_>) i
                .getSerializableExtra("listCatProv");
        List<TtCtSubCategoriaProv> listSubCatProv = (ArrayList<TtCtSubCategoriaProv>) i
                .getSerializableExtra("listSubCatProv");

        rvCatProv = findViewById(R.id.rvCatProv);
        LinearLayoutManager llm = new LinearLayoutManager(ProveedoresActivity.this);
        rvCatProv.setLayoutManager(llm);
        ProvClasifAdapter subGirosAdapter = new ProvClasifAdapter(ProveedoresActivity.this, listSubCatProv, null);
        subGirosAdapter.setList(listCatProv);
        rvCatProv.setAdapter(subGirosAdapter);

    }

}
