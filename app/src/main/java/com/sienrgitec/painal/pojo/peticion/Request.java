package com.sienrgitec.painal.pojo.peticion;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Request {

    public Request (){

    }

    public Request (DsCtCliente dsCtCliente){
        this.dsCtCliente = dsCtCliente;
    }

    public Request (DsCtCliente dsCtClienteActualiza, Integer num){
        this.dsCtClienteActualiza = dsCtClienteActualiza;
    }

    public Request (DsNvoPedido dsNvoPedido){
        this.dsNvoPedido = dsNvoPedido;
    }

    public Request (DsCtDomicilio dsCtDomicilio) {
        this.dsCtDomicilio = dsCtDomicilio;
    }

    public Request (DsCtContacto dsCtContacto) {
        this.dsCtContacto = dsCtContacto;
    }

    public Request (DsCtClienteAutorizados dsAutorizados) {
        this.dsAutorizados = dsAutorizados;
    }

    public Request (DsOpClienteReferidos dsClienteRef) {
        this.dsClienteRef = dsClienteRef;
    }

    /**Andros 050620*/
    public Request (ds_NvoPago dsTtCredDetCPCP){
        this.dsTtCredDetCPCP = dsTtCredDetCPCP;
    }

    @SerializedName("ds_NvoPago")
    @Expose
    private ds_NvoPago dsTtCredDetCPCP;

    @SerializedName("ds_ctCliente")
    @Expose
    private DsCtCliente dsCtCliente;

    @SerializedName("ds_CtCliente")
    @Expose
    private DsCtCliente dsCtClienteActualiza;

    @SerializedName("ds_NvoPedido")
    @Expose
    private DsNvoPedido dsNvoPedido;

    @SerializedName("ds_ctDomicilio")
    @Expose
    private DsCtDomicilio dsCtDomicilio;

    @SerializedName("ds_ctContacto")
    @Expose
    private DsCtContacto dsCtContacto;

    @SerializedName("ds_ClienteRef")
    @Expose
    private DsOpClienteReferidos dsClienteRef;

    @SerializedName("ds_Autorizados")
    @Expose
    private DsCtClienteAutorizados dsAutorizados;

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

    public DsCtDomicilio getDsCtDomicilio() {
        return dsCtDomicilio;
    }

    public void setDsCtDomicilio(DsCtDomicilio dsCtDomicilio) {
        this.dsCtDomicilio = dsCtDomicilio;
    }

    public DsCtContacto getDsCtContacto() {
        return dsCtContacto;
    }

    public void setDsCtContacto(DsCtContacto dsCtContacto) {
        this.dsCtContacto = dsCtContacto;
    }

    public DsOpClienteReferidos getDsClienteRef() {
        return dsClienteRef;
    }

    public void setDsClienteRef(DsOpClienteReferidos dsClienteRef) {
        this.dsClienteRef = dsClienteRef;
    }

    public DsCtClienteAutorizados getDsAutorizados() {
        return dsAutorizados;
    }

    public void setDsAutorizados(DsCtClienteAutorizados dsAutorizados) {
        this.dsAutorizados = dsAutorizados;
    }

    public DsCtCliente getDsCtClienteActualiza() {
        return dsCtClienteActualiza;
    }

    public void setDsCtClienteActualiza(DsCtCliente dsCtClienteActualiza) {
        this.dsCtClienteActualiza = dsCtClienteActualiza;
    }

    public ds_NvoPago getDsTtCredDetCPCP() {
        return dsTtCredDetCPCP;
    }

    public void setDsTtCredDetCPCP(ds_NvoPago dsTtCredDetCPCP) {
        this.dsTtCredDetCPCP = dsTtCredDetCPCP;
    }
}
