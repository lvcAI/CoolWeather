package com.lvc.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lvc on 2017/2/12.
 */

public class Now {

    @SerializedName("tmp")
    public String temperature;//温度

    @SerializedName("cond")
    public More more;  //天气

    public class More {
        @SerializedName("txt")
        public String info;
    }
}
