package com.sienrgitec.painal.componente.recycler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.componente.RVAdapter;
import com.sienrgitec.painal.pojo.entity.TtCtContacto_;

public class ContactoAdapter  extends RVAdapter<TtCtContacto_> {
    public ContactoAdapter(Context context, RVAdapter.OnViewHolderClick<TtCtContacto_> listener) {
        super(context, listener);
    }

    @Override
    protected View createView(Context context, ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recycler_contacto, viewGroup, false);
        return view;
    }

    @Override
    protected void bindView(TtCtContacto_ item, RVAdapter.ListViewHolder viewHolder) {
        if (item != null) {

            TextView nombre = (TextView)viewHolder.getView(R.id.nombre);
            nombre.setText(item.getcNombre() + ' ' + item.getcApellidos());
        }
    }
}
