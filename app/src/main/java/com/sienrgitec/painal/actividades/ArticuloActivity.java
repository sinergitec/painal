package com.sienrgitec.painal.actividades;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.componente.recycler.ArticulosAdapter;
import com.sienrgitec.painal.pojo.entity.TtCtArtProveedor_;

import java.util.ArrayList;
import java.util.List;

public class ArticuloActivity extends AppCompatActivity {

    private RecyclerView rvArt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.articulo);

        rvArt = findViewById(R.id.rvCatProv);

        Intent i = getIntent();
        List<TtCtArtProveedor_> listArt =
                (ArrayList<TtCtArtProveedor_>) i.getSerializableExtra("list");
        GridLayoutManager grid = new GridLayoutManager(ArticuloActivity.this, 2);
        rvArt.setLayoutManager(grid);
        ArticulosAdapter articulosAdapter = new ArticulosAdapter(ArticuloActivity.this, null);
        articulosAdapter.setList(listArt);
        rvArt.setAdapter(articulosAdapter);
    }

}
