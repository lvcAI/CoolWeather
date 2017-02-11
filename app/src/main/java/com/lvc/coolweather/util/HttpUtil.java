package com.lvc.coolweather.util;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lvc on 2017/2/11.
 */

public class HttpUtil {
    /**
     * 封装网络请求,
     * @param address  url地址
     * @param callback 回调函数处理服务器的响应
     */
    public static void sendOkhttpRequest(String address,okhttp3.Callback callback){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(address).build();
        client.newCall(request).enqueue(callback);
    }
}
