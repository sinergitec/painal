package com.sienrgitec.painal.fragmentos;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.actividades.SubGirosActivity;
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
                    GirosAdapter girosAdapter = new GirosAdapter(getActivity(), new RVAdapter.OnViewHolderClick() {
                        @Override
                        public void onClick(View view, int position, Object item) {
                            List<TtCtSubGiro_> listSubGiro = new ArrayList<TtCtSubGiro_>();
                            for (TtCtSubGiro_ subgiro : res.getResponse().getTtCtSubGiro().getTtCtSubGiro()) {
                                if(subgiro.getIGiro() == ((TtCtGiro_) item).getIGiro())
                                    listSubGiro.add(subgiro);
                            }
                            System.out.println(listSubGiro.toString());
                            Intent vistaNueva = new Intent(getActivity(), SubGirosActivity.class);
                            vistaNueva.putExtra("list", (Serializable) listSubGiro);
                            startActivity(vistaNueva);
                        }
                    });
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
            public void onFailure(Call<Respuesta> call, Throwable t) {
                System.out.println("Error: " + t.getMessage());
            }
        });

        return view;
    }
}
