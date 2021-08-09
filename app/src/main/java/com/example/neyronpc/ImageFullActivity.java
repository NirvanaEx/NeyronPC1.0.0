package com.example.neyronpc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

public class ImageFullActivity extends AppCompatActivity implements View.OnClickListener {

    boolean visiblibleContainer = true;
    LinearLayout linearLayoutTop;
    LinearLayout linearLayoutBottom;
    ImageView imageView;
    ImageView backImageView;
    ImageView selectImageView;


    String imageURL;
    String company;
    String model;
    String price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_full);
        initViews();
        setData();
    }


    private void initViews(){
        linearLayoutTop = findViewById(R.id.image_full_top_container);
        linearLayoutBottom = findViewById(R.id.image_full_bottom_container);
        imageView =  findViewById(R.id.image_full_image);
        backImageView = findViewById(R.id.image_full_back_image);
        selectImageView = findViewById(R.id.image_full_select_image);

        imageView.setOnClickListener(this::onClick);
        backImageView.setOnClickListener(this::onClick);
        selectImageView.setOnClickListener(this::onClick);
    }

    private void setData(){
        company = getIntent().getStringExtra(CONSTANT.COMPANY_VALUE);
        model = getIntent().getStringExtra(CONSTANT.MODEL_VALUE);
        price = getIntent().getStringExtra(CONSTANT.PRICE_VALUE);
        imageURL = getIntent().getStringExtra(CONSTANT.IMAGE_URL);


        Glide.with(getApplicationContext())
                .load(imageURL)
                .error(R.drawable.no_photo)
                .into(imageView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_full_image:
                showInfo();
                break;
            case R.id.image_full_back_image:
                finish();
                break;
            case R.id.image_full_select_image:
                imageSelected();
                break;


        }
    }

    private void imageSelected() {
        Intent intent = new Intent();
        intent.putExtra(CONSTANT.IMAGE_URL,imageURL);
        intent.putExtra(CONSTANT.COMPANY_VALUE,company);
        intent.putExtra(CONSTANT.MODEL_VALUE,model);
        intent.putExtra(CONSTANT.PRICE_VALUE,price);
        setResult(RESULT_OK,intent);
        finish();
    }

    private void showInfo(){
        if(visiblibleContainer == true){
            linearLayoutTop.setVisibility(View.INVISIBLE);
            linearLayoutBottom.setVisibility(View.INVISIBLE);
            visiblibleContainer = false;
        }
        else{
            linearLayoutTop.setVisibility(View.VISIBLE);
            linearLayoutBottom.setVisibility(View.VISIBLE);
            visiblibleContainer = true;
        }
    }
}