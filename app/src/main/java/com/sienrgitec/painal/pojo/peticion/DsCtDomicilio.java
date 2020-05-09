package com.sienrgitec.painal.pojo.peticion;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sienrgitec.painal.pojo.entity.TtCtDomicilio;

import java.util.List;

public class DsCtDomicilio {
    @SerializedName("tt_ctDomicilio")
    @Expose
    private List<TtCtDomicilio> ttCtDomicilio = null;

    public DsCtDomicilio() {
    }

    public DsCtDomicilio(List<TtCtDomicilio> ttCtDomicilio) {
        this.ttCtDomicilio = ttCtDomicilio;
    }

    public List<TtCtDomicilio> getTtCtDomicilio() {
        return ttCtDomicilio;
    }

    public void setTtCtDomicilio(List<TtCtDomicilio> ttCtDomicilio) {
        this.ttCtDomicilio = ttCtDomicilio;
    }
}
