package com.sienrgitec.painal.actividades;

import androidx.appcompat.app.AppCompatActivity;

import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.SearchView;


import com.sienrgitec.painal.R;
import com.sienrgitec.painal.componente.recycler.ctProveedorAdapter;
import com.sienrgitec.painal.pojo.entity.TtCtArtProveedor_;
import com.sienrgitec.painal.pojo.entity.TtCtProveedor_;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ctProveedores extends AppCompatActivity {

    ViewPager viewPager;
    private  Integer viProveedor = 0;

    private ctProveedorAdapter adapter;

    private SearchView buscador;
    List<TtCtArtProveedor_> listArt;    // = new ArrayList<>();
    List <TtCtProveedor_> provedoresList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ct_proveedores);

        Intent i = getIntent();
        provedoresList = (ArrayList<TtCtProveedor_>) i
                .getSerializableExtra("listProvs");
        listArt = (ArrayList<TtCtArtProveedor_>) i
                .getSerializableExtra("listArts");



        viewPager  = findViewById(R.id.viewPager);
        adapter = new ctProveedorAdapter(this.provedoresList , getBaseContext());
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,120,130,120);

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                viProveedor = provedoresList.get(position).getIProveedor();
            }

            @Override
            public void onPageSelected(int position) {
                // this will execute when page will be selected
                viProveedor = provedoresList.get(position).getIProveedor();
            }



            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public  void buscaArt(View v){
        List<TtCtArtProveedor_> listMuestraArt = new ArrayList<TtCtArtProveedor_>();
        for(TtCtArtProveedor_ objArt : listArt){
            if (objArt.getIProveedor().equals(viProveedor)){
                listMuestraArt.add(objArt);
            }
        }

        Intent home = new Intent(ctProveedores.this, ArticuloActivity.class);
        home.putExtra("list", (Serializable) listMuestraArt);
        startActivity(home);
    }



}