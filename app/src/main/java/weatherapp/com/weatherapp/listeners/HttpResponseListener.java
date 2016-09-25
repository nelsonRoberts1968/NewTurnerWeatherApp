package weatherapp.com.weatherapp.listeners;

/**
 * Turner Cnn Weather app
 */
public interface HttpResponseListener {

    void onResponseReceived(int responseCode, String contentStr);
}
