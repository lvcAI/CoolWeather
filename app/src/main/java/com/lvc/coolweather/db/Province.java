package com.lvc.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by lvc on 2017/2/11.
 */

public class Province extends DataSupport {

    private int id;
    private String provinveName; //省名称
    private int provinveCode;   // 省 代码

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProvinveCode() {
        return provinveCode;
    }

    public void setProvinveCode(int provinveCode) {
        this.provinveCode = provinveCode;
    }

    public String getProvinveName() {
        return provinveName;
    }

    public void setProvinveName(String provinveName) {
        this.provinveName = provinveName;
    }
}
