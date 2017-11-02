package ambe.com.vn.hanoi.models.others;

import java.io.Serializable;

/**
 * Created by AMBE on 02/11/2017.
 */

public class TienIch implements Serializable {

    private int idImage;
    private String name;


    public TienIch(int idImage, String name) {
        this.idImage = idImage;
        this.name = name;
    }

    public TienIch() {
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
