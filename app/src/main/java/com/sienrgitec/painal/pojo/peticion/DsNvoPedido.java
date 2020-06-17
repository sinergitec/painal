package com.sienrgitec.painal.pojo.peticion;

import android.util.Log;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sienrgitec.painal.pojo.entity.TtCredDetCPCP_;
import com.sienrgitec.painal.pojo.entity.TtOpPedido;
import com.sienrgitec.painal.pojo.entity.TtOpPedidoDet;
import com.sienrgitec.painal.pojo.entity.TtOpPedidoDomicilio;
import com.sienrgitec.painal.pojo.entity.TtOpPedidoPago;
import com.sienrgitec.painal.pojo.entity.TtOpPedidoProveedor;

import java.io.Serializable;
import java.util.List;

public class DsNvoPedido implements Serializable {


    public DsNvoPedido(){

    }

    public DsNvoPedido(List<TtOpPedido> ttOpPedido, List<TtOpPedidoProveedor> ttOpPedidoProveedor,
                       List<TtOpPedidoDet> ttOpPedidoDet, List<TtOpPedidoDomicilio> ttOpPedidoDomicilio,
                       List<TtOpPedidoPago> ttOpPedidoPago,
                       List<TtCredDetCPCP_> ttCredDetCPCP){
        this.ttOpPedido = ttOpPedido;
        this.ttOpPedidoProveedor = ttOpPedidoProveedor;
        this.ttOpPedidoDet = ttOpPedidoDet;
        this.ttOpPedidoDomicilio = ttOpPedidoDomicilio;
        this.ttOpPedidoPago = ttOpPedidoPago;
        this.ttCredDetCPCP = ttCredDetCPCP;


    }

    @SerializedName("password")
    @Expose
    private  String vcPassword;

    @SerializedName("tt_opPedido")
    @Expose
    private List<TtOpPedido> ttOpPedido = null;

    @SerializedName("tt_opPedidoProveedor")
    @Expose
    private List<TtOpPedidoProveedor> ttOpPedidoProveedor = null;

    @SerializedName("tt_opPedidoDet")
    @Expose
    private List<TtOpPedidoDet> ttOpPedidoDet = null;

    @SerializedName("tt_opPedidoDomicilio")
    @Expose
    private List<TtOpPedidoDomicilio> ttOpPedidoDomicilio = null;

    @SerializedName("tt_opPedidoPago")
    @Expose
    private List<TtOpPedidoPago> ttOpPedidoPago = null;

    @SerializedName("tt_credDetCPCP")
    @Expose
    private List<TtCredDetCPCP_> ttCredDetCPCP = null;

    public List<TtOpPedido> getTtOpPedido() {
        return ttOpPedido;
    }

    public void setTtOpPedido(List<TtOpPedido> ttOpPedido) {
        this.ttOpPedido = ttOpPedido;
    }

    public List<TtOpPedidoProveedor> getTtOpPedidoProveedor() {
        return ttOpPedidoProveedor;
    }

    public void setTtOpPedidoProveedor(List<TtOpPedidoProveedor> ttOpPedidoProveedor) {
        this.ttOpPedidoProveedor = ttOpPedidoProveedor;
    }

    public List<TtOpPedidoDet> getTtOpPedidoDet() {
        return ttOpPedidoDet;
    }

    public void setTtOpPedidoDet(List<TtOpPedidoDet> ttOpPedidoDet) {
        this.ttOpPedidoDet = ttOpPedidoDet;
    }

    public List<TtOpPedidoDomicilio> getTtOpPedidoDomicilio() {
        return ttOpPedidoDomicilio;
    }

    public void setTtOpPedidoDomicilio(List<TtOpPedidoDomicilio> ttOpPedidoDomicilio) {
        this.ttOpPedidoDomicilio = ttOpPedidoDomicilio;
    }

    public List<TtOpPedidoPago> getTtOpPedidoPago() {
        return ttOpPedidoPago;
    }

    public void setTtOpPedidoPago(List<TtOpPedidoPago> ttOpPedidoPago) {
        this.ttOpPedidoPago = ttOpPedidoPago;
    }


    public String getVcPassword() {
        return vcPassword;
    }

    public void setVcPassword(String vcPassword) {
        this.vcPassword = vcPassword;
    }

    @Override
    public String toString() {
        return "DsNvoPedido{" +
                "ipcPassword='" + vcPassword + '\'' +
                ", ttOpPedido=" + ttOpPedido +
                ", ttOpPedidoProveedor=" + ttOpPedidoProveedor +
                ", ttOpPedidoDet=" + ttOpPedidoDet +
                ", ttOpPedidoDomicilio=" + ttOpPedidoDomicilio +
                ", ttOpPedidoPago=" + ttOpPedidoPago +
                ", ttCredDetCPCP=" + ttCredDetCPCP +
                '}' ;
    }
}
