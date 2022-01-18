package persistence.DBUpdate;

import com.alibaba.fastjson.JSONObject;

import business.InfoGet.WeatherInfoGet;
import business.InfoObjects.Weather;
import business.InfoSet.WeatherInfoSet.ShanghaiWeatherInfoSet;
import persistence.DBInit;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ShanghaiWeatherInfoUpdate {
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

    private void updateShanghai1stDayWeatherInfo(JSONObject shanghaiWeatherJSON) {
        shanghaiWeatherInfoSet.setShanghai1stDayWeatherInfo(shanghai1stDayWeather, shanghaiWeatherJSON);

        Connection conn = null;
        PreparedStatement pstmt = null;

        String updateShanghai1stDayWeatherInfo = "INSERT INTO shanghaiweatherinfo (updateTime, city_name, fxDate, tempMax, tempMin, textDay) " +
                "VALUES (?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE updateTime = ?, tempMax = ?, tempMin = ?, textDay = ?;";

        try {
            conn = dbInit.getConnection();
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(true);

            pstmt = conn.prepareStatement(updateShanghai1stDayWeatherInfo);
            pstmt.setObject(1, shanghai1stDayWeather.getUpdateTime());
            pstmt.setString(2, shanghai1stDayWeather.getCityName());
            pstmt.setDate(3, shanghai1stDayWeather.getFxDate());
            pstmt.setInt(4, shanghai1stDayWeather.getTempMax());
            pstmt.setInt(5, shanghai1stDayWeather.getTempMin());
            pstmt.setString(6, shanghai1stDayWeather.getTextDay());
            pstmt.setObject(7, shanghai1stDayWeather.getUpdateTime());
            pstmt.setInt(8, shanghai1stDayWeather.getTempMax());
            pstmt.setInt(9, shanghai1stDayWeather.getTempMin());
            pstmt.setString(10, shanghai1stDayWeather.getTextDay());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbInit.closePreparedStatement(pstmt);
            dbInit.closeConnection(conn);
        }
    }

    private void updateShanghai2ndDayWeatherInfo(JSONObject shanghaiWeatherJSON) {
        shanghaiWeatherInfoSet.setShanghai2ndDayWeatherInfo(shanghai2ndDayWeather, shanghaiWeatherJSON);

        Connection conn = null;
        PreparedStatement pstmt = null;

        String updateShanghai2ndDayWeatherInfo = "INSERT INTO shanghaiweatherinfo (updateTime, city_name, fxDate, tempMax, tempMin, textDay) " +
                "VALUES (?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE updateTime = ?, tempMax = ?, tempMin = ?, textDay = ?;";

        try {
            conn = dbInit.getConnection();
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(true);

            pstmt = conn.prepareStatement(updateShanghai2ndDayWeatherInfo);
            pstmt.setObject(1, shanghai2ndDayWeather.getUpdateTime());
            pstmt.setString(2, shanghai2ndDayWeather.getCityName());
            pstmt.setDate(3, shanghai2ndDayWeather.getFxDate());
            pstmt.setInt(4, shanghai2ndDayWeather.getTempMax());
            pstmt.setInt(5, shanghai2ndDayWeather.getTempMin());
            pstmt.setString(6, shanghai2ndDayWeather.getTextDay());
            pstmt.setObject(7, shanghai2ndDayWeather.getUpdateTime());
            pstmt.setInt(8, shanghai2ndDayWeather.getTempMax());
            pstmt.setInt(9, shanghai2ndDayWeather.getTempMin());
            pstmt.setString(10, shanghai2ndDayWeather.getTextDay());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbInit.closePreparedStatement(pstmt);
            dbInit.closeConnection(conn);
        }
    }

    private void updateShanghai3rdDayWeatherInfo(JSONObject shanghaiWeatherJSON) {
        shanghaiWeatherInfoSet.setShanghai3rdDayWeatherInfo(shanghai3rdDayWeather, shanghaiWeatherJSON);

        Connection conn = null;
        PreparedStatement pstmt = null;

        String updateShanghai3rdDayWeatherInfo = "INSERT INTO shanghaiweatherinfo (updateTime, city_name, fxDate, tempMax, tempMin, textDay) " +
                "VALUES (?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE updateTime = ?, tempMax = ?, tempMin = ?, textDay = ?;";

        try {
            conn = dbInit.getConnection();
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(true);

            pstmt = conn.prepareStatement(updateShanghai3rdDayWeatherInfo);
            pstmt.setObject(1, shanghai3rdDayWeather.getUpdateTime());
            pstmt.setString(2, shanghai3rdDayWeather.getCityName());
            pstmt.setDate(3, shanghai3rdDayWeather.getFxDate());
            pstmt.setInt(4, shanghai3rdDayWeather.getTempMax());
            pstmt.setInt(5, shanghai3rdDayWeather.getTempMin());
            pstmt.setString(6, shanghai3rdDayWeather.getTextDay());
            pstmt.setObject(7, shanghai3rdDayWeather.getUpdateTime());
            pstmt.setInt(8, shanghai3rdDayWeather.getTempMax());
            pstmt.setInt(9, shanghai3rdDayWeather.getTempMin());
            pstmt.setString(10, shanghai3rdDayWeather.getTextDay());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbInit.closePreparedStatement(pstmt);
            dbInit.closeConnection(conn);
        }
    }

    public void updateShanghaiWeatherInfo() throws IOException {
        JSONObject shanghaiWeatherJSON = getShanghaiWeatherJSON(key, shanghaiId);
        updateShanghai1stDayWeatherInfo(shanghaiWeatherJSON);
        updateShanghai2ndDayWeatherInfo(shanghaiWeatherJSON);
        updateShanghai3rdDayWeatherInfo(shanghaiWeatherJSON);
    }
}
