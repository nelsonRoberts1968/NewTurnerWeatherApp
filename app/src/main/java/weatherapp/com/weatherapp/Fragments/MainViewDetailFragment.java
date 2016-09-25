package weatherapp.com.weatherapp.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import weatherapp.com.weatherapp.Model.DailyWeather;
import weatherapp.com.weatherapp.R;
import weatherapp.com.weatherapp.util.Utils;


/**
 * Turner Cnn Weather app
 */
public class MainViewDetailFragment extends Fragment {

    private DailyWeather mModel;

    public MainViewDetailFragment() {
        // Recommended constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPassedArgument();
    }

    public void getPassedArgument() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            mModel = (DailyWeather) bundle.getSerializable(MainViewFragment.BUNDLE_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_view_details, container, false);
        initViews(view);
        return view;
    }

    public void initViews(View view) {

        TextView weatherDate = (TextView) view.findViewById(R.id.weather_date);
        weatherDate.setText(mModel.getDate());

        TextView weatherDay = (TextView) view.findViewById(R.id.weather_day);
        weatherDay.setText(mModel.getDay());

        TextView humidity = (TextView) view.findViewById(R.id.weather_humidity);
        String humidityTxt = String.format(getString(R.string.current_humidity), mModel.getHumidity());
        humidity.setText(humidityTxt);

        TextView wind = (TextView) view.findViewById(R.id.weather_wind);
        String windTxt = String.format(getString(R.string.current_wind_speed), mModel.getWind());
        wind.setText(windTxt);

        TextView pressure = (TextView) view.findViewById(R.id.weather_pressure);
        String pressureTxt = String.format(getString(R.string.current_pressure), mModel.getPressure());
        pressure.setText(pressureTxt);

        String degreeSymbol = "°";
        TextView maxTemp = (TextView) view.findViewById(R.id.weather_temp_max);
        String maxTempText = String.format(getString(R.string.max_temp_txt), String.valueOf(mModel.getTemperatureMax()), degreeSymbol);
        maxTemp.setText(maxTempText);

        TextView minTemp = (TextView) view.findViewById(R.id.weather_temp_min);
        String minTempText = String.format(getString(R.string.max_temp_txt), String.valueOf(mModel.getTemperatureMin()), degreeSymbol);
        minTemp.setText(minTempText);

        ImageView dailyIcon = (ImageView) view.findViewById(R.id.daily_icon);
        dailyIcon.setImageResource(Utils.getDrawableResource(getActivity(), mModel.getIcon()));

        TextView weatherDesc = (TextView) view.findViewById(R.id.weather_desc);
        weatherDesc.setText(String.valueOf(mModel.getCondition()));
    }
}
