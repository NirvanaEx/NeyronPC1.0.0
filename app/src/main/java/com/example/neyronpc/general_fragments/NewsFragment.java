package com.example.neyronpc.general_fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.neyronpc.R;
import com.example.neyronpc.adapter.DataAdapter;
import com.example.neyronpc.data.PC;

import java.util.ArrayList;
import java.util.List;


public class NewsFragment extends Fragment implements View.OnClickListener {

    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;


    public NewsFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPage = getArguments().getInt(ARG_PAGE);
        }


    }

    private boolean filterBtnPressed = false;
    private boolean advancedFilterSelected = false;


    //Views
    View view;
    RecyclerView recyclerView;
    DataAdapter dataAdapter;
    ScrollView scrollView;
    Button filterBtn;
    CheckBox advancedCheckBox;
    LinearLayout linearLayout;


    //Other Views
    LayoutInflater layoutInflater;
    View priceViewFilter;
    View advancedViewFilter;
    View filterView;
    View showDataFilterView;


    //Data
    List<PC> pc;
    Bundle bundle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_new, container, false);
        initViews();
        initData();
        showData();
        initViewGroup();
        return view;
    }

    private void initViews(){
        recyclerView = view.findViewById(R.id.fragment_news_recycler_view);
        scrollView = view.findViewById(R.id.fragment_news_scrollview);
        filterBtn = view.findViewById(R.id.fragment_news_filter_btn);
        linearLayout = view.findViewById(R.id.fragment_news_filtershow_container);



        recyclerView.setNestedScrollingEnabled(false);
        filterBtn.setOnClickListener(this);

        layoutInflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    private void initFilterViews(){
        advancedCheckBox = priceViewFilter.findViewById(R.id.filter_advanced_search_checkbox);

        advancedCheckBox.setOnClickListener(this);
    }
    private void initViewGroup(){
        if(priceViewFilter == null || showDataFilterView == null || advancedViewFilter == null) {
            priceViewFilter = layoutInflater.inflate(R.layout.filter, null);
            advancedViewFilter = layoutInflater.inflate(R.layout.filter_advanced, null);
            showDataFilterView = layoutInflater.inflate(R.layout.filter_show_data, null);

            initFilterViews();
        }


    }


    private void initData(){
        pc = new ArrayList<>();

        PC pc1 = new PC();
        pc1.setImageURL("https://3dnews.ru/assets/external/illustrations/2020/01/15/1001454/aero1.jpg");
        pc1.setName("Игровое");
        pc1.setProcessor("Intel Core i5 9600K");
        pc1.setVideocard("RTX 2070 SUPER");
        pc1.setHdd("2 TB");
        pc1.setSsd("512 GB");
        pc1.setRam("32 GB");
        pc1.setPrice("10.000.000 "+"UZS");
        PC pc2 = new PC();
        pc2.setImageURL("https://3dnews.ru/assets/external/illustrations/2020/01/15/1001454/aero1.jpg");
        pc2.setName("Игровое");
        pc2.setProcessor("Intel Core i5 9600K");
        pc2.setVideocard("RTX 2070 SUPER");
        pc2.setHdd("2 TB");
        pc2.setSsd("512 GB");
        pc2.setRam("32 GB");
        pc2.setPrice("9.500.000 "+"UZS");
        pc.add(pc1);
        pc.add(pc2);
        pc.add(pc1);
        pc.add(pc1);
        pc.add(pc1);
        pc.add(pc1);
        pc.add(pc1);
        pc.add(pc1);
        pc.add(pc1);


    }
    private void showData(){
        dataAdapter = new DataAdapter(getContext(),pc);
        recyclerView.setAdapter(dataAdapter);
    }



    private void showMainFilter(){
        initViewGroup();
        if(!filterBtnPressed && !advancedFilterSelected) {
            mainFilter();
            filterBtnPressed = true;
        }
        else if(!filterBtnPressed && advancedFilterSelected){
            advancedFilter();
            filterBtnPressed = true;
        }
        else{
            linearLayout.removeAllViews();
            filterBtnPressed = false;
        }
    }

    private void showAdvancedFilter(){
        initViewGroup();

        if(filterBtnPressed && !advancedFilterSelected){
            advancedFilter();
            advancedFilterSelected = true;
        }
        else if(filterBtnPressed && advancedFilterSelected){
            mainFilter();
            advancedFilterSelected = false;
        }
    }



    private void mainFilter(){

        linearLayout.removeAllViews();
        linearLayout.addView(priceViewFilter);
        linearLayout.addView(showDataFilterView);
    }

    private void advancedFilter(){
        linearLayout.removeAllViews();
        linearLayout.addView(priceViewFilter);
        linearLayout.addView(advancedViewFilter);
        linearLayout.addView(showDataFilterView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fragment_news_filter_btn:
                showMainFilter();
                break;
            case R.id.filter_advanced_search_checkbox:
                showAdvancedFilter();
                break;
        }
    }


}
