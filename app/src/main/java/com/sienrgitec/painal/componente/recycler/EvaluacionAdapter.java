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
import com.sienrgitec.painal.actividades.FamilyActualiza;
import com.sienrgitec.painal.componente.RVAdapter;
import com.sienrgitec.painal.pojo.entity.TtCtClienteAutorizados_;
import com.sienrgitec.painal.pojo.entity.Tt_CtEvaluacion_;

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

        }
    }
}
