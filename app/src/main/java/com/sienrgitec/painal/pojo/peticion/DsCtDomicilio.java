package com.sienrgitec.painal.pojo.peticion;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sienrgitec.painal.pojo.entity.TtCtDomicilio_;

import java.util.List;

public class DsCtDomicilio {
    @SerializedName("tt_ctDomicilio")
    @Expose
    private List<TtCtDomicilio_> ttCtDomicilio = null;

    public DsCtDomicilio() {
    }

    public DsCtDomicilio(List<TtCtDomicilio_> ttCtDomicilio) {
        this.ttCtDomicilio = ttCtDomicilio;
    }

    public List<TtCtDomicilio_> getTtCtDomicilio() {
        return ttCtDomicilio;
    }

    public void setTtCtDomicilio(List<TtCtDomicilio_> ttCtDomicilio) {
        this.ttCtDomicilio = ttCtDomicilio;
    }
}
