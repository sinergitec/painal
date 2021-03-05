package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TtCtCategoriaProv_ implements Serializable {

    @SerializedName("iProveedor")
    @Expose
    private Integer iProveedor;
    @SerializedName("iCategoria")
    @Expose
    private Integer iCategoria;
    @SerializedName("cCategoria")
    @Expose
    private String cCategoria;
    @SerializedName("lActivo")
    @Expose
    private Boolean lActivo;
    @SerializedName("dtCreado")
    @Expose
    private Object dtCreado;
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

    @SerializedName("cFoto")
    @Expose
    private Object cFoto;

    @SerializedName("cRutaImg")
    @Expose
    private Object cRutaImg;


    public Object getcRutaImg() {
        return cRutaImg;
    }

    public void setcRutaImg(Object cRutaImg) {
        this.cRutaImg = cRutaImg;
    }

    public Object getcFoto() {
        return cFoto;
    }

    public void setcFoto(Object cFoto) {
        this.cFoto = cFoto;
    }

    public Integer getiProveedor() {
        return iProveedor;
    }

    public void setiProveedor(Integer iProveedor) {
        this.iProveedor = iProveedor;
    }

    public Integer getiCategoria() {
        return iCategoria;
    }

    public void setiCategoria(Integer iCategoria) {
        this.iCategoria = iCategoria;
    }

    public String getcCategoria() {
        return cCategoria;
    }

    public void setcCategoria(String cCategoria) {
        this.cCategoria = cCategoria;
    }

    public Boolean getlActivo() {
        return lActivo;
    }

    public void setlActivo(Boolean lActivo) {
        this.lActivo = lActivo;
    }

    public Object getDtCreado() {
        return dtCreado;
    }

    public void setDtCreado(Object dtCreado) {
        this.dtCreado = dtCreado;
    }

    public Object getDtModificado() {
        return dtModificado;
    }

    public void setDtModificado(Object dtModificado) {
        this.dtModificado = dtModificado;
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

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TtCtCategoriaProv_{");
        sb.append("iProveedor=").append(iProveedor);
        sb.append(", iCategoria=").append(iCategoria);
        sb.append(", cCategoria='").append(cCategoria).append('\'');
        sb.append(", lActivo=").append(lActivo);
        sb.append(", dtCreado=").append(dtCreado);
        sb.append(", dtModificado=").append(dtModificado);
        sb.append(", cUsuCrea='").append(cUsuCrea).append('\'');
        sb.append(", cUsuModifica='").append(cUsuModifica).append('\'');
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}
