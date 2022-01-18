package business.InfoKeep.CityInfoKeep;

import com.alibaba.fastjson.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;

import business.InfoGet.CityInfoGet;
import business.InfoObjects.City;
import business.InfoSet.CityInfoSet.ShanghaiCityInfoSet;
import persistence.DBInit;

public class ShanghaiCityInfoKeep {
    DBInit dbInit = new DBInit();
    ShanghaiCityInfoSet shanghaiCityInfoSet = new ShanghaiCityInfoSet();
    CityInfoGet cityInfoGet = new CityInfoGet();
    City shanghai = new City();
    JSONObject shanghaiCityJSON = new JSONObject();

    public void keepShanghaiCityInfo() {
        shanghaiCityInfoSet.setShanghaiCityInfo(cityInfoGet, shanghai, shanghaiCityJSON);

        Connection conn = null;
        PreparedStatement pstmt = null;

        String insertBeijingCityInfo = "INSERT INTO `cityinfo` (city_id, city_name, longitude, latitude) VALUES (?, ?, ?, ?)";

        try{
            conn = dbInit.getConnection();
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(true);

            pstmt = conn.prepareStatement(insertBeijingCityInfo);
            pstmt.setString(1, shanghai.getId());
            pstmt.setString(2, shanghai.getName());
            pstmt.setFloat(3, shanghai.getLongitude());
            pstmt.setFloat(4, shanghai.getLatitude());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbInit.closePreparedStatement(pstmt);
            dbInit.closeConnection(conn);
        }
    }
}
