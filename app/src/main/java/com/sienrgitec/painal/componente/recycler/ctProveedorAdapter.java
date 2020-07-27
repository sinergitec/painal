package com.sienrgitec.painal.componente.recycler;


import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.actividades.ProveedoresActivity;
import com.sienrgitec.painal.componente.RVAdapter;
import com.sienrgitec.painal.pojo.entity.TtCtProveedor_;
import com.sienrgitec.painal.pojo.entity.TtCtSubGiro_;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.sienrgitec.painal.constante.Constantes.ctProvList;

public class ctProveedorAdapter extends PagerAdapter {



    private List<TtCtProveedor_> listaPrvo;
    private LayoutInflater layoutInflater;
    private Context context;
    private String vcEvalua = "";


    public ctProveedorAdapter(List<TtCtProveedor_> listaPrvo, Context context) {
        this.listaPrvo = listaPrvo;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listaPrvo.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.itemprovs, container, false);


        TextView tvProv, tvEvalua, tvGiro;
        ImageView img;

        img = view.findViewById(R.id.imageView);
        tvProv = view.findViewById(R.id.tvProv);
        tvEvalua = view.findViewById(R.id.tvEvalua);
        tvGiro = view.findViewById(R.id.tvTipoProv);





        tvProv.setText(listaPrvo.get(position).getCNegocio());
        tvEvalua.setText(listaPrvo.get(position).getcEvaluacion());
        tvGiro.setText(listaPrvo.get(position).getcTipoProv());






        container.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }

}


/***/


/*









 */