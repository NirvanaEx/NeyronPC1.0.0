package com.example.neyronpc.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.neyronpc.CONSTANT;
import com.example.neyronpc.R;
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

import java.util.List;

public class SelectListAdapter extends RecyclerView.Adapter<SelectListAdapter.ViewHolder> {

    //Views
    private LinearLayout linearLayout;
    private LinearLayout containerArg1;
    private LinearLayout containerArg2;
    private LinearLayout containerArg3;

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;


    private  final String type;
    private final String mode;
    private String companyValue;

    LayoutInflater layoutInflater;

    Context context;
    Activity activity;

    //Data
    //Processor
    List<ProcessorCompany> processorCompanyList;
    List<Processor> processorList;
    //Videocard
    List<VideocardCompany> videocardCompanyList;
    List<Videocard> videocardList;
    //Motherboard
    List<MotherboardCompany> motherboardCompanyList;
    List<Motherboard> motherboardList;
    //RAM
    List<RAMCompany> ramCompanyList;
    List<RAM> ramList;
    //SSD
    List<SSDCompany> ssdCompanyList;
    List<SSD> ssdList;
    //HDD
    List<HDDCompany> hddCompanyList;
    List<HDD> hddList;
    //Power Supply
    List<PowerSupplyCompany> powerSupplyCompanyList;
    List<PowerSupply> powerSupplyList;
    //Cooler
    List<CoolerCompany> coolerCompanyList;
    List<Cooler> coolerList;
    //PC Case
    List<PCCaseCompany> pcCaseCompanyList;
    List<PCCase>pcCaseList;


    public SelectListAdapter(Activity activity,Context context, String type, String mode){
        this.activity = activity;
        this.context = context;
        this.type = type;
        this.mode = mode;

        layoutInflater = LayoutInflater.from(context);
    }


