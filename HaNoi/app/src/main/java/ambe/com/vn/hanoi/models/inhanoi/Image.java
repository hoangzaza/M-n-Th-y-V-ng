package ambe.com.vn.hanoi.models.inhanoi;

import java.io.Serializable;

/**
 * Created by AMBE on 16/10/2017.
 */

public class Image implements Serializable {
    private String id;
    private String url;

    public Image(String id, String url) {
        this.id = id;
        this.url = url;
    }

    public Image() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
