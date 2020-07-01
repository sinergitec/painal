package com.sienrgitec.painal.fragmentos;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.sienrgitec.painal.R;
import com.sienrgitec.painal.carrito.CarritoSingleton;
import com.sienrgitec.painal.pojo.entity.TtCtDomicilio_;
import com.sienrgitec.painal.pojo.peticion.DsCtDomicilio;
import com.sienrgitec.painal.pojo.peticion.Peticion;
import com.sienrgitec.painal.pojo.peticion.Request;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;

import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapaFragment extends Fragment implements OnMapReadyCallback, GoogleMap.OnMarkerDragListener {

    private View view;
    private TextView calleTxt;
    private MapView mapView;
    private GoogleMap gMap;
    private List<Address> direccion;
    private Geocoder geocoder;
    private String calle;
    private String municipio;
    private String estado;
    private String codigoPostal;
    private Double latitud;
    private Double longitud;
    private String colonia;
    private String numeroExterior;
    private String direccionTxt;
    private Marker marcador;


    public MapaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_mapa, container, false);
        calleTxt = view.findViewById(R.id.direccion);

        final TextView alias = view.findViewById(R.id.alias);
        final Button guardar = view.findViewById(R.id.guardarDireccion);
        guardar.setOnClickListener(v -> {
            TtCtDomicilio_ ttCtDomicilio = new TtCtDomicilio_(
                    String.valueOf(CarritoSingleton.getInstance().getUsuario_().getiPersona()),
                    String.valueOf(0),
                    String.valueOf(CarritoSingleton.getInstance().getUsuario_().getiTipoPersona()),
                    String.valueOf(1),
                    "",
                    this.calle,
                    this.numeroExterior,
                    "",
                    this.colonia,
                    this.municipio,
                    this.estado,
                    this.codigoPostal,
                    "MEX",
                    "",
                    "",
                    String.valueOf(this.longitud),
                    String.valueOf(this.latitud),
                    true,
                    "NOW",
                    "",
                    CarritoSingleton.getInstance().getUsuario_().getcUsuario(),
                    CarritoSingleton.getInstance().getUsuario_().getcUsuario()
            );

            final Peticion peticion = new Peticion(new Request(new DsCtDomicilio(new ArrayList<TtCtDomicilio_>() {
                {
                    add(ttCtDomicilio);
                }
            })));

            final Painal service = ServiceGenerator.createService(Painal.class);
            final Call<Respuesta> call = service.creaDomicilio(peticion);

            call.enqueue(new Callback<Respuesta>() {
                @Override
                public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                    if (response.isSuccessful()) {
                        Respuesta respuesta = response.body();
                        if (!Boolean.valueOf(respuesta.getResponse().getOplError())) {
                            Toast.makeText(v.getContext(), "Dirección creada", Toast.LENGTH_LONG).show();
                            CarritoSingleton.getInstance().setDomicilioActual(ttCtDomicilio);
                        } else {
                            Toast.makeText(v.getContext(), "No se creo la dirección", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(v.getContext(), "No se creo la dirección", Toast.LENGTH_LONG).show();
                    }
                }

                @Override
                public void onFailure(Call<Respuesta> call, Throwable t) {
                    System.out.println(t.getMessage());
                    Toast.makeText(v.getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                }
            });

        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mapView = view.findViewById(R.id.map);
        if (mapView != null) {
            mapView.onCreate(null);
            mapView.onResume();
            mapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        gMap = googleMap;
        miUbicacion();

        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        gMap.setMyLocationEnabled(true);
        gMap.setOnMarkerDragListener(this);
        geocoder = new Geocoder(getContext(), Locale.getDefault());
    }

    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        try {
            direccion = geocoder.getFromLocation(marker.getPosition().latitude, marker.getPosition().longitude, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (direccion != null && direccion.size() > 0) {
            direccionTxt = direccion.get(0).getAddressLine(0);
            calle = direccion.get(0).getThoroughfare();
            municipio = direccion.get(0).getLocality();
            estado = direccion.get(0).getAdminArea();
            codigoPostal = direccion.get(0).getPostalCode();
            latitud = marker.getPosition().latitude;
            longitud = marker.getPosition().longitude;
            calleTxt.setText(direccionTxt);
            colonia = direccion.get(0).getSubLocality();
            numeroExterior = direccion.get(0).getSubThoroughfare();
        } else {
            Toast.makeText(getContext(), "No se ha podido crear la dirección", Toast.LENGTH_LONG).show();
        }
    }

    public void ubicacionActual(final Location location) {
        if (location != null) {
            latitud = location.getLatitude();
            longitud = location.getLongitude();
            agregarMarcador(latitud, longitud);
        }
    }

    public void agregarMarcador(final Double latitud, final Double longitud) {
        LatLng latLng = new LatLng(latitud, longitud);
        if(marcador != null)
            marcador.remove();
        marcador = gMap.addMarker(new MarkerOptions().position(latLng).draggable(true));
        gMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 18));
    }

    public void miUbicacion() {
        if (ActivityCompat.checkSelfPermission(this.getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this.getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        LocationManager locationManager = (LocationManager) this.getContext().getSystemService(Context.LOCATION_SERVICE);
        Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        ubicacionActual(location);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 0,locationListener);
    }

    LocationListener locationListener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            ubicacionActual(location);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
    };

}
