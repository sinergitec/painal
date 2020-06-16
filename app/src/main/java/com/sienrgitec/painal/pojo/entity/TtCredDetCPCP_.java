package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TtCredDetCPCP_ implements Serializable {

    @SerializedName("cBeneficiario")
    @Expose
    private String cBeneficiario;

    @SerializedName("cCuenta")
    @Expose
    private String cCuenta;

    @SerializedName("cMov")
    @Expose
    private String cMov;

    @SerializedName("cObs")
    @Expose
    private String cObs;

    @SerializedName("cReferencia")
    @Expose
    private String cReferencia;

    @SerializedName("cUsuAutoriza")
    @Expose
    private String cUsuAutoriza;

    @SerializedName("cUsuCrea")
    @Expose
    private String cUsuCrea;

    @SerializedName("cUsuModifica")
    @Expose
    private String cUsuModifica;


    @SerializedName("deMonto")
    @Expose
    private String deMonto;


    @SerializedName("dtAutorizado")
    @Expose
    private String dtAutorizado;


    @SerializedName("dtCreado")
    @Expose
    private String dtCreado;


    @SerializedName("dtFechaMov")
    @Expose
    private String dtFechaMov;

    @SerializedName("dtModificado")
    @Expose
    private String dtModificado;


    @SerializedName("iMov")
    @Expose
    private Integer iMov;


    @SerializedName("lAutorizado")
    @Expose
    private Boolean lAutorizado;


    @SerializedName("id")
    @Expose
    private Object id;


    /*public TtCredDetCPCP_ (){

    }
    public TtCredDetCPCP_(String cCuenta, Integer iMov, String dtFechaMov, String cMov, String deMonto, String cReferencia,
                          String cObs, String cBeneficiario, Boolean lAutorizado, String dtAutorizado, String dtCreado, String dtModificado,
                          String cUsuCrea, String cUsuModifica){

        this.cCuenta = cCuenta;
        this.iMov = iMov;
        this.dtFechaMov = dtFechaMov;
        this.cMov = cMov;
        this.deMonto = deMonto;
        this.cReferencia = cReferencia;
        this.cObs = cObs;
        this.cBeneficiario = cBeneficiario;
        this.lAutorizado = lAutorizado;
        this.dtAutorizado = dtAutorizado;
        this.dtCreado = dtCreado;
        this.dtModificado = dtModificado;
        this.cUsuCrea = cUsuCrea;
        this.cUsuModifica = cUsuModifica;

    }*/

    public String getcBeneficiario() {
        return cBeneficiario;
    }

    public void setcBeneficiario(String cBeneficiario) {
        this.cBeneficiario = cBeneficiario;
    }

    public String getcCuenta() {
        return cCuenta;
    }

    public void setcCuenta(String cCuenta) {
        this.cCuenta = cCuenta;
    }

    public String getcMov() {
        return cMov;
    }

    public void setcMov(String cMov) {
        this.cMov = cMov;
    }

    public String getcObs() {
        return cObs;
    }

    public void setcObs(String cObs) {
        this.cObs = cObs;
    }

    public String getcReferencia() {
        return cReferencia;
    }

    public void setcReferencia(String cReferencia) {
        this.cReferencia = cReferencia;
    }

    public String getcUsuAutoriza() {
        return cUsuAutoriza;
    }

    public void setcUsuAutoriza(String cUsuAutoriza) {
        this.cUsuAutoriza = cUsuAutoriza;
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

    public String getDeMonto() {
        return deMonto;
    }

    public void setDeMonto(String deMonto) {
        this.deMonto = deMonto;
    }

    public String getDtAutorizado() {
        return dtAutorizado;
    }

    public void setDtAutorizado(String dtAutorizado) {
        this.dtAutorizado = dtAutorizado;
    }

    public String getDtCreado() {
        return dtCreado;
    }

    public void setDtCreado(String dtCreado) {
        this.dtCreado = dtCreado;
    }

    public String getDtFechaMov() {
        return dtFechaMov;
    }

    public void setDtFechaMov(String dtFechaMov) {
        this.dtFechaMov = dtFechaMov;
    }

    public String getDtModificado() {
        return dtModificado;
    }

    public void setDtModificado(String dtModificado) {
        this.dtModificado = dtModificado;
    }

    public Integer getiMov() {
        return iMov;
    }

    public void setiMov(Integer iMov) {
        this.iMov = iMov;
    }

    public Boolean getlAutorizado() {
        return lAutorizado;
    }

    public void setlAutorizado(Boolean lAutorizado) {
        this.lAutorizado = lAutorizado;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    /*@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TtCredDetCPCP{");
        sb.append("iPedido='").append(iPedido).append('\'');
        sb.append(", iPartida='").append(iPartida).append('\'');
        sb.append(", iFormaPago='").append(iFormaPago).append('\'');
        sb.append(", deMonto='").append(deMonto).append('\'');
        sb.append(", deProcComision='").append(deProcComision).append('\'');
        sb.append(", deComision='").append(deComision).append('\'');
        sb.append(", dePorcPropina='").append(dePorcPropina).append('\'');
        sb.append(", dtCreado='").append(dtCreado).append('\'');
        sb.append(", dtModificado='").append(dtModificado).append('\'');
        sb.append(", cUsuario='").append(cUsuario).append('\'');
        sb.append(", iCliente='").append(iCliente).append('\'');
        sb.append(", iOrigenFP='").append(iOrigenFP).append('\'');
        sb.append(", cCuenta='").append(cCuenta).append('\'');
        sb.append(", dePropina='").append(dePropina).append('\'');
        sb.append('}');
        return sb.toString();
    }*/


}
