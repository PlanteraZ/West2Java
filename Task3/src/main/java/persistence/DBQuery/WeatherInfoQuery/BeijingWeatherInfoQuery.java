package persistence.DBQuery.WeatherInfoQuery;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import business.InfoObjects.Weather;
import persistence.DBInit;

public class BeijingWeatherInfoQuery {
    DBInit dbInit = new DBInit();

    public List<Weather> queryBeijingWeatherInfo() {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        List<Weather> weatherList = new ArrayList<>();

        String queryWeatherInfo = "SELECT * FROM beijingweatherinfo WHERE fxDate >= ?;";
        try {
            conn = dbInit.getConnection();
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(true);

            pstmt = conn.prepareStatement(queryWeatherInfo);
            pstmt.setDate(1, new CurrentDate().getCurrentDate());

            rs = pstmt.executeQuery();
            while (rs.next()){
                ZonedDateTime updateTime = rs.getObject("updateTime", ZonedDateTime.class);
                String cityName = rs.getString("city_name");
                Date fxDate = rs.getDate("fxDate");
                int tempMax = rs.getInt("tempMax");
                int tempMin = rs.getInt("tempMin");
                String textDay = rs.getString("textDay");
                //每个记录对应一个对象
                Weather weather = new Weather();
                weather.setUpdateTime(updateTime);
                weather.setCityName(cityName);
                weather.setFxDate(fxDate);
                weather.setTempMax(tempMax);
                weather.setTempMin(tempMin);
                weather.setTextDay(textDay);
                //将对象放到集合中
                weatherList.add(weather);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbInit.closeConnection(conn);
            dbInit.closePreparedStatement(pstmt);
            dbInit.closeResultSet(rs);
        }
        return weatherList;
    }
}
