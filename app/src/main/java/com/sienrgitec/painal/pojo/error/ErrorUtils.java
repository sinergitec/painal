package com.sienrgitec.painal.pojo.error;

import com.sienrgitec.painal.servicio.ServiceGenerator;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

public class ErrorUtils {

    public static Errors parseError(Response<?> response) {
        Converter<ResponseBody, Errors> converter =
                ServiceGenerator.retrofit
                        .responseBodyConverter(Errors.class, new Annotation[0]);
        Errors error;
        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return new Errors();
        }
        return error;
    }

}
