package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TtCtTelefono_ {

    @SerializedName("iPersona")
    @Expose
    private Integer iPersona;

    @SerializedName("iTelefono")
    @Expose
    private Integer iTelefono;

    @SerializedName("iTipoPersona")
    @Expose
    private Integer iTipoPersona;

    @SerializedName("iTipoTelefono")
    @Expose
    private Integer iTipoTelefono;

    @SerializedName("cTelefono")
    @Expose
    private String cTelefono;

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

    public Integer getiPersona() {
        return iPersona;
    }

    public void setiPersona(Integer iPersona) {
        this.iPersona = iPersona;
    }

    public Integer getiTelefono() {
        return iTelefono;
    }

    public void setiTelefono(Integer iTelefono) {
        this.iTelefono = iTelefono;
    }

    public Integer getiTipoPersona() {
        return iTipoPersona;
    }

    public void setiTipoPersona(Integer iTipoPersona) {
        this.iTipoPersona = iTipoPersona;
    }

    public Integer getiTipoTelefono() {
        return iTipoTelefono;
    }

    public void setiTipoTelefono(Integer iTipoTelefono) {
        this.iTipoTelefono = iTipoTelefono;
    }

    public String getcTelefono() {
        return cTelefono;
    }

    public void setcTelefono(String cTelefono) {
        this.cTelefono = cTelefono;
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
