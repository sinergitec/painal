package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TtCtClienteAutorizados_ {

    @SerializedName("iCliente")
    @Expose
    private Integer iCliente;

    @SerializedName("iAutorizado")
    @Expose
    private Integer iAutorizado;

    @SerializedName("cNombre")
    @Expose
    private String cNombre;

    @SerializedName("cApellidos")
    @Expose
    private String cApellidos;

    @SerializedName("lSolicitaAut")
    @Expose
    private Boolean lSolicitaAut;

    @SerializedName("cParentesco")
    @Expose
    private String cParentesco;

    @SerializedName("cEdad")
    @Expose
    private String cEdad;

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
    public Integer getiCliente() {
        return iCliente;
    }

    public void setiCliente(Integer iCliente) {
        this.iCliente = iCliente;
    }

    public Integer getiAutorizado() {
        return iAutorizado;
    }

    public void setiAutorizado(Integer iAutorizado) {
        this.iAutorizado = iAutorizado;
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

    public Boolean getlSolicitaAut() {
        return lSolicitaAut;
    }

    public void setlSolicitaAut(Boolean lSolicitaAut) {
        this.lSolicitaAut = lSolicitaAut;
    }

    public String getcParentesco() {
        return cParentesco;
    }

    public void setcParentesco(String cParentesco) {
        this.cParentesco = cParentesco;
    }

    public String getcEdad() {
        return cEdad;
    }

    public void setcEdad(String cEdad) {
        this.cEdad = cEdad;
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
