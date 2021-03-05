package com.sienrgitec.painal.componente.recycler;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.actividades.ArticuloDetalleActivity;
import com.sienrgitec.painal.carrito.CarritoSingleton;
import com.sienrgitec.painal.componente.DownloadImageTask;
import com.sienrgitec.painal.componente.RVAdapter;
import com.sienrgitec.painal.constante.Constantes;
import com.sienrgitec.painal.pojo.carrito.Carrito;
import com.sienrgitec.painal.pojo.entity.TtCtArtProveedor_;
import com.sienrgitec.painal.util.Funcionalidades;
import com.squareup.picasso.Picasso;

import java.io.Serializable;

import static com.sienrgitec.painal.constante.Constantes.vcUrlImg;

public class ArticulosAdapter extends RVAdapter<TtCtArtProveedor_> {
    Constantes constantes;

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
            TextView precio = (TextView)viewHolder.getView(R.id.precio);
            Button agregar = (Button)viewHolder.getView(R.id.agregar);

            descripcion.setText(item.getCDescripcion());
            precio.setText(Funcionalidades.retornaDoubleEnMoneda(item.getDePrecioVtaPza()));
            agregar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Carrito carrito = new Carrito(item, 1.0, item.getDePrecioVtaPza(), "pz", "");
                    carrito.setMonto(carrito.getCantidadArticulo() * carrito.getMonto());
                    CarritoSingleton.getInstance().agregaCarrito(v.getContext(), carrito);
                }
            });

            if(item.getcFoto() != ""){
                new DownloadImageTask(photo).execute(vcUrlImg   + item.getcRutaImg()  + "/" +  item.getcFoto());

            }else{
                //new DownloadImageTask(photo).execute("http://192.168.1.13:80/multimedia/painal/sinvistaprevia.png");
            }


            photo.setOnClickListener(v -> {
                Intent intent = new Intent(v.getContext(), ArticuloDetalleActivity.class);
                intent.putExtra("articulo", (Serializable) item);
                v.getContext().startActivity(intent);
            });
        }
    }
}
