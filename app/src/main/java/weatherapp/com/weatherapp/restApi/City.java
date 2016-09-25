package weatherapp.com.weatherapp.restApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Turner Cnn Weather app
 */


public class City {

    @Expose
    @SerializedName("id")
    private String id;

    public String getId() {
        return id;
    }

    @Expose
    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }

    @Expose
    @SerializedName("coord")
    private Coord coord;

    public Coord getCoord() {
        return coord;
    }

    public class Coord {
        @Expose
        @SerializedName("lon")
        private String lon;

        public String getLon() {
            return lon;
        }

        @Expose
        @SerializedName("lat")
        private String lat;

        public String getLat() {
            return lat;
        }
    }


}
