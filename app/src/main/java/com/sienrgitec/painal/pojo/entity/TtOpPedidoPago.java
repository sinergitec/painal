package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TtOpPedidoPago implements Serializable {
    @SerializedName("iPedido")
    @Expose
    private String iPedido;
    @SerializedName("iPartida")
    @Expose
    private String iPartida;
    @SerializedName("iFormaPago")
    @Expose
    private String iFormaPago;
    @SerializedName("deMonto")
    @Expose
    private String deMonto;
    @SerializedName("deProcComision")
    @Expose
    private String deProcComision;
    @SerializedName("deComision")
    @Expose
    private String deComision;
    @SerializedName("dePorcPropina")
    @Expose
    private String dePorcPropina;
    @SerializedName("dtCreado")
    @Expose
    private String dtCreado;
    @SerializedName("dtModificado")
    @Expose
    private String dtModificado;

    @SerializedName("cUsuCrea")
    @Expose
    private String cUsuCrea;


    @SerializedName("iCliente")
    @Expose
    private String iCliente;
    @SerializedName("iOrigenFP")
    @Expose
    private String iOrigenFP;
    @SerializedName("cCuenta")
    @Expose
    private String cCuenta;

    @SerializedName("dePropina")
    @Expose
    private String dePropina;

    public TtOpPedidoPago (){

    }

    public TtOpPedidoPago(String iPedido, String iPartida, String iFormaPago, String deMonto, String deProcComision, String deComision, String dePorcPropina, String dtCreado, String dtModificado, String cUsuCrea, String iCliente, String iOrigenFP, String cCuenta, String dePropina) {
        this.iPedido = iPedido;
        this.iPartida = iPartida;
        this.iFormaPago = iFormaPago;
        this.deMonto = deMonto;
        this.deProcComision = deProcComision;
        this.deComision = deComision;
        this.dePorcPropina = dePorcPropina;
        this.dtCreado = dtCreado;
        this.dtModificado = dtModificado;
        this.cUsuCrea = cUsuCrea;
        this.iCliente = iCliente;
        this.iOrigenFP = iOrigenFP;
        this.cCuenta = cCuenta;
        this.dePropina = dePropina;
    }

    public String getIPedido() {
        return iPedido;
    }

    public void setIPedido(String iPedido) {
        this.iPedido = iPedido;
    }

    public String getIPartida() {
        return iPartida;
    }

    public void setIPartida(String iPartida) {
        this.iPartida = iPartida;
    }

    public String getIFormaPago() {
        return iFormaPago;
    }

    public void setIFormaPago(String iFormaPago) {
        this.iFormaPago = iFormaPago;
    }

    public String getDeMonto() {
        return deMonto;
    }

    public void setDeMonto(String deMonto) {
        this.deMonto = deMonto;
    }

    public String getDeProcComision() {
        return deProcComision;
    }

    public void setDeProcComision(String deProcComision) {
        this.deProcComision = deProcComision;
    }

    public String getDeComision() {
        return deComision;
    }

    public void setDeComision(String deComision) {
        this.deComision = deComision;
    }


    public String getDePropina() {
        return dePropina;
    }

    public void setDePropina(String dePropina) {
        this.dePropina = dePropina;
    }

    public String getDePorcPropina() {
        return dePorcPropina;
    }

    public void setDePorcPropina(String dePorcPropina) {
        this.dePorcPropina = dePorcPropina;
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

    public String getICliente() {
        return iCliente;
    }

    public void setICliente(String iCliente) {
        this.iCliente = iCliente;
    }

    public String getIOrigenFP() {
        return iOrigenFP;
    }

    public void setIOrigenFP(String iOrigenFP) {
        this.iOrigenFP = iOrigenFP;
    }

    public String getCCuenta() {
        return cCuenta;
    }

    public void setCCuenta(String cCuenta) {
        this.cCuenta = cCuenta;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TtOpPedidoPago{");
        sb.append("iPedido='").append(iPedido).append('\'');
        sb.append(", iPartida='").append(iPartida).append('\'');
        sb.append(", iFormaPago='").append(iFormaPago).append('\'');
        sb.append(", deMonto='").append(deMonto).append('\'');
        sb.append(", deProcComision='").append(deProcComision).append('\'');
        sb.append(", deComision='").append(deComision).append('\'');
        sb.append(", dePorcPropina='").append(dePorcPropina).append('\'');
        sb.append(", dtCreado='").append(dtCreado).append('\'');
        sb.append(", dtModificado='").append(dtModificado).append('\'');
        sb.append(", cUsuCrea='").append(cUsuCrea).append('\'');
        sb.append(", iCliente='").append(iCliente).append('\'');
        sb.append(", iOrigenFP='").append(iOrigenFP).append('\'');
        sb.append(", cCuenta='").append(cCuenta).append('\'');
        sb.append(", dePropina='").append(dePropina).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
