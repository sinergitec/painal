package com.sienrgitec.painal.componente.recycler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.actividades.EliminaAutorizados;
import com.sienrgitec.painal.actividades.EliminaDirecciones;
import com.sienrgitec.painal.carrito.CarritoSingleton;
import com.sienrgitec.painal.componente.RVAdapter;
import com.sienrgitec.painal.pojo.entity.TtCtDomicilio_;

public class ListaDomicilioAdapter extends RVAdapter<TtCtDomicilio_> {

    public ListaDomicilioAdapter(Context context, OnViewHolderClick listener){
        super(context, listener);
    }

    @Override
    protected View createView(Context context, ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recycler_lista_domicilios, viewGroup, false);
        return view;
    }

    @Override
    protected void bindView(TtCtDomicilio_ item, RVAdapter.ListViewHolder viewHolder) {
        if (item != null) {
            ImageView domicilioActual = (ImageView) viewHolder.getView(R.id.direccionPrincipal);
            TextView aliasDireccion = (TextView) viewHolder.getView(R.id.aliasDireccion);


            aliasDireccion.setText(item.getCCalle() + " " + (item.getcNumExt() != null ? item.getcNumExt() : "SN"));
            if(!item.getIDomicilio().equals(CarritoSingleton.getInstance().getDomicilioActual().getIDomicilio())){
               domicilioActual.setVisibility(View.INVISIBLE);
            }

            ImageView elimianrDireccion = (ImageView) viewHolder.getView(R.id.borrarDomicilio);
            elimianrDireccion.setOnClickListener(v ->{
                Intent elimina = new Intent(viewHolder.getView().getContext(), EliminaDirecciones.class);
                elimina.putExtra("objEliminar", item);
                viewHolder.getView().getContext().startActivity(elimina);


            });

        }
    }

}
