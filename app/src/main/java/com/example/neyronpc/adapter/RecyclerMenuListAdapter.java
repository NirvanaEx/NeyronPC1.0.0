package com.example.neyronpc.adapter;

import android.content.Context;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.neyronpc.R;
import com.example.neyronpc.data.PC;
import com.example.neyronpc.myclass.MyFragmentManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecyclerMenuListAdapter extends RecyclerView.Adapter<RecyclerMenuListAdapter.ViewHolder>  {

    private LayoutInflater inflater;
    private List<String> menuList;
    private Context context;
    private TextView toolBarHeaderTextView;
    private MyFragmentManager myFragmentManager;


    private DrawerLayout drawerLayout;
    private View view;


    public RecyclerMenuListAdapter(Context context, TextView textView, MyFragmentManager myFragmentManager) {
        menuList = Arrays.asList(context.getResources().getStringArray(R.array.menu_list));
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        toolBarHeaderTextView = textView;
        this.myFragmentManager = myFragmentManager;

    }

    public void setDrawerConfig(View view, DrawerLayout drawerLayout){
        this.drawerLayout = drawerLayout;
        this.view =view;
    }
    @Override
    public RecyclerMenuListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_group, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerMenuListAdapter.ViewHolder holder, int position) {
        holder.menuListTextView.setText(menuList.get(position));

        if(menuList.get(position).equals(context.getResources().getString(R.string.cart))){
            holder.menuListTextView.setTextColor(context.getResources().getColor(R.color.orange));
            holder.menuListMessageTextView.setVisibility(View.VISIBLE);
        }


    }



    @Override
    public int getItemCount() {
        return menuList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView menuListTextView;
        TextView menuListMessageTextView;
        RelativeLayout relativeLayout;


        ViewHolder(View view) {
            super(view);
            menuListTextView = view.findViewById(R.id.list_view_title_tv);
            menuListMessageTextView = view.findViewById(R.id.list_view_number_tv);
            relativeLayout = view.findViewById(R.id.list_group_relativelayout);

            menuListTextView.setOnClickListener(this);
            relativeLayout.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {

            if(v.getId() == R.id.list_view_title_tv || v.getId() == R.id.list_group_relativelayout)
                changeHeader();

        }

        private void changeHeader() {
            TypedValue outValue = new TypedValue();
            context.getTheme().resolveAttribute(android.R.attr.selectableItemBackground, outValue, true);
            relativeLayout.setBackgroundResource(outValue.resourceId);
            toolBarHeaderTextView.setText(menuListTextView.getText());



            if(menuListTextView.getText().toString().equals(context.getResources().getString(R.string.main)))
                myFragmentManager.loadMainGeneralFragment();
            else if(menuListTextView.getText().toString().equals(context.getResources().getString(R.string.cart)))
                myFragmentManager.loadCartFragment();
            else if(menuListTextView.getText().toString().equals(context.getResources().getString(R.string.order)))
                myFragmentManager.loadOrderFragment();



            if(drawerLayout!=null && view != null)
                drawerLayout.closeDrawer(view);

        }
    }

}