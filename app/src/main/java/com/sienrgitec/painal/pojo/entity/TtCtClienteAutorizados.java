package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class TtCtClienteAutorizados implements Serializable {

    @SerializedName("tt_ctClienteAutorizados")
    @Expose
    private List<TtCtClienteAutorizados_> tt_ctClienteAutorizados = null;


    public List<TtCtClienteAutorizados_> getTt_ctClienteAutorizados() {
        return tt_ctClienteAutorizados;
    }

    public void setTt_ctClienteAutorizados(List<TtCtClienteAutorizados_> tt_ctClienteAutorizados) {
        this.tt_ctClienteAutorizados = tt_ctClienteAutorizados;
    }
}
