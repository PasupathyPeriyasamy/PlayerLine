package com.example.playerline.model;

import com.google.gson.annotations.SerializedName;

public class DataObject {

    @SerializedName("result")
    private String result;

    @SerializedName("return_type")
    private String returnType;

    @SerializedName("subtype")
    private String subtype;

    @SerializedName("duration")
    private double duration;

    @SerializedName("data")
    private Data data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
