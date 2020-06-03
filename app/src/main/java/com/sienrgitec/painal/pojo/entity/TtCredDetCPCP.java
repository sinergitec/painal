package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class TtCredDetCPCP implements Serializable {

    @SerializedName("tt_credDetCPCP")
    @Expose
    private List<TtCredDetCPCP_> ttCredDetCPCP = null;

    public List<TtCredDetCPCP_> getTtCredDetCPCP() {
        return ttCredDetCPCP;
    }

    public void setTtCredDetCPCP(List<TtCredDetCPCP_> ttCredDetCPCP) {
        this.ttCredDetCPCP = ttCredDetCPCP;
    }



}
