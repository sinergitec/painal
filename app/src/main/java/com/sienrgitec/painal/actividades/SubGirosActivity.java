package com.sienrgitec.painal.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.componente.RVAdapter;
import com.sienrgitec.painal.componente.recycler.SubGirosAdapter;
import com.sienrgitec.painal.pojo.entity.TtCtSubGiro_;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubGirosActivity extends AppCompatActivity {

    private RecyclerView rvSubGiros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subgiros);

        Intent i = getIntent();
        List<TtCtSubGiro_> list = (ArrayList<TtCtSubGiro_>) i
                .getSerializableExtra("list");

        rvSubGiros = findViewById(R.id.rvSubGrio);
        LinearLayoutManager llm = new LinearLayoutManager(SubGirosActivity.this);
        rvSubGiros.setLayoutManager(llm);
        SubGirosAdapter subGirosAdapter = new SubGirosAdapter(SubGirosActivity.this,null);
        subGirosAdapter.setList(list);
        rvSubGiros.setAdapter(subGirosAdapter);

    }

}
