package persistence.DBQuery.WeatherInfoQuery;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class CurrentDate {
    public Date getCurrentDate() {
        // TODO Auto-generated method stub
        Date currentDate = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.format(currentDate);
        return currentDate;
    }
}
