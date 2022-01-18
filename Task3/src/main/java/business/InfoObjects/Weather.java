package business.InfoObjects;

import com.alibaba.fastjson.annotation.JSONField;

import java.time.ZonedDateTime;
import java.sql.Date;

public class Weather {
    @JSONField(name = "updateTime")
    private ZonedDateTime updateTime;

    @JSONField(name = "cityName")
    private String cityName;  //城市名字

    @JSONField(name = "fxDate")
    private Date fxDate;  //当日日期

    @JSONField(name = "tempMax")
    private int tempMax;  //当日最高气温

    @JSONField(name = "tempMin")
    private int tempMin;  //当日最低气温

    @JSONField(name = "textDay")
    private String textDay;  //白天天气情况

    //getter and setter
    public ZonedDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(ZonedDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getFxDate() {
        return fxDate;
    }

    public void setFxDate(Date fxDate) {
        this.fxDate = fxDate;
    }

    public int getTempMax() {
        return tempMax;
    }

    public void setTempMax(int tempMax) {
        this.tempMax = tempMax;
    }

    public int getTempMin() {
        return tempMin;
    }

    public void setTempMin(int tempMin) {
        this.tempMin = tempMin;
    }

    public String getTextDay() {
        return textDay;
    }

    public void setTextDay(String textDay) {
        this.textDay = textDay;
    }
}
