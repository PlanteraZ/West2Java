package persistence;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;

import business.InfoKeep.CityInfoKeep.BeijingCityInfoKeep;
import business.InfoKeep.CityInfoKeep.FuzhouCityInfoKeep;
import business.InfoKeep.CityInfoKeep.ShanghaiCityInfoKeep;
import business.InfoKeep.WeatherInfoKeep.BeijingWeatherInfoKeep;
import business.InfoKeep.WeatherInfoKeep.FuzhouWeatherInfoKeep;
import business.InfoKeep.WeatherInfoKeep.ShanghaiWeatherInfoKeep;

//构建MySQL Database(创建表格，建立主键、外键约束和索引，初始化数据)
public class DBBuild {
    DBInit dbInit = new DBInit();
    /*
     * 创建表格
     * @return void
     */
    public void createTables() {
        //建立城市信息表格
        String createCityInfoTable = "CREATE TABLE IF NOT EXISTS `cityinfo`" +
                "(" +
                "`city_id` CHAR(10)," +
                "`city_name` CHAR(5)," +
                "`longitude` FLOAT," +
                "`latitude` FLOAT," +
                "PRIMARY KEY (`city_name`)" +
                ")ENGINE=InnoDB DEFAULT CHARSET=utf8;";
        //建立北京天气信息表格
        String createBeijingWeatherInfoTable = "CREATE TABLE IF NOT EXISTS `beijingweatherinfo`" +
                "(" +
                "`updateTime` DATETIME," +
                "`city_name` CHAR(5)," +
                "`fxDate` DATE," +
                "`tempMax` INT," +
                "`tempMin` INT," +
                "`textDay` CHAR(5)," +
                "PRIMARY KEY (`fxDate`)" +
                ")ENGINE=InnoDB DEFAULT CHARSET=utf8;";
        //建立上海天气信息表格
        String createShanghaiWeatherInfoTable = "CREATE TABLE IF NOT EXISTS `shanghaiweatherinfo`" +
                "(" +
                "`updateTime` DATETIME," +
                "`city_name` CHAR(5)," +
                "`fxDate` DATE," +
                "`tempMax` INT," +
                "`tempMin` INT," +
                "`textDay` CHAR(5)," +
                "PRIMARY KEY (`fxDate`)" +
                ")ENGINE=InnoDB DEFAULT CHARSET=utf8;";
        //建立福州天气信息表格
        String createFuzhouWeatherInfoTable = "CREATE TABLE IF NOT EXISTS `fuzhouweatherinfo`" +
                "(" +
                "`updateTime` DATETIME," +
                "`city_name` CHAR(5)," +
                "`fxDate` DATE," +
                "`tempMax` INT," +
                "`tempMin` INT," +
                "`textDay` CHAR(5)," +
                "PRIMARY KEY (`fxDate`)" +
                ")ENGINE=InnoDB DEFAULT CHARSET=utf8;";
        Connection conn = null;
        Statement stmt = null;
        try {
            //开启事务，设置隔离级别，禁止自动提交
            conn = dbInit.getConnection();
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(false);

            stmt = conn.createStatement();
            stmt.addBatch(createCityInfoTable);
            stmt.addBatch(createBeijingWeatherInfoTable);
            stmt.addBatch(createShanghaiWeatherInfoTable);
            stmt.addBatch(createFuzhouWeatherInfoTable);
            stmt.executeBatch();
            conn.commit();  //执行成功，提交事务
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            if(conn != null) {
                try {
                    conn.rollback();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            System.out.println("出现异常，该事务已回滚！");
        } finally {
            dbInit.closeStatement(stmt);
            dbInit.closeConnection(conn);
        }
    }

    /*
     * 添加索引
     * @return void
     */
    public void addIndexes() {
        String addCityInfoIndex = "ALTER TABLE `CityInfo`" +
                "ADD UNIQUE INDEX `uni_city_name` (city_name);";
        String addBeijingCityNameIndex = "ALTER TABLE `BeijingWeatherInfo`" +
                "ADD INDEX `idx_beijing_name` (city_name)";
        String addShanghaiCityNameIndex = "ALTER TABLE `ShanghaiWeatherInfo`" +
                "ADD INDEX `idx_shanghai_name` (city_name);";
        String addFuzhouCityNameIndex = "ALTER TABLE `FuzhouWeatherInfo`" +
                "ADD INDEX `idx_fuzhou_name` (city_name);";
        String addBeijingDateIndex = "ALTER TABLE `BeijingWeatherInfo`" +
                "ADD INDEX `idx_beijing_date` (fxDate);";
        String addShanghaiDateIndex = "ALTER TABLE `ShanghaiWeatherInfo`" +
                "ADD INDEX `idx_shanghai_date` (fxDate);";
        String addFuzhouDateIndex = "ALTER TABLE `FuzhouWeatherInfo`" +
                "ADD INDEX `idx_fuzhou_date` (fxDate);";
        Connection conn = null;
        Statement stmt = null;
        try {
            //开启事务，设置隔离级别，禁止自动提交
            conn = dbInit.getConnection();
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(false);

            stmt = conn.createStatement();
            stmt.addBatch(addCityInfoIndex);
            stmt.addBatch(addBeijingCityNameIndex);
            stmt.addBatch(addShanghaiCityNameIndex);
            stmt.addBatch(addFuzhouCityNameIndex);
            stmt.addBatch(addBeijingDateIndex);
            stmt.addBatch(addShanghaiDateIndex);
            stmt.addBatch(addFuzhouDateIndex);
            stmt.executeBatch();
            conn.commit();  //执行成功，提交事务
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            if(conn != null) {
                try {
                    conn.rollback();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            System.out.println("出现异常，该事务已回滚！");
        } finally {
            dbInit.closeStatement(stmt);
            dbInit.closeConnection(conn);
        }
    }

    /*
     * 定义外键约束
     * @return void
     */
    public void addForeignKeys() {
        String addBeijingForeignKey = "ALTER TABLE `BeijingWeatherInfo`" +
                "ADD CONSTRAINT `fk_beijing_name`" +
                "FOREIGN KEY (city_name)" +
                "REFERENCES cityinfo (city_name);";
        String addShanghaiForeignKey = "ALTER TABLE `ShanghaiWeatherInfo`" +
                "ADD CONSTRAINT `fk_shanghai_name`" +
                "FOREIGN KEY (city_name)" +
                "REFERENCES cityinfo (city_name);";
        String addFuzhouForeignKey = "ALTER TABLE `FuzhouWeatherInfo`" +
                "ADD CONSTRAINT `fk_fuzhou_name`" +
                "FOREIGN KEY (city_name)" +
                "REFERENCES cityinfo (city_name);";
        Connection conn = null;
        Statement stmt = null;
        try {
            //开启事务，设置隔离级别，禁止自动提交
            conn = dbInit.getConnection();
            conn.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            conn.setAutoCommit(false);

            stmt = conn.createStatement();
            stmt.addBatch(addBeijingForeignKey);
            stmt.addBatch(addShanghaiForeignKey);
            stmt.addBatch(addFuzhouForeignKey);
            stmt.executeBatch();
            conn.commit();  //执行成功，提交事务
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            if(conn != null) {
                try {
                    conn.rollback();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            System.out.println("出现异常，该事务已回滚！");
        } finally {
            dbInit.closeStatement(stmt);
            dbInit.closeConnection(conn);
        }
    }

    public void build() throws IOException {
        createTables();
        addIndexes();
        addForeignKeys();
        new BeijingCityInfoKeep().keepBeijingCityInfo();
        new BeijingWeatherInfoKeep().keepBeijingWeatherInfo();
        new ShanghaiCityInfoKeep().keepShanghaiCityInfo();
        new ShanghaiWeatherInfoKeep().keepShanghaiWeatherInfo();
        new FuzhouCityInfoKeep().keepFuzhouCityInfo();
        new FuzhouWeatherInfoKeep().keepFuzhouWeatherInfo();
    }
}
