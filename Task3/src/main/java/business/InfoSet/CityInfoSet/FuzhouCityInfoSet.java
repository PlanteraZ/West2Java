package business.InfoSet.CityInfoSet;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

import business.InfoGet.CityInfoGet;
import business.InfoObjects.City;

public class FuzhouCityInfoSet {
    public void setFuzhouCityInfo(CityInfoGet cityInfoGet, City fuzhou, JSONObject fuzhouCityJSON) {
        try {
            fuzhouCityJSON = JSONObject.parseObject(cityInfoGet.getCityInfo("2c835338eccf48fcba60c11c575c3e80", "101230101"));
            fuzhou.setName(fuzhouCityJSON.getJSONArray("location").getJSONObject(0).getString("name"));
            fuzhou.setId(fuzhouCityJSON.getJSONArray("location").getJSONObject(0).getString("id"));
            fuzhou.setLongitude(fuzhouCityJSON.getJSONArray("location").getJSONObject(0).getFloat("lon"));
            fuzhou.setLatitude(fuzhouCityJSON.getJSONArray("location").getJSONObject(0).getFloat("lat"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
