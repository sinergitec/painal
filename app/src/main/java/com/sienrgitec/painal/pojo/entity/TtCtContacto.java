package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class TtCtContacto implements Serializable {

    @SerializedName("tt_ctContacto")
    @Expose
    private List<TtCtContacto_> ttCtContacto_ = null;

    public List<TtCtContacto_> getTtCtContacto_() {
        return ttCtContacto_;
    }

    public void setTtCtContacto_(List<TtCtContacto_> ttCtContacto_) {
        this.ttCtContacto_ = ttCtContacto_;
    }

}
