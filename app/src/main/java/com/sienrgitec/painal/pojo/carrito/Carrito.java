package com.sienrgitec.painal.pojo.carrito;

import com.sienrgitec.painal.pojo.entity.TtCtArtProveedor_;

import java.io.Serializable;

public class Carrito implements Serializable {
    private TtCtArtProveedor_ articulo;
    private Double cantidadArticulo;
    private Double monto;

    public Carrito (){

    }

    public Carrito(TtCtArtProveedor_ articulo, Double cantidadArticulo, Double monto) {
        this.articulo = articulo;
        this.cantidadArticulo = cantidadArticulo;
        this.monto = monto;
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
}
