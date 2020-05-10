package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tt_OpClienteReferidos_ {

    @SerializedName("iCliente")
    @Expose
    private Integer iCliente;

    @SerializedName("iReferido")
    @Expose
    private Integer iReferido;

    @SerializedName("cNombre")
    @Expose
    private String cNombre;

    @SerializedName("cApellidos")
    @Expose
    private String cApellidos;

    @SerializedName("cEmail")
    @Expose
    private String cEmail;

    @SerializedName("cTelefono")
    @Expose
    private String cTelefono;

    @SerializedName("cCveReferido")
    @Expose
    private String cCveReferido;

    @SerializedName("lAfiliado")
    @Expose
    private Boolean lAfiliado;

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

    public Integer getiReferido() {
        return iReferido;
    }

    public void setiReferido(Integer iReferido) {
        this.iReferido = iReferido;
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

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getcTelefono() {
        return cTelefono;
    }

    public void setcTelefono(String cTelefono) {
        this.cTelefono = cTelefono;
    }

    public String getcCveReferido() {
        return cCveReferido;
    }

    public void setcCveReferido(String cCveReferido) {
        this.cCveReferido = cCveReferido;
    }

    public Boolean getlAfiliado() {
        return lAfiliado;
    }

    public void setlAfiliado(Boolean lAfiliado) {
        this.lAfiliado = lAfiliado;
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
