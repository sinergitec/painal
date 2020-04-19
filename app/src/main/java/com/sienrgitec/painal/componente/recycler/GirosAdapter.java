package com.sienrgitec.painal.componente.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.componente.RVAdapter;
import com.sienrgitec.painal.pojo.entity.TtCtGiro_;

public class GirosAdapter extends RVAdapter<TtCtGiro_> {

    public GirosAdapter(Context context, OnViewHolderClick listener){
        super(context, listener);
    }


    @Override
    protected View createView(Context context, ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recycler, viewGroup, false);
        return view;
    }

    @Override
    protected void bindView(TtCtGiro_ item, RVAdapter.ListViewHolder viewHolder) {
        if (item != null) {

            TextView  title = (TextView)viewHolder.getView(R.id.title);
            TextView  subTitle = (TextView)viewHolder.getView(R.id.subTitle);
            ImageView photo = (ImageView)viewHolder.getView(R.id.photo);

            title.setText(item.getCGiro());
            subTitle.setText("");
            photo.setImageResource(R.drawable.ic_cafe);
        }
    }

}
