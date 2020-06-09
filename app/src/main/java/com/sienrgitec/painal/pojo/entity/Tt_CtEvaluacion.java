package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Tt_CtEvaluacion {
    @SerializedName("tt_ctEvaluacion")
    @Expose
    private List<Tt_CtEvaluacion_> tt_ctEvaluacion = null;

    public List<Tt_CtEvaluacion_> getTt_ctEvaluacion() {
        return tt_ctEvaluacion;
    }

    public void setTt_ctEvaluacion(List<Tt_CtEvaluacion_> tt_ctEvaluacion) {
        this.tt_ctEvaluacion = tt_ctEvaluacion;
    }
}
