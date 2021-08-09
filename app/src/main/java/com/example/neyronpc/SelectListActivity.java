package com.example.neyronpc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;

import com.example.neyronpc.adapter.SelectListAdapter;
import com.example.neyronpc.data.Processor;
import com.example.neyronpc.data.ProcessorCompany;
import com.example.neyronpc.interfaces.ApiServices;
import com.example.neyronpc.service.GetDataService;
import com.example.neyronpc.service.NeyronPCService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SelectListActivity extends AppCompatActivity {


    String type;
    String mode;

    //Views
    RecyclerView recyclerView;
    //Data
    List<Processor> processorList;
    List<String> company;
    SelectListAdapter selectListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_list);
        String type = getIntent().getStringExtra(CONSTANT.TYPE);
        String mode = getIntent().getStringExtra(CONSTANT.MODE);
        String companyValue = getIntent().getStringExtra(CONSTANT.COMPANY_VALUE);

        initViews();
        initData();
        showData(type,mode,companyValue);
    }


    private void showData(String type,String mode,String companyValue){
        new GetDataService(this,getApplicationContext(),recyclerView,selectListAdapter,type,mode,companyValue);
    }


    private void initViews(){
        recyclerView = findViewById(R.id.choise_recyclerview);
    }









    private void initData(){

        /*
        processorList = new ArrayList<>();
        Processor processorDefault = new Processor();
        processorDefault.setCompany(getResources().getString(R.string.not_selected));
        processorDefault.setModel(getResources().getString(R.string.not_selected));

        Processor processor1 = new Processor();

        processor1.setCompany("INTEL");
        processor1.setModel("CORE I5 9600K");
        processor1.setPrice("240");
        Processor processor2 = new Processor();
        processor2.setCompany("AMD");
        processor2.setModel("Ryzen 5 3600");
        processor2.setPrice("200");

        processorList.add(processorDefault);
        processorList.add(processor1);
        processorList.add(processor2);
        processorList.add(processor1);
        processorList.add(processor2);
        processorList.add(processor1);
        processorList.add(processor2);
        processorList.add(processor1);
        processorList.add(processor2);*/
    }







}