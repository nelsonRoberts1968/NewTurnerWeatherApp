package weatherapp.com.weatherapp.restApi;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;

import weatherapp.com.weatherapp.listeners.HttpResponseListener;

/**
 * Turner Cnn Weather app
 */
public class HttpRequestManager {

    private static final String TAG = HttpRequestManager.class.getSimpleName();
    private static final String HEADER_NAME_CACHE_CONTROL = "Cache-Control";
    private static final String HEADER_NAME_CONTENT_TYPE = "Content-Type";


    public static void callApi(API apiDetails, RequestMethod method, HttpResponseListener listener) {
        HttpRequestManager manager = new HttpRequestManager();
        manager.sendRequestAsync(apiDetails, method, listener);
    }

    private void sendRequestAsync(final API apiDetails, final RequestMethod method, final HttpResponseListener listener) {
        new AsyncTask<Void, Void, String>() {
            String contentStr = "";
            int responseCode = 0;

            @Override
            protected String doInBackground(Void... params) {
                HttpURLConnection huc;
                InputStream is;
                String requestUrl = apiDetails.getRequestUrl();

                try {
                    huc = prepareHttpURLConnection(requestUrl, method);
                    if (huc == null) {
                        return null;
                    }

                    if (method == RequestMethod.POST || method == RequestMethod.PUT) {
                        huc.setDoOutput(true);

                    } else {
                        huc.connect();
                    }

                    responseCode = huc.getResponseCode();

                    if (responseCode >= 400)
                        is = huc.getErrorStream();
                    else
                        is = huc.getInputStream();
                    contentStr = readIt(is);

                    is.close();

                } catch (SocketTimeoutException e) {
                    Log.e(TAG, " Socket timeout", e);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return contentStr;
            }

            @Override
            protected void onPostExecute(String contentStr) {
                super.onPostExecute(contentStr);
                Log.d(TAG, "Response: = " + contentStr);
                listener.onResponseReceived(responseCode, contentStr);
            }
        }.execute();
    }

    private String readIt(InputStream is) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
        String line;
        StringBuilder content = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            content.append(line);
        }
        return content.toString();
    }

    /**
     * Creates an instance of HttpURLConnection with the specified URL string <code>urlStr</code> and parameters.
     *
     * @param urlStr URL string to connect.
     * @param method Method of the HTTP request, e.g., POST.
     * @return the <code>HttpURLConnection</code> created.
     * @throws IOException
     */
    private HttpURLConnection prepareHttpURLConnection(String urlStr, RequestMethod method)
            throws IOException {
        URL url = new URL(urlStr);
        HttpURLConnection huc = (HttpURLConnection) url.openConnection();
        huc.setRequestMethod(method.name());
        huc.setConnectTimeout(30000);
        huc.setRequestProperty(HEADER_NAME_CONTENT_TYPE, "application/json");
        huc.setRequestProperty(HEADER_NAME_CACHE_CONTROL, "no-cache");
        return huc;
    }
}
