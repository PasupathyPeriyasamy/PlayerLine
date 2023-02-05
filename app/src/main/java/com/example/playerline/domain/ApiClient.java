package com.example.playerline.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.CookieJar;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


public class ApiClient {

    public static String BASE_IP = "https://www.playerline.org/";
    public static String PORTAL = "test/";
    private static Retrofit sRetrofit = null;

    public static Retrofit getClient() {

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(String.class, new HtmlAdapter())
                .setDateFormat(DATE_FORMATS[0])
                .setDateFormat(DATE_FORMATS[1])
                .setLenient()
                .create();

        sRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_IP + PORTAL)
                .addConverterFactory(new NullOnEmptyConverterFactory())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(new OkHttpClient())
                .build();
        return sRetrofit;

    }

    public static class NullOnEmptyConverterFactory extends Converter.Factory {

        @Override
        public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
            final Converter<ResponseBody, ?> delegate = retrofit.nextResponseBodyConverter(this, type, annotations);
            return (Converter<ResponseBody, Object>) body -> {
                if (body.contentLength() == 0) return null;
                return delegate.convert(body);
            };
        }
    }

    private static final String[] DATE_FORMATS = new String[]{
            "dd/MM/yyyy HH:mm:ss",
            "dd/MM/yyyy"
    };
}
