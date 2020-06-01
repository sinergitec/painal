package com.sienrgitec.painal.componente.recycler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.actividades.RefActualizaActivity;
import com.sienrgitec.painal.actividades.RefEliminaActivity;
import com.sienrgitec.painal.carrito.CarritoSingleton;
import com.sienrgitec.painal.componente.RVAdapter;
import com.sienrgitec.painal.pojo.entity.Tt_OpClienteReferidos_;

public class ReferidosAdapter extends RVAdapter<Tt_OpClienteReferidos_> {

    public ReferidosAdapter(Context context, RVAdapter.OnViewHolderClick<Tt_OpClienteReferidos_> listener) {
        super(context, listener);
    }

    @Override
    protected View createView(Context context, ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recycler_referidos, viewGroup, false);
        return view;
    }

    @Override
    protected void bindView(Tt_OpClienteReferidos_ item, RVAdapter.ListViewHolder viewHolder) {
        if (item != null) {
            ImageView btnEditar  = (ImageView)viewHolder.getView(R.id.imageView8);
            btnEditar.setOnClickListener(v -> {

                Intent actualiza = new Intent(viewHolder.getView().getContext(), RefActualizaActivity.class);
                actualiza.putExtra("objActualizar", item);
                viewHolder.getView().getContext().startActivity(actualiza);
            });

            ImageView btnEliminar = (ImageView)viewHolder.getView(R.id.imageView10);
            btnEliminar.setOnClickListener(v ->{
                RefEliminaActivity dialogoEliminar = new RefEliminaActivity(item.getiCliente());
                dialogoEliminar.show(((AppCompatActivity) viewHolder.getView().getContext()).getSupportFragmentManager(), null);
            });


            TextView nombre = (TextView)viewHolder.getView(R.id.descripcion);
            nombre.setText(item.getcNombre() + ' ' + item.getCapellidos());

            TextView correo = (TextView)viewHolder.getView(R.id.correo);
            correo.setText(item.getcEMail());

            TextView telefono = (TextView)viewHolder.getView(R.id.telefono);
            telefono.setText(item.getcTelefono());

            TextView afiliado = (TextView)viewHolder.getView(R.id.afiliado);
            afiliado.setText(item.getlAfiliado() ? "Si" : "No");
        }
    }
}
