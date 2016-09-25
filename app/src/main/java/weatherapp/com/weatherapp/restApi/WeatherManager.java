package weatherapp.com.weatherapp.restApi;

import java.util.List;

import weatherapp.com.weatherapp.Model.DailyWeatherCity;

/**
 * Turner Cnn Weather app
 */
public class WeatherManager {

    private static WeatherManager instance;
    private DailyWeatherCity mDailyWeatherCity;
    private TodayWeather mTodayWeather;

    public static WeatherManager getInstance() {
        if (instance == null) {
            instance = new WeatherManager();
        }
        return instance;
    }

    public City getCity() {

        if (mDailyWeatherCity != null) {
            return mDailyWeatherCity.getCity();
        }
        return null;
    }

    public List<WeatherList> getWeatherList() {
        if (mDailyWeatherCity != null) {
            return mDailyWeatherCity.getWeatherList();
        }
        return null;
    }

    public DailyWeatherCity getDailyWeatherCity() {
        return mDailyWeatherCity != null ? mDailyWeatherCity : null;
    }

    public TodayWeather getTodayWeather() {
        return mTodayWeather != null ? mTodayWeather : null;
    }

    public void setResponseString(String conStr) {
        mDailyWeatherCity = GsonUtils.getGson().fromJson(conStr, DailyWeatherCity.class);
    }

    public void setTodayWeather(String conStr) {
        mTodayWeather = GsonUtils.getGson().fromJson(conStr, TodayWeather.class);
    }
}
