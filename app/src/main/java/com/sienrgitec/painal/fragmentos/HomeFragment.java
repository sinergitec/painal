package com.sienrgitec.painal.fragmentos;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.actividades.HomeActivity;
import com.sienrgitec.painal.actividades.ListaDomicilioActivity;
import com.sienrgitec.painal.actividades.SubGirosActivity;
import com.sienrgitec.painal.carrito.CarritoSingleton;
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

import static com.sienrgitec.painal.constante.Constantes.vcMatchArt;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private RecyclerView rv;
    private TextView calleEntregar;

    private SearchView buscador;
    private List<TtCtGiro_> listaGiros = new ArrayList<>();
    private List<TtCtSubGiro_> listaSubGiros = new ArrayList<>();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        buscador =  view.findViewById(R.id.buscadorView);

        buscador.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                GirosAdapter girosAdapter = generaObjGirosAdapter(listaSubGiros);
                girosAdapter.setList(buscaItem(query));
                rv.setAdapter(girosAdapter);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                GirosAdapter girosAdapter = generaObjGirosAdapter(listaSubGiros);
                girosAdapter.setList(buscaItem(newText));
                rv.setAdapter(girosAdapter);
                vcMatchArt = newText;
                return true;
            }
        });



        calleEntregar = view.findViewById(R.id.calleEntregar);
        calleEntregar.setText(CarritoSingleton.getInstance().getDomicilioActual().calleYNumero());
        abrirMapa(calleEntregar);
        final Painal service = ServiceGenerator.createService(Painal.class);
        Map<String, String> data = new HashMap<>();
        data.put("iplActivo","true");
        final Call<Respuesta> call = service.consultaGiro(data);

        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {

                if(response.isSuccessful()){
                    Respuesta res = response.body();
                    rv = view.findViewById(R.id.rv);
                    LinearLayoutManager llm = new LinearLayoutManager(getActivity());
                    rv.setLayoutManager(llm);
                    GirosAdapter girosAdapter = generaObjGirosAdapter(res.getResponse().getTtCtSubGiro().getTtCtSubGiro());
                    listaGiros.addAll(res.getResponse().getTtCtGiro().getTtCtGiro());
                    listaSubGiros.addAll(res.getResponse().getTtCtSubGiro().getTtCtSubGiro());
                    girosAdapter.setList(res.getResponse().getTtCtGiro().getTtCtGiro());
                    rv.setAdapter(girosAdapter);
                } else {
                    try {
                        Errors error = ErrorUtils.parseError(response);
                        Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) { ;
                Toast.makeText(getActivity(), "Error Failure: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

    private void abrirMapa(TextView calleEntregar){
        calleEntregar.setOnClickListener(v -> {
            Intent pantallaListaDomicilios = new Intent(getContext(), ListaDomicilioActivity.class);
            getActivity().startActivity(pantallaListaDomicilios);
        });
    }

    private List<TtCtGiro_> buscaItem(String valorBuscado){
        List<TtCtGiro_> listaFiltrada = new ArrayList<>();
        for (TtCtGiro_ giro: listaGiros) {
            if(giro.getCGiro().trim().toUpperCase().contains(valorBuscado.trim().toUpperCase()))
                listaFiltrada.add(giro);
        }
        listaFiltrada.toString();
        return listaFiltrada;
    }

    private GirosAdapter generaObjGirosAdapter(List<TtCtSubGiro_> listaSubGiro){
        GirosAdapter girosAdapter = new GirosAdapter(getActivity(), new RVAdapter.OnViewHolderClick() {
            @Override
            public void onClick(View view, int position, Object item) {
                List<TtCtSubGiro_> listSubGiro = new ArrayList<TtCtSubGiro_>();
                for (TtCtSubGiro_ subgiro : listaSubGiro) {
                    if(subgiro.getIGiro() == ((TtCtGiro_) item).getIGiro())
                        listSubGiro.add(subgiro);
                }
                Intent vistaNueva = new Intent(getActivity(), SubGirosActivity.class);
                vistaNueva.putExtra("list", (Serializable) listSubGiro);
                startActivity(vistaNueva);
            }
        });
        return girosAdapter;
    }



}
