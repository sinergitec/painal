package com.sienrgitec.painal.servicio;

import com.sienrgitec.painal.pojo.peticion.Peticion;
import com.sienrgitec.painal.pojo.respuesta.Respuesta;
import com.sienrgitec.painal.pojo.sesion.Session;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.QueryMap;

public interface Painal {

    /*@FormUrlEncoded
    @POST("login")
    Call<Session> login(@Field("username") String username, @Field("password") String password);*/

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

    @GET("login")
    Call<Respuesta> login(@QueryMap Map<String, String> options);

    @POST("opPedidoCrea")
    Call<Respuesta> creaPedido(@Body Peticion peticion);

    @POST("ctDomicilio")
    Call<Respuesta> creaDomicilio(@Body Peticion peticion);

    @DELETE("ctDomicilio")
    Call<Respuesta> eliminaDomicilio(@QueryMap Map<String, String> options);

    //Cliente
    @POST("ctCliente")
    Call<Respuesta> ctCliente(@Body Peticion peticion);

    @PUT("ctCliente")
    Call<Respuesta> ctClientePut(@Body Peticion peticion);

    //Contacto
    @POST("ctContacto")
    Call<Respuesta> ctContacto(@Body Peticion peticion);

    @GET("ctContacto")
    Call<Respuesta> ctContacto(@QueryMap Map<String, String> options);

    //Clientes autorizados
    @GET("ctClienteAutorizados")
    Call<Respuesta> ctClienteAutorizados(@QueryMap Map<String, String> options);

    @POST("ctClienteAutorizados")
    Call<Respuesta> ctClienteAutorizado(@Body Peticion peticion);

    @PUT("ctClienteAutorizados")
    Call<Respuesta> ctClienteAutorizadosPut(@Body Peticion peticion);

    @DELETE("ctClienteAutorizados")
    Call<Respuesta> ctClienteAutorizadosDelete(@QueryMap Map<String, Integer> options);

    //Clientes Referidos
    @GET("opClienteReferidos")
    Call<Respuesta> opClienteReferidos(@QueryMap Map<String, String> options);

    @POST("opClienteReferidos")
    Call<Respuesta> opClienteReferidos(@Body Peticion peticion);

    @PUT("opClienteReferidos")
    Call<Respuesta> opClienteReferidosPut(@Body Peticion peticion);

    @DELETE("opClienteReferidos")
    Call<Respuesta> opClienteReferidosDelete(@QueryMap Map<String, Integer> options);

    /*Andros Consulta de saldos CPC*/
    @GET("credEncCPCP")
    Call<Respuesta> credEncCPCP(@QueryMap Map<String, String> options);

    /*Andros Solicitud de Abono*/
    @POST("credDetCPCP")
    Call<Respuesta> credDetCPCPPost(@Body Peticion peticion);

    /*Evaluacion Proveedor / Titlani*/
    @GET("ctEvaluacion")
    Call<Respuesta> ctEvaluacionGet(@QueryMap Map<String, String> options);

    @POST("opClienteEvalua")
    Call<Respuesta> ctEvaluacionPost(@Body Peticion peticion);

    /*Carga formas de Pago / Andros 10-06-20 */
    @GET("ctFormasPago")
    Call<Respuesta> ctFormasPago(@QueryMap Map<String, String> options);

    /*Carga ctComisiones / Andros 10-06-20 */
    @GET("ctComisiones")
    Call<Respuesta> ctComisiones(@QueryMap Map<String, String> options);

    @GET("validaUbicacion")
    Call<Respuesta> validaUbicacion(@QueryMap Map<String, String> options);

    @GET("consultaDomicilio")
    Call<Respuesta> consultaDomicilio(@QueryMap Map<String, String> options);
}
