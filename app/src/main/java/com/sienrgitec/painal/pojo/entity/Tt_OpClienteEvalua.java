package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Tt_OpClienteEvalua {
    @SerializedName("tt_OpClienteEvalua")
    @Expose
    private List<Tt_OpClienteEvalua> tt_OpClienteEvalua = null;

    public List<Tt_OpClienteEvalua> getTt_OpClienteEvalua() {
        return tt_OpClienteEvalua;
    }

    public void setTt_OpClienteEvalua(List<Tt_OpClienteEvalua> tt_OpClienteEvalua) {
        this.tt_OpClienteEvalua = tt_OpClienteEvalua;
    }
}