    //Setters
    public void setCompany(String companyValue){
        this.companyValue = companyValue;
    }
    public void setProcessorCompanyList(List<ProcessorCompany> processorCompanyList) {
        this.processorCompanyList = processorCompanyList;
    }
    public void setProcessorList(List<Processor> processorList) {
        this.processorList = processorList;
    }
    public void setVideocardCompanyList(List<VideocardCompany> videocardCompanyList) {
        this.videocardCompanyList = videocardCompanyList;
    }
    public void setVideocardList(List<Videocard> videocardList) {
        this.videocardList = videocardList;
    }
    public void setMotherboardCompanyList(List<MotherboardCompany> motherboardCompanyList) {
        this.motherboardCompanyList = motherboardCompanyList;
    }
    public void setMotherboardList(List<Motherboard> motherboardList) {
        this.motherboardList = motherboardList;
    }
    public void setRamCompanyList(List<RAMCompany> ramCompanyList) {
        this.ramCompanyList = ramCompanyList;
    }
    public void setRamList(List<RAM> ramList) {
        this.ramList = ramList;
    }
    public void setSsdCompanyList(List<SSDCompany> ssdCompanyList) {
        this.ssdCompanyList = ssdCompanyList;
    }
    public void setSsdList(List<SSD> ssdList) {
        this.ssdList = ssdList;
    }
    public void setHddCompanyList(List<HDDCompany> hddCompanyList) {
        this.hddCompanyList = hddCompanyList;
    }
    public void setHddList(List<HDD> hddList) {
        this.hddList = hddList;
    }
    public void setPowerSupplyCompanyList(List<PowerSupplyCompany> powerSupplyCompanyList) {
        this.powerSupplyCompanyList = powerSupplyCompanyList;
    }
    public void setPowerSupplyList(List<PowerSupply> powerSupplyList) {
        this.powerSupplyList = powerSupplyList;
    }
    public void setCoolerCompanyList(List<CoolerCompany> coolerCompanyList) {
        this.coolerCompanyList = coolerCompanyList;
    }
    public void setCoolerList(List<Cooler> coolerList) {
        this.coolerList = coolerList;
    }
    public void setPcCaseCompanyList(List<PCCaseCompany> pcCaseCompanyList) {
        this.pcCaseCompanyList = pcCaseCompanyList;
    }
    public void setPcCaseList(List<PCCase> pcCaseList) {
        this.pcCaseList = pcCaseList;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String none = type;
        if(type!=null) {
            Mode(type,mode,holder,position);
        }

        holder.arg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                sentArg1(holder.arg1);
            }
        });

        holder.arg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sentArg2AndArg3(holder.arg1,holder.arg2,holder.arg3,position);
            }
        });


    }







    private void sentArg1(TextView arg1){
        Intent intent = new Intent();
        intent.putExtra(CONSTANT.TYPE,type);
        intent.putExtra(CONSTANT.MODE,mode);
        intent.putExtra(CONSTANT.COMPANY_VALUE,arg1.getText().toString());
        activity.setResult(Activity.RESULT_OK,intent);
        activity.finish();
    }

    private void sentArg2AndArg3(TextView arg1, TextView arg2, TextView arg3, int pos){
        Intent intent = new Intent();
        intent.putExtra(CONSTANT.TYPE,type);
        intent.putExtra(CONSTANT.MODE,mode);
        if(arg1!=null)
            intent.putExtra(CONSTANT.COMPANY_VALUE,arg1.getText().toString());

        intent.putExtra(CONSTANT.MODEL_VALUE,arg2.getText().toString());
        intent.putExtra(CONSTANT.PRICE_VALUE,arg3.getText().toString());

        if(type.equals(CONSTANT.PC_CASE))
            intent.putExtra(CONSTANT.IMAGE_URL,pcCaseList.get(pos).getImageURL());

        activity.setResult(Activity.RESULT_OK,intent);
        activity.finish();



    }









    //Set Data
    private void Mode(String type,String mode,ViewHolder viewHolder, int position){

        linearLayout = viewHolder.container;

        textView1 = viewHolder.arg1;
        textView2 = viewHolder.arg2;
        textView3 = viewHolder.arg3;

        containerArg1 = viewHolder.containerArg1;
        containerArg2 = viewHolder.containerArg2;
        containerArg3 = viewHolder.containerArg3;

        if(mode!=null) {
            switch (mode){
                case CONSTANT.COMPANY:
                    showCompany(type,viewHolder,position);
                    return;
                case CONSTANT.MODEL:
                    showModel(type,viewHolder,position);
                    return;
                case CONSTANT.MODEL_ALL:
                    showModelAll(type,viewHolder,position);
                    return;
            }
        }
    }

    private void showCompany(String type,ViewHolder view, int position) {
        String company = "";
        switch (type){
            case CONSTANT.PROCESSOR:
                company = processorCompanyList.get(position).getCompany();
                break;
            case CONSTANT.VIDEOCARD:
                company = videocardCompanyList.get(position).getCompany();
                break;
            case CONSTANT.MOTHERBOARD:
                company = motherboardCompanyList.get(position).getCompany();
                break;
            case CONSTANT.RAM:
                company = ramCompanyList.get(position).getCompany();
                break;
            case CONSTANT.SSD:
                company = ssdCompanyList.get(position).getCompany();
                break;
            case CONSTANT.HDD:
                company = hddCompanyList.get(position).getCompany();
                break;
            case CONSTANT.POWER_SUPPLY:
                company = powerSupplyCompanyList.get(position).getCompany();
                break;
            case CONSTANT.COOLER:
                company = coolerCompanyList.get(position).getCompany();
                break;
            case CONSTANT.PC_CASE:
                company = pcCaseCompanyList.get(position).getCompany();
                break;

        }

        view.arg1.setText(company);
        removeArg2andArg3();
    }

    private void showModel(String type,ViewHolder view, int position) {
        String model = "";
        String price = "";

        switch (type){
            case CONSTANT.PROCESSOR:
                model = processorList.get(position).getModel();
                price = processorList.get(position).getPrice();
                break;
            case CONSTANT.VIDEOCARD:
                model = videocardList.get(position).getModel();
                price = videocardList.get(position).getPrice();
                break;
            case CONSTANT.MOTHERBOARD:
                model = motherboardList.get(position).getModel();
                price = motherboardList.get(position).getPrice();
                break;
            case CONSTANT.RAM:
                model = ramList.get(position).getModel();
                price = ramList.get(position).getPrice();
                break;
            case CONSTANT.SSD:
                model = ssdList.get(position).getModel();
                price = ssdList.get(position).getPrice();
                break;
            case CONSTANT.HDD:
                model = hddList.get(position).getModel();
                price = hddList.get(position).getPrice();
                break;
            case CONSTANT.POWER_SUPPLY:
                model = powerSupplyList.get(position).getModel();
                price = powerSupplyList.get(position).getPrice();
                break;
            case CONSTANT.COOLER:
                model = coolerList.get(position).getModel();
                price = coolerList.get(position).getPrice();
                break;
            case CONSTANT.PC_CASE:
                model = pcCaseList.get(position).getModel();
                price = pcCaseList.get(position).getPrice();
                break;
        }


        view.arg2.setText(model);
        view.arg3.setText(price);
        removeArg1();
    }

    private void showModelAll(String type,ViewHolder view, int position) {
        String company = "";
        String model = "";
        String price = "";


        switch (type){
            case CONSTANT.PROCESSOR:
                company = processorList.get(position).getCompany();
                model = processorList.get(position).getModel();
                price = processorList.get(position).getPrice();
                break;
            case CONSTANT.VIDEOCARD:
                company = videocardList.get(position).getCompany();
                model = videocardList.get(position).getModel();
                price = videocardList.get(position).getPrice();
                break;
            case CONSTANT.MOTHERBOARD:
                company = motherboardList.get(position).getCompany();
                model = motherboardList.get(position).getModel();
                price = motherboardList.get(position).getPrice();
                break;
            case CONSTANT.RAM:
                company = ramList.get(position).getCompany();
                model = ramList.get(position).getModel();
                price = ramList.get(position).getPrice();
                break;
            case CONSTANT.SSD:
                company = ssdList.get(position).getCompany();
                model = ssdList.get(position).getModel();
                price = ssdList.get(position).getPrice();
                break;
            case CONSTANT.HDD:
                company = hddList.get(position).getCompany();
                model = hddList.get(position).getModel();
                price = hddList.get(position).getPrice();
                break;
            case CONSTANT.POWER_SUPPLY:
                company = powerSupplyList.get(position).getCompany();
                model = powerSupplyList.get(position).getModel();
                price = powerSupplyList.get(position).getPrice();
                break;
            case CONSTANT.COOLER:
                company = coolerList.get(position).getCompany();
                model = coolerList.get(position).getModel();
                price = coolerList.get(position).getPrice();
                break;
            case CONSTANT.PC_CASE:
                company = pcCaseList.get(position).getCompany();
                model = pcCaseList.get(position).getModel();
                price = pcCaseList.get(position).getPrice();
                break;
        }


        view.arg1.setText(company);
        view.arg2.setText(model);
        view.arg3.setText(price);
    }









    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView arg1;
        TextView arg2;
        TextView arg3;
        LinearLayout container;
        LinearLayout containerArg1;
        LinearLayout containerArg2;
        LinearLayout containerArg3;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            arg1 = itemView.findViewById(R.id.list_choise_arg1_tv);
            arg2 = itemView.findViewById(R.id.list_choise_arg2_tv);
            arg3 = itemView.findViewById(R.id.list_choise_arg3_tv);
            container = itemView.findViewById(R.id.list_choise_container);
            containerArg1 = itemView.findViewById(R.id.list_choise_container_arg1_tv);
            containerArg2 = itemView.findViewById(R.id.list_choise_container_arg2_tv);
            containerArg3 = itemView.findViewById(R.id.list_choise_container_arg3_tv);

        }

       /* @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.list_choise_arg1_tv:

                    break;
                case R.id.list_choise_arg2_tv:

                    break;
            }
        }*/



    }



    @Override
    public int getItemCount() {
        return modeItemCount();
    }



    private int modeItemCount(){
        if(mode!=null && mode!=null) {
            switch (mode) {
                case CONSTANT.COMPANY:
                    return companyListSize(type);
                case CONSTANT.MODEL:
                    return modelListSize(type);
                case CONSTANT.MODEL_ALL:
                    return modelListSize(type);
            }
        }
        return 0;
    }

    //If add new list just change it
    private int companyListSize(String type){
        switch (type){
            case CONSTANT.PROCESSOR:
                if(processorCompanyList == null) return 0;
                    return processorCompanyList.size();
            case CONSTANT.VIDEOCARD:
                if(videocardCompanyList == null) return 0;
                    return videocardCompanyList.size();
            case CONSTANT.MOTHERBOARD:
                if(motherboardCompanyList == null) return 0;
                    return motherboardCompanyList.size();
            case CONSTANT.RAM:
                if(ramCompanyList == null) return 0;
                    return ramCompanyList.size();
            case CONSTANT.SSD:
                if(ssdCompanyList == null) return 0;
                return ssdCompanyList.size();
            case CONSTANT.HDD:
                if(hddCompanyList == null) return 0;
                return hddCompanyList.size();
            case CONSTANT.POWER_SUPPLY:
                if(powerSupplyCompanyList == null) return 0;
                return powerSupplyCompanyList.size();
            case CONSTANT.COOLER:
                if(coolerCompanyList == null) return 0;
                return coolerCompanyList.size();
            case CONSTANT.PC_CASE:
                if(pcCaseCompanyList == null) return 0;
                return pcCaseCompanyList.size();

        }
        return 0;
    }

    private int modelListSize(String type){
        switch (type){
            case CONSTANT.PROCESSOR:
                if(processorList == null) return 0;
                    return processorList.size();
            case CONSTANT.VIDEOCARD:
                if(videocardList == null) return 0;
                    return videocardList.size();
            case CONSTANT.MOTHERBOARD:
                if(motherboardList == null) return 0;
                    return motherboardList.size();
            case CONSTANT.RAM:
                if(ramList == null) return 0;
                    return ramList.size();
            case CONSTANT.SSD:
                if(ssdList == null) return 0;
                return ssdList.size();
            case CONSTANT.HDD:
                if(hddList == null) return 0;
                return hddList.size();
            case CONSTANT.POWER_SUPPLY:
                if(powerSupplyList == null) return 0;
                return powerSupplyList.size();
            case CONSTANT.COOLER:
                if(coolerList == null) return 0;
                return coolerList.size();
            case CONSTANT.PC_CASE:
                if(pcCaseList == null) return 0;
                return pcCaseList.size();

        }
        return 0;
    }









    @NonNull
    @Override
    public SelectListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.list_select,parent,false);
        return new ViewHolder(view);
    }





    private void removeArg1(){
        if(linearLayout!=null && containerArg1!=null)
            linearLayout.removeView(containerArg1);
    }

    private void removeArg2andArg3(){
        if(linearLayout!=null && containerArg2!=null && containerArg3!=null) {
            linearLayout.removeView(containerArg2);
            linearLayout.removeView(containerArg3);

        }
    }



}
