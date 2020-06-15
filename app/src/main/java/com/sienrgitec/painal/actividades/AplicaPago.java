package com.sienrgitec.painal.actividades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.carrito.CarritoSingleton;
import com.sienrgitec.painal.componente.recycler.CarritoAdapter;
import com.sienrgitec.painal.constante.Constantes;
import com.sienrgitec.painal.pojo.carrito.Carrito;
import com.sienrgitec.painal.pojo.entity.TtCtComisiones_;
import com.sienrgitec.painal.pojo.entity.TtCtFormasPago_;
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

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AplicaPago extends AppCompatActivity {

    private TextView etContacto, etDomicilio, etMonto, etAporta, etPropina, etSubtotal, etTotal;
    private Button btnPagar;
    RelativeLayout rlEstadoProc, rlPropinas, rlTitlani;
    private Integer iFormaPago = 0, iComision = 0, iTitlaniP = 0;
    private double deAporta = 0.0 , dePropina = 0.0, vdeSubtotal = 0.00, vdeMonto =0.00,
            dePorcCom = 0.00, dePorcProp = 0.00;
    private Constantes constantes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aplica_pago);

        Intent i = getIntent();
        vdeSubtotal = getIntent().getExtras().getDouble("vdeimporte");
        /*List<TtOpPedido> oppedidoList = (List<TtOpPedido>) getIntent().getSerializableExtra("opPedidoList");
        ArrayList<TtOpPedidoDomicilio> opPedidoDomicilio = (ArrayList<TtOpPedidoDomicilio>) getIntent().getSerializableExtra("opPedidoDomList");*/



        cargaInfoCarrito(  );

        rlEstadoProc = findViewById(R.id.edoproc);
        rlPropinas  = findViewById(R.id.edoprop);
        rlTitlani   = findViewById(R.id.edtitlani);
        etContacto  = findViewById (R.id.textView28);
        etDomicilio = findViewById(R.id.textView29);
        etSubtotal  = findViewById(R.id.textView21);
        etTotal     = findViewById(R.id.tvTotal);
        etAporta    = findViewById(R.id.tvAporta);
        etPropina   = findViewById(R.id.tvPropina);
        etMonto     = findViewById(R.id.textView25);
        btnPagar    = findViewById(R.id.btnPagoF);

        btnPagar.setOnClickListener(v -> CreaCompra(v));

        CargaFPagos();
        CargaComisiones();

        etContacto.setText("Contacto: " + String.valueOf(CarritoSingleton.getInstance().getCliente().getcNombre()));
        etDomicilio.setText(CarritoSingleton.getInstance().getDomicilio().get(0).getCCalle() + " "  + CarritoSingleton.getInstance().getDomicilio().get(0).getCNumeroExt()
                + " " + CarritoSingleton.getInstance().getDomicilio().get(0).getCColonia());
        etSubtotal.setText(vdeSubtotal + "0");
        etTotal.setText(vdeSubtotal + "0");

    }

    private void cargaInfoCarrito(){

        // Se invoca al llenado de la lista

        // Se invoca al llenado de la lista
        CarritoSingleton.getInstance().consultaItemCarrito(AplicaPago.this);
        Integer sizeList = CarritoSingleton.getInstance().getListaCarrito().size();
        Double totalD = subTotalCarrito(CarritoSingleton.getInstance().getListaCarrito());

        LinearLayoutManager llm = new LinearLayoutManager(AplicaPago.this);

        CarritoAdapter carritoAdapter = new CarritoAdapter(AplicaPago.this, null);
        carritoAdapter.setList(CarritoSingleton.getInstance().getListaCarrito());






    }

    private void CargaFPagos(){

        final Painal service = ServiceGenerator.createService(Painal.class);
        Map<String, String> data = new HashMap<>();
        //data.put("ipiCliente", String.valueOf(CarritoSingleton.getInstance().getCliente().getiCliente()));

        final Call<Respuesta> call = service.ctFormasPago(data);
        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                Respuesta res = response.body();

                if (response.isSuccessful()) {
                    if (res.getResponse().getOplError().equals("true")) {
                        Toast.makeText(AplicaPago.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();

                    }else {
                        int vxMod = 0, vyMod = 0,viPago = 0;
                        RadioGroup rgEstadoP = new RadioGroup(AplicaPago.this);
                        rgEstadoP.setOrientation(RadioGroup.HORIZONTAL);

                        for (final TtCtFormasPago_ objctFPago : res.getResponse().getTt_ctFormasPago().getTtCtFormasPago()) {

                            viPago = viPago + 1;

                            RadioButton rbEdoProceso = new RadioButton(AplicaPago.this);
                            rbEdoProceso.setText(objctFPago.getcFormaPago());
                            rbEdoProceso.setHeight(75);
                            rbEdoProceso.setLayoutParams(new RadioGroup.LayoutParams(180, 50)); //150

                            rgEstadoP.addView(rbEdoProceso);

                            if (viPago % 3 == 0) {
                                vxMod = 0;
                                vyMod = vyMod + 35;
                            } else {
                                vxMod = vxMod + 80;
                            }

                            rbEdoProceso.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    iFormaPago =  objctFPago.getiFormaPago();

                                }
                            });

                        }
                        rlEstadoProc.addView(rgEstadoP);
                    }
                } else {
                    Toast.makeText(AplicaPago.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {
                Toast.makeText(AplicaPago.this, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });

    }

    private void CargaComisiones(){
        final Painal service = ServiceGenerator.createService(Painal.class);
        Map<String, String> data = new HashMap<>();
        data.put("ipiPersona", String.valueOf(5));

        final Call<Respuesta> call = service.ctComisiones(data);
        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                Respuesta res = response.body();

                if (response.isSuccessful()) {
                    if (res.getResponse().getOplError().equals("true")) {
                        Toast.makeText(AplicaPago.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();

                    }else {
                        int vxMod = 0, vyMod = 0,viPago = 0;
                        RadioGroup rgPropinas = new RadioGroup(AplicaPago.this);
                        rgPropinas.setOrientation(RadioGroup.HORIZONTAL);


                        RadioGroup rgTitlani = new RadioGroup(AplicaPago.this);
                        rgTitlani.setOrientation(RadioGroup.HORIZONTAL);

                        for (final TtCtComisiones_ objCtComision : res.getResponse().getTtCtComisiones().getTtCtComisiones_()) {

                            viPago = viPago + 1;

                            RadioButton rbAgregaP = new RadioButton(AplicaPago.this);
                            rbAgregaP.setText(objCtComision.getDeValor().toString());
                            rbAgregaP.setHeight(75);
                            rbAgregaP.setLayoutParams(new RadioGroup.LayoutParams(125, 70)); //150


                            RadioButton rbTitlaniP = new RadioButton(AplicaPago.this);
                            rbTitlaniP.setText(objCtComision.getDeValor().toString());
                            rbTitlaniP.setHeight(75);
                            rbTitlaniP.setLayoutParams(new RadioGroup.LayoutParams(125, 70)); //150

                            rgPropinas.addView(rbAgregaP);
                            rgTitlani.addView(rbTitlaniP);

                            rbAgregaP.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    iComision =  objCtComision.getiComision();
                                    dePorcCom =  objCtComision.getDeValor();
                                    CalculaAportacion(objCtComision.getDeValor());

                                }
                            });

                            rbTitlaniP.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {
                                    iTitlaniP  =  objCtComision.getiComision();
                                    dePorcProp =  objCtComision.getDeValor();
                                    CalculaPropina(objCtComision.getDeValor());

                                }
                            });

                        }
                        rlPropinas.addView(rgPropinas);
                        rlTitlani.addView(rgTitlani);
                    }
                } else {
                    Toast.makeText(AplicaPago.this, res.getResponse().getOpcError(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {
                Toast.makeText(AplicaPago.this, t.getMessage(), Toast.LENGTH_LONG).show();

            }
        });



    }

    private void CalculaAportacion(double vdeValor){
        double vdeMonto = 0.00;
        vdeMonto = ((vdeValor / 100) * vdeSubtotal);
        deAporta = vdeMonto;
        String vdeMontoS = new DecimalFormat("0.00").format(vdeMonto);
        etAporta.setText("$" + vdeMontoS);
        String vdeTotalF = new DecimalFormat("0.00").format(vdeSubtotal + deAporta + dePropina);
        etTotal.setText("$" + (vdeTotalF));

    }

    private void CalculaPropina(double vdeValor){
        double vdeMonto = 0.00, vdeTotal = 0.00;
        vdeMonto = ((vdeValor / 100) * vdeSubtotal);
        dePropina = vdeMonto;
        String vdeMontoS = new DecimalFormat("0.00").format(vdeMonto);
        etPropina.setText("$" + vdeMontoS);
        String vdeTotalF = new DecimalFormat("0.00").format(vdeSubtotal + deAporta + dePropina);
        etTotal.setText("$" + (vdeTotalF));

    }

    private void CreaCompra(View v) {

        final TtOpPedido pedido =
                new TtOpPedido("0", "1", String.valueOf(CarritoSingleton.getInstance().getCliente().getiCliente()),
                        "TODAY", "1", String.valueOf(CarritoSingleton.getInstance().getNumeroProveedores().compareTo(Constantes.CANTIDAD_MAX_PROVEEDORES) > 0 ? CarritoSingleton.getInstance().getNumeroProveedores() - 1 : CarritoSingleton.getInstance().getNumeroProveedores()),
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
                CarritoSingleton.getInstance().getDomicilio().get(0).getIDomicilio(),String.valueOf(CarritoSingleton.getInstance().getCliente().getiCliente()),
                "TRUE","NOW","","AUTO","");

        final TtOpPedidoPago opPedidoPago = new TtOpPedidoPago("0","1","1",
                String.valueOf(totalCarrtio(subTotalCarrito(CarritoSingleton.getInstance().getListaCarrito()), 16.0)),
                "0","0","0","NOW","",
                "AUTO",String.valueOf(CarritoSingleton.getInstance().getCliente().getiCliente()),
                "1","012021225");


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

    private void llenaListaOpPedidoProveedorYOpPedidoDet(List<TtOpPedidoProveedor> listaOpPedidoProveedor, List<TtOpPedidoDet> listDetalle){
        Integer proveedorPedido = 1;
        for (int i = 0; i < CarritoSingleton.getInstance().getPilaDomicilios().size() ; i++) {
            Integer partida = 1;
            Double totalPedidoProveedor = 0.0;
            for (Carrito item: CarritoSingleton.getInstance().getListaCarrito()) {
                if(CarritoSingleton.getInstance().getPilaProveedores().get(i).compareTo(item.getArticulo().getIProveedor()) == 0
                        && CarritoSingleton.getInstance().getPilaDomicilios().get(i).
                        equals(String.valueOf(item.getArticulo().getIProveedor())+ "," + String.valueOf(item.getArticulo().getiDomicilio()))){
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

            String [] proveedorDomicilio = CarritoSingleton.getInstance().getPilaDomicilios().get(i).split(",");

            listaOpPedidoProveedor.add(new TtOpPedidoProveedor(String.valueOf(proveedorPedido * 6),String.valueOf(proveedorPedido),
                    proveedorDomicilio[0],
                    "TODAY","0",
                    proveedorDomicilio[1],
                    String.valueOf(partida.compareTo(1) > 0 ? partida - 1 : partida),
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