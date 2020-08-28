package com.sienrgitec.painal.componente.recycler;

import android.content.Context;
import android.text.Html;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.sienrgitec.painal.R;
import com.sienrgitec.painal.carrito.CarritoSingleton;
import com.sienrgitec.painal.componente.DownloadImageTask;
import com.sienrgitec.painal.componente.RVAdapter;
import com.sienrgitec.painal.pojo.carrito.Carrito;
import com.sienrgitec.painal.util.Funcionalidades;

public class CarritoAdapter extends RVAdapter<Carrito> {
    TextView articulos;
    TextView total;
    double cantArt;
    double totalArt;

    public CarritoAdapter(Context context, OnViewHolderClick<Carrito> listener, TextView articulos, TextView total,
                                                double cantArt, double totalArt) {
        super(context, listener);
        this.articulos = articulos;
        this.total = total;
        this.cantArt = cantArt;
        this.totalArt = totalArt;
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

            menos.setOnClickListener(v -> cant.setText(toString().valueOf(menosCantidad(item, precio,viewHolder.getAdapterPosition()))));
            mas.setOnClickListener(v -> cant.setText(toString().valueOf(masCantidad(item,precio,viewHolder.getAdapterPosition()))));
            System.out.println();

        }
    }

    public String  actualizaPrecio (double precio , double cantidad, int posicion, Carrito cant){
        double monto = precio * cantidad;
        CarritoSingleton.getInstance().getListaCarrito().get(posicion).setMonto(monto);
        CarritoSingleton.getInstance().getListaCarrito().get(posicion).setCantidadArticulo(cantidad);
        cant.setMonto(monto);
       return Funcionalidades.retornaDoubleEnMoneda(monto);
    }

    private double menosCantidad(Carrito cant, TextView precio, int posicion) {
        double cantMen = cant.getCantidadArticulo();
        double cantMenos = cantMen - (cant.getTipoUnidad().equals("g") ? cant.getArticulo().getDeGramosPieza() : 1.0);

        if(cantMenos <= 0){
            cantMenos = 1.0;

            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle(Html.fromHtml("<font color='#FF0000'>Aviso</font>"));
            builder.setMessage("No puedes tener cantidad menor a: "
                              + (cant.getTipoUnidad().equals("g") ? cant.getArticulo().getDeGramosPieza() : 1.0)
                              + ". Si deseas eliminar desliza el producto a la izquierda.");
            builder.setPositiveButton("Aceptar", null);

            AlertDialog dialog = builder.create();
            dialog.show();

        }else{
            precio.setText(actualizaPrecio((cant.getTipoUnidad().equals("g") ? cant.getArticulo().getDePrecioVtaGranel() : cant.getArticulo().getDePrecioVtaPza()) ,cantMenos, posicion, cant));
            actualizaCantidadTotal_MontoTotal((cant.getTipoUnidad().equals("g") ? cant.getArticulo().getDePrecioVtaGranel() : cant.getArticulo().getDePrecioVtaPza()), false);
        }
        cant.setCantidadArticulo(cantMenos);
        return cantMenos;
    }

    private double masCantidad(Carrito cant, TextView precio, int posicion) {
        double cantMas = cant.getCantidadArticulo();
        double cantMasSuma = cantMas + (cant.getTipoUnidad().equals("g") ? cant.getArticulo().getDeGramosPieza() : 1.0);

        if (cantMasSuma > 20) {
            cantMasSuma = 20;

            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            builder.setTitle(Html.fromHtml("<font color='#FF0000'>Aviso</font>"));
            builder.setMessage("No puedes tener cantidad mayor a 20.0 unidades.");
            builder.setPositiveButton("Aceptar", null);

            AlertDialog dialog = builder.create();
            dialog.show();
        }else{
            precio.setText(actualizaPrecio((cant.getTipoUnidad().equals("g") ? cant.getArticulo().getDePrecioVtaGranel() : cant.getArticulo().getDePrecioVtaPza()) ,cantMasSuma, posicion, cant));
            actualizaCantidadTotal_MontoTotal((cant.getTipoUnidad().equals("g") ? cant.getArticulo().getDePrecioVtaGranel() : cant.getArticulo().getDePrecioVtaPza()), true);
        }
        cant.setCantidadArticulo(cantMasSuma);
        return cantMasSuma;
    }

    public void actualizaCantidadTotal_MontoTotal(double precioSumar, boolean tipoOperacion){

        if(tipoOperacion){
            this.totalArt = totalArt + precioSumar;
        }else{
            this.totalArt = totalArt - precioSumar;
        }

        this.total.setText(Funcionalidades.retornaDoubleEnMoneda(this.totalArt));
    }
}
