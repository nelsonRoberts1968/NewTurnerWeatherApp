package weatherapp.com.weatherapp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import weatherapp.com.weatherapp.Model.DailyWeather;
import weatherapp.com.weatherapp.R;

/**
 * Turner Cnn Weather app
 */
public class MainViewListAdapter extends BaseAdapter {

    private List<DailyWeather> dailyWeatherList = new ArrayList<>();
    private Context mContext;

    public MainViewListAdapter(Context context, List<DailyWeather> dailyWeatherList) {
        mContext = context;
        this.dailyWeatherList = dailyWeatherList;

    }

    public void updateDailyWeather(List<DailyWeather> dailyWeatherList) {
        dailyWeatherList.clear();
        this.dailyWeatherList.addAll(dailyWeatherList);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return dailyWeatherList.size();
    }

    @Override
    public Object getItem(int position) {
        return dailyWeatherList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        DailyWeather model = (DailyWeather) getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.daily_weather_item_view, parent, false);
        }

        if (model != null) {

            ImageView imageView = (ImageView) convertView.findViewById(R.id.icon);
            imageView.setImageResource(getDrawableResource(model.getIcon()));

            TextView dayTextView = (TextView) convertView.findViewById(R.id.day);
            dayTextView.setText(model.getDay());

            TextView conditionTextView = (TextView) convertView.findViewById(R.id.condition);
            conditionTextView.setText(model.getCondition());

            TextView maxTempTextView = (TextView) convertView.findViewById(R.id.max_temp);
            maxTempTextView.setText(String.valueOf(model.getTemperatureMax()) + "\u00B0");

            TextView minTempTextView = (TextView) convertView.findViewById(R.id.min_temp);
            minTempTextView.setText(String.valueOf(model.getTemperatureMin()) + "\u00B0");
        }

        return convertView;
    }

    public int getDrawableResource(String icon) {

        if (icon.equalsIgnoreCase(mContext.getString(R.string.ic_clear))) {
            return R.drawable.ic_clear;
        } else if (icon.equalsIgnoreCase(mContext.getString(R.string.ic_light_clouds))) {
            return R.drawable.ic_light_clouds;
        } else if (icon.equalsIgnoreCase(mContext.getString(R.string.ic_cloudy))) {
            return R.drawable.ic_cloudy;
        } else if (icon.equalsIgnoreCase(mContext.getString(R.string.ic_cloudy_4))) {
            return R.drawable.ic_cloudy;
        } else if (icon.equalsIgnoreCase(mContext.getString(R.string.ic_light_rain))) {
            return R.drawable.ic_light_rain;
        } else if (icon.equalsIgnoreCase(mContext.getString(R.string.ic_rain))) {
            return R.drawable.ic_rain;
        } else if (icon.equalsIgnoreCase(mContext.getString(R.string.ic_storm))) {
            return R.drawable.ic_storm;
        } else if (icon.equalsIgnoreCase(mContext.getString(R.string.ic_snow))) {
            return R.drawable.ic_snow;
        } else if (icon.equalsIgnoreCase(mContext.getString(R.string.ic_fog))) {
            return R.drawable.ic_fog;
        }
        return R.drawable.art_clouds;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }
}
