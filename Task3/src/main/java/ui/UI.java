package ui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import business.InfoObjects.City;
import persistence.DBQuery.CityInfoQuery;
import persistence.DBQuery.WeatherInfoQuery.WeatherInfoQuery;
import persistence.DBUpdate.DBUpdate;

public class UI {
    public static void go() {
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("1.查询城市信息\t2.查询未来三日天气信息\t3.更新数据\t4.退出系统");
            System.out.println("请输入要进行的操作：");
            int choice = in.nextInt();
            switch (choice) {
                case 1: {
                    System.out.println("请输入要查询的城市名字(北京、上海、福州)：");
                    String cityName = in.next();
                    try {
                        City queryCity = new CityInfoQuery().queryCityInfo(cityName);
                        System.out.println("查询结果如下：");
                        System.out.println("城市名字：" + queryCity.getName() + ", 城市id：" + queryCity.getId() +
                                ", 城市经度：" + queryCity.getLongitude() + ", 城市纬度：" + queryCity.getLatitude());
                    } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println("查询出错！请联系系统管理人员！");
                    }
                    break;
                }
                case 2: {
                    System.out.println("请输入要查询哪个城市的天气(北京、上海、福州)：");
                    String cityName = in.next();
                    new WeatherInfoQuery().queryWeatherInfo(cityName);
                    break;
                }
                case 3: {
                    try {
                        new DBUpdate().update();
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("更新数据出错！请联系系统管理人员！");
                    }
                    break;
                }
                case 4: {
                    return;
                }
                default: {
                    System.out.println("请输入正确的选项！");
                    break;
                }
            }
        }
    }
}
