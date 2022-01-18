package business.InfoKeep.WeatherInfoKeep;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import business.InfoObjects.Weather;
import business.InfoGet.WeatherInfoGet;
import business.InfoSet.WeatherInfoSet.BeijingWeatherInfoSet;
import persistence.DBInit;

public class BeijingWeatherInfoKeep {
    String key = "2c835338eccf48fcba60c11c575c3e80";
    String beijingId = "101010100";

    DBInit dbInit = new DBInit();
    BeijingWeatherInfoSet beijingWeatherInfoSet = new BeijingWeatherInfoSet();
    WeatherInfoGet weatherInfoGet = new WeatherInfoGet();
    Weather beijing1stDayWeather = new Weather();
    Weather beijing2ndDayWeather = new Weather();
    Weather beijing3rdDayWeather = new Weather();

    private JSONObject getBeijingWeatherJSON(String key, String id) throws IOException {
        return JSONObject.parseObject(weatherInfoGet.getWeatherInfo(key, id));
    }

    private void keepBeijing1stDayWeatherInfo(JSONObject beijingWeatherJSON) {
        beijingWeatherInfoSet.setBeijing1stDayWeatherInfo(beijing1stDayWeather, beijingWeatherJSON);

        Connection conn = null;
        PreparedStatement pstmt = null;

        String insertBeijing1stDayWeatherInfo = "INSERT INTO " +
                "`beijingweatherinfo` (updateTime, city_name, fxDate, tempMax, tempMin, textDay) VALUES (?, ?, ?, ?, ?, ?);";

        try{
            conn = dbInit.getConnection();
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(true);

            pstmt = conn.prepareStatement(insertBeijing1stDayWeatherInfo);
            pstmt.setObject(1, beijing1stDayWeather.getUpdateTime());
            pstmt.setString(2, beijing1stDayWeather.getCityName());
            pstmt.setDate(3, beijing1stDayWeather.getFxDate());
            pstmt.setInt(4, beijing1stDayWeather.getTempMax());
            pstmt.setInt(5, beijing1stDayWeather.getTempMin());
            pstmt.setString(6, beijing1stDayWeather.getTextDay());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbInit.closePreparedStatement(pstmt);
            dbInit.closeConnection(conn);
        }
    }

    private void keepBeijing2ndDayWeatherInfo(JSONObject beijingWeatherJSON) {
        beijingWeatherInfoSet.setBeijing2ndDayWeatherInfo(beijing2ndDayWeather, beijingWeatherJSON);

        Connection conn = null;
        PreparedStatement pstmt = null;

        String insertBeijing2ndDayWeatherInfo = "INSERT INTO `beijingweatherinfo` (updateTime, city_name, fxDate, tempMax, tempMin, textDay) VALUES (?, ?, ?, ?, ?, ?);";

        try{
            conn = dbInit.getConnection();
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(true);

            pstmt = conn.prepareStatement(insertBeijing2ndDayWeatherInfo);
            pstmt.setObject(1, beijing2ndDayWeather.getUpdateTime());
            pstmt.setString(2, beijing2ndDayWeather.getCityName());
            pstmt.setDate(3, beijing2ndDayWeather.getFxDate());
            pstmt.setInt(4, beijing2ndDayWeather.getTempMax());
            pstmt.setInt(5, beijing2ndDayWeather.getTempMin());
            pstmt.setString(6, beijing2ndDayWeather.getTextDay());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbInit.closePreparedStatement(pstmt);
            dbInit.closeConnection(conn);
        }
    }

    private void keepBeijing3rdDayWeatherInfo(JSONObject beijingWeatherJSON) {
        beijingWeatherInfoSet.setBeijing3rdDayWeatherInfo(beijing3rdDayWeather, beijingWeatherJSON);

        Connection conn = null;
        PreparedStatement pstmt = null;

        String insertBeijing3rdWeatherInfo = "INSERT INTO `beijingweatherinfo` (updateTime, city_name, fxDate, tempMax, tempMin, textDay) VALUES (?, ?, ?, ?, ?, ?);";

        try{
            conn = dbInit.getConnection();
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(true);

            pstmt = conn.prepareStatement(insertBeijing3rdWeatherInfo);
            pstmt.setObject(1, beijing3rdDayWeather.getUpdateTime());
            pstmt.setString(2, beijing3rdDayWeather.getCityName());
            pstmt.setDate(3, beijing3rdDayWeather.getFxDate());
            pstmt.setInt(4, beijing3rdDayWeather.getTempMax());
            pstmt.setInt(5, beijing3rdDayWeather.getTempMin());
            pstmt.setString(6, beijing3rdDayWeather.getTextDay());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbInit.closePreparedStatement(pstmt);
            dbInit.closeConnection(conn);
        }
    }

    public void keepBeijingWeatherInfo() throws IOException {
        JSONObject beijingWeatherJSON = getBeijingWeatherJSON(key, beijingId);
        keepBeijing1stDayWeatherInfo(beijingWeatherJSON);
        keepBeijing2ndDayWeatherInfo(beijingWeatherJSON);
        keepBeijing3rdDayWeatherInfo(beijingWeatherJSON);
    }
}
