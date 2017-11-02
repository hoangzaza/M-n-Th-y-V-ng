package ambe.com.vn.hanoi.models.weather;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by AMBE on 17/10/2017.
 */

public class ListItem implements Serializable {
    private long dt;
    private Temp temp;
    private ArrayList<WeatherItem> weather;

    public ListItem(long dt, Temp temp, ArrayList<WeatherItem> weather) {
        this.dt = dt;
        this.temp = temp;
        this.weather = weather;
    }

    public ListItem() {
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    public ArrayList<WeatherItem> getWeather() {
        return weather;
    }

    public void setWeather(ArrayList<WeatherItem> weather) {
        this.weather = weather;
    }
}
