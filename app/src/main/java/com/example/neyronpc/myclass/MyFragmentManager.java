package com.example.neyronpc.myclass;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.neyronpc.R;
import com.example.neyronpc.cart_fragments.CartFragment;
import com.example.neyronpc.general_fragments.MainGeneralFragment;
import com.example.neyronpc.order_fragments.OrderFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyFragmentManager {

    //CONST
    private String MAIN = "MAIN";
    private String CART = "CART";
    private String ORDER = "ORDER";

    Context context;
    FragmentManager fragmentManager;
    int container;

    List<String> fragmentTags;
    List<String> headerTexts;
    List<Fragment> fragmentList;
    TextView header;


    public MyFragmentManager(Context context, FragmentManager fragmentManager, int container, TextView header){
        this.fragmentManager = fragmentManager;
        this.container = container;
        this.header = header;
        this.context = context;

        fragmentTags = new ArrayList<>();
        headerTexts = new ArrayList<>();
        fragmentList = new ArrayList<>();
    }

    private int stackSize(){
        if(fragmentTags==null) return 0;
        return fragmentTags.size();
    }


    public void addFragment(Fragment fragment, String tag, String headerText){
        if(!isHasInStack(tag)) {

            if(tag!=MAIN)
                 fragmentManager
                    .beginTransaction()
                    .add(container,fragment)
                    .addToBackStack(tag)
                    .commit();
            else fragmentManager
                    .beginTransaction()
                    .add(container,fragment)
                    .commit();

            header.setText(headerText);
            headerTexts.add(headerText);
            fragmentTags.add(tag);
            fragmentList.add(fragment);

        }
        else{
            removeAll();
            if(tag == MAIN) return;

            fragmentManager
                    .beginTransaction()
                    .add(container,fragment)
                    .addToBackStack(tag)
                    .commit();

            header.setText(headerText);
            headerTexts.add(headerText);
            fragmentTags.add(tag);
            fragmentList.add(fragment);

        }

    }

    private boolean isHasInStack(String tag){
        if(fragmentTags.size()==0) return false;

        for(int i=0; i<stackSize(); i++){
            if(fragmentTags.get(i).equals(tag)) return true;
        }

        return false;
    }

    private void removeFragment(String tag){

    }

    private void removeAll(){
        for(int i=stackSize()-1; i>0; i--) {
            fragmentManager.popBackStack();
            fragmentTags.remove(i);
            headerTexts.remove(i);
            fragmentList.remove(i);
        }
    }

    public void back(){

        if(stackSize()>0){
            int size = stackSize();
            fragmentTags.remove(size-1);
            headerTexts.remove(size-1);
            if(stackSize()!=0) {
                header.setText(headerTexts.get(stackSize() - 1));
            }
        }
        Log.v("Stack size ", String.valueOf(stackSize()));
    }




    //Add Fragments
    public void loadMainGeneralFragment(){
        MainGeneralFragment mainGeneralFragment = new MainGeneralFragment();
        this.addFragment(mainGeneralFragment, MAIN, context.getResources().getString(R.string.main));
    }

    public void loadCartFragment(){
        CartFragment cartFragment = new CartFragment();
        this.addFragment(cartFragment, CART, context.getResources().getString(R.string.cart));
    }

    public void  loadOrderFragment(){
        OrderFragment orderFragment = new OrderFragment();
        this.addFragment(orderFragment,ORDER, context.getResources().getString(R.string.order));
    }



    //For developer
    public void showStack(){
        for(int i=0; i<stackSize(); i++){
            Log.v("Stack "+String.valueOf(i),fragmentTags.get(i));
        }
    }

    public void showFragmentManagerFragmentList(){
        for(int i=0; i<fragmentManager.getFragments().size(); i++){
            Log.v("Fragment manager "+String.valueOf(i),String.valueOf(fragmentManager.getFragments().get(i)));
        }
    }
}
