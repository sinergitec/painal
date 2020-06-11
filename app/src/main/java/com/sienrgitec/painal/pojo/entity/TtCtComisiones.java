package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class TtCtComisiones  implements Serializable {

    @SerializedName("tt_ctComisiones")
    @Expose
    private List<TtCtComisiones_> ttCtComisiones_ = null;

    public List<TtCtComisiones_> getTtCtComisiones_() {
        return ttCtComisiones_;
    }

    public void setTtCtComisiones_(List<TtCtComisiones_> ttCtComisiones_) {
        this.ttCtComisiones_ = ttCtComisiones_;
    }
}
