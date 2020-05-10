package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TtCtContacto_ {

    @SerializedName("iPersona")
    @Expose
    private int iPersona;

    @SerializedName("iContacto")
    @Expose
    private int iContacto;

    @SerializedName("iTipoPersona")
    @Expose
    private int iTipoPersona;

    @SerializedName("itipoContacto")
    @Expose
    private int itipoContacto;

    @SerializedName("cNombre")
    @Expose
    private String cNombre;

    @SerializedName("cApellidos")
    @Expose
    private String cApellidos;

    @SerializedName("cObs")
    @Expose
    private String cObs;

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

    //Getters and setters

    public int getiPersona() {
        return iPersona;
    }

    public void setiPersona(int iPersona) {
        this.iPersona = iPersona;
    }

    public int getiContacto() {
        return iContacto;
    }

    public void setiContacto(int iContacto) {
        this.iContacto = iContacto;
    }

    public int getiTipoPersona() {
        return iTipoPersona;
    }

    public void setiTipoPersona(int iTipoPersona) {
        this.iTipoPersona = iTipoPersona;
    }

    public int getItipoContacto() {
        return itipoContacto;
    }

    public void setItipoContacto(int itipoContacto) {
        this.itipoContacto = itipoContacto;
    }

    public String getcNombre() {
        return cNombre;
    }

    public void setcNombre(String cNombre) {
        this.cNombre = cNombre;
    }

    public String getcApellidos() {
        return cApellidos;
    }

    public void setcApellidos(String cApellidos) {
        this.cApellidos = cApellidos;
    }

    public String getcObs() {
        return cObs;
    }

    public void setcObs(String cObs) {
        this.cObs = cObs;
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
