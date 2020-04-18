package com.sienrgitec.painal.pojo.error;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ErrorABL {
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ErrorABL{");
        sb.append("errorMsg='").append(errorMsg).append('\'');
        sb.append(", errorNum=").append(errorNum);
        sb.append('}');
        return sb.toString();
    }
}
