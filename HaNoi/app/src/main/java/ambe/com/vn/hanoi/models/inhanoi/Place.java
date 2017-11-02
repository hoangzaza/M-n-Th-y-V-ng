package ambe.com.vn.hanoi.models.inhanoi;


import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by AMBE on 16/10/2017.
 */

public class Place implements Serializable {
    private String id;
    private String name;
    private String address;
    private String type;
    private ArrayList<Image> images;
    private String description;
    private ArrayList<Rate> rates;
    private String website;
    private String numberPhone;
    private String openHours;
    private String price;
    private String distance;

    public Place() {
    }

    public Place(String id, String name, String address, String type, ArrayList<Image> images, String description, ArrayList<Rate> rates, String website, String numberPhone, String openHours, String price, String distance) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.type = type;
        this.images = images;
        this.description = description;
        this.rates = rates;
        this.website = website;
        this.numberPhone = numberPhone;
        this.openHours = openHours;
        this.price = price;
        this.distance = distance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ArrayList<Image> getImages() {
        return images;
    }

    public void setImages(ArrayList<Image> images) {
        this.images = images;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Rate> getRates() {
        return rates;
    }

    public void setRates(ArrayList<Rate> rates) {
        this.rates = rates;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getOpenHours() {
        return openHours;
    }

    public void setOpenHours(String openHours) {
        this.openHours = openHours;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }
}
