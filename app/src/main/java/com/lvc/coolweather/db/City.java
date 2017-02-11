package com.lvc.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by lvc on 2017/2/11.
 * 城市 实体类
 */

public class City extends DataSupport {

    private int id;
    private String cityName;
    private int citycode;
    private int provinveId; // 省份id

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCitycode() {
        return citycode;
    }

    public void setCitycode(int citycode) {
        this.citycode = citycode;
    }

    public int getProvinveId() {
        return provinveId;
    }

    public void setProvinveId(int provinveId) {
        this.provinveId = provinveId;
    }
}
