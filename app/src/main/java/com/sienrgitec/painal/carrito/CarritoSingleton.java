package com.sienrgitec.painal.carrito;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.Html;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import com.sienrgitec.painal.actividades.NvoPagoActivity;
import com.sienrgitec.painal.actividades.RegistroActivity;
import com.sienrgitec.painal.actividades.SaldosActivity;
import com.sienrgitec.painal.constante.Constantes;
import com.sienrgitec.painal.fragmentos.CarritoFragment;
import com.sienrgitec.painal.pojo.carrito.Carrito;
import com.sienrgitec.painal.pojo.entity.TtCtCliente_;
import com.sienrgitec.painal.pojo.entity.TtCtDomicilio_;
import com.sienrgitec.painal.pojo.entity.TtCtTelefono_;
import com.sienrgitec.painal.pojo.entity.TtCtUsuario_;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static com.sienrgitec.painal.constante.Constantes.vdeSaldo;

public class CarritoSingleton {

    private static volatile CarritoSingleton sSoleInstance = new CarritoSingleton();
    private List<Carrito> listaCarrito = new ArrayList<>();
    private TtCtCliente_ cliente = new TtCtCliente_();
    private TtCtUsuario_ usuario_ = new TtCtUsuario_();
    private TtCtTelefono_ telefono = new TtCtTelefono_();
    private TtCtDomicilio_ domicilioActual = new TtCtDomicilio_();
    private List<TtCtDomicilio_> domicilio = new ArrayList<TtCtDomicilio_>();
    private Stack<Integer> pilaProveedores = new Stack<>();
    private Stack<String> pilaDomicilios = new Stack<>();

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

        //Agrega a la pila de domicilios
        if(!pilaDomicilios.contains(String.valueOf(item.getArticulo().getIProveedor())+ "," + String.valueOf(item.getArticulo().getIDomicilio()))){
            pilaDomicilios.push(String.valueOf(item.getArticulo().getIProveedor())+ "," + String.valueOf(item.getArticulo().getIDomicilio()));
        }

        //Determina si el numero de proveedores es mayor al maximo permitido
        if(pilaProveedores.size() > Constantes.CANTIDAD_MAX_PROVEEDORES
                || pilaDomicilios.size() > Constantes.CANTIDAD_MAX_PROVEEDORES){
            Toast.makeText(context, "Alcanzo el máximo de proveedores", Toast.LENGTH_LONG).show();
            return;
        }

        this.listaCarrito.add(item);
        // Persisten en caso de que se salgan de la aplicacion
        CarritoDBHelper carritoDBHelper = new CarritoDBHelper(context);
        carritoDBHelper.insertarPedido(item);


        /**AndrosOHG 30/07/2020**/
        Double totalD = 0.0;
        for (Carrito articulo: CarritoSingleton.getInstance().getListaCarrito()) {
            totalD += articulo.getMonto();
        }


        ProgressDialog nDialog;
        nDialog = new ProgressDialog(context);
        nDialog.setMessage("Alerta...");
        nDialog.setTitle("Alerta");
        nDialog.setIndeterminate(false);
        nDialog.show();


        if (totalD >= vdeSaldo){
            AlertDialog.Builder myBuild = new AlertDialog.Builder(context);
            myBuild.setMessage("No puedes seguir agregando mas productos. "  +  '\n' +  "Tu saldo actual es de: " + vdeSaldo + "0" + '\n' +
                    "Saldo Total del pedido: " + totalD + "0"
                    +  '\n' + "Le invitamos a realizar una recarga  o a eliminar productos de la lista para continuar");
            myBuild.setTitle(Html.fromHtml("<font color ='#FF0000'> ¡Saldo Insuficiente! </font>"));
            myBuild.setPositiveButton("Recargar Saldo", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent recarga = new Intent(context, SaldosActivity.class);
                    recarga.putExtra("cuenta", "");
                    context.startActivity(recarga);
                }
            });
            myBuild.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    return;
                }
            });
            AlertDialog dialog = myBuild.create();
            dialog.show();
            nDialog.dismiss();

            return;
        }
        nDialog.dismiss();
        /************************/
        Toast.makeText(context, item.getArticulo().getCDescripcion() + " agregado al carrito", Toast.LENGTH_SHORT).show();
    }

    public synchronized void consultaItemCarrito(Context context){
        CarritoDBHelper carritoDBHelper = new CarritoDBHelper(context);
        this.listaCarrito = carritoDBHelper.recuperarPedidos();
        for (Carrito item: listaCarrito) {
            if(!pilaProveedores.contains(item.getArticulo().getIProveedor())){
                pilaProveedores.push(item.getArticulo().getIProveedor());
            }
            if(!pilaDomicilios.contains(String.valueOf(item.getArticulo().getIProveedor())+ "," + String.valueOf(item.getArticulo().getIDomicilio()))){
                pilaDomicilios.push(String.valueOf(item.getArticulo().getIProveedor())+ "," + String.valueOf(item.getArticulo().getIDomicilio()));
            }
        }
    }

    public synchronized void vaciarCarrito(Context context){
        listaCarrito.clear();
        boolean changed = pilaProveedores.removeAll(pilaProveedores);
        boolean changed2 = pilaDomicilios.removeAll(pilaDomicilios);
        if (changed && changed2)
            System.out.println("Limpieza ");
        else
            System.out.println("Limpieza no hecha");
        // Vacia la base de datos
        CarritoDBHelper carritoDBHelper = new CarritoDBHelper(context);
        carritoDBHelper.vaciaCarrito();
        Toast.makeText(context,"Carrito vacio", Toast.LENGTH_SHORT).show();
    }

    public synchronized void eliminarArticuloCarrito(Context context, int id){
        listaCarrito.remove(id - 1);
        CarritoDBHelper carritoDBHelper = new CarritoDBHelper(context);
        carritoDBHelper.eliminarArticuloCarrito(id);
    }

    public synchronized List<Carrito> getListaCarrito() {
        return listaCarrito;
    }

    public synchronized TtCtCliente_ getCliente() {
        return cliente;
    }

    public synchronized void setCliente(TtCtCliente_ cliente) {
        this.cliente = cliente;
    }

    public synchronized TtCtUsuario_ getUsuario_() {
        return usuario_;
    }

    public synchronized void setUsuario_(TtCtUsuario_ usuario_) {
        this.usuario_ = usuario_;
    }

    public synchronized TtCtTelefono_ getTelefono() {
        return telefono;
    }

    public synchronized void setTelefono(TtCtTelefono_ telefono) {
        this.telefono = telefono;
    }

    public synchronized Integer getNumeroProveedores() {
        return pilaProveedores.size();
    }

    public synchronized Stack<Integer> getPilaProveedores() {
        return pilaProveedores;
    }

    public synchronized Integer getNumeroDomicilios() {
        return pilaDomicilios.size();
    }

    public synchronized Stack<String> getPilaDomicilios() {
        return pilaDomicilios;
    }

    public synchronized List<TtCtDomicilio_> getDomicilio() {
        return domicilio;
    }

    public synchronized void setDomicilio(List<TtCtDomicilio_> domicilio) {
        this.domicilio = domicilio;
    }

    public synchronized TtCtDomicilio_ getDomicilioActual() {
        return domicilioActual;
    }

    public synchronized void setDomicilioActual(TtCtDomicilio_ domicilioActual) {
        this.domicilioActual = domicilioActual;
    }
}
