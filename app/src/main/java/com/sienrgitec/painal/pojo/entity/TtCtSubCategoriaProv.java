package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TtCtSubCategoriaProv {
    @SerializedName("iProveedor")
    @Expose
    private Integer iProveedor;
    @SerializedName("iCategoria")
    @Expose
    private Integer iCategoria;
    @SerializedName("iSubCategoria")
    @Expose
    private Integer iSubCategoria;
    @SerializedName("cSubCategoria")
    @Expose
    private String cSubCategoria;
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

    public Integer getIProveedor() {
        return iProveedor;
    }

    public void setIProveedor(Integer iProveedor) {
        this.iProveedor = iProveedor;
    }

    public Integer getICategoria() {
        return iCategoria;
    }

    public void setICategoria(Integer iCategoria) {
        this.iCategoria = iCategoria;
    }

    public Integer getISubCategoria() {
        return iSubCategoria;
    }

    public void setISubCategoria(Integer iSubCategoria) {
        this.iSubCategoria = iSubCategoria;
    }

    public String getCSubCategoria() {
        return cSubCategoria;
    }

    public void setCSubCategoria(String cSubCategoria) {
        this.cSubCategoria = cSubCategoria;
    }

    public Boolean getLActivo() {
        return lActivo;
    }

    public void setLActivo(Boolean lActivo) {
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
        final StringBuilder sb = new StringBuilder("TtCtSubCategoriaProv{");
        sb.append("iProveedor=").append(iProveedor);
        sb.append(", iCategoria=").append(iCategoria);
        sb.append(", iSubCategoria=").append(iSubCategoria);
        sb.append(", cSubCategoria='").append(cSubCategoria).append('\'');
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
