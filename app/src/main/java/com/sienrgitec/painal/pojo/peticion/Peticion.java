package com.sienrgitec.painal.pojo.peticion;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Peticion {

    public Peticion(Request request, String Password){
        this.request = request;


    }

    public Peticion (Request request){
        this.request = request;
    }



    @SerializedName("request")
    @Expose
    private Request request;

    @SerializedName("Password")
    @Expose
    private  String Password;

    public Request getRequest() {
        return request;
    }

    public String getPassword(){
        return Password;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public void setPassword(String Password){
        this.Password = Password;
    }
}
