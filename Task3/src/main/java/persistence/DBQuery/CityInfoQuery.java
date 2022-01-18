package persistence.DBQuery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import business.InfoObjects.City;
import persistence.DBInit;

public class CityInfoQuery {
    DBInit dbInit = new DBInit();

    public City queryCityInfo(String cityName) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        City city = new City();

        String queryCityInfo = "SELECT * FROM cityinfo WHERE city_name = ?;";

        try {
            conn = dbInit.getConnection();
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(true);

            pstmt = conn.prepareStatement(queryCityInfo);
            pstmt.setString(1, cityName);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                String name = rs.getString("city_name");
                String id = rs.getString("city_id");
                float longitude = rs.getFloat("longitude");
                float latitude = rs.getFloat("latitude");

                city.setName(name);
                city.setId(id);
                city.setLongitude(longitude);
                city.setLatitude(latitude);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbInit.closeConnection(conn);
            dbInit.closePreparedStatement(pstmt);
            dbInit.closeResultSet(rs);
        }
        System.out.println("查询操作已完成");
        return city;
    }
}
