package com.sienrgitec.painal.componente.recycler;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.actividades.HistoDetPedido;
import com.sienrgitec.painal.componente.RVAdapter;
import com.sienrgitec.painal.pojo.entity.TtOpPedido;
import com.sienrgitec.painal.pojo.entity.TtOpPedidoDet;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class HistoricoAdapter extends RVAdapter<TtOpPedido> {

    private List <TtOpPedidoDet> detallePed =  new ArrayList<>();
    public HistoricoAdapter(Context context, RVAdapter.OnViewHolderClick<TtOpPedido> listener, List<TtOpPedidoDet> detallePed) {
        super(context, listener);
        this.detallePed = detallePed;
    }

    @Override
    protected View createView(Context context, ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recycler_historico_pedidos, viewGroup, false);
        return view;
    }

    @Override
    protected void bindView(TtOpPedido item, RVAdapter.ListViewHolder viewHolder) {
        if (item != null) {

            ImageView btnEditar  = (ImageView)viewHolder.getView(R.id.imageView8);
            btnEditar.setOnClickListener(v -> {

                List <TtOpPedidoDet> enviarListDetalle =  new ArrayList<>();

                for (TtOpPedidoDet detalle: detallePed ){

                    if(detalle.getIPedido().equals(item.getIPedido())){
                        enviarListDetalle.add(detalle);
                    }
                }

                Intent verDetalle = new Intent(viewHolder.getView().getContext(), HistoDetPedido.class);
                verDetalle.putExtra("objMostrarDetalle", (Serializable) enviarListDetalle);
                viewHolder.getView().getContext().startActivity(verDetalle);
            });


            TextView numPedido = (TextView)viewHolder.getView(R.id.pedido1);
            numPedido.setText(item.getIPedido());

            TextView fecha = (TextView)viewHolder.getView(R.id.fecha1);
            fecha.setText(item.getDtFecha());

            TextView estatus = (TextView)viewHolder.getView(R.id.estatus1);
            estatus.setText(item.getcEdoProc());

            TextView totalP = (TextView)viewHolder.getView(R.id.total1);
            totalP.setText(item.getDeImporte());
        }
    }
}
