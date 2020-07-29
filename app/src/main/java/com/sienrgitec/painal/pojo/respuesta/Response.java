package com.sienrgitec.painal.pojo.respuesta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sienrgitec.painal.pojo.entity.TTOpPedido_;
import com.sienrgitec.painal.pojo.entity.TtCredEncCPCP;
import com.sienrgitec.painal.pojo.entity.TtCtArtProveedor;
import com.sienrgitec.painal.pojo.entity.TtCtCategoriaProv;
import com.sienrgitec.painal.pojo.entity.TtCtCliente;
import com.sienrgitec.painal.pojo.entity.TtCtClienteAutorizados;
import com.sienrgitec.painal.pojo.entity.TtCtComisiones;
import com.sienrgitec.painal.pojo.entity.TtCtContacto;
import com.sienrgitec.painal.pojo.entity.TtCtDomicilio;
import com.sienrgitec.painal.pojo.entity.TtCtFormasPago;
import com.sienrgitec.painal.pojo.entity.TtCtGiro;
import com.sienrgitec.painal.pojo.entity.TtCtProveedor;
import com.sienrgitec.painal.pojo.entity.TtCtSubCategoria;
import com.sienrgitec.painal.pojo.entity.TtCtSubGiro;
import com.sienrgitec.painal.pojo.entity.TtCtTelefono;
import com.sienrgitec.painal.pojo.entity.TtCtUsuario;
import com.sienrgitec.painal.pojo.entity.TtOpPedidoDet_;
import com.sienrgitec.painal.pojo.entity.Tt_CtEvaluacion;
import com.sienrgitec.painal.pojo.entity.Tt_OpClienteReferidos;
import com.sienrgitec.painal.pojo.entity.Tt_ctPainani;
import com.sienrgitec.painal.pojo.entity.Tt_ctPainani_;

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

    @SerializedName("tt_opPedido")
    @Expose
    private TTOpPedido_ ttTtOpPedido;

    @SerializedName("tt_opPedidoDet")
    @Expose
    private TtOpPedidoDet_ tt_opPedidoDet;

    @SerializedName("tt_ctContacto")
    @Expose
    private TtCtContacto tt_ctContacto;

    @SerializedName("tt_ctClienteAutorizados")
    @Expose
    private TtCtClienteAutorizados tt_ctClienteAutorizados;

    @SerializedName("tt_opClienteReferidos")
    @Expose
    private Tt_OpClienteReferidos tt_opClienteReferidos;

    @SerializedName("tt_ctDomicilio")
    @Expose
    private TtCtDomicilio tt_ctDomicilio;

    @SerializedName("tt_ctEvaluacion")
    @Expose
    private Tt_CtEvaluacion tt_ctEvaluacion;

    @SerializedName("tt_credEncCPCP")
    @Expose
    private TtCredEncCPCP tt_credEncCPCP;

    @SerializedName("tt_ctFormasPago")
    @Expose
    private TtCtFormasPago tt_ctFormasPago;

    @SerializedName("tt_ctComisiones")
    @Expose
    private TtCtComisiones tt_ctComisiones;

    @SerializedName("tt_ctPainani")
    @Expose
    private Tt_ctPainani tt_ctPainani;

    @SerializedName("oplError")
    @Expose
    private String oplError;
    @SerializedName("opcError")
    @Expose
    private String opcError;
    @SerializedName("opdeSaldo")
    @Expose
    private Double opdeSaldo;

    public Double getOpdeSaldo() {
        return opdeSaldo;
    }

    public void setOpdeSaldo(Double opdeSaldo) {
        this.opdeSaldo = opdeSaldo;
    }

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

    public TtCtContacto getTt_ctContacto() {
        return tt_ctContacto;
    }

    public void setTt_ctContacto(TtCtContacto tt_ctContacto) {
        this.tt_ctContacto = tt_ctContacto;
    }

    public TtCtClienteAutorizados getTt_ctClienteAutorizados() {
        return tt_ctClienteAutorizados;
    }

    public void setTt_ctClienteAutorizados(TtCtClienteAutorizados tt_ctClienteAutorizados) {
        this.tt_ctClienteAutorizados = tt_ctClienteAutorizados;
    }

    public Tt_OpClienteReferidos getTt_opClienteReferidos() {
        return tt_opClienteReferidos;
    }

    public void setTt_opClienteReferidos(Tt_OpClienteReferidos tt_opClienteReferidos) {
        this.tt_opClienteReferidos = tt_opClienteReferidos;
    }

    public TtCtDomicilio getTt_ctDomicilio() {
        return tt_ctDomicilio;
    }

    public void setTt_ctDomicilio(TtCtDomicilio tt_ctDomicilio) {
        this.tt_ctDomicilio = tt_ctDomicilio;
    }

    public TtCredEncCPCP getTt_credEncCPCP() {
        return tt_credEncCPCP;
    }


    public Tt_CtEvaluacion getTt_ctEvaluacion() {
        return tt_ctEvaluacion;
    }

    public void setTt_ctEvaluacion(Tt_CtEvaluacion tt_ctEvaluacion) {
        this.tt_ctEvaluacion = tt_ctEvaluacion;
    }

    public void setTt_credEncCPCP(TtCredEncCPCP tt_credEncCPCP) {
        this.tt_credEncCPCP = tt_credEncCPCP;
    }

    /*Andros Carga formas de pago*/
    public TtCtFormasPago getTt_ctFormasPago() {
        return tt_ctFormasPago;
    }
    /*Andros Carga ctComisones*/
    public TtCtComisiones getTtCtComisiones() {
        return tt_ctComisiones;
    }

    public TTOpPedido_ getTtTtOpPedido() {
        return ttTtOpPedido;
    }

    public void setTtTtOpPedido(TTOpPedido_ ttTtOpPedido) {
        this.ttTtOpPedido = ttTtOpPedido;
    }

    public TtOpPedidoDet_ getTt_opPedidoDet() {
        return tt_opPedidoDet;
    }

    public void setTt_opPedidoDet(TtOpPedidoDet_ tt_opPedidoDet) {
        this.tt_opPedidoDet = tt_opPedidoDet;
    }

    public Tt_ctPainani getTt_ctPainani() {
        return tt_ctPainani;
    }

    public void setTt_ctPainani(Tt_ctPainani tt_ctPainani) {
        this.tt_ctPainani = tt_ctPainani;
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
                ", tt_credEncCPCP" + tt_credEncCPCP +
                ", tt_ctFormasPago" + tt_ctFormasPago +
                ", tt_ctComisiones" + tt_ctComisiones +
                ", oplError='" + oplError + '\'' +
                ", opcError='" + opcError + '\'' +
                ", opdeSaldo='" + opdeSaldo + '\'' +
                '}';
    }
}
