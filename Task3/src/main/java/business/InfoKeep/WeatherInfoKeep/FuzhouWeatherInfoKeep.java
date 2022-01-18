package business.InfoKeep.WeatherInfoKeep;

import com.alibaba.fastjson.JSONObject;

import business.InfoGet.WeatherInfoGet;
import business.InfoObjects.Weather;
import business.InfoSet.WeatherInfoSet.FuzhouWeatherInfoSet;
import persistence.DBInit;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class FuzhouWeatherInfoKeep {
    String key = "2c835338eccf48fcba60c11c575c3e80";
    String fuzhouId = "101230101";

    DBInit dbInit = new DBInit();
    FuzhouWeatherInfoSet fuzhouWeatherInfoSet = new FuzhouWeatherInfoSet();
    WeatherInfoGet weatherInfoGet = new WeatherInfoGet();
    Weather fuzhou1stDayWeather = new Weather();
    Weather fuzhou2ndDayWeather = new Weather();
    Weather fuzhou3rdDayWeather = new Weather();

    private JSONObject getFuzhouWeatherJSON(String key, String id) throws IOException {
        return JSONObject.parseObject(weatherInfoGet.getWeatherInfo(key, id));
    }

    private void keepFuzhou1stDayWeatherInfo(JSONObject fuzhouWeatherJSON) {
        fuzhouWeatherInfoSet.setFuzhou1stDayWeatherInfo(fuzhou1stDayWeather, fuzhouWeatherJSON);

        Connection conn = null;
        PreparedStatement pstmt = null;

        String insertFuzhou1stDayWeatherInfo = "INSERT INTO `fuzhouweatherinfo` (updateTime, city_name, fxDate, tempMax, tempMin, textDay) VALUES (?, ?, ?, ?, ?, ?);";

        try{
            conn = dbInit.getConnection();
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(true);

            pstmt = conn.prepareStatement(insertFuzhou1stDayWeatherInfo);
            pstmt.setObject(1, fuzhou1stDayWeather.getUpdateTime());
            pstmt.setString(2, fuzhou1stDayWeather.getCityName());
            pstmt.setDate(3, fuzhou1stDayWeather.getFxDate());
            pstmt.setInt(4, fuzhou1stDayWeather.getTempMax());
            pstmt.setInt(5, fuzhou1stDayWeather.getTempMin());
            pstmt.setString(6, fuzhou1stDayWeather.getTextDay());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbInit.closePreparedStatement(pstmt);
            dbInit.closeConnection(conn);
        }
    }

    private void keepFuzhou2ndDayWeatherInfo(JSONObject fuzhouWeatherJSON) {
        fuzhouWeatherInfoSet.setFuzhou2ndDayWeatherInfo(fuzhou2ndDayWeather, fuzhouWeatherJSON);

        Connection conn = null;
        PreparedStatement pstmt = null;

        String insertFuzhou2ndDayWeatherInfo = "INSERT INTO `fuzhouweatherinfo` (updateTime, city_name, fxDate, tempMax, tempMin, textDay) VALUES (?, ?, ?, ?, ?, ?);";

        try{
            conn = dbInit.getConnection();
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(true);

            pstmt = conn.prepareStatement(insertFuzhou2ndDayWeatherInfo);
            pstmt.setObject(1, fuzhou2ndDayWeather.getUpdateTime());
            pstmt.setString(2, fuzhou2ndDayWeather.getCityName());
            pstmt.setDate(3, fuzhou2ndDayWeather.getFxDate());
            pstmt.setInt(4, fuzhou2ndDayWeather.getTempMax());
            pstmt.setInt(5, fuzhou2ndDayWeather.getTempMin());
            pstmt.setString(6, fuzhou2ndDayWeather.getTextDay());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbInit.closePreparedStatement(pstmt);
            dbInit.closeConnection(conn);
        }
    }

    private void keepFuzhou3rdDayWeatherInfo(JSONObject fuzhouWeatherJSON) {
        fuzhouWeatherInfoSet.setFuzhou3rdDayWeatherInfo(fuzhou3rdDayWeather, fuzhouWeatherJSON);

        Connection conn = null;
        PreparedStatement pstmt = null;

        String insertBeijing3rdWeatherInfo = "INSERT INTO `fuzhouweatherinfo` (updateTime, city_name, fxDate, tempMax, tempMin, textDay) VALUES (?, ?, ?, ?, ?, ?);";

        try{
            conn = dbInit.getConnection();
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(true);

            pstmt = conn.prepareStatement(insertBeijing3rdWeatherInfo);
            pstmt.setObject(1, fuzhou3rdDayWeather.getUpdateTime());
            pstmt.setString(2, fuzhou3rdDayWeather.getCityName());
            pstmt.setDate(3, fuzhou3rdDayWeather.getFxDate());
            pstmt.setInt(4, fuzhou3rdDayWeather.getTempMax());
            pstmt.setInt(5, fuzhou3rdDayWeather.getTempMin());
            pstmt.setString(6, fuzhou3rdDayWeather.getTextDay());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbInit.closePreparedStatement(pstmt);
            dbInit.closeConnection(conn);
        }
    }

    public void keepFuzhouWeatherInfo() throws IOException {
        JSONObject fuzhouWeatherJSON = getFuzhouWeatherJSON(key, fuzhouId);
        keepFuzhou1stDayWeatherInfo(fuzhouWeatherJSON);
        keepFuzhou2ndDayWeatherInfo(fuzhouWeatherJSON);
        keepFuzhou3rdDayWeatherInfo(fuzhouWeatherJSON);
    }
}
