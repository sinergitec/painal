package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TtOpPedidoProveedor implements Serializable {
    @SerializedName("iPedido")
    @Expose
    private String iPedido;
    @SerializedName("iPedidoProv")
    @Expose
    private String iPedidoProv;
    @SerializedName("iProveedor")
    @Expose
    private String iProveedor;
    @SerializedName("dtFecha")
    @Expose
    private String dtFecha;
    @SerializedName("iHora")
    @Expose
    private String iHora;
    @SerializedName("iDomicilio")
    @Expose
    private String iDomicilio;
    @SerializedName("deTotalPzas")
    @Expose
    private String deTotalPzas;
    @SerializedName("deSubtotal")
    @Expose
    private String deSubtotal;
    @SerializedName("deImpuesto")
    @Expose
    private String deImpuesto;
    @SerializedName("deImporte")
    @Expose
    private String deImporte;
    @SerializedName("dtAvisado")
    @Expose
    private String dtAvisado;
    @SerializedName("lContestado")
    @Expose
    private String lContestado;
    @SerializedName("lPagado")
    @Expose
    private String lPagado;
    @SerializedName("dtPagado")
    @Expose
    private String dtPagado;
    @SerializedName("lVoBoPago")
    @Expose
    private String lVoBoPago;
    @SerializedName("deAporta")
    @Expose
    private String deAporta;
    @SerializedName("dePenalizacion")
    @Expose
    private String dePenalizacion;
    @SerializedName("dePagoNeto")
    @Expose
    private String dePagoNeto;
    @SerializedName("lCancelado")
    @Expose
    private String lCancelado;
    @SerializedName("dtCancelado")
    @Expose
    private String dtCancelado;
    @SerializedName("iRazon")
    @Expose
    private String iRazon;
    @SerializedName("lEntregado")
    @Expose
    private String lEntregado;
    @SerializedName("dtSurtido")
    @Expose
    private String dtSurtido;
    @SerializedName("dePesoTotal")
    @Expose
    private String dePesoTotal;
    @SerializedName("deVolumenPed")
    @Expose
    private String deVolumenPed;
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

    @SerializedName("dePorcCargo")
    @Expose
    private String dePorcCargo;

    @SerializedName("deCargoPago")
    @Expose
    private String deCargoPago;

    @Expose
    private String lSurtido;

    public TtOpPedidoProveedor (){

    }

    public String getDePorcCargo() {
        return dePorcCargo;
    }

    public void setDePorcCargo(String dePorcCargo) {
        this.dePorcCargo = dePorcCargo;
    }

    public String getDeCargoPago() {
        return deCargoPago;
    }

    public void setDeCargoPago(String deCargoPago) {
        this.deCargoPago = deCargoPago;
    }

    public TtOpPedidoProveedor(String iPedido, String iPedidoProv, String iProveedor, String dtFecha, String iHora, String iDomicilio, String deTotalPzas, String deSubtotal, String deImpuesto, String deImporte, String dtAvisado, String lContestado, String lPagado, String dtPagado, String lVoBoPago, String deAporta, String dePenalizacion, String dePagoNeto, String lCancelado, String dtCancelado, String iRazon, String lEntregado, String dtSurtido, String dePesoTotal, String deVolumenPed,
                               String dtCreado, String dtModificado, String cUsuCrea, String cUsuModifica, String dePorcCargo, String deCargoPago) {
        this.iPedido = iPedido;
        this.iPedidoProv = iPedidoProv;
        this.iProveedor = iProveedor;
        this.dtFecha = dtFecha;
        this.iHora = iHora;
        this.iDomicilio = iDomicilio;
        this.deTotalPzas = deTotalPzas;
        this.deSubtotal = deSubtotal;
        this.deImpuesto = deImpuesto;
        this.deImporte = deImporte;
        this.dtAvisado = dtAvisado;
        this.lContestado = lContestado;
        this.lPagado = lPagado;
        this.dtPagado = dtPagado;
        this.lVoBoPago = lVoBoPago;
        this.deAporta = deAporta;
        this.dePenalizacion = dePenalizacion;
        this.dePagoNeto = dePagoNeto;
        this.lCancelado = lCancelado;
        this.dtCancelado = dtCancelado;
        this.iRazon = iRazon;
        this.lEntregado = lEntregado;
        this.dtSurtido = dtSurtido;
        this.dePesoTotal = dePesoTotal;
        this.deVolumenPed = deVolumenPed;
        this.dtCreado = dtCreado;
        this.dtModificado = dtModificado;
        this.cUsuCrea = cUsuCrea;
        this.cUsuModifica = cUsuModifica;
        this.lSurtido = lSurtido;
        this.dePorcCargo = dePorcCargo;
        this.deCargoPago = deCargoPago;
    }

    public String getIPedido() {
        return iPedido;
    }

    public void setIPedido(String iPedido) {
        this.iPedido = iPedido;
    }

    public String getIPedidoProv() {
        return iPedidoProv;
    }

    public void setIPedidoProv(String iPedidoProv) {
        this.iPedidoProv = iPedidoProv;
    }

    public String getIProveedor() {
        return iProveedor;
    }

    public void setIProveedor(String iProveedor) {
        this.iProveedor = iProveedor;
    }

    public String getDtFecha() {
        return dtFecha;
    }

    public void setDtFecha(String dtFecha) {
        this.dtFecha = dtFecha;
    }

    public String getIHora() {
        return iHora;
    }

    public void setIHora(String iHora) {
        this.iHora = iHora;
    }

    public String getIDomicilio() {
        return iDomicilio;
    }

    public void setIDomicilio(String iDomicilio) {
        this.iDomicilio = iDomicilio;
    }

    public String getDeTotalPzas() {
        return deTotalPzas;
    }

    public void setDeTotalPzas(String deTotalPzas) {
        this.deTotalPzas = deTotalPzas;
    }

    public String getDeSubtotal() {
        return deSubtotal;
    }

    public void setDeSubtotal(String deSubtotal) {
        this.deSubtotal = deSubtotal;
    }

    public String getDeImpuesto() {
        return deImpuesto;
    }

    public void setDeImpuesto(String deImpuesto) {
        this.deImpuesto = deImpuesto;
    }

    public String getDeImporte() {
        return deImporte;
    }

    public void setDeImporte(String deImporte) {
        this.deImporte = deImporte;
    }

    public String getDtAvisado() {
        return dtAvisado;
    }

    public void setDtAvisado(String dtAvisado) {
        this.dtAvisado = dtAvisado;
    }

    public String getLContestado() {
        return lContestado;
    }

    public void setLContestado(String lContestado) {
        this.lContestado = lContestado;
    }

    public String getLPagado() {
        return lPagado;
    }

    public void setLPagado(String lPagado) {
        this.lPagado = lPagado;
    }

    public String getDtPagado() {
        return dtPagado;
    }

    public void setDtPagado(String dtPagado) {
        this.dtPagado = dtPagado;
    }

    public String getLVoBoPago() {
        return lVoBoPago;
    }

    public void setLVoBoPago(String lVoBoPago) {
        this.lVoBoPago = lVoBoPago;
    }

    public String getDeAporta() {
        return deAporta;
    }

    public void setDeAporta(String deAporta) {
        this.deAporta = deAporta;
    }

    public String getDePenalizacion() {
        return dePenalizacion;
    }

    public void setDePenalizacion(String dePenalizacion) {
        this.dePenalizacion = dePenalizacion;
    }

    public String getDePagoNeto() {
        return dePagoNeto;
    }

    public void setDePagoNeto(String dePagoNeto) {
        this.dePagoNeto = dePagoNeto;
    }

    public String getLCancelado() {
        return lCancelado;
    }

    public void setLCancelado(String lCancelado) {
        this.lCancelado = lCancelado;
    }

    public String getDtCancelado() {
        return dtCancelado;
    }

    public void setDtCancelado(String dtCancelado) {
        this.dtCancelado = dtCancelado;
    }

    public String getIRazon() {
        return iRazon;
    }

    public void setIRazon(String iRazon) {
        this.iRazon = iRazon;
    }

    public String getLEntregado() {
        return lEntregado;
    }

    public void setLEntregado(String lEntregado) {
        this.lEntregado = lEntregado;
    }

    public String getDtSurtido() {
        return dtSurtido;
    }

    public void setDtSurtido(String dtSurtido) {
        this.dtSurtido = dtSurtido;
    }

    public String getDePesoTotal() {
        return dePesoTotal;
    }

    public void setDePesoTotal(String dePesoTotal) {
        this.dePesoTotal = dePesoTotal;
    }

    public String getDeVolumenPed() {
        return deVolumenPed;
    }

    public void setDeVolumenPed(String deVolumenPed) {
        this.deVolumenPed = deVolumenPed;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TtOpPedidoProveedor{");
        sb.append("iPedido='").append(iPedido).append('\'');
        sb.append(", iPedidoProv='").append(iPedidoProv).append('\'');
        sb.append(", iProveedor='").append(iProveedor).append('\'');
        sb.append(", dtFecha='").append(dtFecha).append('\'');
        sb.append(", iHora='").append(iHora).append('\'');
        sb.append(", iDomicilio='").append(iDomicilio).append('\'');
        sb.append(", deTotalPzas='").append(deTotalPzas).append('\'');
        sb.append(", deSubtotal='").append(deSubtotal).append('\'');
        sb.append(", deImpuesto='").append(deImpuesto).append('\'');
        sb.append(", deImporte='").append(deImporte).append('\'');
        sb.append(", dtAvisado='").append(dtAvisado).append('\'');
        sb.append(", lContestado='").append(lContestado).append('\'');
        sb.append(", lPagado='").append(lPagado).append('\'');
        sb.append(", dtPagado='").append(dtPagado).append('\'');
        sb.append(", lVoBoPago='").append(lVoBoPago).append('\'');
        sb.append(", deAporta='").append(deAporta).append('\'');
        sb.append(", dePenalizacion='").append(dePenalizacion).append('\'');
        sb.append(", dePagoNeto='").append(dePagoNeto).append('\'');
        sb.append(", lCancelado='").append(lCancelado).append('\'');
        sb.append(", dtCancelado='").append(dtCancelado).append('\'');
        sb.append(", iRazon='").append(iRazon).append('\'');
        sb.append(", lEntregado='").append(lEntregado).append('\'');
        sb.append(", dtSurtido='").append(dtSurtido).append('\'');
        sb.append(", dePesoTotal='").append(dePesoTotal).append('\'');
        sb.append(", deVolumenPed='").append(deVolumenPed).append('\'');
        sb.append(", dtCreado='").append(dtCreado).append('\'');
        sb.append(", dtModificado='").append(dtModificado).append('\'');
        sb.append(", cUsuCrea='").append(cUsuCrea).append('\'');
        sb.append(", cUsuModifica='").append(cUsuModifica).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
