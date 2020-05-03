package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TtCtArtProveedor_ implements Serializable {

    @SerializedName("iProveedor")
    @Expose
    private Integer iProveedor;
    @SerializedName("iArticulo")
    @Expose
    private Integer iArticulo;
    @SerializedName("cArticulo")
    @Expose
    private String cArticulo;
    @SerializedName("cAplicaciones")
    @Expose
    private String cAplicaciones;
    @SerializedName("cPresentacion")
    @Expose
    private String cPresentacion;
    @SerializedName("cDescripcion")
    @Expose
    private String cDescripcion;
    @SerializedName("iImpuesto")
    @Expose
    private Integer iImpuesto;
    @SerializedName("iCategoria")
    @Expose
    private Integer iCategoria;
    @SerializedName("iSubCategoria")
    @Expose
    private Integer iSubCategoria;
    @SerializedName("iClasificacion")
    @Expose
    private Integer iClasificacion;
    @SerializedName("iSubClasificacion")
    @Expose
    private Integer iSubClasificacion;
    @SerializedName("iMarca")
    @Expose
    private Integer iMarca;
    @SerializedName("lActivo")
    @Expose
    private Boolean lActivo;
    @SerializedName("bImagen")
    @Expose
    private Object bImagen;
    @SerializedName("dePeso")
    @Expose
    private Double dePeso;
    @SerializedName("deLargo")
    @Expose
    private Boolean deLargo;
    @SerializedName("deAncho")
    @Expose
    private Double deAncho;
    @SerializedName("deProfundo")
    @Expose
    private Double deProfundo;
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
    @SerializedName("dePrecioVta")
    @Expose
    private Double dePrecioVta;
    @SerializedName("Id")
    @Expose
    private Object id;

    public Integer getIProveedor() {
        return iProveedor;
    }

    public void setIProveedor(Integer iProveedor) {
        this.iProveedor = iProveedor;
    }

    public Integer getIArticulo() {
        return iArticulo;
    }

    public void setIArticulo(Integer iArticulo) {
        this.iArticulo = iArticulo;
    }

    public String getCArticulo() {
        return cArticulo;
    }

    public void setCArticulo(String cArticulo) {
        this.cArticulo = cArticulo;
    }

    public String getCAplicaciones() {
        return cAplicaciones;
    }

    public void setCAplicaciones(String cAplicaciones) {
        this.cAplicaciones = cAplicaciones;
    }

    public String getCPresentacion() {
        return cPresentacion;
    }

    public void setCPresentacion(String cPresentacion) {
        this.cPresentacion = cPresentacion;
    }

    public String getCDescripcion() {
        return cDescripcion;
    }

    public void setCDescripcion(String cDescripcion) {
        this.cDescripcion = cDescripcion;
    }

    public Integer getIImpuesto() {
        return iImpuesto;
    }

    public void setIImpuesto(Integer iImpuesto) {
        this.iImpuesto = iImpuesto;
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

    public Integer getIClasificacion() {
        return iClasificacion;
    }

    public void setIClasificacion(Integer iClasificacion) {
        this.iClasificacion = iClasificacion;
    }

    public Integer getISubClasificacion() {
        return iSubClasificacion;
    }

    public void setISubClasificacion(Integer iSubClasificacion) {
        this.iSubClasificacion = iSubClasificacion;
    }

    public Integer getIMarca() {
        return iMarca;
    }

    public void setIMarca(Integer iMarca) {
        this.iMarca = iMarca;
    }

    public Boolean getLActivo() {
        return lActivo;
    }

    public void setLActivo(Boolean lActivo) {
        this.lActivo = lActivo;
    }

    public Object getBImagen() {
        return bImagen;
    }

    public void setBImagen(Object bImagen) {
        this.bImagen = bImagen;
    }

    public Double getDePeso() {
        return dePeso;
    }

    public void setDePeso(Double dePeso) {
        this.dePeso = dePeso;
    }

    public Boolean getDeLargo() {
        return deLargo;
    }

    public void setDeLargo(Boolean deLargo) {
        this.deLargo = deLargo;
    }

    public Double getDeAncho() {
        return deAncho;
    }

    public void setDeAncho(Double deAncho) {
        this.deAncho = deAncho;
    }

    public Double getDeProfundo() {
        return deProfundo;
    }

    public void setDeProfundo(Double deProfundo) {
        this.deProfundo = deProfundo;
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

    public Double getDePrecioVta() {
        return dePrecioVta;
    }

    public void setDePrecioVta(Double dePrecioVta) {
        this.dePrecioVta = dePrecioVta;
    }

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TtCtArtProveedor_{");
        sb.append("iProveedor=").append(iProveedor);
        sb.append(", iArticulo=").append(iArticulo);
        sb.append(", cArticulo='").append(cArticulo).append('\'');
        sb.append(", cAplicaciones='").append(cAplicaciones).append('\'');
        sb.append(", cPresentacion='").append(cPresentacion).append('\'');
        sb.append(", cDescripcion='").append(cDescripcion).append('\'');
        sb.append(", iImpuesto=").append(iImpuesto);
        sb.append(", iCategoria=").append(iCategoria);
        sb.append(", iSubCategoria=").append(iSubCategoria);
        sb.append(", iClasificacion=").append(iClasificacion);
        sb.append(", iSubClasificacion=").append(iSubClasificacion);
        sb.append(", iMarca=").append(iMarca);
        sb.append(", lActivo=").append(lActivo);
        sb.append(", bImagen=").append(bImagen);
        sb.append(", dePeso=").append(dePeso);
        sb.append(", deLargo=").append(deLargo);
        sb.append(", deAncho=").append(deAncho);
        sb.append(", deProfundo=").append(deProfundo);
        sb.append(", dtCreado='").append(dtCreado).append('\'');
        sb.append(", dtModificado='").append(dtModificado).append('\'');
        sb.append(", cUsuCrea='").append(cUsuCrea).append('\'');
        sb.append(", cUsuModifica='").append(cUsuModifica).append('\'');
        sb.append(", dePrecioVta=").append(dePrecioVta);
        sb.append(", id=").append(id);
        sb.append('}');
        return sb.toString();
    }
}

