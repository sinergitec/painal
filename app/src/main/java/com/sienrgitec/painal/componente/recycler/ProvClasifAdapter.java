package com.sienrgitec.painal.componente.recycler;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.actividades.ArticuloActivity;
import com.sienrgitec.painal.actividades.SubGirosActivity;
import com.sienrgitec.painal.componente.DownloadImageTask;
import com.sienrgitec.painal.componente.RVAdapter;
import com.sienrgitec.painal.constante.Constantes;
import com.sienrgitec.painal.pojo.entity.TtCtCategoriaProv_;
import com.sienrgitec.painal.pojo.entity.TtCtSubCategoriaProv;
import com.sienrgitec.painal.pojo.error.ErrorUtils;
import com.sienrgitec.painal.pojo.error.Errors;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.sienrgitec.painal.constante.Constantes.vcUrlImg;

public class ProvClasifAdapter extends RVAdapter<TtCtCategoriaProv_> implements View.OnClickListener {

    private List<TtCtSubCategoriaProv> listaSub = new ArrayList<>();
    private View.OnClickListener listener;

    public ProvClasifAdapter(Context context, List<TtCtSubCategoriaProv> listSub, OnViewHolderClick listener) {
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
    protected void bindView(TtCtCategoriaProv_ item, RVAdapter.ListViewHolder viewHolder) {
        if (item != null) {
            CardView cardView = (CardView) viewHolder.getView(R.id.cv);
            TextView  title = (TextView)viewHolder.getView(R.id.title);
            ImageView photo = (ImageView) viewHolder.getView(R.id.imageView12);


            title.setText(item.getcCategoria());

            if(item.getcFoto()!=""){

                new DownloadImageTask(photo).execute(vcUrlImg + item.getcRutaImg()     + "/"   + item.getcFoto());

            }else{
                new DownloadImageTask(photo).execute(vcUrlImg + "/" + item.getcRutaImg() + "/" + "sinvistaprevia.png");
            }


            title.setText(item.getcCategoria());
            List<TtCtSubCategoriaProv> listaSubAux = new ArrayList<>();
            for (TtCtSubCategoriaProv itemSubCat : this.listaSub) {
                if(item.getiCategoria().compareTo(itemSubCat.getICategoria()) == 0){
                    listaSubAux.add(itemSubCat);
                }
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
