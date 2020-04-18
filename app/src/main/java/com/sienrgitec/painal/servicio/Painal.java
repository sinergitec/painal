package com.sienrgitec.painal.servicio;

import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.pojo.sesion.Session;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface Painal {

    @FormUrlEncoded
    @POST("login")
    Call<Session> login(@Field("username") String username, @Field("password") String password);

    @GET("ctGiro")
    Call<Respuesta> consulta(@QueryMap Map<String, String> options);

}
