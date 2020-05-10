package com.sienrgitec.painal.pojo.peticion;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sienrgitec.painal.pojo.entity.TtCtContacto_;

import java.util.List;

public class DsCtContacto {

    public DsCtContacto (){

    }

    public DsCtContacto (List<TtCtContacto_> contacto){
        this.contacto = contacto;
    }

    @SerializedName("tt_ctContacto")
    @Expose
    private List<TtCtContacto_> contacto = null;

    public List<TtCtContacto_> getContacto() {
        return contacto;
    }

    public void setContacto(List<TtCtContacto_> contacto) {
        this.contacto = contacto;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DsCtContacto{");
        sb.append("contacto=").append(contacto);
        sb.append('}');
        return sb.toString();
    }
}
