package com.example.neyronpc;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import com.example.neyronpc.adapter.ImageListAdapter;
import com.example.neyronpc.data.PCCase;
import com.example.neyronpc.interfaces.ApiServices;
import com.example.neyronpc.service.NeyronPCService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImageGridActivity extends AppCompatActivity {


    GridView gridView;
    ImageListAdapter imageListAdapter;
    Activity activity;

    List<PCCase> pcCaseList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_grid);
        initViews();
        setData();


    }


    private void initViews(){
        activity = this;
        gridView = findViewById(R.id.image_grid_view);
    }



    private void setData(){
        ApiServices apiServices = NeyronPCService.getAPI().create(ApiServices.class);
        apiServices.getPCCaseModelAll().enqueue(new Callback<List<PCCase>>() {
            @Override
            public void onResponse(Call<List<PCCase>> call, Response<List<PCCase>> response) {
                if(response.isSuccessful() && response.body()!=null){
                    imageListAdapter = new ImageListAdapter(activity,getApplicationContext());
                    imageListAdapter.setPcCaseList(response.body());
                    gridView.setAdapter(imageListAdapter);
                }
                else{
                    Toast.makeText(getApplicationContext(),"EMPTY", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<PCCase>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"ERROR CONNECTION", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK){
            String imageURL = data.getStringExtra(CONSTANT.IMAGE_URL);
            String companyValue = data.getStringExtra(CONSTANT.COMPANY_VALUE);
            String modelValue = data.getStringExtra(CONSTANT.MODEL_VALUE);
            String priceValue = data.getStringExtra(CONSTANT.PRICE_VALUE);
            Intent intent = new Intent();
            intent.putExtra(CONSTANT.TYPE,CONSTANT.PC_CASE);
            intent.putExtra(CONSTANT.MODE,CONSTANT.MODEL_ALL);
            intent.putExtra(CONSTANT.COMPANY_VALUE,companyValue);
            intent.putExtra(CONSTANT.MODEL_VALUE,modelValue);
            intent.putExtra(CONSTANT.PRICE_VALUE,priceValue);
            intent.putExtra(CONSTANT.IMAGE_URL, imageURL);
            setResult(RESULT_OK,intent);
            finish();
        }
    }



}