package com.example.neyronpc.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cooler {
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
}
