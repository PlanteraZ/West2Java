package business.InfoSet.WeatherInfoSet;

import com.alibaba.fastjson.JSONObject;

import java.sql.Date;
import java.time.ZonedDateTime;

import business.InfoObjects.Weather;

public class FuzhouWeatherInfoSet {
    public void setFuzhou1stDayWeatherInfo(Weather fuzhou1stDayWeather, JSONObject fuzhouWeatherJSON) {
        fuzhou1stDayWeather.setUpdateTime(fuzhouWeatherJSON.getObject("updateTime", ZonedDateTime.class));
        fuzhou1stDayWeather.setCityName("福州");
        fuzhou1stDayWeather.setFxDate((Date) fuzhouWeatherJSON.getJSONArray("daily").getJSONObject(0).getSqlDate("fxDate"));
        fuzhou1stDayWeather.setTempMax(fuzhouWeatherJSON.getJSONArray("daily").getJSONObject(0).getInteger("tempMax"));
        fuzhou1stDayWeather.setTempMin(fuzhouWeatherJSON.getJSONArray("daily").getJSONObject(0).getInteger("tempMin"));
        fuzhou1stDayWeather.setTextDay(fuzhouWeatherJSON.getJSONArray("daily").getJSONObject(0).getString("textDay"));
    }

    public void setFuzhou2ndDayWeatherInfo(Weather fuzhou2ndDayWeather, JSONObject fuzhouWeatherJSON) {
        fuzhou2ndDayWeather.setUpdateTime(fuzhouWeatherJSON.getObject("updateTime", ZonedDateTime.class));
        fuzhou2ndDayWeather.setCityName("福州");
        fuzhou2ndDayWeather.setFxDate((Date) fuzhouWeatherJSON.getJSONArray("daily").getJSONObject(1).getSqlDate("fxDate"));
        fuzhou2ndDayWeather.setTempMax(fuzhouWeatherJSON.getJSONArray("daily").getJSONObject(1).getInteger("tempMax"));
        fuzhou2ndDayWeather.setTempMin(fuzhouWeatherJSON.getJSONArray("daily").getJSONObject(1).getInteger("tempMin"));
        fuzhou2ndDayWeather.setTextDay(fuzhouWeatherJSON.getJSONArray("daily").getJSONObject(1).getString("textDay"));
    }

    public void setFuzhou3rdDayWeatherInfo(Weather fuzhou3rdDayWeather, JSONObject fuzhouWeatherJSON) {
        fuzhou3rdDayWeather.setUpdateTime(fuzhouWeatherJSON.getObject("updateTime", ZonedDateTime.class));
        fuzhou3rdDayWeather.setCityName("福州");
        fuzhou3rdDayWeather.setFxDate((Date) fuzhouWeatherJSON.getJSONArray("daily").getJSONObject(2).getSqlDate("fxDate"));
        fuzhou3rdDayWeather.setTempMax(fuzhouWeatherJSON.getJSONArray("daily").getJSONObject(2).getInteger("tempMax"));
        fuzhou3rdDayWeather.setTempMin(fuzhouWeatherJSON.getJSONArray("daily").getJSONObject(2).getInteger("tempMin"));
        fuzhou3rdDayWeather.setTextDay(fuzhouWeatherJSON.getJSONArray("daily").getJSONObject(2).getString("textDay"));
    }
}
