package weatherapp.com.weatherapp.restApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Turner Cnn Weather app
 */
public class TodayWeather {

    @Expose
    @SerializedName("main")
    private Main main;

    public Main getMain() {
        return main;
    }

    @Expose
    @SerializedName("weather")
    private List<Weather> weather;

    public List<Weather> getWeather() {
        return weather;
    }

    public class Main {
        @Expose
        @SerializedName("temp_min")
        private String temp_min;

        public String getTempMin() {
            return temp_min;
        }

        @Expose
        @SerializedName("temp_max")
        private String temp_max;

        public String getTempMax() {
            return temp_max;
        }
    }

    public class Weather {

        @Expose
        @SerializedName("description")
        private String description;

        public String getDescription() {
            return description;
        }

        @Expose
        @SerializedName("icon")
        private String icon;

        public String getIcon() {
            return icon;
        }
    }
}
