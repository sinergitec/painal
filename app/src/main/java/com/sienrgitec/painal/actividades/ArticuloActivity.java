package com.sienrgitec.painal.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.componente.RVAdapter;
import com.sienrgitec.painal.componente.recycler.ArticulosAdapter;
import com.sienrgitec.painal.componente.recycler.SubGirosAdapter;
import com.sienrgitec.painal.pojo.entity.TtCtArtProveedor;
import com.sienrgitec.painal.pojo.entity.TtCtArtProveedor_;
import com.sienrgitec.painal.pojo.entity.TtCtSubGiro_;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ArticuloActivity extends AppCompatActivity {

    private RecyclerView rvArt;
    private SearchView buscador;
    private List<TtCtArtProveedor_> listArt = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.articulo);

        rvArt = findViewById(R.id.rvCatProv);

        Intent i = getIntent();
        this.listArt = (ArrayList<TtCtArtProveedor_>) i.getSerializableExtra("list");
        GridLayoutManager grid = new GridLayoutManager(ArticuloActivity.this, 2);
        rvArt.setLayoutManager(grid);
        ArticulosAdapter articulosAdapter = new ArticulosAdapter(ArticuloActivity.this, null);
        articulosAdapter.setList(listArt);
        rvArt.setAdapter(articulosAdapter);


        buscador =  findViewById(R.id.buscadorView);

        buscador.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                ArticulosAdapter articulosAdapter  = generaObjArticuloAdapter(listArt);
                articulosAdapter.setList(buscaItem(query));
                rvArt.setAdapter(articulosAdapter);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArticulosAdapter articulosAdapter = generaObjArticuloAdapter(listArt);
                articulosAdapter.setList(buscaItem(newText));
                rvArt.setAdapter(articulosAdapter);
                return true;
            }
        });
    }

    private List<TtCtArtProveedor_> buscaItem(String valorBuscado){
        List<TtCtArtProveedor_> listaFiltrada = new ArrayList<>();
        for (TtCtArtProveedor_ articulo: listArt) {
            if(articulo.getCDescripcion().trim().toUpperCase().contains(valorBuscado.trim().toUpperCase()))
                listaFiltrada.add(articulo);
        }
        return listaFiltrada;
    }

    private ArticulosAdapter generaObjArticuloAdapter(List<TtCtArtProveedor_> listaArticulo){
        ArticulosAdapter articulosAdapter = new ArticulosAdapter(ArticuloActivity.this, new RVAdapter.OnViewHolderClick() {
            @Override
            public void onClick(View view, int position, Object item) {
                List<TtCtArtProveedor_> listArticulo = new ArrayList<TtCtArtProveedor_>();
                for (TtCtArtProveedor_ articulo : listArticulo) {
                    if(articulo.getIArticulo() == ((TtCtArtProveedor_) item).getIArticulo())
                        listArticulo.add(articulo);
                }
                Intent vistaNueva = new Intent(ArticuloActivity.this, ArticuloDetalleActivity.class);
                vistaNueva.putExtra("list", (Serializable) listArticulo);
                startActivity(vistaNueva);
            }
        });
        return articulosAdapter;
    }
}
