package ambe.com.vn.hanoi.models.inhanoi;

import java.io.Serializable;
import java.util.ArrayList;

import ambe.com.vn.hanoi.models.inhanoi.Place;

/**
 * Created by AMBE on 16/10/2017.
 */

public class User implements Serializable {
    private String token;
    private String urlAvatar;
    private String lastName;
    private String firstName;
    private ArrayList<Place> likes;

    public User(String token, String urlAvatar, String lastName, String firstName, ArrayList<Place> likes) {
        this.token = token;
        this.urlAvatar = urlAvatar;
        this.lastName = lastName;
        this.firstName = firstName;
        this.likes=likes;
    }

    public User() {
    }

    public ArrayList<Place> getLikes() {
        return likes;
    }

    public void setLikes(ArrayList<Place> likes) {
        this.likes = likes;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
