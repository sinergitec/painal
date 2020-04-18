package com.sienrgitec.painal.pojo.respuesta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Respuesta {

    @SerializedName("response")
    @Expose
    private Response response;
    @SerializedName("_errorMsg")
    @Expose
    private String errorMsg;
    @SerializedName("_errorNum")
    @Expose
    private Integer errorNum;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Integer getErrorNum() {
        return errorNum;
    }

    public void setErrorNum(Integer errorNum) {
        this.errorNum = errorNum;
    }

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Respuesta{");
        sb.append("response=").append(response);
        sb.append(", errorMsg='").append(errorMsg).append('\'');
        sb.append(", errorNum=").append(errorNum);
        sb.append('}');
        return sb.toString();
    }

}
