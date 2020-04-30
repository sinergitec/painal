package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TtCtCategoriaProv {

    @SerializedName("tt_ctCategoriaProv")
    @Expose
    private List<TtCtCategoriaProv_> ttCtCategoriaProv = null;

    public List<TtCtCategoriaProv_> getTtCtCategoriaProv() {
        return ttCtCategoriaProv;
    }

    public void setTtCtCategoriaProv(List<TtCtCategoriaProv_> ttCtCategoriaProv) {
        this.ttCtCategoriaProv = ttCtCategoriaProv;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TtCtCategoriaProv{");
        sb.append("ttCtCategoriaProv=").append(ttCtCategoriaProv);
        sb.append('}');
        return sb.toString();
    }
}
