package com.sienrgitec.painal.componente.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.componente.DownloadImageTask;
import com.sienrgitec.painal.componente.RVAdapter;
import com.sienrgitec.painal.pojo.carrito.Carrito;
import com.sienrgitec.painal.util.Funcionalidades;

public class CarritoAdapter extends RVAdapter<Carrito> {

    public CarritoAdapter(Context context, OnViewHolderClick<Carrito> listener) {
        super(context, listener);
    }

    @Override
    protected View createView(Context context, ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recycler_articulo_carrito, viewGroup, false);
        return view;
    }

    @Override
    protected void bindView(Carrito item, RVAdapter.ListViewHolder viewHolder) {
        if (item != null) {
            ImageView photo = (ImageView)viewHolder.getView(R.id.artImg);
            TextView descripcion = (TextView)viewHolder.getView(R.id.nombre);
            TextView precio = (TextView)viewHolder.getView(R.id.precio);

            descripcion.setText(item.getArticulo().getCDescripcion());
            precio.setText(Funcionalidades.retornaDoubleEnMoneda(item.getMonto()));
            new DownloadImageTask(photo).execute("https://images.unsplash.com/photo-1414235077428-338989a2e8c0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");

        }
    }
}
