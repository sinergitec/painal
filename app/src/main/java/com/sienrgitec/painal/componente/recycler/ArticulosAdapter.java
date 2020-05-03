package com.sienrgitec.painal.componente.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.carrito.CarritoDBHelper;
import com.sienrgitec.painal.carrito.CarritoSingleton;
import com.sienrgitec.painal.componente.DownloadImageTask;
import com.sienrgitec.painal.componente.RVAdapter;
import com.sienrgitec.painal.pojo.carrito.Carrito;
import com.sienrgitec.painal.pojo.entity.TtCtArtProveedor_;
import com.sienrgitec.painal.util.Funcionalidades;

public class ArticulosAdapter extends RVAdapter<TtCtArtProveedor_> {

    public ArticulosAdapter(Context context, OnViewHolderClick<TtCtArtProveedor_> listener) {
        super(context, listener);
    }

    @Override
    protected View createView(Context context, ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recycler_articulo, viewGroup, false);
        return view;
    }

    @Override
    protected void bindView(TtCtArtProveedor_ item, RVAdapter.ListViewHolder viewHolder) {
        if (item != null) {

            ImageView photo = (ImageView)viewHolder.getView(R.id.imageButton);
            TextView descripcion = (TextView)viewHolder.getView(R.id.descripcion);
            //TextView presentacion = (TextView)viewHolder.getView(R.id.presentacion);
            TextView precio = (TextView)viewHolder.getView(R.id.precio);
            Button agregar = (Button)viewHolder.getView(R.id.agregar);

            descripcion.setText(item.getCDescripcion());
            //presentacion.setText(item.getCPresentacion());
            precio.setText(Funcionalidades.retornaDoubleEnMoneda(item.getDePrecioVta()));
            agregar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Carrito carrito = new Carrito(item, 1.0, item.getDePrecioVta());
                    carrito.setMonto(carrito.getCantidadArticulo() * carrito.getMonto());
                    CarritoSingleton.getInstance().agregaCarrito(v.getContext(), carrito);
                }
            });
            new DownloadImageTask(photo).execute("https://images.unsplash.com/photo-1414235077428-338989a2e8c0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");
        }
    }
}
