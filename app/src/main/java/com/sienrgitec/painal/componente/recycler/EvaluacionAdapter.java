package com.sienrgitec.painal.componente.recycler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.actividades.FamilyActualiza;
import com.sienrgitec.painal.actividades.FamilyListActivity;
import com.sienrgitec.painal.carrito.CarritoSingleton;
import com.sienrgitec.painal.componente.Loading;
import com.sienrgitec.painal.componente.RVAdapter;
import com.sienrgitec.painal.pojo.entity.TtCtClienteAutorizados_;
import com.sienrgitec.painal.pojo.entity.Tt_CtEvaluacion_;
import com.sienrgitec.painal.pojo.entity.Tt_OpClienteEvalua_;
import com.sienrgitec.painal.pojo.peticion.DsCtClienteAutorizados;
import com.sienrgitec.painal.pojo.peticion.DsNvaEvaluacion;
import com.sienrgitec.painal.pojo.peticion.Peticion;
import com.sienrgitec.painal.pojo.peticion.Request;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EvaluacionAdapter extends RVAdapter<Tt_CtEvaluacion_> {
    public EvaluacionAdapter(Context context, RVAdapter.OnViewHolderClick<Tt_CtEvaluacion_> listener) {
        super(context, listener);
    }

    @Override
    protected View createView(Context context, ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recycler_evaluacionprov, viewGroup, false);
        return view;
    }

    @Override
    protected void bindView(Tt_CtEvaluacion_ item, RVAdapter.ListViewHolder viewHolder) {
        if (item != null) {

            TextView evalua = (TextView)viewHolder.getView(R.id.tipo);
            evalua.setText(item.getcEvalua());

            RatingBar ratingBar;
            Button btnEvaluar;

            ratingBar  = (RatingBar)viewHolder.getView(R.id.ratingBar);
            btnEvaluar = (Button)viewHolder.getView(R.id.button);
            btnEvaluar.setOnClickListener(v -> {

                String s = String.valueOf(ratingBar.getRating());
                Toast.makeText(getContext(), "Valor" + s, Toast.LENGTH_LONG).show();

                Tt_OpClienteEvalua_ objEvalua = new Tt_OpClienteEvalua_();

                objEvalua.setiEvalua(item.getiEvalua());
                objEvalua.setiPedido(1);
                objEvalua.setiPersona(CarritoSingleton.getInstance().getCliente().getiCliente());
                objEvalua.setiPunto(item.getiPunto());
                objEvalua.setiTipoPersona(0);
                objEvalua.setcObs("");
                objEvalua.setcTipo(item.getcTipo());
                objEvalua.setcUsuCrea(CarritoSingleton.getInstance().getUsuario_().getcUsuario());
                objEvalua.setcUsuModifica(CarritoSingleton.getInstance().getUsuario_().getcUsuario());
                objEvalua.setcValor(s);
                objEvalua.setDtCreado(null);
                objEvalua.setDtFecha(null);

                Peticion peticion = new Peticion(new Request(new DsNvaEvaluacion(new ArrayList<Tt_OpClienteEvalua_>() {
                    {
                        add(objEvalua);
                    }
                }, "Cliente")));

                final Painal service = ServiceGenerator.createService(Painal.class);
                final Call<Respuesta> call = service.ctEvaluacionPost(peticion);

                call.enqueue(new Callback<Respuesta>() {
                    @Override
                    public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                        System.out.println(response.toString());
                    }

                    @Override
                    public void onFailure(Call<Respuesta> call, Throwable t) {
                        System.out.println(t.getMessage());

                    }
                });


            });
        }
    }
}
