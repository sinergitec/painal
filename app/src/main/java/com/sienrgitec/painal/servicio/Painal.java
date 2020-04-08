package com.sienrgitec.painal.servicio;

import com.sienrgitec.painal.pojo.sesion.Session;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Painal {

    @FormUrlEncoded
    @POST("login")
    Call<Session> login(@Field("username") String username, @Field("password") String password);

}
