package com.sienrgitec.painal.pojo.peticion;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sienrgitec.painal.pojo.entity.TtCtClienteAutorizados_;

import java.util.List;

public class DsCtClienteAutorizados {

    public DsCtClienteAutorizados (){

    }

    public DsCtClienteAutorizados (List<TtCtClienteAutorizados_> cliAuto){
        this.cliAutorizado = cliAuto;
    }

    @SerializedName("tt_ctClienteAutorizados")
    @Expose
    private List<TtCtClienteAutorizados_> cliAutorizado = null;

    public List<TtCtClienteAutorizados_> getCliAutorizado() {
        return cliAutorizado;
    }

    public void setCliAutorizado(List<TtCtClienteAutorizados_> cliAutorizado) {
        this.cliAutorizado = cliAutorizado;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DsCtClienteAutorizados{");
        sb.append("cliAutorizado=").append(cliAutorizado);
        sb.append('}');
        return sb.toString();
    }
}
