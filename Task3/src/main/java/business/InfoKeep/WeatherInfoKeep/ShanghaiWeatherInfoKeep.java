package business.InfoKeep.WeatherInfoKeep;

import com.alibaba.fastjson.JSONObject;

import business.InfoGet.WeatherInfoGet;
import business.InfoObjects.Weather;
import business.InfoSet.WeatherInfoSet.ShanghaiWeatherInfoSet;
import persistence.DBInit;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ShanghaiWeatherInfoKeep {
    String key = "2c835338eccf48fcba60c11c575c3e80";
    String shanghaiId = "101020100";

    DBInit dbInit = new DBInit();
    ShanghaiWeatherInfoSet shanghaiWeatherInfoSet = new ShanghaiWeatherInfoSet();
    WeatherInfoGet weatherInfoGet = new WeatherInfoGet();
    Weather shanghai1stDayWeather = new Weather();
    Weather shanghai2ndDayWeather = new Weather();
    Weather shanghai3rdDayWeather = new Weather();

    private JSONObject getShanghaiWeatherJSON(String key, String id) throws IOException {
        return JSONObject.parseObject(weatherInfoGet.getWeatherInfo(key, id));
    }

    private void keepShanghai1stDayWeatherInfo(JSONObject shanghaiWeatherJSON) {
        shanghaiWeatherInfoSet.setShanghai1stDayWeatherInfo(shanghai1stDayWeather, shanghaiWeatherJSON);

        Connection conn = null;
        PreparedStatement pstmt = null;

        String insertShanghai1stDayWeatherInfo = "INSERT INTO `shanghaiweatherinfo` (updateTime, city_name, fxDate, tempMax, tempMin, textDay) VALUES (?, ?, ?, ?, ?, ?);";

        try{
            conn = dbInit.getConnection();
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(true);

            pstmt = conn.prepareStatement(insertShanghai1stDayWeatherInfo);
            pstmt.setObject(1, shanghai1stDayWeather.getUpdateTime());
            pstmt.setString(2, shanghai1stDayWeather.getCityName());
            pstmt.setDate(3, shanghai1stDayWeather.getFxDate());
            pstmt.setInt(4, shanghai1stDayWeather.getTempMax());
            pstmt.setInt(5, shanghai1stDayWeather.getTempMin());
            pstmt.setString(6, shanghai1stDayWeather.getTextDay());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbInit.closePreparedStatement(pstmt);
            dbInit.closeConnection(conn);
        }
    }

    private void keepShanghai2ndDayWeatherInfo(JSONObject shanghaiWeatherJSON) {
        shanghaiWeatherInfoSet.setShanghai2ndDayWeatherInfo(shanghai2ndDayWeather, shanghaiWeatherJSON);

        Connection conn = null;
        PreparedStatement pstmt = null;

        String insertShanghai2ndDayWeatherInfo = "INSERT INTO `shanghaiweatherinfo` (updateTime, city_name, fxDate, tempMax, tempMin, textDay) VALUES (?, ?, ?, ?, ?, ?);";

        try{
            conn = dbInit.getConnection();
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(true);

            pstmt = conn.prepareStatement(insertShanghai2ndDayWeatherInfo);
            pstmt.setObject(1, shanghai2ndDayWeather.getUpdateTime());
            pstmt.setString(2, shanghai2ndDayWeather.getCityName());
            pstmt.setDate(3, shanghai2ndDayWeather.getFxDate());
            pstmt.setInt(4, shanghai2ndDayWeather.getTempMax());
            pstmt.setInt(5, shanghai2ndDayWeather.getTempMin());
            pstmt.setString(6, shanghai2ndDayWeather.getTextDay());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbInit.closePreparedStatement(pstmt);
            dbInit.closeConnection(conn);
        }
    }

    private void keepShanghai3rdDayWeatherInfo(JSONObject shanghaiWeatherJSON) {
        shanghaiWeatherInfoSet.setShanghai3rdDayWeatherInfo(shanghai3rdDayWeather, shanghaiWeatherJSON);

        Connection conn = null;
        PreparedStatement pstmt = null;

        String insertShanghai3rdDayWeatherInfo = "INSERT INTO `shanghaiweatherinfo` (updateTime, city_name, fxDate, tempMax, tempMin, textDay) VALUES (?, ?, ?, ?, ?, ?);";

        try{
            conn = dbInit.getConnection();
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(true);

            pstmt = conn.prepareStatement(insertShanghai3rdDayWeatherInfo);
            pstmt.setObject(1, shanghai3rdDayWeather.getUpdateTime());
            pstmt.setString(2, shanghai3rdDayWeather.getCityName());
            pstmt.setDate(3, shanghai3rdDayWeather.getFxDate());
            pstmt.setInt(4, shanghai3rdDayWeather.getTempMax());
            pstmt.setInt(5, shanghai3rdDayWeather.getTempMin());
            pstmt.setString(6, shanghai3rdDayWeather.getTextDay());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbInit.closePreparedStatement(pstmt);
            dbInit.closeConnection(conn);
        }
    }

    public void keepShanghaiWeatherInfo() throws IOException {
        JSONObject shanghaiWeatherJSON = getShanghaiWeatherJSON(key, shanghaiId);
        keepShanghai1stDayWeatherInfo(shanghaiWeatherJSON);
        keepShanghai2ndDayWeatherInfo(shanghaiWeatherJSON);
        keepShanghai3rdDayWeatherInfo(shanghaiWeatherJSON);
    }
}
