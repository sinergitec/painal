package com.sienrgitec.painal.pojo.peticion;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sienrgitec.painal.pojo.entity.TtCtCliente_;
import com.sienrgitec.painal.pojo.entity.TtCtTelefono_;
import com.sienrgitec.painal.pojo.entity.TtCtUsuario_;

import java.util.ArrayList;
import java.util.List;

public class DsCtCliente {

    public DsCtCliente (){

    }

    public DsCtCliente (List<TtCtCliente_> clientes, List<TtCtUsuario_> usuarios,
                        List<TtCtTelefono_> telefonos){
        this.clientes = clientes;
        this.usuarios = usuarios;
        this.telefonos = telefonos;
    }

    public DsCtCliente(List<TtCtCliente_> clientes) {
        this.clientes = clientes;
    }

    @SerializedName("tt_ctCliente")
    @Expose
    private List<TtCtCliente_> clientes = null;

    @SerializedName("tt_ctUsuario")
    @Expose
    private List<TtCtUsuario_> usuarios = null;

    @SerializedName("tt_ctTelefono")
    @Expose
    private List<TtCtTelefono_> telefonos = null;

    public List<TtCtCliente_> getClientes() {
        return clientes;
    }

    public void setClientes(List<TtCtCliente_> clientes) {
        this.clientes = clientes;
    }

    public List<TtCtUsuario_> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<TtCtUsuario_> usuarios) {
        this.usuarios = usuarios;
    }

    public List<TtCtTelefono_> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<TtCtTelefono_> telefonos) {
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
