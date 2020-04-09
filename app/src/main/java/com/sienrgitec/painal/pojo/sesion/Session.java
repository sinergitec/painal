package com.sienrgitec.painal.pojo.sesion;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Session {

    @SerializedName("mensaje")
    @Expose
    private String mensaje;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("token")
    @Expose
    private String token;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Session{");
        sb.append("mensaje='").append(mensaje).append('\'');
        sb.append(", user=").append(user);
        sb.append(", token='").append(token).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
