package com.sienrgitec.painal.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.componente.RVAdapter;
import com.sienrgitec.painal.componente.recycler.ArticulosAdapter;
import com.sienrgitec.painal.componente.recycler.ProvClasifAdapter;
import com.sienrgitec.painal.componente.recycler.SubGirosAdapter;
import com.sienrgitec.painal.pojo.entity.TtCtArtProveedor_;
import com.sienrgitec.painal.pojo.entity.TtCtCategoriaProv_;
import com.sienrgitec.painal.pojo.entity.TtCtProveedor_;
import com.sienrgitec.painal.pojo.entity.TtCtSubCategoriaProv;
import com.sienrgitec.painal.pojo.entity.TtCtSubGiro_;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProveedoresActivity  extends AppCompatActivity {

    private RecyclerView rvCatProv;
    private SearchView buscador;
    private List<TtCtCategoriaProv_> listCatProv  = new ArrayList<>();
    private List<TtCtSubCategoriaProv> listSubCatProv = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.proveedores);

        Intent i = getIntent();
        this.listCatProv = (ArrayList<TtCtCategoriaProv_>) i
                .getSerializableExtra("listCatProv");
        this.listSubCatProv = (ArrayList<TtCtSubCategoriaProv>) i
                .getSerializableExtra("listSubCatProv");

        rvCatProv = findViewById(R.id.rvCatProv);
        /*LinearLayoutManager llm = new LinearLayoutManager(ProveedoresActivity.this);
        rvCatProv.setLayoutManager(llm);*/
        GridLayoutManager grid = new GridLayoutManager(ProveedoresActivity.this, 3);
        rvCatProv.setLayoutManager(grid);


        ProvClasifAdapter subGirosAdapter = new ProvClasifAdapter(ProveedoresActivity.this, listSubCatProv, null);
        subGirosAdapter.setList(listCatProv);
        rvCatProv.setAdapter(subGirosAdapter);


        subGirosAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("provs", "prov-->");
                Intent vistaNueva = new Intent(ProveedoresActivity.this, ctSubClasif.class);
                vistaNueva.putExtra("list", (Serializable) listSubCatProv);
                vistaNueva.putExtra("ipiCat",listCatProv.get(rvCatProv.getChildAdapterPosition(v)).getiCategoria());
                vistaNueva.putExtra("ipiProv",listCatProv.get(rvCatProv.getChildAdapterPosition(v)).getiProveedor());
                startActivity(vistaNueva);
            }
        });

        buscador = findViewById(R.id.buscadorView);






        buscador.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                ProvClasifAdapter provClasifAdapter = generaObjCategoriaAdapter(listCatProv);
                provClasifAdapter.setList(buscaItem(query));
                rvCatProv.setAdapter(provClasifAdapter);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ProvClasifAdapter provClasifAdapter = generaObjCategoriaAdapter(listCatProv);
                provClasifAdapter.setList(buscaItem(newText));;
                rvCatProv.setAdapter(provClasifAdapter);
                return true;
            }
        });
    }

    private List<TtCtCategoriaProv_> buscaItem(String valorBuscado){
        List<TtCtCategoriaProv_> listaFiltrada = new ArrayList<>();
        for (TtCtCategoriaProv_ catArticulo: listCatProv) {
            if(catArticulo.getcCategoria().trim().toUpperCase().contains(valorBuscado.trim().toUpperCase()))
                listaFiltrada.add(catArticulo);
        }
        return listaFiltrada;
    }




    private ProvClasifAdapter generaObjCategoriaAdapter(List<TtCtCategoriaProv_> listaCatArt){
        ProvClasifAdapter provClasifAdapter = new ProvClasifAdapter(ProveedoresActivity.this, listSubCatProv, new RVAdapter.OnViewHolderClick() {
            @Override
            public void onClick(View view, int position, Object item) {
                List<TtCtCategoriaProv_> listCat = new ArrayList<TtCtCategoriaProv_>();
                for (TtCtCategoriaProv_ cat : listCat) {
                    if(cat.getiCategoria() == ((TtCtCategoriaProv_) item).getiCategoria())
                        listCat.add(cat);
                }
                Intent vistaNueva = new Intent(ProveedoresActivity.this, ArticuloActivity.class);
                vistaNueva.putExtra("list", (Serializable) listCat);
                startActivity(vistaNueva);
            }
        });
        return provClasifAdapter;
    }
}
