package ambe.com.vn.hanoi.models.weather;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by AMBE on 17/10/2017.
 */

public class WeatherJson implements Serializable {
    private ArrayList<ListItem> list;

    public WeatherJson(ArrayList<ListItem> list) {
        this.list = list;
    }

    public WeatherJson() {
    }

    public ArrayList<ListItem> getList() {
        return list;
    }

    public void setList(ArrayList<ListItem> list) {
        this.list = list;
    }
}
