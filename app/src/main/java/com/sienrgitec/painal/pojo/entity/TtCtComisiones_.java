package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TtCtComisiones_ {

    @SerializedName("cComision")
    @Expose
    private String cComision;

    @SerializedName("iComision")
    @Expose
    private int iComision;

    @SerializedName("cNombre")
    @Expose
    private String cNombre;

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

    @SerializedName("deValor")
    @Expose
    private Double deValor;

    private Object  id;

    public String getcComision() {
        return cComision;
    }

    public void setcComision(String cComision) {
        this.cComision = cComision;
    }

    public int getiComision() {
        return iComision;
    }

    public void setiComision(int iComision) {
        this.iComision = iComision;
    }

    public String getcNombre() {
        return cNombre;
    }

    public void setcNombre(String cNombre) {
        this.cNombre = cNombre;
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

    public Double getDeValor() {
        return deValor;
    }

    public void setDeValor(Double deValor) {
        this.deValor = deValor;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }
}
