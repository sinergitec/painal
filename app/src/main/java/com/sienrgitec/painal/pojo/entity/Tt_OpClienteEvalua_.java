package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Tt_OpClienteEvalua_ implements Serializable {

    @SerializedName("iEvalua")
    @Expose
    private Integer iEvalua;

    @SerializedName("iPedido")
    @Expose
    private Integer iPedido;

    @SerializedName("iPersona")
    @Expose
    private Integer iPersona;

    @SerializedName("iPunto")
    @Expose
    private Integer iPunto;

    @SerializedName("iTipoPersona")
    @Expose
    private Integer iTipoPersona;

    @SerializedName("cObs")
    @Expose
    private String cObs;

    @SerializedName("cTipo")
    @Expose
    private String cTipo;

    @SerializedName("cUsuCrea")
    @Expose
    private String cUsuCrea;

    @SerializedName("cUsuModifica")
    @Expose
    private String cUsuModifica;

    @SerializedName("cValor")
    @Expose
    private String cValor;

    @SerializedName("dtCreado")
    @Expose
    private Object dtCreado;

    @SerializedName("dtFecha")
    @Expose
    private Object dtFecha;

    public Integer getiEvalua() {
        return iEvalua;
    }

    public void setiEvalua(Integer iEvalua) {
        this.iEvalua = iEvalua;
    }

    public Integer getiPedido() {
        return iPedido;
    }

    public void setiPedido(Integer iPedido) {
        this.iPedido = iPedido;
    }

    public Integer getiPersona() {
        return iPersona;
    }

    public void setiPersona(Integer iPersona) {
        this.iPersona = iPersona;
    }

    public Integer getiPunto() {
        return iPunto;
    }

    public void setiPunto(Integer iPunto) {
        this.iPunto = iPunto;
    }

    public Integer getiTipoPersona() {
        return iTipoPersona;
    }

    public void setiTipoPersona(Integer iTipoPersona) {
        this.iTipoPersona = iTipoPersona;
    }

    public String getcObs() {
        return cObs;
    }

    public void setcObs(String cObs) {
        this.cObs = cObs;
    }

    public String getcTipo() {
        return cTipo;
    }

    public void setcTipo(String cTipo) {
        this.cTipo = cTipo;
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

    public String getcValor() {
        return cValor;
    }

    public void setcValor(String cValor) {
        this.cValor = cValor;
    }

    public Object getDtCreado() {
        return dtCreado;
    }

    public void setDtCreado(Object dtCreado) {
        this.dtCreado = dtCreado;
    }

    public Object getDtFecha() {
        return dtFecha;
    }

    public void setDtFecha(Object dtFecha) {
        this.dtFecha = dtFecha;
    }
}
