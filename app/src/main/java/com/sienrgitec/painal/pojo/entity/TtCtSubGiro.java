package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TtCtSubGiro {
    @SerializedName("tt_ctSubGiro")
    @Expose
    private List<TtCtSubGiro_> ttCtSubGiro = null;

    public List<TtCtSubGiro_> getTtCtSubGiro() {
        return ttCtSubGiro;
    }

    public void setTtCtSubGiro(List<TtCtSubGiro_> ttCtSubGiro) {
        this.ttCtSubGiro = ttCtSubGiro;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TtCtSubGiro{");
        sb.append("ttCtSubGiro=").append(ttCtSubGiro);
        sb.append('}');
        return sb.toString();
    }
}
