package com.sienrgitec.painal.componente.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.componente.RVAdapter;
import com.sienrgitec.painal.pojo.entity.TtOpPedidoDet;

public class HistoricoDetAdapter extends RVAdapter<TtOpPedidoDet> {
    public HistoricoDetAdapter(Context context, OnViewHolderClick<TtOpPedidoDet> listener, TtOpPedidoDet detalle) {
        super(context, listener);
    }

    @Override
    protected View createView(Context context, ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recycler_detalle_pedido, viewGroup, false);
        return view;
    }

    @Override
    protected void bindView(TtOpPedidoDet item, RVAdapter.ListViewHolder viewHolder) {
        if (item != null) {

            TextView articulo = (TextView)viewHolder.getView(R.id.pedido1);
            articulo.setText(item.getCDescricpcion());

            TextView obs = (TextView)viewHolder.getView(R.id.fecha1);
            obs.setText(item.getCObs());

            TextView cantidad = (TextView)viewHolder.getView(R.id.estatus1);
            cantidad.setText(item.getDeCantidad());

            TextView precio = (TextView)viewHolder.getView(R.id.total1);
            precio.setText(item.getDePrecioUnit());

            TextView total = (TextView)viewHolder.getView(R.id.totlaPrecio);
            total.setText(item.getDeImporte());
        }
    }
}
