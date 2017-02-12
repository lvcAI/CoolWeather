package com.lvc.coolweather.util;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.lvc.coolweather.db.City;
import com.lvc.coolweather.db.County;
import com.lvc.coolweather.db.Province;
import com.lvc.coolweather.gson.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by lvc on 2017/2/11.
 */

public class Utility {

    /**
     * 处理服务器返回的省级数据
     * @param response
     * @return
     */
    public static boolean handleProvinveResponse(String response){
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allProvinces = new JSONArray(response);
                for (int i=0;i< allProvinces.length();i++){
                    JSONObject proviceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinveName(proviceObject.getString("name"));
                    province.setProvinveCode(proviceObject.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    /**
     * 处理市级数据
     * @param response
     * @param proviceId
     * @return
     */
    public static boolean handleCityResponse(String response,int proviceId){
        if (!TextUtils.isEmpty(response)){
            try {
                JSONArray allCities =new JSONArray(response);
                for(int i=0;i<allCities.length();i++){
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCitycode(cityObject.getInt("id"));
                    city.setProvinveId(proviceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
      return false;
    }

    /**
     * 处理县级数据
     * @param response
     * @param cityId
     * @return
     */
    public static boolean handleCountyResponse(String response,int cityId){
        if (!TextUtils.isEmpty(response)){
         //   Log.d("测试返回数据：", ""+response);
            try {
                JSONArray allCounties =new JSONArray(response);
                for(int i=0;i<allCounties.length();i++){
                    JSONObject cityObject = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(cityObject.getString("name"));
                    county.setWeatherId(cityObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 将返回的JSON数据解析成Weather 实体类
     * @param response
     * @return
     */
    public static Weather handleWeatherResponse(String response){

        try {
            JSONObject  jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            Log.i("测试输出内容", "handleWeatherResponse: "+weatherContent);
            return new Gson().fromJson(weatherContent,Weather.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
