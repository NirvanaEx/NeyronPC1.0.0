package com.example.neyronpc.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("login")
    @Expose
    private String login;

    @SerializedName("pass")
    @Expose
    private String password;

    @SerializedName("email")
    @Expose
    private String email;


    @SerializedName("tel")
    @Expose
    private String tel;

    @SerializedName("message")
    @Expose
    private String message;




    //Нужно сделать массивом
    @SerializedName("adress")
    @Expose
    private String adress;

    @SerializedName("imageUrl")
    @Expose
    private String imageUrl;


    public int getId() {
        return id;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getMessage() {
        return message;
    }
}
