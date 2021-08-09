package com.example.neyronpc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.example.neyronpc.adapter.RecyclerMenuListAdapter;
import com.example.neyronpc.cart_fragments.CartFragment;
import com.example.neyronpc.general_fragments.MainGeneralFragment;
import com.example.neyronpc.myclass.MyFragmentManager;

public class GeneralActivity extends AppCompatActivity implements View.OnClickListener {



    //Manager
    MyFragmentManager myFragmentManager;

    //CONST
    final int MAIN_CONTAINER = R.id.general_activity_main_container;
    final String CART = "CART";
    final String MAIN = "MAIN";

    //Views
    RecyclerView recyclerView;
    View toolbarView;
    DrawerLayout drawerLayout;
    LinearLayout navigView;

    //ToolbarViews
    ImageButton cardImageButton;
    ImageButton menuImageButton;
    TextView toolbarHeader;
    //Edittext container
    RelativeLayout containerEdittext;


    //Fragments


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);


        initViews();
        myFragmentManager = new MyFragmentManager(this,getSupportFragmentManager(),MAIN_CONTAINER, toolbarHeader);
        loadMainFragment();
        setupAdapters();

    }

    private void initViews(){
        toolbarView = findViewById(R.id.general_activity_toolbarlayout);
        recyclerView = findViewById(R.id.general_activity_menu_list_recyclerview);
        navigView = findViewById(R.id.general_activity_navigation_view);
        drawerLayout = findViewById(R.id.general_activity_drawerlayout);


        //TODO maybe need delete
        containerEdittext = findViewById(R.id.general_activity_edittext_container);

        containerEdittext.setVisibility(View.INVISIBLE);
        containerEdittext.setClickable(false);

        initToolbarViews();
    }


    private void initToolbarViews() {
        cardImageButton = toolbarView.findViewById(R.id.toolbar_card_imagebtn);
        menuImageButton = toolbarView.findViewById(R.id.toolbar_menu_imagebtn);
        toolbarHeader = toolbarView.findViewById(R.id.toolbar_header_tv);

        cardImageButton.setOnClickListener(this);
        menuImageButton.setOnClickListener(this);
    }

    private void loadMainFragment(){
        myFragmentManager.loadMainGeneralFragment();
    }

    private void cartImgBtnPressed() {
        myFragmentManager.loadCartFragment();
    }

    private void setupAdapters(){
        RecyclerMenuListAdapter recyclerMenuListAdapter = new RecyclerMenuListAdapter(getApplicationContext(),toolbarHeader,myFragmentManager);
        recyclerMenuListAdapter.setDrawerConfig(navigView,drawerLayout);
        recyclerView.setAdapter(recyclerMenuListAdapter);
        recyclerView.setNestedScrollingEnabled(false);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        myFragmentManager.back();
        myFragmentManager.showFragmentManagerFragmentList();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.toolbar_card_imagebtn:
                cartImgBtnPressed();
                break;
            case R.id.toolbar_menu_imagebtn:
                openMenu();
                break;
        }
    }

    private void openMenu() {
        drawerLayout.openDrawer(navigView);
    }


    private void back(){

    }


}