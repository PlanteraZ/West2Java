package business.InfoKeep.CityInfoKeep;

import com.alibaba.fastjson.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;

import business.InfoGet.CityInfoGet;
import business.InfoObjects.City;
import business.InfoSet.CityInfoSet.BeijingCityInfoSet;
import persistence.DBInit;

public class BeijingCityInfoKeep {
    DBInit dbInit = new DBInit();
    BeijingCityInfoSet beijingCityInfoSet = new BeijingCityInfoSet();
    CityInfoGet cityInfoGet = new CityInfoGet();
    City beijing = new City();
    JSONObject beijingCityJSON = new JSONObject();

    public void keepBeijingCityInfo() {
        beijingCityInfoSet.setBeijingCityInfo(cityInfoGet, beijing, beijingCityJSON);

        Connection conn = null;
        PreparedStatement pstmt = null;

        String insertBeijingCityInfo = "INSERT INTO `cityinfo` (city_id, city_name, longitude, latitude) VALUES (?, ?, ?, ?)";

        try{
            conn = dbInit.getConnection();
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(true);

            pstmt = conn.prepareStatement(insertBeijingCityInfo);
            pstmt.setString(1, beijing.getId());
            pstmt.setString(2, beijing.getName());
            pstmt.setFloat(3, beijing.getLongitude());
            pstmt.setFloat(4, beijing.getLatitude());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbInit.closePreparedStatement(pstmt);
            dbInit.closeConnection(conn);
        }
    }
}
