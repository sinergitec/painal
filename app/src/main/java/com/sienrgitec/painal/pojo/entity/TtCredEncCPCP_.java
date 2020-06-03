package com.sienrgitec.painal.pojo.entity;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TtCredEncCPCP_ implements Serializable {
    
    @SerializedName("cCuenta")
    @Expose
    private String cCuenta;

    @SerializedName("cUltMov")
    @Expose
    private String cUltMov;

    @SerializedName("cUsuCrea")
    @Expose
    private String cUsuCrea;

    @SerializedName("cUsuModifica")
    @Expose
    private String cUsuModifica;

    @SerializedName("deSaldo")
    @Expose
    private String deSaldo;

    @SerializedName("deUltMov")
    @Expose
    private String deUltMov;

    @SerializedName("dtAfiliado")
    @Expose
    private String dtAfiliado;

    @SerializedName("dtCreado")
    @Expose
    private String dtCreado;

    @SerializedName("dtModificado")
    @Expose
    private String dtModificado;

    @SerializedName("dtVencimiento")
    @Expose
    private String dtVencimiento;

    @SerializedName("iCliente")
    @Expose
    private Integer iCliente;

    @SerializedName("iUltPedido")
    @Expose
    private Integer iUltPedido;

    @SerializedName("lActivo")
    @Expose
    private Boolean lActivo;

    @SerializedName("id")
    @Expose
    private Object id;


    public String getcCuenta() {
        return cCuenta;
    }

    public void setcCuenta(String cCuenta) {
        this.cCuenta = cCuenta;
    }

    public String getcUltMov() {
        return cUltMov;
    }

    public void setcUltMov(String cUltMov) {
        this.cUltMov = cUltMov;
    }

    public String getcUsuCrea() {
        return cUsuCrea;
    }

    public void setcUsuCrea(String cUsuCrea) {
        this.cUsuCrea = cUsuCrea;
    }

    public String getcUsuModifica() {
        return cUsuModifica;
    }

    public void setcUsuModifica(String cUsuModifica) {
        this.cUsuModifica = cUsuModifica;
    }

    public String getDeSaldo() {
        return deSaldo;
    }

    public void setDeSaldo(String deSaldo) {
        this.deSaldo = deSaldo;
    }

    public String getDeUltMov() {
        return deUltMov;
    }

    public void setDeUltMov(String deUltMov) {
        this.deUltMov = deUltMov;
    }

    public String getDtAfiliado() {
        return dtAfiliado;
    }

    public void setDtAfiliado(String dtAfiliado) {
        this.dtAfiliado = dtAfiliado;
    }

    public String getDtCreado() {
        return dtCreado;
    }

    public void setDtCreado(String dtCreado) {
        this.dtCreado = dtCreado;
    }

    public String getDtModificado() {
        return dtModificado;
    }

    public void setDtModificado(String dtModificado) {
        this.dtModificado = dtModificado;
    }

    public String getDtVencimiento() {
        return dtVencimiento;
    }

    public void setDtVencimiento(String dtVencimiento) {
        this.dtVencimiento = dtVencimiento;
    }

    public Integer getiCliente() {
        return iCliente;
    }

    public void setiCliente(Integer iCliente) {
        this.iCliente = iCliente;
    }

    public Integer getiUltPedido() {
        return iUltPedido;
    }

    public void setiUltPedido(Integer iUltPedido) {
        this.iUltPedido = iUltPedido;
    }

    public Boolean getlActivo() {
        return lActivo;
    }

    public void setlActivo(Boolean lActivo) {
        this.lActivo = lActivo;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }
}
