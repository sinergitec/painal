package com.sienrgitec.painal.componente.recycler;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.componente.DownloadImageTask;
import com.sienrgitec.painal.componente.RVAdapter;
import com.sienrgitec.painal.pojo.entity.TtCtFormasPago_;
import com.sienrgitec.painal.pojo.entity.TtCtGiro_;
import com.sienrgitec.painal.pojo.entity.TtCtSubCategoriaProv;

import java.util.ArrayList;
import java.util.List;

import static com.sienrgitec.painal.constante.Constantes.vcUrlImg;

public class ctFPagosAdapter extends RVAdapter<TtCtFormasPago_> implements View.OnClickListener{

    private List<TtCtFormasPago_> listaFPagos = new ArrayList<>();
    private View.OnClickListener listener;

    public ctFPagosAdapter(Context context, List<TtCtFormasPago_> listSub, RVAdapter.OnViewHolderClick listener){
        super(context, listener);
        this.listaFPagos = listSub;
    }

    @Override
    protected View createView(Context context, ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recycler, viewGroup, false);
        view.setOnClickListener(this);
        return view;
    }

    @Override
    protected void bindView(TtCtFormasPago_ item, RVAdapter.ListViewHolder viewHolder) {
        if (item != null) {

            CardView cardView = (CardView) viewHolder.getView(R.id.cv);
            TextView title = (TextView)viewHolder.getView(R.id.title);
            ImageView photo = (ImageView) viewHolder.getView(R.id.imageView12);


            title.setText(item.getcFormaPago());
            if(item.getCvePago().equals("TC")) {

                Log.e("aa", "si existo");
                //new DownloadImageTask(photo).execute(vcUrlImg + "/giro/" + item.getcFoto());
                new DownloadImageTask(photo).execute("http://192.168.1.13:80/multimedia/imagenes/pagos/tc.jpg");

            }else{
                new DownloadImageTask(photo).execute("http://192.168.1.13:80/img/pp.jpg" );
            }

          //  new DownloadImageTask(photo).execute("http://192.168.1.13:80/multimedia/imagenes/pagos/tc.jpg");
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
