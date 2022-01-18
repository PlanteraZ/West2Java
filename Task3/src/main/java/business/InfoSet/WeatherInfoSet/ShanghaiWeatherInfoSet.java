package business.InfoSet.WeatherInfoSet;

import com.alibaba.fastjson.JSONObject;

import java.sql.Date;
import java.time.ZonedDateTime;

import business.InfoObjects.Weather;

public class ShanghaiWeatherInfoSet {
    public void setShanghai1stDayWeatherInfo(Weather shanghai1stDayWeather, JSONObject shanghaiWeatherJSON) {
        shanghai1stDayWeather.setUpdateTime(shanghaiWeatherJSON.getObject("updateTime", ZonedDateTime.class));
        shanghai1stDayWeather.setCityName("上海");
        shanghai1stDayWeather.setFxDate((Date) shanghaiWeatherJSON.getJSONArray("daily").getJSONObject(0).getSqlDate("fxDate"));
        shanghai1stDayWeather.setTempMax(shanghaiWeatherJSON.getJSONArray("daily").getJSONObject(0).getInteger("tempMax"));
        shanghai1stDayWeather.setTempMin(shanghaiWeatherJSON.getJSONArray("daily").getJSONObject(0).getInteger("tempMin"));
        shanghai1stDayWeather.setTextDay(shanghaiWeatherJSON.getJSONArray("daily").getJSONObject(0).getString("textDay"));
    }

    public void setShanghai2ndDayWeatherInfo(Weather shanghai2ndDayWeather, JSONObject shanghaiWeatherJSON) {
        shanghai2ndDayWeather.setUpdateTime(shanghaiWeatherJSON.getObject("updateTime", ZonedDateTime.class));
        shanghai2ndDayWeather.setCityName("上海");
        shanghai2ndDayWeather.setFxDate((Date) shanghaiWeatherJSON.getJSONArray("daily").getJSONObject(1).getSqlDate("fxDate"));
        shanghai2ndDayWeather.setTempMax(shanghaiWeatherJSON.getJSONArray("daily").getJSONObject(1).getInteger("tempMax"));
        shanghai2ndDayWeather.setTempMin(shanghaiWeatherJSON.getJSONArray("daily").getJSONObject(1).getInteger("tempMin"));
        shanghai2ndDayWeather.setTextDay(shanghaiWeatherJSON.getJSONArray("daily").getJSONObject(1).getString("textDay"));
    }

    public void setShanghai3rdDayWeatherInfo(Weather shanghai3rdDayWeather, JSONObject shanghaiWeatherJSON) {
        shanghai3rdDayWeather.setUpdateTime(shanghaiWeatherJSON.getObject("updateTime", ZonedDateTime.class));
        shanghai3rdDayWeather.setCityName("上海");
        shanghai3rdDayWeather.setFxDate((Date) shanghaiWeatherJSON.getJSONArray("daily").getJSONObject(2).getSqlDate("fxDate"));
        shanghai3rdDayWeather.setTempMax(shanghaiWeatherJSON.getJSONArray("daily").getJSONObject(2).getInteger("tempMax"));
        shanghai3rdDayWeather.setTempMin(shanghaiWeatherJSON.getJSONArray("daily").getJSONObject(2).getInteger("tempMin"));
        shanghai3rdDayWeather.setTextDay(shanghaiWeatherJSON.getJSONArray("daily").getJSONObject(2).getString("textDay"));
    }
}
