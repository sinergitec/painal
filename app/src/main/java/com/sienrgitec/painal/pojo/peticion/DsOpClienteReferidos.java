package com.sienrgitec.painal.pojo.peticion;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sienrgitec.painal.pojo.entity.TtCtClienteAutorizados_;
import com.sienrgitec.painal.pojo.entity.Tt_OpClienteReferidos_;

import java.util.List;

public class DsOpClienteReferidos {

    public DsOpClienteReferidos (){

    }

    public DsOpClienteReferidos (List<Tt_OpClienteReferidos_> cliReferidos){
        this.cliReferidos = cliReferidos;
    }

    @SerializedName("tt_opClienteReferidos")
    @Expose
    private List<Tt_OpClienteReferidos_> cliReferidos = null;

    public List<Tt_OpClienteReferidos_> getCliReferidos() {
        return cliReferidos;
    }

    public void setCliReferidos(List<Tt_OpClienteReferidos_> cliReferidos) {
        this.cliReferidos = cliReferidos;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DsOpClienteReferidos{");
        sb.append("cliReferidos=").append(cliReferidos);
        sb.append('}');
        return sb.toString();
    }
}
