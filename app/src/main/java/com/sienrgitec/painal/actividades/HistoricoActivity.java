package com.sienrgitec.painal.actividades;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sienrgitec.painal.R;
import com.sienrgitec.painal.carrito.CarritoSingleton;
import com.sienrgitec.painal.componente.recycler.HistoricoAdapter;
import com.sienrgitec.painal.fragmentos.CarritoFragment;
import com.sienrgitec.painal.fragmentos.ConfiguracionFragment;
import com.sienrgitec.painal.fragmentos.HomeFragment;
import com.sienrgitec.painal.fragmentos.PedidosFragment;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HistoricoActivity extends AppCompatActivity {

    private RecyclerView recyclerHistorico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.historico_pedido);
        listHistorico();

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new HomeFragment()).commit();
        }
    }

    private void listHistorico() {
        final Painal service = ServiceGenerator.createService(Painal.class);
        Map<String, String> data = new HashMap<>();
        data.put("ipiCliente", String.valueOf(CarritoSingleton.getInstance().getCliente().getiCliente()));

        final Call<Respuesta> call = service.opPedidoCrea(data);
        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                Respuesta res = response.body();

                if (response.isSuccessful()) {
                    if (res.getResponse().getOplError().equals("true"))
                        Toast.makeText(HistoricoActivity.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                    else {
                        recyclerHistorico = findViewById(R.id.listHistotico);
                        recyclerHistorico.setLayoutManager(new LinearLayoutManager(HistoricoActivity.this));
                        HistoricoAdapter fm = new HistoricoAdapter(HistoricoActivity.this, null,
                                                                    res.getResponse().getTt_opPedidoDet().getTt_opPedidoDet());
                        fm.setList(res.getResponse().getTtTtOpPedido().getTt_OpPedido());
                        recyclerHistorico.setAdapter(fm);
                    }
                } else {
                    Toast.makeText(HistoricoActivity.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {
                Toast.makeText(HistoricoActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }
}
