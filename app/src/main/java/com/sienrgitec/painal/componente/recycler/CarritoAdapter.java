package com.sienrgitec.painal.componente.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.componente.DownloadImageTask;
import com.sienrgitec.painal.componente.RVAdapter;
import com.sienrgitec.painal.pojo.carrito.Carrito;
import com.sienrgitec.painal.util.Funcionalidades;

public class CarritoAdapter extends RVAdapter<Carrito> {

    private Object Double;

    public CarritoAdapter(Context context, OnViewHolderClick<Carrito> listener) {
        super(context, listener);
    }

    @Override
    protected View createView(Context context, ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recycler_articulo_carrito, viewGroup, false);
        return view;
    }

    @Override
    protected void bindView(Carrito item, RVAdapter.ListViewHolder viewHolder) {
        if (item != null) {
            ImageView photo = (ImageView)viewHolder.getView(R.id.artImg);
            TextView descripcion = (TextView)viewHolder.getView(R.id.descripcion);
            TextView precio = (TextView)viewHolder.getView(R.id.precio);
            TextView cant = (TextView)viewHolder.getView(R.id.cantPed);

            ImageView menos = (ImageView)viewHolder.getView(R.id.imageView6);
            ImageView mas = (ImageView)viewHolder.getView(R.id.imageView9);

            descripcion.setText(item.getArticulo().getCDescripcion());
            precio.setText(Funcionalidades.retornaDoubleEnMoneda(item.getMonto()));
            new DownloadImageTask(photo).execute("https://images.unsplash.com/photo-1414235077428-338989a2e8c0?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80");
            cant.setText(item.getCantidadArticulo().toString());

            menos.setOnClickListener(v ->  menosCantidad(item));
            mas.setOnClickListener(v -> masCantidad(item));
        }
    }

    private void menosCantidad(Carrito cant) {

        double cantMen = cant.getCantidadArticulo();

        System.out.println("Cantidad menos" + cantMen);

        double cantMenos = cantMen - 1.0;

        System.out.println("Cantidad menos" + cantMenos);

        cant.setCantidadArticulo(cantMenos);
    }

    private void masCantidad(Carrito cant) {

        double cantMas = cant.getCantidadArticulo();

        System.out.println("cantidadMas" + cantMas);

        double cantMasSuma = cantMas + 1.0;

        System.out.println("cantidadMas" + cantMasSuma);

        cant.setCantidadArticulo(cantMasSuma);

    }
}
