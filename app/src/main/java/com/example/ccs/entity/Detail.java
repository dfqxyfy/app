package com.example.ccs.entity;

/**
 * Created by ccs on 2016/10/12.
 */

public class Detail {
    private String type;
    private String des;

    public Detail(String type, String des) {
        this.type = type;
        this.des = des;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
