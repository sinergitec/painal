package com.sienrgitec.painal.pojo.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class TtCtArtProveedor implements Serializable {

    @SerializedName("tt_ctArtProveedor")
    @Expose
    private List<TtCtArtProveedor_> ttCtArtProveedor = null;

    public List<TtCtArtProveedor_> getTtCtArtProveedor() {
        return ttCtArtProveedor;
    }

    public void setTtCtArtProveedor(List<TtCtArtProveedor_> ttCtArtProveedor) {
        this.ttCtArtProveedor = ttCtArtProveedor;
    }

}
