package weatherapp.com.weatherapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import weatherapp.com.weatherapp.restApi.City;
import weatherapp.com.weatherapp.restApi.WeatherList;

/**
 * Turner Cnn Weather app
 */
public class DailyWeatherCity {

    @Expose
    @SerializedName("cnt")
    private String cnt;

    public String getCnt() {
        return cnt;
    }

    @Expose
    @SerializedName("message")
    private String message;

    public String getMessage() {
        return message;
    }

    @Expose
    @SerializedName("list")
    private List<WeatherList> wetherList;

    public List<WeatherList> getWeatherList() {
        return wetherList;
    }

    @Expose
    @SerializedName("city")
    private City city;

    public City getCity() {
        return city;
    }

}
