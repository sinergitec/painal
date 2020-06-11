package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TtCtFormasPago_ {
    @SerializedName("cCvePago")
    @Expose
    private String cCvePago;

    @SerializedName("cFormaPago")
    @Expose
    private String cFormaPago;

    @SerializedName("cUsuCrea")
    @Expose
    private String cUsuCrea;

    @SerializedName("cUsuModifica")
    @Expose
    private String cUsuModifica;

    @SerializedName("dtCreado")
    @Expose
    private String dtCreado;

    @SerializedName("dtModificado")
    @Expose
    private String dtModificado;

    @SerializedName("iFormaPago")
    @Expose
    private Integer iFormaPago;

    @SerializedName("lActivo")
    @Expose
    private Boolean lActivo;

    private Object  id;


    public String getCvePago() {
        return cCvePago;
    }

    public void setCvePago(String cvePago) {
        cCvePago = cvePago;
    }

    public String getcFormaPago() {
        return cFormaPago;
    }

    public void setcFormaPago(String cFormaPago) {
        this.cFormaPago = cFormaPago;
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

    public Integer getiFormaPago() {
        return iFormaPago;
    }

    public void setiFormaPago(Integer iFormaPago) {
        this.iFormaPago = iFormaPago;
    }

    public Boolean getlActivo() {
        return lActivo;
    }

    public void setlActivo(Boolean lActivo) {
        this.lActivo = lActivo;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TtCtFormasPago{");
        sb.append("cCvePago=").append(cCvePago);
        sb.append("iFormaPago=").append(iFormaPago);
        sb.append(", cFormaPago='").append(cFormaPago).append('\'');
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
