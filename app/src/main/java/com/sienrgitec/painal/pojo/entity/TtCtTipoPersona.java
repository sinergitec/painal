package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TtCtTipoPersona {

    @SerializedName("iTipoPersona")
    @Expose
    private Integer iTipoPersona;

    @SerializedName("cTabla")
    @Expose
    private String cTabla;

    @SerializedName("lActivo")
    @Expose
    private Boolean lActivo;

    @SerializedName("dtCreado")
    @Expose
    private Object dtCreado;

    @SerializedName("dtModificado")
    @Expose
    private Object dtModificado;

    public Integer getiTipoPersona() {
        return iTipoPersona;
    }

    public void setiTipoPersona(Integer iTipoPersona) {
        this.iTipoPersona = iTipoPersona;
    }

    public String getcTabla() {
        return cTabla;
    }

    public void setcTabla(String cTabla) {
        this.cTabla = cTabla;
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

    @SerializedName("cUsuCrea")
    @Expose
    private String cUsuCrea;

    @SerializedName("cUsuModifica")
    @Expose
    private String cUsuModifica;
}
