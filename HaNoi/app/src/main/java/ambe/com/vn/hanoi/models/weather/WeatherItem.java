package ambe.com.vn.hanoi.models.weather;

import java.io.Serializable;

/**
 * Created by AMBE on 17/10/2017.
 */

public class WeatherItem implements Serializable {

    private long id;
    private String main;
    private String description;
    private String icon;

    public WeatherItem() {
    }

    public WeatherItem(long id, String main, String description, String icon) {
        this.id = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
