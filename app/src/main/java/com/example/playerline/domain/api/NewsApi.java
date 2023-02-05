package com.example.playerline.domain.api;

import com.example.playerline.domain.ApiClient;
import com.example.playerline.domain.service.NewsService;
import com.example.playerline.model.DataObject;
import com.example.playerline.model.NewsList;

import retrofit2.Call;
import retrofit2.Response;

public class NewsApi {

    public NewsList getNewsList(int pageNo) throws Exception {

        NewsList newsList = null;
        NewsService newsService = ApiClient.getClient().create(NewsService.class);
        try {
            Call<DataObject> call = newsService.getNewsList(pageNo + ".json");
            Response<DataObject> response = call.execute();
            if (HttpStatus.SC_OK == response.code() && response != null && response.body() != null) {
                DataObject dataObject = response.body();
                newsList = dataObject.getData().getNewsList();
            } else if (response.code() == HttpStatus.SC_MOVED_TEMPORARILY) {
                throw new Exception("Your session has expired due to inactivity...Please login again!!!");
            } else {
                throw new Exception("There is some technical error, Please try again after some time!");
            }
            System.out.print(response.code());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return newsList;
    }

}
