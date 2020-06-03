package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class TtCredEncCPCP implements Serializable {
    @SerializedName("tt_credEncCPCP")
    @Expose
    private List<TtCredEncCPCP_> ttCredEncCPCP = null;

    public List<TtCredEncCPCP_> getTtCredEncCPCP() {
        return ttCredEncCPCP;
    }

    public void setTtCredDetCPCP(List<TtCredEncCPCP_> ttCredEncCPCP) {
        this.ttCredEncCPCP = ttCredEncCPCP;
    }
}
