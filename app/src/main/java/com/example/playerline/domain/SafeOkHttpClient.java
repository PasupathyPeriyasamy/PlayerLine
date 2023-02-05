package com.example.playerline.domain;


import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

public class SafeOkHttpClient {

    public static SSLContext sslContext = null;
    private static TrustManager[] trustAllCerts = null;
    private static SSLSocketFactory sslSocketFactory = null;

    public static OkHttpClient getOkHttpClient() {
        try {

            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            /*add header*/
            builder.addInterceptor(chain -> {
                Request original = chain.request();

                // Request customization: add request headers
                Request.Builder requestBuilder = original.newBuilder();
                Request request = requestBuilder.build();
                return chain.proceed(request);
            });

            if (trustAllCerts == null) {
//                trustAllCerts = SecurityUtil.getTrustManagers();
                //enable for client certificate
                /*if (BuildConfig.ENABLE_CLIENT_CERT) {
                    sslContext = SecurityUtil.createSSLContext(trustAllCerts);
                    sslSocketFactory = sslContext.getSocketFactory();
                } else {*/
//                    sslSocketFactory = SecurityUtil.getSslSocketFactory();
//                }
            }

            /*logging*/
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
            builder.hostnameVerifier((hostname, session) -> true);
            builder.addInterceptor(logging);
            builder.connectTimeout(5, TimeUnit.MINUTES);
            builder.readTimeout(5, TimeUnit.MINUTES);
            builder.writeTimeout(5, TimeUnit.MINUTES);
            builder.followRedirects(false);
            builder.followSslRedirects(false);
            return builder.build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
