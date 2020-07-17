package com.sienrgitec.painal.fragmentos;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.actividades.HistoricoActivity;
import com.sienrgitec.painal.actividades.SeguimientoActivity;
import com.sienrgitec.painal.actividades.TitlaniAsignado;

import static com.sienrgitec.painal.R.id.imageView;
import static com.sienrgitec.painal.R.id.imageView2;
import static com.sienrgitec.painal.R.id.imageView4;

public class PedidosFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private ImageView btnHistorico;
    private ImageView btnSeguimiento;
    private ImageView btnTitlani;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PedidosFragment() {
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
    public static PedidosFragment newInstance(String param1, String param2) {
        PedidosFragment fragment = new PedidosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_pedidos, container, false);

        btnHistorico = view.findViewById(imageView);
        btnHistorico.setOnClickListener(v -> historico());

        btnSeguimiento = view.findViewById(imageView4);
        btnSeguimiento.setOnClickListener(v -> seguimiento());

        btnTitlani = view.findViewById(imageView2);
        btnTitlani.setOnClickListener(v -> titlaniAsignado());

        final TextView histo = view.findViewById(R.id.perfil);
        histo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Entrando a Historico de Pedido.. ", Toast.LENGTH_LONG).show();
                Intent historico = new Intent(getActivity(), HistoricoActivity.class);
                startActivity(historico);
            }
        });

        final TextView seguimiento = view.findViewById(R.id.family);
        seguimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Entrando a Seguimiento de Pedido.. ", Toast.LENGTH_LONG).show();
                Intent seguimiento = new Intent(getActivity(), TitlaniAsignado.class);
                startActivity(seguimiento);
            }
        });
        final TextView titlaniAsig = view.findViewById(R.id.referidos);
        titlaniAsig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Entrando a Titlani Asignado.. ", Toast.LENGTH_LONG).show();
                Intent titlaniAsig = new Intent(getActivity(), SeguimientoActivity.class);
                startActivity(titlaniAsig);
            }
        });

        return view;
    }

    private void historico() {
        Intent historico = new Intent(getActivity(), HistoricoActivity.class);
        startActivity(historico);
    }

    private void seguimiento() {
        Intent seguimiento = new Intent(getActivity(), SeguimientoActivity.class);
        startActivity(seguimiento);
    }

    private void titlaniAsignado() {
        Intent titlaniAsignado = new Intent(getActivity(), TitlaniAsignado.class);
        startActivity(titlaniAsignado);
    }
}



