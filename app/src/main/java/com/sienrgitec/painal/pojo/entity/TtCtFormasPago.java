package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TtCtFormasPago {
    @SerializedName("tt_ctFormasPago")
    @Expose
    private List<TtCtFormasPago_> ttCtFormasPago = null;

    public List<TtCtFormasPago_> getTtCtFormasPago() {
        return ttCtFormasPago;
    }

    public void setTtCtFormasPago(List<TtCtFormasPago_> ttCtFormasPago) {
        this.ttCtFormasPago = ttCtFormasPago;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ttCtFormasPago{");
        sb.append("ttCtFormasPago=").append(ttCtFormasPago);
        sb.append('}');
        return sb.toString();
    }
}
