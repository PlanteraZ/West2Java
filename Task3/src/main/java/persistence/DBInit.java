package persistence;

import org.apache.commons.dbutils.DbUtils;

import java.sql.*;

//JDBC基础操作
public class DBInit {
    /*
     * 取得数据库的连接
     * @return Connection
     */
    public Connection getConnection() {
        //驱动程序名
        String driver = "com.mysql.cj.jdbc.Driver";
        //URL指向要访问的数据库名
        String url = "jdbc:mysql://127.0.0.1:3306/weathersystem?characterEncoding=UTF-8";
        //MySQL配置时的用户名
        String user = "root";
        //连接MySQL配置时的密码
        String password = "01234567890/Zz!";

        Connection conn = null;
        try {
            //初始化驱动类
            DbUtils.loadDriver(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return conn;
    }

    /*
     * 封装关闭方法
     * @return void
     */
    public void closePreparedStatement(PreparedStatement pstmt) {
        if(pstmt != null) {  //避免出现空指针异常
            try {
                pstmt.close();
            } catch(SQLException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }

    public void closeStatement(Statement stmt) {
        if(stmt != null) {  //避免出现空指针异常
            try {
                stmt.close();
            } catch(SQLException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }

    public void closeConnection(Connection conn) {
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }

    public void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }
}
