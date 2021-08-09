package com.example.neyronpc.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PC {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("processor")
    @Expose
    private String processor;

    @SerializedName("videocard")
    @Expose
    private String videocard;


    @SerializedName("ram")
    @Expose
    private String ram;

    @SerializedName("ssd")
    @Expose
    private String ssd;


    @SerializedName("hdd")
    @Expose
    private String hdd;


    @SerializedName("powersuppy")
    @Expose
    private String powersuppy;


    @SerializedName("price")
    @Expose
    private String price;

    @SerializedName("isnew")
    @Expose
    private boolean isNew;

    @SerializedName("imageurl")
    @Expose
    private String imageURL;



    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getVideocard() {
        return videocard;
    }

    public void setVideocard(String videocard) {
        this.videocard = videocard;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getSsd() {
        return ssd;
    }

    public void setSsd(String ssd) {
        this.ssd = ssd;
    }

    public String getHdd() {
        return hdd;
    }

    public void setHdd(String hdd) {
        this.hdd = hdd;
    }

    public String getPowersuppy() {
        return powersuppy;
    }

    public void setPowersuppy(String powersuppy) {
        this.powersuppy = powersuppy;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
