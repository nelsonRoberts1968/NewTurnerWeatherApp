package weatherapp.com.weatherapp.restApi;

/**
 * Turner Cnn Weather app
 */
public enum API {

    WEATHER_API("http://api.openweathermap.org/data/2.5/forecast/atlanta?id=4180439&APPID=cf1afbbc0648c6ba6e4d9edc278afe90"),
    TODAY_WEATHER_API("http://api.openweathermap.org/data/2.5/weather?q=sacramneto?id=4180439&APPID=cf1afbbc0648c6ba6e4d9edc278afe90");

    private String api;

    API(String api) {
        this.api = api;
    }

    public String getRequestUrl() {
        return api;
    }
}
