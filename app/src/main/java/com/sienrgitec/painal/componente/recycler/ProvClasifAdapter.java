package com.sienrgitec.painal.componente.recycler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.actividades.ArticuloActivity;
import com.sienrgitec.painal.actividades.SubGirosActivity;
import com.sienrgitec.painal.componente.RVAdapter;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProvClasifAdapter extends RVAdapter<TtCtCategoriaProv_> {

    private List<TtCtSubCategoriaProv> listaSub = new ArrayList<>();

    public ProvClasifAdapter(Context context, List<TtCtSubCategoriaProv> listSub, OnViewHolderClick listener) {
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
            ProvSubClasifAdapter provSubClasifAdapter = new ProvSubClasifAdapter(viewHolder.getView().getContext(), new RVAdapter.OnViewHolderClick(){
                @Override
                public void onClick(View view, int position, Object item2) {
                    final Painal service = ServiceGenerator.createService(Painal.class);
                    final TtCtSubCategoriaProv subCatProv = (TtCtSubCategoriaProv) item2;
                    Map<String, String> data = new HashMap<>();
                    data.put("ipiProveedor", String.valueOf(subCatProv.getIProveedor()));
                    data.put("ipiCategoria", String.valueOf(subCatProv.getICategoria()));
                    data.put("ipisubCategoria", String.valueOf(subCatProv.getISubCategoria()));
                    data.put("ipiClasificacion", "1");
                    data.put("ipiSubClasificacion", "1");
                    final Call<Respuesta> call = service.consultaArticulos(data);

                    call.enqueue(new Callback<Respuesta>() {
                        @Override
                        public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                            if(response.isSuccessful()){
                                Respuesta res = response.body();

                                if(res.getResponse().getTtCtArtProveedor() != null &&
                                        res.getResponse().getTtCtArtProveedor().getTtCtArtProveedor() != null &&
                                        res.getResponse().getTtCtArtProveedor().getTtCtArtProveedor().size() > 0){
                                    Intent vistaNueva = new Intent(viewHolder.getView().getContext(), ArticuloActivity.class);
                                    vistaNueva.putExtra("list", (Serializable) res.getResponse().getTtCtArtProveedor().getTtCtArtProveedor());
                                    viewHolder.getView().getContext().startActivity(vistaNueva);
                                } else {
                                    Toast.makeText(viewHolder.getView().getContext(), "Sin articulos disponibles", Toast.LENGTH_LONG).show();
                                }
                            } else {
                                try {
                                    Errors error = ErrorUtils.parseError(response);
                                    Toast.makeText(viewHolder.getView().getContext(), error.toString(), Toast.LENGTH_LONG).show();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    Toast.makeText(viewHolder.getView().getContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<Respuesta> call, Throwable t) {
                            Toast.makeText(viewHolder.getView().getContext(), "Error Failure: " + t.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });

                }
            });
            provSubClasifAdapter.setList(listaSubAux);
            rv.setAdapter(provSubClasifAdapter);
        }
    }
}
