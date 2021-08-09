package com.example.neyronpc.interfaces;

import com.example.neyronpc.data.Cooler;
import com.example.neyronpc.data.CoolerCompany;
import com.example.neyronpc.data.Currency;
import com.example.neyronpc.data.HDD;
import com.example.neyronpc.data.HDDCompany;
import com.example.neyronpc.data.Motherboard;
import com.example.neyronpc.data.MotherboardCompany;
import com.example.neyronpc.data.PCCase;
import com.example.neyronpc.data.PCCaseCompany;
import com.example.neyronpc.data.PowerSupply;
import com.example.neyronpc.data.PowerSupplyCompany;
import com.example.neyronpc.data.Processor;
import com.example.neyronpc.data.ProcessorCompany;
import com.example.neyronpc.data.RAM;
import com.example.neyronpc.data.RAMCompany;
import com.example.neyronpc.data.SSD;
import com.example.neyronpc.data.SSDCompany;
import com.example.neyronpc.data.User;
import com.example.neyronpc.data.Videocard;
import com.example.neyronpc.data.VideocardCompany;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiServices {


    @GET("json/")
    Call<List<Currency>> getCurrency();

    @FormUrlEncoded
    @POST("userLogin.php")
    Call<User> userLogin(
           @Field("login") String login,
           @Field("pass") String pass
    );

    @FormUrlEncoded
    @POST("userReg.php")
    Call<User> userReg(
            @Field("login") String login,
            @Field("pass") String pass,
            @Field("email") String email
    );

    //Processor
    @POST("processor/getCompany.php")
    Call<List<ProcessorCompany>> getProcessorCompany();

    @FormUrlEncoded
    @POST("processor/getModel.php")
    Call<List<Processor>> getProcessorModel(
            @Field("company") String company
    );

    @POST("processor/getModelAll.php")
    Call<List<Processor>> getProcessorModelAll();


    //Videocard
    @POST("videocard/getCompany.php")
    Call<List<VideocardCompany>> getVideocardCompany();

    @FormUrlEncoded
    @POST("videocard/getModel.php")
    Call<List<Videocard>> getVideocardModel(
            @Field("company") String company
    );

    @POST("videocard/getModelAll.php")
    Call<List<Videocard>> getVideocardModelAll();



    //Motherboard
    @POST("motherboard/getCompany.php")
    Call<List<MotherboardCompany>> getMotherboardCompany();

    @FormUrlEncoded
    @POST("motherboard/getModel.php")
    Call<List<Motherboard>> getMotherboardModel(
            @Field("company") String company
    );

    @POST("motherboard/getModelAll.php")
    Call<List<Motherboard>> getMotherboardModelAll();


    //RAM
    @POST("ram/getCompany.php")
    Call<List<RAMCompany>> getRAMCompany();

    @FormUrlEncoded
    @POST("ram/getModel.php")
    Call<List<RAM>> getRAMModel(
            @Field("company") String company
    );

    @POST("ram/getModelAll.php")
    Call<List<RAM>> getRAMModelAll();

    //SSD
    @POST("ssd/getCompany.php")
    Call<List<SSDCompany>> getSSDCompany();

    @FormUrlEncoded
    @POST("ssd/getModel.php")
    Call<List<SSD>> getSSDModel(
            @Field("company") String company
    );

    @POST("ssd/getModelAll.php")
    Call<List<SSD>> getSSDModelAll();


    //HDD
    @POST("hdd/getCompany.php")
    Call<List<HDDCompany>> getHDDCompany();

    @FormUrlEncoded
    @POST("hdd/getModel.php")
    Call<List<HDD>> getHDDModel(
            @Field("company") String company
    );

    @POST("hdd/getModelAll.php")
    Call<List<HDD>> getHDDModelAll();


    //Power Supply
    @POST("powersupply/getCompany.php")
    Call<List<PowerSupplyCompany>> getPowerSupplyCompany();

    @FormUrlEncoded
    @POST("powersupply/getModel.php")
    Call<List<PowerSupply>> getPowerSupplyModel(
            @Field("company") String company
    );

    @POST("powersupply/getModelAll.php")
    Call<List<PowerSupply>> getPowerSupplyModelAll();


    //Cooler
    @POST("cooler/getCompany.php")
    Call<List<CoolerCompany>> getCoolerCompany();

    @FormUrlEncoded
    @POST("cooler/getModel.php")
    Call<List<Cooler>> getCoolerModel(
            @Field("company") String company
    );

    @POST("pccase/getModelAll.php")
    Call<List<Cooler>> getCoolerModelAll();

    //PC case
    @POST("pccase/getCompany.php")
    Call<List<PCCaseCompany>> getPCCaseCompany();

    @FormUrlEncoded
    @POST("pccase/getModel.php")
    Call<List<PCCase>> getPCCaseModel(
            @Field("company") String company
    );

    @POST("pccase/getModelAll.php")
    Call<List<PCCase>> getPCCaseModelAll();

}
