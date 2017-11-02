package ambe.com.vn.hanoi.models.inhanoi;

import java.io.Serializable;

/**
 * Created by AMBE on 16/10/2017.
 */

public class Rate implements Serializable {
    private String id;
    private User user;
    private String comment;
    private float rating;
    private String timeRate;


    public Rate(String id, User user, String comment, float rating, String timeRate) {
        this.id = id;
        this.user = user;
        this.comment = comment;
        this.rating = rating;
        this.timeRate=timeRate;
    }

    public Rate() {
    }

    public String getTimeRate() {
        return timeRate;
    }

    public void setTimeRate(String timeRate) {
        this.timeRate = timeRate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
