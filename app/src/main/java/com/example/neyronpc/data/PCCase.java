package com.example.neyronpc.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PCCase {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("company")
    @Expose
    private String company;

    @SerializedName("model")
    @Expose
    private String model;

    @SerializedName("price")
    @Expose
    private String price;

    @SerializedName("imageURL")
    @Expose
    private String imageURL;


    public int getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
