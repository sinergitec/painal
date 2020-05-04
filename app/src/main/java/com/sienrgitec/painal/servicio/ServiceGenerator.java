package com.sienrgitec.painal.servicio;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sienrgitec.painal.constante.Constantes;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private final static String URL_BASE = Constantes.URL_BASE_WS_SINERGITEC;

    private final static Gson gson = new GsonBuilder().setLenient().create();

    private final static HttpLoggingInterceptor loggingInterceptor =
            new HttpLoggingInterceptor()
                    .setLevel(HttpLoggingInterceptor.Level.BODY);

    private final static OkHttpClient.Builder httpClient = new OkHttpClient.Builder().addInterceptor(loggingInterceptor);

    private final static Retrofit.Builder retro = new Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(httpClient.build());

    public final static Retrofit retrofit = retro.build();

    public static <S> S createService(Class<S> serviceClass) {
        if (!httpClient.interceptors().contains(loggingInterceptor)) {
            httpClient.addInterceptor(loggingInterceptor);
            retro.client(httpClient.build());
        }
        return retrofit.create(serviceClass);
    }

}
