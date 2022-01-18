package business.InfoSet.CityInfoSet;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

import business.InfoGet.CityInfoGet;
import business.InfoObjects.City;

public class BeijingCityInfoSet {
    public void setBeijingCityInfo(CityInfoGet cityInfoGet, City beijing, JSONObject beijingCityJSON) {
        try {
            beijingCityJSON = JSONObject.parseObject(cityInfoGet.getCityInfo("2c835338eccf48fcba60c11c575c3e80", "101010100"));
            beijing.setName(beijingCityJSON.getJSONArray("location").getJSONObject(0).getString("name"));
            beijing.setId(beijingCityJSON.getJSONArray("location").getJSONObject(0).getString("id"));
            beijing.setLongitude(beijingCityJSON.getJSONArray("location").getJSONObject(0).getFloat("lon"));
            beijing.setLatitude(beijingCityJSON.getJSONArray("location").getJSONObject(0).getFloat("lat"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
