package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Tt_OpClienteReferidos implements Serializable {

    @SerializedName("tt_opClienteReferidos")
    @Expose
    private List<Tt_OpClienteReferidos_> tt_opClienteReferidos = null;

    public List<Tt_OpClienteReferidos_> getTt_opClienteReferidos() {
        return tt_opClienteReferidos;
    }

    public void setTt_opClienteReferidos(List<Tt_OpClienteReferidos_> tt_opClienteReferidos) {
        this.tt_opClienteReferidos = tt_opClienteReferidos;
    }
}
