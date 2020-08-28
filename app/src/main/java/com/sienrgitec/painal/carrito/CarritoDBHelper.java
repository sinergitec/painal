package com.sienrgitec.painal.carrito;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sienrgitec.painal.pojo.carrito.Carrito;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CarritoDBHelper {

    private Context context;
    public static final String CARRITO = "CARRITO" ;
    public static final String LISTA_CARRITO = "Lista" ;

    public CarritoDBHelper(Context context) {
        this.context = context;
    }

    public void insertarPedido(final List<Carrito> listaCarrito){
        final SharedPreferences sharedPreferences =
                context.getSharedPreferences(CARRITO,context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(LISTA_CARRITO,new Gson().toJson(listaCarrito));
        editor.commit();
    }

    public void vaciaCarrito(){
        final SharedPreferences sharedPreferences =
                context.getSharedPreferences(CARRITO,context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }

    public void eliminarArticuloCarrito(final List<Carrito> listaCarrito){
        insertarPedido(listaCarrito);
    }

    public List<Carrito> recuperarPedidos() {
        final SharedPreferences sharedPreferences =
                context.getSharedPreferences(CARRITO,context.MODE_PRIVATE);
        final String json = sharedPreferences.getString(LISTA_CARRITO, "");
        final Type type = new TypeToken<List<Carrito>>() {}.getType();
        return json == null || json.isEmpty() ? new ArrayList<>() : new Gson().fromJson(json,type);
    }

}
