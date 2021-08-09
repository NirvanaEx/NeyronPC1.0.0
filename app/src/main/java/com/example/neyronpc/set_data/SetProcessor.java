package com.example.neyronpc.set_data;

import android.app.Activity;
import android.content.Intent;

import androidx.annotation.Nullable;

import com.example.neyronpc.CONSTANT;
import com.example.neyronpc.SelectListActivity;

import static android.app.Activity.RESULT_OK;

public class SetProcessor extends Activity{

    String TYPE;
    String MODE;
    Activity activity;



    private void send(){
        switch (MODE){
            case CONSTANT.COMPANY:
                setProcessorCompany();
                return;
            case CONSTANT.MODEL:
                setProcessorModel();
                return;
            case CONSTANT.MODEL_ALL:
                setProcessorModelAll();
                return;
        }
    }

    private void setProcessorCompany(){
        Intent companyIntent = new Intent(activity, SelectListActivity.class);
        companyIntent.putExtra(CONSTANT.TYPE, CONSTANT.PROCESSOR);
        companyIntent.putExtra(CONSTANT.MODE,CONSTANT.COMPANY);
        activity.startActivityForResult(companyIntent,1);

    }

    private void setProcessorModel(){
        Intent modelIntent = new Intent(activity, SelectListActivity.class);
        modelIntent.putExtra(CONSTANT.TYPE, CONSTANT.PROCESSOR);
        modelIntent.putExtra(CONSTANT.MODE,CONSTANT.MODEL);
        activity.startActivityForResult(modelIntent,1);
    }

    private void setProcessorModelAll(){
        Intent modelAllIntent = new Intent(activity, SelectListActivity.class);
        modelAllIntent.putExtra(CONSTANT.TYPE, CONSTANT.PROCESSOR);
        modelAllIntent.putExtra(CONSTANT.MODE,CONSTANT.MODEL_ALL);
        activity.startActivityForResult(modelAllIntent,1);
    }



}
