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
import com.sienrgitec.painal.pojo.entity.TtCtSubCategoria;
import com.sienrgitec.painal.pojo.entity.TtCtSubCategoriaProv;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.sienrgitec.painal.constante.Constantes.vcUrlImg;

public class ctSubCatAdapter  extends RVAdapter<TtCtSubCategoriaProv>  implements View.OnClickListener{

private List<TtCtSubCategoriaProv> listaSub = new ArrayList<>();
private View.OnClickListener listener;

public ctSubCatAdapter(Context context, List<TtCtSubCategoriaProv> listSub, RVAdapter.OnViewHolderClick listener) {
        super(context, listener);
        this.listaSub = listSub;
        }

@Override
protected View createView(Context context, ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //View view = inflater.inflate(R.layout.ctcategorialist, viewGroup, false);
        View view = inflater.inflate(R.layout.ctcategorialist, viewGroup, false);
        view.setOnClickListener(this);
        return view;
        }

@Override
protected void bindView(TtCtSubCategoriaProv item, RVAdapter.ListViewHolder viewHolder) {
        if (item != null) {
        CardView cardView = (CardView) viewHolder.getView(R.id.cv);
        TextView title = (TextView)viewHolder.getView(R.id.title);
        ImageView photo = (ImageView) viewHolder.getView(R.id.imageView12);

        title.setText(item.getCSubCategoria());
        if(item.getcFoto()!=""){
              new DownloadImageTask(photo).execute(vcUrlImg +  item.getcRutaImg() + "/" + item.getcFoto());
        }else{
                new DownloadImageTask(photo).execute(vcUrlImg + "/"  + "sinvistaprevia.png");
        }


        }
        }

public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;

        }

@Override
public void onClick(View v) {
        listener.onClick(v);

        }
}
