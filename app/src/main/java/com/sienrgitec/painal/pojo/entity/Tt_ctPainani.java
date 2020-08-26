package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Tt_ctPainani {

    @SerializedName("tt_ctPainani")
    @Expose
    private List<Tt_ctPainani_> tt_ctPainani = null;

    public List<Tt_ctPainani_> getTt_ctPainani() {
        return tt_ctPainani;
    }

    public void setTt_ctPainani(List<Tt_ctPainani_> tt_ctPainani) {
        this.tt_ctPainani = tt_ctPainani;
    }
}
