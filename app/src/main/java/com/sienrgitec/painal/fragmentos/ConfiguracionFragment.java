package com.sienrgitec.painal.fragmentos;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.actividades.FamilyListActivity;
import com.sienrgitec.painal.actividades.PerfilActivity;
import com.sienrgitec.painal.actividades.ReferidosListActivity;

import static com.sienrgitec.painal.R.id.agregar;
import static com.sienrgitec.painal.R.id.imageView;
import static com.sienrgitec.painal.R.id.imageView2;
import static com.sienrgitec.painal.R.id.imageView4;
import static com.sienrgitec.painal.R.id.referidos;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ConfiguracionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConfiguracionFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private ImageView btnPerfil;
    private ImageView btnAutorizado;
    private ImageView btnReferidos;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ConfiguracionFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConfiguracionFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConfiguracionFragment newInstance(String param1, String param2) {
        ConfiguracionFragment fragment = new ConfiguracionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        btnPerfil = btnPerfil.findViewById(imageView);
        btnPerfil.setOnClickListener(v -> perfil());

        btnReferidos = btnReferidos.findViewById(imageView4);
        btnReferidos.setOnClickListener(v -> referidos());

        btnAutorizado = btnAutorizado.findViewById(imageView2);
        btnAutorizado.setOnClickListener(v -> autorizados());

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private void perfil() {
        Intent perfil = new Intent(getActivity(), PerfilActivity.class);
        startActivity(perfil);
    }

    private void referidos() {
        Intent ref = new Intent(getActivity(), ReferidosListActivity.class);
        startActivity(ref);
    }

    private void autorizados() {
        Intent family = new Intent(getActivity(), FamilyListActivity.class);
        startActivity(family);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_configuracion, container, false);

        final TextView perfil = view.findViewById(R.id.perfil);
        perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent perfil = new Intent(getActivity(), PerfilActivity.class);
                startActivity(perfil);
            }
        });
        /*final TextView contacto = view.findViewById(R.id.contacto);
        contacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contacto = new Intent(getActivity(), ContactoListActivity.class);
                startActivity(contacto);
            }
        });*/
        final TextView family = view.findViewById(R.id.family);
        family.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent family = new Intent(getActivity(), FamilyListActivity.class);
                startActivity(family);
            }
        });
        final TextView referidos = view.findViewById(R.id.referidos);
        referidos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ref = new Intent(getActivity(), ReferidosListActivity.class);
                startActivity(ref);
            }
        });

        return view;
    }
}
