package com.sienrgitec.painal.actividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sienrgitec.painal.R;
import com.sienrgitec.painal.componente.RVAdapter;
import com.sienrgitec.painal.componente.recycler.GirosAdapter;
import com.sienrgitec.painal.fragmentos.HomeFragment;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

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
                        /*fragment = new CartFragment();
                        loadFragment(fragment);*/
                        System.out.println("Pedidos");
                        return true;
                    case R.id.navigation_profile:
                        /*fragment = new ProfileFragment();
                        loadFragment(fragment);*/
                        System.out.println("Configuracion");
                        return true;
                }

                return false;
            };

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
