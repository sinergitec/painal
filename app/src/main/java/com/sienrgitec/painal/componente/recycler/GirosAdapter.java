package com.sienrgitec.painal.componente.recycler;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.componente.DownloadImageTask;
import com.sienrgitec.painal.componente.RVAdapter;
import com.sienrgitec.painal.constante.Constantes;
import com.sienrgitec.painal.pojo.entity.TtCtGiro_;

import java.util.Random;

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

            CardView cardView = (CardView) viewHolder.getView(R.id.cv);
            TextView  title = (TextView)viewHolder.getView(R.id.title);
            TextView  subTitle = (TextView)viewHolder.getView(R.id.subTitle);
            ImageView photo = (ImageView)viewHolder.getView(R.id.photo);


            cardView.setCardBackgroundColor(Color.parseColor(Constantes.ARRAY_COLORS[ new Random().nextInt(Constantes.ARRAY_COLORS.length) ]));
            title.setText(item.getCGiro());
            subTitle.setText("");
            //new DownloadImageTask(photo).execute("https://images.unsplash.com/photo-1414235077428-338989a2e8c0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");
            if(item.getCGiro().equals("RESTAURANTES")){
                photo.setImageResource(R.drawable.ic_mesarestaurante);
            } else if (item.getCGiro().equals("MERCADOS")){
                photo.setImageResource(R.drawable.ic_market);
            }
        }
    }

}
