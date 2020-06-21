package com.sienrgitec.painal.componente.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sienrgitec.painal.R;
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
            ImageView editarDireccion = (ImageView) viewHolder.getView(R.id.imageView12);
            ImageView elimianrDireccion = (ImageView) viewHolder.getView(R.id.borrarDomicilio);

            aliasDireccion.setText(item.getCCalle() + " " + (item.getCNumeroExt() != null ? item.getCNumeroExt() : "SN"));
            if(!item.getIDomicilio().equals(CarritoSingleton.getInstance().getDomicilioActual().getIDomicilio())){
               domicilioActual.setVisibility(View.INVISIBLE);
            }

        }
    }

}
