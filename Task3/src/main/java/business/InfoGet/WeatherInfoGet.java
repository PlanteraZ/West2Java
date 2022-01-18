package business.InfoGet;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class WeatherInfoGet {
    public String getWeatherInfo(String key, String cityId) throws IOException {
        String weatherQueryURL = "https://devapi.qweather.com/v7/weather/3d?key=" + key + "&location=" + cityId;
        //1.创建httpclient对象
        CloseableHttpClient client = HttpClients.createDefault();
        //2.创建get对象
        HttpGet get = new HttpGet(weatherQueryURL);
        //3.执行get请求，并返回响应结果
        CloseableHttpResponse response = client.execute(get);
        //4.处理结果
        //4.1.获取结果中的状态码
        int statusCode = response.getStatusLine().getStatusCode();
        //4.2.获取结果中内容
        HttpEntity entity = response.getEntity();  //获得实体内容
        String content = EntityUtils.toString(entity, "utf-8");  //通过实体工具类转换实体输出格式
        //5.关闭连接
        client.close();

        if(statusCode != 200) {
            System.out.println("请求出错，请检查key或location是否正确");
            return null;
        } else {
            return content;
        }
    }
}
