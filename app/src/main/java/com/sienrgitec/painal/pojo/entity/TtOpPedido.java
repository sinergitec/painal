package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TtOpPedido implements Serializable {

    @SerializedName("iPedido")
    @Expose
    private String iPedido;
    @SerializedName("iUnidad")
    @Expose
    private String iUnidad;
    @SerializedName("iCliente")
    @Expose
    private String iCliente;
    @SerializedName("dtFecha")
    @Expose
    private String dtFecha;
    @SerializedName("iEstadoPedido")
    @Expose
    private String iEstadoPedido;
    @SerializedName("iNegocios")
    @Expose
    private String iNegocios;
    @SerializedName("deTotalPiezas")
    @Expose
    private String deTotalPiezas;
    @SerializedName("deSubtotal")
    @Expose
    private String deSubtotal;
    @SerializedName("deDescuento")
    @Expose
    private String deDescuento;
    @SerializedName("deImpuesto")
    @Expose
    private String deImpuesto;
    @SerializedName("deImporte")
    @Expose
    private String deImporte;
    @SerializedName("dePorcComision")
    @Expose
    private String dePorcComision;
    @SerializedName("deComision")
    @Expose
    private String deComision;
    @SerializedName("dePorcPropina")
    @Expose
    private String dePorcPropina;
    @SerializedName("dePropina")
    @Expose
    private String dePropina;
    @SerializedName("dtRegistrado")
    @Expose
    private String dtRegistrado;
    @SerializedName("dtAsignado")
    @Expose
    private String dtAsignado;
    @SerializedName("dtEntregado")
    @Expose
    private String dtEntregado;
    @SerializedName("dtModificado")
    @Expose
    private String dtModificado;
    @SerializedName("cUsuCreado")
    @Expose
    private String cUsuCreado;
    @SerializedName("cUsuModificado")
    @Expose
    private String cUsuModificado;
    @SerializedName("cUsuCrea")
    @Expose
    private String cUsuCrea;
    @SerializedName("cUsuModifca")
    @Expose
    private String cUsuModifca;
    @SerializedName("deTiempoLlega")
    @Expose
    private String deTiempoLlega;

    public TtOpPedido(){

    }

    public TtOpPedido(String iPedido, String iUnidad, String iCliente, String dtFecha, String iEstadoPedido, String iNegocios, String deTotalPiezas, String deSubtotal, String deDescuento, String deImpuesto, String deImporte, String dePorcComision, String deComision, String dePorcPropina, String dePropina, String dtRegistrado, String dtAsignado, String dtEntregado, String dtModificado, String cUsuCreado, String cUsuModificado, String cUsuCrea, String cUsuModifca, String deTiempoLlega) {
        this.iPedido = iPedido;
        this.iUnidad = iUnidad;
        this.iCliente = iCliente;
        this.dtFecha = dtFecha;
        this.iEstadoPedido = iEstadoPedido;
        this.iNegocios = iNegocios;
        this.deTotalPiezas = deTotalPiezas;
        this.deSubtotal = deSubtotal;
        this.deDescuento = deDescuento;
        this.deImpuesto = deImpuesto;
        this.deImporte = deImporte;
        this.dePorcComision = dePorcComision;
        this.deComision = deComision;
        this.dePorcPropina = dePorcPropina;
        this.dePropina = dePropina;
        this.dtRegistrado = dtRegistrado;
        this.dtAsignado = dtAsignado;
        this.dtEntregado = dtEntregado;
        this.dtModificado = dtModificado;
        this.cUsuCreado = cUsuCreado;
        this.cUsuModificado = cUsuModificado;
        this.cUsuCrea = cUsuCrea;
        this.cUsuModifca = cUsuModifca;
        this.deTiempoLlega = deTiempoLlega;
    }

    public String getIPedido() {
        return iPedido;
    }

    public void setIPedido(String iPedido) {
        this.iPedido = iPedido;
    }

    public String getIUnidad() {
        return iUnidad;
    }

    public void setIUnidad(String iUnidad) {
        this.iUnidad = iUnidad;
    }

    public String getICliente() {
        return iCliente;
    }

    public void setICliente(String iCliente) {
        this.iCliente = iCliente;
    }

    public String getDtFecha() {
        return dtFecha;
    }

    public void setDtFecha(String dtFecha) {
        this.dtFecha = dtFecha;
    }

    public String getIEstadoPedido() {
        return iEstadoPedido;
    }

    public void setIEstadoPedido(String iEstadoPedido) {
        this.iEstadoPedido = iEstadoPedido;
    }

    public String getINegocios() {
        return iNegocios;
    }

    public void setINegocios(String iNegocios) {
        this.iNegocios = iNegocios;
    }

    public String getDeTotalPiezas() {
        return deTotalPiezas;
    }

    public void setDeTotalPiezas(String deTotalPiezas) {
        this.deTotalPiezas = deTotalPiezas;
    }

    public String getDeSubtotal() {
        return deSubtotal;
    }

    public void setDeSubtotal(String deSubtotal) {
        this.deSubtotal = deSubtotal;
    }

    public String getDeDescuento() {
        return deDescuento;
    }

    public void setDeDescuento(String deDescuento) {
        this.deDescuento = deDescuento;
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

    public String getDePorcComision() {
        return dePorcComision;
    }

    public void setDePorcComision(String dePorcComision) {
        this.dePorcComision = dePorcComision;
    }

    public String getDeComision() {
        return deComision;
    }

    public void setDeComision(String deComision) {
        this.deComision = deComision;
    }

    public String getDePorcPropina() {
        return dePorcPropina;
    }

    public void setDePorcPropina(String dePorcPropina) {
        this.dePorcPropina = dePorcPropina;
    }

    public String getDePropina() {
        return dePropina;
    }

    public void setDePropina(String dePropina) {
        this.dePropina = dePropina;
    }

    public String getDtRegistrado() {
        return dtRegistrado;
    }

    public void setDtRegistrado(String dtRegistrado) {
        this.dtRegistrado = dtRegistrado;
    }

    public String getDtAsignado() {
        return dtAsignado;
    }

    public void setDtAsignado(String dtAsignado) {
        this.dtAsignado = dtAsignado;
    }

    public String getDtEntregado() {
        return dtEntregado;
    }

    public void setDtEntregado(String dtEntregado) {
        this.dtEntregado = dtEntregado;
    }

    public String getDtModificado() {
        return dtModificado;
    }

    public void setDtModificado(String dtModificado) {
        this.dtModificado = dtModificado;
    }

    public String getCUsuCreado() {
        return cUsuCreado;
    }

    public void setCUsuCreado(String cUsuCreado) {
        this.cUsuCreado = cUsuCreado;
    }

    public String getCUsuModificado() {
        return cUsuModificado;
    }

    public void setCUsuModificado(String cUsuModificado) {
        this.cUsuModificado = cUsuModificado;
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

    public String getDeTiempoLlega() {
        return deTiempoLlega;
    }

    public void setDeTiempoLlega(String deTiempoLlega) {
        this.deTiempoLlega = deTiempoLlega;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TtOpPedido{");
        sb.append("iPedido='").append(iPedido).append('\'');
        sb.append(", iUnidad='").append(iUnidad).append('\'');
        sb.append(", iCliente='").append(iCliente).append('\'');
        sb.append(", dtFecha='").append(dtFecha).append('\'');
        sb.append(", iEstadoPedido='").append(iEstadoPedido).append('\'');
        sb.append(", iNegocios='").append(iNegocios).append('\'');
        sb.append(", deTotalPiezas='").append(deTotalPiezas).append('\'');
        sb.append(", deSubtotal='").append(deSubtotal).append('\'');
        sb.append(", deDescuento='").append(deDescuento).append('\'');
        sb.append(", deImpuesto='").append(deImpuesto).append('\'');
        sb.append(", deImporte='").append(deImporte).append('\'');
        sb.append(", dePorcComision='").append(dePorcComision).append('\'');
        sb.append(", deComision='").append(deComision).append('\'');
        sb.append(", dePorcPropina='").append(dePorcPropina).append('\'');
        sb.append(", dePropina='").append(dePropina).append('\'');
        sb.append(", dtRegistrado='").append(dtRegistrado).append('\'');
        sb.append(", dtAsignado='").append(dtAsignado).append('\'');
        sb.append(", dtEntregado='").append(dtEntregado).append('\'');
        sb.append(", dtModificado='").append(dtModificado).append('\'');
        sb.append(", cUsuCreado='").append(cUsuCreado).append('\'');
        sb.append(", cUsuModificado='").append(cUsuModificado).append('\'');
        sb.append(", cUsuCrea='").append(cUsuCrea).append('\'');
        sb.append(", cUsuModifca='").append(cUsuModifca).append('\'');
        sb.append(", deTiempoLlega='").append(deTiempoLlega).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
