package com.sienrgitec.painal.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.carrito.CarritoSingleton;
import com.sienrgitec.painal.componente.recycler.CarritoAdapter;
import com.sienrgitec.painal.pojo.carrito.Carrito;
import com.sienrgitec.painal.util.Funcionalidades;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CarritoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CarritoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CarritoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CarritoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CarritoFragment newInstance(String param1, String param2) {
        CarritoFragment fragment = new CarritoFragment();
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
        final View view = inflater.inflate(R.layout.fragment_carrito, container, false);
        final TextView vaciar = view.findViewById(R.id.vaciar);
        cargaInfoCarrito(view);
        vaciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarritoSingleton.getInstance().vaciarCarrito(v.getContext());
                cargaInfoCarrito(view);
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    private void cargaInfoCarrito(View view){
        RecyclerView rvListaCarrito = view.findViewById(R.id.listaCarrito);
        TextView totalArticulos = view.findViewById(R.id.cantidadArt);
        TextView total = view.findViewById(R.id.total);
        // Se invoca al llenado de la lista
        CarritoSingleton.getInstance().consultaItemCarrito(view.getContext());
        Integer sizeList = CarritoSingleton.getInstance().getListaCarrito().size();
        Double totalD = 0.0;
        for (Carrito articulo: CarritoSingleton.getInstance().getListaCarrito()) {
            System.out.println(articulo.toString());
            totalD += articulo.getMonto();
        }

        LinearLayoutManager llm = new LinearLayoutManager(view.getContext());
        rvListaCarrito.setLayoutManager(llm);
        CarritoAdapter carritoAdapter = new CarritoAdapter(view.getContext(), null);
        carritoAdapter.setList(CarritoSingleton.getInstance().getListaCarrito());
        rvListaCarrito.setAdapter(carritoAdapter);

        totalArticulos.setText("Cantidad de articulos: " + sizeList);
        total.setText(Funcionalidades.retornaDoubleEnMoneda(totalD));
    }
}
