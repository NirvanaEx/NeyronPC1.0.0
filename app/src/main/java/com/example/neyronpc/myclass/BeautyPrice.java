package com.example.neyronpc.myclass;

public class BeautyPrice {

    public BeautyPrice() {
    }

     public String beautyPrice(String price){
        String result = "";
        int j = 0;
        for(int i = price.length()-1; i>=0; i--){

            result+=price.charAt(i);
            j++;

            if(j%3==0 && i!=0)
                result+=".";

        }
        return reverse(result);
    }

    private String reverse(String text){
        String result = "";
        for(int i=text.length()-1; i>=0; i--){
            result+=text.charAt(i);
        }
        return result;
    }

}
