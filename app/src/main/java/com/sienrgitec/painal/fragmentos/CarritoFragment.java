package com.sienrgitec.painal.fragmentos;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.actividades.AplicaPago;
import com.sienrgitec.painal.actividades.NvoPagoActivity;
import com.sienrgitec.painal.actividades.SaldosActivity;
import com.sienrgitec.painal.carrito.CarritoSingleton;
import com.sienrgitec.painal.componente.recycler.CarritoAdapter;
import com.sienrgitec.painal.constante.Constantes;
import com.sienrgitec.painal.pojo.carrito.Carrito;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;
import com.sienrgitec.painal.util.Funcionalidades;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.sienrgitec.painal.constante.Constantes.vdeSaldo;


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
    private Double vdeImporte = 0.00;
    private Constantes constantes;
    RecyclerView rvListaCarrito;
    CarritoAdapter carritoAdapter;
    TextView totalArticulos;
    TextView total;
    TextView cantArt;

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
        /**Se agrega para mostrar saldo**/
        RecuperaSaldo(view);


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

                ProgressDialog nDialog;
                nDialog = new ProgressDialog(getContext());
                nDialog.setMessage("Alerta...");
                nDialog.setTitle("Alerta");
                nDialog.setIndeterminate(false);
                nDialog.show();


                Double totalD = 0.0;
                for (Carrito articulo: CarritoSingleton.getInstance().getListaCarrito()) {
                    totalD += articulo.getMonto();
                }


                if (totalD >= vdeSaldo){
                    AlertDialog.Builder myBuild = new AlertDialog.Builder(getContext());
                    myBuild.setMessage("No puedes realizar este pedido. "  +  '\n' +  "Tu saldo actual es de: " + vdeSaldo + "0" + '\n' +
                            "Saldo Total del pedido: " + totalD + "0"
                            +  '\n' + "Te invitamos a realizar una recarga  o a eliminar productos de la lista para continuar");
                    myBuild.setTitle(Html.fromHtml("<font color ='#FF0000'> ¡Saldo Insuficiente! </font>"));
                    myBuild.setPositiveButton("Recargar Saldo", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent recarga = new Intent(getContext(), SaldosActivity.class);
                            recarga.putExtra("cuenta", "");
                            getContext().startActivity(recarga);
                        }
                    });
                    myBuild.setNegativeButton("Eliminar Productos", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            return;
                        }
                    });

                    AlertDialog dialog = myBuild.create();
                    dialog.show();
                    nDialog.dismiss();

                    return;
                }
                Intent aplicaPago = new Intent(getContext(), AplicaPago.class);
                aplicaPago.putExtra("vdeimporte", totalD);
                startActivity(aplicaPago);
            }
        });
        // Inflate the layout for this fragment
        return view;
    }

    private void cargaInfoCarrito(View view){
        rvListaCarrito = view.findViewById(R.id.listaCarrito);
        totalArticulos = view.findViewById(R.id.cantidadArt);
        total = view.findViewById(R.id.total);
        cantArt = view.findViewById(R.id.cantArti);
        // Se invoca al llenado de la lista
        CarritoSingleton.getInstance().consultaItemCarrito(view.getContext());
        Integer sizeList = CarritoSingleton.getInstance().getListaCarrito().size();
        Double totalD = subTotalCarrito(CarritoSingleton.getInstance().getListaCarrito());
        Double totalCant = totalArticulo(CarritoSingleton.getInstance().getListaCarrito());

        LinearLayoutManager llm = new LinearLayoutManager(view.getContext());
        rvListaCarrito.setLayoutManager(llm);
        carritoAdapter = new CarritoAdapter(view.getContext(), null, totalArticulos, total, cantArt, sizeList, totalD, totalCant);
        carritoAdapter.setList(CarritoSingleton.getInstance().getListaCarrito());
        rvListaCarrito.setAdapter(carritoAdapter);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(rvListaCarrito);

        totalArticulos.setText("Art Dif: " + sizeList);
        total.setText(Funcionalidades.retornaDoubleEnMoneda(totalD));
        cantArt.setText(totalCant.toString());
    }

    private Double totalArticulo(List<Carrito> listaCarrito) {
        Double totalCant = 0.0;
        for (Carrito cantidad: CarritoSingleton.getInstance().getListaCarrito()) {
            totalCant += cantidad.getCantidadArticulo();
        }
        return  totalCant;
    }

    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int position = viewHolder.getAdapterPosition() + 1;
            switch (direction){
                case ItemTouchHelper.LEFT :
                    System.out.println("Eliminar: " + position);
                    CarritoSingleton.getInstance().eliminarArticuloCarrito(viewHolder.itemView.getContext(), position);
                    carritoAdapter.notifyItemRemoved(position - 1);

                    Integer sizeList = CarritoSingleton.getInstance().getListaCarrito().size();
                    Double totalD = subTotalCarrito(CarritoSingleton.getInstance().getListaCarrito());
                    Double totalCant = totalArticulo(CarritoSingleton.getInstance().getListaCarrito());

                    totalArticulos.setText("Art Dif: " + sizeList );
                    total.setText(Funcionalidades.retornaDoubleEnMoneda(totalD));
                    cantArt.setText(totalCant.toString());

                    Toast.makeText(viewHolder.itemView.getContext(),"Articulo eliminado", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    private void RecuperaSaldo(View view ){

        TextView tvSaldo = view.findViewById(R.id.saldo);

        final Painal service = ServiceGenerator.createService(Painal.class);
        Map<String, String> data = new HashMap<>();
        data.put("ipiCliente", String.valueOf(CarritoSingleton.getInstance().getCliente().getiCliente()));

        final Call<Respuesta> call = service.credEncCPCP(data);
        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                Respuesta res = response.body();

                if (response.isSuccessful()) {
                    if (res.getResponse().getOplError().equals("true")) {
                        //Toast.makeText(getContext(), res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();

                    }else {

                        String vdeSaldo = new DecimalFormat("0.00").format(Double.parseDouble(res.getResponse().getTt_credEncCPCP().getTtCredEncCPCP().get(0).getDeSaldo()));
                        SpannableString txtdeCant = new SpannableString(vdeSaldo);
                        tvSaldo.setText("Saldo Disponible" + "\n" + txtdeCant);
                        constantes.vcCuenta = (res.getResponse().getTt_credEncCPCP().getTtCredEncCPCP().get(0).getcCuenta());

                    }
                } else {
                    Toast.makeText(getContext(), res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });
    }

    private Double subTotalCarrito (List<Carrito> carritoList){
        Double totalD = 0.0;
        for (Carrito articulo: CarritoSingleton.getInstance().getListaCarrito()) {
            totalD += articulo.getMonto();

        }
        vdeImporte = totalD;
        return  totalD;
    }

    private Double totalCarrtio(Double subTotal, Double impuesto){
        return subTotal * (1+impuesto);
    }
}
