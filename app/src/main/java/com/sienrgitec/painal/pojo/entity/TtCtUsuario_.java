package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TtCtUsuario_ {

    @SerializedName("cUsuario")
    @Expose
    private String cUsuario;

    @SerializedName("cPassword")
    @Expose
    private String cPassword;

    @SerializedName("iPersona")
    @Expose
    private Integer iPersona;

    @SerializedName("iTipoPersona")
    @Expose
    private Integer iTipoPersona;

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

    public String getcUsuario() {
        return cUsuario;
    }

    public void setcUsuario(String cUsuario) {
        this.cUsuario = cUsuario;
    }

    public String getcPassword() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword;
    }

    public Integer getiPersona() {
        return iPersona;
    }

    public void setiPersona(Integer iPersona) {
        this.iPersona = iPersona;
    }

    public Integer getiTipoPersona() {
        return iTipoPersona;
    }

    public void setiTipoPersona(Integer iTipoPersona) {
        this.iTipoPersona = iTipoPersona;
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

    @SerializedName("cUsuModifica")
    @Expose
    private String cUsuModifica;
}
