package business.InfoSet.WeatherInfoSet;

import com.alibaba.fastjson.JSONObject;

import business.InfoObjects.Weather;

import java.sql.Date;
import java.time.ZonedDateTime;

public class BeijingWeatherInfoSet {


    public void setBeijing1stDayWeatherInfo(Weather beijing1stDayWeather, JSONObject beijingWeatherJSON) {
        beijing1stDayWeather.setUpdateTime(beijingWeatherJSON.getObject("updateTime", ZonedDateTime.class));
        beijing1stDayWeather.setCityName("北京");
        beijing1stDayWeather.setFxDate((Date) beijingWeatherJSON.getJSONArray("daily").getJSONObject(0).getSqlDate("fxDate"));
        beijing1stDayWeather.setTempMax(beijingWeatherJSON.getJSONArray("daily").getJSONObject(0).getInteger("tempMax"));
        beijing1stDayWeather.setTempMin(beijingWeatherJSON.getJSONArray("daily").getJSONObject(0).getInteger("tempMin"));
        beijing1stDayWeather.setTextDay(beijingWeatherJSON.getJSONArray("daily").getJSONObject(0).getString("textDay"));
    }

    public void setBeijing2ndDayWeatherInfo(Weather beijing2ndDayWeather, JSONObject beijingWeatherJSON) {
        beijing2ndDayWeather.setUpdateTime(beijingWeatherJSON.getObject("updateTime", ZonedDateTime.class));
        beijing2ndDayWeather.setCityName("北京");
        beijing2ndDayWeather.setFxDate((Date) beijingWeatherJSON.getJSONArray("daily").getJSONObject(1).getSqlDate("fxDate"));
        beijing2ndDayWeather.setTempMax(beijingWeatherJSON.getJSONArray("daily").getJSONObject(1).getInteger("tempMax"));
        beijing2ndDayWeather.setTempMin(beijingWeatherJSON.getJSONArray("daily").getJSONObject(1).getInteger("tempMin"));
        beijing2ndDayWeather.setTextDay(beijingWeatherJSON.getJSONArray("daily").getJSONObject(1).getString("textDay"));
    }

    public void setBeijing3rdDayWeatherInfo(Weather beijing3rdDayWeather, JSONObject beijingWeatherJSON) {
        beijing3rdDayWeather.setUpdateTime(beijingWeatherJSON.getObject("updateTime", ZonedDateTime.class));
        beijing3rdDayWeather.setCityName("北京");
        beijing3rdDayWeather.setFxDate((Date) beijingWeatherJSON.getJSONArray("daily").getJSONObject(2).getSqlDate("fxDate"));
        beijing3rdDayWeather.setTempMax(beijingWeatherJSON.getJSONArray("daily").getJSONObject(2).getInteger("tempMax"));
        beijing3rdDayWeather.setTempMin(beijingWeatherJSON.getJSONArray("daily").getJSONObject(2).getInteger("tempMin"));
        beijing3rdDayWeather.setTextDay(beijingWeatherJSON.getJSONArray("daily").getJSONObject(2).getString("textDay"));
    }
}
