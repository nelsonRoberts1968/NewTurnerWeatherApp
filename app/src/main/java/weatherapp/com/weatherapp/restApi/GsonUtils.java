package weatherapp.com.weatherapp.restApi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Util class that provides convenience methods to use GSON library.
 */
public class GsonUtils {
    /**
     * Returns a Gson object with the following features:
     * <ol>
     * <li>Excluding fields without <b>Expose</b> annotation;</li>
     * <li>
     * Type adapters are registered for these classes:
     * <ul><li>com.seedonk.mobilesdk.Resolution</li><li>java.util.Date</ul>
     * </li>
     * </ol>
     *
     * @return
     * @since 0.8.2
     */
    public static Gson getGson() {
        return new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
//                   .registerTypeAdapter(Resolution.class, new ResolutionAdapter())
//                .registerTypeAdapter(Date.class, new ISO8601DateAdapter())
                .create();
    }
}

