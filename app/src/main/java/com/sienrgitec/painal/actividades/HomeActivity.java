package com.sienrgitec.painal.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.componente.RVAdapter;
import com.sienrgitec.painal.componente.recycler.GirosAdapter;
import com.sienrgitec.painal.pojo.entity.TtCtGiro_;
import com.sienrgitec.painal.pojo.entity.TtCtSubGiro_;
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


public class HomeActivity extends AppCompatActivity {

    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        final Painal service = ServiceGenerator.createService(Painal.class);
        Map<String, String> data = new HashMap<>();
        data.put("iplActivo","true");
        final Call<Respuesta> call = service.consultaGiro(data);

        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {

                if(response.isSuccessful()){
                    Respuesta res = response.body();
                    rv = findViewById(R.id.rv);
                    LinearLayoutManager llm = new LinearLayoutManager(HomeActivity.this);
                    rv.setLayoutManager(llm);
                    GirosAdapter girosAdapter = new GirosAdapter(HomeActivity.this, new RVAdapter.OnViewHolderClick() {
                        @Override
                        public void onClick(View view, int position, Object item) {
                            List<TtCtSubGiro_> listSubGiro = new ArrayList<TtCtSubGiro_>();
                            for (TtCtSubGiro_ subgiro : res.getResponse().getTtCtSubGiro().getTtCtSubGiro()) {
                                if(subgiro.getIGiro() == ((TtCtGiro_) item).getIGiro())
                                    listSubGiro.add(subgiro);
                            }
                            System.out.println(listSubGiro.toString());
                            Intent vistaNueva = new Intent(HomeActivity.this, SubGirosActivity.class);
                            vistaNueva.putExtra("list", (Serializable) listSubGiro);
                            startActivity(vistaNueva);
                        }
                    });
                    girosAdapter.setList(res.getResponse().getTtCtGiro().getTtCtGiro());
                    rv.setAdapter(girosAdapter);
                } else {
                    try {
                        Errors error = ErrorUtils.parseError(response);
                        Toast.makeText(HomeActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(HomeActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {
                System.out.println("Error: " + t.getMessage());
            }
        });

    }

}
