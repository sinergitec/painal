package com.sienrgitec.painal.pojo.error;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Errors {
    @SerializedName("_errors")
    @Expose
    private List<ErrorABL> errors = null;

    public List<ErrorABL> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorABL> errors) {
        this.errors = errors;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Errors{");
        sb.append("errors=").append(errors);
        sb.append('}');
        return sb.toString();
    }
}
