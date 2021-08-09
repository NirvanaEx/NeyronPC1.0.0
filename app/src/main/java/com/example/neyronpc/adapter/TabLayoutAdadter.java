package com.example.neyronpc.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.neyronpc.R;
import com.example.neyronpc.general_fragments.AllFragment;
import com.example.neyronpc.general_fragments.CollectYouFragment;
import com.example.neyronpc.general_fragments.NewsFragment;
import com.google.android.material.tabs.TabLayout;

public class TabLayoutAdadter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 3;
    private String tabTitles[] = {"Новинки","Все","Собери сам"};
    private Context context;
    private TabLayout tabLayout;

    private NewsFragment newsFragment;
    private AllFragment allFragment;
    private  CollectYouFragment collectYouFragment;


    public TabLayoutAdadter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public void setTabLayout(TabLayout tabLayout, Context context){
        this.tabLayout = tabLayout;
        this.context = context;
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                if(newsFragment==null)
                 newsFragment =  new NewsFragment();

                return newsFragment;
            case 1:
                if(allFragment==null)
                    allFragment =  new AllFragment();

                return allFragment;
            case 2:
                if(collectYouFragment==null)
                    collectYouFragment =  new CollectYouFragment();

                return collectYouFragment;
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 1 && context!=null && tabLayout!=null){
            tabLayout.setTabTextColors(context.getResources().getColor(R.color.red),context.getResources().getColor(R.color.white));
        }
        return tabTitles[position];
    }
}
