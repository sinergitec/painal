package com.sienrgitec.painal.pojo.respuesta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sienrgitec.painal.pojo.entity.TtCtArtProveedor;
import com.sienrgitec.painal.pojo.entity.TtCtCategoriaProv;
import com.sienrgitec.painal.pojo.entity.TtCtCliente;
import com.sienrgitec.painal.pojo.entity.TtCtGiro;
import com.sienrgitec.painal.pojo.entity.TtCtProveedor;
import com.sienrgitec.painal.pojo.entity.TtCtSubCategoria;
import com.sienrgitec.painal.pojo.entity.TtCtSubGiro;
import com.sienrgitec.painal.pojo.entity.TtCtTelefono;
import com.sienrgitec.painal.pojo.entity.TtCtUsuario;

public class Response {

    @SerializedName("tt_ctGiro")
    @Expose
    private TtCtGiro ttCtGiro;
    @SerializedName("tt_ctSubGiro")
    @Expose
    private TtCtSubGiro ttCtSubGiro;
    @SerializedName("tt_ctProveedor")
    @Expose
    private TtCtProveedor ttCtProveedor;
    @SerializedName("tt_ctCategoriaProv")
    @Expose
    private TtCtCategoriaProv ttCtCategoriaProv;
    @SerializedName("tt_ctSubCategoriaProv")
    @Expose
    private TtCtSubCategoria ttCtSubCategoria;
    @SerializedName("tt_ctArtProveedor")
    @Expose
    private TtCtArtProveedor ttCtArtProveedor;
    @SerializedName("tt_ctUsuario")
    @Expose
    private TtCtUsuario ttCtUsuario;
    @SerializedName("tt_ctCliente")
    @Expose
    private TtCtCliente ttCtCliente;
    @SerializedName("tt_ctTelefono")
    @Expose
    private TtCtTelefono ttCtTelefono;

    @SerializedName("oplError")
    @Expose
    private String oplError;
    @SerializedName("opcError")
    @Expose
    private String opcError;

    public TtCtGiro getTtCtGiro() {
        return ttCtGiro;
    }

    public void setTtCtGiro(TtCtGiro ttCtGiro) {
        this.ttCtGiro = ttCtGiro;
    }

    public TtCtSubGiro getTtCtSubGiro() {
        return ttCtSubGiro;
    }

    public void setTtCtSubGiro(TtCtSubGiro ttCtSubGiro) {
        this.ttCtSubGiro = ttCtSubGiro;
    }

    public String getOplError() {
        return oplError;
    }

    public void setOplError(String oplError) {
        this.oplError = oplError;
    }

    public String getOpcError() {
        return opcError;
    }

    public void setOpcError(String opcError) {
        this.opcError = opcError;
    }

    public TtCtProveedor getTtCtProveedor() {
        return ttCtProveedor;
    }

    public void setTtCtProveedor(TtCtProveedor ttCtProveedor) {
        this.ttCtProveedor = ttCtProveedor;
    }

    public TtCtCategoriaProv getTtCtCategoriaProv() {
        return ttCtCategoriaProv;
    }

    public void setTtCtCategoriaProv(TtCtCategoriaProv ttCtCategoriaProv) {
        this.ttCtCategoriaProv = ttCtCategoriaProv;
    }

    public TtCtSubCategoria getTtCtSubCategoria() {
        return ttCtSubCategoria;
    }

    public void setTtCtSubCategoria(TtCtSubCategoria ttCtSubCategoria) {
        this.ttCtSubCategoria = ttCtSubCategoria;
    }

    public TtCtArtProveedor getTtCtArtProveedor() {
        return ttCtArtProveedor;
    }

    public void setTtCtArtProveedor(TtCtArtProveedor ttCtArtProveedor) {
        this.ttCtArtProveedor = ttCtArtProveedor;
    }

    public TtCtUsuario getTtCtUsuario() {
        return ttCtUsuario;
    }

    public void setTtCtUsuario(TtCtUsuario ttCtUsuario) {
        this.ttCtUsuario = ttCtUsuario;
    }

    public TtCtCliente getTtCtCliente() {
        return ttCtCliente;
    }

    public void setTtCtCliente(TtCtCliente ttCtCliente) {
        this.ttCtCliente = ttCtCliente;
    }

    public TtCtTelefono getTtCtTelefono() {
        return ttCtTelefono;
    }

    public void setTtCtTelefono(TtCtTelefono ttCtTelefono) {
        this.ttCtTelefono = ttCtTelefono;
    }

    @Override
    public String toString() {
        return "Response{" +
                "ttCtGiro=" + ttCtGiro +
                ", ttCtSubGiro=" + ttCtSubGiro +
                ", ttCtProveedor=" + ttCtProveedor +
                ", ttCtCategoriaProv=" + ttCtCategoriaProv +
                ", ttCtSubCategoria=" + ttCtSubCategoria +
                ", ttCtArtProveedor=" + ttCtArtProveedor +
                ", ttCtUsuario=" + ttCtUsuario +
                ", ttCtCliente=" + ttCtCliente +
                ", ttCtTelefono=" + ttCtTelefono +
                ", oplError='" + oplError + '\'' +
                ", opcError='" + opcError + '\'' +
                '}';
    }
}
