package com.example.abid.fypapplication;

public class DataModel {


    private Long time;
    private String object;

    public DataModel() {
    }

    public DataModel(Long time, String object) {
        this.time = time;
        this.object = object;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }
}
