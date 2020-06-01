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
import com.sienrgitec.painal.actividades.FamEliminaActivity;
import com.sienrgitec.painal.actividades.FamilyActualiza;
import com.sienrgitec.painal.actividades.RefActualizaActivity;
import com.sienrgitec.painal.actividades.RefEliminaActivity;
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

            ImageView btnEditar  = (ImageView)viewHolder.getView(R.id.imageView8);
            btnEditar.setOnClickListener(v -> {

                Intent actualiza = new Intent(viewHolder.getView().getContext(), FamilyActualiza.class);
                actualiza.putExtra("objActualizar", item);
                viewHolder.getView().getContext().startActivity(actualiza);
            });


            ImageView btnEliminar = (ImageView)viewHolder.getView(R.id.imageView10);
            btnEliminar.setOnClickListener(v ->{
                FamEliminaActivity dialogoEliminar = new FamEliminaActivity(item.getiCliente());
                dialogoEliminar.show(((AppCompatActivity) viewHolder.getView().getContext()).getSupportFragmentManager(), null);
            });

            TextView nombre = (TextView)viewHolder.getView(R.id.descripcion);
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
