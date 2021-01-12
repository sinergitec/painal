package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Tt_siParametros implements Serializable {
    @SerializedName("tt_siParametros")
    @Expose
    private List<com.sienrgitec.painal.pojo.entity.Tt_siParametros_> tt_siParametros_ = null;

    public List<Tt_siParametros_> getTtsiParametros_() {

        return tt_siParametros_;
    }

    public void setTt_siParametros_(List<Tt_siParametros_> ttsiParametros_) {
        this.tt_siParametros_ = ttsiParametros_;
    }




}

