package com.sienrgitec.painal.actividades;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.maps.model.LatLng;
import com.sienrgitec.painal.R;
import com.sienrgitec.painal.carrito.CarritoSingleton;
import com.sienrgitec.painal.componente.RVAdapter;
import com.sienrgitec.painal.componente.adaptadores.AutoCompleteStreet;
import com.sienrgitec.painal.componente.recycler.ListaDomicilioAdapter;
import com.sienrgitec.painal.fragmentos.MapaFragment;
import com.sienrgitec.painal.pojo.entity.TtCtDomicilio_;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaDomicilioActivity extends AppCompatActivity {

    private RecyclerView rvListaDomicilios;
    private Button ubicacionActual;
    private View fragmentMapa;
    private boolean banderaMostrarMapa = false;
    private MapaFragment newFragment = new MapaFragment();
    private ImageView back, home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_direcciones);

        back = findViewById(R.id.back);
        back.setOnClickListener(v -> regresaPantalla());

        home = findViewById(R.id.imageView7);
        home.setOnClickListener(v -> pantallaHome());


        final AutoCompleteTextView autoCompleteTextView = findViewById(R.id.buscarDireccion);
        autoCompleteTextView.setAdapter(new AutoCompleteStreet(ListaDomicilioActivity.this,android.R.layout.simple_list_item_1));
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                LatLng latLng=getLatLngFromAddress(autoCompleteTextView.getText().toString());
                if(latLng!=null) {
                    Address address=getAddressFromLatLng(latLng);
                    if(address!=null) {
                        loadFragment(new MapaFragment(latLng.latitude, latLng.longitude));
                        fragmentMapa.setVisibility(View.VISIBLE);
                        banderaMostrarMapa = true;
                    }
                    else {
                        Toast.makeText(ListaDomicilioActivity.this, "Dirección no encontrada", Toast.LENGTH_LONG);
                    }
                }
                else {
                    Toast.makeText(ListaDomicilioActivity.this, "Coordenadas no encontradas", Toast.LENGTH_LONG);
                }

            }
        });

        recuperaDomicilio();
        ubicacionActual = findViewById(R.id.ubicacionActual);
        rvListaDomicilios = findViewById(R.id.rvListaDomicilios);
        fragmentMapa = findViewById(R.id.fragmentMapa);
        loadFragment(newFragment);
        LinearLayoutManager llm = new LinearLayoutManager(ListaDomicilioActivity.this);
        rvListaDomicilios.setLayoutManager(llm);
        ListaDomicilioAdapter listaDomicilioAdapter = new ListaDomicilioAdapter(ListaDomicilioActivity.this, new RVAdapter.OnViewHolderClick() {
            @Override
            public void onClick(View view, int position, Object item) {
                CarritoSingleton.getInstance().setDomicilioActual((TtCtDomicilio_) item);
                Intent inicio = new Intent(ListaDomicilioActivity.this, HomeActivity.class);
                startActivity(inicio);
            }
        });
        listaDomicilioAdapter.setList(CarritoSingleton.getInstance().getDomicilio());
        rvListaDomicilios.setAdapter(listaDomicilioAdapter);
        fragmentMapa.setVisibility(View.INVISIBLE);

        ubicacionActual.setOnClickListener(v -> {
            if(!banderaMostrarMapa){
                fragmentMapa.setVisibility(View.VISIBLE);
                banderaMostrarMapa = true;
            } else {
                fragmentMapa.setVisibility(View.INVISIBLE);
                banderaMostrarMapa = false;
            }
        });

    }

    public void recuperaDomicilio(){

        final Map<String, String> data = new HashMap<String, String>();
        data.put("ipiPersona", CarritoSingleton.getInstance().getCliente().getiCliente().toString());
        data.put("ipcPersona","cliente");
        data.put("iplActivo","true");
        final Painal service = ServiceGenerator.createService(Painal.class);
        final Call<Respuesta> call = service.consultaDomicilio(data);

        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                if(response.isSuccessful()){
                    Respuesta respuesta = response.body();
                    if(respuesta.getResponse().getOplError().equals("false")){
                        CarritoSingleton.getInstance().setDomicilio(respuesta.getResponse().getTt_ctDomicilio().getTt_ctDomicilio());
                    }
                } else {
                    Toast.makeText(ListaDomicilioActivity.this, "", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {
                System.out.println(t.getMessage());
                Toast.makeText(ListaDomicilioActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private LatLng getLatLngFromAddress(String address){

        Geocoder geocoder=new Geocoder(ListaDomicilioActivity.this);
        List<Address> addressList;

        try {
            addressList = geocoder.getFromLocationName(address, 1);
            if(addressList!=null){
                Address singleaddress=addressList.get(0);
                LatLng latLng=new LatLng(singleaddress.getLatitude(),singleaddress.getLongitude());
                return latLng;
            }
            else{
                return null;
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private Address getAddressFromLatLng(LatLng latLng){
        Geocoder geocoder=new Geocoder(ListaDomicilioActivity.this);
        List<Address> addresses;
        try {
            addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 5);
            if(addresses!=null){
                Address address=addresses.get(0);
                return address;
            }
            else{
                return null;
            }
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentMapa, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    private void pantallaHome() {
        Intent regresa = new Intent(ListaDomicilioActivity.this, HomeActivity.class);
        startActivity(regresa);
    }

    private void regresaPantalla() {
        Intent regresa = new Intent(ListaDomicilioActivity.this, HomeActivity.class);
        startActivity(regresa);
    }

}
