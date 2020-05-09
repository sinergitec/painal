package com.sienrgitec.painal.carrito;

import android.content.Context;
import android.widget.Toast;

import com.sienrgitec.painal.pojo.carrito.Carrito;
import com.sienrgitec.painal.pojo.entity.TtCtCliente_;

import java.util.ArrayList;
import java.util.List;

public class CarritoSingleton {

    private static volatile CarritoSingleton sSoleInstance = new CarritoSingleton();
    private List<Carrito> listaCarrito = new ArrayList<>();
    private TtCtCliente_ cliente = new TtCtCliente_();

    private CarritoSingleton(){
        if (sSoleInstance != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public static CarritoSingleton getInstance(){
        if (sSoleInstance == null){
            sSoleInstance = new CarritoSingleton();
        }
        return sSoleInstance;
    }

    public void agregaCarrito(Context context, Carrito item){
        this.listaCarrito.add(item);
        // Persisten en caso de que se salgan de la aplicacion
        CarritoDBHelper carritoDBHelper = new CarritoDBHelper(context);
        carritoDBHelper.insertarPedido(item);
        // Se muestra toast
        Toast.makeText(context, item.getArticulo().getCDescripcion() + " agregado al carrito", Toast.LENGTH_SHORT).show();
    }

    public void consultaItemCarrito(Context context){
        CarritoDBHelper carritoDBHelper = new CarritoDBHelper(context);
        this.listaCarrito = carritoDBHelper.recuperarPedidos();
    }

    public List<Carrito> getListaCarrito() {
        return listaCarrito;
    }

    public void vaciarCarrito(Context context){
        CarritoDBHelper carritoDBHelper = new CarritoDBHelper(context);
        carritoDBHelper.vaciaCarrito();
        // Se muestra toast
        Toast.makeText(context,"Carrito vacio", Toast.LENGTH_LONG).show();
    }

    public TtCtCliente_ getCliente() {
        return cliente;
    }

    public void setCliente(TtCtCliente_ cliente) {
        this.cliente = cliente;
    }
}
