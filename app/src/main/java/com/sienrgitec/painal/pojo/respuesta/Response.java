package com.sienrgitec.painal.pojo.respuesta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("oplError")
    @Expose
    private String oplError;
    @SerializedName("opcError")
    @Expose
    private String opcError;

    public String getOplError() {
        return oplError;
    }

    public void setOplError(String oplError) {
        this.oplError = oplError;
    }

    public String getOpcError() {
        return opcError;
    }

    public void setOpcError(String opcError) {
        this.opcError = opcError;
    }

}
