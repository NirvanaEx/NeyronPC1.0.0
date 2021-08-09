package com.example.neyronpc.authorization_fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.neyronpc.AuthorizationActivity;
import com.example.neyronpc.GeneralActivity;
import com.example.neyronpc.R;
import com.example.neyronpc.data.User;
import com.example.neyronpc.interfaces.ApiServices;
import com.example.neyronpc.service.NeyronPCService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SingInFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SingInFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SingInFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SingInFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SingInFragment newInstance(String param1, String param2) {
        SingInFragment fragment = new SingInFragment();
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



    //Strings
    String loginStr;
    String passStr;

    //Views
    private View view;
    private TextView fogotPressHere;
    private TextView registration;
    private EditText login;
    private EditText password;
    private Button enterBtn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_sing_in, container, false);
        Intent intent = new Intent(getContext(),GeneralActivity.class);
        startActivity(intent);
        getActivity().finish();
        initViews();
        return view;
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        if(outState==null){
            outState.putString("login",login.getText().toString());
            outState.putString("pass",login.getText().toString());
            Log.v("Save", "saved! data");
        }
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if(savedInstanceState!=null){
            if(savedInstanceState.getString("login")!=null && savedInstanceState.getString("pass")!=null){
                loginStr = savedInstanceState.getString("login");
                passStr = savedInstanceState.getString("pass");
                connectCheckUser(loginStr,passStr);
            }
            Log.v("login", loginStr);
        }
    }

    void initViews(){
        fogotPressHere = view.findViewById(R.id.sing_in_press_here);
        registration = view.findViewById(R.id.sing_in_registation_tv);

        login = view.findViewById(R.id.sing_in_login_et);
        password = view.findViewById(R.id.sing_in_password_et);
        enterBtn = view.findViewById(R.id.sing_in_enter_btn);
        //Set Click Listener
        fogotPressHere.setOnClickListener(this);
        registration.setOnClickListener(this);
        enterBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sing_in_press_here:
                Toast.makeText(getContext(),"Потерял пароль",Toast.LENGTH_SHORT).show();
                break;
            case R.id.sing_in_registation_tv:
                singUp();
                break;
            case R.id.sing_in_enter_btn:
                checkUser();
                break;
        }

    }

    private void checkUser(){
        loginStr = login.getText().toString();
        passStr = password.getText().toString();


        connectCheckUser(loginStr, passStr);
    }

    private void singUp(){
        SingUpFragment singUpFragment = new SingUpFragment();
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.autorization_fragment_layout,singUpFragment)
                .commit();
    }

    private void connectCheckUser(String loginStr, String passStr){
        ApiServices apiServices = NeyronPCService.getAPI().create(ApiServices.class);
        Call<User> userCall = apiServices.userLogin(loginStr,passStr);

        userCall.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful() && response.body().getMessage().equals("success")){
                    Intent intent = new Intent(getActivity(), GeneralActivity.class);
                    startActivity(intent);
                    getActivity().finish();
                }
                else{
                    //TODO Нужно написать ошибку если пользователь неправильно ввел данные
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                // TODO Обработка непредвиденных ошибок
            }
        });
    }
}