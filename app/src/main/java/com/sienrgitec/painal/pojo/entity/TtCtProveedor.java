package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TtCtProveedor {

    @SerializedName("tt_ctProveedor")
    @Expose
    private List<TtCtProveedor_> ttCtProveedor = null;

    public List<TtCtProveedor_> getTtCtProveedor() {
        return ttCtProveedor;
    }

    public void setTtCtProveedor(List<TtCtProveedor_> ttCtProveedor) {
        this.ttCtProveedor = ttCtProveedor;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TtCtProveedor{");
        sb.append("ttCtProveedor=").append(ttCtProveedor);
        sb.append('}');
        return sb.toString();
    }
}
