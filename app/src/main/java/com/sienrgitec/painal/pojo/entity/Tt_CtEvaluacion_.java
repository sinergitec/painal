package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tt_CtEvaluacion_ {

    @SerializedName("iEvalua")
    @Expose
    private Integer iEvalua;

    @SerializedName("cTipo")
    @Expose
    private String cTipo;

    @SerializedName("iPunto")
    @Expose
    private Integer iPunto;

    @SerializedName("cEvalua")
    @Expose
    private String cEvalua;

    @SerializedName("lActivo")
    @Expose
    private Boolean lActivo;

    @SerializedName("dtCreado")
    @Expose
    private Object dtCreado;

    @SerializedName("dtModificado")
    @Expose
    private Object dtModificado;

    @SerializedName("cUsuCrea")
    @Expose
    private String cUsuCrea;

    @SerializedName("cUsuModifica")
    @Expose
    private String cUsuModifica;


    public Integer getiEvalua() {
        return iEvalua;
    }

    public void setiEvalua(Integer iEvalua) {
        this.iEvalua = iEvalua;
    }

    public String getcTipo() {
        return cTipo;
    }

    public void setcTipo(String cTipo) {
        this.cTipo = cTipo;
    }

    public Integer getiPunto() {
        return iPunto;
    }

    public void setiPunto(Integer iPunto) {
        this.iPunto = iPunto;
    }

    public String getcEvalua() {
        return cEvalua;
    }

    public void setcEvalua(String cEvalua) {
        this.cEvalua = cEvalua;
    }

    public Boolean getlActivo() {
        return lActivo;
    }

    public void setlActivo(Boolean lActivo) {
        this.lActivo = lActivo;
    }

    public Object getDtCreado() {
        return dtCreado;
    }

    public void setDtCreado(Object dtCreado) {
        this.dtCreado = dtCreado;
    }

    public Object getDtModificado() {
        return dtModificado;
    }

    public void setDtModificado(Object dtModificado) {
        this.dtModificado = dtModificado;
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
}
