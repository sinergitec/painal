package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TtOpPedidoDomicilio implements Serializable {

    @SerializedName("iPedido")
    @Expose
    private String iPedido;
    @SerializedName("iDomicilio")
    @Expose
    private String iDomicilio;
    @SerializedName("iCliente")
    @Expose
    private String iCliente;
    @SerializedName("lHabitual")
    @Expose
    private String lHabitual;
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

    public  TtOpPedidoDomicilio(){

    }

    public TtOpPedidoDomicilio(String iPedido, String iDomicilio, String iCliente, String lHabitual, String dtCreado, String dtModificado, String cUsuCrea, String cUsuModifca) {
        this.iPedido = iPedido;
        this.iDomicilio = iDomicilio;
        this.iCliente = iCliente;
        this.lHabitual = lHabitual;
        this.dtCreado = dtCreado;
        this.dtModificado = dtModificado;
        this.cUsuCrea = cUsuCrea;
        this.cUsuModifca = cUsuModifca;
    }

    public String getIPedido() {
        return iPedido;
    }

    public void setIPedido(String iPedido) {
        this.iPedido = iPedido;
    }

    public String getIDomicilio() {
        return iDomicilio;
    }

    public void setIDomicilio(String iDomicilio) {
        this.iDomicilio = iDomicilio;
    }

    public String getICliente() {
        return iCliente;
    }

    public void setICliente(String iCliente) {
        this.iCliente = iCliente;
    }

    public String getLHabitual() {
        return lHabitual;
    }

    public void setLHabitual(String lHabitual) {
        this.lHabitual = lHabitual;
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
        final StringBuilder sb = new StringBuilder("TtOpPedidoDomicilio{");
        sb.append("iPedido='").append(iPedido).append('\'');
        sb.append(", iDomicilio='").append(iDomicilio).append('\'');
        sb.append(", iCliente='").append(iCliente).append('\'');
        sb.append(", lHabitual='").append(lHabitual).append('\'');
        sb.append(", dtCreado='").append(dtCreado).append('\'');
        sb.append(", dtModificado='").append(dtModificado).append('\'');
        sb.append(", cUsuCrea='").append(cUsuCrea).append('\'');
        sb.append(", cUsuModifca='").append(cUsuModifca).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
