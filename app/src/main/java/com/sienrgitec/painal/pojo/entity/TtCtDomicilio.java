package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class TtCtDomicilio implements Serializable {

    @SerializedName("tt_ctDomicilio")
    @Expose
    private List<TtCtDomicilio_> tt_ctDomicilio = null;

    public List<TtCtDomicilio_> getTt_ctDomicilio() {
        return tt_ctDomicilio;
    }

    public void setTt_ctDomicilio(List<TtCtDomicilio_> tt_ctDomicilio) {
        this.tt_ctDomicilio = tt_ctDomicilio;
    }
}
