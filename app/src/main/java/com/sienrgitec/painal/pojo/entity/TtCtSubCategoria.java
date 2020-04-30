package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TtCtSubCategoria {

    @SerializedName("tt_ctSubCategoriaProv")
    @Expose
    private List<TtCtSubCategoriaProv> ttCtSubCategoriaProv = null;

    public List<TtCtSubCategoriaProv> getTtCtSubCategoriaProv() {
        return ttCtSubCategoriaProv;
    }

    public void setTtCtSubCategoriaProv(List<TtCtSubCategoriaProv> ttCtSubCategoriaProv) {
        this.ttCtSubCategoriaProv = ttCtSubCategoriaProv;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TtCtSubCategoria{");
        sb.append("ttCtSubCategoriaProv=").append(ttCtSubCategoriaProv);
        sb.append('}');
        return sb.toString();
    }
}
