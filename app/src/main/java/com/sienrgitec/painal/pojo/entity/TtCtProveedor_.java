package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TtCtProveedor_  implements Serializable {

    @SerializedName("iProveedor")
    @Expose
    private Integer iProveedor;
    @SerializedName("cClaveProv")
    @Expose
    private String cClaveProv;
    @SerializedName("cRazonSocial")
    @Expose
    private String cRazonSocial;
    @SerializedName("cNegocio")
    @Expose
    private String cNegocio;
    @SerializedName("cRFC")
    @Expose
    private String cRFC;
    @SerializedName("iGiro")
    @Expose
    private Integer iGiro;
    @SerializedName("iSubGiro")
    @Expose
    private Integer iSubGiro;
    @SerializedName("cWhatsApp")
    @Expose
    private String cWhatsApp;
    @SerializedName("cPaginaWeb")
    @Expose
    private String cPaginaWeb;
    @SerializedName("cEMail")
    @Expose
    private String cEMail;
    @SerializedName("cTwitter")
    @Expose
    private String cTwitter;
    @SerializedName("cFacebook")
    @Expose
    private String cFacebook;
    @SerializedName("iEstadoProv")
    @Expose
    private Integer iEstadoProv;
    @SerializedName("lSucursales")
    @Expose
    private Boolean lSucursales;
    @SerializedName("iNivelClasifica")
    @Expose
    private Integer iNivelClasifica;
    @SerializedName("lSistema")
    @Expose
    private Boolean lSistema;
    @SerializedName("cSistema")
    @Expose
    private String cSistema;
    @SerializedName("cObs")
    @Expose
    private String cObs;
    @SerializedName("dtAfiliacion")
    @Expose
    private Object dtAfiliacion;
    @SerializedName("dtCreado")
    @Expose
    private String dtCreado;
    @SerializedName("dtModificado")
    @Expose
    private String dtModificado;
    @SerializedName("cUsuCrea")
    @Expose
    private String cUsuCrea;
    @SerializedName("cUsuModifica")
    @Expose
    private String cUsuModifica;

    @SerializedName("iDomicilio")
    @Expose
    private Integer iDomicilio;

    @SerializedName("deEvaluacion")
    @Expose
    private Double deEvaluacion;

    @SerializedName("cEvaluacion")
    @Expose
    private String cEvaluacion;

    @SerializedName("cTipoProv")
    @Expose
    private String cTipoProv;

    @SerializedName("lPideOtrasUnidades")
    @Expose
    private String lPideOtrasUnidades;

    @SerializedName("cDomicilio")
    @Expose
    private String cDomicilio;

    @SerializedName("Id")
    @Expose
    private Object id;



    public TtCtProveedor_(){

    }

    public TtCtProveedor_(Integer iProveedor, String cClaveProv, String cRazonS, String cNegocio, String cRFC, Integer iGiro, Integer iSubGiro, String cWhatsApp,
                          String cPaginaWeb, String cEMail, String cTwitter, String cFacebook, Integer iEstadoProv, Boolean lSucursales, Integer iNivelClasifica,
                          Boolean lSistema, String cSistema, String cObs, Object dtAfiliacion, String dtCreado, String dtModificado, String cUsuCrea, String cUsuModifica,
                          Integer iDomicilio, Double deEvaluacion, String cEvaluacion, String cTipoProv,  String cDomicilio, Object id) {
        this.iProveedor = iProveedor;
        this.cClaveProv = cClaveProv;
        this.cRazonSocial = cRazonSocial;
        this.cNegocio = cNegocio;
        this.cRFC = cRFC;
        this.iGiro = iGiro;
        this.iSubGiro = iSubGiro;
        this.cWhatsApp = cWhatsApp;
        this.cPaginaWeb = cPaginaWeb;
        this.cEMail = cEMail;
        this.cTwitter = cTwitter;
        this.cFacebook = cFacebook;
        this.iEstadoProv = iEstadoProv;
        this.lSucursales = lSucursales;
        this.iNivelClasifica = iNivelClasifica;
        this.lSistema = lSistema;
        this.cSistema = cSistema;
        this.cObs = cObs;
        this.dtAfiliacion = dtAfiliacion;
        this.dtCreado = dtCreado;
        this.dtModificado = dtModificado;
        this.cUsuCrea = cUsuCrea;
        this.cUsuModifica = cUsuModifica;
        this.iDomicilio = iDomicilio;
        this.deEvaluacion = deEvaluacion;
        this.cEvaluacion = cEvaluacion;
        this.cTipoProv = cTipoProv;
        this.cDomicilio = cDomicilio;
        this.id = id;
    }


    public String getcDomicilio() {
        return cDomicilio;
    }

    public void setcDomicilio(String cDomicilio) {
        this.cDomicilio = cDomicilio;
    }

    public String getcTipoProv() {
        return cTipoProv;
    }

    public void setcTipoProv(String cTipoProv) {
        this.cTipoProv = cTipoProv;
    }

    public String getcEvaluacion() {
        return cEvaluacion;
    }

    public void setcEvaluacion(String cEvaluacion) {
        this.cEvaluacion = cEvaluacion;
    }

    public Integer getiDomicilio() {
        return iDomicilio;
    }

    public void setiDomicilio(Integer iDomicilio) {
        this.iDomicilio = iDomicilio;
    }

    public Double getDeEvaluacion() {
        return deEvaluacion;
    }

    public void setDeEvaluacion(Double deEvaluacion) {
        this.deEvaluacion = deEvaluacion;
    }

    public Integer getIProveedor() {
        return iProveedor;
    }

    public void setIProveedor(Integer iProveedor) {
        this.iProveedor = iProveedor;
    }

    public String getCClaveProv() {
        return cClaveProv;
    }

    public void setCClaveProv(String cClaveProv) {
        this.cClaveProv = cClaveProv;
    }

    public String getcRazonSocial() {
        return cRazonSocial;
    }

    public void setcRazonSocial(String cRazonSocial) {
        this.cRazonSocial = cRazonSocial;
    }

    public String getCNegocio() {
        return cNegocio;
    }

    public void setCNegocio(String cNegocio) {
        this.cNegocio = cNegocio;
    }

    public String getCRFC() {
        return cRFC;
    }

    public void setCRFC(String cRFC) {
        this.cRFC = cRFC;
    }

    public Integer getIGiro() {
        return iGiro;
    }

    public void setIGiro(Integer iGiro) {
        this.iGiro = iGiro;
    }

    public Integer getISubGiro() {
        return iSubGiro;
    }

    public void setISubGiro(Integer iSubGiro) {
        this.iSubGiro = iSubGiro;
    }

    public String getCWhatsApp() {
        return cWhatsApp;
    }

    public void setCWhatsApp(String cWhatsApp) {
        this.cWhatsApp = cWhatsApp;
    }

    public String getCPaginaWeb() {
        return cPaginaWeb;
    }

    public void setCPaginaWeb(String cPaginaWeb) {
        this.cPaginaWeb = cPaginaWeb;
    }

    public String getCEMail() {
        return cEMail;
    }

    public void setCEMail(String cEMail) {
        this.cEMail = cEMail;
    }

    public String getCTwitter() {
        return cTwitter;
    }

    public void setCTwitter(String cTwitter) {
        this.cTwitter = cTwitter;
    }

    public String getCFacebook() {
        return cFacebook;
    }

    public void setCFacebook(String cFacebook) {
        this.cFacebook = cFacebook;
    }

    public Integer getIEstadoProv() {
        return iEstadoProv;
    }

    public void setIEstadoProv(Integer iEstadoProv) {
        this.iEstadoProv = iEstadoProv;
    }

    public Boolean getLSucursales() {
        return lSucursales;
    }

    public void setLSucursales(Boolean lSucursales) {
        this.lSucursales = lSucursales;
    }

    public Integer getINivelClasifica() {
        return iNivelClasifica;
    }

    public void setINivelClasifica(Integer iNivelClasifica) {
        this.iNivelClasifica = iNivelClasifica;
    }

    public Boolean getLSistema() {
        return lSistema;
    }

    public void setLSistema(Boolean lSistema) {
        this.lSistema = lSistema;
    }

    public String getCSistema() {
        return cSistema;
    }

    public void setCSistema(String cSistema) {
        this.cSistema = cSistema;
    }

    public String getCObs() {
        return cObs;
    }

    public void setCObs(String cObs) {
        this.cObs = cObs;
    }

    public Object getDtAfiliacion() {
        return dtAfiliacion;
    }

    public void setDtAfiliacion(Object dtAfiliacion) {
        this.dtAfiliacion = dtAfiliacion;
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

    public String getCUsuCrea() {
        return cUsuCrea;
    }

    public void setCUsuCrea(String cUsuCrea) {
        this.cUsuCrea = cUsuCrea;
    }

    public String getCUsuModifica() {
        return cUsuModifica;
    }

    public void setCUsuModifica(String cUsuModifica) {
        this.cUsuModifica = cUsuModifica;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Integer getiProveedor() {
        return iProveedor;
    }

    public void setiProveedor(Integer iProveedor) {
        this.iProveedor = iProveedor;
    }

    public String getcClaveProv() {
        return cClaveProv;
    }

    public void setcClaveProv(String cClaveProv) {
        this.cClaveProv = cClaveProv;
    }


    public String getcNegocio() {
        return cNegocio;
    }

    public void setcNegocio(String cNegocio) {
        this.cNegocio = cNegocio;
    }

    public String getcRFC() {
        return cRFC;
    }

    public void setcRFC(String cRFC) {
        this.cRFC = cRFC;
    }

    public Integer getiGiro() {
        return iGiro;
    }

    public void setiGiro(Integer iGiro) {
        this.iGiro = iGiro;
    }

    public Integer getiSubGiro() {
        return iSubGiro;
    }

    public void setiSubGiro(Integer iSubGiro) {
        this.iSubGiro = iSubGiro;
    }

    public String getcWhatsApp() {
        return cWhatsApp;
    }

    public void setcWhatsApp(String cWhatsApp) {
        this.cWhatsApp = cWhatsApp;
    }

    public String getcPaginaWeb() {
        return cPaginaWeb;
    }

    public void setcPaginaWeb(String cPaginaWeb) {
        this.cPaginaWeb = cPaginaWeb;
    }

    public String getcEMail() {
        return cEMail;
    }

    public void setcEMail(String cEMail) {
        this.cEMail = cEMail;
    }

    public String getcTwitter() {
        return cTwitter;
    }

    public void setcTwitter(String cTwitter) {
        this.cTwitter = cTwitter;
    }

    public String getcFacebook() {
        return cFacebook;
    }

    public void setcFacebook(String cFacebook) {
        this.cFacebook = cFacebook;
    }

    public Integer getiEstadoProv() {
        return iEstadoProv;
    }

    public void setiEstadoProv(Integer iEstadoProv) {
        this.iEstadoProv = iEstadoProv;
    }

    public Boolean getlSucursales() {
        return lSucursales;
    }

    public void setlSucursales(Boolean lSucursales) {
        this.lSucursales = lSucursales;
    }

    public Integer getiNivelClasifica() {
        return iNivelClasifica;
    }

    public void setiNivelClasifica(Integer iNivelClasifica) {
        this.iNivelClasifica = iNivelClasifica;
    }

    public Boolean getlSistema() {
        return lSistema;
    }

    public void setlSistema(Boolean lSistema) {
        this.lSistema = lSistema;
    }

    public String getcSistema() {
        return cSistema;
    }

    public void setcSistema(String cSistema) {
        this.cSistema = cSistema;
    }

    public String getcObs() {
        return cObs;
    }

    public void setcObs(String cObs) {
        this.cObs = cObs;
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

    public String getlPideOtrasUnidades() {
        return lPideOtrasUnidades;
    }

    public void setlPideOtrasUnidades(String lPideOtrasUnidades) {
        this.lPideOtrasUnidades = lPideOtrasUnidades;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TtCtProveedor_{");
        sb.append("iProveedor=").append(iProveedor);
        sb.append(", cClaveProv='").append(cClaveProv).append('\'');
        sb.append(", cRazonSocial='").append(cRazonSocial).append('\'');
        sb.append(", cNegocio='").append(cNegocio).append('\'');
        sb.append(", cRFC='").append(cRFC).append('\'');
        sb.append(", iGiro=").append(iGiro);
        sb.append(", iSubGiro=").append(iSubGiro);
        sb.append(", cWhatsApp='").append(cWhatsApp).append('\'');
        sb.append(", cPaginaWeb='").append(cPaginaWeb).append('\'');
        sb.append(", cEMail='").append(cEMail).append('\'');
        sb.append(", cTwitter='").append(cTwitter).append('\'');
        sb.append(", cFacebook='").append(cFacebook).append('\'');
        sb.append(", iEstadoProv=").append(iEstadoProv);
        sb.append(", lSucursales=").append(lSucursales);
        sb.append(", iNivelClasifica=").append(iNivelClasifica);
        sb.append(", lSistema=").append(lSistema);
        sb.append(", cSistema='").append(cSistema).append('\'');
        sb.append(", cObs='").append(cObs).append('\'');
        sb.append(", dtAfiliacion=").append(dtAfiliacion);
        sb.append(", dtCreado='").append(dtCreado).append('\'');
        sb.append(", dtModificado='").append(dtModificado).append('\'');
        sb.append(", cUsuCrea='").append(cUsuCrea).append('\'');
        sb.append(", cUsuModifica='").append(cUsuModifica).append('\'');
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }

}
