package com.sienrgitec.painal.componente.recycler;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.componente.DownloadImageTask;
import com.sienrgitec.painal.componente.RVAdapter;
import com.sienrgitec.painal.pojo.entity.TtCtProveedor_;

import static com.sienrgitec.painal.constante.Constantes.vcUrlImg;

public class ProveedorAdapter extends RVAdapter<TtCtProveedor_> {

    public ProveedorAdapter(Context context, OnViewHolderClick listener) {
        super(context,listener);
    }

    @Override
    protected View createView(Context context, ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recycler_mosaic, viewGroup, false);
        return view;
    }

    @Override
    protected void bindView(TtCtProveedor_ item, RVAdapter.ListViewHolder viewHolder) {
        if (item != null) {

            TextView title = (TextView)viewHolder.getView(R.id.titleMosaic);
            ImageView photo = (ImageView)viewHolder.getView(R.id.imgMosaic);

            title.setText(item.getCNegocio());
            new DownloadImageTask(photo).execute(vcUrlImg + "/proveedores" + item.getcRutaImg() + "/"  +  item.getcFoto());
            //new DownloadImageTask(photo).execute(vcUrlImg + "/" + item.getcRutaImg() + "/" + item.getcFoto());

        }
    }
}
