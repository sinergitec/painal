package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TtCtTelefono {

    @SerializedName("tt_ctTelefono")
    @Expose
    private List<TtCtTelefono_> ttCtTelefono = null;

    public List<TtCtTelefono_> getTtCtTelefono() {
        return ttCtTelefono;
    }

    public void setTtCtTelefono(List<TtCtTelefono_> ttCtTelefono) {
        this.ttCtTelefono = ttCtTelefono;
    }
}
