package com.sienrgitec.painal.pojo.peticion;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sienrgitec.painal.pojo.entity.Tt_OpClienteEvalua_;

import java.util.List;

public class DsNvaEvaluacion {

    public DsNvaEvaluacion (){

    }

    public DsNvaEvaluacion (List<Tt_OpClienteEvalua_> cliEvalua){
        this.cliEvaluar = cliEvalua;
    }

    public DsNvaEvaluacion (List<Tt_OpClienteEvalua_> cliEvalua, String ipcPersona){
        this.cliEvaluar = cliEvalua;
        this.ipcPersona = ipcPersona;
    }

    @SerializedName("tt_opClienteEvalua")
    @Expose
    private List<Tt_OpClienteEvalua_> cliEvaluar = null;

    @SerializedName("ipcPersona")
    @Expose
    private String ipcPersona = null;

    public String getIpcPersona() {
        return ipcPersona;
    }

    public void setIpcPersona(String ipcPersona) {
        this.ipcPersona = ipcPersona;
    }

    public List<Tt_OpClienteEvalua_> getCliEvaluar() {
        return cliEvaluar;
    }

    public void setCliEvaluar(List<Tt_OpClienteEvalua_> cliEvaluar) {
        this.cliEvaluar = cliEvaluar;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DsNvaEvaluacion{");
        sb.append("cliEvaluar=").append(cliEvaluar);
        sb.append('}');
        return sb.toString();
    }

}
