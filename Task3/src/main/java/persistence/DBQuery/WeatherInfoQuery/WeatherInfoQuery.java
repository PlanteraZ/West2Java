package persistence.DBQuery.WeatherInfoQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import business.InfoObjects.Weather;

public class WeatherInfoQuery {
    List<Weather> queryWeatherList = new ArrayList<>();
    Weather firstDayWeather, secondDayWeather, thirdDayWeather;

    public void queryWeatherInfo(String cityName) {
        if(Objects.equals(cityName, "北京")) {
            queryWeatherList = new BeijingWeatherInfoQuery().queryBeijingWeatherInfo();
        } else if(Objects.equals(cityName, "上海")) {
            queryWeatherList = new ShanghaiWeatherInfoQuery().queryShanghaiWeatherInfo();
        } else if(Objects.equals(cityName, "福州")) {
            queryWeatherList = new FuzhouWeatherInfoQuery().queryFuzhouWeatherInfo();
        }

        firstDayWeather = queryWeatherList.get(0);
        secondDayWeather = queryWeatherList.get(1);
        thirdDayWeather = queryWeatherList.get(2);

        System.out.println("今天天气信息如下：");
        System.out.println("城市名字：" + firstDayWeather.getCityName() + ", 当天日期：" + firstDayWeather.getFxDate() +
                "\n最高温度：" + firstDayWeather.getTempMax() + ", 最低温度：" + firstDayWeather.getTempMin() +
                ", 数据更新时间：" + firstDayWeather.getUpdateTime());
        System.out.println("明天天气信息如下：");
        System.out.println("城市名字：" + secondDayWeather.getCityName() + ", 当天日期：" + secondDayWeather.getFxDate() +
                "\n最高温度：" + secondDayWeather.getTempMax() + ", 最低温度：" + secondDayWeather.getTempMin() +
                ", 数据更新时间：" + secondDayWeather.getUpdateTime());
        System.out.println("后天天气信息如下：");
        System.out.println("城市名字：" + thirdDayWeather.getCityName() + ", 当天日期：" + thirdDayWeather.getFxDate() +
                "\n最高温度：" + thirdDayWeather.getTempMax() + ", 最低温度：" + thirdDayWeather.getTempMin() +
                ", 数据更新时间：" + thirdDayWeather.getUpdateTime());
    }
}
