package com.example.neyronpc.authorization_fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

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
 * Use the {@link ConfirmRegistationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ConfirmRegistationFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ConfirmRegistationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ConfirmRegistationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ConfirmRegistationFragment newInstance(String param1, String param2) {
        ConfirmRegistationFragment fragment = new ConfirmRegistationFragment();
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

    View views;
    Bundle userDataReg;
    Button confirmReg;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        views =  inflater.inflate(R.layout.fragment_confirm_registation, container, false);
        userDataReg = this.getArguments();
        initView();
        return views;
    }


    private void initView(){
        confirmReg = views.findViewById(R.id.confirm_registration_btn_confirm);

        confirmReg.setOnClickListener(this);
    }

    private void finishRegistation(){

        ApiServices apiServices = NeyronPCService.getAPI().create(ApiServices.class);
        Log.v("LOGIN", userDataReg.getString("login"));
        Log.v("PASS", userDataReg.getString("pass"));
        Log.v("EMAIL", userDataReg.getString("email"));

        apiServices.userReg(
                userDataReg.getString("login"),
                userDataReg.getString("pass"),
                userDataReg.getString("email")
        ).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful() && response.body().getMessage().equals("success")){
                    Toast.makeText(getContext(),"Congratulation",Toast.LENGTH_SHORT).show();
                    Intent generalApp = new Intent(getActivity(), GeneralActivity.class);
                    generalApp.putExtras(userDataReg);
                    startActivity(generalApp);
                    getActivity().finish();
                }
                else{
                    Toast.makeText(getContext(),response.body().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.confirm_registration_btn_confirm:

                finishRegistation();
                break;
        }
    }
}