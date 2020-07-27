package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class TTOpPedido_ implements Serializable {

    @SerializedName("tt_opPedido")
    @Expose
    private List<TtOpPedido> tt_OpPedido = null;

    public List<TtOpPedido> getTt_OpPedido() {
        return tt_OpPedido;
    }

    public void setTt_OpPedido(List<TtOpPedido> tt_OpPedido) {
        this.tt_OpPedido = tt_OpPedido;
    }
}
