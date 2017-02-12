package com.lvc.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lvc on 2017/2/12.
 *基础类
 */

public class Basic {

    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update{
        @SerializedName("loc")
        public String updateTime;
    }
}
