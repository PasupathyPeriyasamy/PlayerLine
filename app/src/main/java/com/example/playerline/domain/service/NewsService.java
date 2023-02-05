package com.example.playerline.domain.service;

import com.example.playerline.model.DataObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NewsService {

    @GET("static-endpoint/api/newslist/{fileName}")
    Call<DataObject> getNewsList(@Path("fileName") String fileName);

}
