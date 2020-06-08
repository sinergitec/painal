package com.sienrgitec.painal.pojo.peticion;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sienrgitec.painal.pojo.entity.TtCredDetCPCP_;
import com.sienrgitec.painal.pojo.entity.TtCtContacto_;

import java.util.List;

public class ds_NvoPago {

    public ds_NvoPago(){

    }

    public ds_NvoPago (List<TtCredDetCPCP_> abono){
        this.contacto = abono;
    }

    @SerializedName("tt_credDetCPCP")
    @Expose
    private List<TtCredDetCPCP_> contacto = null;

    public List<TtCredDetCPCP_> getContacto() {
        return contacto;
    }

    public void setContacto(List<TtCredDetCPCP_> contacto) {
        this.contacto = contacto;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ds_NvoPago{");
        sb.append("contacto=").append(contacto);
        sb.append('}');
        return sb.toString();
    }
}
