package business.InfoSet.CityInfoSet;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

import business.InfoGet.CityInfoGet;
import business.InfoObjects.City;

public class ShanghaiCityInfoSet {
    public void setShanghaiCityInfo(CityInfoGet cityInfoGet, City shanghai, JSONObject shanghaiCityJSON) {
        try {
            shanghaiCityJSON = JSONObject.parseObject(cityInfoGet.getCityInfo("2c835338eccf48fcba60c11c575c3e80", "101020100"));
            shanghai.setName(shanghaiCityJSON.getJSONArray("location").getJSONObject(0).getString("name"));
            shanghai.setId(shanghaiCityJSON.getJSONArray("location").getJSONObject(0).getString("id"));
            shanghai.setLongitude(shanghaiCityJSON.getJSONArray("location").getJSONObject(0).getFloat("lon"));
            shanghai.setLatitude(shanghaiCityJSON.getJSONArray("location").getJSONObject(0).getFloat("lat"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
