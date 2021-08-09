package com.example.neyronpc.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.neyronpc.CONSTANT;
import com.example.neyronpc.ImageFullActivity;
import com.example.neyronpc.R;
import com.example.neyronpc.data.PCCase;

import java.util.ArrayList;
import java.util.List;

public class ImageListAdapter extends BaseAdapter {

    LayoutInflater inflater;
    Context context;
    String imageURL;
    Activity activity;


    List<PCCase> pcCaseList;

    public ImageListAdapter(Activity activity,Context context) {
        initData();
        this.activity = activity;
        this.context = context;

        inflater = LayoutInflater.from(context);
    }

    private void initData(){
        /*imagesURL = new ArrayList<>();
        imagesURL.add("https://3dnews.ru/assets/external/illustrations/2020/01/15/1001454/aero1.jpg");
        imagesURL.add("https://cdn.pixabay.com/photo/2014/09/29/01/17/selfie-465563__340.jpg");
        imagesURL.add("https://cdn.pixabay.com/photo/2016/12/02/03/08/people-talking-1876726__340.jpg");
        imagesURL.add("https://i.ytimg.com/vi/8ATWBmiDmwc/maxresdefault.jpg");
        imagesURL.add("https://content.thefroot.com/media/market_products/alstyle/30226_1.jpg");
        imagesURL.add("https://www.littlebigpc.co.uk/media/catalog/product/cache/2/image/9df78eab33525d08d6e5fb8d27136e95/s/k/sk-18048_1.jpg");
        */

        //TODO need delete
        /*
        imagesURL.add("https://img-fdc03.erogazouman.net/img1/articles/201705/0242/04.jpg");
        imagesURL.add("https://ftopx.com/images/201311/ftop.ru_78121.jpg");
        imagesURL.add("https://thumb-p1.xhcdn.com/a/M4UX30mhcCqnIHWtYkm4eQ/000/199/819/881_1000.jpg");
        imagesURL.add("https://img-7.poringa.net/poringa/img/2/A/A/3/5/0/Fag08/F48.jpg");
        imagesURL.add("https://caps1cdn.adultempire.com/r/8142/1920/1898142_04490_1920c.jpg");
        imagesURL.add("https://64.media.tumblr.com/cff245370bc41933f477446eb00066a9/tumblr_mezd1gn6FQ1rmiy94o1_1280.jpg");
        imagesURL.add("https://caps2cdn.adultempire.com/r/8142/1920/1898142_04610_1920c.jpg");
        imagesURL.add("https://img04.rl0.ru/98f0a6bed7e84c252a3285feaf4e0413/c1700x1222/fap.to/images/full/47/733/733558053.jpg");
        imagesURL.add("https://i.imgur.com/vEYwxsj.jpg");
        imagesURL.add("http://dm.damcdn.net/pics/wp-content/uploads/2016/06/virgin-pussy-cum-inside.jpg");
        imagesURL.add("http://img00.pornoslon.me/8377620.jpg");
        imagesURL.add("https://siskins.net/uploads/posts/2020-05/1590004965_2-p-pornukha-konchayushchie-telki-trakh-6.jpg");
        imagesURL.add("https://damochki.info/uploads/posts/2019-11/1574380629_bolshie-chleny-konchayut-vnutr-porno-trah-82.jpg");
        imagesURL.add("https://soski.info/uploads/posts/2019-11/1574728438_mnogo-spermy-v-pizde-jerotika-tushy-19.jpg");
        imagesURL.add("https://i0.wp.com/tiny4kfan.com/wp-content/uploads/2015/03/tiny4k-alexa-nova-in-will-it-fit.jpg?ssl=1");
        imagesURL.add("http://cdn.pichunter.com/338/6/3386130/3386130_1_o.jpg");
        imagesURL.add("https://cdn5-images.motherlessmedia.com/images/2C87945.jpg?fs=opencloud");
        imagesURL.add("https://boombo.pro/uploads/posts/2019-06/1561505346_ftop_ru_73475.jpg");
        imagesURL.add("http://boobsik.net/uploads/posts/2019-08/1565804489_konchajut-vnutr-krupnym-planom-naughty-america-trah-37.jpg");
        imagesURL.add("https://soski.info/uploads/posts/2019-11/1574728296_porno-sperma-v-pise-jerotika-67.jpg");
        imagesURL.add("https://cdni.sleazyneasy.com/contents/videos_screenshots/987000/987217/preview.jpg");
        imagesURL.add("https://ist2-2.filesor.com/pimpandhost.com/1/_/_/_/1/1/Q/A/o/1QAoy/agness_miller_073.jpg");
        imagesURL.add("http://img01.pornoslon.me/10397891.jpg");
        imagesURL.add("https://www.pussy-pics.net/galleries/2472/images/16.jpg");
        imagesURL.add("http://www.tiny-asians.com/wp-content/uploads/2016/05/passion-hd-morgan-lee-magic-wand-29.jpg");
        imagesURL.add("https://cdn5-images.motherlessmedia.com/images/F76C1F5.jpg");
        */

    }

    public void setPcCaseList(List<PCCase> pcCaseList) {
        this.pcCaseList = pcCaseList;
    }

    @Override
    public int getCount() {
        if(pcCaseList == null) return 0;
        return pcCaseList.size();
    }

    @Override
    public Object getItem(int position) {
        return pcCaseList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;


        View view = inflater.inflate(R.layout.image_list,parent,false);

        imageView = view.findViewById(R.id.image_list_image);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        ViewGroup.LayoutParams params = imageView.getLayoutParams();
        params.width = displayMetrics.widthPixels/3;
        params.height = displayMetrics.widthPixels/3;
        imageView.setLayoutParams(params);
        Glide.with(context)
                .load(pcCaseList.get(position).getImageURL())
                .centerCrop()
                .into(imageView);
        imageURL = pcCaseList.get(position).getImageURL();



        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity,ImageFullActivity.class);
                intent.putExtra(CONSTANT.IMAGE_URL, pcCaseList.get(position).getImageURL());
                intent.putExtra(CONSTANT.COMPANY_VALUE,pcCaseList.get(position).getCompany());
                intent.putExtra(CONSTANT.MODEL_VALUE,pcCaseList.get(position).getModel());
                intent.putExtra(CONSTANT.PRICE_VALUE,pcCaseList.get(position).getPrice());
                activity.startActivityForResult(intent,1);
            }
        });

        return view;
    }


}
