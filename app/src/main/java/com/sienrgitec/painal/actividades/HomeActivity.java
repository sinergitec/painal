package com.sienrgitec.painal.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sienrgitec.painal.fragmentos.ConfiguracionFragment;
import com.sienrgitec.painal.R;
import com.sienrgitec.painal.fragmentos.CarritoFragment;
import com.sienrgitec.painal.fragmentos.HomeFragment;
import com.sienrgitec.painal.fragmentos.PedidosFragment;
import com.sienrgitec.painal.pojo.entity.TtCtArtProveedor_;
import com.sienrgitec.painal.pojo.entity.TtCtProveedor_;
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

import static com.sienrgitec.painal.constante.Constantes.ctProvList;
import static com.sienrgitec.painal.constante.Constantes.vcMatchArt;

public class HomeActivity extends AppCompatActivity {
    private List<TtCtArtProveedor_> listaArts = new ArrayList<>();
    private List<TtCtProveedor_> listProvs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);


        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new HomeFragment()).commit();
        }
    }

    /*Agregado para buscar por articulos**/
    public void matchArts(View c){
        Log.e("press" , "valores" + vcMatchArt);
        final Painal service = ServiceGenerator.createService(Painal.class);
        Map<String, String> data = new HashMap<>();
        data.put("ipcBuscar",vcMatchArt);

        final Call<Respuesta> call = service.matchArt(data);
        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                Respuesta res = response.body();

                if (response.isSuccessful()) {
                    if (res.getResponse().getOplError().equals("true")) {
                        Toast.makeText(HomeActivity.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                        return;

                    }else {
                        listaArts.addAll(res.getResponse().getTtCtArtProveedor().getTtCtArtProveedor());
                        ctProvList.addAll(res.getResponse().getTtCtProveedor().getTtCtProveedor());





                        List<TtCtArtProveedor_> listArtProv = new ArrayList<TtCtArtProveedor_>();
                        for (TtCtArtProveedor_ artProv : listaArts) {
                            listArtProv.add(artProv);
                        }

                        List<TtCtProveedor_> listaFiltrada = new ArrayList<>();
                        for (TtCtProveedor_ ObjProv: ctProvList) {
                                listaFiltrada.add(ObjProv);
                        }

                        Intent home = new Intent(HomeActivity.this, ctProveedores.class);
                        home.putExtra("listProvs", (Serializable) listaFiltrada);
                        home.putExtra("listArts", (Serializable) listArtProv);
                        startActivity(home);
                    }
                } else {
                    Toast.makeText(HomeActivity.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {
                Toast.makeText(HomeActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });


    }
    /***/

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.navigation_shop:
                        fragment = new HomeFragment();
                        loadFragment(fragment);
                        System.out.println("Inicio");
                        return true;
                    case R.id.navigation_cart:
                        fragment = new CarritoFragment();
                        loadFragment(fragment);
                        return true;
                    case R.id.navigation_profile:
                        fragment = new ConfiguracionFragment();
                        loadFragment(fragment);
                        System.out.println("Configuracion");
                        return true;
                    case R.id.navigation_orders:
                        fragment = new PedidosFragment();
                        loadFragment(fragment);
                        System.out.println("Pedidos");
                        return true;
                    default:
                        fragment = new HomeFragment();
                        loadFragment(fragment);
                        return true;
                }
            };

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
