package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class TtCtUsuario {
    @SerializedName("tt_ctUsuario")
    @Expose
    private List<TtCtUsuario_> ttCtUsuario = new ArrayList<>();

    public List<TtCtUsuario_> getTtCtUsuario() {
        return ttCtUsuario;
    }

    public void setTtCtUsuario(List<TtCtUsuario_> ttCtUsuario) {
        this.ttCtUsuario = ttCtUsuario;
    }
}
