package com.sienrgitec.painal.componente.recycler;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.componente.RVAdapter;
import com.sienrgitec.painal.constante.Constantes;
import com.sienrgitec.painal.pojo.entity.TtCtSubGiro_;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.servicio.Painal;
import com.sienrgitec.painal.servicio.ServiceGenerator;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.Random;

public class SubGirosAdapter extends RVAdapter<TtCtSubGiro_> {
    public SubGirosAdapter(Context context, OnViewHolderClick listener) {
        super(context,listener);
    }

    @Override
    protected View createView(Context context, ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recycler_with_recycler_horizontal, viewGroup, false);
        return view;
    }

    @Override
    protected void bindView(TtCtSubGiro_ item, RVAdapter.ListViewHolder viewHolder) {
        if (item != null) {

            CardView cardView = (CardView) viewHolder.getView(R.id.cv);
            TextView title = (TextView)viewHolder.getView(R.id.titile);
            TextView subTitle = (TextView)viewHolder.getView(R.id.subTitle);
            final RecyclerView rv = (RecyclerView) viewHolder.getView(R.id.rvH);
            //ImageView photo = (ImageView)viewHolder.getView(R.id.imgMosaic);

            //cardView.setCardBackgroundColor(Color.RED);
            //cardView.setCardBackgroundColor(Color.parseColor(Constantes.ARRAY_COLORS[ new Random().nextInt(Constantes.ARRAY_COLORS.length) ]));
            //rv.setBackgroundColor(Color.parseColor(Constantes.ARRAY_COLORS[ new Random().nextInt(Constantes.ARRAY_COLORS.length) ]));
            title.setText(item.getCSubGiro());
            subTitle.setText("Algo para llevar");
            //new DownloadImageTask(photo).execute("https://images.unsplash.com/photo-1414235077428-338989a2e8c0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");

            final Painal service = ServiceGenerator.createService(Painal.class);
            Map<String, String> data = new HashMap<>();
            data.put("ipiProveedor","0");
            data.put("ipiGiro",String.valueOf(item.getIGiro()));
            data.put("ipiSubGiro",String.valueOf(item.getISubGiro()));
            data.put("iplActivo","true");
            final Call<Respuesta> call = service.consultaProveedor(data);

            call.enqueue(new Callback<Respuesta>() {
                @Override
                public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                    if(response.isSuccessful()){
                        Respuesta res = response.body();
                        LinearLayoutManager llm = new LinearLayoutManager(viewHolder.getView().getContext(), LinearLayoutManager.HORIZONTAL, false);
                        rv.setLayoutManager(llm);
                        ProveedorAdapter proveedorAdapter = new ProveedorAdapter(viewHolder.getView().getContext(),null);
                        proveedorAdapter.setList(res.getResponse().getTtCtProveedor().getTtCtProveedor());
                        rv.setAdapter(proveedorAdapter);
                    } else {
                        System.out.println("Algo paso al cargar la info");
                    }
                }

                @Override
                public void onFailure(Call<Respuesta> call, Throwable t) {
                    System.out.println("Error: " + t.getMessage());
                }
            });

        }
    }
}
