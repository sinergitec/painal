package com.sienrgitec.painal.pojo.peticion;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Peticion {

    public Peticion(Request request, String Password){
        this.request = request;
        this.Password = Password;


    }

    public Peticion (Request request){
        this.request = request;
    }

    /*@Override
    public String toString() {
        return "Peticion{" +
                "request=" + request +

                '}' + "\n" + " ipcPassword='" + Password ;
    }*/

    @SerializedName("request")
    @Expose
    private Request request;

    @SerializedName("Password")
    @Expose
    private  String Password;

    public Request getRequest() {
        return request;
    }


    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

}
