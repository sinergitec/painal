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

       // cardView.setCardBackgroundColor(Color.parseColor(Constantes.ARRAY_COLORS[ new Random().nextInt(Constantes.ARRAY_COLORS.length) ]));
        title.setText(item.getCSubCategoria());
        if(item.getcFoto()!=""){
              new DownloadImageTask(photo).execute("http://192.168.1.13:80/multimedia/painal/cangrejito/" + item.getcFoto());
        }

            /*CardView cardView = (CardView) viewHolder.getView(R.id.cv);
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
                    data.put("ipiSubCategoria", String.valueOf(subCatProv.getISubCategoria()));
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
            rv.setAdapter(provSubClasifAdapter);*/
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
