package ambe.com.vn.hanoi.models.inhanoi;


import java.io.Serializable;

/**
 * Created by AMBE on 04/11/2017.
 */

public class GioiThieuHn implements Serializable {

    private String txtName;
    private String urlImage;
    private String urlContent;

    public GioiThieuHn(String txtName, String urlImage, String urlContent) {
        this.txtName = txtName;
        this.urlImage = urlImage;
        this.urlContent=urlContent;
    }

    public GioiThieuHn() {
    }

    public String getUrlContent() {
        return urlContent;
    }

    public void setUrlContent(String urlContent) {
        this.urlContent = urlContent;
    }

    public String getTxtName() {
        return txtName;
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
