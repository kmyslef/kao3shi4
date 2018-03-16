package com.example.dike.kao3shi4;

import java.util.List;

/**
 * Created by dik on 2018/3/12.
 */

public class DataListInfo <T> {

    private String message;
    List<T> data;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
