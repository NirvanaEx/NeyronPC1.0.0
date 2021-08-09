package com.example.neyronpc.authorization_fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.neyronpc.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SingUpFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SingUpFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SingUpFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SingUpFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SingUpFragment newInstance(String param1, String param2) {
        SingUpFragment fragment = new SingUpFragment();
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


    private View view;
    private TextView singIn;
    private Button registration;
    private EditText login;
    private EditText pass;
    private EditText passConfirm;
    private EditText email;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view =  inflater.inflate(R.layout.fragment_sing_up, container, false);
        initViews();
        return view;
    }

    private void initViews(){
        singIn = view.findViewById(R.id.sign_up_sign_in_tv);
        registration = view.findViewById(R.id.sign_up_reg_button);
        login = view.findViewById(R.id.sing_up_login_et);
        pass = view.findViewById(R.id.sing_up_confirm_password_et);
        passConfirm = view.findViewById(R.id.sing_up_confirm_password_et);
        email = view.findViewById(R.id.sing_up_email_et);

        singIn.setOnClickListener(this);
        registration.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sign_up_sign_in_tv:
                signIn();
                break;
            case R.id.sign_up_reg_button:
                regUser();
                break;

        }
    }

    private void signIn(){
        SingInFragment singInFragment = new SingInFragment();

        getActivity().getSupportFragmentManager()
                     .beginTransaction()
                     .replace(R.id.autorization_fragment_layout,singInFragment)
                     .commit();
    }

    private void regBtn(Bundle bundle){
        ConfirmRegistationFragment confirmRegistationFragment = new ConfirmRegistationFragment();
        confirmRegistationFragment.setArguments(bundle);
        getActivity().getSupportFragmentManager()
                     .beginTransaction()
                     .add(R.id.autorization_fragment_layout,confirmRegistationFragment)
                     .commit();
    }

    private void regUser(){
        String loginStr = login.getText().toString();
        String passStr = pass.getText().toString();
        String passConfirmStr = pass.getText().toString();
        String emailStr = email.getText().toString();

        Bundle bundle = new Bundle();
        bundle.putString("login",loginStr);
        bundle.putString("pass",passStr);
        bundle.putString("email",emailStr);
        regBtn(bundle);

    }

}