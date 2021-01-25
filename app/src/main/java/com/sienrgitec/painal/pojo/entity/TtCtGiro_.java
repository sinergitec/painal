package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TtCtGiro_ {
    @SerializedName("iGiro")
    @Expose
    private Integer iGiro;
    @SerializedName("cGiro")
    @Expose
    private String cGiro;
    @SerializedName("lActivo")
    @Expose
    private Boolean lActivo;
    @SerializedName("dtCreado")
    @Expose
    private String dtCreado;
    @SerializedName("dtModificado")
    @Expose
    private Object dtModificado;
    @SerializedName("cUsuCrea")
    @Expose
    private String cUsuCrea;
    @SerializedName("cUsuModifica")
    @Expose
    private String cUsuModifica;
    @SerializedName("cFoto")
    @Expose
    private String cFoto;
    @SerializedName("cRutaImg")
    @Expose
    private String cRutaImg;
    @SerializedName("Id")
    @Expose
    private Object id;


    public String getcFoto() {
        return cFoto;
    }

    public void setcFoto(String cFoto) {
        this.cFoto = cFoto;
    }

    public String getcRutaImg() {
        return cRutaImg;
    }

    public void setcRutaImg(String cRutaImg) {
        this.cRutaImg = cRutaImg;
    }

    public Integer getIGiro() {
        return iGiro;
    }

    public void setIGiro(Integer iGiro) {
        this.iGiro = iGiro;
    }

    public String getCGiro() {
        return cGiro;
    }

    public void setCGiro(String cGiro) {
        this.cGiro = cGiro;
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

    public Object getDtModificado() {
        return dtModificado;
    }

    public void setDtModificado(Object dtModificado) {
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TtCtGiro_{");
        sb.append("iGiro=").append(iGiro);
        sb.append(", cGiro='").append(cGiro).append('\'');
        sb.append(", lActivo=").append(lActivo);
        sb.append(", dtCreado='").append(dtCreado).append('\'');
        sb.append(", dtModificado=").append(dtModificado);
        sb.append(", cUsuCrea='").append(cUsuCrea).append('\'');
        sb.append(", cUsuModifica='").append(cUsuModifica).append('\'');
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
