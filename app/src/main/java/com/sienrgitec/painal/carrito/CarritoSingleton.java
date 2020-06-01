package com.sienrgitec.painal.carrito;

import android.content.Context;
import android.widget.Toast;

import com.sienrgitec.painal.constante.Constantes;
import com.sienrgitec.painal.pojo.carrito.Carrito;
import com.sienrgitec.painal.pojo.entity.TtCtCliente_;
import com.sienrgitec.painal.pojo.entity.TtCtTelefono_;
import com.sienrgitec.painal.pojo.entity.TtCtUsuario_;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CarritoSingleton {

    private static volatile CarritoSingleton sSoleInstance = new CarritoSingleton();
    private List<Carrito> listaCarrito = new ArrayList<>();
    private TtCtCliente_ cliente = new TtCtCliente_();
    private TtCtUsuario_ usuario_ = new TtCtUsuario_();
    private TtCtTelefono_ telefono = new TtCtTelefono_();
    private Stack<Integer> pilaProveedores = new Stack<>();

    private CarritoSingleton(){
        if (sSoleInstance != null){
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    public synchronized static CarritoSingleton getInstance(){
        if (sSoleInstance == null){
            sSoleInstance = new CarritoSingleton();
        }
        return sSoleInstance;
    }

    public synchronized void agregaCarrito(Context context, Carrito item){

        //Agrega a la pila de proveedores
        if(!pilaProveedores.contains(item.getArticulo().getIProveedor())){
            pilaProveedores.push(item.getArticulo().getIProveedor());
        }

        //Determina si el numero de proveedores es mayor al maximo permitido
        if(pilaProveedores.size() > Constantes.CANTIDAD_MAX_PROVEEDORES){
            Toast.makeText(context, "Alcanzo el maximo de proveedores", Toast.LENGTH_LONG).show();
            return;
        }

        this.listaCarrito.add(item);
        // Persisten en caso de que se salgan de la aplicacion
        CarritoDBHelper carritoDBHelper = new CarritoDBHelper(context);
        carritoDBHelper.insertarPedido(item);

        Toast.makeText(context, item.getArticulo().getCDescripcion() + " agregado al carrito", Toast.LENGTH_SHORT).show();
    }

    public synchronized void consultaItemCarrito(Context context){
        CarritoDBHelper carritoDBHelper = new CarritoDBHelper(context);
        this.listaCarrito = carritoDBHelper.recuperarPedidos();
        for (Carrito item: listaCarrito) {
            if(!pilaProveedores.contains(item.getArticulo().getIProveedor())){
                pilaProveedores.push(item.getArticulo().getIProveedor());
            }
        }
    }

    public synchronized void vaciarCarrito(Context context){
        listaCarrito.clear();
        boolean changed = pilaProveedores.removeAll(pilaProveedores);
        if (changed)
            System.out.println("Limpieza ");
        else
            System.out.println("Limpieza no hecha");
        // Vacia la base de datos
        CarritoDBHelper carritoDBHelper = new CarritoDBHelper(context);
        carritoDBHelper.vaciaCarrito();
        Toast.makeText(context,"Carrito vacio", Toast.LENGTH_LONG).show();
    }

    public List<Carrito> getListaCarrito() {
        return listaCarrito;
    }

    public TtCtCliente_ getCliente() {
        return cliente;
    }

    public void setCliente(TtCtCliente_ cliente) {
        this.cliente = cliente;
    }

    public TtCtUsuario_ getUsuario_() {
        return usuario_;
    }

    public void setUsuario_(TtCtUsuario_ usuario_) {
        this.usuario_ = usuario_;
    }

    public TtCtTelefono_ getTelefono() {
        return telefono;
    }

    public void setTelefono(TtCtTelefono_ telefono) {
        this.telefono = telefono;
    }

    public synchronized Integer getNumeroProveedores() {
        return pilaProveedores.size();
    }

    public Stack<Integer> getPilaProveedores() {
        return pilaProveedores;
    }
}
