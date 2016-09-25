package weatherapp.com.weatherapp.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import weatherapp.com.weatherapp.Activity.MainActivity;
import weatherapp.com.weatherapp.Adapter.MainViewListAdapter;
import weatherapp.com.weatherapp.Model.DailyWeather;
import weatherapp.com.weatherapp.Model.DailyWeatherCity;
import weatherapp.com.weatherapp.R;
import weatherapp.com.weatherapp.restApi.TodayWeather;
import weatherapp.com.weatherapp.restApi.WeatherList;
import weatherapp.com.weatherapp.restApi.WeatherManager;
import weatherapp.com.weatherapp.util.Utils;

/**
 * Turner Cnn Weather app
 */
public class MainViewFragment extends Fragment implements AdapterView.OnItemClickListener {

    private MainViewListAdapter mainViewListAdapter;
    private static final String TAG = MainViewFragment.class.getSimpleName();
    public static final String BUNDLE_KEY = "mainView";

    /**
     * Default Date format string
     */
    private NumberFormat formatter = new DecimalFormat("#0.0");
    public final static String DATE_FORMAT_STRING = "MMMM dd";

    public final static String DAY_FORMAT_STRING = "EEEE";

    public MainViewFragment() {
        // Recommended constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        convertDate();
    }

//    public void convertDate() {
//        String dateInString = WeatherManager.getInstance().getWeatherList().get(2).getDtTxt();
//        Date date = Utils.parseDate(dateInString);
//        Log.d(TAG, Utils.formatDate(date, DATE_FORMAT_STRING));
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_view, container, false);
        initViews(view);
        return view;
    }

    public void initViews(View view) {
        ListView listView = (ListView) view.findViewById(R.id.listView);
        setListAdapter(listView);

        TextView todayDate = (TextView) view.findViewById(R.id.weather_curent_day);
        Date date = Utils.getCurrentDay();
        String todayDateTxt = String.format(getString(R.string.day_today), Utils.formatDate(date, DATE_FORMAT_STRING));
        todayDate.setText(todayDateTxt);

        TodayWeather weather = WeatherManager.getInstance().getTodayWeather();

        String maxTemp = formatter.format(Double.valueOf(weather.getMain().getTempMax()) - 273);

        String minTemp = formatter.format(Double.valueOf(weather.getMain().getTempMin()) - 273);

        String degreeSymbol = "°";
        TextView maxTempView = (TextView) view.findViewById(R.id.weather_temp_max);
        String maxTempText = String.format(getString(R.string.max_temp_txt), maxTemp, degreeSymbol);
        maxTempView.setText(maxTempText);

        TextView minTempView = (TextView) view.findViewById(R.id.weather_temp_min);
        String minTempText = String.format(getString(R.string.max_temp_txt), minTemp, degreeSymbol);
        minTempView.setText(minTempText);

        TextView weatherDescView = (TextView) view.findViewById(R.id.weather_description);
        weatherDescView.setText(weather.getWeather().get(0).getDescription());

        ImageView dailyIcon = (ImageView) view.findViewById(R.id.daily_icon);
        dailyIcon.setImageResource(Utils.getDrawableResource(getActivity(), weather.getWeather().get(0).getIcon()));
    }

    public void setListAdapter(ListView listView) {
        mainViewListAdapter = new MainViewListAdapter(getActivity(), getDailyWeatherModels());
        listView.setAdapter(mainViewListAdapter);
        listView.setOnItemClickListener(this);
    }

    public String getFormattedDay(String dateInString, String dateFormat) {
        Date date = Utils.parseDate(dateInString);
        return Utils.formatDate(date, dateFormat);
    }

    public List<DailyWeather> getDailyWeatherModels() {

        List<DailyWeather> modelsList = new ArrayList<>();

        DailyWeather model;

        int size = WeatherManager.getInstance().getWeatherList().size();

        for (int i = 0; i < size; i++) {
            DailyWeatherCity dailyWeather = WeatherManager.getInstance().getDailyWeatherCity();
            WeatherList weather = dailyWeather.getWeatherList().get(i);

            weather.getWeather().get(0).getDescription();

            model = new DailyWeather();
            model.setDay(getFormattedDay(weather.getDtTxt(), DAY_FORMAT_STRING));
            model.setCondition(weather.getWeather().get(0).getDescription());

            double maxTemp = Double.valueOf(formatter.format(Double.valueOf(weather.getMain().getTempMax()) - 273));

            double minTemp = Double.valueOf(formatter.format(Double.valueOf(weather.getMain().getTempMin()) - 273));

            model.setTemperatureMax(maxTemp);
            model.setTemperatureMin(minTemp);
            model.setIcon(weather.getWeather().get(0).getIcon());
            model.setDate(getFormattedDay(weather.getDtTxt(), DATE_FORMAT_STRING));

            model.setHumidity(weather.getMain().getHumidity());
            model.setPressure(weather.getMain().getPressure());
            model.setWind(weather.getWind().getSpeed());

            modelsList.add(model);

        }

//        model = new DailyWeather();
//        model.setDay(Days.MONDAY.name());
//        model.setCondition("clear");
//        model.setTemperatureMax(21);
//        model.setTemperatureMin(18);
//        modelsList.add(model);
//
//        model = new DailyWeather();
//        model.setDay(Days.TUESDAY.name());
//        model.setCondition("clear");
//        model.setTemperatureMax(21);
//        model.setTemperatureMin(18);
//        modelsList.add(model);
//
//        model = new DailyWeather();
//        model.setDay(Days.WEDNESDAY.name());
//        model.setCondition("clear");
//        model.setTemperatureMax(21);
//        model.setTemperatureMin(18);
//        modelsList.add(model);
//
//        model = new DailyWeather();
//        model.setDay(Days.THURSDAY.name());
//        model.setCondition("clear");
//        model.setTemperatureMax(21);
//        model.setTemperatureMin(18);
//        modelsList.add(model);
//
//        model = new DailyWeather();
//        model.setDay(Days.FRIDAY.name());
//        model.setCondition("clear");
//        model.setTemperatureMax(21);
//        model.setTemperatureMin(18);
//        modelsList.add(model);
//
//        model = new DailyWeather();
//        model.setDay(Days.SATURDAY.name());
//        model.setCondition("clear");
//        model.setTemperatureMax(21);
//        model.setTemperatureMin(18);
//        modelsList.add(model);
//
//        model = new DailyWeather();
//        model.setDay(Days.SUNDAY.name());
//        model.setCondition("clear");
//        model.setTemperatureMax(21);
//        model.setTemperatureMin(18);
//        modelsList.add(model);


        return modelsList;
    }

    // TODO update model from data change from the server
    public void notifyWeatherAdapter(List<DailyWeather> dailyWeathers) {
        mainViewListAdapter.updateDailyWeather(dailyWeathers);
        mainViewListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        DailyWeather model = (DailyWeather) parent.getAdapter().getItem(position);
        openDailyWeatherDetails(model);

    }

    public void openDailyWeatherDetails(DailyWeather model) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(BUNDLE_KEY, model);

        MainViewDetailFragment fragment = new MainViewDetailFragment();
        fragment.setArguments(bundle);

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment, MainActivity.MAIN_VIEW_DETAIL_FRAG);
        transaction.addToBackStack(MainActivity.MAIN_VIEW_DETAIL_FRAG);
        transaction.commit();
    }

    public enum Days {
        MONDAY("Monday"),
        TUESDAY("Tuesday"),
        WEDNESDAY("Wednesday"),
        THURSDAY("Thursday"),
        FRIDAY("Friday"),
        SATURDAY("Saturday"),
        SUNDAY("Sunday");

        private String mDay;

        Days(String day) {
            mDay = day;
        }

        public String getDay() {
            return mDay;
        }
    }
}
