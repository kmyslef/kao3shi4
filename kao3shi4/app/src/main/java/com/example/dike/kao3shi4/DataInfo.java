package com.example.dike.kao3shi4;

import java.util.List;

/**
 * Created by dik on 2018/3/5.
 */

public class DataInfo {
    private String message;
    List<GroupInfo> data;

    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }

    public List<GroupInfo> getData() {
        return data;
    }

    public void setData(List<GroupInfo> data) {
        this.data = data;
    }
}
