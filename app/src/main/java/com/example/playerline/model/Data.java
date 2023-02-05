package com.example.playerline.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("next_items")
    public long nextItems;

    @SerializedName("sport")
    public String sport;

    @SerializedName("newslist")
    public NewsList newsList;

    public long getNextItems() {
        return nextItems;
    }

    public void setNextItems(long nextItems) {
        this.nextItems = nextItems;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public NewsList getNewsList() {
        return newsList;
    }

    public void setNewsList(NewsList newsList) {
        this.newsList = newsList;
    }
}
