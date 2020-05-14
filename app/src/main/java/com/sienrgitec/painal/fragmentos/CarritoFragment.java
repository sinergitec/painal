package com.sienrgitec.painal.fragmentos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.carrito.CarritoSingleton;
import com.sienrgitec.painal.componente.recycler.CarritoAdapter;
import com.sienrgitec.painal.pojo.carrito.Carrito;
import com.sienrgitec.painal.pojo.entity.TtOpPedido;
import com.sienrgitec.painal.pojo.entity.TtOpPedidoDet;
import com.sienrgitec.painal.pojo.entity.TtOpPedidoDomicilio;
import com.sienrgitec.painal.pojo.entity.TtOpPedidoPago;
import com.sienrgitec.painal.pojo.entity.TtOpPedidoProveedor;
import com.sienrgitec.painal.pojo.peticion.DsNvoPedido;
import com.sienrgitec.painal.pojo.peticion.Peticion;
import com.sienrgitec.painal.pojo.peticion.Request;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;
import com.sienrgitec.painal.util.Funcionalidades;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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
        final Button button = view.findViewById(R.id.realizaPedido);
        cargaInfoCarrito(view);
        vaciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarritoSingleton.getInstance().vaciarCarrito(v.getContext());
                cargaInfoCarrito(view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizaPedido(v);
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
        Double totalD = subTotalCarrito(CarritoSingleton.getInstance().getListaCarrito());

        LinearLayoutManager llm = new LinearLayoutManager(view.getContext());
        rvListaCarrito.setLayoutManager(llm);
        CarritoAdapter carritoAdapter = new CarritoAdapter(view.getContext(), null);
        carritoAdapter.setList(CarritoSingleton.getInstance().getListaCarrito());
        rvListaCarrito.setAdapter(carritoAdapter);

        totalArticulos.setText("Cantidad de articulos: " + sizeList);
        total.setText(Funcionalidades.retornaDoubleEnMoneda(totalD));
    }

    private Double subTotalCarrito (List<Carrito> carritoList){
        Double totalD = 0.0;
        for (Carrito articulo: CarritoSingleton.getInstance().getListaCarrito()) {
            totalD += articulo.getMonto();
        }
        return  totalD;
    }

    private Double totalCarrtio(Double subTotal, Double impuesto){
        return subTotal * (1+impuesto);
    }

    private void realizaPedido(View v){

        final TtOpPedido pedido =
                new TtOpPedido("0", "1", String.valueOf(CarritoSingleton.getInstance().getCliente().getiCliente()),
                        "TODAY", "1", String.valueOf(CarritoSingleton.getInstance().getNumeroProveedores()),
                        String.valueOf(CarritoSingleton.getInstance().getListaCarrito().size()),
                        String.valueOf(subTotalCarrito(CarritoSingleton.getInstance().getListaCarrito())),
                        "0", "16", String.valueOf(subTotalCarrito(CarritoSingleton.getInstance().getListaCarrito())),
                        "1", "1", "1", "1", "", "",
                        "NOW", "", "AUTO", "", CarritoSingleton.getInstance().getUsuario_().getcUsuario(),
                        CarritoSingleton.getInstance().getUsuario_().getcUsuario(), "0");

        final List<TtOpPedidoProveedor> listaOpPedidoProveedor = new ArrayList<>();
        final List<TtOpPedidoDet> listaOpPedidoDet = new ArrayList<>();

        llenaListaOpPedidoProveedorYOpPedidoDet(listaOpPedidoProveedor, listaOpPedidoDet);

        final TtOpPedidoDomicilio opPedidoDomicilio = new TtOpPedidoDomicilio("0",
                "1",String.valueOf(CarritoSingleton.getInstance().getCliente().getiCliente()),
                "TRUE","NOW","","AUTO","");

        final TtOpPedidoPago opPedidoPago = new TtOpPedidoPago("3","1","1",
                String.valueOf(totalCarrtio(subTotalCarrito(CarritoSingleton.getInstance().getListaCarrito()), 16.0)),
                "0","0","0","NOW","",
                "AUTO",String.valueOf(CarritoSingleton.getInstance().getCliente().getiCliente()),
                "1","1050125");

        final Peticion peticion = new Peticion(new Request(new DsNvoPedido(new ArrayList<TtOpPedido>() {
            {
                add(pedido);
            }
        },
        listaOpPedidoProveedor, listaOpPedidoDet,
         new ArrayList<TtOpPedidoDomicilio>(){
             {
                 add(opPedidoDomicilio);
             }
         },
         new ArrayList<TtOpPedidoPago>(){
             {
                 add(opPedidoPago);
             }
         })));
        final Painal service = ServiceGenerator.createService(Painal.class);
        final Call<Respuesta> call = service.creaPedido(peticion);

        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                if(response.isSuccessful()){
                    Respuesta res = response.body();

                    if(res.getResponse().getOplError().equalsIgnoreCase("true")){
                        Toast.makeText(v.getContext(), "Pedido no realizado", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(v.getContext(), "Pedido realizado", Toast.LENGTH_LONG).show();
                        CarritoSingleton.getInstance().vaciarCarrito(v.getContext());
                    }
                } else {
                    Toast.makeText(v.getContext(), "Pedido no realizado", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {
                System.out.println(t.getMessage());
                Toast.makeText(v.getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }

    private void llenaListaOpPedidoProveedorYOpPedidoDet(List<TtOpPedidoProveedor> listaOpPedidoProveedor, List<TtOpPedidoDet> listDetalle){
        Integer proveedorPedido = 1;
        for (int i = 0; i < CarritoSingleton.getInstance().getPilaProveedores().size() ; i++) {
            Integer partida = 1;
            Double totalPedidoProveedor = 0.0;
            for (Carrito item: CarritoSingleton.getInstance().getListaCarrito()) {
                if(CarritoSingleton.getInstance().getPilaProveedores().get(i).compareTo(item.getArticulo().getIProveedor()) == 0){
                    listDetalle.add(new TtOpPedidoDet(String.valueOf(partida * 4),
                            String.valueOf(partida),
                            String.valueOf(proveedorPedido),
                            "TODAY",
                            String.valueOf(item.getArticulo().getIArticulo()),
                            item.getArticulo().getCArticulo(),
                            item.getArticulo().getCDescripcion(),
                            "",
                            "FALSE",
                            "",
                            "16",
                            "",
                            String.valueOf(item.getArticulo().getDePrecioVtaPza()),
                            "0",
                            "0",
                            String.valueOf(item.getArticulo().getDePrecioVtaPza()),
                            String.valueOf(item.getCantidadArticulo()),
                            String.valueOf(item.getMonto()),
                            "0",
                            "",
                            "0",
                            "0",
                            "",
                            "NOW",
                            "",
                            "AUTO",
                            ""));
                    partida ++;
                    totalPedidoProveedor += item.getArticulo().getDePrecioVtaPza();
                }
            }

            listaOpPedidoProveedor.add(new TtOpPedidoProveedor(String.valueOf(proveedorPedido * 6),String.valueOf(proveedorPedido),
                    String.valueOf(CarritoSingleton.getInstance().getPilaProveedores().get(i)),
                    "TODAY","0",
                    "1",String.valueOf(partida.compareTo(1) > 0 ? partida - 1 : partida),
                    String.valueOf(totalPedidoProveedor),
                    "16",String.valueOf(totalPedidoProveedor),
                    "","FALSE","TRUE","NOW","FALSE",
                    "10","0","0","FALSE","",
                    "0","FALSE","","0","0",
                    "NOW","","AUTO",""));

            proveedorPedido ++;
        }
    }

}
