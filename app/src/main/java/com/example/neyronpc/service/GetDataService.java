package com.example.neyronpc.service;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.neyronpc.CONSTANT;
import com.example.neyronpc.adapter.SelectListAdapter;
import com.example.neyronpc.data.Cooler;
import com.example.neyronpc.data.CoolerCompany;
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
import com.example.neyronpc.data.Videocard;
import com.example.neyronpc.data.VideocardCompany;
import com.example.neyronpc.interfaces.ApiServices;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetDataService {

    //Data
    String companyValue;
    List<ProcessorCompany> processorCompanyList;
    List<Processor> processorList;



    ApiServices apiServices;

    Activity activity;
    Context context;
    RecyclerView recyclerView;
    SelectListAdapter selectListAdapter;
    String type;
    String mode;





    public GetDataService(Activity activity, Context context,RecyclerView recyclerView, SelectListAdapter selectListAdapter, String type, String mode, String companyValue ){
        apiServices = NeyronPCService.getAPI().create(ApiServices.class);

        this.activity = activity;
        this.context = context;
        this.recyclerView = recyclerView;
        this.selectListAdapter = selectListAdapter;
        this.type = type;
        this.mode = mode;
        this.companyValue = companyValue;

        setData();
    }


    private void setData(){
        if(type!=null && mode!=null){
            mode();
        }
    }


    private void mode(){
        switch (mode){
            case CONSTANT.COMPANY:
                setCompany(type);
                return;
            case CONSTANT.MODEL:
                setModel(type);
                return;
            case CONSTANT.MODEL_ALL:
                setModelAll(type);
                return;

        }
    }


    private void setCompany(String type){
        switch (type){
            case CONSTANT.PROCESSOR:
                setProcessorCompanyList();
                return;
            case CONSTANT.VIDEOCARD:
                setVideocardCompanyList();
                return;
            case CONSTANT.MOTHERBOARD:
                setMotherboardCompanyList();
                return;
            case CONSTANT.RAM:
                setRAMCompanyList();
                return;
            case CONSTANT.SSD:
                setSSDCompanyList();
                return;
            case CONSTANT.HDD:
                setHDDCompanyList();
                return;
            case CONSTANT.POWER_SUPPLY:
                setPowerSupplyCompanyList();
                return;
            case CONSTANT.COOLER:
                setCoolerCompanyList();
                return;
            case CONSTANT.PC_CASE:
                setPCCaseCompany();
                return;

        }
    }

    private void setModel(String type){
        switch (type){
            case CONSTANT.PROCESSOR:
                setProcessorModel();
                return;
            case CONSTANT.VIDEOCARD:
                setVideocardModel();
                return;
            case CONSTANT.MOTHERBOARD:
                setMotherboardModel();
                return;
            case CONSTANT.RAM:
                setRAMModel();
                return;
            case CONSTANT.SSD:
                setSSDModel();
                return;
            case CONSTANT.HDD:
                setHDDModel();
                return;
            case CONSTANT.POWER_SUPPLY:
                setPowerSupplyModel();
                return;
            case CONSTANT.COOLER:
                setCoolerModel();
                return;
            case CONSTANT.PC_CASE:
                setPCCaseModel();
                return;

        }
    }

    private void setModelAll(String type){
        switch (type){
            case CONSTANT.PROCESSOR:
                setProcessorModelAll();
                return;
            case CONSTANT.VIDEOCARD:
                setVideocardModelAll();
                return;
            case CONSTANT.MOTHERBOARD:
                setMotherboardModelAll();
                return;
            case CONSTANT.RAM:
                setRAMModelAll();
                return;
            case CONSTANT.SSD:
                setSSDModelAll();
                return;
            case CONSTANT.HDD:
                setHDDModelAll();
                return;
            case CONSTANT.POWER_SUPPLY:
                setPowerSupplyModelAll();
                return;
            case CONSTANT.COOLER:
                setCoolerModelAll();
                return;
            case CONSTANT.PC_CASE:
                setPCCaseModelAll();
                return;

        }
    }



    //Processor
    private void setProcessorCompanyList(){
        apiServices.getProcessorCompany().enqueue(new Callback<List<ProcessorCompany>>() {
            @Override
            public void onResponse(Call<List<ProcessorCompany>> call, Response<List<ProcessorCompany>> response) {
                if(response.isSuccessful() && response.body()!=null) {
                    selectListAdapter = new SelectListAdapter(activity,context,type,mode);
                    selectListAdapter.setProcessorCompanyList(response.body());
                    recyclerView.setAdapter(selectListAdapter);
                }
                else{
                    Toast.makeText(context,"ERROR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ProcessorCompany>> call, Throwable t) {
                Toast.makeText(context,"CONNECTION ERROR", Toast.LENGTH_SHORT).show();
                Toast.makeText(context,t.getMessage(), Toast.LENGTH_SHORT).show();

                Log.v("OnFailure",t.getMessage());
            }
        });
    }

    private void setProcessorModel(){
        apiServices.getProcessorModel(companyValue).enqueue(new Callback<List<Processor>>() {
            @Override
            public void onResponse(Call<List<Processor>> call, Response<List<Processor>> response) {
                if(response.body()!=null && response.isSuccessful()){
                    selectListAdapter = new SelectListAdapter(activity,context,type,mode);
                    selectListAdapter.setProcessorList(response.body());
                    recyclerView.setAdapter(selectListAdapter);
                }
                else{
                    Toast.makeText(context,"ERROR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Processor>> call, Throwable t) {
                Toast.makeText(context,"CONNECTION ERROR", Toast.LENGTH_SHORT).show();
                Log.v("OnFailure",t.getMessage());
            }
        });
    }

    private void setProcessorModelAll(){
        apiServices.getProcessorModelAll().enqueue(new Callback<List<Processor>>() {
            @Override
            public void onResponse(Call<List<Processor>> call, Response<List<Processor>> response) {
                if(response.body()!=null && response.isSuccessful()){
                    selectListAdapter = new SelectListAdapter(activity,context,type,mode);
                    selectListAdapter.setProcessorList(response.body());
                    recyclerView.setAdapter(selectListAdapter);
                }
                else{
                    Toast.makeText(context,"ERROR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Processor>> call, Throwable t) {
                Toast.makeText(context,"CONNECTION ERROR", Toast.LENGTH_SHORT).show();
                Log.v("OnFailure",t.getMessage());
            }
        });
    }


    //Videocard
    private void setVideocardCompanyList(){
        apiServices.getVideocardCompany().enqueue(new Callback<List<VideocardCompany>>() {
            @Override
            public void onResponse(Call<List<VideocardCompany>> call, Response<List<VideocardCompany>> response) {
                if(response.isSuccessful() && response.body()!=null) {
                    selectListAdapter = new SelectListAdapter(activity,context,type,mode);
                    selectListAdapter.setVideocardCompanyList(response.body());
                    recyclerView.setAdapter(selectListAdapter);
                }
                else{
                    Toast.makeText(context,"ERROR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<VideocardCompany>> call, Throwable t) {
                Toast.makeText(context,"CONNECTION ERROR", Toast.LENGTH_SHORT).show();
                Log.v("OnFailure",t.getMessage());
            }
        });
    }

    private void setVideocardModel(){
        apiServices.getVideocardModel(companyValue).enqueue(new Callback<List<Videocard>>() {
            @Override
            public void onResponse(Call<List<Videocard>> call, Response<List<Videocard>> response) {
                if(response.isSuccessful() && response.body()!=null) {
                    selectListAdapter = new SelectListAdapter(activity,context,type,mode);
                    selectListAdapter.setVideocardList(response.body());
                    recyclerView.setAdapter(selectListAdapter);
                }
                else{
                    Toast.makeText(context,"ERROR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Videocard>> call, Throwable t) {
                Toast.makeText(context,"CONNECTION ERROR", Toast.LENGTH_SHORT).show();
                Log.v("OnFailure",t.getMessage());
            }
        });
    }

    private void setVideocardModelAll(){
        apiServices.getVideocardModelAll().enqueue(new Callback<List<Videocard>>() {
            @Override
            public void onResponse(Call<List<Videocard>> call, Response<List<Videocard>> response) {
                if(response.isSuccessful() && response.body()!=null) {
                    selectListAdapter = new SelectListAdapter(activity,context,type,mode);
                    selectListAdapter.setVideocardList(response.body());
                    recyclerView.setAdapter(selectListAdapter);
                }
                else{
                    Toast.makeText(context,"ERROR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Videocard>> call, Throwable t) {
                Toast.makeText(context,"CONNECTION ERROR", Toast.LENGTH_SHORT).show();
                Log.v("OnFailure",t.getMessage());
            }
        });
    }


    //Motherboard
    private void setMotherboardCompanyList(){
        apiServices.getMotherboardCompany().enqueue(new Callback<List<MotherboardCompany>>() {
            @Override
            public void onResponse(Call<List<MotherboardCompany>> call, Response<List<MotherboardCompany>> response) {
                if(response.isSuccessful() && response.body()!=null) {
                    selectListAdapter = new SelectListAdapter(activity,context,type,mode);
                    selectListAdapter.setMotherboardCompanyList(response.body());
                    recyclerView.setAdapter(selectListAdapter);
                }
                else{
                    Toast.makeText(context,"ERROR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<MotherboardCompany>> call, Throwable t) {
                Toast.makeText(context,"CONNECTION ERROR", Toast.LENGTH_SHORT).show();
                Log.v("OnFailure",t.getMessage());
            }
        });
    }

    private void setMotherboardModel(){
        apiServices.getMotherboardModel(companyValue).enqueue(new Callback<List<Motherboard>>() {
            @Override
            public void onResponse(Call<List<Motherboard>> call, Response<List<Motherboard>> response) {
                if(response.isSuccessful() && response.body()!=null) {
                    selectListAdapter = new SelectListAdapter(activity,context,type,mode);
                    selectListAdapter.setMotherboardList(response.body());
                    recyclerView.setAdapter(selectListAdapter);
                }
                else{
                    Toast.makeText(context,"ERROR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Motherboard>> call, Throwable t) {
                Toast.makeText(context,"CONNECTION ERROR", Toast.LENGTH_SHORT).show();
                Log.v("OnFailure",t.getMessage());
            }
        });
    }

    private void setMotherboardModelAll(){
        apiServices.getMotherboardModelAll().enqueue(new Callback<List<Motherboard>>() {
            @Override
            public void onResponse(Call<List<Motherboard>> call, Response<List<Motherboard>> response) {
                if(response.isSuccessful() && response.body()!=null) {
                    selectListAdapter = new SelectListAdapter(activity,context,type,mode);
                    selectListAdapter.setMotherboardList(response.body());
                    recyclerView.setAdapter(selectListAdapter);
                }
                else{
                    Toast.makeText(context,"ERROR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Motherboard>> call, Throwable t) {
                Toast.makeText(context,"CONNECTION ERROR", Toast.LENGTH_SHORT).show();
                Log.v("OnFailure",t.getMessage());
            }
        });
    }


    //RAM
    private void setRAMCompanyList(){
        apiServices.getRAMCompany().enqueue(new Callback<List<RAMCompany>>() {
            @Override
            public void onResponse(Call<List<RAMCompany>> call, Response<List<RAMCompany>> response) {
                if(response.isSuccessful() && response.body()!=null) {
                    selectListAdapter = new SelectListAdapter(activity,context,type,mode);
                    selectListAdapter.setRamCompanyList(response.body());
                    recyclerView.setAdapter(selectListAdapter);
                }
                else{
                    Toast.makeText(context,"ERROR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<RAMCompany>> call, Throwable t) {
                Toast.makeText(context,"CONNECTION ERROR", Toast.LENGTH_SHORT).show();
                Log.v("OnFailure",t.getMessage());
            }
        });
     }

    private void setRAMModel(){
        apiServices.getRAMModel(companyValue).enqueue(new Callback<List<RAM>>() {
            @Override
            public void onResponse(Call<List<RAM>> call, Response<List<RAM>> response) {
                if(response.isSuccessful() && response.body()!=null) {
                    selectListAdapter = new SelectListAdapter(activity,context,type,mode);
                    selectListAdapter.setRamList(response.body());
                    recyclerView.setAdapter(selectListAdapter);
                }
                else{
                    Toast.makeText(context,"ERROR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<RAM>> call, Throwable t) {
                Toast.makeText(context,"CONNECTION ERROR", Toast.LENGTH_SHORT).show();
                Log.v("OnFailure",t.getMessage());
            }
        });
    }

    private void setRAMModelAll(){
        apiServices.getRAMModelAll().enqueue(new Callback<List<RAM>>() {
            @Override
            public void onResponse(Call<List<RAM>> call, Response<List<RAM>> response) {
                if(response.isSuccessful() && response.body()!=null) {
                    selectListAdapter = new SelectListAdapter(activity,context,type,mode);
                    selectListAdapter.setRamList(response.body());
                    recyclerView.setAdapter(selectListAdapter);
                }
                else{
                    Toast.makeText(context,"ERROR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<RAM>> call, Throwable t) {
                Toast.makeText(context,"CONNECTION ERROR", Toast.LENGTH_SHORT).show();
                Log.v("OnFailure",t.getMessage());
            }
        });
    }


    //SSD
    private void setSSDCompanyList(){
        apiServices.getSSDCompany().enqueue(new Callback<List<SSDCompany>>() {
            @Override
            public void onResponse(Call<List<SSDCompany>> call, Response<List<SSDCompany>> response) {
                if(response.isSuccessful() && response.body()!=null) {
                    selectListAdapter = new SelectListAdapter(activity,context,type,mode);
                    selectListAdapter.setSsdCompanyList(response.body());
                    recyclerView.setAdapter(selectListAdapter);
                }
                else{
                    Toast.makeText(context,"ERROR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<SSDCompany>> call, Throwable t) {
                Toast.makeText(context,"CONNECTION ERROR", Toast.LENGTH_SHORT).show();
                Log.v("OnFailure",t.getMessage());
            }
        });
    }

    private void setSSDModel(){
        apiServices.getSSDModel(companyValue).enqueue(new Callback<List<SSD>>() {
            @Override
            public void onResponse(Call<List<SSD>> call, Response<List<SSD>> response) {
                if(response.isSuccessful() && response.body()!=null) {
                    selectListAdapter = new SelectListAdapter(activity,context,type,mode);
                    selectListAdapter.setSsdList(response.body());
                    recyclerView.setAdapter(selectListAdapter);
                }
                else{
                    Toast.makeText(context,"ERROR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<SSD>> call, Throwable t) {
                Toast.makeText(context,"CONNECTION ERROR", Toast.LENGTH_SHORT).show();
                Log.v("OnFailure",t.getMessage());
            }
        });


    }

    private void setSSDModelAll(){
        apiServices.getSSDModelAll().enqueue(new Callback<List<SSD>>() {
            @Override
            public void onResponse(Call<List<SSD>> call, Response<List<SSD>> response) {
                if(response.isSuccessful() && response.body()!=null) {
                    selectListAdapter = new SelectListAdapter(activity,context,type,mode);
                    selectListAdapter.setSsdList(response.body());
                    recyclerView.setAdapter(selectListAdapter);
                }
                else{
                    Toast.makeText(context,"ERROR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<SSD>> call, Throwable t) {
                Toast.makeText(context,"CONNECTION ERROR", Toast.LENGTH_SHORT).show();
                Log.v("OnFailure",t.getMessage());
            }
        });
    }


    //HDD
    private void setHDDCompanyList(){
        apiServices.getHDDCompany().enqueue(new Callback<List<HDDCompany>>() {
            @Override
            public void onResponse(Call<List<HDDCompany>> call, Response<List<HDDCompany>> response) {
                if(response.isSuccessful() && response.body()!=null) {
                    selectListAdapter = new SelectListAdapter(activity,context,type,mode);
                    selectListAdapter.setHddCompanyList(response.body());
                    recyclerView.setAdapter(selectListAdapter);
                }
                else{
                    Toast.makeText(context,"ERROR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<HDDCompany>> call, Throwable t) {
                Toast.makeText(context,"CONNECTION ERROR", Toast.LENGTH_SHORT).show();
                Log.v("OnFailure",t.getMessage());
            }
        });
    }

    private void setHDDModel(){
        apiServices.getHDDModel(companyValue).enqueue(new Callback<List<HDD>>() {
            @Override
            public void onResponse(Call<List<HDD>> call, Response<List<HDD>> response) {
                if(response.isSuccessful() && response.body()!=null) {
                    selectListAdapter = new SelectListAdapter(activity,context,type,mode);
                    selectListAdapter.setHddList(response.body());
                    recyclerView.setAdapter(selectListAdapter);
                }
                else{
                    Toast.makeText(context,"ERROR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<HDD>> call, Throwable t) {
                Toast.makeText(context,"CONNECTION ERROR", Toast.LENGTH_SHORT).show();
                Log.v("OnFailure",t.getMessage());
            }
        });
    }

    private void setHDDModelAll(){
        apiServices.getHDDModelAll().enqueue(new Callback<List<HDD>>() {
            @Override
            public void onResponse(Call<List<HDD>> call, Response<List<HDD>> response) {
                if(response.isSuccessful() && response.body()!=null) {
                    selectListAdapter = new SelectListAdapter(activity,context,type,mode);
                    selectListAdapter.setHddList(response.body());
                    recyclerView.setAdapter(selectListAdapter);
                }
                else{
                    Toast.makeText(context,"ERROR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<HDD>> call, Throwable t) {
                Toast.makeText(context,"CONNECTION ERROR", Toast.LENGTH_SHORT).show();
                Log.v("OnFailure",t.getMessage());
            }
        });
    }



    //Power Supply
    private void setPowerSupplyCompanyList(){
        apiServices.getPowerSupplyCompany().enqueue(new Callback<List<PowerSupplyCompany>>() {
            @Override
            public void onResponse(Call<List<PowerSupplyCompany>> call, Response<List<PowerSupplyCompany>> response) {
                if(response.isSuccessful() && response.body()!=null) {
                    selectListAdapter = new SelectListAdapter(activity,context,type,mode);
                    selectListAdapter.setPowerSupplyCompanyList(response.body());
                    recyclerView.setAdapter(selectListAdapter);
                }
                else{
                    Toast.makeText(context,"ERROR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<PowerSupplyCompany>> call, Throwable t) {
                Toast.makeText(context,"CONNECTION ERROR", Toast.LENGTH_SHORT).show();
                Log.v("OnFailure",t.getMessage());
            }
        });
    }

    private void setPowerSupplyModel(){
        apiServices.getPowerSupplyModel(companyValue).enqueue(new Callback<List<PowerSupply>>() {
            @Override
            public void onResponse(Call<List<PowerSupply>> call, Response<List<PowerSupply>> response) {
                if(response.isSuccessful() && response.body()!=null) {
                    selectListAdapter = new SelectListAdapter(activity,context,type,mode);
                    selectListAdapter.setPowerSupplyList(response.body());
                    recyclerView.setAdapter(selectListAdapter);
                }
                else{
                    Toast.makeText(context,"ERROR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<PowerSupply>> call, Throwable t) {
                Toast.makeText(context,"CONNECTION ERROR", Toast.LENGTH_SHORT).show();
                Log.v("OnFailure",t.getMessage());
            }
        });
    }

    private void setPowerSupplyModelAll(){
        apiServices.getPowerSupplyModelAll().enqueue(new Callback<List<PowerSupply>>() {
            @Override
            public void onResponse(Call<List<PowerSupply>> call, Response<List<PowerSupply>> response) {
                if(response.isSuccessful() && response.body()!=null) {
                    selectListAdapter = new SelectListAdapter(activity,context,type,mode);
                    selectListAdapter.setPowerSupplyList(response.body());
                    recyclerView.setAdapter(selectListAdapter);
                }
                else{
                    Toast.makeText(context,"ERROR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<PowerSupply>> call, Throwable t) {
                Toast.makeText(context,"CONNECTION ERROR", Toast.LENGTH_SHORT).show();
                Log.v("OnFailure",t.getMessage());
            }
        });
    }


    //Cooler
    private void setCoolerCompanyList(){
        apiServices.getCoolerCompany().enqueue(new Callback<List<CoolerCompany>>() {
            @Override
            public void onResponse(Call<List<CoolerCompany>> call, Response<List<CoolerCompany>> response) {
                if(response.isSuccessful() && response.body()!=null) {
                    selectListAdapter = new SelectListAdapter(activity,context,type,mode);
                    selectListAdapter.setCoolerCompanyList(response.body());
                    recyclerView.setAdapter(selectListAdapter);
                }
                else{
                    Toast.makeText(context,"ERROR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<CoolerCompany>> call, Throwable t) {
                Toast.makeText(context,"CONNECTION ERROR", Toast.LENGTH_SHORT).show();
                Log.v("OnFailure",t.getMessage());
            }
        });
    }

    private void setCoolerModel(){
        apiServices.getCoolerModel(companyValue).enqueue(new Callback<List<Cooler>>() {
            @Override
            public void onResponse(Call<List<Cooler>> call, Response<List<Cooler>> response) {
                if(response.isSuccessful() && response.body()!=null) {
                    selectListAdapter = new SelectListAdapter(activity,context,type,mode);
                    selectListAdapter.setCoolerList(response.body());
                    recyclerView.setAdapter(selectListAdapter);
                }
                else{
                    Toast.makeText(context,"ERROR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Cooler>> call, Throwable t) {
                Toast.makeText(context,"CONNECTION ERROR", Toast.LENGTH_SHORT).show();
                Log.v("OnFailure",t.getMessage());
            }
        });
    }

    private void setCoolerModelAll(){
        apiServices.getCoolerModelAll().enqueue(new Callback<List<Cooler>>() {
            @Override
            public void onResponse(Call<List<Cooler>> call, Response<List<Cooler>> response) {
                if(response.isSuccessful() && response.body()!=null) {
                    selectListAdapter = new SelectListAdapter(activity,context,type,mode);
                    selectListAdapter.setCoolerList(response.body());
                    recyclerView.setAdapter(selectListAdapter);
                }
                else{
                    Toast.makeText(context,"ERROR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Cooler>> call, Throwable t) {
                Toast.makeText(context,"CONNECTION ERROR", Toast.LENGTH_SHORT).show();
                Log.v("OnFailure",t.getMessage());
            }
        });
    }

    //PC Case
    private void setPCCaseCompany(){
        apiServices.getPCCaseCompany().enqueue(new Callback<List<PCCaseCompany>>() {
            @Override
            public void onResponse(Call<List<PCCaseCompany>> call, Response<List<PCCaseCompany>> response) {
                if(response.isSuccessful() && response.body()!=null) {
                    selectListAdapter = new SelectListAdapter(activity,context,type,mode);
                    selectListAdapter.setPcCaseCompanyList(response.body());
                    recyclerView.setAdapter(selectListAdapter);
                }
                else{
                    Toast.makeText(context,"ERROR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<PCCaseCompany>> call, Throwable t) {
                Toast.makeText(context,"CONNECTION ERROR", Toast.LENGTH_SHORT).show();
                Log.v("OnFailure",t.getMessage());
            }
        });
    }

    private void setPCCaseModel(){
        apiServices.getPCCaseModel(companyValue).enqueue(new Callback<List<PCCase>>() {
            @Override
            public void onResponse(Call<List<PCCase>> call, Response<List<PCCase>> response) {
                if(response.isSuccessful() && response.body()!=null) {
                    selectListAdapter = new SelectListAdapter(activity,context,type,mode);
                    selectListAdapter.setPcCaseList(response.body());
                    recyclerView.setAdapter(selectListAdapter);
                }
                else{
                    Toast.makeText(context,"ERROR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<PCCase>> call, Throwable t) {
                Toast.makeText(context,"CONNECTION ERROR", Toast.LENGTH_SHORT).show();
                Log.v("OnFailure",t.getMessage());
            }
        });
    }

    private void setPCCaseModelAll(){
        apiServices.getPCCaseModelAll().enqueue(new Callback<List<PCCase>>() {
            @Override
            public void onResponse(Call<List<PCCase>> call, Response<List<PCCase>> response) {
                if(response.isSuccessful() && response.body()!=null) {
                    selectListAdapter = new SelectListAdapter(activity,context,type,mode);
                    selectListAdapter.setPcCaseList(response.body());
                    recyclerView.setAdapter(selectListAdapter);
                }
                else{
                    Toast.makeText(context,"ERROR", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<PCCase>> call, Throwable t) {
                Toast.makeText(context,"CONNECTION ERROR", Toast.LENGTH_SHORT).show();
                Log.v("OnFailure",t.getMessage());
            }
        });
    }

}
