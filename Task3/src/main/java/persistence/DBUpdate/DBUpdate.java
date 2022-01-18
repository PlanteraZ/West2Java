package persistence.DBUpdate;

import java.io.IOException;

//用于更新MySQL Database数据库中的数据
public class DBUpdate {
    public void update() throws IOException {
        new BeijingWeatherInfoUpdate().updateBeijingWeatherInfo();
        new ShanghaiWeatherInfoUpdate().updateShanghaiWeatherInfo();
        new FuzhouWeatherInfoUpdate().updateFuzhouWeatherInfo();
        System.out.println("数据更新操作已完成");
    }
}
