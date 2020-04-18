package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TtCtGiro {

    @SerializedName("tt_ctGiro")
    @Expose
    private List<TtCtGiro_> ttCtGiro = null;

    public List<TtCtGiro_> getTtCtGiro() {
        return ttCtGiro;
    }

    public void setTtCtGiro(List<TtCtGiro_> ttCtGiro) {
        this.ttCtGiro = ttCtGiro;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TtCtGiro{");
        sb.append("ttCtGiro=").append(ttCtGiro);
        sb.append('}');
        return sb.toString();
    }
}
