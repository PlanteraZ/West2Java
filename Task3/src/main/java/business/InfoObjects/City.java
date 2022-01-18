package business.InfoObjects;

import com.alibaba.fastjson.annotation.JSONField;

public class City {
    @JSONField(name = "name")
    private String name;  //城市名字

    @JSONField(name = "id")
    private String id;  //城市id

    @JSONField(name = "longitude")
    private float longitude;  //城市经度

    @JSONField(name = "latitude")
    private float latitude;  //城市纬度

    //getter and setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

}
