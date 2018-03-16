package com.example.dike.kao3shi4;

import java.util.List;

/**
 * Created by dik on 2018/2/24.
 */

public class GroupInfo {

    private String message;
    private List<Info> data;

    public class Info {
        private int pagenum;
        private int pagesize;
        private int showsize;

        public void setPagenum(int pagenum) {
            this.pagenum = pagenum;
        }

        public int getPagenum() {
            return pagenum;
        }

        public void setPagesize(int pagesize) {
            this.pagesize = pagesize;
        }

        public int getPagesize() {
            return pagesize;
        }

        public void setShowsize(int showsize) {
            this.showsize = showsize;
        }

        public int getShowsize() {
            return showsize;
        }
    }



    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }

    public List<Info> getData() {
        return data;
    }

    public void setData(List<Info> data) {
        this.data = data;
    }



}
