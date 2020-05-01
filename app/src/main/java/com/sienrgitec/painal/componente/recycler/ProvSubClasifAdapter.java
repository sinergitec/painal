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
import com.sienrgitec.painal.pojo.entity.TtCtSubCategoriaProv;

public class ProvSubClasifAdapter extends RVAdapter<TtCtSubCategoriaProv> {

    public ProvSubClasifAdapter(Context context, OnViewHolderClick listener) {
        super(context, listener);
    }

    @Override
    protected View createView(Context context, ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recycler_mosaic, viewGroup, false);
        return view;
    }

    @Override
    protected void bindView(TtCtSubCategoriaProv item, RVAdapter.ListViewHolder viewHolder) {
        if (item != null) {

            TextView title = (TextView)viewHolder.getView(R.id.titleMosaic);
            ImageView photo = (ImageView)viewHolder.getView(R.id.imgMosaic);

            title.setText(item.getCSubCategoria());
            new DownloadImageTask(photo).execute("https://images.unsplash.com/photo-1414235077428-338989a2e8c0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");
        }
    }
}
