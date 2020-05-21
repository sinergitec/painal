package com.sienrgitec.painal.componente.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.componente.RVAdapter;
import com.sienrgitec.painal.pojo.entity.TtCtClienteAutorizados_;


public class FamilyAdapter extends RVAdapter<TtCtClienteAutorizados_> {
    public FamilyAdapter(Context context, RVAdapter.OnViewHolderClick<TtCtClienteAutorizados_> listener) {
        super(context, listener);
    }

    @Override
    protected View createView(Context context, ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recycler_autorizados, viewGroup, false);
        return view;
    }

    @Override
    protected void bindView(TtCtClienteAutorizados_ item, RVAdapter.ListViewHolder viewHolder) {
        if (item != null) {

            TextView nombre = (TextView)viewHolder.getView(R.id.nombre);
            nombre.setText(item.getcNombre() + ' ' + item.getcApellidos());

            TextView edad = (TextView)viewHolder.getView(R.id.edad);
            edad.setText(item.getcEdad());

            TextView soliAuto = (TextView)viewHolder.getView(R.id.solicitaAuto);
            soliAuto.setText(item.getlSolicitaAut() ? "Si" : "No");

            TextView parentesco = (TextView)viewHolder.getView(R.id.parentesco);
            parentesco.setText(item.getcParentesco());

        }
    }
}
