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
    Call<Respuesta> consultaGiro(@QueryMap Map<String, String> options);

    @GET("ctGiro")
    Call<Respuesta> consultaSubGiro(@QueryMap Map<String, String> options);

    @GET("ctProveedorCli")
    Call<Respuesta> consultaProveedor(@QueryMap Map<String, String> options);

    @GET("ctClasificaArt")
    Call<Respuesta> consultaClasifProveedor(@QueryMap Map<String, String> options);

    @GET("recuperapw")
    Call<Respuesta> recuperapw(@QueryMap Map<String, String> options);

    @GET("buscaArticulos")
    Call<Respuesta> consultaArticulos(@QueryMap Map<String, String> options);

}
