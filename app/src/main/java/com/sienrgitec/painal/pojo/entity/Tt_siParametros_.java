package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Tt_siParametros_ implements Serializable {
    @SerializedName("cDescripcion")
    @Expose
    private String cDescripcion;
    private String cValor ;


    public String getcValor() {
        return cValor;
    }

    public void setcValor(String cValor) {
        this.cValor = cValor;
    }

    public String getcDescripcion() {
        return cDescripcion;
    }

    public void setcDescripcion(String cDescripcion) {
        this.cDescripcion = cDescripcion;
    }
}
