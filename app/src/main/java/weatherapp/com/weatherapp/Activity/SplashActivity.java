package weatherapp.com.weatherapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import weatherapp.com.weatherapp.R;
import weatherapp.com.weatherapp.listeners.HttpResponseListener;
import weatherapp.com.weatherapp.restApi.API;
import weatherapp.com.weatherapp.restApi.HttpRequestManager;
import weatherapp.com.weatherapp.restApi.RequestMethod;
import weatherapp.com.weatherapp.restApi.WeatherManager;

/**
 * Turner Cnn Weather app
 */
public class SplashActivity extends AppCompatActivity implements HttpResponseListener {

    private static final String TAG = SplashActivity.class.getSimpleName();
    private boolean isFirst = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        startWeatherAppDelayed(1500);
    }

    /**
     * This shows the mandatory splash screen.
     *
     * @param timeMilliSec time required to show splash screen
     */
    public void startWeatherAppDelayed(int timeMilliSec) {
        Handler handler = new Handler();
        final Runnable startActivityRunnable = new Runnable() {
            @Override
            public void run() {
                callTodayWeatherApi();
            }
        };
        handler.postDelayed(startActivityRunnable, timeMilliSec);
    }

    public void callTodayWeatherApi() {
        HttpRequestManager.callApi(API.TODAY_WEATHER_API, RequestMethod.GET, this);
    }

    public void callWeatherApi() {
        HttpRequestManager.callApi(API.WEATHER_API, RequestMethod.GET, this);
    }

    public void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onResponseReceived(int responseCode, String contentStr) {
        if (responseCode == 200 && isFirst) {
            isFirst = false;
            Log.d(TAG, "Response Code=" + responseCode + " Today weather Context String =" + contentStr);
            WeatherManager.getInstance().setTodayWeather(contentStr);
            callWeatherApi();

        } else if (responseCode == 200) {
            Log.d(TAG, "Response Code=" + responseCode + " Forecast Weather Context String =" + contentStr);
            WeatherManager.getInstance().setResponseString(contentStr);
            startMainActivity();
        } else {
            String responseError = String.format(getString(R.string.api_not_error), String.valueOf(responseCode));
            Toast.makeText(this, responseError, Toast.LENGTH_LONG).show();
        }
    }
}
