package com.example.neyronpc.service;

import com.example.neyronpc.interfaces.ApiServices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NeyronPCService{

    public static final String BaseURL = "http://192.168.43.8/openserver/neyronpc/api/v1/";
    public static final String CurrencyURL = "https://nbu.uz/exchange-rates/";
    public static Retrofit retrofit;

    public static Retrofit getAPI(){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BaseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        return retrofit;
    }

    public static Retrofit currencyAPI(){
        retrofit = new Retrofit.Builder()
                .baseUrl(CurrencyURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
