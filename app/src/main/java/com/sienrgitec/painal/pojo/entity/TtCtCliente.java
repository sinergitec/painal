package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TtCtCliente {

    @SerializedName("tt_ctCliente")
    @Expose
    private List<TtCtCliente_> ttCtCliente_ = null;

    public List<TtCtCliente_> getTtCtCliente_() {
        return ttCtCliente_;
    }

    public void setTtCtCliente_(List<TtCtCliente_> ttCtCliente_) {
        this.ttCtCliente_ = ttCtCliente_;
    }
}
