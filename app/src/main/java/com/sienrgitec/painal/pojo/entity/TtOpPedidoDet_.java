package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class TtOpPedidoDet_ implements Serializable {

    @SerializedName("tt_opPedidoDet")
    @Expose
    private List<TtOpPedidoDet> tt_opPedidoDet = null;

    public List<TtOpPedidoDet> getTt_opPedidoDet() {
        return tt_opPedidoDet;
    }

    public void setTt_opPedidoDet(List<TtOpPedidoDet> tt_opPedidoDet) {
        this.tt_opPedidoDet = tt_opPedidoDet;
    }
}
