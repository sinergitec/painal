package com.sienrgitec.painal.pojo.carrito;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sienrgitec.painal.pojo.entity.TtCtArtProveedor_;

import java.io.Serializable;

public class Carrito implements Serializable {
    private TtCtArtProveedor_ articulo;
    private Double cantidadArticulo = 0.0 ;
    private Double monto = 0.0 ;
    private String tipoUnidad;

    public Carrito (){

    }

    public Carrito(TtCtArtProveedor_ articulo, Double cantidadArticulo, Double monto, String tipoUnidad) {
        this.articulo = articulo;
        this.cantidadArticulo = cantidadArticulo;
        this.monto = monto;
        this.tipoUnidad = tipoUnidad;
    }

    public TtCtArtProveedor_ getArticulo() {
        return articulo;
    }

    public void setArticulo(TtCtArtProveedor_ articulo) {
        this.articulo = articulo;
    }

    public Double getCantidadArticulo() {
        return cantidadArticulo;
    }

    public void setCantidadArticulo(Double cantidadArticulo) {
        this.cantidadArticulo = cantidadArticulo;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getTipoUnidad() {
        return tipoUnidad;
    }

    public void setTipoUnidad(String tipoUnidad) {
        this.tipoUnidad = tipoUnidad;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Carrito{");
        sb.append("articulo=").append(articulo);
        sb.append(", cantidadArticulo=").append(cantidadArticulo);
        sb.append(", monto=").append(monto);
        sb.append(", tipoUnidad='").append(tipoUnidad).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
