package com.example.neyronpc.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.neyronpc.R;
import com.example.neyronpc.data.PC;

import java.net.URL;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>  {

    private LayoutInflater inflater;
    private List<PC> pcList;
    private Context context;

    public DataAdapter(Context context, List<PC> list) {
        pcList = list;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.cardview_option1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {

        PC pc = pcList.get(position);

        holder.pcName.setText(pc.getName());
        holder.processor.setText(pc.getProcessor());
        holder.videocard.setText(pc.getVideocard());
        holder.ram.setText(pc.getRam());
        holder.ssd.setText(pc.getSsd());
        holder.hdd.setText(pc.getHdd());
        holder.price.setText(pc.getPrice());

        //TODO add isNew Icon visibility

        Log.v("Recycler View",pc.getHdd());
        Glide.with(context)
                .load(pc.getImageURL())
                .centerCrop()
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return pcList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{


        TextView pcName;
        TextView processor;
        TextView videocard;
        TextView ram;
        TextView ssd;
        TextView hdd;
        TextView price;
        Button inCard;
        ImageView imageView;

        ViewHolder(View view){
            super(view);
            pcName = view.findViewById(R.id.cardview_option1_pc_name_tv);
            processor = view.findViewById(R.id.cardview_option1_processor_tv);
            videocard =view.findViewById(R.id.cardview_option1_videocard_tv);
            ram = view.findViewById(R.id.cardview_option1_ram_tv);
            ssd = view.findViewById(R.id.cardview_option1_ssd_tv);
            hdd = view.findViewById(R.id.cardview_option1_hdd_tv);
            price = view.findViewById(R.id.cardview_option1_price_tv);
            inCard = view.findViewById(R.id.cardview_option1_incard_btn);
            imageView = view.findViewById(R.id.cardview_option1_pc_image);


            inCard.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.cardview_option1_incard_btn:
                    Toast.makeText(context,"In Card!",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }


}