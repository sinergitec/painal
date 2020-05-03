package com.sienrgitec.painal.carrito;

import android.content.Context;

import com.sienrgitec.painal.pojo.carrito.Carrito;

import java.util.ArrayList;
import java.util.List;

public class CarritoSingleton {

    private static volatile CarritoSingleton sSoleInstance = new CarritoSingleton();
    private List<Carrito> listaCarrito = new ArrayList<>();

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
        // Dispara la visualizacion del carrito
    }

    public void consultaItemCarrito(Context context){
        CarritoDBHelper carritoDBHelper = new CarritoDBHelper(context);
        this.listaCarrito = carritoDBHelper.recuperarPedidos();
    }

}
