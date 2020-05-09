package com.sienrgitec.painal.pojo.peticion;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Request {

    public Request (){

    }

    public Request (DsCtCliente dsCtCliente){
        this.dsCtCliente = dsCtCliente;
    }

    public Request (DsNvoPedido dsNvoPedido){
        this.dsNvoPedido = dsNvoPedido;
    }

    @SerializedName("ds_ctCliente")
    @Expose
    private DsCtCliente dsCtCliente;

    @SerializedName("ds_NvoPedido")
    @Expose
    private DsNvoPedido dsNvoPedido;

    public DsCtCliente getDsCtCliente() {
        return dsCtCliente;
    }

    public void setDsCtCliente(DsCtCliente dsCtCliente) {
        this.dsCtCliente = dsCtCliente;
    }

    public DsNvoPedido getDsNvoPedido() {
        return dsNvoPedido;
    }

    public void setDsNvoPedido(DsNvoPedido dsNvoPedido) {
        this.dsNvoPedido = dsNvoPedido;
    }
}
