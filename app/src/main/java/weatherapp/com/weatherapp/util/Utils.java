package weatherapp.com.weatherapp.util;

import android.content.Context;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import weatherapp.com.weatherapp.R;

/**
 * Turner Cnn Weather app
 */
public abstract class Utils {

    /**
     * @return todays date
     */

    public static Date getCurrentDay() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    public static String formatDate(Date date, String formatString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString, Locale.getDefault());
        return simpleDateFormat.format(date);
    }

    /**
     * This method parse given formatted date String into Date object
     *
     * @param dateStr
     * @return
     */
    public static Date parseDate(String dateStr) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.getDefault());
        Date date = null;
        try {
            date = simpleDateFormat.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static int getDrawableResource(Context context, String icon) {
        if (icon.equalsIgnoreCase(context.getString(R.string.ic_clear))) {
            return R.drawable.art_clear;
        } else if (icon.equalsIgnoreCase(context.getString(R.string.ic_light_clouds))) {
            return R.drawable.art_light_clouds;
        } else if (icon.equalsIgnoreCase(context.getString(R.string.ic_cloudy))) {
            return R.drawable.art_clouds;
        } else if (icon.equalsIgnoreCase(context.getString(R.string.ic_cloudy_4))) {
            return R.drawable.art_clouds;
        } else if (icon.equalsIgnoreCase(context.getString(R.string.ic_light_rain))) {
            return R.drawable.art_light_rain;
        } else if (icon.equalsIgnoreCase(context.getString(R.string.ic_rain))) {
            return R.drawable.art_rain;
        } else if (icon.equalsIgnoreCase(context.getString(R.string.ic_storm))) {
            return R.drawable.art_storm;
        } else if (icon.equalsIgnoreCase(context.getString(R.string.ic_snow))) {
            return R.drawable.art_snow;
        } else if (icon.equalsIgnoreCase(context.getString(R.string.ic_fog))) {
            return R.drawable.art_fog;
        }
        return R.drawable.art_clouds;
    }
}
