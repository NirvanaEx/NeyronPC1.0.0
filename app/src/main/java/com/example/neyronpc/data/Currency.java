package com.example.neyronpc.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Currency {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("nbu_cell_price")
    @Expose
    private String price;
    @SerializedName("code")
    @Expose
    private String code;



    public String getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }
}
