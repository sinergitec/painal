package com.sienrgitec.painal.componente.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.componente.RVAdapter;
import com.sienrgitec.painal.pojo.entity.TtCtCategoriaProv_;
import com.sienrgitec.painal.pojo.entity.TtCtSubCategoriaProv;

import java.util.ArrayList;
import java.util.List;

public class ProvClasifAdapter extends RVAdapter<TtCtCategoriaProv_> {

    private List<TtCtSubCategoriaProv> listaSub = new ArrayList<>();

    public ProvClasifAdapter(Context context, OnViewHolderClick listener, List<TtCtSubCategoriaProv> listSub) {
        super(context, listener);
        this.listaSub = listSub;
    }

    @Override
    protected View createView(Context context, ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recycler_with_recycler_horizontal, viewGroup, false);
        return view;
    }

    @Override
    protected void bindView(TtCtCategoriaProv_ item, RVAdapter.ListViewHolder viewHolder) {
        if (item != null) {
            CardView cardView = (CardView) viewHolder.getView(R.id.cv);
            TextView title = (TextView) viewHolder.getView(R.id.titile);
            TextView subTitle = (TextView) viewHolder.getView(R.id.subTitle);

            final RecyclerView rv = (RecyclerView) viewHolder.getView(R.id.rvH);
            subTitle.setText("");
            title.setText(item.getcCategoria());
            List<TtCtSubCategoriaProv> listaSubAux = new ArrayList<>();
            for (TtCtSubCategoriaProv itemSubCat : this.listaSub) {
                if(item.getiCategoria().compareTo(itemSubCat.getICategoria()) == 0){
                    listaSubAux.add(itemSubCat);
                }
            }
            LinearLayoutManager llm = new LinearLayoutManager(viewHolder.getView().getContext(), LinearLayoutManager.HORIZONTAL, false);
            rv.setLayoutManager(llm);
            ProvSubClasifAdapter provSubClasifAdapter = new ProvSubClasifAdapter(viewHolder.getView().getContext(), null);
            provSubClasifAdapter.setList(listaSubAux);
            rv.setAdapter(provSubClasifAdapter);
        }
    }
}
