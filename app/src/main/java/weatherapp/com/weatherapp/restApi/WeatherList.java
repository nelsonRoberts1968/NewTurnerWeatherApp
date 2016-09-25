package weatherapp.com.weatherapp.restApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Turner Cnn Weather app
 */
public class WeatherList {

    @Expose
    @SerializedName("dt_txt")
    private String dt_txt;

    public String getDtTxt() {
        return dt_txt;
    }

    @Expose
    @SerializedName("sys")
    private Sys sys;

    public Sys getSys() {
        return sys;
    }

    @Expose
    @SerializedName("wind")
    private Wind wind;

    public Wind getWind() {
        return wind;
    }

    @Expose
    @SerializedName("clouds")
    private Cloud clouds;

    public Cloud getCloud() {
        return clouds;
    }

    @Expose
    @SerializedName("dt")
    private String date;

    public String getDate() {
        return date;
    }

    @Expose
    @SerializedName("main")
    private Main main;

    public Main getMain() {
        return main;
    }

    @Expose
    @SerializedName("weather")
    private List<Weather> getWeatherList;

    public List<Weather> getWeather() {
        return getWeatherList;
    }

    public class Main {

        @Expose
        @SerializedName("temp")
        private String temp;

        public String getTemp() {
            return temp;
        }

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

        @Expose
        @SerializedName("pressure")
        private String pressure;

        public String getPressure() {
            return pressure;
        }

        @Expose
        @SerializedName("sea_level")
        private String seaLevel;

        public String getSeaLevel() {
            return seaLevel;
        }

        @Expose
        @SerializedName("grnd_level")
        private String grnd_level;

        public String getGrndevel() {
            return grnd_level;
        }

        @Expose
        @SerializedName("humidity")
        private String humidity;

        public String getHumidity() {
            return humidity;
        }

        @Expose
        @SerializedName("temp_kf")
        private String temp_kf;

        public String getTempKf() {
            return temp_kf;
        }
    }

    public class Weather {

        @Expose
        @SerializedName("id")
        private String id;

        public String getId() {
            return id;
        }

        @Expose
        @SerializedName("main")
        private String main;

        public String getMain() {
            return main;
        }

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

    public class Cloud {

        @Expose
        @SerializedName("all")
        private String all;

        public String getAll() {
            return all;
        }
    }

    public class Wind {

        @Expose
        @SerializedName("speed")
        private String speed;

        public String getSpeed() {
            return speed;
        }

        @Expose
        @SerializedName("deg")
        private String deg;

        public String getDeg() {
            return deg;
        }
    }

    public class Sys {
        @Expose
        @SerializedName("pod")
        private String pod;

        public String getPod() {
            return pod;
        }
    }

}
