package persistence.DBUpdate;

import com.alibaba.fastjson.JSONObject;

import business.InfoGet.WeatherInfoGet;
import business.InfoObjects.Weather;
import business.InfoSet.WeatherInfoSet.BeijingWeatherInfoSet;
import persistence.DBInit;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class BeijingWeatherInfoUpdate {
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

    //如果我们希望插入一条新记录（INSERT），但如果记录已经存在，就更新该记录，此时，可以使用INSERT INTO ... ON DUPLICATE KEY UPDATE ...语句：
    //INSERT INTO students (id, class_id, name, gender, score) VALUES (1, 1, '小明', 'F', 99) ON DUPLICATE KEY UPDATE name='小明', gender='F', score=99;
    //若id=1的记录不存在，INSERT语句将插入新记录，否则，当前id=1的记录将被更新，更新的字段由UPDATE指定。
    private void updateBeijing1stDayWeatherInfo(JSONObject beijingWeatherJSON) {
        beijingWeatherInfoSet.setBeijing1stDayWeatherInfo(beijing1stDayWeather, beijingWeatherJSON);

        Connection conn = null;
        PreparedStatement pstmt = null;

        String updateBeijing1stDayWeatherInfo = "INSERT INTO beijingweatherinfo (updateTime, city_name, fxDate, tempMax, tempMin, textDay) " +
                "VALUES (?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE updateTime = ?, tempMax = ?, tempMin = ?, textDay = ?;";

        try {
            conn = dbInit.getConnection();
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(true);

            pstmt = conn.prepareStatement(updateBeijing1stDayWeatherInfo);
            pstmt.setObject(1, beijing1stDayWeather.getUpdateTime());
            pstmt.setString(2, beijing1stDayWeather.getCityName());
            pstmt.setDate(3, beijing1stDayWeather.getFxDate());
            pstmt.setInt(4, beijing1stDayWeather.getTempMax());
            pstmt.setInt(5, beijing1stDayWeather.getTempMin());
            pstmt.setString(6, beijing1stDayWeather.getTextDay());
            pstmt.setObject(7, beijing1stDayWeather.getUpdateTime());
            pstmt.setInt(8, beijing1stDayWeather.getTempMax());
            pstmt.setInt(9, beijing1stDayWeather.getTempMin());
            pstmt.setString(10, beijing1stDayWeather.getTextDay());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbInit.closePreparedStatement(pstmt);
            dbInit.closeConnection(conn);
        }
    }

    private void updateBeijing2ndDayWeatherInfo(JSONObject beijingWeatherJSON) {
        beijingWeatherInfoSet.setBeijing2ndDayWeatherInfo(beijing2ndDayWeather, beijingWeatherJSON);

        Connection conn = null;
        PreparedStatement pstmt = null;

        String updateBeijing2ndDayWeatherInfo = "INSERT INTO beijingweatherinfo (updateTime, city_name, fxDate, tempMax, tempMin, textDay) " +
                "VALUES (?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE updateTime = ?, tempMax = ?, tempMin = ?, textDay = ?;";

        try {
            conn = dbInit.getConnection();
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(true);

            pstmt = conn.prepareStatement(updateBeijing2ndDayWeatherInfo);
            pstmt.setObject(1, beijing2ndDayWeather.getUpdateTime());
            pstmt.setString(2, beijing2ndDayWeather.getCityName());
            pstmt.setDate(3, beijing2ndDayWeather.getFxDate());
            pstmt.setInt(4, beijing2ndDayWeather.getTempMax());
            pstmt.setInt(5, beijing2ndDayWeather.getTempMin());
            pstmt.setString(6, beijing2ndDayWeather.getTextDay());
            pstmt.setObject(7, beijing2ndDayWeather.getUpdateTime());
            pstmt.setInt(8, beijing2ndDayWeather.getTempMax());
            pstmt.setInt(9, beijing2ndDayWeather.getTempMin());
            pstmt.setString(10, beijing2ndDayWeather.getTextDay());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbInit.closePreparedStatement(pstmt);
            dbInit.closeConnection(conn);
        }
    }

    private void updateBeijing3rdDayWeatherInfo(JSONObject beijingWeatherJSON) {
        beijingWeatherInfoSet.setBeijing3rdDayWeatherInfo(beijing3rdDayWeather, beijingWeatherJSON);

        Connection conn = null;
        PreparedStatement pstmt = null;

        String updateBeijing3rdDayWeatherInfo = "INSERT INTO beijingweatherinfo (updateTime, city_name, fxDate, tempMax, tempMin, textDay) " +
                "VALUES (?, ?, ?, ?, ?, ?) ON DUPLICATE KEY UPDATE updateTime = ?, tempMax = ?, tempMin = ?, textDay = ?;";

        try {
            conn = dbInit.getConnection();
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(true);

            pstmt = conn.prepareStatement(updateBeijing3rdDayWeatherInfo);
            pstmt.setObject(1, beijing3rdDayWeather.getUpdateTime());
            pstmt.setString(2, beijing3rdDayWeather.getCityName());
            pstmt.setDate(3, beijing3rdDayWeather.getFxDate());
            pstmt.setInt(4, beijing3rdDayWeather.getTempMax());
            pstmt.setInt(5, beijing3rdDayWeather.getTempMin());
            pstmt.setString(6, beijing3rdDayWeather.getTextDay());
            pstmt.setObject(7, beijing3rdDayWeather.getUpdateTime());
            pstmt.setInt(8, beijing3rdDayWeather.getTempMax());
            pstmt.setInt(9, beijing3rdDayWeather.getTempMin());
            pstmt.setString(10, beijing3rdDayWeather.getTextDay());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbInit.closePreparedStatement(pstmt);
            dbInit.closeConnection(conn);
        }
    }

    public void updateBeijingWeatherInfo() throws IOException {
        JSONObject beijingWeatherJSON = getBeijingWeatherJSON(key, beijingId);
        updateBeijing1stDayWeatherInfo(beijingWeatherJSON);
        updateBeijing2ndDayWeatherInfo(beijingWeatherJSON);
        updateBeijing3rdDayWeatherInfo(beijingWeatherJSON);
    }
}
