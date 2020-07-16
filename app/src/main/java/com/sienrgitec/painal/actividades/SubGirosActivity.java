package com.sienrgitec.painal.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.componente.RVAdapter;
import com.sienrgitec.painal.componente.recycler.GirosAdapter;
import com.sienrgitec.painal.componente.recycler.SubGirosAdapter;
import com.sienrgitec.painal.pojo.entity.TtCtGiro_;
import com.sienrgitec.painal.pojo.entity.TtCtSubGiro_;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SubGirosActivity extends AppCompatActivity {

    private RecyclerView rvSubGiros;
    private SearchView buscador;
    private List<TtCtSubGiro_> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.subgiros);

        Intent i = getIntent();
        list = (ArrayList<TtCtSubGiro_>) i
                .getSerializableExtra("list");

        rvSubGiros = findViewById(R.id.rvCatProv);
        LinearLayoutManager llm = new LinearLayoutManager(SubGirosActivity.this);
        rvSubGiros.setLayoutManager(llm);
        SubGirosAdapter subGirosAdapter = new SubGirosAdapter(SubGirosActivity.this,null);
        subGirosAdapter.setList(list);
        rvSubGiros.setAdapter(subGirosAdapter);


        buscador =  findViewById(R.id.buscadorView);

        buscador.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                SubGirosAdapter subGirosAdapter = generaObjSubGirosAdapter(list);
                subGirosAdapter.setList(buscaItem(query));
                rvSubGiros.setAdapter(subGirosAdapter);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                SubGirosAdapter subGirosAdapter = generaObjSubGirosAdapter(list);
                subGirosAdapter.setList(buscaItem(newText));
                rvSubGiros.setAdapter(subGirosAdapter);
                return true;
            }
        });

    }

    private List<TtCtSubGiro_> buscaItem(String valorBuscado){
        List<TtCtSubGiro_> listaFiltrada = new ArrayList<>();
        for (TtCtSubGiro_ subGiro: list) {
            if(subGiro.getCSubGiro().trim().toUpperCase().contains(valorBuscado.trim().toUpperCase()))
                listaFiltrada.add(subGiro);
        }
        return listaFiltrada;
    }

    private SubGirosAdapter generaObjSubGirosAdapter(List<TtCtSubGiro_> listaSubGiro){
        SubGirosAdapter subGirosAdapter = new SubGirosAdapter(SubGirosActivity.this, new RVAdapter.OnViewHolderClick() {
            @Override
            public void onClick(View view, int position, Object item) {
                List<TtCtSubGiro_> listSubGiro = new ArrayList<TtCtSubGiro_>();
                for (TtCtSubGiro_ subgiro : listaSubGiro) {
                    if(subgiro.getISubGiro() == ((TtCtSubGiro_) item).getISubGiro())
                        listSubGiro.add(subgiro);
                }
                Intent vistaNueva = new Intent(SubGirosActivity.this, ProveedoresActivity.class);
                vistaNueva.putExtra("list", (Serializable) listSubGiro);
                startActivity(vistaNueva);
            }
        });
        return subGirosAdapter;
    }
}
