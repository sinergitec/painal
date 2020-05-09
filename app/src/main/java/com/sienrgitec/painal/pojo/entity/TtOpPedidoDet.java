package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TtOpPedidoDet implements Serializable {

    @SerializedName("iPedido")
    @Expose
    private String iPedido;
    @SerializedName("iPartida")
    @Expose
    private String iPartida;
    @SerializedName("iPedidoProv")
    @Expose
    private String iPedidoProv;
    @SerializedName("dtFecha")
    @Expose
    private String dtFecha;
    @SerializedName("iArticulo")
    @Expose
    private String iArticulo;
    @SerializedName("cArticulo")
    @Expose
    private String cArticulo;
    @SerializedName("cDescricpcion")
    @Expose
    private String cDescricpcion;
    @SerializedName("cObs")
    @Expose
    private String cObs;
    @SerializedName("lPesado")
    @Expose
    private String lPesado;
    @SerializedName("dePrecio")
    @Expose
    private String dePrecio;
    @SerializedName("dePorcImp")
    @Expose
    private String dePorcImp;
    @SerializedName("deImpuesto")
    @Expose
    private String deImpuesto;
    @SerializedName("dePrecVta")
    @Expose
    private String dePrecVta;
    @SerializedName("dePorcDescto")
    @Expose
    private String dePorcDescto;
    @SerializedName("deDescuento")
    @Expose
    private String deDescuento;
    @SerializedName("dePrecioUnit")
    @Expose
    private String dePrecioUnit;
    @SerializedName("deCantidad")
    @Expose
    private String deCantidad;
    @SerializedName("deImporte")
    @Expose
    private String deImporte;
    @SerializedName("deCantCancela")
    @Expose
    private String deCantCancela;
    @SerializedName("dtCancela")
    @Expose
    private String dtCancela;
    @SerializedName("deCancela")
    @Expose
    private String deCancela;
    @SerializedName("iRazon")
    @Expose
    private String iRazon;
    @SerializedName("cTipoRazon")
    @Expose
    private String cTipoRazon;
    @SerializedName("dtCreado")
    @Expose
    private String dtCreado;
    @SerializedName("dtModificado")
    @Expose
    private String dtModificado;
    @SerializedName("cUsuCra")
    @Expose
    private String cUsuCra;
    @SerializedName("cUsuMofica")
    @Expose
    private String cUsuMofica;

    public TtOpPedidoDet(){

    }

    public TtOpPedidoDet(String iPedido, String iPartida, String iPedidoProv, String dtFecha, String iArticulo, String cArticulo, String cDescricpcion, String cObs, String lPesado, String dePrecio, String dePorcImp, String deImpuesto, String dePrecVta, String dePorcDescto, String deDescuento, String dePrecioUnit, String deCantidad, String deImporte, String deCantCancela, String dtCancela, String deCancela, String iRazon, String cTipoRazon, String dtCreado, String dtModificado, String cUsuCra, String cUsuMofica) {
        this.iPedido = iPedido;
        this.iPartida = iPartida;
        this.iPedidoProv = iPedidoProv;
        this.dtFecha = dtFecha;
        this.iArticulo = iArticulo;
        this.cArticulo = cArticulo;
        this.cDescricpcion = cDescricpcion;
        this.cObs = cObs;
        this.lPesado = lPesado;
        this.dePrecio = dePrecio;
        this.dePorcImp = dePorcImp;
        this.deImpuesto = deImpuesto;
        this.dePrecVta = dePrecVta;
        this.dePorcDescto = dePorcDescto;
        this.deDescuento = deDescuento;
        this.dePrecioUnit = dePrecioUnit;
        this.deCantidad = deCantidad;
        this.deImporte = deImporte;
        this.deCantCancela = deCantCancela;
        this.dtCancela = dtCancela;
        this.deCancela = deCancela;
        this.iRazon = iRazon;
        this.cTipoRazon = cTipoRazon;
        this.dtCreado = dtCreado;
        this.dtModificado = dtModificado;
        this.cUsuCra = cUsuCra;
        this.cUsuMofica = cUsuMofica;
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

    public String getIPedidoProv() {
        return iPedidoProv;
    }

    public void setIPedidoProv(String iPedidoProv) {
        this.iPedidoProv = iPedidoProv;
    }

    public String getDtFecha() {
        return dtFecha;
    }

    public void setDtFecha(String dtFecha) {
        this.dtFecha = dtFecha;
    }

    public String getIArticulo() {
        return iArticulo;
    }

    public void setIArticulo(String iArticulo) {
        this.iArticulo = iArticulo;
    }

    public String getCArticulo() {
        return cArticulo;
    }

    public void setCArticulo(String cArticulo) {
        this.cArticulo = cArticulo;
    }

    public String getCDescricpcion() {
        return cDescricpcion;
    }

    public void setCDescricpcion(String cDescricpcion) {
        this.cDescricpcion = cDescricpcion;
    }

    public String getCObs() {
        return cObs;
    }

    public void setCObs(String cObs) {
        this.cObs = cObs;
    }

    public String getLPesado() {
        return lPesado;
    }

    public void setLPesado(String lPesado) {
        this.lPesado = lPesado;
    }

    public String getDePrecio() {
        return dePrecio;
    }

    public void setDePrecio(String dePrecio) {
        this.dePrecio = dePrecio;
    }

    public String getDePorcImp() {
        return dePorcImp;
    }

    public void setDePorcImp(String dePorcImp) {
        this.dePorcImp = dePorcImp;
    }

    public String getDeImpuesto() {
        return deImpuesto;
    }

    public void setDeImpuesto(String deImpuesto) {
        this.deImpuesto = deImpuesto;
    }

    public String getDePrecVta() {
        return dePrecVta;
    }

    public void setDePrecVta(String dePrecVta) {
        this.dePrecVta = dePrecVta;
    }

    public String getDePorcDescto() {
        return dePorcDescto;
    }

    public void setDePorcDescto(String dePorcDescto) {
        this.dePorcDescto = dePorcDescto;
    }

    public String getDeDescuento() {
        return deDescuento;
    }

    public void setDeDescuento(String deDescuento) {
        this.deDescuento = deDescuento;
    }

    public String getDePrecioUnit() {
        return dePrecioUnit;
    }

    public void setDePrecioUnit(String dePrecioUnit) {
        this.dePrecioUnit = dePrecioUnit;
    }

    public String getDeCantidad() {
        return deCantidad;
    }

    public void setDeCantidad(String deCantidad) {
        this.deCantidad = deCantidad;
    }

    public String getDeImporte() {
        return deImporte;
    }

    public void setDeImporte(String deImporte) {
        this.deImporte = deImporte;
    }

    public String getDeCantCancela() {
        return deCantCancela;
    }

    public void setDeCantCancela(String deCantCancela) {
        this.deCantCancela = deCantCancela;
    }

    public String getDtCancela() {
        return dtCancela;
    }

    public void setDtCancela(String dtCancela) {
        this.dtCancela = dtCancela;
    }

    public String getDeCancela() {
        return deCancela;
    }

    public void setDeCancela(String deCancela) {
        this.deCancela = deCancela;
    }

    public String getIRazon() {
        return iRazon;
    }

    public void setIRazon(String iRazon) {
        this.iRazon = iRazon;
    }

    public String getCTipoRazon() {
        return cTipoRazon;
    }

    public void setCTipoRazon(String cTipoRazon) {
        this.cTipoRazon = cTipoRazon;
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

    public String getCUsuCra() {
        return cUsuCra;
    }

    public void setCUsuCra(String cUsuCra) {
        this.cUsuCra = cUsuCra;
    }

    public String getCUsuMofica() {
        return cUsuMofica;
    }

    public void setCUsuMofica(String cUsuMofica) {
        this.cUsuMofica = cUsuMofica;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TtOpPedidoDet{");
        sb.append("iPedido='").append(iPedido).append('\'');
        sb.append(", iPartida='").append(iPartida).append('\'');
        sb.append(", iPedidoProv='").append(iPedidoProv).append('\'');
        sb.append(", dtFecha='").append(dtFecha).append('\'');
        sb.append(", iArticulo='").append(iArticulo).append('\'');
        sb.append(", cArticulo='").append(cArticulo).append('\'');
        sb.append(", cDescricpcion='").append(cDescricpcion).append('\'');
        sb.append(", cObs='").append(cObs).append('\'');
        sb.append(", lPesado='").append(lPesado).append('\'');
        sb.append(", dePrecio='").append(dePrecio).append('\'');
        sb.append(", dePorcImp='").append(dePorcImp).append('\'');
        sb.append(", deImpuesto='").append(deImpuesto).append('\'');
        sb.append(", dePrecVta='").append(dePrecVta).append('\'');
        sb.append(", dePorcDescto='").append(dePorcDescto).append('\'');
        sb.append(", deDescuento='").append(deDescuento).append('\'');
        sb.append(", dePrecioUnit='").append(dePrecioUnit).append('\'');
        sb.append(", deCantidad='").append(deCantidad).append('\'');
        sb.append(", deImporte='").append(deImporte).append('\'');
        sb.append(", deCantCancela='").append(deCantCancela).append('\'');
        sb.append(", dtCancela='").append(dtCancela).append('\'');
        sb.append(", deCancela='").append(deCancela).append('\'');
        sb.append(", iRazon='").append(iRazon).append('\'');
        sb.append(", cTipoRazon='").append(cTipoRazon).append('\'');
        sb.append(", dtCreado='").append(dtCreado).append('\'');
        sb.append(", dtModificado='").append(dtModificado).append('\'');
        sb.append(", cUsuCra='").append(cUsuCra).append('\'');
        sb.append(", cUsuMofica='").append(cUsuMofica).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
