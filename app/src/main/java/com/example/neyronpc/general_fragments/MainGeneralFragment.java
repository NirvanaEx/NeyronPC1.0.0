package com.example.neyronpc.general_fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.neyronpc.R;
import com.example.neyronpc.adapter.TabLayoutAdadter;
import com.google.android.material.tabs.TabLayout;

import static androidx.fragment.app.FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainGeneralFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainGeneralFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MainGeneralFragment() {
        // Required empty public constructor
    }

    public MainGeneralFragment(Context context, TextView header) {
        this.context = context;
        toolbarHeaderText = header;
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainGeneralFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainGeneralFragment newInstance(String param1, String param2) {
        MainGeneralFragment fragment = new MainGeneralFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }



    Context context;
    ViewPager viewPager;
    TabLayout tabLayout;
    View views;

    //Toolbar Views
    TextView toolbarHeaderText;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        views = inflater.inflate(R.layout.fragment_main_general, container, false);
        initViews();
        setupAdapters();

        return views;
    }


    public void setHeader(){
        if(toolbarHeaderText!=null) toolbarHeaderText.setText(context.getResources().getString(R.string.main));
    }

    private void initViews() {
        viewPager = views.findViewById(R.id.general_activity_viewpager);
        tabLayout = views.findViewById(R.id.general_activity_tab_layout);
    }

    private void setupAdapters() {
        TabLayoutAdadter tabLayoutAdadter = new TabLayoutAdadter(getChildFragmentManager(), BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        tabLayoutAdadter.setTabLayout(tabLayout, getContext());
        viewPager.setOffscreenPageLimit(2);
        viewPager.setAdapter(tabLayoutAdadter);
        tabLayout.setupWithViewPager(viewPager);


    }


}