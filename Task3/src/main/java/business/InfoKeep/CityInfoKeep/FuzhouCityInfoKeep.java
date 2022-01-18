package business.InfoKeep.CityInfoKeep;

import business.InfoGet.CityInfoGet;
import business.InfoObjects.City;
import business.InfoSet.CityInfoSet.FuzhouCityInfoSet;
import com.alibaba.fastjson.JSONObject;
import persistence.DBInit;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class FuzhouCityInfoKeep {
    DBInit dbInit = new DBInit();
    FuzhouCityInfoSet fuzhouCityInfoSet = new FuzhouCityInfoSet();
    CityInfoGet cityInfoGet = new CityInfoGet();
    City fuzhou = new City();
    JSONObject fuzhouCityJSON = new JSONObject();

    public void keepFuzhouCityInfo() {
        fuzhouCityInfoSet.setFuzhouCityInfo(cityInfoGet, fuzhou, fuzhouCityJSON);

        Connection conn = null;
        PreparedStatement pstmt = null;

        String insertBeijingCityInfo = "INSERT INTO `cityinfo` (city_id, city_name, longitude, latitude) VALUES (?, ?, ?, ?)";

        try{
            conn = dbInit.getConnection();
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(true);

            pstmt = conn.prepareStatement(insertBeijingCityInfo);
            pstmt.setString(1, fuzhou.getId());
            pstmt.setString(2, fuzhou.getName());
            pstmt.setFloat(3, fuzhou.getLongitude());
            pstmt.setFloat(4, fuzhou.getLatitude());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbInit.closePreparedStatement(pstmt);
            dbInit.closeConnection(conn);
        }
    }
}
