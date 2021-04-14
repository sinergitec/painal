package com.sienrgitec.painal.componente.recycler;

import android.content.Context;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.componente.DownloadImageTask;
import com.sienrgitec.painal.componente.RVAdapter;
import com.sienrgitec.painal.constante.Constantes;
import com.sienrgitec.painal.pojo.entity.TtCtGiro_;

import java.util.Random;

import static com.sienrgitec.painal.constante.Constantes.vcUrlImg;

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
            ImageView photo = (ImageView) viewHolder.getView(R.id.imageView12);


            //cardView.setCardBackgroundColor(Color.parseColor(Constantes.ARRAY_COLORS[ new Random().nextInt(Constantes.ARRAY_COLORS.length) ]));
            title.setText(item.getCGiro());
            if(item.getcFoto()!="") {


                new DownloadImageTask(photo).execute(vcUrlImg + "/giro/" + item.getcFoto());
                Log.e("giros:"," --> " + vcUrlImg + "/giro/" + item.getcFoto());
            }
        }
    }

}
