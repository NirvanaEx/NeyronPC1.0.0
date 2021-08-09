package com.example.neyronpc.general_fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.neyronpc.CONSTANT;
import com.example.neyronpc.SelectListActivity;
import com.example.neyronpc.ImageGridActivity;
import com.example.neyronpc.R;
import com.example.neyronpc.myclass.BeautyPrice;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CollectYouFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CollectYouFragment extends Fragment implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, TextWatcher,
        AdapterView.OnItemSelectedListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CollectYouFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CollectYouFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CollectYouFragment newInstance(String param1, String param2) {
        CollectYouFragment fragment = new CollectYouFragment();
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

    //Default String
    String defaultText;


    View view;

    //Price Filter views
    Spinner spinner;
    CheckBox showBudjetCheckBox;
    CheckBox anchorCheckBox;
    EditText setPriceEditText;
    SeekBar seekBar;

    //Processor Views
    TextView processorCompany;
    TextView processorModel;
    TextView processorPrice;
    //Videocard views
    TextView videocardCompany;
    TextView videocardModel;
    EditText videocardCount;
    TextView videocardPrice;
    //Motherboard views
    TextView motherboardCompany;
    TextView motherboardModel;
    TextView motherboardPrice;
    //RAM
    TextView ramCompany;
    TextView ramModel;
    EditText ramCount;
    TextView ramPrice;
    //SSD
    TextView ssdCompany;
    TextView ssdModel;
    EditText ssdCount;
    TextView ssdPrice;
    //HDD
    TextView hddCompany;
    TextView hddModel;
    EditText hddCount;
    TextView hddPrice;
    //Power Supply
    TextView powerSupplyCompany;
    TextView powerSupplyModel;
    TextView powerSupplyPrice;
    //Cooler
    TextView coolerCompany;
    TextView coolerModel;
    TextView coolerPrice;
    //PC case
    TextView pcCaseCompany;
    TextView pcCaseModel;
    TextView pcCasePrice;
    ImageView pcCaseImageView;


    LinearLayout showBudjetLinearLayout;
    TextView totalPriceBudgetTextView;

    //Data Vars
    String not_selected;
    String defaultNumber0;
    String defaultNumber1;

    int priceProcessor = 0;
    int priceVideocard = 0;
    int priceMotherboard = 0;
    int priceRam = 0;
    int priceSsd = 0;
    int priceHdd = 0;
    int pricePowerSupply = 0;
    int priceCooler = 0;
    int pricePCCase = 0;
    int totalPrice = 0;


    //PC CASE IMAGE URL
    String imageURL;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_collect_you, container, false);
        initDefaultVar();
        initViews();
        setDefaultText();



        return view;
    }


    /*
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        save(outState);
    }


    private void save(Bundle bundle){
        /*bundle.putString(CONSTANT.CURRENCY,spinner.getSelectedItem().toString());
        bundle.putString(CONSTANT.BUDGET, setPriceEditText.getText().toString());
        bundle.putBoolean(CONSTANT.ANCHOR,anchorCheckBox.isChecked());
        bundle.putBoolean(CONSTANT.SHOW_BUDGET,showBudjetCheckBox.isChecked());
        bundle.putString(CONSTANT.PROCESSOR_COMPANY,processorCompany.getText().toString());
        bundle.putString(CONSTANT.PROCESSOR_MODEL,processorModel.getText().toString());
        setBundleText(bundle,CONSTANT.PROCESSOR_COMPANY,processorCompany);
    }

    private void restore(Bundle bundle){
        if(bundle!=null){
            processorCompany.setText("LOL");
        }
    }

    private String getBundleText(String text){
        if(text!=null) return "Красиво";
        return not_selected;
    }

    private void setBundleText(Bundle bundle,String type, TextView textView){
        if(textView!=null && !textView.getText().toString().equals(not_selected)){
            bundle.putString(type,processorCompany.getText().toString());
        }
    }*/

    private void initDefaultVar(){
        not_selected = getActivity().getResources().getString(R.string.not_selected);
        defaultNumber0 = "0";
        defaultNumber1 = "1";
    }

    private void initViews() {
        //VIEWS

        //Price filter
        showBudjetCheckBox = view.findViewById(R.id.collect_you_show_budget_checkbox);
        totalPriceBudgetTextView = view.findViewById(R.id.collect_you_budget_totel_price_tv);
        spinner = view.findViewById(R.id.fragment_collect_you_currency_spinner);
        showBudjetLinearLayout = view.findViewById(R.id.collect_you_budget_linearlayout);
        setPriceEditText = view.findViewById(R.id.collect_you_pricetake_et);
        anchorCheckBox = view.findViewById(R.id.collect_you_anchor_checkbox);
        seekBar = view.findViewById(R.id.collect_you_seekbar);
        //Processor views
        processorCompany = view.findViewById(R.id.fragment_collect_you_processor_company_tv);
        processorModel = view.findViewById(R.id.fragment_collect_you_processor_model_tv);
        processorPrice = view.findViewById(R.id.fragment_collect_you_processor_price_tv);
        //VideocardViews
        videocardCompany = view.findViewById(R.id.fragment_collect_you_videocard_company_tv);
        videocardModel = view.findViewById(R.id.fragment_collect_you_videocard_model_tv);
        videocardCount = view.findViewById(R.id.fragment_collect_you_videocard_count_et);
        videocardPrice = view.findViewById(R.id.fragment_collect_you_videocard_price_tv);
        //Motherboard
        motherboardCompany = view.findViewById(R.id.fragment_collect_you_motherboard_company_tv);
        motherboardModel = view.findViewById(R.id.fragment_collect_you_motherboard_model_tv);
        motherboardPrice = view.findViewById(R.id.fragment_collect_you_motherboard_price_tv);
        //RAM
        ramCompany = view.findViewById(R.id.fragment_collect_you_ram_company_tv);
        ramModel = view.findViewById(R.id.fragment_collect_you_ram_model_tv);
        ramCount = view.findViewById(R.id.fragment_collect_you_ram_count_et);
        ramPrice = view.findViewById(R.id.fragment_collect_you_ram_price_tv);
        //SSD
        ssdCompany = view.findViewById(R.id.fragment_collect_you_ssd_company_tv);
        ssdModel = view.findViewById(R.id.fragment_collect_you_ssd_model_tv);
        ssdCount = view.findViewById(R.id.fragment_collect_you_ssd_count_et);
        ssdPrice = view.findViewById(R.id.fragment_collect_you_ssd_price_tv);
        //HDD
        hddCompany = view.findViewById(R.id.fragment_collect_you_hdd_company_tv);
        hddModel = view.findViewById(R.id.fragment_collect_you_hdd_model_tv);
        hddCount = view.findViewById(R.id.fragment_collect_you_hdd_count_et);
        hddPrice = view.findViewById(R.id.fragment_collect_you_hdd_price_tv);
        //Power Supply
        powerSupplyCompany = view.findViewById(R.id.fragment_collect_you_powersupply_company_tv);
        powerSupplyModel = view.findViewById(R.id.fragment_collect_you_powersupply_model_tv);
        powerSupplyPrice = view.findViewById(R.id.fragment_collect_you_powersupply_price_tv);
        //Cooler
        coolerCompany = view.findViewById(R.id.fragment_collect_you_cooler_company_tv);
        coolerModel = view.findViewById(R.id.fragment_collect_you_cooler_model_tv);
        coolerPrice = view.findViewById(R.id.fragment_collect_you_cooler_price_tv);
        //PC case views
        pcCaseCompany = view.findViewById(R.id.fragment_collect_you_pccase_company_tv);
        pcCaseModel = view.findViewById(R.id.fragment_collect_you_pccase_model_tv);
        pcCasePrice  = view.findViewById(R.id.fragment_collect_you_pccase_price_tv);
        pcCaseImageView = view.findViewById(R.id.fragment_collect_you_pccase_image);




        //LISTENERS

        //Price filter listeners
        anchorCheckBox.setOnClickListener(this);
        showBudjetCheckBox.setOnClickListener(this);
        seekBar.setOnSeekBarChangeListener(this);
        setPriceEditText.addTextChangedListener(this);
        spinner.setOnItemSelectedListener(this);


        //Processor views listeners
        processorCompany.setOnClickListener(this);
        processorModel.setOnClickListener(this::onClick);
        //Videocard views listeners
        videocardCompany.setOnClickListener(this::onClick);
        videocardModel.setOnClickListener(this::onClick);
        videocardCount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                setVideocardCount();
            }
        });
        //Motherboard views listeners
        motherboardCompany.setOnClickListener(this::onClick);
        motherboardModel.setOnClickListener(this::onClick);
        //RAM views listeners
        ramCompany.setOnClickListener(this::onClick);
        ramModel.setOnClickListener(this::onClick);
        ramCount.addTextChangedListener(this);
        //SSD views listeners
        ssdCompany.setOnClickListener(this::onClick);
        ssdModel.setOnClickListener(this::onClick);
        ssdCount.addTextChangedListener(this);
        //HDD
        hddCompany.setOnClickListener(this::onClick);
        hddModel.setOnClickListener(this::onClick);
        hddCount.addTextChangedListener(this);
        //Power Supply
        powerSupplyCompany.setOnClickListener(this::onClick);
        powerSupplyModel.setOnClickListener(this::onClick);
        //Cooler
        coolerCompany.setOnClickListener(this::onClick);
        coolerModel.setOnClickListener(this::onClick);
        //PC case views
        pcCaseCompany.setOnClickListener(this::onClick);
        pcCaseModel.setOnClickListener(this::onClick);
        pcCaseImageView.setOnClickListener(this);

        //Options

    }


    private void setVideocardCount(){
        if(videocardCompany!=null && videocardModel!=null && videocardCount!=null && !videocardModel.getText().toString().equals(not_selected) &&
        !videocardCount.getText().toString().equals("")) {
            int count = integerConverter(videocardCount.getText().toString());
            if(count<1 || count>2) {
                Toast.makeText(getContext(), getActivity().getResources().getString(R.string.you_can_take_1_or_2), Toast.LENGTH_SHORT).show();
                count = 1;
                videocardCount.setText(defaultNumber1);
            }
            else priceVideocard*=count;
            updatePrice();
        }
    }



    //Default text for all textview
    private void setDefaultText(){
        setDefaultTextProcessor();
        setDefaultTextVidecard();
        setDefaultTextMotherboard();
        setDefaultTextRAM();
        setDefaultTextSSD();
        setDefaultTextHDD();
        setDefaultTextPowerSupply();
        setDefaultTextCooler();
        setDefaultTextPCCase();
    }

    private void defaultTextTextView(TextView company,TextView model, TextView price){
        company.setText(not_selected);
        model.setText(not_selected);
        price.setText(defaultNumber0);

        setDefaultTextViewBackground(company);
        setDefaultTextViewBackground(model);
        setDefaultTextViewBackground(price);
    }
    private void defaultTextEditText(EditText count){
        count.setText(defaultNumber0);
        setDefaultEditTextBackground(count);
    }


    private void setDefaultTextProcessor(){
        defaultTextTextView(processorCompany,processorModel,processorPrice);
        priceProcessor = 0;
        updatePrice();
    }

    private void setDefaultTextVidecard(){
        defaultTextTextView(videocardCompany,videocardModel,videocardPrice);
        defaultTextEditText(videocardCount);
        priceVideocard = 0;
        updatePrice();
    }

    private void setDefaultTextMotherboard(){
        defaultTextTextView(motherboardCompany,motherboardModel,motherboardPrice);
        priceMotherboard = 0;
        updatePrice();
    }

    private void setDefaultTextRAM(){
        defaultTextTextView(ramCompany,ramModel,ramPrice);
        defaultTextEditText(ramCount);
        priceRam = 0;
        updatePrice();
    }


    private void setDefaultTextSSD(){
        defaultTextTextView(ssdCompany,ssdModel,ssdPrice);
        defaultTextEditText(ssdCount);
        priceSsd = 0;
        updatePrice();
    }

    private void setDefaultTextHDD(){
        defaultTextTextView(hddCompany,hddModel,hddPrice);
        defaultTextEditText(hddCount);
        priceHdd = 0;
        updatePrice();
    }

    private void setDefaultTextPowerSupply(){
        defaultTextTextView(powerSupplyCompany,powerSupplyModel,powerSupplyPrice);
        pricePowerSupply = 0;
        updatePrice();
    }

    private void setDefaultTextCooler(){
        defaultTextTextView(coolerCompany,coolerModel,coolerPrice);
        priceCooler = 0;
        updatePrice();
    }
    private void setDefaultTextPCCase(){
        defaultTextTextView(pcCaseCompany,pcCaseModel,pcCasePrice);
        pricePCCase = 0;
        pcCaseImageView.setImageDrawable(getResources().getDrawable(R.drawable.no_photo));
        updatePrice();
    }







    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK){
            String type, mode;
            String companyValue, modelValue,priceValue;

            type = data.getStringExtra(CONSTANT.TYPE);
            mode = data.getStringExtra(CONSTANT.MODE);

            companyValue = data.getStringExtra(CONSTANT.COMPANY_VALUE);
            modelValue = data.getStringExtra(CONSTANT.MODEL_VALUE);
            priceValue = data.getStringExtra(CONSTANT.PRICE_VALUE);

            imageURL = data.getStringExtra(CONSTANT.IMAGE_URL);

            setData(type,mode,companyValue,modelValue,priceValue);

        }
    }


    //getResult

    private void setData(String type,String mode,String companyValue,String modelValue,String priceValue){
        if(type!=null && mode!=null) {
            switch (type) {
                case CONSTANT.PROCESSOR:
                    Mode(CONSTANT.PROCESSOR,mode,companyValue,modelValue,priceValue,processorCompany,processorModel,processorPrice);
                    return;
                case CONSTANT.VIDEOCARD:
                    Mode(CONSTANT.VIDEOCARD, mode,companyValue,modelValue,priceValue,videocardCompany,videocardModel,videocardPrice);
                    return;
                case CONSTANT.MOTHERBOARD:
                    Mode(CONSTANT.MOTHERBOARD, mode,companyValue,modelValue,priceValue,motherboardCompany,motherboardModel,motherboardPrice);
                    return;
                case CONSTANT.RAM:
                    Mode(CONSTANT.RAM, mode,companyValue,modelValue,priceValue,ramCompany,ramModel,ramPrice);
                    return;
                case CONSTANT.SSD:
                    Mode(CONSTANT.SSD, mode,companyValue,modelValue,priceValue,ssdCompany,ssdModel,ssdPrice);
                    return;
                case CONSTANT.HDD:
                    Mode(CONSTANT.HDD, mode,companyValue,modelValue,priceValue,hddCompany,hddModel,hddPrice);
                    return;
                case CONSTANT.POWER_SUPPLY:
                    Mode(CONSTANT.POWER_SUPPLY, mode,companyValue,modelValue,priceValue,powerSupplyCompany,powerSupplyModel,powerSupplyPrice);
                    return;
                case CONSTANT.COOLER:
                    Mode(CONSTANT.COOLER, mode,companyValue,modelValue,priceValue,coolerCompany,coolerModel,coolerPrice);
                    return;
                case CONSTANT.PC_CASE:
                    Mode(CONSTANT.PC_CASE, mode,companyValue,modelValue,priceValue,pcCaseCompany,pcCaseModel,pcCasePrice);
                    return;
            }
        }
        else Toast.makeText(getContext(),"Type or Mode NULL", Toast.LENGTH_SHORT).show();
    }






    //For all




    private void сompanyButton(String type){

        switch (type){
            case CONSTANT.PROCESSOR:
                setDefaultTextProcessor();
                break;
            case CONSTANT.VIDEOCARD:
                setDefaultTextVidecard();
                break;
            case CONSTANT.MOTHERBOARD:
                setDefaultTextMotherboard();
                break;
            case CONSTANT.RAM:
                setDefaultTextRAM();
                break;
            case CONSTANT.SSD:
                setDefaultTextSSD();
                break;
            case CONSTANT.HDD:
                setDefaultTextHDD();
                break;
            case CONSTANT.POWER_SUPPLY:
                setDefaultTextPowerSupply();
                break;
            case CONSTANT.COOLER:
                setDefaultTextCooler();
                break;
            case CONSTANT.PC_CASE:
                setDefaultTextPCCase();
                break;
        }

        Intent companyIntent = new Intent(getActivity(),SelectListActivity.class);
        companyIntent.putExtra(CONSTANT.TYPE, type);
        companyIntent.putExtra(CONSTANT.MODE,CONSTANT.COMPANY);
        startActivityForResult(companyIntent,1);

    }

    private void modelButton(String type){
        String companyValue = "";
        switch (type){
            case CONSTANT.PROCESSOR:
                companyValue = processorCompany.getText().toString();
                break;
            case CONSTANT.VIDEOCARD:
                companyValue = videocardCompany.getText().toString();
                break;
            case CONSTANT.MOTHERBOARD:
                companyValue = motherboardCompany.getText().toString();
                break;
            case CONSTANT.RAM:
                companyValue = ramCompany.getText().toString();
                break;
            case CONSTANT.SSD:
                companyValue = ssdCompany.getText().toString();
                break;
            case CONSTANT.HDD:
                companyValue = hddCompany.getText().toString();
                break;
            case CONSTANT.POWER_SUPPLY:
                companyValue = powerSupplyCompany.getText().toString();
                break;
            case CONSTANT.COOLER:
                companyValue = coolerCompany.getText().toString();
                break;
            case CONSTANT.PC_CASE:
                companyValue = pcCaseCompany.getText().toString();
                break;

        }

        Intent modelIntent = new Intent(getActivity(),SelectListActivity.class);
        if(companyValue.equals(not_selected)){
            modelIntent.putExtra(CONSTANT.TYPE, type);
            modelIntent.putExtra(CONSTANT.MODE,CONSTANT.MODEL_ALL);
        }
        else{
            modelIntent.putExtra(CONSTANT.TYPE, type);
            modelIntent.putExtra(CONSTANT.MODE,CONSTANT.MODEL);
            modelIntent.putExtra(CONSTANT.COMPANY_VALUE, companyValue);
        }
        startActivityForResult(modelIntent ,1);
    }

    private void Mode(String type,String mode, String companyValue, String modelValue, String priceValue,TextView companyTV,TextView modelTV, TextView priceTV) {
        switch (mode) {
            case CONSTANT.COMPANY:
                setTextCompany(companyValue,companyTV);
                return;
            case CONSTANT.MODEL:
                setTextModel(type,modelValue,priceValue,modelTV,priceTV);
                return;
            case CONSTANT.MODEL_ALL:
                setTextModelAll(type,companyValue,modelValue,priceValue,companyTV,modelTV,priceTV);
                return;
        }
    }

    private void setTextCompany(String companyValue,TextView companyTV){
        if(companyValue!=null && companyTV!=null) {
            companyTV.setText(companyValue);

            setSelectedModeTextViewBackground(companyTV);
        }
        else Toast.makeText(getContext(),"Company value NULL", Toast.LENGTH_SHORT).show();
    }

    private void setTextModel(String type,String modelValue,String priceValue,TextView modelTV,TextView priceTV) {
        if(modelValue!=null && priceValue!=null) {
            modelTV.setText(modelValue);
            priceTV.setText(priceValue);

            setSelectedModeTextViewBackground(modelTV);
            setSelectedModeTextViewBackground(priceTV);

            if(type.equals(CONSTANT.PC_CASE)) {
                Glide.with(getContext())
                        .load(imageURL)
                        .error(R.drawable.no_photo)
                        .into(pcCaseImageView);
            }
            setPrice(type);
        }
        else Toast.makeText(getContext(),"Model Or Price value NULL", Toast.LENGTH_SHORT).show();
    }

    private void setTextModelAll(String type,String companyValue,String modelValue,String priceValue,TextView companyTV,TextView modelTV,TextView priceTV){
        if(companyValue!=null && modelValue!=null && priceValue!=null) {
            companyTV.setText(companyValue);
            modelTV.setText(modelValue);
            priceTV.setText(priceValue);

            setSelectedModeTextViewBackground(companyTV);
            setSelectedModeTextViewBackground(modelTV);
            setSelectedModeTextViewBackground(priceTV);

            if(type.equals(CONSTANT.PC_CASE) && imageURL!=null) {
                Glide.with(getContext())
                        .load(imageURL)
                        .error(R.drawable.no_photo)
                        .into(pcCaseImageView);
            }

            setPrice(type);
        }
        else Toast.makeText(getContext(),"Company, Model Or Price value NULL", Toast.LENGTH_SHORT).show();
    }

    private void setPrice(String type){
        if(type.equals(CONSTANT.PROCESSOR)){
            priceProcessor = integerConverter(processorPrice.getText().toString());
        }
        else if(type.equals(CONSTANT.VIDEOCARD)) {
            videocardCount.setText(defaultNumber1);
            setSelectedModeEditTextBackground(videocardCount);
            priceVideocard = integerConverter(videocardPrice.getText().toString());
        }
        else if(type.equals(CONSTANT.MOTHERBOARD)){
            priceMotherboard = integerConverter(motherboardPrice.getText().toString());
        }
        else if(type.equals(CONSTANT.RAM)){
            ramCount.setText(defaultNumber1);
            setSelectedModeEditTextBackground(ramCount);
            priceRam = integerConverter(ramPrice.getText().toString());
        }
        else if(type.equals(CONSTANT.SSD)){
            ssdCount.setText(defaultNumber1);
            setSelectedModeEditTextBackground(ssdCount);
            priceSsd = integerConverter(ssdPrice.getText().toString());
        }
        else if(type.equals(CONSTANT.HDD)){
            hddCount.setText(defaultNumber1);
            setSelectedModeEditTextBackground(hddCount);
            priceHdd = integerConverter(hddPrice.getText().toString());
        }
        else if(type.equals(CONSTANT.POWER_SUPPLY)){
            pricePowerSupply = integerConverter(powerSupplyPrice.getText().toString());
        }
        else if(type.equals(CONSTANT.COOLER)){
            priceCooler = integerConverter(coolerPrice.getText().toString());
        }
        else if(type.equals(CONSTANT.PC_CASE)){
            pricePCCase = integerConverter(pcCasePrice.getText().toString());
        }
        updatePrice();
    }




















    @Override
    public void onClick(View v) {
        switch (v.getId()){

            //Price filter
            case R.id.collect_you_show_budget_checkbox:
                showBudjet();
                break;
            case R.id.collect_you_anchor_checkbox:
                anchorPrice();
                break;

            //Processor
            case R.id.fragment_collect_you_processor_company_tv:
                сompanyButton(CONSTANT.PROCESSOR);
                break;
            case R.id.fragment_collect_you_processor_model_tv:
                modelButton(CONSTANT.PROCESSOR);
                break;

            //Videocard
            case R.id.fragment_collect_you_videocard_company_tv:
                сompanyButton(CONSTANT.VIDEOCARD);
                break;
            case R.id.fragment_collect_you_videocard_model_tv:
                modelButton(CONSTANT.VIDEOCARD);
                break;

            //Motherboard
            case R.id.fragment_collect_you_motherboard_company_tv:
                сompanyButton(CONSTANT.MOTHERBOARD);
                break;
            case R.id.fragment_collect_you_motherboard_model_tv:
                modelButton(CONSTANT.MOTHERBOARD);
                break;

            //RAM
            case R.id.fragment_collect_you_ram_company_tv:
                сompanyButton(CONSTANT.RAM);
                break;
            case R.id.fragment_collect_you_ram_model_tv:
                modelButton(CONSTANT.RAM);
                break;

            //SSD
            case R.id.fragment_collect_you_ssd_company_tv:
                сompanyButton(CONSTANT.SSD);
                break;
            case R.id.fragment_collect_you_ssd_model_tv:
                modelButton(CONSTANT.SSD);
                break;

            //HDD
            case R.id.fragment_collect_you_hdd_company_tv:
                сompanyButton(CONSTANT.HDD);
                break;
            case R.id.fragment_collect_you_hdd_model_tv:
                modelButton(CONSTANT.HDD);
                break;

            //Power Supply
            case R.id.fragment_collect_you_powersupply_company_tv:
                сompanyButton(CONSTANT.POWER_SUPPLY);
                break;
            case R.id.fragment_collect_you_powersupply_model_tv:
                modelButton(CONSTANT.POWER_SUPPLY);
                break;

            //Power Supply
            case R.id.fragment_collect_you_cooler_company_tv:
                сompanyButton(CONSTANT.COOLER);
                break;
            case R.id.fragment_collect_you_cooler_model_tv:
                modelButton(CONSTANT.COOLER);
                break;

            //Power Supply
            case R.id.fragment_collect_you_pccase_company_tv:
                сompanyButton(CONSTANT.PC_CASE);
                break;
            case R.id.fragment_collect_you_pccase_model_tv:
                modelButton(CONSTANT.PC_CASE);
                break;

            //PC case
            case R.id.fragment_collect_you_pccase_image:
                showPCcases();
                break;
        }
    }






    private void anchorPrice() {
        if(anchorCheckBox.isChecked()){
            setPriceEditText.setEnabled(false);
            seekBar.setEnabled(false);
        }
        else {
            setPriceEditText.setEnabled(true);
            seekBar.setEnabled(true);
        }
        updatePrice();
    }

    private void showBudjet() {
        if(showBudjetCheckBox.isChecked()) showBudjetLinearLayout.setVisibility(View.VISIBLE);
        else showBudjetLinearLayout.setVisibility(View.INVISIBLE);
    }

    private void showPCcases() {
        Intent intent = new Intent(getActivity(),ImageGridActivity.class);
        startActivityForResult(intent,1);
    }

    private int integerConverter(String text){
        if(text!=null && text.matches("[0-9]+")){
            return Integer.valueOf(text);
        }
        return 0;
    }


    private void updatePrice(){
        BeautyPrice beautyPrice = new BeautyPrice();
        String currency = spinner.getSelectedItem().toString();
        int limitBudgetPrice =  integerConverter(setPriceEditText.getText().toString());
        String USD = getActivity().getResources().getString(R.string.usd);
        String UZS = getActivity().getResources().getString(R.string.uzs);
        String sign = "";
        int TOTAL;


        totalPrice = priceProcessor + priceVideocard + priceMotherboard + priceRam + priceSsd + priceHdd + pricePowerSupply + priceCooler + pricePCCase;


        if(anchorCheckBox.isChecked()){
            TOTAL = limitBudgetPrice - totalPrice;
            if(TOTAL<0){
                totalPriceBudgetTextView.setTextColor(getActivity().getResources().getColor(R.color.red));
                sign = "-";
            }
            else{
                totalPriceBudgetTextView.setTextColor(getActivity().getResources().getColor(R.color.green));
                sign = "";
            }
        }
        else{
            TOTAL = totalPrice;
            totalPriceBudgetTextView.setTextColor(getActivity().getResources().getColor(R.color.green));
            sign = "";
        }

            if (currency.equals(USD))
                totalPriceBudgetTextView.setText(sign + beautyPrice.beautyPrice(String.valueOf(Math.abs(TOTAL))) + " " + USD);
            else if (currency.equals(UZS))
                totalPriceBudgetTextView.setText(sign + beautyPrice.beautyPrice(String.valueOf(Math.abs(TOTAL * 10300))) + " " + UZS);

    }




    //Spinner Click itemselected
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        updatePrice();
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        updatePrice();
    }




    //Background change TextView
    private void setSelectedModeTextViewBackground(TextView textView){
        String text = textView.getText().toString();

        if(textView!=null && !text.equals(not_selected) ){
            textView.setBackground(getActivity().getResources().getDrawable(R.drawable.rectangle_background_red));
            textView.setTextColor(getActivity().getResources().getColor(R.color.white));
        }
        else textView.setBackground(getActivity().getResources().getDrawable(R.drawable.regtangle_background_border));
    }
    private void setDefaultTextViewBackground(TextView textView){
        if(textView!=null) {
            try {
                textView.setBackground(getActivity().getResources().getDrawable(R.drawable.regtangle_background_border));
                textView.setTextColor(getActivity().getResources().getColor(R.color.black));
            }
            catch (NullPointerException ex){

            }
        }
    }

    //Background change EditText
    private void setSelectedModeEditTextBackground(EditText editText){
        String text = editText.getText().toString();

        if(editText!=null && !text.equals(defaultNumber0) ){
            editText.setBackground(getActivity().getResources().getDrawable(R.drawable.rectangle_background_red));
            editText.setTextColor(getActivity().getResources().getColor(R.color.white));
        }
        else editText.setBackground(getActivity().getResources().getDrawable(R.drawable.regtangle_background_border));
    }
    private void setDefaultEditTextBackground(EditText editText){
        if(editText!=null) {
            try {
                editText.setBackground(getActivity().getResources().getDrawable(R.drawable.regtangle_background_border));
                editText.setTextColor(getActivity().getResources().getColor(R.color.black));
            }
            catch (NullPointerException ex){

            }
        }
    }





    //Synchronize seekbar and edittext for set price
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        try{
            setPriceEditText.setText(String.valueOf(seekBar.getProgress()));
            String text = setPriceEditText.getText().toString();
            int position = 0;
            if(text!=null && !text.equals("")) {
                position = text.length();
            }

            Log.v("POSITION",String.valueOf(position));
            setPriceEditText.setSelection(position);
            updatePrice();
        }
        catch (IndexOutOfBoundsException ex){

        }
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        try {
            String current = setPriceEditText.getText().toString();
            int position = 0;
            if (current != null && !current.equals("")) {
                seekBar.setProgress(Integer.valueOf(current));
                position = current.length();
            }
            setPriceEditText.setSelection(position);
            updatePrice();
        }
        catch (IndexOutOfBoundsException ex){

        }
    }






    //This I dont use
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }
    @Override
    public void afterTextChanged(Editable s) {

    }
}