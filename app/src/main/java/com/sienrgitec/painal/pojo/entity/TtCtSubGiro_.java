package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TtCtSubGiro_ {
    @SerializedName("iGiro")
    @Expose
    private Integer iGiro;
    @SerializedName("iSubGiro")
    @Expose
    private Integer iSubGiro;
    @SerializedName("cSubGiro")
    @Expose
    private String cSubGiro;
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
    @SerializedName("Id")
    @Expose
    private Object id;

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

    public String getCSubGiro() {
        return cSubGiro;
    }

    public void setCSubGiro(String cSubGiro) {
        this.cSubGiro = cSubGiro;
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
        final StringBuilder sb = new StringBuilder("TtCtSubGiro_{");
        sb.append("iGiro=").append(iGiro);
        sb.append(", iSubGiro=").append(iSubGiro);
        sb.append(", cSubGiro='").append(cSubGiro).append('\'');
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
