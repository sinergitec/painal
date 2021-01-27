package com.sienrgitec.painal.actividades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.componente.recycler.ProvClasifAdapter;
import com.sienrgitec.painal.componente.recycler.ctSubCatAdapter;
import com.sienrgitec.painal.pojo.entity.TtCtArtProveedor_;
import com.sienrgitec.painal.pojo.entity.TtCtSubCategoriaProv;
import com.sienrgitec.painal.pojo.error.ErrorUtils;
import com.sienrgitec.painal.pojo.error.Errors;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ctSubClasif extends AppCompatActivity {

    private List<TtCtSubCategoriaProv> listSubCat = new ArrayList<>();
    Integer ipiCat = 0, ipiProv = 0;

    private List<TtCtSubCategoriaProv> listSubCatFinal = new ArrayList<>();
    private RecyclerView rvSubCatArt;



    /**/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ctsubclasif);

        Intent i = getIntent();
        this.listSubCat = (ArrayList<TtCtSubCategoriaProv>) i.getSerializableExtra("list");
        ipiCat = (Integer) i.getSerializableExtra("ipiCat");
        ipiProv = (Integer) i.getSerializableExtra("ipiProv");

        rvSubCatArt = findViewById(R.id.rvSubCatArt);

        GridLayoutManager grid = new GridLayoutManager(ctSubClasif.this, 3);
        rvSubCatArt.setLayoutManager(grid);
        listSubCatFinal.clear();

        for(TtCtSubCategoriaProv obj: this.listSubCat){
            if(obj.getICategoria().equals(ipiCat)) {
                listSubCatFinal.add(obj);
            }
        }

        ctSubCatAdapter subCategoriaAdapter = new ctSubCatAdapter(ctSubClasif.this, listSubCatFinal, null);
        subCategoriaAdapter.setList(listSubCatFinal);
        rvSubCatArt.setAdapter(subCategoriaAdapter);


        subCategoriaAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CargaArticulos(listSubCatFinal.get(rvSubCatArt.getChildAdapterPosition(v)).getISubCategoria());
            }
        });
    }

    public void CargaArticulos(Integer ipiSubCategoria){
        final Painal service = ServiceGenerator.createService(Painal.class);
        //final TtCtSubCategoriaProv subCatProv = (TtCtSubCategoriaProv) 2;
        Map<String, String> data = new HashMap<>();
        data.put("ipiProveedor", String.valueOf(ipiProv));
        data.put("ipiCategoria", String.valueOf(ipiCat));
        data.put("ipiSubCategoria", String.valueOf(ipiSubCategoria));
        data.put("ipiClasificacion", "1");
        data.put("ipiSubClasificacion", "1");
        final Call<Respuesta> call = service.consultaArticulos(data);

        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                if(response.isSuccessful()){
                    Respuesta res = response.body();

                    if(res.getResponse().getTtCtArtProveedor() != null &&
                            res.getResponse().getTtCtArtProveedor().getTtCtArtProveedor() != null &&
                            res.getResponse().getTtCtArtProveedor().getTtCtArtProveedor().size() > 0){
                        Intent vistaNueva = new Intent(ctSubClasif.this, ArticuloActivity.class);
                        vistaNueva.putExtra("list", (Serializable) res.getResponse().getTtCtArtProveedor().getTtCtArtProveedor());
                       startActivity(vistaNueva);
                    } else {
                        Toast.makeText(ctSubClasif.this, "Sin articulos disponibles", Toast.LENGTH_LONG).show();
                    }
                } else {
                    try {
                        Errors error = ErrorUtils.parseError(response);
                        Toast.makeText(ctSubClasif.this, error.toString(), Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(ctSubClasif.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {
                Toast.makeText(ctSubClasif.this, "Error Failure: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}