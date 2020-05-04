package com.sienrgitec.painal.pojo.peticion;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sienrgitec.painal.pojo.entity.TtCtCliente;
import com.sienrgitec.painal.pojo.entity.TtCtTelefono;
import com.sienrgitec.painal.pojo.entity.TtCtUsuario_;

import java.util.List;

public class DsCtCliente {

    public DsCtCliente (){

    }

    public DsCtCliente (List<TtCtCliente> clientes, List<TtCtUsuario_> usuarios,
                        List<TtCtTelefono> telefonos){
        this.clientes = clientes;
        this.usuarios = usuarios;
        this.telefonos = telefonos;
    }

    @SerializedName("tt_ctCliente")
    @Expose
    private List<TtCtCliente> clientes = null;

    @SerializedName("tt_ctUsuario")
    @Expose
    private List<TtCtUsuario_> usuarios = null;

    @SerializedName("tt_ctTelefono")
    @Expose
    private List<TtCtTelefono> telefonos = null;

    public List<TtCtCliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<TtCtCliente> clientes) {
        this.clientes = clientes;
    }

    public List<TtCtUsuario_> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<TtCtUsuario_> usuarios) {
        this.usuarios = usuarios;
    }

    public List<TtCtTelefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<TtCtTelefono> telefonos) {
        this.telefonos = telefonos;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DsCtCliente{");
        sb.append("clientes=").append(clientes);
        sb.append(", usuarios=").append(usuarios);
        sb.append(", telefonos=").append(telefonos);
        sb.append('}');
        return sb.toString();
    }
}
