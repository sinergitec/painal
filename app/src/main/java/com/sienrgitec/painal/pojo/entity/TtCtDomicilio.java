package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TtCtDomicilio implements Serializable {
    @SerializedName("iPersona")
    @Expose
    private String iPersona;
    @SerializedName("iDomicilio")
    @Expose
    private String iDomicilio;
    @SerializedName("iTipoPersona")
    @Expose
    private String iTipoPersona;
    @SerializedName("itipoDomicilio")
    @Expose
    private String itipoDomicilio;
    @SerializedName("cCalle")
    @Expose
    private String cCalle;
    @SerializedName("cNumeroExt")
    @Expose
    private String cNumeroExt;
    @SerializedName("cNumeroInt")
    @Expose
    private String cNumeroInt;
    @SerializedName("cColonia")
    @Expose
    private String cColonia;
    @SerializedName("cMpioDeleg")
    @Expose
    private String cMpioDeleg;
    @SerializedName("cEstado")
    @Expose
    private String cEstado;
    @SerializedName("cCP")
    @Expose
    private String cCP;
    @SerializedName("cPais")
    @Expose
    private String cPais;
    @SerializedName("cReferencia")
    @Expose
    private String cReferencia;
    @SerializedName("cObs")
    @Expose
    private String cObs;
    @SerializedName("deLongitud")
    @Expose
    private String deLongitud;
    @SerializedName("deLatitud")
    @Expose
    private String deLatitud;
    @SerializedName("lActivo")
    @Expose
    private Boolean lActivo;
    @SerializedName("dtCreado")
    @Expose
    private String dtCreado;
    @SerializedName("dtModificado")
    @Expose
    private String dtModificado;
    @SerializedName("cUsuCrea")
    @Expose
    private String cUsuCrea;
    @SerializedName("cUsuModifca")
    @Expose
    private String cUsuModifca;

    public TtCtDomicilio(String iPersona, String iDomicilio, String iTipoPersona, String itipoDomicilio, String cCalle, String cNumeroExt, String cNumeroInt, String cColonia, String cMpioDeleg, String cEstado, String cCP, String cPais, String cReferencia, String cObs, String deLongitud, String deLatitud, Boolean lActivo, String dtCreado, String dtModificado, String cUsuCrea, String cUsuModifca) {
        this.iPersona = iPersona;
        this.iDomicilio = iDomicilio;
        this.iTipoPersona = iTipoPersona;
        this.itipoDomicilio = itipoDomicilio;
        this.cCalle = cCalle;
        this.cNumeroExt = cNumeroExt;
        this.cNumeroInt = cNumeroInt;
        this.cColonia = cColonia;
        this.cMpioDeleg = cMpioDeleg;
        this.cEstado = cEstado;
        this.cCP = cCP;
        this.cPais = cPais;
        this.cReferencia = cReferencia;
        this.cObs = cObs;
        this.deLongitud = deLongitud;
        this.deLatitud = deLatitud;
        this.lActivo = lActivo;
        this.dtCreado = dtCreado;
        this.dtModificado = dtModificado;
        this.cUsuCrea = cUsuCrea;
        this.cUsuModifca = cUsuModifca;
    }

    public String getIPersona() {
        return iPersona;
    }

    public void setIPersona(String iPersona) {
        this.iPersona = iPersona;
    }

    public String getIDomicilio() {
        return iDomicilio;
    }

    public void setIDomicilio(String iDomicilio) {
        this.iDomicilio = iDomicilio;
    }

    public String getITipoPersona() {
        return iTipoPersona;
    }

    public void setITipoPersona(String iTipoPersona) {
        this.iTipoPersona = iTipoPersona;
    }

    public String getItipoDomicilio() {
        return itipoDomicilio;
    }

    public void setItipoDomicilio(String itipoDomicilio) {
        this.itipoDomicilio = itipoDomicilio;
    }

    public String getCCalle() {
        return cCalle;
    }

    public void setCCalle(String cCalle) {
        this.cCalle = cCalle;
    }

    public String getCNumeroExt() {
        return cNumeroExt;
    }

    public void setCNumeroExt(String cNumeroExt) {
        this.cNumeroExt = cNumeroExt;
    }

    public String getCNumeroInt() {
        return cNumeroInt;
    }

    public void setCNumeroInt(String cNumeroInt) {
        this.cNumeroInt = cNumeroInt;
    }

    public String getCColonia() {
        return cColonia;
    }

    public void setCColonia(String cColonia) {
        this.cColonia = cColonia;
    }

    public String getCMpioDeleg() {
        return cMpioDeleg;
    }

    public void setCMpioDeleg(String cMpioDeleg) {
        this.cMpioDeleg = cMpioDeleg;
    }

    public String getCEstado() {
        return cEstado;
    }

    public void setCEstado(String cEstado) {
        this.cEstado = cEstado;
    }

    public String getCCP() {
        return cCP;
    }

    public void setCCP(String cCP) {
        this.cCP = cCP;
    }

    public String getCPais() {
        return cPais;
    }

    public void setCPais(String cPais) {
        this.cPais = cPais;
    }

    public String getCReferencia() {
        return cReferencia;
    }

    public void setCReferencia(String cReferencia) {
        this.cReferencia = cReferencia;
    }

    public String getCObs() {
        return cObs;
    }

    public void setCObs(String cObs) {
        this.cObs = cObs;
    }

    public String getDeLongitud() {
        return deLongitud;
    }

    public void setDeLongitud(String deLongitud) {
        this.deLongitud = deLongitud;
    }

    public String getDeLatitud() {
        return deLatitud;
    }

    public void setDeLatitud(String deLatitud) {
        this.deLatitud = deLatitud;
    }

    public Boolean getLActivo() {
        return lActivo;
    }

    public void setLActivo(Boolean lActivo) {
        this.lActivo = lActivo;
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

    public String getCUsuModifca() {
        return cUsuModifca;
    }

    public void setCUsuModifca(String cUsuModifca) {
        this.cUsuModifca = cUsuModifca;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TtCtDomicilio{");
        sb.append("iPersona='").append(iPersona).append('\'');
        sb.append(", iDomicilio='").append(iDomicilio).append('\'');
        sb.append(", iTipoPersona='").append(iTipoPersona).append('\'');
        sb.append(", itipoDomicilio='").append(itipoDomicilio).append('\'');
        sb.append(", cCalle='").append(cCalle).append('\'');
        sb.append(", cNumeroExt='").append(cNumeroExt).append('\'');
        sb.append(", cNumeroInt='").append(cNumeroInt).append('\'');
        sb.append(", cColonia='").append(cColonia).append('\'');
        sb.append(", cMpioDeleg='").append(cMpioDeleg).append('\'');
        sb.append(", cEstado='").append(cEstado).append('\'');
        sb.append(", cCP='").append(cCP).append('\'');
        sb.append(", cPais='").append(cPais).append('\'');
        sb.append(", cReferencia='").append(cReferencia).append('\'');
        sb.append(", cObs='").append(cObs).append('\'');
        sb.append(", deLongitud='").append(deLongitud).append('\'');
        sb.append(", deLatitud='").append(deLatitud).append('\'');
        sb.append(", lActivo=").append(lActivo);
        sb.append(", dtCreado='").append(dtCreado).append('\'');
        sb.append(", dtModificado='").append(dtModificado).append('\'');
        sb.append(", cUsuCrea='").append(cUsuCrea).append('\'');
        sb.append(", cUsuModifca='").append(cUsuModifca).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
