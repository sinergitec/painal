package com.sienrgitec.painal.pojo.peticion;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Request {

    public Request (){

    }

    //cliente
    public Request (DsCtCliente dsCtCliente){
        this.dsCtCliente = dsCtCliente;
    }

    //Cliente autorizado
    public Request (DsCtCliente dsCtClienteActualiza, Integer num){
        this.dsCtClienteActualiza = dsCtClienteActualiza;
    }
    public Request (DsCtClienteAutorizados dsAutorizados) {
        this.dsAutorizados = dsAutorizados;
    }

    //nuevo pedido
    public Request (DsNvoPedido dsNvoPedido, String password){
        this.dsNvoPedido = dsNvoPedido;
        this.ipcPassword = password;
    }

    //Domicilio
    public Request (DsCtDomicilio dsCtDomicilio) {
        this.dsCtDomicilio = dsCtDomicilio;
    }

    //contacto
    public Request (DsCtContacto dsCtContacto) {
        this.dsCtContacto = dsCtContacto;
    }

    //Evaluacion
    public Request (DsNvaEvaluacion dsNvaEvaluacion) {
        this.dsNvaEvaluacion = dsNvaEvaluacion;
    }

    public Request(DsNvaEvaluacion dsNvaEvaluacion, String finalTipoP) {
        this.dsNvaEvaluacion = dsNvaEvaluacion;
        this.ipcPersona = finalTipoP;
    }

    //clientes referidos
    public Request (DsOpClienteReferidos dsClienteRef) {
        this.dsClienteRef = dsClienteRef;
    }

    /**Andros 050620*/
    public Request (ds_NvoPago dsTtCredDetCPCP){
        this.dsTtCredDetCPCP = dsTtCredDetCPCP;
    }


//variables
    @SerializedName("ipcPersona")
    @Expose
    private  String ipcPersona;

    @SerializedName("ipcPassword")
    @Expose
    private  String ipcPassword;

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

    @SerializedName("ds_NvaEvaluacion")
    @Expose
    private DsNvaEvaluacion dsNvaEvaluacion;

    public DsNvaEvaluacion getDsNvaEvaluacion() {
        return dsNvaEvaluacion;
    }

    public void setDsNvaEvaluacion(DsNvaEvaluacion dsNvaEvaluacion) {
        this.dsNvaEvaluacion = dsNvaEvaluacion;
    }

    public DsNvaEvaluacion getDs_NvaEvaluacion() {
        return dsNvaEvaluacion;
    }

    public void setDs_NvaEvaluacion(DsNvaEvaluacion ds_NvaEvaluacion) {
        this.dsNvaEvaluacion = dsNvaEvaluacion;
    }

    public DsCtCliente getDsCtCliente() {
        return dsCtCliente;
    }

    public void setDsCtCliente(DsCtCliente dsCtCliente) {
        this.dsCtCliente = dsCtCliente;
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

    public DsNvoPedido getDsNvoPedido() {
        return dsNvoPedido;
    }

    public void setDsNvoPedido(DsNvoPedido dsNvoPedido) {
        this.dsNvoPedido = dsNvoPedido;

    }
    public String getPassword() {
        return ipcPassword;
    }

    public void setPassword(String password) {
        this.ipcPassword = password;
    }

    public String getIpcPersona() {
        return ipcPersona;
    }

    public void setIpcPersona(String ipcPersona) {
        this.ipcPersona = ipcPersona;
    }

    public String getIpcPassword() {
        return ipcPassword;
    }

    public void setIpcPassword(String ipcPassword) {
        this.ipcPassword = ipcPassword;
    }
}
